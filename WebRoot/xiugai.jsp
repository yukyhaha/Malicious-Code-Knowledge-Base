<%@ page language="java" import="java.util.*,com.malc.vo.*" pageEncoding="gb2312"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'xiugai.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body background="./images/bg5.jpg">
  <form name="form1" action="./MalcServlet" method="post">
<% 

 request.setCharacterEncoding("GB2312"); 

String sn=request.getParameter("sn"); 
String name=request.getParameter("name"); 
String kind=request.getParameter("kind"); 
String stime=request.getParameter("stime"); 
String etime=request.getParameter("etime"); 
String detail=request.getParameter("detail"); 

 
%> 
��������ţ�<input type="text" name="s_number" value="<%=sn%>"/> <br></br>
���ƣ�<input type="text" name="mc_name" value="<%=name%>"/> 
���ࣺ<input type="text" name="kind" value="<%=kind%>"/><br></br>
����ʱ�䣺<input type="text" name="s_time" value="<%=stime%>"/>
���ʱ�䣺<input type="text" name="e_time" value="<%=etime%>"/><br><br>
��ϸ��Ϣ��</br><textarea name="detail" rows="5" cros="10"><%=detail%></textarea>

<input type="hidden" name="opflag" value="update"/>
<input type="hidden" name="ssn" value="<%=sn%>"/>

</br></br>
<input type="submit" name="sb" value="�ύ�޸� "/>
</form>
  </body>
</html>
