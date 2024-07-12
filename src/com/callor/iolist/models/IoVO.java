package com.callor.iolist.models;

public class IoVO {
	public String date;
	public String time;
	public String io;
	public String name;
	public int count;
	public int price;
	
	
	public int totalPrice() {
		return count * price;
	}
	
	
	
	@Override
	public String toString() {
		return "IoVO [date=" + date + ", time=" + time + ", io=" + io + ", name=" + name + ", count=" + count + ", price="
				+ price + "]";
	}
	
	
}
