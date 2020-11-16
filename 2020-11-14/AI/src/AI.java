import javax.microedition.lcdui.*;
import javax.microedition.midlet.*;
import java.io.*;

public class AI extends MIDlet
{
	Display display;
	MainCanvas mc;
	public AI(){
		display=Display.getDisplay(this);
		mc=new MainCanvas();
		display.setCurrent(mc);
	}
	public void startApp(){
	}
	public void destroyApp(boolean unc){
	}
	public void pauseApp(){
	}
}
class MainCanvas extends Canvas
{
	Image img_up,img_down,img_left,img_right,currentImg;
	public MainCanvas()
	{
		try
		{
			img_up=Image.createImage("/sayo14.png");
			img_down=Image.createImage("/sayo10.png");
			img_left=Image.createImage("/sayo12.png");
			img_right=Image.createImage("/sayo16.png");
			currentImg=img_down;
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	public void paint(Graphics g){
		g.setColor(0,0,0);
		g.fillRect(0,0,getWidth(),getHeight());
		g.drawImage(currentImg,111,111,0);
	}

	public void keyPressed(int keyCode)
	{
		int action=getGameAction(keyCode);
		if(action==UP)
		{
			currentImg=img_up;
			repaint();
		}
		if(action==DOWN)
		{
			currentImg=img_down;
			repaint();
		}
		if(action==LEFT)
		{
			currentImg=img_left;
			repaint();
		}
		if(action==RIGHT)
		{
			currentImg=img_right;
			repaint();
		}
	}
}