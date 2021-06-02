package dao;

import java.util.List;

import bean.User;

public interface UserDao{
	public void insert(User user) throws Exception;
    public void delete(int userid) throws Exception;
    public void update(User user) throws Exception;
    public User queryByUserid(int userid) throws Exception;
    public List queryAll() throws Exception;
    public User login(String username, String password) throws Exception;
}