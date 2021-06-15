package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.User;
import utils.JDBCUtils;

public class UserDaoImpl implements UserDao{

	@Override
	public int insert(User user) {
		Connection con = null;
        PreparedStatement pstm = null;
        String sql = "insert into blog_user values (null, ?, md5(?), ?, ?, ?)";

        try
        {
            con = JDBCUtils.getConnerction();
            pstm = con.prepareStatement(sql);
            pstm.setString(1, user.getUsername());
            pstm.setString(2, user.getPassword());
            pstm.setString(3, user.getNickname());
            pstm.setString(4, user.getAvatar());
            pstm.setString(5, user.getProfile());
            pstm.executeUpdate();
            return 0;
        } catch (Exception e)
        {
            // TODO Auto-generated catch block
            System.out.println("插入用户失败");
            e.printStackTrace();
        } finally
        {
        	JDBCUtils.relesae(pstm, con);
        }
        return -1;
	}

	@Override
	public int delete(int userid) {
		// TODO Auto-generated method stub
		Connection con = null;
        PreparedStatement pstm = null;
        String sql = "deleter  from blog_user where Id=?";

        try
        {
            con = JDBCUtils.getConnerction();
            pstm = con.prepareStatement(sql);
            pstm.setInt(1, userid);
            pstm.executeUpdate();
            return 0;
        } catch (Exception e)
        {
            // TODO Auto-generated catch block
            System.out.println("删除用户失败");
            e.printStackTrace();
        } finally
        {
        	JDBCUtils.relesae(pstm, con);
        }
        return -1;
	}

	@Override
	public int update(User user) {
		// TODO Auto-generated method stub
		Connection con = null;
        PreparedStatement pstm = null;
        String sql = "update blog_user SET Username=?,Password=?,Nickname=?,Avatar=?,Profile=? where id=?";

        try
        {
            con = JDBCUtils.getConnerction();
            pstm = con.prepareStatement(sql);
            pstm.setString(1, user.getUsername());
            pstm.setString(2, user.getPassword());
            pstm.setString(3, user.getNickname());
            pstm.setString(4, user.getAvatar());
            pstm.setString(5, user.getProfile());
            pstm.setInt(6, user.getId());
            pstm.executeUpdate();
            return 0;
        } catch (Exception e)
        {
            // TODO Auto-generated catch block
            System.out.println("更新用户失败");
            e.printStackTrace();
        } finally
        {
        	JDBCUtils.relesae(pstm, con);
        }
        return -1;
	}

	@Override
	public User query(int id) {
		// TODO Auto-generated method stub
		Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        User user = null;
        String sql = "select * from blog_user where id = ?";

        try
        {
            con = JDBCUtils.getConnerction();
            pstm = con.prepareStatement(sql);
            pstm.setInt(1, id);
            rs = pstm.executeQuery();

            while(rs.next()) {
            	user = new User();
            	user.setId(rs.getInt(1));
            	user.setUsername(rs.getString(2));
            	user.setPassword(rs.getString(3));
            	user.setNickname(rs.getString(4));
            	user.setAvatar(rs.getString(5));
            	user.setProfile(rs.getString(6));
            	return user;
            }
        } catch (Exception e)
        {
            // TODO Auto-generated catch block
            System.out.println("根据Id查询用户失败");
            e.printStackTrace();
        } finally
        {
        	JDBCUtils.relesae(pstm, con);
        }
		return null;
	}
	
	@Override
	public User query(String username) {
		// TODO Auto-generated method stub
		Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        User user = null;
        String sql = "select * from blog_user where Username = ?";

        try
        {
            con = JDBCUtils.getConnerction();
            pstm = con.prepareStatement(sql);
            pstm.setString(1, username);
            rs = pstm.executeQuery();

            while(rs.next()) {
            	user = new User();
            	user.setId(rs.getInt(1));
            	user.setUsername(rs.getString(2));
            	user.setPassword(rs.getString(3));
            	user.setNickname(rs.getString(4));
            	user.setAvatar(rs.getString(5));
            	user.setProfile(rs.getString(6));
            	return user;
            }
        } catch (Exception e)
        {
            // TODO Auto-generated catch block
            System.out.println("根据Username查询用户失败");
            e.printStackTrace();
        } finally
        {
        	JDBCUtils.relesae(pstm, con);
        }
		return null;
	}

	@Override
	public List<User> queryAll() {
		// TODO Auto-generated method stub
		Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<User> users = new ArrayList<User>();
        String sql = "select * from  blog_user";

        try
        {
            con = JDBCUtils.getConnerction();
            pstm = con.prepareStatement(sql);
            rs = pstm.executeQuery();
            while(rs.next()) {
            	User user = new User();
            	user.setId(rs.getInt(1));
            	user.setUsername(rs.getString(2));
            	user.setPassword(rs.getString(3));
            	user.setNickname(rs.getString(4));
            	user.setAvatar(rs.getString(5));
            	user.setProfile(rs.getString(6));
            	users.add(user);
            }
            return users;
        } catch (Exception e)
        {
            // TODO Auto-generated catch block
            System.out.println("查询所有用户失败");
            e.printStackTrace();
        } finally
        {
        	JDBCUtils.relesae(pstm, con);
        }
		return null;
	}

	@Override
	public User login(String username, String password) {
		// TODO Auto-generated method stub
		Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        User user = null;
        String sql = "select * from blog_user where Username = ? and Password = md5(?)";

        try
        {
            con = JDBCUtils.getConnerction();
            pstm = con.prepareStatement(sql);
            pstm.setString(1, username);
            pstm.setString(2, password);
            
            rs = pstm.executeQuery();

            while(rs.next()) {
            	user = new User();
            	user.setId(rs.getInt(1));
            	user.setUsername(rs.getString(2));
            	user.setPassword(rs.getString(3));
            	user.setNickname(rs.getString(4));
            	user.setAvatar(rs.getString(5));
            	user.setProfile(rs.getString(6));
            	return user;
            }
        } catch (Exception e)
        {
            // TODO Auto-generated catch block
            System.out.println("登录失败");
            e.printStackTrace();
        } finally
        {
        	JDBCUtils.relesae(pstm, con);
        }
		return null;
	}
}
