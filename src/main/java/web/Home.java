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
import utils.Encryption;

/**
 * Servlet implementation class Home
 */

// 以使用@WebServlet注解将一个继承于HttpServlet的类标注为可以处理用户请求的 Servlet。
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		// 获取cookie进行自动登录
		User user = null;
		String token = null;
		Cookie[] cookies = request.getCookies(); 
		for(int i = 0; cookies != null && session.getAttribute("user") == null && i < cookies.length; i++) {
			if("userid".equals(cookies[i].getName())) {
				int userid = new Integer(cookies[i].getValue());
				UserDao userDao = DaoFactory.getUserDaoInstance();
				user = userDao.query(userid);
				System.out.println("Home -> cookie中的userid：" + userid);
			}
			if("token".equals(cookies[i].getName())) {
				token = cookies[i].getValue();
				System.out.println("Home -> cookie中的token：" + token);
			}
		}
		if(user != null && token != null && session.getAttribute("user") == null && !token.isEmpty()) {
			String token2 = Encryption.encrypByMD5(user.getUsername() + user.getPassword());
			System.out.println("Home -> 客户端token:" + token);
			System.out.println("Home -> 服务器token:" + token2);
			if(token.equals(token2)) {
				session.setAttribute("user", user);
				System.out.println("Home -> token相同，自动登录成功");
			}else {
				System.out.println("Home -> token不同，自动登录失败");
			}
		}
		int page = 1;
		try {
			page = Integer.parseInt(request.getParameter("page"));
		} catch (Exception e) {}
		// 获取用于操作文章的ArticleDao实列
		ArticleDao articleDao = DaoFactory.getArticleDaoInstance();
		// 文章总数量
		float article_conut = (float) articleDao.queryAllCounts();
		// 一页显示的文章数量
		int num = 9;
		// 向上取整，获取总页数
		int page_count = (int) Math.ceil(article_conut / num);
		request.setAttribute("page_count", page_count);
		request.setAttribute("page", page);
		System.out.println("Home -> 查询到文章总数：" + article_conut);
		System.out.println("Home -> 主页文章总页数：" + page_count);
		// 存放查询到的文章列表
		List<Article> articles = articleDao.queryAllWithPage((page - 1) * num, num);
		// 存放查询到的最新更新文章列表
		List<Article> articles_lately = articleDao.queryByUpdateTime(5);
		System.out.println("Home -> 当前页面文章：" + articles.size() + " 条");
		request.setAttribute("articles", articles);
		request.setAttribute("articles_lately", articles_lately);
		// 请求转发到index.jsp，将查询到的文章展示出来
		request.getRequestDispatcher("home.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
