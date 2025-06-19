package dto;

import java.io.Serializable;

public class Sidpw implements Serializable{
	private int className; // クラス名
	private String sName; // 生徒の氏名
	private int number; //学籍番号
	private String sPw; // 生徒のパスワード
	
	public int getClassName() {
		return className;
	}
	public String getsName() {
		return sName;
	}
	public int getNumber() {
		return number;
	}
	public String getsPw() {
		return sPw;
	}
	public void setClassName(int className) {
		this.className = className;
	}
	public void setsName(String sName) {
		this.sName = sName;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public void setsPw(String sPw) {
		this.sPw = sPw;
	}
	public Sidpw(int className, String sName, int number, String sPw) {
		this.className = className;
		this.sName = sName;
		this.number = number;
		this.sPw = sPw;
	}
	
	public Sidpw(String sName, String sPw) {
		this.sName = sName;
		this.sPw = sPw;
	}
	
	public Sidpw(String sName, int number, String sPw) {
		this.sName = sName;
		this.number = number;
		this.sPw = sPw;
	}
	public Sidpw() {
		this.className = 0;
		this.sName = "";
		this.number = 0;
		this.sPw = "";
	}
	
	
}