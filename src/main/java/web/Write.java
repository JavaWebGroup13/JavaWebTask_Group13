package web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Article;
import bean.User;
import dao.ArticleDao;
import dao.CategoryDao;
import dao.DaoFactory;

/**
 * Servlet implementation class Write
 */
@WebServlet("/Write")
public class Write extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Write() {
        super();
        // TODO Auto-generated constructor stub
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
		// 如果有id，则是更新文章，否则是添加文章
		int id = -1;
		try{
			id = Integer.parseInt(request.getParameter("id"));
			// 查询文章详情
			ArticleDao articleDao = DaoFactory.getArticleDaoInstance();
			Article article = articleDao.query(id);
			request.setAttribute("article", article);
		}catch(Exception e) {}
		CategoryDao categoryDao = DaoFactory.getCategoryDaoInstance();
		List<bean.Category> categorys = categoryDao.queryAll(user.getId());
		// 查询出错
		if(categorys == null) {
			System.out.println("查询类别出错");
			request.setAttribute("code", -1);
			request.setAttribute("msg", "查询类别出错，请联系开发者");
			request.getRequestDispatcher("write.jsp").forward(request, response);
			return;
		}
		// 没有类别
		if(categorys.size() == 0) {
			System.out.println("当前没有类别");
			request.setAttribute("code", -1);
			request.setAttribute("msg", "您的博客当前没有类别，请到管理界面添加");
			request.getRequestDispatcher("write.jsp").forward(request, response);
			return;
		}
		request.setAttribute("categorys", categorys);
		request.getRequestDispatcher("write.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		// 获取表单参数
		String cover = request.getParameter("cover");
		String title = request.getParameter("title");
		String summary = request.getParameter("summary");
		String content = request.getParameter("content");
		String isUpdate = request.getParameter("isUpdate");
		int category = new Integer(request.getParameter("category"));
		if(cover.isEmpty() || title.isEmpty() || category < 0 || summary.isEmpty() || content.isEmpty()) {
			System.out.println("表单为空");
			response.sendRedirect("/JavaWebTask_Group13/Write");
			return;
		}
		// 获取session中的属性
		User user = (User)request.getSession().getAttribute("user");
		// 强制登录
		if(user == null) {
			System.out.println("需要登录");
			response.sendRedirect("/JavaWebTask_Group13/Login");
			return;
		}
		// 获取用于操作文章的ArticleDao实列
		ArticleDao articleDao = DaoFactory.getArticleDaoInstance();
		Article article = new Article();
		article.setCover(cover);
		article.setTitle(title);
		article.setCategoryId(category);
		article.setSummary(summary);
		article.setContent(content);
		article.setAuthorId(user.getId());
		int resCode = -1;
		if("true".equals(isUpdate)) {
			int id = new Integer(request.getParameter("id"));
			article.setId(id);
			resCode = articleDao.update(article);
		}else {
			resCode = articleDao.insert(article);
		}
		if(resCode == 0) {
			request.setAttribute("code", 0);
			request.setAttribute("msg", "操作成功！");
			System.out.println("操作文章成功");
			request.getRequestDispatcher("write.jsp").forward(request, response);
		}else {
			request.setAttribute("code", -1);
			request.setAttribute("msg", "操作失败！，请联系开发者");
			System.out.println("操作文章失败");
			request.getRequestDispatcher("write.jsp").forward(request, response);
		}
	}

}
