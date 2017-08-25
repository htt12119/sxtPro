package cn.bjsxt.test;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * 游戏基本知识测试类,简单运动轨迹（上下与左右），物体沿任意角度飞行
 * @author houtingting
 *
 */
public class GameFrame extends Frame{	//GUI编程：AWT,swing等。这些都不用，java不适合桌面软件
	
	Image img = GameUtil.getImage("images/sun.png");
	/**
	 * 加载窗口
	 */
	public void launchFrame(){
		setSize(500,500);
		setLocation(100,100);
		setVisible(true);//可视化
		//启动线程
		new PaintThread().start();
		//匿名内部类
		addWindowListener(new WindowAdapter(){
			
			@Override
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});
	}
	
	/**
	 * 定义一个重画窗口的线程类，是一个内部类
	 * @author houtingting
	 *
	 */
	//内部类，通过线程类来控制
	class PaintThread extends Thread{
		//画整个界面，不停地画
		public void run(){
			while(true){
				//重画线程
				repaint();
				//休息休息，
				try {
					Thread.sleep(40);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}//1s = 1000ms
			}
		}
	}
	
	public static void main(String[] args){
		GameFrame gf = new GameFrame();
		gf.launchFrame();
	}
	
	private double x = 100,y = 100;
	/*private boolean left;
	private boolean up;*/
	private double degree = 3.14/3;//用弧度表示角度
	private double speed = 10;
	//重写父类的一个方法
	@Override
	public void paint(Graphics g) {
//		//System.out.println("paint!!");  //用以测试重画线程
//		g.drawLine(100, 100, 200, 200);//相对坐标
//		g.drawRect(100,100,200,200);
//		g.drawOval(100, 100, 200, 200);//实际是画的矩形的内切圆
//		//设置字体
//		Font f = new Font("宋体",Font.BOLD,100);
//		g.setFont(f);
//		g.drawString("我是尚学堂",200,200);
//		
//		g.fillRect(100,100,20,20);
//		/**
//		 * 用颜色保存一下旧的，用完以后再设置回来。一般不要设置画笔颜色。
//		 */
//		Color c = g.getColor();
//		g.setColor(Color.red);
//		g.fillOval(200, 300, 20, 20);
//		g.setColor(c);
//		
		//画图像，坐标用变量代替就能使用了
		g.drawImage(img,(int)x,(int)y,null);
		//g.drawImage(img,(int)x,(int)y,null);
	/*	//上下移动
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
		//左右移动
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
		//设置小球运动速度，每次递减，最后停住。
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
