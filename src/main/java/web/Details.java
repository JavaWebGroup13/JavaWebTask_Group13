package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Article;
import dao.ArticleDao;
import dao.DaoFactory;

/**
 * Servlet implementation class Details
 */
@WebServlet("/Details")
public class Details extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Details() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 通过参数获取文章ID
		int id = -1;
		try{
			id = Integer.parseInt(request.getParameter("id"));
		}catch(Exception e) {
			e.printStackTrace();
			response.sendRedirect("/JavaWebTask_Group13/Notfound");
			return;
		}
		
		HttpSession session = request.getSession();
		
		// 获取用于操作文章的articleDao实例
		ArticleDao articleDao = DaoFactory.getArticleDaoInstance();
		
		Article article = articleDao.query(id);
		
		// 文章查询失败
		if(article == null) {
			response.sendRedirect("/JavaWebTask_Group13/Notfound");
			return;
		}
		
		session.setAttribute("article", article);
		
		System.out.println("Details: article" + article.getTitle());
		request.getRequestDispatcher("details.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
