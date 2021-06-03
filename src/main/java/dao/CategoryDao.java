package dao;

import java.util.List;

import bean.Category;

public interface CategoryDao{
	/**
     * 增加类别
     * @param category
     * @return 0 成功 -1 失败
     */
    public int insert(Category category);
    
    /**
     * 删除类别
     * @param categoryid
     * @return 0 成功 -1 失败
     */
    public int delete(int categoryid);
    
    /**
     * 更新类别
     * @param category
     * @return 0 成功 -1 失败
     */
    public int update(Category category);
    
    /**
     * 根据AuthorId查询类别
     * @param authorid
     * @return Category
     */
    public List<Category> queryAll(int authorid);
    
}