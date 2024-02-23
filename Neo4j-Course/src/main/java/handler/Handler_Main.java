package handler;

import java.util.ArrayList;
import java.util.List;

import org.neo4j.driver.Record;
import org.neo4j.driver.Result;
import org.neo4j.driver.Session;
import org.neo4j.driver.Transaction;
import org.neo4j.driver.Values;
import org.neo4j.driver.types.Node;

import Database.Connect;
import entity.Course;
import entity.Department;
import entity.Student;

public class Handler_Main {
	// Trinh lam viev
	Session session = Connect.connect();

	// Chay trinh lam viec lien kết tới Database Neo4j
	Transaction transaction = session.beginTransaction();
	
	/**
	 * Tim kiem sinh vien khi biet ma sinh vien
	 * @param id
	 * @return
	 */
	public Student findStudentById(String id) {
		Student student = null;
		
		String query = "MATCH (s: Student {studentID: $studentid}) RETURN s";
		
		Result result = transaction.run(query, Values.parameters("studentid", id));
		Record record = result.single();
		Node node = record.get("s").asNode();
		
		student = new Student(node.get("studentID").asString(), node.get("name").asString(), Float.parseFloat(node.get("gpa").toString()));
	
		return student;
	}
	
	/**
	 * Tìm danh sách khóa học thuộc của một khoa nào đó khi biết mã khoa
	 * @param deptID
	 * @return
	 */
	public List<Course> findListCourseByIDDept(String deptID){
		List<Course> list = new ArrayList<Course>();
		
		String query = "MATCH (c: Course)-[:BELONG_TO]->(d: Department)"
				+ "WHERE d.deptID = $idDept \n"
				+ "RETURN c, d";
		Result result = transaction.run(query, Values.parameters("idDept", deptID));
		List<Record> records = result.list();
		for (Record record : records) {
			Node node_course = record.get("c").asNode();
			Node node_dept = record.get("d").asNode();
			Department dept = new Department(node_dept.get("deptID").asString(),node_dept.get("name").asString(),node_dept.get("dean").asString(),node_dept.get("building").asString(),Integer.parseInt(node_dept.get("room").toString()));
			Course course = new Course(node_course.get("courseID").asString(), node_course.get("name").asString(), Integer.parseInt(node_course.get("hours").toString()), dept);
			list.add(course);
		}
					
		return list;
	}
	
	
}
