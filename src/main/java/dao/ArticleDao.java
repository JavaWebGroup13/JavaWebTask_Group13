package dao;

import java.util.List;

import bean.Article;

public interface ArticleDao {
    /**
     * 增加文章
     * @param Article
     * @return 0 成功 -1 失败
     */
	public int insert(Article article);

    /**
     * 删除文章
     * @param articleid
     * @return 0 成功 -1 失败
     */
    public int delete(int articleid);

    /**
     * 更新文章
     * @param Article
     * @return 0 成功 -1 失败
     */
    public int update(Article article);

    /**
     * 根据ArticleId查询文章
     * @param authorid
     * @return Article
     */
    public Article query(int articleid);

    /**
     * 根据AuthorId获取所有文章
     * @param authorid
     * @return List
     */
    public List<Article> queryAll(int authorid);
    
    /**
     * 根据AuthorId CategoryId获取所有文章
     * @param authorid categoryid
     * @return List
     */
    public List<Article> queryAll(int authorid, int categoryid);
    
    
    /**
     * 根据Title查询所有文章
     * @param Title
     * @return List
     */
    public List<Article> queryAll(String title);
    
    /**
     * 获取所有文章
     * @param Article
     * @return List
     */
    public List<Article> queryAll();
}
