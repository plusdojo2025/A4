package dto;

import java.io.Serializable;

public class Attendance implements Serializable{
	private String name; // 氏名
	private String number; //学籍番号
	private String status; // 出席状況
	private String attendanceDate; //出欠日
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getAttendanceDate() {
		return attendanceDate;
	}
	public void setAttendanceDate(String attendanceDate) {
		this.attendanceDate = attendanceDate;
	}
	public Attendance(String name, String number, String status, String attendanceDate) {
		this.name = name;
		this.number = number;
		this.status = status;
		this.attendanceDate = attendanceDate;
	}
	public Attendance() {
		this.name = "";
		this.number = "";
		this.status = "";
		this.attendanceDate = "";
	}
	
}
