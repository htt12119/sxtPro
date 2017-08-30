package cn.bjsxt.collection;

import java.util.LinkedList;

/**
 * Map的低层实现是数组加链表
 * 自定义Map的升级版
 * 1.提高查询的效率
 * @author houtingting
 *程序错了，不知道哪错了
 */
public class TestMap002 {
	LinkedList arr[] = new LinkedList[999];
	int size;
	
	public void put(Object key,Object value){
		Entry e = new Entry(key,value);
		
		int a = key.hashCode()%arr.length;
		if(arr[a] == null){
			LinkedList list = new LinkedList();
			arr[a] = list;
			list.add(e);
		}else{
			LinkedList list = arr[a];
			for(int i = 0;i < list.size();i++){
				Entry e2 = (Entry)list.get(i);
				if(e2.key.equals(key)){
					e2.value = value;//键值重复
					return;
				}
			}
			arr[a].add(e);
		}
	}
	
	public Object get(Object key){
		int a = key.hashCode()%arr.length;
		if(arr[a] != null){
			LinkedList list = arr[a];
			for(int i = 0;i < list.size();i++){
				Entry e = (Entry)list.get(i);
				if(e.key.equals(key)){
					return e.value;
				}
			}
		}
		return null;
	}
	public static void main(String[] args) {
		TestMap002 map = new TestMap002();
		map.put("高琪", new Wife("张曼玉"));
		map.put("刘恺威", new Wife("杨幂"));
		Wife w = (Wife) map.get("高琪");
		System.out.println(w.name);
	}

}



