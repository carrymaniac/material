package cn.gdou.material.entity;

import java.util.Date;

public class Appointment {
	public Appointment() {
		
	};
	//操作的id
	private int appointmentId;	
	//操作时间
	private Date appointTime;
	//操作的商品id
	private Good good;
	//操作人
	private String operator;
	//出库入库的单位
	private String company;
	//出库入库的数量
	private int number;
	//出库入库的状态，其中0表示出库 1表示入库
	private int state;
	
	public int getAppointmentId() {
		return appointmentId;
	}
	public void setAppointmentId(int appointmentId) {
		this.appointmentId = appointmentId;
	}
	public Date getAppointTime() {
		return appointTime;
	}
	public void setAppointTime(Date appointTime) {
		this.appointTime = appointTime;
	}
	public Good getGood() {
		return good;
	}
	public void setGood(Good good) {
		this.good = good;
	}
	public String getOperator() {
		return operator;
	}
	public void setOperator(String operator) {
		this.operator = operator;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public Appointment(int appointmentId, Date appointTime, Good good, String operator, String company, int number,
			int state) {
		super();
		this.appointmentId = appointmentId;
		this.appointTime = appointTime;
		this.good = good;
		this.operator = operator;
		this.company = company;
		this.number = number;
		this.state = state;
	}
	@Override
	public String toString() {
		return "Appointment [appointmentId=" + appointmentId + ", appointTime=" + appointTime + ", good=" + good
				+ ", operator=" + operator + ", company=" + company + ", number=" + number + ", state=" + state + "]";
	}
	
}
