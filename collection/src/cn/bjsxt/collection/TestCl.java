package cn.bjsxt.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
/**
 * 测试List中的基本方法
 * @author houtingting
 *
 */
public class TestCl {

	public static void main(String[] args){
		List list = new ArrayList();
		//ArrayList:低层实现是数组，线程不安全，效率高，所以。查询快，修改、插入、删除慢。
		//LinkList:低层实现是链表，线程不安全，效率高，查询慢，修改、插入、删除快。
		//Vector:线程安全，效率低。低层实现是数组。
		list.add("aaa");
		list.add(new Date());//hashcode 和equals
	//	list.add(new Dog());
		list.add(1234);//包装类的：自动装箱
		System.out.println(list.size());
		System.out.println(list.isEmpty());
		//list.remove("aaa");
		
		List list2 = new ArrayList();
		list2.add("bbb");
		list2.add("ccc");
		
		list.add(list2);
		
		//跟顺序的操作
		String str = (String)list.get(0);
		System.out.println(str);
		System.out.println(list.size());
		list.set(1,"ababa");
		list.remove(0);
		System.out.println(list.size());
		
		
	}
}
