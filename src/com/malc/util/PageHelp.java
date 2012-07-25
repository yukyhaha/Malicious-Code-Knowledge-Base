package com.malc.util;


public class PageHelp {
  private static int currentpage;    	//��ǰҳ��Ҫ��set������ֵ
  private static int recordcount;		//��¼����������Ҫ��set������ֵ
  private String condition;				// ��¼��ǰ�Ĳ�ѯ������Ҫ��set������ֵ
  private java.util.List objectlist;	//װ����Ҫ��ʾ����Ϣ��Ҫ��set������ֵ
  
  private static int pagecount; 		//����ҳ����ҳ���������������Լ���ó�
  public static int pagesize=6;			//ÿҳ��ʾ��¼����ϵͳͳһ����ʾ��������
  private String pagebar="";			//��ҳ������

  
  public PageHelp() {
	
  }
  public PageHelp(int currentpage,int recordcount,String condition,java.util.List objectlist) {
	  this.currentpage=currentpage;
	  this.recordcount=recordcount;
	  this.condition=condition;
	  this.objectlist=objectlist;
	  getPagecount(); //����ҳ��               
	  setPagebar();	//���ɷ�ҳ��
  }

  public int getCurrentpage() {
    return currentpage;
  }

  public void setCurrentpage(int currentpage) {
    PageHelp.currentpage = currentpage;
  }



  public int getPagecount() {//ͨ������ ҳ��=��¼����/ÿҳ��ʾ���� ���ҳ��
    if (PageHelp.recordcount % PageHelp.pagesize == 0) {
      PageHelp.pagecount = PageHelp.recordcount / PageHelp.pagesize;
    }
    else {
      PageHelp.pagecount = PageHelp.recordcount / PageHelp.pagesize + 1;
    }

    return pagecount;
  }

  public void setPagecount(int pagecount) {//����ҳ��ֵ
    PageHelp.pagecount = pagecount;
  }
  public int getRecordcount() {
    return recordcount;
  }

  public void setRecordcount(int recordcount) {
    PageHelp.recordcount = recordcount;
  
  }

  public int getPagesize() {//ÿҳ��ʾ�ļ�¼����
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
   * ShowDivPagebar ��ʾ��ҳ����������ҳ����һҳ����һҳ��βҳ��
   *
   * @param pageName String����ǰURL������
   * @param ListType int��ҳ������ʶ
   * @param pageCount int������ҳ��
   * @param currPage int����ǰҳ
   * @return String
   */
  public void setPagebar() {//��ʾ��ҳ����һҳ����һҳ��βҳ����ǰ����ҳ��������ҳ�ȵķ�ҳ��
    String strResult = "";
    if (PageHelp.currentpage <= 1) {//���list���м�¼��������һҳ����ʾ������һҳ����ҳ������

      strResult = strResult + "��ҳ   ��һҳ ";
    } else {//���������м�¼������һҳ���������ӣ����Է�ҳ��ʾ
      strResult = "<a href='#' onClick='return changpage(1)'><font color='red'>��ҳ</font></a> ";
      strResult += "<a href='#' onClick='return changpage("+(PageHelp.currentpage - 1)+")'><font color='red'>��һҳ</font><a> ";
    }
    if (PageHelp.currentpage >= PageHelp.pagecount) {//�����ǰҳ����ʾ�����һҳ������һҳ��βҳ������
      strResult += " ��һҳ βҳ ";
    }else {//����ֻҪ��¼�������һҳ��������ʵ�ֵ����ҳ
      strResult += "<a href='#' onClick='return changpage(" +(PageHelp.currentpage + 1) + ")'><font color='red'>��һҳ</font><a> ";
      strResult += "<a href='#' onClick='return changpage(" + PageHelp.pagecount + ")'><font color='red'>βҳ</font><a> ";
    }
    strResult = strResult + "��<font color='red'>" + PageHelp.currentpage + "</font>ҳ����<font color='red'>" + PageHelp.recordcount +
        "</font>����¼����<font color='red'>" + PageHelp.pagecount + "</font>ҳ��ʾ��ÿҳ����<font color='red'>" + PageHelp.pagesize + "</font>����¼��";
   if(PageHelp.pagecount>1)
	   this.pagebar = strResult;
    }
  public String getPagebar() {
	    return pagebar;
	  }
}