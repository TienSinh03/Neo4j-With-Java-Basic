package Test;

import org.neo4j.driver.Result;
import org.neo4j.driver.Session;
import org.neo4j.driver.Transaction;
import org.neo4j.driver.Value;
import org.neo4j.driver.Values;
import org.neo4j.driver.types.Node;

import java.util.List;

import org.neo4j.driver.Record;

import Database.Connect;
import entity.Course;
import entity.Student;
import handler.Handler_Main;

public class Main {
	
	public static void main(String[] args) {
		//Trinh lam viev
		Session session = Connect.connect();
		
		//Chay trinh lam viec lien kết tới Database Neo4j
		Transaction transaction = session.beginTransaction();
		
		//Tim kiem sinh vien khi biet ma sinh vien
		String id = "11";
//		String query = "MATCH (s:Student {studentID: $idString}) RETURN s;";
//		
//		//cach thuc thi giong ben jdbc method PreparedStatement 
//		/**
//		 *  Values.parameters("idString",id):Sử dụng tham số id để truyền vào idString
//		 */
//		Result result = transaction.run(query, Values.parameters("idString",id));
//		
//		//Chứa bản ghi từ kết quả
//		Record record= result.single();
//		//Node ghi đc, cụ thể trong bài là Node Student
//		Node node = record.get("s").asNode();
//		
//		Student student = new Student(node.get("studentID").toString(), node.get("name").toString(), Float.parseFloat(node.get("gpa").toString()));
		Handler_Main handler_Main = new Handler_Main();
		
		
		System.out.println("Tim kiem sinh vien khi biet ma sinh vien");
		System.out.println(handler_Main.findStudentById(id));	
				
		//Tim danh sach khoa hoc thuoc cua mot khoa nao do khi biet ma khoa
		List<Course> listCourses = handler_Main.findListCourseByIDDept("IE");
		System.out.println("Tim danh sach khoa hoc thuoc cua mot khoa nao do khi biet ma khoa");
		listCourses.forEach(System.out::println);
		
		//Cập nhật name = “Mathematics” cho department_id = “Math” 
		System.out.println("Cap nhat name = Mathematics cho department_id = Math ");
		System.out.println(handler_Main.updateNameByID("Math", "Mathematics"));
		
	}
}
