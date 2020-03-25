package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.StudentService;
import service.StudentServiceImpl;

/**
 *   用于删除学生
 */
public class DeleteServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.接收sid
		int sid =Integer.parseInt(request.getParameter("sid"));
		
		//2.通过service去解决 
		StudentService service=new StudentServiceImpl();
		try {
			service.delete(sid);  //service 去找dao层解决
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
		//3.跳转页面
		request.getRequestDispatcher("StudentListServlet").forward(request, response);  //表单跳到Studentservlet 查询完数据库 然后Servlet在跳list.jsp页面
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
