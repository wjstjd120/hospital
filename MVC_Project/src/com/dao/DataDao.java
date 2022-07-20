package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dto.DataDto;

public class DataDao {
	
	private String drv ="com.mysql.cj.jdbc.Driver";
	private String url ="jdbc:mysql://localhost:3306/medicalchart";
	private String user ="root";
	private String pass ="sh741852*";
	
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public DataDao() {
		
		try {
			Class.forName(drv);
		} catch (ClassNotFoundException e) {
			//e.printStackTrace();
			System.out.println("드라이버 로드 실패");
		}
	}

	private void close() {
			try {
				if (rs!=null)rs.close();
				if (pstmt!=null)pstmt.close();
				if (conn!=null)conn.close();
				
			} catch (SQLException e) {
				//e.printStackTrace();
			}
	}
	// *************************************   데이터 입력   *************************************
	public int insertData(DataDto data) {
		int result = 0;
		
		String query = "insert into chart values (?, ?, ?, ?, ?, ?, ?, ?)";
		
		try {
			conn = DriverManager.getConnection(url, user, pass);
			
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, data.getC_name());
			pstmt.setInt(2, data.getC_age());
			pstmt.setString(3, data.getC_gender());
			pstmt.setString(4, data.getC_ssn());
			pstmt.setInt(5, data.getC_no());
			pstmt.setString(6, data.getC_dis());
			pstmt.setString(7, data.getC_imp());
			pstmt.setString(8, data.getC_date());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			//e.printStackTrace();
		} finally {
			close();
		}
		 return result;
	}
	// *************************************   데이터 출력   *************************************
	
	public List<DataDto> selectList() {
		List<DataDto> dList = new ArrayList<>();
		
		String query = "select * from chart";
		
		try {
			conn = DriverManager.getConnection(url, user, pass);
			
			pstmt = conn.prepareStatement(query);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				DataDto d = new DataDto();
				
				d.setC_name(rs.getString(1));
				d.setC_age(rs.getInt(2));
				d.setC_gender(rs.getString(3));
				d.setC_ssn(rs.getString(4));
				d.setC_no(rs.getInt(5));
				d.setC_dis(rs.getString(6));
				d.setC_imp(rs.getString(7));
				d.setC_date(rs.getString(8));
				
				dList.add(d);
			}
		} catch (SQLException e) {
			//e.printStackTrace();
		} finally {
			close();
		}
		return dList;
	}
	// *************************************   날짜별 리스트 데이터 출력   *************************************
	
		public List<DataDto> selectDateList(String date) {
			List<DataDto> dList = new ArrayList<>();
			
			String query = "select * from chart where c_date = ?";
			
			try {
				conn = DriverManager.getConnection(url, user, pass);
				
				pstmt = conn.prepareStatement(query);
				pstmt.setString(1, date);
				rs = pstmt.executeQuery();
				
				while(rs.next()) {
					DataDto d = new DataDto();
					
					d.setC_name(rs.getString(1));
					d.setC_age(rs.getInt(2));
					d.setC_gender(rs.getString(3));
					d.setC_ssn(rs.getString(4));
					d.setC_no(rs.getInt(5));
					d.setC_dis(rs.getString(6));
					d.setC_imp(rs.getString(7));
					d.setC_date(rs.getString(8));
					
					dList.add(d);
				}
			} catch (SQLException e) {
				//e.printStackTrace();
			} finally {
				close();
			}
			return dList;
		}
	// *************************************   날짜별 데이터 검색   *************************************
	/*public DataDto selectDate(String date) {
		DataDto data = null;
		
		String query = "select * from chart where c_date = ?";
		
		try {
			conn = DriverManager.getConnection(url, user, pass);
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, date);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
			data = new DataDto();
			data.setC_name(rs.getString(1));
			data.setC_age(rs.getInt(2));
			data.setC_gender(rs.getString(3));
			data.setC_ssn(rs.getString(4));
			data.setC_no(rs.getInt(5));
			data.setC_dis(rs.getString(6));
			data.setC_imp(rs.getString(7));
			data.setC_date(rs.getString(8));
			}
			
		} catch (SQLException e) {
			//e.printStackTrace();
		} finally {
			close ();
		} return data;
		
	}*/
		
		
		public DataDto selectChartnoDateList(int chartno, String date){
			DataDto d = null;
			
			String query = "select * from chart where c_no = ? and c_date = ?";
			
			try {
				conn = DriverManager.getConnection(url, user, pass);
				
				pstmt = conn.prepareStatement(query);
				pstmt.setInt(1, chartno);
				pstmt.setString(2, date);
				
				rs = pstmt.executeQuery();
				
				while(rs.next()) {
					d = new DataDto();
					
					d.setC_name(rs.getString(1));
					d.setC_age(rs.getInt(2));
					d.setC_gender(rs.getString(3));
					d.setC_ssn(rs.getString(4));
					d.setC_no(rs.getInt(5));
					d.setC_dis(rs.getString(6));
					d.setC_imp(rs.getString(7));
					d.setC_date(rs.getString(8));
					
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return d;
		}
	// *************************************   차트넘버로 데이터 출력   *************************************
		public List<DataDto> selectchartnoList(int chartno){
			List<DataDto> dList = new ArrayList<>();
			
			String query = "select * from chart where c_no = ?";
			
			try {
				conn = DriverManager.getConnection(url, user, pass);
				
				pstmt = conn.prepareStatement(query);
				pstmt.setInt(1, chartno);
				
				rs = pstmt.executeQuery();
				
				while(rs.next()) {
					DataDto d = new DataDto();
					
					d.setC_name(rs.getString(1));
					d.setC_age(rs.getInt(2));
					d.setC_gender(rs.getString(3));
					d.setC_ssn(rs.getString(4));
					d.setC_no(rs.getInt(5));
					d.setC_dis(rs.getString(6));
					d.setC_imp(rs.getString(7));
					d.setC_date(rs.getString(8));
					
					dList.add(d);
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return dList;
		}
		
	
	// *************************************   데이터 수정   *************************************
		public int updateData(DataDto data) {
			int result = 0;
			
			String query = "update chart set c_imp = ? where c_no = ? and c_date = ?";
			
			try {
				conn = DriverManager.getConnection(url, user, pass);
				
				pstmt = conn.prepareStatement(query);
				pstmt.setString(1, data.getC_imp());
//				pstmt.setString(2, data.getC_date());
				pstmt.setInt(2, data.getC_no());
				pstmt.setString(3, data.getC_date());
				
				result = pstmt.executeUpdate();
			}catch(SQLException e) {
				e.printStackTrace();
			}finally {
				close();
			}
			return result;
		}
	
	
	// *************************************   데이터 삭제   *************************************
	public int deleteData(String ssn) {
		int result = 0;
		
		String query = "delete from chart where c_ssn = ?";
		
		try {
			conn = DriverManager.getConnection(url, user, pass);
			
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, ssn);
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			
		} finally {
			close();
		}
		return result;
	}
}
