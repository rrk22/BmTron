import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import javax.swing.*;

public class test extends Applet implements KeyListener

{
	Font scorefont = new Font("Times Roman",Font.PLAIN,20);

	public static final int VK_DOWN = 40, Rdown =40;
	public static final int	VK_UP   = 38, Rup = 38;
	public static final int	VK_RIGHT = 39 , Rright = 39;
	public static final int	VK_LEFT	= 37, Rleft = 37;

	int x = 0, y = 0, a = 0, b = 0, releasedkey = 0, currentkey = 0, currentkeytwo = 0;
	boolean neverstop = true, pressed = false, left=false, right = false, up = false, down = false;
	boolean A = false, D = false, W = false, S = false;
	boolean outofboundsone = false, outofboundstwo = false, finished = false, filledspace= false, gameover = false;
	boolean pausegame = false;
	String currentkeyword = "", currentkeywordtwo = "";
	int direction = 0, pause = 50, size = 10, time = 0, timecount = 0;
	int order = 0;

	//initials
	int width = getSize().width;
 	int height = getSize().height;
	Graphics g = getGraphics();
	Grid grid;
	player playa;
	player playatwo;

	KeyEvent e;
				public void paint (Graphics g)
			{
					int width = getSize().width;
 					int height = getSize().height;




				order++;
				System.out.println("paint order is: " + order);
				Grid grid = new Grid(g,this,width,height);



			}

			public void init()
			{

					reseteverythingelse ();
					int width = getSize().width;
 					int height = getSize().height;
					setVisible(true);
					Graphics g = getGraphics();
					grid = new Grid(g,this,width,height);
					grid.resetGrid(g);


					//creates two players
					playa = new player(10,10,Color.blue,Color.blue,0);
					playatwo = new player(10,10,Color.red,Color.red,0);

					//add players to the grid
					grid.addPlayer (playa,g,50,25,x,y);
					grid.addPlayer (playatwo,g,20,25,a,b);
					grid.showscore(g,60,30,playa,playatwo);
					grid.resetGrid(g);

			//	while (!gameover)

					while(!finished)   //while not finished, continue
					{
						if (!pausegame) // while not finisned **AND** the game isn't paused, continue
				{

						if (pressed)
						{ }

						else
						{
							continueoption(grid);
						}

						if (!pausegame)



						if (!outofboundsone && !outofboundstwo)
						{
							moveoption();
							grid.movePlayer (playa,g,x,y);
							System.out.println("(" + x + "," + y + ")");
						//	stuff.drawGrid(g);

							grid.movePlayer (playatwo,g,a,b);
							System.out.println("(" + a + "," + b + ")");
						//	stuff.drawGrid(g);
						}

						else if (!outofboundsone && outofboundstwo)
						{

							playa.winround();
							grid.showscore(g,60,30,playa,playatwo);
							Expo.delay(750);
						    grid.resetGrid(g);
							reseteverythingelse();
							grid.movePlayer (playa,g,x,y);
							grid.movePlayer (playatwo,g,a,b);
							grid.showscore(g,60,30,playa,playatwo);

						}
						else if (outofboundsone && !outofboundstwo)
						{

							playatwo.winround();
							grid.showscore(g,60,30,playa,playatwo);
							Expo.delay(750);
							grid.resetGrid(g);
							reseteverythingelse();
							grid.movePlayer (playa,g,x,y);
							grid.movePlayer (playatwo,g,a,b);
							grid.showscore(g,60,30,playa,playatwo);


						}



						else if (outofboundsone && outofboundstwo)
						{

							grid.showscore(g,60,30,playa,playatwo);
							Expo.delay(750);
						    grid.resetGrid(g);
							reseteverythingelse();
							grid.movePlayer (playa,g,x,y);
							grid.movePlayer (playatwo,g,a,b);
							grid.showscore(g,60,30,playa,playatwo);

						}




						if (playa.getscore() == 10 || playatwo.getscore() == 10)
						{

							finished = true;
						}

						Expo.delay(pause);

						addKeyListener ( this ) ;
			}
					}

								if (playa.getscore() == 10 && playatwo.getscore() != 10)
							{
								grid.victory (g,"Player 1 is the winner!!!",500,30, Color.blue);
							}
							else if (playa.getscore() != 10 && playatwo.getscore() == 10)
							{
								grid.victory (g,"Player 2 is the winner!!!",500,30, Color.red);
							}
							else if (playa.getscore() == 10 && playatwo.getscore() == 10)
							{
								grid.victory (g,"There is no winner!!!",500,30, Color.red);
							}



			}

