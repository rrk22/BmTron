import java.awt.*;
import java.applet.*;

public class Grid
{
	int width, height, bordersize, time;
	Color newgray = new Color(125,125,125);
	boolean [][] truthtable;
	Font scorefont = new Font("Times Roman",Font.PLAIN,20);


	public Grid (Graphics g, Applet a, int x, int y)
	{
		truthtable = new boolean [70][50];
		width = a.getSize().width;
 		height = a.getSize().height;
 		time = 0;
 		g.setColor(Color.black);
 		g.fillRect(0,0,width,height);
		g.setColor(newgray);
		g.drawRect(50,50,700,500);
	//	drawGrid(g);
		a.setVisible(true);
	}




	public void addPlayer (player p, Graphics g, int x, int y, int variableone, int variabletwo)
	{
		Color a = p.head;
		Color b = p.body;
		fillsquare(g,x,y,a,b);
		truthtable[x][y] = true;
		variableone = x;
		variabletwo = y;

	}
		public void movePlayer (player p, Graphics g, int x, int y)
	{
		Color a = p.head;
		Color b = p.body;
		fillsquare(g,x,y,a,b);
		truthtable[x][y] = true;

	}

	public void resetGrid(Graphics g)
	{
		resettruthtable ();
		g.setColor(Color.black);
 		g.fillRect(0,0,width,height);
		g.setColor(newgray);
		g.drawRect(50,50,700,500);
	//	drawGrid(g);
	}

	public boolean gettruthvalue (int x, int y)
	{
		return truthtable[x][y];
	}
	public void fillsquare(Graphics g, int x, int y,Color square, Color original)
	{

		g.setColor(square);
		g.fillRect(50 + (10*x),50 + (10*y),10,10);
		g.setColor(original);
	}
	public void drawsquare(Graphics g, int x, int y,Color square, Color original)
	{

		g.setColor(square);
		g.fillRect(x,y,10,10);
		g.setColor(original);
	}

	public void showscore(Graphics g,int x, int y,player first, player second)
	{
		int one = first.score;
		int two = second.score;

		g.setColor(Color.black);
		g.fillRect(60,10,410,30);


		g.setFont(scorefont);
		g.setColor(Color.blue);
		g.drawString("Player one: " + one + "              ",x,y);
		g.setColor(Color.red);
		g.drawString("Player two: " + two,x+200,y);
		g.setColor(Color.black);
	}
	public void printout (Graphics g, int x, int y, String s)
	{
		g.setColor(Color.green);
		g.fillRect(x,y-20,x+150,y);
		g.setColor(Color.red);
		g.setFont(scorefont);
		g.drawString(s,x,y);
	}

	public void showTime (Graphics g,int x, int y)
	{
		g.setFont(scorefont);
		g.setColor(Color.red);
		g.drawString("The current time is: " + time,x,y);
		g.setColor(Color.black);
	}

	public void nextTime()
	{
		time += 1/1000;
	}

	public void drawGrid(Graphics g)
	{
	int a = 50;
	int b = 50;
	int c = 50;
	int d = 550;
	g.setColor(newgray);

		for (int x = 1; x<=70; x++)
		{
			g.drawLine(a,b,c,d);
			a += 10;
			c += 10;
		}

	 a = 50;
	 b = 50;
	 c = 750;
	 d = 50;

	 	for (int y = 1; y<=50; y++)
		{
			g.drawLine(a,b,c,d);
			b += 10;
			d += 10;
		}

	}



	public int getwidth()
	{	return width;	}

	public int getheight()
	{	return height;  }

	public boolean gettruthval (int x, int y)
	{
		return truthtable[x][y];
	}
	public void resettruthtable ()
	{
		truthtable = new boolean [70][50];
	}
	public void victory (Graphics g, String s,int x, int y, Color c)
	{
		g.setColor(c);
		g.setFont(scorefont);
		g.drawString(s,x,y);
		g.setColor(Color.black);
	}

}

class stuff
{
		static Color newgray = new Color(125,125,125);

		public static void drawGrid(Graphics g)
	{

	int a = 50;
	int b = 50;
	int c = 50;
	int d = 550;
	g.setColor(newgray);
	g.drawRect(50,50,700,500);

		for (int x = 1; x<=70; x++)
		{
			g.drawLine(a,b,c,d);
			a += 10;
			c += 10;
		}

	 a = 50;
	 b = 50;
	 c = 750;
	 d = 50;

	 	for (int y = 1; y<=50; y++)
		{
			g.drawLine(a,b,c,d);
			b += 10;
			d += 10;
		}

	}
}