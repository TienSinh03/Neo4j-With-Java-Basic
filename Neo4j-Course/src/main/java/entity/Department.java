package entity;

public class Department {
	private String deptID;
	private String name;
	private String dean;
	private String building;
	private int room;
	
	public Department() {
	}
	
	public Department(String deptID, String name, String dean, String building, int room) {
		this.deptID = deptID;
		this.name = name;
		this.dean = dean;
		this.building = building;
		this.room = room;
	}

	public String getDeptID() {
		return deptID;
	}

	public void setDeptID(String deptID) {
		this.deptID = deptID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDean() {
		return dean;
	}

	public void setDean(String dean) {
		this.dean = dean;
	}

	public String getBuilding() {
		return building;
	}

	public void setBuilding(String building) {
		this.building = building;
	}

	public int getRoom() {
		return room;
	}

	public void setRoom(int room) {
		this.room = room;
	}

	@Override
	public String toString() {
		return "Department [deptID=" + deptID + ", name=" + name + ", dean=" + dean + ", building=" + building
				+ ", room=" + room + "]";
	}
}
