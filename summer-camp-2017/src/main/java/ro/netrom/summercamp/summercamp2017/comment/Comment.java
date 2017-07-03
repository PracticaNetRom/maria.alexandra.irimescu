package ro.netrom.summercamp.summercamp2017.comment;

import ro.netrom.summercamp.summercamp2017.announcement.Announcement;

public class Comment {
	private String commentId;
	private String name;
	private String parent;
	private Announcement announcementId;
	private String createDate;
	// private String children;

	public Comment() {

	}

	public Comment(String commentId, String name, String parent, Announcement announcementId, String createDate) {
		super();
		this.commentId = commentId;
		this.name = name;
		this.parent = parent;
		this.announcementId = announcementId;
		this.createDate = createDate;
	}

	public String getCommentId() {
		return commentId;
	}

	public void setCommentId(String commentId) {
		this.commentId = commentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getParent() {
		return parent;
	}

	public void setParent(String parent) {
		this.parent = parent;
	}

	public Announcement getAnnouncementId() {
		return announcementId;
	}

	public void setAnnouncementId(Announcement announcementId) {
		this.announcementId = announcementId;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

}
