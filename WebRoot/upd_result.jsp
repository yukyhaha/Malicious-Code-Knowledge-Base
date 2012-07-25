<%@ page contentType="text/html;charset=GB2312" language="java" import="java.util.*" pageEncoding="gb2312"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'upd_result.jsp' starting page</title>
    
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
  <form name=form1 action="xiugai.jsp" method="post">
  
  <%            
                request.setCharacterEncoding("GB2312"); 
                
                String sn=(String)request.getAttribute("sn");
				String name=(String)request.getAttribute("mcn");
				String kind=(String)request.getAttribute("kind");
				String st=(String)request.getAttribute("st");
				String et=(String)request.getAttribute("et");
				String detail=(String)request.getAttribute("detail"); %>
				  
<strong>修改成功，信息如下：<br>&nbsp;</strong></br>
<table width="536" height="122">
<tr>
<td><strong>恶意代码编号：</strong><%=sn %></td>	 
<td><strong>名称：</strong><%=name %></td>
</tr>
<tr><td><strong>输入时间：</strong><%=st %></td><td> <strong>输出时间：</strong><%=et %></td></tr>  
<tr><td><strong>详细信息：</strong></td></tr>
<tr><td><%=detail %></td></tr>
</table>
 <input type="hidden" name="sn" value="<%=sn%>"/>
<input type="hidden" name="name" value="<%=name%>"/>

<input type="hidden" name="kind" value="<%=kind%>"/>

<input type="hidden" name="stime" value="<%=st %>"/>

<input type="hidden" name="etime" value="<%=et%>"/>
<input type="hidden" name="detail" value="<%=detail%>"/>
</br></br>
<input type="submit" value="继续修改"/>

  </form>
  </body>
</html>
