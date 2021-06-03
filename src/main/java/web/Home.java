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
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String isLogin = "false";
		
		Cookie[] cookies = request.getCookies();
		for(int i = 0; cookies != null && i < cookies.length; i++) {
			if("isLogin".equals(cookies[i].getName())) {
				isLogin = cookies[i].getValue();
			}
		}
		
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		
		ArticleDao articleDao = DaoFactory.getArticleDaoInstance();
		List<Article> articles = new ArrayList<Article>();
		
		if("true".equals(isLogin) && user != null) {
			// 已登录，查询自己的文章
			articles = articleDao.queryAll(user.getId());
		}else {
			// 否则，查询所有文章
			articles = articleDao.queryAll();
		}
		System.out.println("Home：检索到文章数量 " + articles.size() + " 条");
		request.setAttribute("articles", articles);
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
