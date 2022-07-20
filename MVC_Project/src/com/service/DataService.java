package com.service;

import java.util.List;

import com.dao.DataDao;
import com.dto.DataDto;

public class DataService {
	private DataDao dDao = new DataDao();
	
	// *************************************   데이터 입력   *************************************
	public String insertData(DataDto data) {
		String msg = null;
		
		int result = dDao.insertData(data);
		
		if (result >0) {
			msg = "입력 성공";
		} else {
			msg = "입력 실";
		}
		return msg;
	}
	
	// *************************************   데이터 전체 출력   *************************************
	public List<DataDto> getList() {
		List<DataDto> dList = dDao.selectList();
		
		return dList;
	}
	
	// *************************************   날짜별 데이터 검색   *************************************
	public List<DataDto> getDateList(String date) {
		
		List<DataDto> dList = dDao.selectDateList(date);
		
		return dList;
	}
	
	// *************************************   차트넘버,날짜별 데이터 검색   *************************************
	public DataDto getChartnoDateList(int chartno, String chartdate) {
		DataDto data = dDao.selectChartnoDateList(chartno, chartdate);
		return data;
	}
	
	// *************************************   데이터 수정   *************************************
	public String updateData(DataDto data) {
		String msg = null;
		
		int result = dDao.updateData(data);
		
		if(result>0) {
			msg = "업데이트 성공";
		}else {
			msg = "업데이트 실패";
		}
		
		
		return msg;
	}
	
	// *************************************   데이터 삭제   *************************************
	public String deleteData(String ssn) {
		String msg = null;
		
		int result = dDao.deleteData(ssn);
		
		if(result == 0) {
			msg = "삭제 성공";
		} else {
			msg = "삭제 실패";
		}
		return msg;
	}


	
	
}//class end	

