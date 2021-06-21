package dao;

import java.util.List;

import bean.User;

public interface UserDao{
    /**
     * 增加用户
     * @param user
     * @return 0 成功 -1 失败
     */
	public int insert(User user);
	
	/**
     * 删除用户
     * @param userid
     * @return 0 成功 -1 失败
     */
    public int delete(int userid);
    
    /**
     * 更新用户
     * @param user
     * @return 0 成功 -1 失败
     */
    public int update(User user);
    
    /**
     * 根据Id查询用户
     * @param userid
     * @return user
     */
    public User query(int userid);
    
    /**
     * 根据Username查询用户
     * @param username
     * @return user
     */
    public User query(String username);
    
    /**
     * 查询所有用户
     * @return List user
     */
    public List<User> queryAll();

    /**
     * 根据Username、password登录
     * @param username password
     * @return User
     */
    public User login(String username, String password);
}