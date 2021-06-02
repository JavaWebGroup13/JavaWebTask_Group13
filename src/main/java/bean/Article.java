package bean;

public class Article {
	private int Id;
	private String Title;
	private String Summary;
	private String Content;
	private String Cover;
	private String CreatedTime;
	private String UpdateTime;
	private int AuthorId;
	private int CategoryId;
	
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public String getSummary() {
		return Summary;
	}
	public void setSummary(String summary) {
		Summary = summary;
	}
	public String getContent() {
		return Content;
	}
	public void setContent(String content) {
		Content = content;
	}
	public String getCover() {
		return Cover;
	}
	public void setCover(String cover) {
		Cover = cover;
	}
	public String getCreatedTime() {
		return CreatedTime;
	}
	public void setCreatedTime(String createdTime) {
		CreatedTime = createdTime;
	}
	public String getUpdateTime() {
		return UpdateTime;
	}
	public void setUpdateTime(String updateTime) {
		UpdateTime = updateTime;
	}
	public int getAuthorId() {
		return AuthorId;
	}
	public void setAuthorId(int authorId) {
		AuthorId = authorId;
	}
	public int getCategoryId() {
		return CategoryId;
	}
	public void setCategoryId(int categoryId) {
		CategoryId = categoryId;
	}
}