		public void reseteverythingelse ()
		{
			neverstop = true; pressed = false; left=false; right = false; up = false; down = false;
			A = false; D = false; W = false; S = false;
			outofboundsone = false; outofboundstwo = false;
			currentkeyword = ""; currentkeywordtwo = "";
			direction = 0;
			x = 50; y = 25;
			a = 20; b = 25;
		}




		public void keyPressed ( KeyEvent e)
		{


			//reset methods
			Graphics g = getGraphics();
			pressed = true;
			currentkey = e.getKeyCode();
			currentkeytwo = e.getKeyCode();

			if (!pausegame)
		{	    //sets keylistner to only recognize keys that affect the game for...

				//...player one
			if (
				e.getKeyText(currentkey).equals("Up") ||
				e.getKeyText(currentkey).equals("Down") ||
				e.getKeyText(currentkey).equals("Left") ||
				e.getKeyText(currentkey).equals("Right")

				)
			{
				currentkeyword = e.getKeyText(currentkey);
			}

			    //...player two
			if (
				e.getKeyText(currentkeytwo).equals("W") ||
				e.getKeyText(currentkeytwo).equals("S") ||
				e.getKeyText(currentkeytwo).equals("A") ||
				e.getKeyText(currentkeytwo).equals("D")

				)
			{
				currentkeywordtwo = e.getKeyText(currentkeytwo);
			}


			System.out.println("current key pressed "  + "\"" + currentkeyword + "\"" + " keycode: " + currentkey);

	//	g.fillRect(x,y,size,size);
		left=false; right = false; up = false; down = false;
		A = false; D = false; W = false; S = false;
		//playerone keyoptions
		if (currentkeyword.equals("Up") || currentkeyword.equals("Down") || currentkeyword.equals("Left") || currentkeyword.equals("Right"))
		{
			if (currentkeyword.equals("Up"))
			{


				if (y-1<0)
				{
					outofboundsone = true;
				}
				else
				{
					filledspace = grid.gettruthval(x,y-1);

					if (filledspace)
					{
						outofboundsone = true;
					}
					else
					{

						up = true;

					}
				}



			}
			else if (currentkeyword.equals("Down"))
			{


				if (y+1>49)
				{
					outofboundsone = true;
				}
				else
				{
					filledspace = grid.gettruthval(x,y+1);

					if (filledspace)
					{
						outofboundsone = true;
					}

					else
					{
						down = true;

					}
				}


			}

			else if (currentkeyword.equals("Left"))
			{
				if (x-1<0)
				{
					outofboundsone = true;
				}
				else
				{
					filledspace = grid.gettruthval(x-1,y);
					if (filledspace)
					{
						outofboundsone = true;
					}
					else
					{
						left = true;

					}
				}

			}
			else if (currentkeyword.equals("Right"))
			{
				if(x+1>69)
				{
					outofboundsone = true;
				}
				else
				{
					filledspace = grid.gettruthval(x+1,y);
					if (filledspace)
					{
						outofboundsone = true;
					}
				else
				{
					right = true;

				}
				}

			}
		}

		//playertwo keyoptions
		if (currentkeywordtwo.equals("W") || currentkeywordtwo.equals("S") || currentkeywordtwo.equals("A") || currentkeywordtwo.equals("D"))
		{
			if (currentkeywordtwo.equals("W"))
			{


				if (b-1<0)
				{
					outofboundstwo = true;
				}
				else
				{
					filledspace = grid.gettruthval(a,b-1);

					if (filledspace)
					{
						outofboundstwo = true;
					}
					else
					{

						W = true;

					}
				}



			}
			else if (currentkeywordtwo.equals("S"))
			{


				if (b+1>49)
				{
					outofboundstwo = true;
				}
				else
				{
					filledspace = grid.gettruthval(a,b+1);

					if (filledspace)
					{
						outofboundstwo = true;
					}

					else
					{
						S = true;

					}
				}


			}

			else if (currentkeywordtwo.equals("A"))
			{
				if (a-1<0)
				{
					outofboundstwo = true;
				}
				else
				{
					filledspace = grid.gettruthval(a-1,b);
					if (filledspace)
					{
						outofboundstwo = true;
					}
					else
					{
						A = true;

					}
				}

			}
			else if (currentkeywordtwo.equals("D"))
			{
				if(a+1>69)
				{
					outofboundstwo = true;
				}
				else
				{
					filledspace = grid.gettruthval(a+1,b);
					if (filledspace)
					{
						outofboundstwo = true;
					}
					else
				{
					D = true;

				}
				}

			}
		}







	}
			pressed = false;
		}



