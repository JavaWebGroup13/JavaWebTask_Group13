package dao;

public class DaoFactory {
	// ����һ�����ڲ����û���UserDaoImplʵ��
	public static UserDao getUserDaoInstance() {
		return new UserDaoImpl();
	}
}
