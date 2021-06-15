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

		int page = 1;
		try{
			page = Integer.parseInt(request.getParameter("page"));
		}catch(Exception e) {
		}
		
		// 获取用于操作文章的ArticleDao实列
		ArticleDao articleDao = DaoFactory.getArticleDaoInstance();
		
		// 查询文章总数量
		float article_conut = (float) articleDao.queryAllCounts();
		// 向上取整
		int page_count = (int) Math.ceil(article_conut / 2);
		System.out.println("Home page_count:" + page_count);
		System.out.println("Home article_conut:" + article_conut);
		request.setAttribute("page_count", page_count);
		request.setAttribute("page", page);
		
		
		// 存放查询到的文章列表
		List<Article> articles = null;

		// 存放查询到的最新更新文章列表
		List<Article> articles_lately = null;
		
		// 查询文章
		articles = articleDao.queryAllWithPage((page - 1) * 2, 2);
		
		// 查询最新的N条文章
		articles_lately = articleDao.queryByUpdateTime(5);
		
		System.out.println("查询所有的文章和最新的5条文章");

		System.out.println("Home：检索到文章数量 " + articles.size() + " 条");
		request.setAttribute("articles", articles);
		request.setAttribute("articles_lately", articles_lately);
		// 请求转发到index.jsp，将查询到的文章展示出来
		request.getRequestDispatcher("home.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
