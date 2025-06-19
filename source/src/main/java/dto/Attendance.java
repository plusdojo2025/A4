package dto;

import java.io.Serializable;

public class Attendance implements Serializable{
	private int attendantId; //出席ID
	private int number; //学籍番号
	private String status; // 出席状況
	private String attendanceDate; //出欠日
	
	public int getAttendantId() {
		return attendantId;
	}
	public void setAttendantId(int attendantId) {
		this.attendantId = attendantId;
	}
	public int getNumber() {
		return number;
	}
	
	public void setNumber(int number) {
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
	public Attendance(int attendantId, int number, String status, String attendanceDate) {
		this.attendantId = attendantId;
		this.number = number;
		this.status = status;
		this.attendanceDate = attendanceDate;
	}
	public Attendance(int number, String attendanceDate) {
		this.number = number;
		this.attendanceDate = attendanceDate;
	}
	public Attendance() {
		this.attendantId = 0;
		this.number = 0;
		this.status = "";
		this.attendanceDate = "";
	}
	
}
