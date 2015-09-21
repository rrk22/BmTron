	import java.awt.*;
	import java.applet.*;
	import java.awt.event.*;
	import java.util.*;

	public class KeyListenerTester extends Applet implements KeyListener
	{


	public static final int VK_DOWN = 40, Rdown =40;
	public static final int	VK_UP   = 38, Rup = 38;
	public static final int	VK_RIGHT = 39 , Rright = 39;
	public static final int	VK_LEFT	= 37, Rleft = 37;
	int x=0, y=0, releasedkey = 0;
	boolean begin = false;
	int direction = 0;

	KeyEvent e;
	public KeyListenerTester ()
	{
		setSize ( 800,600 );
		addKeyListener ( this ) ;
		setVisible(true);




	}

	public void options()
	{

	}


	public void keyPressed ( KeyEvent e) { }


    public void keyTyped ( KeyEvent e ) {}


	public void keyReleased ( KeyEvent e ) { }



  }
