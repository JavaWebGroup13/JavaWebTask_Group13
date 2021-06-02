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
	public void insert(User user) throws Exception {
		// TODO Auto-generated method stub
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
        } catch (Exception e)
        {
            // TODO Auto-generated catch block
            System.out.println("插入数据操作异常");
            e.printStackTrace();
        } finally
        {
        	JDBCUtils.relesae(pstm, con);
        }
	}

	@Override
	public void delete(int userid) throws Exception {
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
        } catch (Exception e)
        {
            // TODO Auto-generated catch block
            System.out.println("删除数据操作异常");
            e.printStackTrace();
        } finally
        {
        	JDBCUtils.relesae(pstm, con);
        }
	}

	@Override
	public void update(User user) throws Exception {
		// TODO Auto-generated method stub
		Connection con = null;
        PreparedStatement pstm = null;
        String sql = "updata blog_user SET Username=?,Password=?,Nickname=?,Avatar=?,Profile=? where Username=?";

        try
        {
            con = JDBCUtils.getConnerction();
            pstm = con.prepareStatement(sql);
            pstm.setString(1, user.getUsername());
            pstm.setString(2, user.getPassword());
            pstm.setString(3, user.getNickname());
            pstm.setString(4, user.getAvatar());
            pstm.setString(5, user.getProfile());
            pstm.setString(6, user.getUsername());
            pstm.executeUpdate();
        } catch (Exception e)
        {
            // TODO Auto-generated catch block
            System.out.println("插入数据操作异常");
            e.printStackTrace();
        } finally
        {
        	JDBCUtils.relesae(pstm, con);
        }
	}

	@Override
	public User queryByUserid(int id) throws Exception {
		// TODO Auto-generated method stub
		Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        User user = null;
        String sql = "select * from blog_user where id = 1";

        try
        {
            con = JDBCUtils.getConnerction();
            System.out.println(con);
            pstm = con.prepareStatement(sql);
            System.out.println(pstm);
//            pstm.setInt(1, id);
            rs = pstm.executeQuery();

            while(rs.next()) {
            	user = new User();
            	user.setId(rs.getInt(1));
            	user.setUsername(rs.getString(2));
            	user.setPassword(rs.getString(3));
            	user.setNickname(rs.getString(4));
            	user.setAvatar(rs.getString(5));
            	user.setProfile(rs.getString(6));
            }
        } catch (Exception e)
        {
            // TODO Auto-generated catch block
            System.out.println("查询数据操作异常");
            e.printStackTrace();
        } finally
        {
        	JDBCUtils.relesae(pstm, con);
        }
		return user;
	}

	@Override
	public List queryAll() throws Exception {
		// TODO Auto-generated method stub
		Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<User> users = new ArrayList<User>();
        String sql = "insert into blog_user values (null, ?, md5(?), ?, ?, ?)";

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
        } catch (Exception e)
        {
            // TODO Auto-generated catch block
            System.out.println("插入数据操作异常");
            e.printStackTrace();
        } finally
        {
        	JDBCUtils.relesae(pstm, con);
        }
		return users;
	}

	public User login(String username, String password) {
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
            }
        } catch (Exception e)
        {
            // TODO Auto-generated catch block
            System.out.println("查询数据操作异常");
            e.printStackTrace();
        } finally
        {
        	JDBCUtils.relesae(pstm, con);
        }
		return user;
	}
}
