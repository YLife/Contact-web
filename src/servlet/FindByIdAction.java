package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AddressInfoDao;
import entity.AddressInfo;

public class FindByIdAction extends HttpServlet {
	private AddressInfoDao dao = new AddressInfoDao();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");
		int id = Integer.parseInt(request.getParameter("id"));
		AddressInfo info = dao.findById(id);
		request.setAttribute("id", info);
		if ("edit".equals(request.getParameter("action"))) {
			System.out.println(request.getParameter("action"));
			request.getRequestDispatcher("edit.jsp").forward(request, response);			
		}
		if ("del".equals(request.getParameter("action"))) {
			request.getRequestDispatcher("del.jsp").forward(request, response);
		}
	}

}
