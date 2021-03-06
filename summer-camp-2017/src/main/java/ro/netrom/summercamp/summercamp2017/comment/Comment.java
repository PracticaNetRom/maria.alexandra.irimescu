package ro.netrom.summercamp.summercamp2017.comment;

import java.sql.Date;
import java.util.List;

public class Comment {
	
	private Integer id;
	private String content;
	private String name;
	private Integer parentId;
	private Integer announcementId;
	private Date createDate;
	private List<Comment> children;
	
	public Comment() {
		super();
	}

	public Comment(Integer id, String content, String name,Integer parentId, Integer announcementId, Date createDate,
			List<Comment> children) {
		super();
		this.id = id;
		this.content = content;
		this.name = name;
		this.parentId = parentId;
		this.announcementId = announcementId;
		this.createDate = createDate;
		this.children = children;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAnnouncementId() {
		return announcementId;
	}

	public void setAnnouncementId(Integer announcementId) {
		this.announcementId = announcementId;
	}
	
	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public List<Comment> getChildren() {
		return children;
	}

	public void setChildren(List<Comment> children) {
		this.children = children;
	}
	
	
	
	
}
