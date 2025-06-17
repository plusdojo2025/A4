package dto;

import java.io.Serializable;

public class Sidpw implements Serializable{
	private String className; // クラス名
	private String sName; // 生徒の氏名
	private String number; //学籍番号
	private String sPw; // 生徒のパスワード
	
	public String getClassName() {
		return className;
	}
	public String getsName() {
		return sName;
	}
	public String getNumber() {
		return number;
	}
	public String getsPw() {
		return sPw;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public void setsName(String sName) {
		this.sName = sName;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public void setsPw(String sPw) {
		this.sPw = sPw;
	}
	public Sidpw(String className, String sName, String number, String sPw) {
		this.className = className;
		this.sName = sName;
		this.number = number;
		this.sPw = sPw;
	}
	
	public Sidpw(String sName, String sPw) {
		this.sName = sName;
		this.sPw = sPw;
	}
	
	public Sidpw() {
		this.className = "";
		this.sName = "";
		this.number = "";
		this.sPw = "";
	}
	
	
}