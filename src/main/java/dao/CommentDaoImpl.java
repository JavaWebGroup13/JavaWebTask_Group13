package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.Article;
import bean.Comment;
import utils.JDBCUtils;

public class CommentDaoImpl implements CommentDao{

	@Override
	public int insert(Comment comment) {
		Connection con = null;
        PreparedStatement pstm = null;
        String sql = "insert into blog_comment values (null, ?, ?, ?, now())";
        try
        {
            con = JDBCUtils.getConnerction();
            pstm = con.prepareStatement(sql);
            pstm.setString(1, comment.getContent());
            pstm.setInt(2, comment.getUserId());
            pstm.setInt(3, comment.getArticaleId());
            pstm.executeUpdate();
            return 0;
        } catch (Exception e)
        {
            System.out.println("插入评论失败");
            e.printStackTrace();
        } finally
        {
        	JDBCUtils.relesae(pstm, con);
        }
		return -1;
	}

	@Override
	public int delete(int commentid) {
		Connection con = null;
        PreparedStatement pstm = null;
        String sql = "delete from blog_comment where id = ?";
        try
        {
            con = JDBCUtils.getConnerction();
            pstm = con.prepareStatement(sql);
            pstm.setInt(1, commentid);
            pstm.executeUpdate();
            return 0;
        } catch (Exception e)
        {
            System.out.println("删除评论失败");
            e.printStackTrace();
        } finally
        {
        	JDBCUtils.relesae(pstm, con);
        }
		return -1;
	}

	@Override
	public int update(Comment comment) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Comment query(int commentid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Comment> queryAll(int articleid) {
		Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<Comment> comments = new ArrayList<Comment>();
        String sql = "select c.id, c.User_Id, c.Article_Id, c.Content, c.created_time, u.Avatar, u.Nickname from blog_comment c left JOIN blog_user u on u.Id = c.User_Id where Article_Id = ? order by Created_Time desc";
        try
        {
            con = JDBCUtils.getConnerction();
            pstm = con.prepareStatement(sql);
            pstm.setInt(1, articleid);
            rs = pstm.executeQuery();

            while(rs.next()) {
            	Comment comment = new Comment();
            	comment.setId(rs.getInt(1));
            	comment.setUserId(rs.getInt(2));
            	comment.setArticaleId(rs.getInt(3));
            	comment.setContent(rs.getString(4));
            	comment.setCreatedTime(rs.getString(5));
            	comment.setAvatar(rs.getString(6));
            	comment.setNickName(rs.getString(7));
            	comments.add(comment);
            }
            return comments;
        } catch (Exception e)
        {
            System.out.println("根据文章Id查询评论失败");
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
        String sql = "select count(1) from blog_comment c left join blog_article a on c.Article_Id = a.id where a.Author_Id = ?";
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
            System.out.println("根据Id查询评论总数失败");
            e.printStackTrace();
        } finally
        {
        	JDBCUtils.relesae(pstm, con);
        }
		return 0;
	}
	
}