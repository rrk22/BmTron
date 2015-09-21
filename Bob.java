	import java.awt.*;
	import java.applet.*;
	import java.awt.event.*;
	import java.util.*;

	public class bob extends Applet implements KeyListener
	{


	public static final int VK_DOWN = 40, Rdown =40;
	public static final int	VK_UP   = 38, Rup = 38;
	public static final int	VK_RIGHT = 39 , Rright = 39;
	public static final int	VK_LEFT	= 37, Rleft = 37;
	int x=0, y=0, releasedkey = 0, currentkey = 0;
	boolean neverstop = true, pressed = false;
	String currentkeyword = "";
	int direction = 0;

	KeyEvent e;
	/*public bob ()
	{
		setSize ( 800,600 );
		addKeyListener ( this ) ;
		setVisible(true);




	}*/

	public void init()
	{
		setSize ( 800,600 );
		addKeyListener ( this ) ;
		setVisible(true);
		while(neverstop)
		{
			if (pressed)
			{

			}
			else
			{
				continueoption();
			}
		}
	}

	public void options()
	{

	}

	public void continueoption ()
	{
		Graphics g = getGraphics();
		if (currentkeyword.equals("Up"))
		{
			y-= 50;
			g.fillRect(x,y,50,50);
			Expo.delay(500);
		}
		else if (currentkeyword.equals("Down"))
		{
			y+= 50;
			g.fillRect(x,y,50,50);
			Expo.delay(500);
		}
		else if (currentkeyword.equals("Left"))
		{
			x-= 50;
			g.fillRect(x,y,50,50);
			Expo.delay(500);
		}
		else if (currentkeyword.equals("Right"))
		{
			x+= 50;
			g.fillRect(x,y,50,50);
			Expo.delay(500);
		}
	}


	public void keyPressed ( KeyEvent e)
		{
			Graphics g = getGraphics();
			pressed = true;
			currentkey = e.getKeyCode();
			currentkeyword = e.getKeyText(currentkey);
			System.out.println("current key pressed "  + "\"" + currentkeyword + "\"" + " keycode: " + currentkey);

		if (currentkeyword.equals("Up"))
		{
			y-= 50;
			g.fillRect(x,y,50,50);
			Expo.delay(500);
		}
		else if (currentkeyword.equals("Down"))
		{
			y+= 50;
			g.fillRect(x,y,50,50);
			Expo.delay(500);
		}
		else if (currentkeyword.equals("Left"))
		{
			x-= 50;
			g.fillRect(x,y,50,50);
			Expo.delay(500);
		}
		else if (currentkeyword.equals("Right"))
		{
			x+= 50;
			g.fillRect(x,y,50,50);
			Expo.delay(500);
		}
		pressed = false;
		}


    public void keyTyped ( KeyEvent e ) {}


	public void keyReleased ( KeyEvent e ) { }



  }
