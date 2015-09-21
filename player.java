import java.awt.*;


public class player
{
	int score;
	int xcoordorigin;
	int ycoordorigin;
	int currentxcoord;
	int currentycoord;
	int width;
	int height;
	Color body;
	Color head;



	public player (int w, int h, Color main, Color front, int s)
	{

		width  = w;
		height = h;
		body   = main;
		head   = front;
		score = s;
	}

	public void winround()
	{
		score++;
	}

	public int getscore ()
	{
		return score;
	}






}