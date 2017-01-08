package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AddressInfoDao;
import entity.AddressInfo;
import util.Pagination;

public class ListAction extends HttpServlet {
	private AddressInfoDao dao = new AddressInfoDao();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		//获得数据行数
		int rowCount = dao.list().size();
		//分页处理
		Pagination pag = new Pagination(request, response, rowCount);
		//获得当前页数据
		List<AddressInfo> data = dao.page(pag.getPageNo(), pag.getPageSize());
		System.out.println(data.size());
		//传数据
		request.setAttribute("pag", pag);
		request.setAttribute("data", data);
		//转发
		request.getRequestDispatcher("index2.jsp").forward(request, response);
	}

}
