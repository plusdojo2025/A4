package dto;

import java.io.Serializable;

public class Tidpw implements Serializable {
	private int className; // クラス名
	private String tName; // 先生の氏名
	private String tPw; // 先生のパスワード
	
	
	
	public int getClassName() {
		return className;
	}

	public String gettName() {
		return tName;
	}

	public String gettPw() {
		return tPw;
	}

	public void setClassName(int className) {
		this.className = className;
	}

	public void settName(String tName) {
		this.tName = tName;
	}

	public void settPw(String tPw) {
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
	
	public Tidpw(String tName) {
		this.tName = tName;
	}
	
	public Tidpw() {
		this.className = 0;
		this.tName = "";
		this.tPw = "";
	}
	
	
}
