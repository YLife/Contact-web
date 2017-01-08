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
		//�����������
		int rowCount = dao.list().size();
		//��ҳ����
		Pagination pag = new Pagination(request, response, rowCount);
		//��õ�ǰҳ����
		List<AddressInfo> data = dao.page(pag.getPageNo(), pag.getPageSize());
		System.out.println(data.size());
		//������
		request.setAttribute("pag", pag);
		request.setAttribute("data", data);
		//ת��
		request.getRequestDispatcher("index2.jsp").forward(request, response);
	}

}
