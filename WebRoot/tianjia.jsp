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
     <span class="STYLE1">����������Ҫ��ӵĶ���������Ϣ��</span>
  <form name="chaxun" action="./MalcServlet" method="post">  
     </br>�����������кţ�
      <input type="text" name="s_number">
     </br>���ƣ�
      <input type="text" name="mc_name">
     </br> ���ͣ�
      <input type="text" name="kind">
     </br> ����ʱ�䣺
    
     <input type="text" name="s_time" onfocus="setday(this)"   />
     </br> 
���ʱ�䣺
     <input type="text" name="e_time" onfocus="setday(this)" >
     </br> ��ϸ��Ϣ��</br> 
     &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <textarea name="detail" cos="60" rows="5"></textarea>
         
    <input type="hidden" name="opflag" value="add">

    </br></br>
     &nbsp; &nbsp; &nbsp; &nbsp;
     <input type="submit" value="ȷ�����">
  </form>
  </body>
</html>
