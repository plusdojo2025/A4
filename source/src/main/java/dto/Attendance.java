package dto;

import java.io.Serializable;

public class Attendance implements Serializable{
	private String attendantId; //出席ID
	private String number; //学籍番号
	private String status; // 出席状況
	private String attendanceDate; //出欠日
	
	public String getAttendantId() {
		return attendantId;
	}
	public void setAttendantId(String attendantId) {
		this.attendantId = attendantId;
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
	public Attendance(String attendantId, String number, String status, String attendanceDate) {
		this.attendantId = attendantId;
		this.number = number;
		this.status = status;
		this.attendanceDate = attendanceDate;
	}
	public Attendance(String number, String attendanceDate) {
		this.number = number;
		this.attendanceDate = attendanceDate;
	}
	public Attendance() {
		this.attendantId = "";
		this.number = "";
		this.status = "";
		this.attendanceDate = "";
	}
	
}
