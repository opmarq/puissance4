package puissance;

import AI.MinMax;

public class Player {

	public static final int FIRST = 1;
	public static final int AI = 2;
	
	private int player;
	
	Grid grid = null;
	
	MinMax minmax = null;
	
	public Player(int player,Grid grid)
	{
		this.player = player;
		this.grid = grid;
		
	}
		
	public void play(int col)
	{
		grid.addValue(player, col);
	}
	
	public int getPlayer()
	{
		return this.player;
	}
	
}
