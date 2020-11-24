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
	Image[][] heroMovImg=new Image[4][3];
	Image currentImg;
	int x=111,y=111;
	int movFlag=1;
	public MainCanvas()
	{
		try
		{
			for(int i=0;i<4;i++)
			{
				for(int j=0;j<3;j++)
				{
					heroMovImg[i][j]=Image.createImage("/sayo"+j+i+".png");
				}
			}
			
			currentImg=heroMovImg[3][1];
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	public void paint(Graphics g){
		g.setColor(0,0,0);
		g.fillRect(0,0,getWidth(),getHeight());
		g.drawImage(currentImg,x,y,0);
	}
	public void heroMove(int action)
	{
		if(action>4)
			action-=2;

		if(movFlag==1)
		{
		currentImg=heroMovImg[action-1][0];
		movFlag=2;
		}
		else
		{
		currentImg=heroMovImg[action-1][2];
		movFlag=1;
		}	
	}
	public void keyPressed(int keyCode)
	{
		int action=getGameAction(keyCode);
		if(action==UP)
			y--;
		if(action==DOWN)
			y++;
		if(action==LEFT)
			x--;
		if(action==RIGHT)
			x++;
		heroMove(action);
		repaint();
	}
}