package com.malc.ctrl;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;





import com.malc.dao.MalcDao;
import com.malc.vo.MalcVo;
import com.malc.util.PageHelp;

public class MalcServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public MalcServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request,response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//System.out.println(caogao);
		request.setCharacterEncoding("gb2312");
		String opflag=request.getParameter("opflag");
		String sqlCondition =" ";

			
		if("del".equals(opflag)){
			String[] s_nArray=request.getParameterValues("checkck");
			 System.out.println(s_nArray.length);
			MalcDao malcdao = new MalcDao();
			int i=malcdao.delmalc(s_nArray);
			if(i!=0){
				response.sendRedirect("./view.jsp");
			}
		}
		
		else if("add".equals(opflag)){
			request.setCharacterEncoding("gb2312");
			String sn=request.getParameter("s_number");
			String mcn=request.getParameter("mc_name");
			String kind=request.getParameter("kind");
			String st=request.getParameter("s_time");
			String et=request.getParameter("e_time");
			String detail=request.getParameter("detail");

            
			MalcVo mvo = new MalcVo();
            mvo.setSnumber(sn);
            mvo.setName(mcn);
            mvo.setKind(kind);
            mvo.setS_time(st);
            mvo.setE_time(et);
            mvo.setDetail(detail);
		    
			
			int i=0;
			MalcDao malcdao = new MalcDao();
			i=malcdao.addmessage(mvo);
			
			if(i!=0){
				
				request.setAttribute("sn",sn);
				request.setAttribute("mcn",mcn);
				request.setAttribute("kind",kind);
				request.setAttribute("st",st);
				request.setAttribute("et",et);
				request.setAttribute("detail",detail);
				request.getRequestDispatcher("add_result.jsp").forward(request, response);
			}else{
				request.setAttribute("mark","failure");
				request.getRequestDispatcher("add_result.jsp").forward(request, response);
		}
		}
		
		else if("querry".equals(opflag)){
			request.setCharacterEncoding("gb2312");

			String sn=request.getParameter("s_number");
			String mcn=request.getParameter("mc_name");
			String kind=request.getParameter("kind");
			String st=request.getParameter("s_time");
			String et=request.getParameter("e_time");
			MalcVo mvo = new MalcVo();
            mvo.setSnumber(sn);
            mvo.setName(mcn);
            mvo.setKind(kind);
            mvo.setS_time(st);
            mvo.setE_time(et);
            
           
			MalcDao malcdao = new MalcDao();
			List<MalcVo> li = new ArrayList<MalcVo>();
			li=malcdao.querry(mvo);
			
			if(li!=null){
				request.setAttribute("list",li);
				request.getRequestDispatcher("cha_result.jsp").forward(request, response);

			}else{
				request.setAttribute("mark","failure");
				
				request.getRequestDispatcher("cha_result.jsp").forward(request, response);
		}
		}
		

		else if("Adetail".equals(opflag)){
			String sn=request.getParameter("sn");
			
            
			MalcVo mvo = new MalcVo();
            mvo.setSnumber(sn);
            			
			
			MalcDao malcdao = new MalcDao();
			MalcVo m = new MalcVo();
			m=malcdao.Adetail(sn);
			if(true){
				request.setAttribute("adetail",m);
				request.getRequestDispatcher("./AllDetail.jsp").forward(request, response);
				
			}else{
				request.setAttribute("mark","failure");
				
				request.getRequestDispatcher("cha_result.jsp").forward(request, response);
		}
			
		}else if("changePage".equals(opflag)){
			sqlCondition=request.getParameter("condi");
			String currentpage=request.getParameter("currentPage");
			System.out.println(currentpage);
			int intcurrentpage=Integer.parseInt(currentpage);
			MalcDao malcdao=new MalcDao();
			PageHelp pagehelp=new PageHelp();
				try {
					pagehelp=malcdao.querymalc(sqlCondition,intcurrentpage);
				
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			request.setAttribute("pagehelp",pagehelp);
			request.getRequestDispatcher("./view.jsp").forward(request,response);			
		}else if("ruku".equals(opflag)){
			int i=0;
			String FileName=request.getParameter("path").trim();
			Scanner inputStream =null;
			try{
				inputStream= new Scanner(new FileInputStream(FileName));
				
			}catch(FileNotFoundException e){
				System.out.println("File was not found!");
				System.out.println("or cound not be opened.");
				System.exit(0);
			}
	     while(inputStream.hasNextLine()){
			String s=inputStream.nextLine();	
	        //System.out.print(n1);
	     	String[] info = s.split(",");
            
           
	        MalcVo mvo = new MalcVo();
            mvo.setSnumber(info[0]);
            mvo.setName(info[1]);
            mvo.setKind(info[2]);
            mvo.setS_time(info[3]);
            mvo.setE_time(info[4]);
            mvo.setDetail(info[5]);
		
			
			
			MalcDao malcdao = new MalcDao();
			i=malcdao.addmessage(mvo);
	     }
			if(i!=0){
				request.getRequestDispatcher("ruku_result.html").forward(request, response);
			}else{
				request.setAttribute("mark","failure");
				request.getRequestDispatcher("ruku_result.html").forward(request, response);
		}
		}	else if("update".equals(opflag)){
			String sn=request.getParameter("s_number");
			String mcn=request.getParameter("mc_name");
			String kind=request.getParameter("kind");
			String st=request.getParameter("s_time");
			String et=request.getParameter("e_time");
			String detail=request.getParameter("detail");
			String ssn=request.getParameter("ssn");

            
			MalcVo mvo = new MalcVo();
            mvo.setSnumber(sn);
            mvo.setName(mcn);
            mvo.setKind(kind);
            mvo.setS_time(st);
            mvo.setE_time(et);
            mvo.setDetail(detail);
		
			
			int i=0;
			MalcDao malcdao = new MalcDao();
			i=malcdao.updmessage(mvo,ssn);
			
			if(i!=0){
				request.setAttribute("sn",sn);
				request.setAttribute("mcn",mcn);
				request.setAttribute("kind",kind);
				request.setAttribute("st",st);
				request.setAttribute("et",et);
				request.setAttribute("detail",detail);

				request.getRequestDispatcher("upd_result.jsp").forward(request, response);
			}else{
				request.setAttribute("mark","failure");
				request.getRequestDispatcher("upd_result.jsp").forward(request, response);
		}
		}
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
