package MysqlConnnect;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import Canvas.canvas;

public class connect {
	java.sql.Connection conn;
	java.sql.Statement stmt;
	ResultSet rs;
	
	public connect(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url="jdbc:mysql://123.207.39.128/YXY?"+"useUnicode=true&characterEncoding=utf8";
			String user = "root";
			String password="XIEhanyang033~!";
			conn = DriverManager.getConnection(url,user,password);
			System.out.print("连接成功！\n");
		}catch(SQLException e1){
			e1.printStackTrace();
		}catch(ClassNotFoundException e1){
			e1.printStackTrace();
		}
	}
	
	//查询课程号是否存在
	public int search(String cname){
		try{
			stmt = conn.createStatement();
			String sql = "select Cname from Canvas where Cname = '" + cname + "'";
			rs = stmt.executeQuery(sql);
			if(rs.next()){
				return 0;//该名称已经存在
			}
			rs.close();
			stmt.close();
		}catch(SQLException e1){
			e1.printStackTrace();
		}
		return 1;//该名称不存在
	}
	
	//插入课程数据
	public int insert(String cname,int x1,int x2,int y1,int y2,int color,int linellae,int drawtype){
		try{
			stmt = conn.createStatement();
			String sql = "insert into Canvas(Cname,x1,x2,y1,y2,color,linellae,drawtype)"+"values('"+cname+"',"+x1+","+x2+","+y1+","+y2+","+color+","+linellae+","+drawtype+")";
			int count = stmt.executeUpdate(sql);
			if(count == 0){
				System.out.println(count);
				return 0;//插入失败
			}
			//rs.close();
			stmt.close();
		}catch(SQLException e1){
			e1.printStackTrace();
		}
		return 1;//插入成功
	}
	
	//查询数据库中存在的图画
	public String[] searchCourseName(){
		String[] s = null;
		try{
			stmt = conn.createStatement();
			String sql = "select count(*)Cname from Canvas";
			rs = stmt.executeQuery(sql);
			int num = 0;
			while(rs.next()){
				num = rs.getInt("Cname");
			}
			s = new String[num]; 
			
			sql = "select * from Canvas";
			rs = stmt.executeQuery(sql);
			int i=0;
			while(rs.next()){
				s[i] = rs.getString("Cname");
				i++;
			}
			rs.close();
			stmt.close();
		}catch(SQLException e1){
			e1.printStackTrace();
		}
		return s;
	}
	
	//返回所有数据
	public canvas returnAll(String cname){
		canvas c = new canvas();
		try{
			stmt = conn.createStatement();
			String sql = "select * from Canvas where Cname = '" + cname + "'";;
			rs = stmt.executeQuery(sql);
			while(rs.next()){
				c.drawType = rs.getInt("drawtype");
				c.set_color(rs.getInt("color"));
				c.set_linellae(rs.getInt("linellae"));
				c.x2 = (rs.getInt("x2"));
				c.y2 = (rs.getInt("y2"));
				c.x1 = (rs.getInt("x1"));
				c.y1 = (rs.getInt("y1"));
			}
			rs.close();
			stmt.close();
		}catch(SQLException e1){
			e1.printStackTrace();
		}
		return c;
	}
}
