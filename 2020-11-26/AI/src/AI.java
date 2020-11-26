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
		Image[][] heroImg=new Image[4][3];
		Image currentImg;
		int x=111,y=111;
		int imgFlag=1;
	public MainCanvas(){
		try{
			for (int i=0;i<4 ;i++ )
			{
				for (int j=0;j<3 ;j++ )
				{
					heroImg[i][j]=Image.createImage("/sayo"+j+i+".png");
				}
			}
			currentImg=heroImg[0][1];
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}
	public void paint(Graphics g){
		g.setColor(250,200,180);
		g.fillRect(0,0,getWidth(),getHeight());
		g.drawImage(currentImg,x,y,0);
	}
	public void heroMov(int direction)
	{
		if(imgFlag==1)
		{
			currentImg=heroImg[direction][0];
			imgFlag=0;
		}
		else
		{
			currentImg=heroImg[direction][1];
			imgFlag=1;
		}
	}
	public void keyPressed(int keyCode){
		int action=getGameAction(keyCode);
		if (action==UP)
		{
			heroMov(2);
			y--;
		}
		if (action==DOWN)
		{
			heroMov(0);
			y++;
		}
		if (action==LEFT)
		{
			heroMov(1);
			x--;
		}
		if (action==RIGHT)
		{
			heroMov(3);
			x++;
		}
		repaint();
	}
}