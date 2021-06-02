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
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		// 是否已登录
		String isLogin = "false";
		
		Cookie[] cookies = request.getCookies();
		for(int i = 0; cookies != null && i < cookies.length; i++) {
			if("isLogin".equals(cookies[i].getName())) {
				isLogin = cookies[i].getValue();
			}
			System.out.println("cookie:" + cookies[i].getName());
		}
		
		String u = request.getParameter("username");
		String p = request.getParameter("password");
		
		UserDao userDao = DaoFactory.getUserDaoInstance();
		try {
			User user = userDao.login(u, p);
			if (user != null) {
				HttpSession session = request.getSession();
				session.setAttribute("isLogin", true);
				session.setAttribute("user", user);
				
				// 设置已登录状态
				Cookie cookie = new Cookie("isLogin", "true");
				cookie.setMaxAge(60 * 60 * 24 * 7);
				response.addCookie(cookie);
				// 跳转到主页
				response.sendRedirect("/JavaWebTask_Group13/center.jsp");
			}else {
				// 跳转到登录页面
				response.sendRedirect("/JavaWebTask_Group13/login.jsp");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		response.getWriter().append(u).append(p);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
