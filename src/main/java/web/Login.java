package web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.User;
import dao.DaoFactory;
import dao.UserDao;
import utils.Encryption;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Login() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 请求转发到登录界面
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		// 获取表单参数
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		// 信息不完整
		if (username.isEmpty() || password.isEmpty()) {
			request.setAttribute("code", -1);
			request.setAttribute("msg", "请填写完整！");
			request.getRequestDispatcher("login.jsp").forward(request, response);
			return;
		}
		// 获取用于操作用户UserDao实例
		UserDao userDao = DaoFactory.getUserDaoInstance();
		try {
			// 登录
			User user = userDao.login(username, password);
			// 用户登录失败，跳转到登录界面
			if (user == null) {
				request.setAttribute("code", -1);
				request.setAttribute("msg", "登录失败，请检查用户名或密码");
				request.getRequestDispatcher("login.jsp").forward(request, response);
				return;
			}
			// 保存用户信息
			request.getSession().setAttribute("user", user);
			// 生成token
			String token = Encryption.encrypByMD5(username + Encryption.encrypByMD5(password));
			System.out.println("Login -> username:" + username);
			System.out.println("Login -> password:" + Encryption.encrypByMD5(password));
			System.out.println("Login -> token:" + token);
			// 设置客户端Cookie
			Cookie cookie1 = new Cookie("userid", user.getId() + "");
			Cookie cookie2 = new Cookie("token", token);
			// 7天过期
			cookie1.setMaxAge(60 * 60 * 24 * 7);
			cookie2.setMaxAge(60 * 60 * 24 * 7);
			response.addCookie(cookie1);
			response.addCookie(cookie2);
			// 跳转到登录界面，由登录界面进一步跳转
			request.setAttribute("code", 0);
			request.setAttribute("msg", "登录成功，3s后跳转到用户中心界面");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
