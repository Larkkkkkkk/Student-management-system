package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Student;
import service.StudentService;
import service.StudentServiceImpl;

/*
 * 用于从list.jsp点击更新之后又弹到Edit.serlvet--通过sid查询存储跳转到edit.jsp显示--然后表单提交到此servlet--然后要通过sid取更新数据
 */
public class UpdateServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//一定要写提交中文!!!
		request.setCharacterEncoding("utf-8");
	
	//1.获取客户端提交上来的数据
		int sid=Integer.parseInt(request.getParameter("sid"));   //添加要有sid!!!!!
		String sname=request.getParameter("sname");
		String gender=request.getParameter("gender");
		String phone=request.getParameter("phone");
		String info=request.getParameter("info");
		String birthday=request.getParameter("birthday");  //1999-07-07---- 需要字符串转date
		//String hobby=request.getParameter("hobby");  //有很多选项---需要用数组去存
		String[] h=request.getParameterValues("hobby"); //获取值存放成数组形式--[篮球,足球,游泳]
		String hobby=Arrays.toString(h);  //存放成--[篮球,足球,游泳]
			hobby=hobby.substring(1,hobby.length()-1);
				
	//2.添加到数据库	
		try {
				//birthday需要从string转date
					Date date= new SimpleDateFormat("yyyy-MM-dd").parse(birthday);
			
					Student student=new Student(sid,sname,gender,phone,hobby,info,date);  //然后给一个student对象  里面用有参构造方法去将客户端提交的数据存下来
				
					//需要更新数据库数据
					
					StudentService service=new StudentServiceImpl();	 //然后通过service去找dao解决
					
			try {
				service.update(student);  //service找它的insert方法 --service的实现类又要去找dao
			} catch (SQLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}  //service去找dao实现
			
		} catch (ParseException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	
	//3.跳转到列表页
		request.getRequestDispatcher("StudentListServlet").forward(request, response);  //表单跳到Studentservlet 查询完数据库 然后Servlet在跳list.jsp页面
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
