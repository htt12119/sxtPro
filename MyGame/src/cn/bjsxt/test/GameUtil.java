package cn.bjsxt.test;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import java.net.URL;

/**
 * ��Ϸ�����г��õĹ����ࣨ�������ͼƬ�ȷ�����
 * @author houtingting
 *
 */
public class GameUtil {
	
	private GameUtil(){} //������ͨ����ѹ��췽��˽����
	public static Image getImage(String path){
		URL u = GameUtil.class.getClassLoader().getResource(path);
		BufferedImage img = null;
		try{
			img = ImageIO.read(u);
		}catch(IOException e){
			e.printStackTrace();
		}

		return img;
	}
}
