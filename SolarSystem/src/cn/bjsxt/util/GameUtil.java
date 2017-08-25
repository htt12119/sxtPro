package cn.bjsxt.util;

import java.awt.Image;
import java.awt.Toolkit;


/**
 * ��Ϸ�����г��õĹ����ࣨ�������ͼƬ�ȷ�����
 * @author houtingting
 *
 */
public class GameUtil {
	
	private GameUtil(){} //������ͨ����ѹ��췽��˽����
	public static Image getImage(String path){
		return Toolkit.getDefaultToolkit().getImage(GameUtil.class.getClassLoader().getResource(path));
		/*URL u = GameUtil.class.getClassLoader().getResource(path);
		BufferedImage img = null;
		try{
			img = ImageIO.read(u);
		}catch(IOException e){
			e.printStackTrace();
		}

		return img;*/
	}
}
