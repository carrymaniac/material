package cn.gdou.material.entity;

import java.util.Date;

/**
 * �����࣬���ж����ļ�¼
 * @author Lusty
 *
 */
public class Order {
	public Order() {
		
	};
		//������id
		private int orderId;	
		//����ʱ��
		private Date orderTime;
		//��������Ʒid
		private Good good;
		//������
		private String operator;
		//�������ĵ�λ
		private String company;
		//������������
		private int number;
		//��������״̬������0��ʾ���� 1��ʾ���
		private int state = 0;
		//���״̬������0��ʾ����ˣ�1��ʾ���ͨ����-1��ʾ��˲�ͨ��
		private int sign;
		public int getOrderId() {
			return orderId;
		}
		public void setOrderId(int orderId) {
			this.orderId = orderId;
		}
		public Date getOrderTime() {
			return orderTime;
		}
		public void setOrderTime(Date orderTime) {
			this.orderTime = orderTime;
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
		public int getSign() {
			return sign;
		}
		public void setSign(int sign) {
			this.sign = sign;
		}
		@Override
		public String toString() {
			return "Order [orderId=" + orderId + ", orderTime=" + orderTime + ", good=" + good + ", operator="
					+ operator + ", company=" + company + ", number=" + number + ", state=" + state + ", sign=" + sign
					+ "]";
		}
		
}
