package servlet;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import domain.Student;
import service.StudentService;
import service.StudentServiceImpl;
/**
 * 处理单个学生信息--查询出信息跳转到更新       比起全部弹出多了一步就是先要接收sid
 */
public class EditServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//1.接收sid
		int sid=Integer.parseInt(request.getParameter("sid"));  //获取sid
		
		//2.通过service去解决 
		StudentService service=new StudentServiceImpl();
		try {
			Student stu=service.findStudentById(sid);
			
		//3.先把数据存到作用域中
			request.setAttribute("stu", stu);

		//4.跳转页面
			request.getRequestDispatcher("edit.jsp").forward(request, response);
			
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
