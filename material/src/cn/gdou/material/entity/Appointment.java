package cn.gdou.material.entity;

import java.util.Date;

public class Appointment {
	public Appointment() {
		
	};
	//������id
	private int appointmentId;	
	//����ʱ��
	private Date appointTime;
	//��������Ʒid
	private Good good;
	//������
	private String operator;
	//�������ĵ�λ
	private String company;
	//������������
	private int number;
	//��������״̬������0��ʾ���� 1��ʾ���
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
