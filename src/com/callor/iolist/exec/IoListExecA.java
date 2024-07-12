package com.callor.iolist.exec;

import java.io.FileNotFoundException;

import com.callor.iolist.service.IoListService;
import com.callor.iolist.service.impl.IoListServiceImplV1;

public class IoListExecA {
	public static void main(String[] args) {
		
		String ioListFile = "src/com/callor/iolist/iolist";
		IoListService ioListService = null;
		try {
			ioListService = new IoListServiceImplV1(ioListFile);
		} catch (FileNotFoundException e) {
			System.out.println("파일을 읽을 수 없습니다.");
		}
		
		ioListService.loadIoListData();
		ioListService.printIoList();
		
	}
}
