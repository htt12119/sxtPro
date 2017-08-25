package cn.bjsxt.test;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import cn.bjsxt.test.GameFrame.PaintThread;

public class GameFrame05 extends MyFrame{
	Image img = GameUtil.getImage("images/sun.png");
	
	
	public static void main(String[] args){
		GameFrame05 gf = new GameFrame05();//���¸��Ƶ�ʱ��ע����������
		gf.launchFrame();
	}
	
	private double x = 100,y = 100;
	/*private boolean left;
	private boolean up;*/
	private double degree = 3.14/3;//�û��ȱ�ʾ�Ƕ�
	private double speed = 10;
	//��д�����һ������
	@Override
	public void paint(Graphics g) {
//		//System.out.println("paint!!");  //���Բ����ػ��߳�
//		g.drawLine(100, 100, 200, 200);//�������
//		g.drawRect(100,100,200,200);
//		g.drawOval(100, 100, 200, 200);//ʵ���ǻ��ľ��ε�����Բ
//		//��������
//		Font f = new Font("����",Font.BOLD,100);
//		g.setFont(f);
//		g.drawString("������ѧ��",200,200);
//		
//		g.fillRect(100,100,20,20);
//		/**
//		 * ����ɫ����һ�¾ɵģ������Ժ������û�����һ�㲻Ҫ���û�����ɫ��
//		 */
//		Color c = g.getColor();
//		g.setColor(Color.red);
//		g.fillOval(200, 300, 20, 20);
//		g.setColor(c);
//		
		//��ͼ�������ñ����������ʹ����
		g.drawImage(img,(int)x,(int)y,null);
		//g.drawImage(img,(int)x,(int)y,null);
	/*	//�����ƶ�
		if(up){
			y -= 10;
		}else{
			y += 10;
		}
		if(y > 500-50){
			up = true;
		}
		if(y < 30){
			up = false;
		}
		//�����ƶ�
		if(left){
			x -= 10;
		}else{
			x += 10;
		}
		if(x > 500 - 50){
			left = true;
		}
		if(x < 10){
			left = false;
		}*/
		//����С���˶��ٶȣ�ÿ�εݼ������ͣס��
		if(speed > 0){
			speed -= 0.05;
		}else{
			speed = 0;
		}
		x += speed*Math.cos(degree);
		y += speed*Math.sin(degree);
		
		if(y > 500 - 50){
			degree = -degree;
		}
		if(y < 30){
			degree = -degree;
		}
		if(x < 10){
			degree = Math.PI - degree;
		}
		if(x > 500 - 50){
			degree = Math.PI - degree;
		}
		super.paint(g);
	}
}
