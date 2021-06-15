package web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Article;
import bean.User;
import dao.ArticleDao;
import dao.CategoryDao;
import dao.DaoFactory;

/**
 * Servlet implementation class Category
 */
@WebServlet("/Category")
public class Category extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Category() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 获取表单参数
		int category = 0;
		try{
			category = Integer.parseInt(request.getParameter("id"));
		}catch(Exception e) {
			// e.printStackTrace();
		}
		
		// 获取session中的属性
		User user = (User)request.getSession().getAttribute("user");
		
		// 强制登录
		if(user == null) {
			response.sendRedirect("/JavaWebTask_Group13/Login");
			return;
		}
		
		CategoryDao categoryDao = DaoFactory.getCategoryDaoInstance();
		List<bean.Category> categorys = categoryDao.queryAll(user.getId());
		
		// 查询出错
		if(categorys == null) {
			System.out.println("查询类别出错");
			request.setAttribute("code1", -1);
			request.setAttribute("msg1", "查询类别出错，请联系开发者");
			request.getRequestDispatcher("category.jsp").forward(request, response);
			return;
		}
		
		// 没有类别
		if(categorys.size() == 0) {
			System.out.println("当前没有类别");
			request.setAttribute("code1", -1);
			request.setAttribute("msg1", "您的博客当前没有类别，请添加");
			request.getRequestDispatcher("category.jsp").forward(request, response);
			return;
		}
		
		// 查询类别成功
		request.setAttribute("categorys", categorys);
		
		// 查询文章
		// 获取用于操作文章的ArticleDao实列
		ArticleDao articleDao = DaoFactory.getArticleDaoInstance();
				
		// 存放查询到的文章列表
		List<Article> category_articles = null;

		if(category != 0) {
			// 查询指定类别ID的文章
			category_articles = articleDao.queryAll(user.getId(), category);
			// 将id号返回到jsp页面，用于设置标签卡激活状态
			request.setAttribute("which", category);
		}else {
			// 查询自己所有文章
			category_articles = articleDao.queryAllByAuthorId(user.getId());
			request.setAttribute("which", 0);
		}
		
		if(category_articles == null) {
			System.out.println("查询文章出错");
			request.setAttribute("code2", -1);
			request.setAttribute("msg2", "查询文章出错，请联系开发者");
			request.getRequestDispatcher("category.jsp").forward(request, response);
			return;
		}
		
		if(category_articles.size() == 0) {
			System.out.println("当前类别没有文章");
			request.setAttribute("code2", -1);
			request.setAttribute("msg2", "当前类别没有文章，请添加一篇");
			request.getRequestDispatcher("category.jsp").forward(request, response);
			return;
		}

		// 查询文章成功
		
		request.setAttribute("category_articles", category_articles);
		request.getRequestDispatcher("category.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title = new String(request.getParameter("title").getBytes("iso-8859-1"),"utf-8");
		
		// 获取session中的属性
		User user = (User)request.getSession().getAttribute("user");
				
		// 强制登录
		if(user == null) {
			response.sendRedirect("/JavaWebTask_Group13/Login");
			return;
		}
		
		if(title.trim().isEmpty()) {
			request.setAttribute("code1", -1);
			request.setAttribute("msg1", "请输入类别标题");
			request.getRequestDispatcher("category.jsp").forward(request, response);
			return;
		}
		
		bean.Category category = new bean.Category();
		category.setAuthorId(user.getId());
		category.setTitle(title);
		
		CategoryDao categoryDao = DaoFactory.getCategoryDaoInstance();
		categoryDao.insert(category);
		
		request.setAttribute("code1", 0);
		request.setAttribute("msg1", "添加类别成功");
		response.sendRedirect("/JavaWebTask_Group13/Category");
	}

}
