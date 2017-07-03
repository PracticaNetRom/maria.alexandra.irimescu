package ro.netrom.summercamp.summercamp2017.announcement;

import java.sql.Date;

public class Announcement {

	private Integer id;
	private String title;
	private String content;
	private String location;
	private String confirmationCode;
	private boolean status;
	private Date createDate;
	private Date expireDate;
	private String categoryName;

	private String ownerEmail;
	private String ownerFirstName;
	private String ownerLastName;
	private String ownerPhone;
	private String categoryDescription;

	public Announcement(){
		
	}

	


	public Announcement(Integer id, String title, String content, String location, String confirmationCode,
			boolean status, Date createDate, Date expireDate, String categoryName, String ownerEmail,
			String ownerFirstName, String ownerLastName, String ownerPhone, String categoryDescription) {
		super();
		id = id;
		this.title = title;
		this.content = content;
		this.location = location;
		this.confirmationCode = confirmationCode;
		this.status = status;
		this.createDate = createDate;
		this.expireDate = expireDate;
		this.categoryName = categoryName;
		this.ownerEmail = ownerEmail;
		this.ownerFirstName = ownerFirstName;
		this.ownerLastName = ownerLastName;
		this.ownerPhone = ownerPhone;
		this.categoryDescription = categoryDescription;
	}




	public Integer getId() {
		return id;
	}




	public void setId(Integer id) {
		this.id = id;
	}




	public String getTitle() {
		return title;
	}




	public void setTitle(String title) {
		this.title = title;
	}




	public String getContent() {
		return content;
	}




	public void setContent(String content) {
		this.content = content;
	}




	public String getLocation() {
		return location;
	}




	public void setLocation(String location) {
		this.location = location;
	}




	public String getConfirmationCode() {
		return confirmationCode;
	}




	public void setConfirmationCode(String confirmationCode) {
		this.confirmationCode = confirmationCode;
	}




	public boolean isStatus() {
		return status;
	}




	public void setStatus(boolean status) {
		this.status = status;
	}




	public Date getCreateDate() {
		return createDate;
	}




	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}




	public Date getExpireDate() {
		return expireDate;
	}




	public void setExpireDate(Date expireDate) {
		this.expireDate = expireDate;
	}




	public String getCategoryName() {
		return categoryName;
	}




	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}




	public String getOwnerEmail() {
		return ownerEmail;
	}




	public void setOwnerEmail(String ownerEmail) {
		this.ownerEmail = ownerEmail;
	}




	public String getOwnerFirstName() {
		return ownerFirstName;
	}




	public void setOwnerFirstName(String ownerFirstName) {
		this.ownerFirstName = ownerFirstName;
	}




	public String getOwnerLastName() {
		return ownerLastName;
	}




	public void setOwnerLastName(String ownerLastName) {
		this.ownerLastName = ownerLastName;
	}




	public String getOwnerPhone() {
		return ownerPhone;
	}




	public void setOwnerPhone(String ownerPhone) {
		this.ownerPhone = ownerPhone;
	}




	public String getCategoryDescription() {
		return categoryDescription;
	}




	public void setCategoryDescription(String categoryDescription) {
		this.categoryDescription = categoryDescription;
	}




	public void printAnnouncement() {
		
		System.out.println("[" + "Title: " + getTitle() + "\n" + "Content: " + getContent() + "\n" + "Location: " + getLocation()
		+ "ConfirmationCode: " + getConfirmationCode() + "CreateDate:" + getCreateDate() + "ExpireDate: "
		+ getExpireDate() + "CategoryName: " + getCategoryName()); 

	}

}
