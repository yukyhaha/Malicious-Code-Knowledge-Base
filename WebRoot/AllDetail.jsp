<%@ page contentType="text/html;charset=GB2312" language="java" import="java.util.*,com.malc.vo.*" pageEncoding="gb2312"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'AllDetail.jsp' starting page</title>
    
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
<form name="form1" action="xiugai.jsp" method="post">
 <%   
     request.setCharacterEncoding("GB2312"); 
   
      MalcVo mv=new  MalcVo();
      mv=(MalcVo)request.getAttribute("adetail"); 
      
      %> 
       </br></br>
  <table style="width: 598px; height: 201px;" width="598" height="201">
<tr>
<td><strong>恶意代码编号</strong></td>
<td><strong>名称</strong></td>
<td><strong>种类</strong></td>
<td><strong>输入时间</strong></td>
<td><strong>输出时间</strong></td>



</tr> 
<tr><td>&nbsp;</td></tr>

<tr><td><%=mv.getSnumber()%></td>
      <td> <%=mv.getName()%></td>
        <td> <%=mv.getKind()%></td>
         <td> <%=mv.getS_time() %></td>
          <td> <%=mv.getE_time()%></td>
           
           </tr>
<tr><td>&nbsp;</td></tr>
<tr> <td><strong>详情:</strong></td> </tr>
<tr><td>&nbsp;</td></tr>

<tr> <td><%=mv.getDetail()%></td></tr>
</table>

<input type="hidden" name="sn" value="<%=mv.getSnumber()%>"/>
<input type="hidden" name="name" value="<%=mv.getName()%>"/>

<input type="hidden" name="kind" value="<%=mv.getKind()%>"/>

<input type="hidden" name="stime" value="<%=mv.getS_time() %>"/>

<input type="hidden" name="etime" value="<%=mv.getE_time()%>"/>
<input type="hidden" name="detail" value="<%=mv.getDetail()%>"/>


<input type="submit" value="修改"/>

  </form>
  </body> 
   
 
</html>
