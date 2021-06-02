package dao;

public class DaoFactory {
	// 返回一个用于操作用户的UserDaoImpl实例
	public static UserDao getUserDaoInstance() {
		return new UserDaoImpl();
	}
}
