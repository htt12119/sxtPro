package cn.bjsxt.test;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import cn.bjsxt.test.GameFrame.PaintThread;

/**
 * ���Դ�
 * @author houtingting
 *
 */
public class MyFrame extends Frame {
	
	
	
	/**
	 * ���ش���
	 */
	public void launchFrame(){
		setSize(Constant.GAME_WIDTH,Constant.GAME_HEIGHT);
		setLocation(100,100);
		setVisible(true);//���ӻ�
		//�����߳�
		new PaintThread().start();//�����ػ��߳�
		//�����ڲ���
		addWindowListener(new WindowAdapter(){
			
			@Override
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});
	}
	
	/**
	 * ����һ���ػ����ڵ��߳��࣬��һ���ڲ���
	 * @author houtingting
	 *
	 */
	//�ڲ��࣬ͨ���߳���������
	class PaintThread extends Thread{
		//���������棬��ͣ�ػ�
		public void run(){
			while(true){
				//�ػ��߳�
				repaint();
				//��Ϣ��Ϣ��
				try {
					Thread.sleep(40);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}//1s = 1000ms
			}
		}
	}
}
