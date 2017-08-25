package cn.bjsxt.plane;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

import cn.bjsxt.util.GameUtil;

public class Plane extends GameObject{
	private boolean left,up,right,down;

	private boolean live = true;
	
	public Plane(String imgpath,double x,double y){
		super();
		this.img = GameUtil.getImage(imgpath);
		this.width = img.getWidth(null);
		this.height = img.getHeight(null);
		this.x = x;
		this.y = y;
	}
	
	public Rectangle getRect(){
		Rectangle r = new Rectangle((int)x,(int)y,50,50);
		return r;
	} 
	public void draw(Graphics g){
		if(live){
			g.drawImage(img, (int)x, (int)y, null);
			move();	
		}
	}
	
	//飞机移动,八个方向
	public void move(){
		if(left){
			x -= speed;
		}
		if(right){
			x += speed;
		}
		if(up){
			y -= speed;
		}
		if(down){
			y += speed;  //注意坐标的方向
		}
	}
	
	public void addDirection(KeyEvent e){
		switch(e.getKeyCode()){
		case KeyEvent.VK_LEFT:
			left = true;
			break;
		case KeyEvent.VK_RIGHT:
			right = true;
			break;
		case KeyEvent.VK_UP:
			up = true;
			break;
		case KeyEvent.VK_DOWN:
			down = true;
			break;
		default:
			break;
		}
	}
	
	public void minusDirection(KeyEvent e){
		switch(e.getKeyCode()){
		case KeyEvent.VK_LEFT:
			left = false;
			break;
		case KeyEvent.VK_RIGHT:
			right = false;
			break;
		case KeyEvent.VK_UP:
			up = false;
			break;
		case KeyEvent.VK_DOWN:
			down = false;
			break;
		default:
			break;
		}
	}
	
	public Plane(){
		
	}

	public boolean isLive() {
		return live;
	}

	public void setLive(boolean live) {
		this.live = live;
	}
	
}
