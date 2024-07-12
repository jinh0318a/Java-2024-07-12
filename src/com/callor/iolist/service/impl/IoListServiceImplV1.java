package com.callor.iolist.service.impl;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.callor.iolist.models.IoVO;
import com.callor.iolist.service.IoListService;
import com.callor.iolist.utils.Contract;
import com.callor.iolist.utils.Line;

public class IoListServiceImplV1 implements IoListService{

	protected final String ioListFile;
	protected final Scanner fileReader;
	protected final List<IoVO> ioList;
	
	public IoListServiceImplV1(String ioListFile) throws FileNotFoundException {
		this.ioListFile = ioListFile;
		InputStream input = new FileInputStream(this.ioListFile);
		this.fileReader = new Scanner(input);
		this.ioList = new ArrayList<IoVO>();
	}

	@Override
	public void loadIoListData() {
		fileReader.nextLine();
		while(fileReader.hasNext()) {
			String[] lines = fileReader.nextLine().split(",");
			IoVO one = new IoVO();
			one.date= lines[Contract.Io.date];
			one.time= lines[Contract.Io.time];
			one.io= lines[Contract.Io.io];
			one.name= lines[Contract.Io.name];
			one.count= Integer.valueOf(lines[Contract.Io.count]);
			one.price= Integer.valueOf(lines[Contract.Io.price]);
			ioList.add(one);
		}
	}

	@Override
	public void printIoList() {
		System.out.println(Line.dline(100));
		System.out.println("거래일자 \t 거래구분 \t 상품이름 \t 매입금액 \t 매출금액");
		System.out.println(Line.sline(100));
		int inTotal = 0;
		int outTotal = 0;
		for(IoVO one : ioList) {
			System.out.printf(one.date+"\t");
			if(one.io.equals("1")) {
				System.out.printf("매입\t");
				System.out.printf(one.name+"\t");
				System.out.printf(one.totalPrice()+"\t");
				System.out.printf(0+"\n");
				inTotal += one.totalPrice();
			}else if(one.io.equals("2")) {
				System.out.printf("매출\t");
				System.out.printf(one.name+"\t");
				System.out.printf(0+"\t");
				System.out.printf(one.totalPrice()+"\n");
				outTotal += one.totalPrice();
			}
		}
		
		System.out.println(Line.sline(100));
		System.out.printf("%s \t %s \t\t\t %d %d\n", "거래건수", ioList.size()+"건", inTotal, outTotal);
		System.out.println(Line.dline(100));
	}

}
