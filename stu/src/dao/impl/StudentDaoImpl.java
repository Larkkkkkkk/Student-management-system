package dao.impl;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import dao.StudentDao;
import domain.Student;
import util.JDBCUtil02;
import util.TextUtil;
/*
 * StudentDao的实现   对于刚才要实现的接口具体实现！
 */
public class StudentDaoImpl implements StudentDao {

	//查询所有学生      
	@Override
	public List<Student> findAll() throws SQLException{
		
		 //1.通过ComboPooledDataSource类获取dataSource
		  //ComboPooledDataSource dataSource =new ComboPooledDataSource(); 
		
		//2.通过jar导入QueryRunner类
		QueryRunner runner=new QueryRunner(JDBCUtil02.getDataSource());    //直接通过写好的类去找datasource
		
		//3.写sql语句 通过list集合去抓取sql的结果
		return runner.query("select * from stu", new BeanListHandler<Student>(Student.class));  //查询所有  使用BeanListHandler
				
	}

	//插入
	@Override
	public void insert(Student student) throws SQLException {
		QueryRunner runner = new QueryRunner(JDBCUtil02.getDataSource());
		
		runner.update("insert into stu values(null , ?,?,?,?,?,?)" ,
				student.getSname(),
				student.getGender(),
				student.getPhone(),
				student.getBirthday(),
				student.getHobby(),
				student.getInfo()
				);
	}

	//删除  直接写语句
	@Override
	public void delete(int sid) throws SQLException {
		QueryRunner runner = new QueryRunner(JDBCUtil02.getDataSource());
		
		runner.update("delete from stu where sid=?",sid);
	}

	//查询一条 相当于查询所有的一条
	@Override
	public Student findStudentById(int sid) throws SQLException {
		QueryRunner runner = new QueryRunner(JDBCUtil02.getDataSource());
		
		return runner.query("select * from stu where sid=?", new BeanHandler<Student>(Student.class),sid);  //查询一条 就用BeanHandler
		
	}

	//更新  相当于新插入了一遍
	@Override
	public void update(Student student) throws SQLException {
		QueryRunner runner = new QueryRunner(JDBCUtil02.getDataSource());
		runner.update("update stu set sname=?,gender=?,phone=?,birthday=?,hobby=?,info=? where sid=?", 
				student.getSname(),
				student.getGender(),
				student.getPhone(),
				student.getBirthday(),
				student.getHobby(),
				student.getInfo(),
				student.getSid()
				);
	}

	//模糊查询
	@Override
	public List<Student> searchStudent(String sname, String sgender) throws SQLException {
		//1.使用DBUtil的语句
		QueryRunner runner = new QueryRunner(JDBCUtil02.getDataSource());
		
		//2.写sql语句
		String sql="select * from stu where 1=1";  //啥也不选就提交就这样的sql语句
		List<String> list=new ArrayList<String>();  //存放传入的sname/sgender
		
		//拼装
		if(!TextUtil.isEmpty(sname))
		{
			sql=sql+" and sname like ?";
			list.add("%"+sname+"%");  //因为like在前面 所以要用%包起来
		}
		if(!TextUtil.isEmpty(sgender))
		{
			sql=sql+" and gender=?";
			list.add(sgender);
		}
		
		//3.添加进去
		return runner.query(sql, new BeanListHandler<Student>(Student.class),list.toArray());  //传入的参数不固定 --要用数组存放(集合.toArray()变为数组)
		
		
	}
	
}
