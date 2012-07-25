package com.malc.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;



import com.malc.util.PageHelp;


import com.malc.db.*;
import com.malc.vo.*;;

public class MalcDao {
	private Connection conn=null;
	private Statement st = null;
	private ResultSet rs = null;
	DataBaseConnection dbc=new DataBaseConnection();
	
	 public PageHelp querymalc(String condi,int currentPage) throws SQLException {
			conn=dbc.getConnection();
			Statement sm=conn.createStatement();


			int recordcount=0;
			ResultSet rs=null;
			String sql="select count(*) recordcount from malcode where 1=1 "+condi+"";
			rs=sm.executeQuery(sql);
			if(rs.next()){
				recordcount=rs.getInt("recordcount");
			}
			int startNum=(currentPage - 1) * PageHelp.pagesize+1;//由于数据库中没有第0条记录所以要进行+1修正
			int endNum= currentPage* PageHelp.pagesize+1;//查询结束行号
			String pagesql="select * from (" +	"select a.* ,rownum rc from(" +	"select * from malcode where 1=1 "+condi+" " +") a where rownum<"+endNum+"" +	") b where rc >="+startNum+"";	
			rs=sm.executeQuery(pagesql);
			List m=new ArrayList();
			MalcVo malcvo =null;
			while(rs.next()){
				malcvo=new MalcVo();
				malcvo.setSnumber(rs.getString("s_number"));
				malcvo.setName(rs.getString("name"));
				malcvo.setKind(rs.getString("kind"));
				malcvo.setS_time(rs.getString("s_time"));
				malcvo.setE_time(rs.getString("e_time"));
				malcvo.setDetail(rs.getString("detail"));
				m.add(malcvo);
			}
			PageHelp pagehelp= new PageHelp(currentPage,recordcount,condi,m);
			return pagehelp;
		}
	public int delmalc(String[] s_nArray){
		int i=0,n;
		conn=dbc.getConnection();
		try {
			st=conn.createStatement();
			 String Str = "delete from malcode where s_number in (";
			
			 for (n=0; n < s_nArray.length; n++) {
		        	if(n==0)
		        	{Str=Str+"'"+s_nArray[0]+"'";}else
		        	{Str=Str+","+"'"+s_nArray[n]+"'";}     
		        }
		        Str=Str+")";
		        System.out.println(Str);
			i=st.executeUpdate(Str);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return i;
	}
/*	public String findnamebylg_water_num(String lg_water_num)
	{
		conn=dbc.getConnection();
		String lg_name=null;
		try {
			st=conn.createStatement();
			rs=st.executeQuery("select * from login where lg_water_num="+lg_water_num);
			
			if(rs.next()){
				
				lg_name=rs.getString("lg_name");
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lg_name;
		
	}
	
	public String findlg_idbylg_water_num(String lg_water_num)
	{
		conn=dbc.getConnection();
		String lg_id=null;
		try {
			st=conn.createStatement();
			rs=st.executeQuery("select * from login where lg_water_num="+lg_water_num);
			
			if(rs.next()){
				
				lg_id=rs.getString("lg_id");
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lg_id;
	}
	
	
	
	
	public String checkById(String un){
		String uname = null;
		conn=dbc.getConnection();
		String sqlcon="select lg_water_num from login where lg_id='"+un+"'";
		try {
			st=conn.createStatement();
			rs=st.executeQuery(sqlcon);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if(rs.next()){
				uname=rs.getString("lg_water_num");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		dbc.closeConnection();
		return uname;
	}
	
	
*/	
	public int addmessage(MalcVo mvo){
		int i=0;

	    conn=dbc.getConnection();
		try {
			st=conn.createStatement();
			i=st.executeUpdate("insert into malcode(s_number ,name,kind,s_time,e_time,detail) values('"+mvo.getSnumber()+"','"+mvo.getName()+"','"+mvo.getKind()+"','"+mvo.getS_time()+"','"+mvo.getE_time()+"','"+mvo.getDetail()+"')");	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return i;
	}
	public List<MalcVo> querry (MalcVo mvo){
		
		List<MalcVo> list = new ArrayList<MalcVo>();
		MalcVo m=null;
		int n1=0,n2=0,n3=0,n4=0;
		String str="select * from malcode where";
		if(!(mvo.getSnumber().equals(""))){
			n1=1;
			str=str+" s_number='"+mvo.getSnumber()+"'"; 
		}
		if(!(mvo.getName().equals(""))){
			n2=1;
			if(n1==1)
			str=str+" and name='"+mvo.getName()+"'";
			else
				str=str+" name='"+mvo.getName()+"'";
		}
		if(!(mvo.getKind().equals(""))){
		  n3=1;
			if((n1==1)||(n2==1))
			str=str+ " and kind='"+mvo.getKind()+"'";
		  	else
				str=str+ " kind='"+mvo.getKind()+"'";

		}
		if(!(mvo.getS_time().equals(""))){
			n4=1;
			if((n1==1)||(n2==1)||(n3==1))
			str=str+" and s_time='"+mvo.getS_time()+"'";
			else
				str=str+" s_time='"+mvo.getS_time()+"'";
				
		}
		if(!(mvo.getE_time().equals(""))){
			if((n1==1)||(n2==1)||(n3==1)||(n4==1))
			str=str+" and e_time='"+mvo.getE_time()+"'";
			else
				str=str+" e_time='"+mvo.getE_time()+"'";

		}
	    conn=dbc.getConnection();
	    try {
	    	st=conn.createStatement();
			rs=st.executeQuery(str);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	    try {
			
			while(rs.next()){
				 m=new MalcVo();
				m.setSnumber(rs.getString("s_number"));
				m.setName(rs.getString("name"));
				m.setKind(rs.getString("kind"));
				m.setS_time(rs.getString("s_time"));
				m.setE_time(rs.getString("e_time"));
				m.setDetail(rs.getString("detail"));
				list.add(m);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
}

public MalcVo Adetail (String sn){
		
		
		MalcVo m=null;
	
		String str="select * from malcode where s_number='"+sn+"'";
	
	    conn=dbc.getConnection();
	    try {
	    	st=conn.createStatement();
			rs=st.executeQuery(str);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	    try {  
	    	while(rs.next()){
	    	    m=new MalcVo();
				m.setSnumber(rs.getString("s_number"));
				m.setName(rs.getString("name"));
				m.setKind(rs.getString("kind"));
				m.setS_time(rs.getString("s_time"));
				m.setE_time(rs.getString("e_time"));
				m.setDetail(rs.getString("detail"));
			
	    	}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return m;
}
public int updmessage(MalcVo mvo, String ssn){
	int i=0;

    conn=dbc.getConnection();
	try {
		st=conn.createStatement();
		i=st.executeUpdate("update malcode set " +
				"s_number='"+mvo.getSnumber()+"'," +
						"name='"+mvo.getName()+"'," +
								"kind='"+mvo.getKind()+"'," +
										"s_time='"+mvo.getS_time()+"'," +
												"e_time='"+mvo.getE_time()+"'," +
														"detail='"+mvo.getDetail()+"'" +
																"where s_number='"+ssn+"' ");
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return i;
}

	
/*	
	public int updmark(messagevo msvo){
		int i=0;
	    conn=dbc.getMyConnection();
		try {
			st=conn.createStatement();
			i=st.executeUpdate("update message set ms_mark="+msvo.getms_mark()+"where ms_water_time="+msvo.getms_water_time());	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return i;
	}

	public messagevo findMessageById(int id){
		messagevo ms=null;
		conn=dbc.getConnection();
		try {
			st=conn.createStatement();
			rs=st.executeQuery("select * from message where ms_water_time="+id);
			
			if(rs.next()){
				ms=new messagevo();
				
				ms.setms_water_time(rs.getInt("ms_water_time"));
				ms.setms_content(rs.getString("ms_content"));
				ms.setms_mark(rs.getInt("ms_mark"));
				ms.setms_sent_id(rs.getInt("lg_water_num"));
				ms.setms_rec_id(rs.getInt("l_lg_water_num"));
				
				
				ms.setms_title(rs.getString("ms_title"));
				//ms.setms_rec_name(rs.getString("ms_rec_name"));
				//ms.setms_sent_name(rs.getString("ms_sent_name"));
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ms;
	}
*/
}
