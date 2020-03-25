package servlet;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import domain.Student;
import service.StudentService;
import service.StudentServiceImpl;
public class StudentListServlet extends HttpServlet {
	/*
	 *负责查询所有的学生信息 然后给到list.jsp页面
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		try {
			//1.查询出所有学生
				StudentService service=new StudentServiceImpl();  //Servlet去找service  然后他会去找dao层
				List<Student> list = service.findAll();
			
			//2.先把数据存到作用域中
				request.setAttribute("list", list);
				
			//3.有结果了--跳转
				request.getRequestDispatcher("list.jsp").forward(request, response);
				
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
					
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
