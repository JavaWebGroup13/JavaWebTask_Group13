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
		Connection con = null;
        PreparedStatement pstm = null;
        String sql = "insert into blog_category values (null, ?, ?)";

        try
        {
            con = JDBCUtils.getConnerction();
            pstm = con.prepareStatement(sql);
            pstm.setString(1, category.getTitle());
            pstm.setInt(2, category.getAuthorId());
            pstm.executeUpdate();
            return 0;
        } catch (Exception e)
        {
            System.out.println("插入类别失败");
            e.printStackTrace();
        } finally
        {
        	JDBCUtils.relesae(pstm, con);
        }
		return -1;
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

	@Override
	public int queryAllCounts(int authorid) {
		Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        String sql = "select count(1) from blog_category where Author_Id = ?";
        int res = 0;
        try
        {
            con = JDBCUtils.getConnerction();
            pstm = con.prepareStatement(sql);
            pstm.setInt(1, authorid);
            rs = pstm.executeQuery();

            while(rs.next()) {
            	res = rs.getInt(1);
            }
            return res;
        } catch (Exception e)
        {
            System.out.println("根据Id查询类别总数失败");
            e.printStackTrace();
        } finally
        {
        	JDBCUtils.relesae(pstm, con);
        }
		return 0;
	}

}