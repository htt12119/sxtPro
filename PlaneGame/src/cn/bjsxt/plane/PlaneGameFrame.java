package cn.bjsxt.plane;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Date;

import cn.bjsxt.util.Constant;
import cn.bjsxt.util.GameUtil;
import cn.bjsxt.util.MyFrame;

public class PlaneGameFrame extends MyFrame {
	Image bg = GameUtil.getImage("images/bg.jpg");
	
	//�ӵ�����࣬��ArrayList
	ArrayList bulletList = new ArrayList();//������ʱδѧ���Ȳ��ӣ��Ժ�ѧ��ǿ�ҽ������
	
	Explode baozha = new Explode(50,50);
	Plane p = new Plane("images/plane.png",50,50);
	int count = 0;//����ڼ�����ײ
	Date startTime;
	Date endTime;
	Explode bao;
	public void paint(Graphics g){
		g.drawImage(bg,0,0,null);
		p.draw(g);
		baozha.draw(g);
		for(int i = 0;i < bulletList.size();i++){
			Bullet b = (Bullet)bulletList.get(i);
			b.draw(g);
			
			//�����ɻ�����ײ
			boolean peng = b.getRect().intersects(p.getRect());
			//System.out.println(p.width);
			if(peng){
				p.setLive(false);//�ɻ�������
//				count++;
//				if(count == 1){//��һ������ʱ��������Ȼ�������ֹʱ�䡣��Ϊ�ɻ�ʵ���ϻ����ڵġ�
					
					if(bao == null){
						endTime = new Date();
						bao = new Explode(p.x,p.y);
					}
					
					bao.draw(g);
					break;
				}
			}
//		}
		
		if((!p.isLive())){
			int period = (int)(endTime.getTime() - startTime.getTime())/1000;//ԭ���Ǻ��룬����ת����
			printInfo(g, "ʱ��:" + period + "��", 20, 150, 360, Color.white);
			switch((int)period/10){
			case 0:
			case 1:
				printInfo(g,"����",50,100,200,Color.white);
				break;
			case 2:
				printInfo(g,"С��",50,100,200,Color.white);
				break;
			case 3:
				printInfo(g,"����",50,100,200,Color.white);
				break;
			case 4:
				printInfo(g,"������",50,100,200,Color.white);
				break;
			default:
				printInfo(g,"����",50,100,200,Color.white);
				break;
			}
		}
		
//		printInfo(g,"������100",10,50,50,Color.YELLOW);
	}
		
	/**
	 * �ڴ����ϴ�ӡ��Ϣ
	 * @param args
	 */
	public void printInfo(Graphics g,String str,int size,int x,int y,Color color){
		Color c = g.getColor();
		g.setColor(color);
		Font f = new Font("����",Font.BOLD,size);
		g.setFont(f);
		//��������ʾGAMEOVER
		g.drawString(str,x,y);
		g.setColor(c);
	}
	
	public static void main(String[] args){
		new PlaneGameFrame().launchFrame();//��������ڸ�������
		
	}
	
	//��д����ķ���
	public void launchFrame(){
		//ֱ�ӵ��ø����е�launchFrame
		super.launchFrame();
		//���Ӽ��̵ļ���
		addKeyListener(new KeyMonitor());
		
		//����һ���ӵ�
		for(int i = 0;i < 50;i++){
			Bullet b = new Bullet();
			bulletList.add(b);
		}
		
		startTime = new Date();
	}
	//����Ϊ�ڲ��࣬���Է����ʹ���ⲿ�����ͨ����,��Ҫע��
	class KeyMonitor extends KeyAdapter{

		@Override
		public void keyPressed(KeyEvent e) {
			//�����ϵ�ÿһ������Ӧһ����ֵ,�����ɻ�������
			//System.out.println("����:" + e.getKeyCode());
			p.addDirection(e);
		}

		@Override
		public void keyReleased(KeyEvent e) {
			//System.out.println("�ͷ�:" + e.getKeyCode());
			p.minusDirection(e);
		}
		
	}
}
