package dto;

import java.io.Serializable;

public class Sidpw implements Serializable{
	private String className; // クラス名
	private String name; // 氏名
	private String number; //学籍番号
	private String pw; // パスワード
	
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
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
	public Sidpw(String className, String name, String number, String pw) {
		this.className = className;
		this.name = name;
		this.number = number;
		this.pw = pw;
	}
	public Sidpw() {
		this.className = "";
		this.name = "";
		this.number = "";
		this.pw = "";
	}
	
	
	
}
