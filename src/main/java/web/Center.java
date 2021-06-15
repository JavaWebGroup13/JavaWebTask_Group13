package web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.User;
import dao.ArticleDao;
import dao.CategoryDao;
import dao.CommentDao;
import dao.DaoFactory;
import dao.UserDao;

/**
 * Servlet implementation class Center
 */
@WebServlet("/Center")
public class Center extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Center() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 获取session中的属性
		User user = (User)request.getSession().getAttribute("user");
				
		// 强制登录
		if(user == null) {
			response.sendRedirect("/JavaWebTask_Group13/Login");
			return;
		}
		
		// 获取用于操作数据库的实例
		ArticleDao articleDao = DaoFactory.getArticleDaoInstance();
		CategoryDao categoryDao = DaoFactory.getCategoryDaoInstance();
		CommentDao commentDao = DaoFactory.getCommentDaoInstance();
		
		// 获取文章总数
		int articleCounts = articleDao.queryAllCounts(user.getId());
		// 获取类别总数
		int categoryCounts = categoryDao.queryAllCounts(user.getId());
		// 获取评论总数
		int commentCounts = commentDao.queryAllCounts(user.getId());

		request.setAttribute("articleCounts", articleCounts);
		request.setAttribute("categoryCounts", categoryCounts);
		request.setAttribute("commentCounts", commentCounts);
		request.getRequestDispatcher("center.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 获取session中的属性
		User user = (User)request.getSession().getAttribute("user");
						
		// 强制登录
		if(user == null) {
			response.sendRedirect("/JavaWebTask_Group13/Login");
			return;
		}
		
		String nick = new String(request.getParameter("nick").getBytes("iso-8859-1"),"utf-8");
		String profile = new String(request.getParameter("profile").getBytes("iso-8859-1"),"utf-8");
		
		user.setNickname(nick);
		user.setProfile(profile);
		UserDao userDao = DaoFactory.getUserDaoInstance();
		userDao.update(user);
		response.sendRedirect("/JavaWebTask_Group13/Center");
	}

}
