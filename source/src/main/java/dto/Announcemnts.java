package dto;

import java.io.Serializable;

public class Announcemnts implements Serializable{
	private int announceId; //連絡ID
	private int className; //クラス名
	private String announce; //連絡事項
	private String announceDate; //登録日時
	
	public int getAnnounceId() {
		return announceId;
	}
	public void setAnnounceId(int announceId) {
		this.announceId = announceId;
	}
	public int getClassName() {
		return className;
	}
	public void setClassName(int className) {
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
	public Announcemnts(int announceId, int className, String announce, String announceDate) {
		this.announceId = announceId;
		this.className = className;
		this.announce = announce;
		this.announceDate = announceDate;
	}
	public Announcemnts() {
		this.announceId = 0;
		this.className = 0;
		this.announce = "";
		this.announceDate = "";
	}
	
}
