<%@ page language="java" import="java.util.*,java.sql.*,com.malc.db.*,com.malc.util.*,com.malc.dao.*,com.malc.vo.*" pageEncoding="gb2312"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  <meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  
    <base href="<%=basePath%>">
    
    <title>My JSP 'user_view.jsp' starting page</title>

   <script>
         function changpage(currentpage){
		document.formpage.currentPage.value=currentpage;
		document.formpage.submit();
		return false;
}
function checkEvent(name,allCheckId)
{
  var allCk=document.getElementById(allCheckId);
  if(allCk.checked==true)
  checkAll(name);
  else
  checkAllNo(name);
  
}

function checkAll(name)
{
  var names=document.getElementsByName(name);
  var len=names.length;
  if(len>0)
  {
   var i=0;
   for(i=0;i<len;i++)
   names[i].checked=true;
    
  }
}

function checkAllNo(name)
{
  var names=document.getElementsByName(name);
 var len=names.length;
 if(len>0)
  {
    var i=0;
    for(i=0;i<len;i++)
    names[i].checked=false;
  }
}


</script>
    
	
  </head>
  <body background="./images/bg5.jpg">
  <form name="form1" method="post" action="./MalcServlet">
    <table>
   
      <tr>
        <td colspan="11" align="center">&nbsp;<font size="5"><strong>恶意代码信息</strong></font></td>
      </tr>
      <tr>
        <td><input type="checkbox" id="ckall" onclick="checkEvent('checkck','ckall')" /><font size="3">全选</font></td>
        <td align="left"><font size="3">&nbsp;&nbsp;&nbsp;</font>恶意代码编号</td>
        <td align="left">&nbsp;&nbsp;&nbsp;恶意代码名称</td>
        <td>&nbsp;&nbsp;&nbsp;种类</td>
        <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;输入时间</td>
        <td>&nbsp;&nbsp;&nbsp;输出时间</td>
      
        
       
      </tr>

     
     
    <tr> 


	<%	
			PageHelp pagehelp=null;
			List list =null;
				pagehelp=(PageHelp)request.getAttribute("pagehelp");
				
				if(pagehelp==null){
					int currentPage=1;
					MalcDao malcdao = new MalcDao();
					pagehelp =malcdao.querymalc("",currentPage);
				}
				list=pagehelp.getObjectlist();
			Iterator it =list.iterator();
			while(it.hasNext()){
				MalcVo malcvo=(MalcVo)it.next();
			
			%>
			</tr>
 <tr>
        <td><input name="checkck" type="checkbox" value="<%=malcvo.getSnumber() %>"></input></td>
        <td>&nbsp;&nbsp;&nbsp;<%=malcvo.getSnumber() %></td>
        <td>&nbsp;&nbsp;&nbsp;<%=malcvo.getName() %></td>
        <td>&nbsp;&nbsp;&nbsp;<%=malcvo.getKind() %></td>
        <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<%=malcvo.getS_time() %></td>
        <td>&nbsp;&nbsp;&nbsp;<%=malcvo.getE_time() %></td>
      
        
       <td>&nbsp;&nbsp;&nbsp;<a href="./MalcServlet?opflag=Adetail&sn=<%=malcvo.getSnumber() %>">查看详细</a></td>
       
      </tr>
       
       <%
        }
      
       %>
     <tr><td>&nbsp;</td></tr>

      <tr>
        <td><input type="submit" value="删除"  /> </td>
    
        <td> <input type="hidden" name="opflag" value="del"/></td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
        <td></td>
       
      </tr>
     
    </table>
     </form>
  

 <form name="formpage" action="./MalcServlet" method="post">
  
            <input type="hidden" name="opflag" value="changePage"/>
			<input type="hidden" name="currentPage" value="<%=pagehelp.getCurrentpage() %>"/> 
			<input type="hidden" name="condi" value="<%=pagehelp.getCondition()%>"/>
            <table align="center">
            <tr>
			<td height="25" cols="3"><font size="4"><%=pagehelp.getPagebar()%></font><br></td>
		     </tr>
	 </table>	
 </form>
 

 
 
 
 

 
  </body>
</html>
