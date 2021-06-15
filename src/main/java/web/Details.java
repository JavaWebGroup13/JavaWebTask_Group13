package web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Article;
import bean.Comment;
import bean.User;
import dao.ArticleDao;
import dao.CommentDao;
import dao.DaoFactory;
import dao.UserDao;

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
		
		// 获取用于操作文章的articleDao实例
		ArticleDao articleDao = DaoFactory.getArticleDaoInstance();
		
		// 查询单篇文章详情
		Article article = articleDao.query(id);
		
		// 文章查询失败
		if(article == null) {
			response.sendRedirect("/JavaWebTask_Group13/Notfound");
			return;
		}
		
		// 存放查询到的相关文章列表
		List<Article> articles_relevant = articleDao.queryByCategory(article.getCategoryId(), 5);

		// 获取用于操作评论的commentDao实例
		CommentDao commentDao = DaoFactory.getCommentDaoInstance();
		
		// 存放查询到的评论列表
		List<Comment> comments = commentDao.queryAll(article.getId());
		
		request.setAttribute("article", article);
		request.setAttribute("articles_relevant", articles_relevant);
		request.setAttribute("comments", comments);
		
		System.out.println("Details: article" + article.getTitle());
		request.getRequestDispatcher("details.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 获取表单参数
		String id = request.getParameter("id");
		// 解决中文乱码问题
		String content = new String(request.getParameter("content").getBytes("iso-8859-1"),"utf-8");
		System.out.println("评论：" + content);

		// 信息不完整
		if (content.isEmpty() || id.isEmpty()) {
			request.setAttribute("code", -1);
			request.setAttribute("msg", "请填写完整！");
			request.getRequestDispatcher("details.jsp").forward(request, response);
			return;
		}

		// 获取已登录的用户
		User user = (User)request.getSession().getAttribute("user");
		
		// 强制登录
		if(user == null) {
			response.sendRedirect("/JavaWebTask_Group13/Login");
			return;
		}
		
		// 获取用于操作评论的commentDao实例
		CommentDao commentDao = DaoFactory.getCommentDaoInstance();
		Comment comment = new Comment();
		try {
			comment.setUserId(user.getId());
			comment.setArticaleId(Integer.parseInt(id));
			comment.setContent(content);
			
			commentDao.insert(comment);
			response.sendRedirect("/JavaWebTask_Group13/Details?id=" + id);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
