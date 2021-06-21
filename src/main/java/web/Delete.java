package web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.User;
import dao.ArticleDao;
import dao.CommentDao;
import dao.DaoFactory;

/**
 * Servlet implementation class Delete
 */
@WebServlet("/Delete")
public class Delete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Delete() {
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
		String type = request.getParameter("type");
		System.out.println("Delete -> type: 删除" + type);
		// 删除文章
		if("article".equals(type)) {
			try{
				int articleid = Integer.parseInt(request.getParameter("articleid"));
				ArticleDao articleDao = DaoFactory.getArticleDaoInstance();
				articleDao.delete(articleid);
				System.out.println("Delete -> 删除文章成功，文章ID：" + articleid);
				request.getRequestDispatcher("delete.jsp").forward(request, response);
				return;
			}catch(Exception e) {}
		}
		// 删除评论
		if("comment".equals(type)) {
			System.out.println("Delete -> 删除评论");
			try{
				int articleid = Integer.parseInt(request.getParameter("articleid"));
				int commentid = Integer.parseInt(request.getParameter("commentid"));
				CommentDao commentDao = DaoFactory.getCommentDaoInstance();
				commentDao.delete(commentid);
				System.out.println("Delete -> 删除评论成功，评论ID：" + commentid);
				response.sendRedirect("/JavaWebTask_Group13/Details?id=" + articleid);
				return;
			}catch(Exception e) {}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
