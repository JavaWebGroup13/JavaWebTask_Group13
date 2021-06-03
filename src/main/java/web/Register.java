package web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.User;
import dao.ArticleDao;
import dao.DaoFactory;
import dao.UserDao;

/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("register.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 获取表单参数
		String username = request.getParameter("username").trim();
		String password1 = request.getParameter("password1").trim();
		String password2 = request.getParameter("password2").trim();
		
		// 信息不完整
		if(username.isEmpty() || password1.isEmpty() || password2.isEmpty()) {
			request.setAttribute("code", -1);
			request.setAttribute("msg", "请填写完整！");
			request.getRequestDispatcher("register.jsp").forward(request, response);
			return;
		}
		
		// 密码不一致
		if(!password1.equals(password2)) {
			request.setAttribute("code", -1);
			request.setAttribute("msg", "两次密码不一致！");
			request.getRequestDispatcher("register.jsp").forward(request, response);
			return;
		}
		
		// 用户名已存在
		UserDao userDao = DaoFactory.getUserDaoInstance();
		User user = userDao.query(username);
		if(user != null) {
			request.setAttribute("code", -1);
			request.setAttribute("msg", "用户已存在:" + username);
			request.getRequestDispatcher("register.jsp").forward(request, response);
			return;
		}
		
		// 注册成功
		user = new User();
		user.setUsername(username);
		user.setPassword(password1);
		user.setAvatar("/static/img/default.png");
		user.setProfile("写点个人简介，帮助别人认识你吧！");
		user.setNickname("叮当猫");
		int res = userDao.insert(user);
		if(res == 0) {
			request.setAttribute("code", 0);
			request.setAttribute("msg", "注册成功！3s后跳转到登录界面");
			request.getRequestDispatcher("register.jsp").forward(request, response);
		}else {
			request.setAttribute("code", -1);
			request.setAttribute("msg", "注册失败！，请联系开发者");
			request.getRequestDispatcher("register.jsp").forward(request, response);
		}
	}

}
