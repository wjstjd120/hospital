package com.view;

import java.util.List;

import com.dto.DataDto;

//콘솔 상에 보이는 뷰

public class DataView {
	private InOutClass ioc = new InOutClass();
	
	public int showFirst() {
		ioc.nPrint("");
		ioc.nPrint("<< 진료 정보 관리 프로그램 >>");
		ioc.nPrint("-----------------------------");
		ioc.nPrint("메뉴 > ");
		ioc.nPrint("1. 진료 작");
		ioc.nPrint("2. 출력");
		ioc.nPrint("3. 환자 정보 삭제");
		ioc.nPrint("4. 진료 기록 수정");
		ioc.nPrint("0. 종료");
		int m = ioc.inNum("선택 : ");
		
		return m;
	}
	public void printMsg(String msg) {
		ioc.nPrint(msg);
	}
	
	// *************************************   데이터 입력   *************************************
	public void inputData(DataDto dd) {
		String str = null;
		int num = -1;
		
		ioc.nPrint("<데이터 입력>");
		ioc.nPrint("----------------------");
		
		str = ioc.inStr("Name : ");
		dd.setC_name(str);
		num = ioc.inNum("Age : ");
		dd.setC_age(num);
		str = ioc.inStr("Gender : "); //m이나 f가 아니면 오류가 나옴. 
		dd.setC_gender(str);
		str = ioc.inStr("Ssn : ");
		dd.setC_ssn(str);
		num = ioc.inNum("No : ");
		dd.setC_no(num);
		str = ioc.inStr("Dis : ");
		dd.setC_dis(str);
		str = ioc.inStr("Imp : ");
		dd.setC_imp(str);
		str = ioc.inStr("Date(YYYY-MM-DD) : ");
		dd.setC_date(str);
		
	}
	
	// *************************************   데이터 전체 출력   *************************************
	public void EoutputList (List<DataDto> dList) {
		ioc.nPrint("<전체 데이터 출력>");
		ioc.nPrint("-----------------------------");
		
		if(dList.isEmpty()) {
			ioc.nPrint("데이터가 없습니다");
			ioc.nPrint("-----------------------------");
			return;
		}
		for(DataDto d : dList) {
			ioc.nPrint(d.toString());
			ioc.nPrint("-----------------------------");
		}
	}
	// *************************************   날짜별 데이터 전체 출력   *************************************
		public void selectDateList (List<DataDto> dList) {
			ioc.nPrint("<데이터 출력>");
			ioc.nPrint("----------------------");
			
			if(dList.isEmpty()) { 
				ioc.nPrint("데이터가 없습니다");
				ioc.nPrint("----------------------");
				return;
			}
			for(DataDto d : dList) { 
				ioc.nPrint(d.toString());
				ioc.nPrint("-------------------");
			}
		}
	// *************************************   날짜 데이터 검색   *************************************
	public String searchDateData(String str) {
		String date = "";
		ioc.nPrint("<날짜 입력>");
		ioc.nPrint("----------------------");
		date = ioc.inStr(str);
		return date;
	}
	
	
	public int searchChartno(String str) {
		int chartno = 0;
		ioc.nPrint("<차트# 입력>");
		ioc.nPrint("----------------------");
		chartno = ioc.inNum(str);
		
		return chartno;
	}
	
	
	public void outputData(DataDto data) {
		ioc.nPrint("<검색 결과>");
		ioc.nPrint("----------------------");
		if (data != null) {
			ioc.nPrint(data.toString());
		} else {
			ioc.nPrint("해당 데이터가 없습니다.");
		}
		ioc.nPrint("----------------------");
	}
	
	// *************************************   데이터 수정   *************************************
	public void updateInput(DataDto dd) {
		String str = null;
		
		ioc.nPrint("<진료 수정>");
		ioc.nPrint("수정내용이 없을경우 enter입력");
		ioc.nPrint("-------------------------");
		
		
		
		
		str = ioc.inStr("Impression : ");
		if(!str.equals("")) {
			dd.setC_imp(str);
		}
		
//		str = ioc.inStr("DATE(YYYY-MM-DD) : ");
//		if(!str.equals("")) {
//			dd.setC_date(str);
//		}
	}
	
	
	
	
	public String inStr(String str) {
		return ioc.inStr(str);
	}
	
	//서브 메뉴 출력용 메소드
		public int showSub() {
			ioc.nPrint("");//첫줄 띄기.
			ioc.nPrint("<<출력>>");
			ioc.nPrint("---------------------------");
			ioc.nPrint("메뉴>");
			ioc.nPrint("1. 전체");
			ioc.nPrint("2. 차트넘버 검색");
			ioc.nPrint("3. 날짜별 검색");
			ioc.nPrint("0. 메인메뉴");
			int m = ioc.inNum("선택 : ");

			return m;
		}
//******************************** 개인정보 삭제 **********************************		
		public String searchSsn(String ssn) {
			ioc.nPrint("<개인정보 삭제>");
			ioc.nPrint("----------------------");
			String s = ioc.inStr(ssn);
			return s;
		}
	
}
