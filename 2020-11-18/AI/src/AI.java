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
	Image[] heroMovImgUp=new Image[],heroMovImgDown=new Image[],heroMovImgLeft=new Image[],heroMovImgRight=new Image[];
	Image currentImg;
	int movFlag=1;
	public MainCanvas()
	{
		try
		{
			for(int i=0;i<3;i++)
			{
				heroMovImgUp[i]=Image.createImage("/sayo"+i+"4.png");
			}
			for(int i=0;i<3;i++)
			{
				heroMovImgDown[i]=Image.createImage("/sayo"+i+"0.png");
			}
			for(int i=0;i<3;i++)
			{
				heroMovImgLeft[i]=Image.createImage("/sayo"+i+"2.png");
			}
			for(int i=0;i<3;i++)
			{
				heroMovImgRight[i]=Image.createImage("/sayo"+i+"6.png");
			}
			currentImg=heroMovImgDown[0];
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
			if(movFlag==1)
			{
			currentImg=heroMovImgUp[1];
			movFlag=2;
			}
			else
			}
			currentImg=heroMovImgUp[2];
			movFlag=1;
			}
		}
		if(action==DOWN)
		{
			if(movFlag==1)
			{
			currentImg=heroMovImgDown[1];
			movFlag=2;
			}
			else
			}
			currentImg=heroMovImgDown[2];
			movFlag=1;
			}
		}
		if(action==LEFT)
		{
			if(movFlag==1)
			{
			currentImg=heroMovImgLeft[1];
			movFlag=2;
			}
			else
			}
			currentImg=heroMovImgLeft[2];
			movFlag=1;
			}
		}
		if(action==RIGHT)
		{
			if(movFlag==1)
			{
			currentImg=heroMovImgRight[1];
			movFlag=2;
			}
			else
			}
			currentImg=heroMovImgRight[2];
			movFlag=1;
			}
		}
		repaint();
	}
}