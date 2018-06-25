package cn.gdou.material.entity;

public class Good {
	//��Ʒ��
	private String name;
	//��Ʒ��������
	private String factory;
	//��ƷID
	private int goodId;
	//��Ʒ���
	private String specifications;
	//��Ʒ�������
	private int number;
	
	
	public Good() {
		super();
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFactory() {
		return factory;
	}
	public void setFactory(String factory) {
		this.factory = factory;
	}
	public int getGoodId() {
		return goodId;
	}
	public void setGoodId(int iD) {
		goodId = iD;
	}
	public String getSpecifications() {
		return specifications;
	}
	public void setSpecifications(String specifications) {
		this.specifications = specifications;
	}
	@Override
	public String toString() {
		return name+":"+specifications;
	}
	public Good(String name, String factory, int goodId, String specifications, int number) {
		super();
		this.name = name;
		this.factory = factory;
		this.goodId = goodId;
		this.specifications = specifications;
		this.number = number;
	}
	
	
}
