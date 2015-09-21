import java.awt.*;
import java.applet.*;

public class PlayingField
{
	int [][] field;

	public PlayingField (int x, int y)
	{
		field = new int [x][y];
	}
	public void filllines()
	{
		int a = 0;
		int b = 0;
		int lcvx = 800/40;
		int lcvy = 600/40;
		for (int x = 1; x<=lcvx; x++)
		{
			for (int y = 1; y<=lcvy; y++)
			{
				field[x][y] = 1;
			}
		}
	}
}