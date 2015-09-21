import java.awt.*;
import java.applet.*;

public class square extends Applet implements Runnable
{
	boolean left = false, right = false, up = false, down = false, started = false;
	boolean bob = false;
		int x = 0;
		int y = 0;
		Graphics graph = getGraphics();

	public void paint (Graphics g)
	{

		g.setColor(Color.blue);
		g.fillRect(x,y,100,100);




	}

	public void step ()
	{

	}
	public void run ()
	{

	}


		public boolean keyDown(Event e, int key)
	{
		Graphics g = getGraphics();
		if ((key == Event.LEFT) &&(!right)){left = true; up = false; down = false;if(!started)started=true;}
		if ((key == Event.RIGHT) && (!left)){right = true; up = false; down = false;if(!started)started=true;}
		if ((key == Event.UP) && (!down)){ up = true; right = false; left = false;if(!started)started=true;}
		if ((key == Event.DOWN) && (!up)){down = true; right = false; left = false;if(!started)started=true;}



			if (left)
			{x -= 100;
			g.fillRect(x,y,100,100);
			}
			if (right)
			{x +=100;
			g.fillRect(x,y,100,100);
			}
			if (up)
			{y +=100;
			g.fillRect(x,y,100,100);
			}
			if (down)
			{y -= 100;
			g.fillRect(x,y,100,100);
			}

		return true;
	}
}