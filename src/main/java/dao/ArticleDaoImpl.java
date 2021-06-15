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
		Connection con = null;
        PreparedStatement pstm = null;
        String sql = "insert into blog_article values (null, ?, ?, ?, ?, now(), now(), ?, ?)";

        try
        {
            con = JDBCUtils.getConnerction();
            pstm = con.prepareStatement(sql);
            pstm.setString(1, article.getTitle());
            pstm.setString(2, article.getSummary());
            pstm.setString(3, article.getContent());
            pstm.setString(4, article.getCover());
            pstm.setInt(5, article.getAuthorId());
            pstm.setInt(6, article.getCategoryId());
            pstm.executeUpdate();
            return 0;
        } catch (Exception e)
        {
            System.out.println("插入文章失败");
            e.printStackTrace();
        } finally
        {
        	JDBCUtils.relesae(pstm, con);
        }
		return 0;
	}

	@Override
	public int delete(int articleid) {
		Connection con = null;
        PreparedStatement pstm = null;
        String sql = "delete from blog_article where id = ?";

        try
        {
            con = JDBCUtils.getConnerction();
            pstm = con.prepareStatement(sql);
            pstm.setInt(1, articleid);
            pstm.executeUpdate();
            return 0;
        } catch (Exception e)
        {
            System.out.println("删除文章失败");
            e.printStackTrace();
        } finally
        {
        	JDBCUtils.relesae(pstm, con);
        }
		return -1;
	}

	@Override
	public int update(Article article) {
		Connection con = null;
        PreparedStatement pstm = null;
        String sql = "update blog_article set title=?, summary=?, content=?, cover=?, updateTime=now(), Category_Id=? where id=?";

        try
        {
            con = JDBCUtils.getConnerction();
            pstm = con.prepareStatement(sql);
            pstm.setString(1, article.getTitle());
            pstm.setString(2, article.getSummary());
            pstm.setString(3, article.getContent());
            pstm.setString(4, article.getCover());
            pstm.setInt(5, article.getCategoryId());
            pstm.setInt(6, article.getId());
            pstm.executeUpdate();
            return 0;
        } catch (Exception e)
        {
            System.out.println("更新文章失败");
            e.printStackTrace();
        } finally
        {
        	JDBCUtils.relesae(pstm, con);
        }
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
	public List<Article> queryAllByAuthorId(int authorid) {
		Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<Article> articles = new ArrayList<Article>();
        String sql = "select * from blog_article where Author_Id = ? order by UpdateTime desc";

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
        String sql = "select * from blog_article where Author_Id = ? and Category_Id = ? order by UpdateTime desc";

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
        String sql = "select * from blog_article where Title like ? order by UpdateTime desc";

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
	public List<Article> queryAllWithPage(int start, int count) {
		Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<Article> articles = new ArrayList<Article>();
        String sql = "select * from blog_article order by UpdateTime desc limit ? , ?";

        try
        {
            con = JDBCUtils.getConnerction();
            pstm = con.prepareStatement(sql);
            pstm.setInt(1, start);
            pstm.setInt(2, count);
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

	@Override
	public List<Article> queryByUpdateTime(int count) {
		Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<Article> articles = new ArrayList<Article>();
        String sql = "select * from blog_article order by updateTime limit ?";

        try
        {
            con = JDBCUtils.getConnerction();
            pstm = con.prepareStatement(sql);
            pstm.setInt(1, count);
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
            System.out.println("查询N条最新文章失败");
            e.printStackTrace();
        } finally
        {
        	JDBCUtils.relesae(pstm, con);
        }
		return null;
	}

	@Override
	public List<Article> queryByUpdateTime(int authorid, int count) {
		Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<Article> articles = new ArrayList<Article>();
        String sql = "select * from blog_article where author_Id = ? order by updateTime limit ?";

        try
        {
            con = JDBCUtils.getConnerction();
            pstm = con.prepareStatement(sql);
            pstm.setInt(1, authorid);
            pstm.setInt(2, count);
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
            System.out.println("根据Authorid Id查询最新N条文章失败");
            e.printStackTrace();
        } finally
        {
        	JDBCUtils.relesae(pstm, con);
        }
		return null;
	}

	@Override
	public List<Article> queryByCategory(int categoryid, int count) {
		Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<Article> articles = new ArrayList<Article>();
        String sql = "select * from blog_article where category_Id = ? order by updateTime desc limit ?";

        try
        {
            con = JDBCUtils.getConnerction();
            pstm = con.prepareStatement(sql);
            pstm.setInt(1, categoryid);
            pstm.setInt(2, count);
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
            System.out.println("根据CategoryId查询最新N条文章失败");
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
        String sql = "select count(1) from blog_article where Author_Id = ?";
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
            System.out.println("根据authorid查询文章总数失败");
            e.printStackTrace();
        } finally
        {
        	JDBCUtils.relesae(pstm, con);
        }
		return 0;
	}

	@Override
	public int queryAllCounts() {
		Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        String sql = "select count(1) from blog_article";
        int res = 0;
        try
        {
            con = JDBCUtils.getConnerction();
            pstm = con.prepareStatement(sql);
            rs = pstm.executeQuery();
            while(rs.next()) {
            	res = rs.getInt(1);
            }
            return res;
        } catch (Exception e)
        {
            System.out.println("查询文章总数失败");
            e.printStackTrace();
        } finally
        {
        	JDBCUtils.relesae(pstm, con);
        }
		return 0;
	}
}
