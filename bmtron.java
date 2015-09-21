import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import java.util.*;
import javax.swing.*;

public class bmtron extends Applet

{
	public void paint (Graphics g)
	{
		int width = getSize().width;
 		int height = getSize().height;
		Scanner scan = new Scanner(System.in);
		int a = 0;
		int b = 0;

		g.fillRect(0,0,width,height);
		g.setColor(Color.yellow);
		drawGrid(g);
		surprise();


			//	question.asknum(scan,g);

		boolean bob = false;
		boolean correct = true;

		while (!bob)
		{
			System.out.println();
			System.out.print("Enter an x-coordinate here ->>>     ");
			a = scan.nextInt();

			System.out.print("Enter a  y-coordinate here ->>>     ");
			b = scan.nextInt();
			if (a>19 || a<0 || b>19 || b<0)
			{
				correct = false;
			}
			while (!correct)
			{
				System.out.println();
				System.out.println("Error, Location (" + a + "," + b + ") is invalid,");
				System.out.println("Please enter a valid location");
				System.out.println();
				System.out.print("Enter an x-coordinate here ->>>     ");
				a = scan.nextInt();
				System.out.print("Enter a  y-coordinate here ->>>     ");
				b = scan.nextInt();
				if (a<=19 && a>=0 && b<=19 && b>=0)
				{
					correct = true;
				}


			}

			System.out.println();
			addredSquare(a,b);
			System.out.println("Current red square drawn at (" + a + "," + b + ")");

		}


	}
			public void surprise ()
			{

	for(int y =0; y<20; y++)
	{

		for(int x =0; x<20; x++)
		{
		addblueSquare(x,y);
		Wait.milisec(20);
		System.out.println("Current blue square drawn at (" + x + "," + y + ")");



		}

	}






		for(int y =0; y<20; y++)
	{

		for(int x =0; x<20; x++)
		{
		addSquare(x,y);
		Wait.milisec(10);
		System.out.println("Current blue square drawn at (" + x + "," + y + ")");

		{
			if (x>4)
			{
			addblueSquare(x-5,y);
			}

		}

		if (x==19)
		{
			int ron = 5;
			for (int bob = 1; bob<=6; bob++)
			{
			Wait.milisec(10);
			addblueSquare(x-ron,y);
			ron--;
			}
		}
		}

	}





		for(int y =0; y<20; y++)
	{

		for(int x =0; x<20; x++)
		{
		addblueSquare(x,y);
		Wait.milisec(10);
		System.out.println("Current blue square drawn at (" + x + "," + y + ")");

		{
			addSquare(x-5,y);

		}

		if (x==19)
		{
			int ron = 5;
			for (int bob = 1; bob<=6; bob++)
			{
			Wait.milisec(10);
			addSquare(x-ron,y);
			ron--;
			}
		}
		}

	}
			}


			public void drawGrid(Graphics g)
			{
				int incx = 800/20;
				int incy = 600/20;
				int currentx = 100;
				int currenty = 100;

				g.drawRect(100,100,800,600);

				for (int x =1; x<=20; x++)
				{
					g.drawLine(currentx,100,currentx,700);
					currentx += incx;
				}

					for (int y =1; y<=20; y++)
				{
					g.drawLine(100,currenty,900,currenty);
					currenty += incy;
				}
			}
			public void addblueSquare(int x, int y)
			{

				int xstart = 100;
				int ystart = 100;

				Graphics g = getGraphics();
				g.setColor(Color.blue);
				x = xstart + x*(800/20);
				y = ystart + y*(600/20);
				g.fillRect(x+1,y+1,39,29);
			}

			public void addredSquare(int x, int y)
			{

				int xstart = 100;
				int ystart = 100;

				Graphics g = getGraphics();
				g.setColor(Color.red);
				x = xstart + x*(800/20);
				y = ystart + y*(600/20);
				g.fillRect(x+1,y+1,39,29);
			}
			public void addSquare(int x, int y)
			{

				int xstart = 100;
				int ystart = 100;

				Graphics g = getGraphics();
				g.setColor(Color.black);
				x = xstart + x*(800/20);
				y = ystart + y*(600/20);
				g.fillRect(x+1,y+1,39,29);
			}
			public void ask ()
			{
				boolean cont = false;
				Scanner scan = new Scanner(System.in);
				int num = 1;

				while (!cont)
				{
				System.out.print("Enter the Amount of seconds you want to start in ->>  ");
				num = scan.nextInt();
				System.out.println("\n");
				if (num>=1)
				{cont = true;}
				}
				for (int x = num; x>=1; x--)
				{

					if (x==1)
					{
						System.out.println("        " + x + " second ...");
						Wait.sec(1);
						System.out.println("...");
					}
					else if (x== num)
					{
						System.out.println("T-minus " + x + " seconds ...");
						Wait.sec(1);
					}
					else
					{
					System.out.println("        " + x + " seconds ...");
					Wait.sec(1);
					}
				}

			}

			public void update (Graphics g)
			{
				paint(g);
			}



}

class Wait {
public static void milisec(long s) {
try {
Thread.currentThread().sleep(s);
}
catch (InterruptedException e) {
e.printStackTrace();
}
}
public static void sec(long s) {
try {
Thread.currentThread().sleep(s * 1000);
}
catch (InterruptedException e) {
e.printStackTrace();
}
}
}

class question

{
	public static void asknum (Scanner scan, Graphics g)
	{
		String firstnum = JOptionPane.showInputDialog("Enter an x-coordinate here ->>>     ");
		String lastnum = JOptionPane.showInputDialog("Enter a  y-coordinate here ->>>     ");
		int a = Integer.parseInt(firstnum);
		int b = Integer.parseInt(lastnum);


		boolean bob = false;
		boolean correct = true;

		while (!bob)
		{

			firstnum = JOptionPane.showInputDialog("Enter an x-coordinate here ->>>     ");
			a = Integer.parseInt(firstnum);

			lastnum = JOptionPane.showInputDialog("Enter a  y-coordinate here ->>>     ");
			b = Integer.parseInt(lastnum);

			if (a>19 || a<0 || b>19 || b<0)
			{
				correct = false;
			}
			while (!correct)
			{
				System.out.println();
				JOptionPane.showMessageDialog(null,"Error, Location (" + a + "," + b + ") is invalid,");
				JOptionPane.showMessageDialog(null,"Please enter a valid location");

				firstnum = JOptionPane.showInputDialog("Enter an x-coordinate here ->>>     ");
				a = Integer.parseInt(firstnum);
				JOptionPane.showInputDialog("Enter a  y-coordinate here ->>>     ");
				b  = Integer.parseInt(lastnum);
				if (a<=19 && a>=0 && b<=19 && b>=0)
				{
					correct = true;
				}


			}

			System.out.println();
			addredSquare(a,b,g);
			System.out.println("Current blue square drawn at (" + a + "," + b + ")");

		}


		JOptionPane.showMessageDialog(null,"The Coordinate of the box drawn is (" + a + "," + b + ")");

		System.exit(0);

	}

		public static void addredSquare(int x, int y, Graphics g)
			{

				int xstart = 100;
				int ystart = 100;


				g.setColor(Color.red);
				x = xstart + x*(800/20);
				y = ystart + y*(600/20);
				g.fillRect(x+1,y+1,39,29);
			}
}