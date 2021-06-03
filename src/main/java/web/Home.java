package web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Article;
import bean.User;
import dao.ArticleDao;
import dao.DaoFactory;
import dao.UserDao;

/**
 * Servlet implementation class Home
 */
@WebServlet("/Home")
public class Home extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Home() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/*
		 * String isLogin = "false";
		 * 
		 * Cookie[] cookies = request.getCookies(); for(int i = 0; cookies != null && i
		 * < cookies.length; i++) { if("isLogin".equals(cookies[i].getName())) { isLogin
		 * = cookies[i].getValue(); } }
		 */

		HttpSession session = request.getSession();
		
		// 获取session中的属性
		User user = (User)session.getAttribute("user");

		// 获取用于操作文章的ArticleDao实列
		ArticleDao articleDao = DaoFactory.getArticleDaoInstance();
		
		// 存放查询到的文章列表
		List<Article> articles = null;
		
		if(user != null) {
			// 已登录，查询自己的文章
			session.setAttribute("isLogin", true);
			articles = articleDao.queryAll(user.getId());
			System.out.println("查询自己的文章");
		}else {
			// 否则，查询所有文章
			session.setAttribute("isLogin", false);
			articles = articleDao.queryAll();
			System.out.println("查询所有的文章");
		}
		System.out.println("Home：检索到文章数量 " + articles.size() + " 条");
		request.setAttribute("articles", articles);
		
		// 请求转发到index.jsp，将查询到的文章展示出来
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
