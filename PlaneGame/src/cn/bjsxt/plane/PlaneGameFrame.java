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
	
	//子弹有许多，用ArrayList
	ArrayList bulletList = new ArrayList();//泛型暂时未学，先不加，以后学了强烈建议加上
	
	Explode baozha = new Explode(50,50);
	Plane p = new Plane("images/plane.png",50,50);
	int count = 0;//计算第几次碰撞
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
			
			//检测跟飞机的碰撞
			boolean peng = b.getRect().intersects(p.getRect());
			//System.out.println(p.width);
			if(peng){
				p.setLive(false);//飞机死掉！
//				count++;
//				if(count == 1){//第一次碰的时候死掉，然后就是终止时间。因为飞机实际上还是在的。
					
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
			int period = (int)(endTime.getTime() - startTime.getTime())/1000;//原来是毫秒，现在转成秒
			printInfo(g, "时间:" + period + "秒", 20, 150, 360, Color.white);
			switch((int)period/10){
			case 0:
			case 1:
				printInfo(g,"菜鸟",50,100,200,Color.white);
				break;
			case 2:
				printInfo(g,"小鸟",50,100,200,Color.white);
				break;
			case 3:
				printInfo(g,"大鸟",50,100,200,Color.white);
				break;
			case 4:
				printInfo(g,"鸟王子",50,100,200,Color.white);
				break;
			default:
				printInfo(g,"鸟人",50,100,200,Color.white);
				break;
			}
		}
		
//		printInfo(g,"分数：100",10,50,50,Color.YELLOW);
	}
		
	/**
	 * 在窗口上打印信息
	 * @param args
	 */
	public void printInfo(Graphics g,String str,int size,int x,int y,Color color){
		Color c = g.getColor();
		g.setColor(color);
		Font f = new Font("宋体",Font.BOLD,size);
		g.setFont(f);
		//画大字提示GAMEOVER
		g.drawString(str,x,y);
		g.setColor(c);
	}
	
	public static void main(String[] args){
		new PlaneGameFrame().launchFrame();//这个方法在父类里面
		
	}
	
	//重写父类的方法
	public void launchFrame(){
		//直接调用父类中的launchFrame
		super.launchFrame();
		//增加键盘的监听
		addKeyListener(new KeyMonitor());
		
		//生成一堆子弹
		for(int i = 0;i < 50;i++){
			Bullet b = new Bullet();
			bulletList.add(b);
		}
		
		startTime = new Date();
	}
	//定义为内部类，可以方便地使用外部类的普通属性,还要注册
	class KeyMonitor extends KeyAdapter{

		@Override
		public void keyPressed(KeyEvent e) {
			//键盘上的每一个键对应一个数值,操作飞机的属性
			//System.out.println("按下:" + e.getKeyCode());
			p.addDirection(e);
		}

		@Override
		public void keyReleased(KeyEvent e) {
			//System.out.println("释放:" + e.getKeyCode());
			p.minusDirection(e);
		}
		
	}
}
