package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AddressInfoDao;
import entity.AddressInfo;

public class AddAction extends HttpServlet {
	private AddressInfoDao dao = new AddressInfoDao();
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		//��ȡ������
		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		AddressInfo info = new AddressInfo(0, name, phone);
		//ִ�����ݵ����
		int row = dao.save(info);
		//��ת���б�
		if (row == 1) {
			response.sendRedirect("list.action");
		}else {
			out.print("������ϵ��ʧ�� ��");
		}
	}

}
