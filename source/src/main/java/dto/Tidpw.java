package dto;

import java.io.Serializable;

public class Tidpw implements Serializable {
	private String className; // クラス名
	private String name; // 氏名
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
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	
	public Tidpw(String className, String name, String pw) {
		super();
		this.className = className;
		this.name = name;
		this.pw = pw;
	}
	public Tidpw() {
		this.className = "";
		this.name = "";
		this.pw = "";
	}
	
	
}
