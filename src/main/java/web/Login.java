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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 转发到登录界面
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 处理用户登录请求

		/*String isLogin = "false";
		
		Cookie[] cookies = request.getCookies();
		for(int i = 0; cookies != null && i < cookies.length; i++) {
			if("isLogin".equals(cookies[i].getName())) {
				isLogin = cookies[i].getValue();
			}
			System.out.println("cookie:" + cookies[i].getName());
		}*/
		
		// 获取表单参数
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		// 获取用于操作用户UserDao实例
		UserDao userDao = DaoFactory.getUserDaoInstance();

		try {
			// 使用username password进行登录
			User user = userDao.login(username, password);

			// 用户登录失败
			if(user == null) {
				// 跳转到登录界面
				response.sendRedirect("/JavaWebTask_Group13/Login");
				return;
			}

			// 用户登录成功
			HttpSession session = request.getSession();
			session.setAttribute("isLogin", true);
			// 保存用户信息
			session.setAttribute("user", user);
			
			// 设置客户端Cookie
			Cookie cookie = new Cookie("isLogin", "true");
			// 7天过期
			cookie.setMaxAge(60 * 60 * 24 * 7);
			response.addCookie(cookie);

			response.sendRedirect("/JavaWebTask_Group13/Center");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
