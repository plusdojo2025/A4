package dto;

import java.io.Serializable;

public class Pidpw implements Serializable{
	private String name; // 氏名
	private String number; //学籍番号
	private String pw; // パスワード
	
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
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public Pidpw(String name, String number, String pw) {
		this.name = name;
		this.number = number;
		this.pw = pw;
	}
	public Pidpw() {
		this.name = "";
		this.number = "";
		this.pw = "";
	}
	
}
