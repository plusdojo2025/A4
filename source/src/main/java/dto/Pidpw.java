package dto;

import java.io.Serializable;

public class Pidpw implements Serializable{
	private String pName; // 保護者の氏名
	private String number; //学籍番号
	private String pPw; // 保護者のパスワード
	
	public String getpName() {
		return pName;
	}
	public String getNumber() {
		return number;
	}
	public String getpPw() {
		return pPw;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public void setpPw(String pPw) {
		this.pPw = pPw;
	}
	public Pidpw(String pName, String number, String pPw) {
		this.pName = pName;
		this.number = number;
		this.pPw = pPw;
	}
	public Pidpw() {
		this.pName = "";
		this.number = "";
		this.pPw = "";
	}
	public Pidpw(String pName, String pPw) {
		this.pName = pName;
		this.pPw = pPw;
	}
	
}
