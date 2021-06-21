package bean;

/*
 * 评论
 */
public class Comment {
	private int Id;
	private String Content;
	private int UserId;
	private int ArticaleId;
	private String CreatedTime;
	
	private String NickName;
	private String Avatar;
	
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
	public String getCreatedTime() {
		return CreatedTime;
	}
	public void setCreatedTime(String createdTime) {
		CreatedTime = createdTime;
	}
	public String getNickName() {
		return NickName;
	}
	public void setNickName(String nickName) {
		NickName = nickName;
	}
	public String getAvatar() {
		return Avatar;
	}
	public void setAvatar(String avatar) {
		Avatar = avatar;
	}
}
