<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'ruku.jsp' starting page</title>
    
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
.STYLE1 {font-size: medium}
-->
    </style>
</head>
  
  <body background="./images/bg5.jpg">
  <form name="form1" action="./MalcServlet" method="post"> 
    <p>&nbsp;</p>
    <table> 
<tr><td height="48"><span class="STYLE1">Â·¾¶£º</span> </td>
<td><input type="file" name="path" size="30" maxlength="80"/></td>
</tr>
<tr>
&nbsp;&nbsp;
</tr>
<tr align="center"> 
<td height="37"></td>
<td><p><input type="hidden" name="opflag" value="ruku"> 
  <input type="submit" value="Èë¿â" ></p></td></tr>
</table> 
  </form>
  </body>
</html>
