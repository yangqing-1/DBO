<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>Hello World!</h2>
<p align="center">增加产品</p>
<hr/>
<form action="add.do" method="post" enctype="multipart/form-data">
产品编码：<input type="text" name="number" ><br/>
产品名称：<input type="text" name="name"><br/>
产品单价：<input type="text" name="price"><br/>
产品照片：
<input type="file" name="photo" /></br>
<input type="submit" value="提交按钮"><br/></form>
<hr/>

</body>
</html>