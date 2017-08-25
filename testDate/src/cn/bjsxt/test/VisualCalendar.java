package cn.bjsxt.test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;
/**
 * 可视化日历程序
 * @author houtingting
 *
 */
public class VisualCalendar {
	public static void main(String[] args){
		System.out.println("请输入日期(按照格式:2030-3-10):");
		Scanner scanner = new Scanner(System.in);
		String inputStr = scanner.nextLine();
		
		String temp = inputStr;
		//转成一个时间对象
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		try{
			Date date = format.parse(temp);
			//把date改成calendar
			Calendar calendar = new GregorianCalendar();
			//设置时间
			calendar.setTime(date);
			int day = calendar.get(Calendar.DATE);
			//把日期改成1号，如果是2号，用什么and
			calendar.set(Calendar.DATE, 1);
			//要获取是星期几
			//System.out.println(calendar.get(Calendar.DAY_OF_WEEK));
			//判断是多少天
			int maxDate = calendar.getActualMaximum(Calendar.DATE);
			
			System.out.println("日\t一\t二\t三\t四\t五\t六");
			
			for(int i = 0;i<calendar.get(Calendar.DAY_OF_WEEK)-1;i++){
				System.out.print('\t');
			}
			for(int i=1;i<=maxDate;i++){
				if(i == day){
					System.out.print("*");
				}
				System.out.print(i + "\t");
				int  w = calendar.get(Calendar.DAY_OF_WEEK);
				//逢周六换行
				if(w == Calendar.SATURDAY){
					System.out.println();
				}
				//日期加一
				calendar.add(Calendar.DATE, 1);
			}
		} catch(ParseException e){
			e.printStackTrace();
		}
		
	}
}
