package cn.bjsxt.plane;

import java.awt.Graphics;
import java.awt.Image;

import cn.bjsxt.util.GameUtil;

/**
 * ��ը��
 * ��ɫ�е㲻�Ҳû�취��
 * @author houtingting
 *
 */
public class Explode {
	double x,y;
	static Image[] imgs = new Image[9];//�����ӵ�������
	static{//��̬��������̬�����ʼ��
		for(int i = 0;i < 9;i++){
			imgs[i] = GameUtil.getImage("images/explode/e"+(i+1)+".jpg");
			imgs[i].getWidth(null);//���������
		}
	}
	int count;
	
	
	public void draw(Graphics g){
		if(count <= 8){
			g.drawImage(imgs[count], (int)x, (int)y, null);
			count++;
		}
	}
	
	public Explode(double x,double y){
		this.x = x;
		this.y = y;
	}
}
