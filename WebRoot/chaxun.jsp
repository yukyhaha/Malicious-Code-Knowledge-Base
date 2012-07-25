<%@ page contentType="text/html;charset=GB2312" language="java" import="java.util.*" pageEncoding="gb2312"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
request.setCharacterEncoding("GB2312"); 
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'chaxun.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
    <style type="text/css">
<!--
.STYLE1 {
	font-size: large;
	font-weight: bold;
}
-->
    </style>
</head>
  
  <body background="./images/bg5.jpg"> 
            <span class="STYLE1">请填入查询的范围：            </span>
            <form name="querry" action="./MalcServlet" method="post">  
   </br>
   <p>恶意代码的序列号： 
     <input type="text" name="s_number"><br></p><p> 
     名称： 
     <input type="text" name="mc_name"> <br></p><p>类型： 
     <input type="text" name="kind"> <br></p><p>输入时间： 
     <input type="text" name="s_time">&nbsp;&nbsp;&nbsp; 
     输出时间： 
     <input type="text" name="e_time">&nbsp;</p><p>&nbsp;
     <input type="hidden" name="opflag" value="querry"> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; <br></p><p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input type="submit" value="开始查询"> 
   </p>
  </form>
  </body>
</html>
