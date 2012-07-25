<%@ page language="java" import="java.util.*,com.malc.vo.*" pageEncoding="gb2312"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'cha_result.jsp' starting page</title>
    
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
	font-size: 24px;
	font-weight: bold;
}
-->
    </style>
</head>
  
  <body background="./images/bg5.jpg">

  <p>
    <%   List<MalcVo> li=(ArrayList)request.getAttribute("list"); %>

 
       <span class="STYLE1">查询结果为</span>：</p>
  <table width="708" height="85">
<tr>
<td width="140">恶意代码编号</td>
<td width="119">名称</td>
<td width="119">种类</td>
<td width="133">输入时间</td>
<td width="133">输出时间</td>
<td width="37">详情</td>

</tr> 
 <% 
  MalcVo mv= new MalcVo();
  for (int i=0;i<li.size();i++){

   mv=(MalcVo)li.get(i); %>
<tr><td><%=mv.getSnumber()%></td>
      <td> <%=mv.getName()%></td>
        <td> <%=mv.getKind()%></td>
         <td> <%=mv.getS_time()%></td>
          <td> <%=mv.getE_time()%></td>
            <%if(mv.getDetail().length()<=5){%>
        <td>&nbsp;&nbsp;&nbsp;<%=mv.getDetail() %></td>
        <%}else {%>
         <td>&nbsp;&nbsp;&nbsp;<%=mv.getDetail().substring(0,5) %></td>
        <%} %>
           
</tr>
<%} %>
</table>
  
  
  </body>
</html>
