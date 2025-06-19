package dto;

import java.io.Serializable;

public class Tidpw implements Serializable {
	private int className; // クラス名
	private String tName; // 先生の氏名
	private String tPw; // 先生のパスワード
	
	public int getClassName() {
		return className;
	}
	public void setClassName(int className) {
		this.className = className;
	}
	public String getName() {
		return tName;
	}
	public void setName(String name) {
		this.tName = name;
	}
	public String getPw() {
		return tPw;
	}
	public void setPw(String tPw) {
		this.tPw = tPw;
	}
	
	public Tidpw(int className, String tName, String tPw) {
		this.className = className;
		this.tName = tName;
		this.tPw = tPw;
	}
	
	public Tidpw(String tName, String tPw) {
		this.tName = tName;
		this.tPw = tPw;
	}
	
	public Tidpw() {
		this.className = 0;
		this.tName = "";
		this.tPw = "";
	}
	
	
}
