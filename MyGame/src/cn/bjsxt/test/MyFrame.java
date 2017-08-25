package cn.bjsxt.test;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import cn.bjsxt.test.GameFrame.PaintThread;

/**
 * 测试窗
 * @author houtingting
 *
 */
public class MyFrame extends Frame {
	
	
	
	/**
	 * 加载窗口
	 */
	public void launchFrame(){
		setSize(Constant.GAME_WIDTH,Constant.GAME_HEIGHT);
		setLocation(100,100);
		setVisible(true);//可视化
		//启动线程
		new PaintThread().start();//启动重画线程
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
}
