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
	
	// 返回用于操作文章类别的实例
	public static CategoryDao getCategoryDaoInstance() {
		return new CategoryDaoImpl();
	}
	
	// 返回用于操作评论的实例
	public static CommentDao getCommentDaoInstance() {
		return new CommentDaoImpl();
	}
}
