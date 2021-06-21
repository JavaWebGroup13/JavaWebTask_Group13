package dao;

import java.util.List;

import bean.Comment;

public interface CommentDao{
	/**
     * 增加评论
     * @param comment
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
     * @param comment
     * @return 0 成功 -1 失败
     */
    public int update(Comment comment);

    /**
     * 根据commentid查询评论
     * @param commentid
     * @return 0 成功 -1 失败
     */
    public Comment query(int commentid);

    /**
     * 根据ArticleId获取所有评论
     * @param articleid
     * @return 0 成功 -1 失败
     */
    public List<Comment> queryAll(int articleid);
    
    /**
     * 根据authorid获取总的评论数量
     * @param authorid
     * @return int
     */
    public int queryAllCounts(int authorid);
}