package cn.bjsxt.collection;

import java.util.HashMap;

/**
 * �Զ����Լ���Set
 * @author houtingting
 *
 */
public class MyHashSet {
	HashMap map;
	private static final Object PRESENT = new Object();
	
	public MyHashSet(){
		map = new HashMap();
	}
	
	public int size(){
		return map.size();
	}
	public void add(Object o){
		map.put(o, PRESENT);//set�Ĳ����ظ�����������Map���������Ĳ����ظ���
	}
	
	
	public static void main(String[] args) {
		MyHashSet s = new MyHashSet();
		s.add("aaa");
		System.out.println(s.size());
		
		
	
	}

}
