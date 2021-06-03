package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.Article;
import bean.Category;
import utils.JDBCUtils;

public class CategoryDaoImpl implements CategoryDao{

	@Override
	public int insert(Category category) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(int categoryid) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Category category) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Category> queryAll(int authorid) {
		Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<Category> categorys = new ArrayList<Category>();
        String sql = "select * from blog_category where Author_Id = ?";

        try
        {
            con = JDBCUtils.getConnerction();
            pstm = con.prepareStatement(sql);
            pstm.setInt(1, authorid);
            rs = pstm.executeQuery();

            while(rs.next()) {
            	Category category = new Category();
            	category.setId(rs.getInt(1));
            	category.setTitle(rs.getString(2));
            	category.setAuthorId(rs.getInt(3));
            	categorys.add(category);
            }
            return categorys;
        } catch (Exception e)
        {
            System.out.println("根据AuthorId查询类别失败");
            e.printStackTrace();
        } finally
        {
        	JDBCUtils.relesae(pstm, con);
        }
		return null;
	}

}