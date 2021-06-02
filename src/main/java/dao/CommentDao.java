package dao;

import java.util.List;

import bean.Comment;

public interface CommentDao{
	/**
     * 增加评论
     * @param Comment
     * @return 0 成功 -1 失败
     */
	public int insert(Comment comment);

    /**
     * 删除评论
     * @param commentid
     * @return 0 成功 -1 失败
     */
    public int delete(int commentid);

    /**
     * 更新评论
     * @param Article
     * @return 0 成功 -1 失败
     */
    public int update(Comment comment);

    /**
     * 根据commentid查询评论
     * @param authorid
     * @return 0 成功 -1 失败
     */
    public Comment query(int commentid);

    /**
     * 根据ArticleId获取所有评论
     * @param Comment
     * @return 0 成功 -1 失败
     */
    public List<Comment> queryAll(int articleid);
}