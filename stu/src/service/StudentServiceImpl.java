package service;
import java.sql.SQLException;
import java.util.List;
import dao.StudentDao;
import dao.impl.StudentDaoImpl;
import domain.Student;
/*
 * 这是学生业务实现
 * 
 */
public class StudentServiceImpl implements StudentService{

	//查询所有学生      
		@Override
		public List<Student> findAll() throws SQLException{
			//面向接口编程
			StudentDao dao=new StudentDaoImpl();  //我通过service去找dao的东西
			return dao.findAll();  //直接返回就行
		}

		@Override
		public void insert(Student student) throws SQLException {
			//面向接口编程
			StudentDao dao=new StudentDaoImpl();  //我通过service去找dao的东西
			 dao.insert(student);  // 把传进来的对象加方法里面
		}

		@Override
		public void delete(int sid) throws SQLException {
			StudentDao dao=new StudentDaoImpl();  //我通过service去找dao的东西
			 dao.delete(sid);  // 把传进来的对象加方法里面
			
		}

		@Override
		public Student findStudentById(int sid) throws SQLException {
			StudentDao dao=new StudentDaoImpl();  //我通过service去找dao的东西
			 return dao.findStudentById(sid);  // 把传进来的对象加方法里面
		}

		@Override
		public void update(Student student) throws SQLException {
			StudentDao dao=new StudentDaoImpl();  //我通过service去找dao的东西
			  dao.update(student);  // 把传进来的对象加方法里面
		}

		@Override
		public List<Student> searchStudent(String sname, String sgender) throws SQLException {
			StudentDao dao=new StudentDaoImpl();  //我通过service去找dao的东西
			 return dao.searchStudent(sname,sgender);// 把传进来的对象加方法里面
		}
		
		
}
