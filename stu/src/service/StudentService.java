package service;
import java.sql.SQLException;
/*
 * 这是学生业务的业务处理规范
 */
import java.util.List;
import domain.Student;
public interface StudentService {
	
	//展示所有学生信息
		 List<Student> findAll() throws SQLException;  //返回肯定需要list集合 元素一定是Student类给的--去写一个Student类	
	
	//根据id查询单个学生对象
		Student	findStudentById(int sid) throws SQLException; 	 
		 
	//添加
		 void insert(Student student)throws SQLException; 
		 
	//删除(根据sid删除)
		 void delete(int sid)throws SQLException;
		
	//更新
		 void update(Student student) throws SQLException;	 
		 
	//模糊查询(根据姓名/性别查询  可能有多个选项)
		 List<Student> searchStudent(String sname,String sgender) throws SQLException;	 
		 
}
