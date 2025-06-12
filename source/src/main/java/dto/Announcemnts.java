package dto;

import java.io.Serializable;

public class Announcemnts implements Serializable{
	private String className; //クラス名
	private String announce; //連絡事項
	private String announceDate; //登録日時
	
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public String getAnnounce() {
		return announce;
	}
	public void setAnnounce(String announce) {
		this.announce = announce;
	}
	public String getAnnounceDate() {
		return announceDate;
	}
	public void setAnnounceDate(String announceDate) {
		this.announceDate = announceDate;
	}
	public Announcemnts(String className, String announce, String announceDate) {
		this.className = className;
		this.announce = announce;
		this.announceDate = announceDate;
	}
	public Announcemnts() {
		this.className = "";
		this.announce = "";
		this.announceDate = "";
	}
	
}
