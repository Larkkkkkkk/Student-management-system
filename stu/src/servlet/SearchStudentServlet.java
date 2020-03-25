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

/**
 *  模糊查询
 */
public class SearchStudentServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//一定要写提交中文!!!
				request.setCharacterEncoding("utf-8");
		
		//1.模糊查询通过list.jsp传过来 姓名 + 性别
		String sname=request.getParameter("sname");
		String sgender=request.getParameter("sgender");
		
				try {
					//2.通过service去解决 
						StudentService service=new StudentServiceImpl();
	
						List<Student> list = service.searchStudent(sname,sgender);  //执行方法 获取数据给list
						
					//3.先把数据存到作用域中 (像这种对于更改/查询的话一定会又去一次更改 必须要进行存新的数据)
						request.setAttribute("list",list);		 //要给c:forEach中的items对应
							
					//4.跳转
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
