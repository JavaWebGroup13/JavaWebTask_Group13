package web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Article;
import dao.ArticleDao;
import dao.DaoFactory;

/**
 * Servlet implementation class Search
 */
@WebServlet("/Search")
public class Search extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Search() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("search.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
//		response.setHeader("Content-Type", "text/html;charset=UTF-8");
		
		// 获取表单参数
		String keywords = request.getParameter("keywords");
		
		// 参数为空
		if(keywords.trim().isEmpty()) {
			System.out.println("参数为空");
			request.setAttribute("code", -1);
			request.setAttribute("msg", "请输入关键字进行查询");
			request.getRequestDispatcher("search.jsp").forward(request, response);
			return;
		}
		
		// 获取用于操作文章的articleDao实例
		ArticleDao articleDao = DaoFactory.getArticleDaoInstance();
				
		List<Article> articles = articleDao.queryAll(keywords.trim());
		
		// 查询出错
		if(articles == null) {
			System.out.println("查询出错");
			request.setAttribute("code", -1);
			request.setAttribute("msg", "查询失败，请联系开发者");
			request.getRequestDispatcher("search.jsp").forward(request, response);
			return;
		}
		
		// 查询结果为0
		if(articles.size() == 0) {
			System.out.println("查询结果为0");
			request.setAttribute("code", -1);
			request.setAttribute("msg", "未查找到关于《" + keywords + "》的相关文章，换个关键词试试吧！");
			request.getRequestDispatcher("search.jsp").forward(request, response);
			return;
		}
		
		// 查询成功
		System.out.println("Search: 成功查询到" + articles.size() + "条数据！");
		request.setAttribute("code", 0);
		request.setAttribute("msg", "成功查询到关于《" + keywords + "》的" + articles.size() + "条数据！");
		request.setAttribute("articles", articles);
		request.getRequestDispatcher("search.jsp").forward(request, response);
	}
}
