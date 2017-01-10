package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AddressInfoDao;

public class DelAction extends HttpServlet {
	private AddressInfoDao dao = new AddressInfoDao();
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		int id = Integer.parseInt(request.getParameter("id"));
		int row = dao.del(id);
		if (row == 1) {
			response.sendRedirect("list.action");
		}else {
			out.print("É¾³ýÁªÏµÈËÊ§°Ü £¡");
		}
		
	}

}
