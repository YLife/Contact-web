package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AddressInfoDao;
import entity.AddressInfo;

public class EditAction extends HttpServlet {
	private AddressInfoDao dao = new AddressInfoDao();
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/htmll;charset=UTF-8");
		PrintWriter out = response.getWriter();
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		AddressInfo info = new AddressInfo(id, name, phone);
		int row = dao.update(info);
		if (row == 1) {
			response.sendRedirect("list.action");
		}
		out.print("修改联系人失败 !");
	}

}
