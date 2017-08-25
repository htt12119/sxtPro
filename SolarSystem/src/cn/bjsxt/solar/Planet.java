package cn.bjsxt.solar;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import cn.bjsxt.util.GameUtil;

public class Planet extends Star{
	//除了图片、坐标。行星沿着某个椭圆运行：长轴、短轴、速度、角度。绕着某个Star飞。
	double longAxis;//椭圆的长轴
	double shortAxis;//椭圆的短轴
	double speed;	//飞行的速度
	double degree; //角度
	Star center;
	
	boolean satellite;
	
	public void draw(Graphics g){
		super.draw(g);
		//沿着椭圆轨迹飞行
		if(!satellite){
			drawTrace(g);
		}
		move();
	}
	//Graphics是一支笔
	public void drawTrace(Graphics g){
		double ovalX,ovalY,ovalWid,ovalHei;
		
		ovalWid = longAxis*2;
		ovalHei = shortAxis*2;
		ovalX = (center.x + center.width/2)- longAxis;
		ovalY = (center.x + center.height/2)- shortAxis;
		Color c = g.getColor();
		g.setColor(Color.blue);
		g.drawOval((int)ovalX, (int)ovalY,(int)ovalWid, (int)ovalHei);
		g.setColor(c);
	}
	public void move(){
		x = (center.x + center.width/2) + longAxis*Math.cos(degree);
		y = (center.x + center.height/2) + shortAxis*Math.sin(degree);
		
		degree += speed;
	}
	//继承的空的构造器
	public Planet(Star center,String imgpath,double longAxis, double shortAxis, double speed) {
		super(GameUtil.getImage(imgpath));
		this.center = center;
		this.x = center.x + center.height/2 + longAxis;
		this.y = center.y;
		this.img = GameUtil.getImage(imgpath);
		this.longAxis = longAxis;
		this.shortAxis = shortAxis;
		this.speed = speed;
		this.center = center;

		this.width = img.getWidth(null);
		this.height = img.getHeight(null);
	}
	
	public Planet(Star center,String imgpath,double longAxis,
			double shortAxis, double speed,boolean satellite) {
		this(center, imgpath, longAxis,shortAxis,speed);
		this.satellite = satellite;
		
	}
	//继承父类的构造器
	public Planet(Image img,double x,double y){
		super(img,x,y);
	}
	public Planet(String imgpath, double x, double y) {
		super(imgpath, x, y);
	}
	
}
