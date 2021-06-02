package dao;

public class DaoFactory {
    // 返回用于操作用户的实例
	public static UserDao getUserDaoInstance() {
		return new UserDaoImpl();
	}

	// 返回用于操作文章的实例
	public static ArticleDao getArticleDaoInstance() {
		return new ArticleDaoImpl();
	}
}
