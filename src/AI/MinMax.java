package AI;

import java.util.ArrayList;

import puissance.Grid;
import puissance.Player;

public class MinMax {

	Grid grid;
	
	private int prof;
	
	public MinMax(Grid grid,int prof)
	{
		this.grid = grid;
		this.prof = prof;
	}
	
	public int AI()
	{
		
		int poMove = 0;
	    int max = -10000;
	    int tmp;
		
	    int profondeur = prof;
	    
	    ArrayList<Integer> positions = grid.getPossiblePositions();
	    
		for (Integer pos : positions) {
			
			grid.addValue(Player.AI, pos);
			
			tmp = min(grid,profondeur - 1);
			
			if( tmp > max )
			{
				max = tmp;
				poMove = pos;
			}
			
			grid.delValue(pos);
			
		}
			
		grid.addValue(Player.AI, poMove);
		
		return poMove;
		
	}

	public int min(Grid grid, int profondeur)
	{
		if(grid.isFull() || eval() != 0 || profondeur <= 0)
		{
			if( profondeur <= 0 )
			{
				return grid.evalProgress(Player.AI) - grid.evalProgress(Player.FIRST);
			
			}else{
				
				return eval();
			}
			
		}
		
	    int min = 10000;
	    int tmp;
		
	    ArrayList<Integer> positions = grid.getPossiblePositions();
	    
		for (Integer pos : positions) {
			
			grid.addValue(Player.FIRST, pos);
			
			tmp = max(grid, profondeur - 1);
			
			if( tmp < min )
			{
				min = tmp;
			}
			
			grid.delValue(pos);
		}
		
		return min;
	}
	
	public int max(Grid grid, int profondeur)
	{
		if(grid.isFull() || eval() != 0 || profondeur <= 0)
		{
			if( profondeur <= 0 )
			{
				return grid.evalProgress(Player.AI) - grid.evalProgress(Player.FIRST);
			
			}else{
				
				return eval();
			}
			
		}
		
	    int max = -10000;
	    int tmp;
		
	    ArrayList<Integer> positions = grid.getPossiblePositions();
	    
		for (Integer pos : positions) {
			
			grid.addValue(Player.AI, pos);
			
			tmp = min(grid, profondeur - 1);
			
			if( tmp > max )
			{
				max = tmp;
			}
			
			grid.delValue(pos);
		}
		
		return max;
	}
	
	
	public int eval()
	{
		if( grid.checkWin(Player.AI))
		{
			return 10;
			
		}else if(grid.checkWin(Player.FIRST))
		{
			return -10;
			
		}else{
			
			return 0;
		}
	}
	
	public void setProf(int prof)
	{
		this.prof = prof;
	}
	
	public int getProf()
	{
		return prof;
	}
}
