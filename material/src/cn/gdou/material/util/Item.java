package cn.gdou.material.util;

/**
 * 
 * ˵��:�Զ��������˵�Ԫ�صĹ�����
 * 
 * @author LS
 * 
 */
public class Item {
	private Object key;

	private Object value;

	public Item(Object key, Object value) {
		this.key = key;
		this.value = value;
	}

	public void setKey(Object key) {
		this.key = key;
	}

	public Object getKey() {
		return key;
	}

	public void setValue(Object value) {
		this.value = value;
	}

	public Object getValue() {
		return value;
	}

	public String toString() {
		return value.toString();
	}
}
