package com.controller;

import java.util.List;

import com.dto.DataDto;
import com.service.DataService;
import com.view.DataView;

public class DataController {
	private DataView dv = new DataView();
	private DataService ds = new DataService();
	
	public void run() {
		int menu;
		
		while(true) {
			menu = dv.showFirst();
			
			if(menu == 0) {
				dv.printMsg("프로그램 종료");
				return;
			}
		switch (menu){
		case 1:
			inputData();
			break;
		case 2:
			outputData();
			break;
		case 3:
			deleteDateData();
			break;
		case 4:
			updateData();
			break;
		default:
			dv.printMsg("0~4 사이의 숫자를 입력하세요.");
		}
	}
}

	private void deleteDateData() {
		String ssn = dv.searchSsn("삭제할 주민등록번호 입력 :");
		String data = ds.deleteData(ssn);
		
		if (data != null) {
			String yn = dv.inStr("삭제 실행 (Y/N)");
			if(yn.equals("y") || yn.equals("Y") || yn.equals("ㅛ")) {
				String msg = ds.deleteData(ssn);
				
				dv.printMsg(msg);
			}
		}
	}
	
	
	private void updateData() {
		int chartno = dv.searchChartno("Chart# to update : ");
		String chartdate = dv.searchDateData("Date to Update : ");
		DataDto data = ds.getChartnoDateList(chartno, chartdate);
		dv.outputData(data);
		
		if(data != null) {
			dv.updateInput(data);
			String msg = ds.updateData(data);
			dv.printMsg(msg);
		}
	}
	

	private void searchDateData() {
		String date = dv.searchDateData("날짜 입력(YYYY-MM-DD) : ");
		List<DataDto> dList = ds.getDateList(date);
		dv.EoutputList(dList);
	}
	
	private void outputData() {
		
		int submenu;

		while(true) {
			submenu = dv.showSub();//타이블, 메뉴 출력 및 메뉴 번호 받기

			//종료 처리
			if(submenu == 0) {
				dv.printMsg("이전메뉴로 돌아갑니다.");//종료 문구 출력
				return;//run 메소드 종료
			}

			switch(submenu) {
			case 1:
				EoutputData(); //EntireOutputData
				break;
			case 2:
				//하위메뉴2 처리 메소드 호출
				break;
			case 3:
				searchDateData();
				break;
			default:
				dv.printMsg("0~3 사이의 숫자를 입력하세요.");//오류 메시지 출력
			}

		}//while end
		
		
	}
//***************************전체 출력*************************************
	private void EoutputData() {
		List<DataDto> dList = ds.getList();
		dv.EoutputList(dList);
		
	}
	
	private void inputData() {
		DataDto dd = new DataDto();
		dv.inputData(dd);
		String msg = ds.insertData(dd);
		dv.printMsg(msg);
	}
}
