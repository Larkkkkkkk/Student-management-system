<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>        <!-- 下面要使用JSTL里面的c:if标签 解决男女选项问题 -->
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>   <!-- 下面要使用JSTL里面的c:if标签  解决爱好问题-->
   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>这是更新学生页面</title>
</head>
<body>
	<h3>更改学生页面:</h3>

  <form method="post" action="UpdateServlet">  
  
  	<input type="hidden" name="sid" value="${stu.sid}">  <!--我们在提交的页面也提交上去sid 方便后面给servlet 但是用hidden隐藏 -->
  
	<table border="1" width="700px">    <!-- 使用EditPlus软件写框架 -->
  		<tr>
			<td>姓名</td>
			<td><input type="text" name="sname" value="${stu.sname }"></td>   <!-- 普通框  直接设定value值 -->
  		</tr>
 		 <tr>
			<td>性别</td>
			<td>              <!-- 单选框 可以简单地在后面加checked 也可以通过c标签 -->
					<input type="radio" name="gender" value="男" <c:if test="${stu.gender=='男'}">checked</c:if>>男     	
					<input type="radio" name="gender" value="女" <c:if test="${stu.gender=='女'}">checked</c:if>>女
			</td>			
  		</tr>
  		<tr>
			<td>电话</td>
			<td><input type="text" name="phone" value="${stu.phone }"></td>
 		 </tr>
 		 <tr>
			<td>生日</td>
			<td><input type="text" name="birthday" value="${stu.birthday }"></td>
 		 </tr>
 		 <tr>
			<td>爱好</td>
			<td>             <!-- 复选框 可以简单地在后面加checked 也可以通过调用方法 fn：contains(原始字符串,要查找的子字符串)-->
				<input type="checkbox" name="hobby" value="游泳" <c:if test="${fn:contains(stu.hobby,'游泳') }">checked</c:if>>游泳  
				<input type="checkbox" name="hobby" value="篮球" <c:if test="${fn:contains(stu.hobby,'篮球') }">checked</c:if>>篮球
				<input type="checkbox" name="hobby" value="足球" <c:if test="${fn:contains(stu.hobby,'足球') }">checked</c:if>>足球
				<input type="checkbox" name="hobby" value="看书" <c:if test="${fn:contains(stu.hobby,'看书') }">checked</c:if>>看书
				<input type="checkbox" name="hobby" value="写字" <c:if test="${fn:contains(stu.hobby,'写字') }">checked</c:if>>写字
			</td>
  		</tr>
  		<tr>
			<td>简介</td>
			<td><textarea name="info" rows="3" cols="20">${stu.info }</textarea></td>   <!-- 文本框 直接在标签外加 -->
  		</tr>
  		<tr>
			<td colspan="2"><input type="submit" value="添加"></td>	
    	</tr>
  </table>
 </form>	
</body>
</html>