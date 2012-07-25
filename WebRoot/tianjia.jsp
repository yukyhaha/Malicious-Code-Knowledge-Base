<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'tianjia.jsp' starting page</title>
    
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
	font-size: medium;
	font-weight: bold;
}
-->
    </style>
</head>
  
  <body background="./images/bg5.jpg">
   <script type="text/javascript" language="javascript" src="calendar.js"></script>
     <span class="STYLE1">请输入您想要添加的恶意代码的信息：</span>
  <form name="chaxun" action="./MalcServlet" method="post">  
     </br>恶意代码的序列号：
      <input type="text" name="s_number">
     </br>名称：
      <input type="text" name="mc_name">
     </br> 类型：
      <input type="text" name="kind">
     </br> 输入时间：
    
     <input type="text" name="s_time" onfocus="setday(this)"   />
     </br> 
输出时间：
     <input type="text" name="e_time" onfocus="setday(this)" >
     </br> 详细信息：</br> 
     &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <textarea name="detail" cos="60" rows="5"></textarea>
         
    <input type="hidden" name="opflag" value="add">

    </br></br>
     &nbsp; &nbsp; &nbsp; &nbsp;
     <input type="submit" value="确认添加">
  </form>
  </body>
</html>
