package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.Article;
import utils.JDBCUtils;

public class ArticleDaoImpl implements ArticleDao {

	@Override
	public int insert(Article article) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(int articleid) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Article article) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Article query(int articleid) {
		Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        Article article = null;
        String sql = "select * from blog_article where Id = ?";

        try
        {
            con = JDBCUtils.getConnerction();
            pstm = con.prepareStatement(sql);
            pstm.setInt(1, articleid);
            rs = pstm.executeQuery();

            while(rs.next()) {
            	article = new Article();
            	article.setId(rs.getInt(1));
            	article.setTitle(rs.getString(2));
            	article.setSummary(rs.getString(3));
            	article.setContent(rs.getString(4));
            	article.setCover(rs.getString(5));
            	article.setCreatedTime(rs.getString(6));
            	article.setUpdateTime(rs.getString(7));
            	article.setAuthorId(rs.getInt(8));
            	article.setCategoryId(rs.getInt(9));
            	return article;
            }
        } catch (Exception e)
        {
            System.out.println("根据Id查询文章失败");
            e.printStackTrace();
        } finally
        {
        	JDBCUtils.relesae(pstm, con);
        }
		return null;
	}

	@Override
	public List<Article> queryAll(int authorid) {
		Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<Article> articles = new ArrayList<Article>();
        String sql = "select * from blog_article where Author_Id = ?";

        try
        {
            con = JDBCUtils.getConnerction();
            pstm = con.prepareStatement(sql);
            pstm.setInt(1, authorid);
            rs = pstm.executeQuery();

            while(rs.next()) {
            	Article article = new Article();
            	article.setId(rs.getInt(1));
            	article.setTitle(rs.getString(2));
            	article.setSummary(rs.getString(3));
            	article.setContent(rs.getString(4));
            	article.setCover(rs.getString(5));
            	article.setCreatedTime(rs.getString(6));
            	article.setUpdateTime(rs.getString(7));
            	article.setAuthorId(rs.getInt(8));
            	article.setCategoryId(rs.getInt(9));
            	articles.add(article);
            }
            return articles;
        } catch (Exception e)
        {
            System.out.println("根据Id查询文章失败");
            e.printStackTrace();
        } finally
        {
        	JDBCUtils.relesae(pstm, con);
        }
		return null;
	}

	@Override
	public List<Article> queryAll(int authorid, int categoryid) {
		Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<Article> articles = new ArrayList<Article>();
        String sql = "select * from blog_article where Author_Id = ? and Category_Id = ?";

        try
        {
            con = JDBCUtils.getConnerction();
            pstm = con.prepareStatement(sql);
            pstm.setInt(1, authorid);
            pstm.setInt(2, categoryid);
            rs = pstm.executeQuery();

            while(rs.next()) {
            	Article article = new Article();
            	article.setId(rs.getInt(1));
            	article.setTitle(rs.getString(2));
            	article.setSummary(rs.getString(3));
            	article.setContent(rs.getString(4));
            	article.setCover(rs.getString(5));
            	article.setCreatedTime(rs.getString(6));
            	article.setUpdateTime(rs.getString(7));
            	article.setAuthorId(rs.getInt(8));
            	article.setCategoryId(rs.getInt(9));
            	articles.add(article);
            }
            return articles;
        } catch (Exception e)
        {
            System.out.println("根据Authorid Id查询文章失败");
            e.printStackTrace();
        } finally
        {
        	JDBCUtils.relesae(pstm, con);
        }
		return null;
	}
	
	@Override
	public List<Article> queryAll(String title) {
		Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<Article> articles = new ArrayList<Article>();
        String sql = "select * from blog_article where Title like ?";

        try
        {
            con = JDBCUtils.getConnerction();
            pstm = con.prepareStatement(sql);
            pstm.setString(1, "%" + title + "%");
            rs = pstm.executeQuery();

            while(rs.next()) {
            	Article article = new Article();
            	article.setId(rs.getInt(1));
            	article.setTitle(rs.getString(2));
            	article.setSummary(rs.getString(3));
            	article.setContent(rs.getString(4));
            	article.setCover(rs.getString(5));
            	article.setCreatedTime(rs.getString(6));
            	article.setUpdateTime(rs.getString(7));
            	article.setAuthorId(rs.getInt(8));
            	article.setCategoryId(rs.getInt(9));
            	articles.add(article);
            }
            return articles;
        } catch (Exception e)
        {
            System.out.println("根据Title查询文章失败");
            e.printStackTrace();
        } finally
        {
        	JDBCUtils.relesae(pstm, con);
        }
		return null;
	}
	
	@Override
	public List<Article> queryAll() {
		Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<Article> articles = new ArrayList<Article>();
        String sql = "select * from blog_article";

        try
        {
            con = JDBCUtils.getConnerction();
            pstm = con.prepareStatement(sql);
            rs = pstm.executeQuery();

            while(rs.next()) {
            	Article article = new Article();
            	article.setId(rs.getInt(1));
            	article.setTitle(rs.getString(2));
            	article.setSummary(rs.getString(3));
            	article.setContent(rs.getString(4));
            	article.setCover(rs.getString(5));
            	article.setCreatedTime(rs.getString(6));
            	article.setUpdateTime(rs.getString(7));
            	article.setAuthorId(rs.getInt(8));
            	article.setCategoryId(rs.getInt(9));
            	articles.add(article);
            }
            return articles;
        } catch (Exception e)
        {
            System.out.println("查询所有文章失败");
            e.printStackTrace();
        } finally
        {
        	JDBCUtils.relesae(pstm, con);
        }
		return null;
	}

	
}
