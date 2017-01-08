package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.account.*;
import entity.Account;

public class CheckCodeAction extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		String user = request.getParameter("user");
		String pwd = request.getParameter("pwd");
		String checkNo = request.getParameter("checkNo");
		Dao dao = new Dao();
		Account acc = dao.queryByUser(user);
		if (acc != null) {
			if (pwd != null && pwd.equals(acc.getPwd())) {
				String code = (String) session.getAttribute("code");
				if (checkNo.equalsIgnoreCase(code)) {
					session.setAttribute("currentUser", user);
					Cookie ckUser = new Cookie("user", user);
					ckUser.setMaxAge(24 * 60 * 60);
					Cookie ckPwd = new Cookie("pwd", pwd);
					ckPwd.setMaxAge(24 * 60 * 60);
					response.addCookie(ckUser);
					response.addCookie(ckPwd);
					response.sendRedirect("list.action");
				}
				out.print("验证码有误 !");
			} else {
				out.print("密码错误 !");
			}
		} else {
			out.print("账户不存在 !");
		}
	}

}