    public void keyTyped ( KeyEvent e )
    	{
    	if (e.getKeyText(currentkey).equals("P"))
			{
				if (!pausegame)
				{pausegame = true;}
				else if (pausegame)
				{pausegame = false;}
			}
    	}


	public void keyReleased ( KeyEvent e ) { }

	public void continueoption(Grid grid)
		{
			if (!pausegame)
			{
				if (up)
				{
					if (y-1<0)
					{
							outofboundsone = true;
					}

					else
					{
					filledspace = grid.gettruthval(x,y-1);

							if (filledspace)
							{
								outofboundsone = true;
							}
							else
							{
								up = true;

							}
					}
				}

				else if (down)
				{

					if (y+1>49)
					{
						outofboundsone = true;
					}
					else
					{
						filledspace = grid.gettruthval(x,y+1);

						if (filledspace)
						{
							outofboundsone = true;
						}

						else
						{
							down = true;

						}
					}
				}

				else if (right)
				{
					if(x+1>69)
					{
						outofboundsone = true;
					}
					else
					{
						filledspace = grid.gettruthval(x+1,y);

						if (filledspace)
						{
							outofboundsone = true;
						}
						else
						{
						right = true;

						}
					}
				}


				else if (left)
				{
					if (x-1<0)
					{
						outofboundsone = true;
					}
					else
					{
						filledspace = grid.gettruthval(x-1,y);
						if (filledspace)
						{
							outofboundsone = true;
						}
						else
						{
							left = true;

						}
					}
				}

				if (W)
				{
						if (b-1<0)
						{
							outofboundstwo = true;
						}
						else
						{
							filledspace = grid.gettruthval(a,b-1);
							if (filledspace)
							{
								outofboundstwo = true;
							}
							else
							{

								W = true;

							}
					}
				}
				else if (S)
				{
					if (b+1>49)
					{
						outofboundstwo = true;
					}
					else
					{
						filledspace = grid.gettruthval(a,b+1);

						if (filledspace)
						{
							outofboundstwo = true;
						}

						else
						{
							S = true;

						}
					}
				}
				else if (A)
				{
					if (a-1<0)
					{
						outofboundstwo = true;
					}
					else
					{
						filledspace = grid.gettruthval(a-1,b);
						if (filledspace)
						{
							outofboundstwo = true;
						}
						else
						{
							A = true;

						}
					}
				}
				else if (D)
				{
					if(a+1>69)
					{
						outofboundstwo = true;
					}
					else
					{
						filledspace = grid.gettruthval(a+1,b);
						if (filledspace)
						{
							outofboundstwo = true;
						}
						else
						{
							D = true;

						}
					}
				}
		}
			}

			public void moveoption()
			{
				if (up)
				{
					y -= 1;
				}
				else if (down)
				{
					y += 1;
				}
				else if (left)
				{
					x -= 1;
				}
				else if (right)
				{
					x += 1;
				}

				if (W)
				{
					b -= 1;
				}
				else if (S)
				{
					b += 1;
				}
				else if (A)
				{
					a -= 1;
				}
				else if (D)
				{
					a += 1;
				}
			}





}
