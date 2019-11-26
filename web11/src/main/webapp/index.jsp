<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<body>
<h2>Hello World!</h2>
<p align="center">增加产品</p>
<hr/>
<form action=””  method=”get/post”>
产品编码：<input type=”text” name=”firstnumber” ><br/>
产品名称：<input type=”text” name=”firstname”><br/>
产品标准：
<input type="radio" name="sex" value="male" checked>国际
<input type="radio" name="sex" value="female">美标
<br/>
产品用途：
<input type="checkbox" name="vehicle" value="Bike">食品

<input type="checkbox" name="vehicle" value="Car">化工
<input type="checkbox" name="vehicle" value="C">机械
<input type="checkbox" name="vehicle" value="ar">电子
<input type="checkbox" name="vehicle" value="r">材料
<br/>
产品单价：<input type=”text” name=”firstprice” ><br/>
<input type="submit" value="提交按钮"><br/></form>
<hr/>
</body>
</html>
