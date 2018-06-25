package cn.gdou.material.entity;

import java.util.Date;

/**
 * 订单类，进行订单的记录
 * @author Lusty
 *
 */
public class Order {
	public Order() {
		
	};
		//操作的id
		private int orderId;	
		//操作时间
		private Date orderTime;
		//操作的商品id
		private Good good;
		//操作人
		private String operator;
		//出库入库的单位
		private String company;
		//出库入库的数量
		private int number;
		//出库入库的状态，其中0表示出库 1表示入库
		private int state = 0;
		//审核状态，其中0表示待审核，1表示审核通过，-1表示审核不通过
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
