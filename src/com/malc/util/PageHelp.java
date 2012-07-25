package com.malc.util;


public class PageHelp {
  private static int currentpage;    	//当前页，要用set方法赋值
  private static int recordcount;		//记录的总条数，要用set方法赋值
  private String condition;				// 记录当前的查询条件，要用set方法赋值
  private java.util.List objectlist;	//装载着要显示的信息，要用set方法赋值
  
  private static int pagecount; 		//共有页数，页总数，有其他属性计算得出
  public static int pagesize=6;			//每页显示记录数，系统统一的显示条数设置
  private String pagebar="";			//分页操作条

  
  public PageHelp() {
	
  }
  public PageHelp(int currentpage,int recordcount,String condition,java.util.List objectlist) {
	  this.currentpage=currentpage;
	  this.recordcount=recordcount;
	  this.condition=condition;
	  this.objectlist=objectlist;
	  getPagecount(); //计算页数               
	  setPagebar();	//生成分页条
  }

  public int getCurrentpage() {
    return currentpage;
  }

  public void setCurrentpage(int currentpage) {
    PageHelp.currentpage = currentpage;
  }



  public int getPagecount() {//通过计算 页数=记录总数/每页显示条数 获得页码
    if (PageHelp.recordcount % PageHelp.pagesize == 0) {
      PageHelp.pagecount = PageHelp.recordcount / PageHelp.pagesize;
    }
    else {
      PageHelp.pagecount = PageHelp.recordcount / PageHelp.pagesize + 1;
    }

    return pagecount;
  }

  public void setPagecount(int pagecount) {//设置页码值
    PageHelp.pagecount = pagecount;
  }
  public int getRecordcount() {
    return recordcount;
  }

  public void setRecordcount(int recordcount) {
    PageHelp.recordcount = recordcount;
  
  }

  public int getPagesize() {//每页显示的记录条数
    return pagesize;
  }

  public void setPagesize(int pagesize) {
    PageHelp.pagesize = pagesize;
  }

  public java.util.List getObjectlist() {
    return objectlist;
  }

  public void setObjectlist(java.util.List objectlist) {
	 this.objectlist = objectlist;
  }


  public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}
  /**
   * ShowDivPagebar 显示分页链接条（首页　上一页　下一页　尾页）
   *
   * @param pageName String　当前URL的名称
   * @param ListType int　页面分类标识
   * @param pageCount int　共有页数
   * @param currPage int　当前页
   * @return String
   */
  public void setPagebar() {//显示首页、上一页、下一页、尾页，当前多少页、共多少页等的分页条
    String strResult = "";
    if (PageHelp.currentpage <= 1) {//如果list表中记录数可以在一页中显示，则上一页，首页无链接

      strResult = strResult + "首页   上一页 ";
    } else {//如果结果集中记录数超出一页，则有链接，可以分页显示
      strResult = "<a href='#' onClick='return changpage(1)'><font color='red'>首页</font></a> ";
      strResult += "<a href='#' onClick='return changpage("+(PageHelp.currentpage - 1)+")'><font color='red'>上一页</font><a> ";
    }
    if (PageHelp.currentpage >= PageHelp.pagecount) {//如果当前页是显示的最后一页，则下一页，尾页无链接
      strResult += " 下一页 尾页 ";
    }else {//否则，只要记录不是最后一页都有链接实现点击分页
      strResult += "<a href='#' onClick='return changpage(" +(PageHelp.currentpage + 1) + ")'><font color='red'>下一页</font><a> ";
      strResult += "<a href='#' onClick='return changpage(" + PageHelp.pagecount + ")'><font color='red'>尾页</font><a> ";
    }
    strResult = strResult + "第<font color='red'>" + PageHelp.currentpage + "</font>页（共<font color='red'>" + PageHelp.recordcount +
        "</font>条记录，分<font color='red'>" + PageHelp.pagecount + "</font>页显示，每页至多<font color='red'>" + PageHelp.pagesize + "</font>条记录）";
   if(PageHelp.pagecount>1)
	   this.pagebar = strResult;
    }
  public String getPagebar() {
	    return pagebar;
	  }
}