package cn.bjsxt.test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;
/**
 * ���ӻ���������
 * @author houtingting
 *
 */
public class VisualCalendar {
	public static void main(String[] args){
		System.out.println("����������(���ո�ʽ:2030-3-10):");
		Scanner scanner = new Scanner(System.in);
		String inputStr = scanner.nextLine();
		
		String temp = inputStr;
		//ת��һ��ʱ�����
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		try{
			Date date = format.parse(temp);
			//��date�ĳ�calendar
			Calendar calendar = new GregorianCalendar();
			//����ʱ��
			calendar.setTime(date);
			int day = calendar.get(Calendar.DATE);
			//�����ڸĳ�1�ţ������2�ţ���ʲôand
			calendar.set(Calendar.DATE, 1);
			//Ҫ��ȡ�����ڼ�
			//System.out.println(calendar.get(Calendar.DAY_OF_WEEK));
			//�ж��Ƕ�����
			int maxDate = calendar.getActualMaximum(Calendar.DATE);
			
			System.out.println("��\tһ\t��\t��\t��\t��\t��");
			
			for(int i = 0;i<calendar.get(Calendar.DAY_OF_WEEK)-1;i++){
				System.out.print('\t');
			}
			for(int i=1;i<=maxDate;i++){
				if(i == day){
					System.out.print("*");
				}
				System.out.print(i + "\t");
				int  w = calendar.get(Calendar.DAY_OF_WEEK);
				//����������
				if(w == Calendar.SATURDAY){
					System.out.println();
				}
				//���ڼ�һ
				calendar.add(Calendar.DATE, 1);
			}
		} catch(ParseException e){
			e.printStackTrace();
		}
		
	}
}
