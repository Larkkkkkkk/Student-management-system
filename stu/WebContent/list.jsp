<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  <!--导入jar包 方便使用el表达式和jstl -->
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学生列表页面</title>

	<script type="text/javascript">
	  function doDelete(sid){
		var flag=confirm("是否确定删除？");  //框框的提示语
			if(flag)
			{
				window.location.href="DeleteServlet?sid="+sid; //在当前标签页上打开超链接 --- http://localhost:8080/stu/DeleteServlet?sid=4   获取到sid等于4
			}		
		}
	</script>

</head>

<body>
  <form action="SearchStudentServlet" method="post">    <!-- 新建表单  模糊查询建立-->
	<table border="1" width="700px">   
	
		<tr >
			<td colspan="8">   <!-- 合并列 -->
		
				按姓名查询:<input type="text" name="sname">
				按性别查询:<select name="sgender">
							<option value="">请选择</option>
							<option value="男">男</option>
							<option value="女">女</option>
					      </select>
					      &nbsp;&nbsp;&nbsp;
					       <input type="submit" value="查询">
					      &nbsp;&nbsp;&nbsp;
						   <a href="add.jsp">添加</a>     <!-- 点添加--跳转到添加页面 -->
							
			</td>
		</tr>
	
		<tr align="center">  <!-- 内容居中 -->
			<td>编号</td>
			<td>姓名</td>
			<td>性别</td>
			<td>电话</td>
			<td>生日</td>
			<td>爱好</td>
			<td>简介</td>
			<td>操作</td>
		</tr>
		
		<c:forEach items="${list}" var="stu">  <!-- JSTL内部的内置标签  items指的是存放的list  而var指的是把存的list集合给stu  -->
		<tr align="center">   <!-- 内容居中 -->
			<td>${stu.sid}</td>    <!-- 通过EL表达式 因为没有下标所以要用.的形式 -->
			<td>${stu.sname}</td>
			<td>${stu.gender}</td>
			<td>${stu.phone}</td>
			<td>${stu.birthday}</td>
			<td>${stu.hobby}</td>
			<td>${stu.info}</td>
			<td>
					<a href="EditServlet?sid=${stu.sid}">更新</a>         <!-- 更新  先要去查数据库填了数据再跳转   -->    
					<a href="#" onclick="doDelete(${stu.sid})">删除</a>   <!-- 删除  需要通过超链接去找js事件代码去弹框获取sid给servlet -->    
			</td>   
		</tr>
		</c:forEach>
		
	</table>
  </form>	
</body>
</html>