package cn.bjsxt.plane;

import java.awt.Graphics;
import java.awt.Image;

import cn.bjsxt.util.GameUtil;

/**
 * 爆炸类
 * 颜色有点不搭，也没办法啦
 * @author houtingting
 *
 */
public class Explode {
	double x,y;
	static Image[] imgs = new Image[9];//所有子弹都共享
	static{//静态方法给静态数组初始化
		for(int i = 0;i < 9;i++){
			imgs[i] = GameUtil.getImage("images/explode/e"+(i+1)+".jpg");
			imgs[i].getWidth(null);//解除懒加载
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
