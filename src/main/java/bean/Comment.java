package bean;

public class Comment {
	private int Id;
	private String Content;
	private int UserId;
	private int ArticaleId;
	
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getContent() {
		return Content;
	}
	public void setContent(String content) {
		Content = content;
	}
	public int getUserId() {
		return UserId;
	}
	public void setUserId(int userId) {
		UserId = userId;
	}
	public int getArticaleId() {
		return ArticaleId;
	}
	public void setArticaleId(int articaleId) {
		ArticaleId = articaleId;
	}
}
