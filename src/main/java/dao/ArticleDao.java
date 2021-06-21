package dao;

import java.util.List;

import bean.Article;

public interface ArticleDao {
    /**
     * 增加文章
     * @param article
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
     * @param article
     * @return 0 成功 -1 失败
     */
    public int update(Article article);

    /**
     * 根据ArticleId查询文章
     * @param articleid
     * @return Article
     */
    public Article query(int articleid);

    /**
     * 根据AuthorId获取所有文章
     * @param authorid
     * @return List
     */
    public List<Article> queryAllByAuthorId(int authorid);
    
    /**
     * 根据AuthorId CategoryId获取所有文章
     * @param authorid categoryid
     * @return List
     */
    public List<Article> queryAll(int authorid, int categoryid);
    
    /**
     * 根据UpdateTime获取最新的N条文章
     * @param count
     * @return List
     */
    public List<Article> queryByUpdateTime(int count);
    
    /**
     * 根据authorid、UpdateTime获取最新的N条文章
     * @param count
     * @return List
     */
    public List<Article> queryByUpdateTime(int authorid, int count);
    
    /**
     * 根据Category_Id获取相关的count条文章
     * @param category count
     * @return List
     */
    public List<Article> queryByCategory(int category, int count);
    
    /**
     * 根据Title查询所有文章
     * @param title
     * @return List
     */
    public List<Article> queryAll(String title);
    
    /**
     * 获取所有文章
     * @param start count
     * @return List
     */
    public List<Article> queryAllWithPage(int start, int count);
    
    /**
     * 根据authorid获取总的文章数量
     * @param authorid
     * @return int
     */
    public int queryAllCounts(int authorid);
    

    /**
     * 获取总的文章数量
     * @return int
     */
    public int queryAllCounts();
}
