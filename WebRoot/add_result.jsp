<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'add_result.jsp' starting page</title>
    
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
.STYLE1 {font-size: 36px}
-->
    </style>
</head>
  
  <%              request.getAttribute("sn");
				request.getAttribute("mcn");
				request.getAttribute("kind");
				request.getAttribute("st");
				request.getAttribute("et");
				request.getAttribute("detail"); %>
				  
  <body background="./images/bg5.jpg">
  
  <%            String sn=(String)request.getAttribute("sn");
				String name=(String)request.getAttribute("mcn");
				String kind=(String)request.getAttribute("kind");
				String st=(String)request.getAttribute("st");
				String et=(String)request.getAttribute("et");
				String detail=(String)request.getAttribute("detail"); %>
				  
<strong>��ӳɹ�����Ϣ���£�<br>&nbsp;</strong></br>
<table width="536" height="122">
<tr>
<td><strong>��������ţ�</strong><%=sn %></td>	 
<td><strong>���ƣ�</strong><%=name %></td>
</tr>
<tr><td><strong>����ʱ�䣺</strong><%=st %></td><td> <strong>���ʱ�䣺</strong><%=et %></td></tr>  
<tr><td><strong>��ϸ��Ϣ��</strong></td></tr>
<tr><td><%=detail %></td></tr>
</table>
 
</br></br>
<a href="tianjia.jsp">�������</a>

 
  </body>
</html>
