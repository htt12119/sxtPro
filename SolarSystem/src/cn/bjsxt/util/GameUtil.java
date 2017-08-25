package cn.bjsxt.util;

import java.awt.Image;
import java.awt.Toolkit;


/**
 * 游戏开发中常用的工具类（比如加载图片等方法）
 * @author houtingting
 *
 */
public class GameUtil {
	
	private GameUtil(){} //工具类通常会把构造方法私有了
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
