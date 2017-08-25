package cn.bjsxt.solar;

import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Image;

import cn.bjsxt.util.Constant;
import cn.bjsxt.util.GameUtil;
import cn.bjsxt.util.MyFrame;
/**
 * 太阳系的主窗口
 * @author houtingting
 *
 */
public class SolarFrame extends MyFrame{
	Image bg = GameUtil.getImage("images/ss.jpg");
	Star sun = new Star("images/sun.png",Constant.GAME_WIDTH/2,Constant.GAME_HEIGHT/2);
	Planet earth = new Planet(sun,"images/lan.png",150,100,0.1);
	Planet Jupiter = new Planet(sun,"images/fu.png",100,200,0.1);
	Planet moon = new Planet(earth,"images/zi.png",200,130,0.3,true);
	public void paint(Graphics g){
		g.drawImage(bg, 0, 0, null);
		sun.draw(g);//画太阳
		earth.draw(g);
		Jupiter.draw(g);
		moon.draw(g);
	}
	
	public static void main(String[] args){
		new SolarFrame().launchFrame();
	}
}
