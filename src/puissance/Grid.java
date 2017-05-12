package puissance;

import java.util.ArrayList;

public class Grid implements Cloneable {

	public static final int EMPTY = 0;
	public static final int WIN = 4;
	public static final int PROGRESS = 3;
	
	
	public static final int HEIGHT = 6;
	public static final int WIDTH = 7;
	
	
	int grid [][] = new int[HEIGHT][WIDTH];
	
	public Grid()
	{
		init();
	}
	
	public Grid(int [][] grid)
	{
		this.grid = grid;
	}
	
	public void init()
	{
		for(int i=0;i<HEIGHT;i++)
			for(int j=0;j<WIDTH;j++)
				grid[i][j] = EMPTY;
	}
	
	public boolean addValue(int val,int row)
	{
		
		for(int i=HEIGHT-1;i>=0;i--)
		{
			
			if( grid[i][row] == EMPTY )
			{
				grid[i][row] = val;
				return true;
			}
				
		}
		
		return false;
		
	}
	
	public boolean delValue(int row)
	{
		for(int i=0;i<HEIGHT;i++)
		{
			
			if( grid[i][row] != EMPTY )
			{
				grid[i][row] = EMPTY;
				return true;
			}
				
		}
		
		return false;
	}
	
	public boolean isFull()
	{
		boolean isFull = true;
		
		for(int i=0;i<WIDTH;i++)
		{
			if(!isColFull(i))
				isFull = false;
		}
		
		return isFull;
	}
	
	public boolean isColFull(int col)
	{
		if(grid[0][col] != EMPTY )
		{
			return true;
		}
		
		return false;
	}
	
	public void printGrid()
	{
		for(int i=0;i<HEIGHT;i++)
		{
			for(int j=0;j<WIDTH;j++)
			{
				System.out.print("|");
				System.out.print(grid[i][j]);
				System.out.print("|");
			}
			
			System.out.println();
		}
	}

	
	public int evalProgress(int p)
	{
		int count = 0;;
		
		int progress = 0;
		
		for(int i=0;i<HEIGHT;i++)
		{
			for(int j=0;j<WIDTH;j++)
			{
				if(grid[i][j] == p)
				{
					count++;
					
				}else if( count < 2 ){
					
					count = 0;
				}
			}
			
			if( count >= PROGRESS  )
			{
				progress++;
			}
	
			count = 0;
			
		}
		
	
		for(int i=0;i<WIDTH;i++)
		{
			for(int j=0;j<HEIGHT;j++)
			{
				if(grid[j][i] == p)
				{
					count++;
					
				}else if( count < 2 ){
					
					count = 0;
				}
			}
			
			if( count >= PROGRESS  )
			{
				progress++;
			}
	
			count = 0;
			
		}
			
		return progress;
		
	}
	
	
	public boolean checkWin(int p)
	{
		int count = 0;
		
		for(int i=0;i<HEIGHT;i++)
		{
			for(int j=0;j<WIDTH;j++)
			{
				if(grid[i][j] == p)
				{
					count++;
				}else if( count < WIN ){
					
					count = 0;
				}
			}
			
			if(count >= WIN)
			{
				return true;
			}
			
			count = 0;
		}
			
		
		for(int i=0;i<WIDTH;i++)
		{
			for(int j=0;j<HEIGHT;j++)
			{
				if(grid[j][i] == p)
				{
					count++;
				}else if( count < WIN ){
					
					count = 0;
				}
			}
			
			if(count >= WIN)
			{
				return true;
			}
			
			count = 0;
		}
		
		
		for(int i=0;i<3;i++)
		{
			for(int j=0;j<HEIGHT-i;j++)
			{
				if(grid[j+i][j] == p)
				{
					count++;
					
				}else if( count < WIN ){
					
					count = 0;
				}
			}
			
			if(count >= WIN)
			{
				return true;
			}
			
			count = 0;
		}
		
		
		
		for(int i=0;i<4;i++)
		{
			for(int j=0;j<HEIGHT-i;j++)
			{
				if(grid[j][j+i] == p)
				{
					count++;
					
				}else if( count < WIN ){
					
					count = 0;
				}
			}
			
			if(count >= WIN)
			{
				System.out.println("diago");
				
				return true;
			}
			
			count = 0;
		}
		
		
		for(int i=0;i<3;i++)
		{
			int j=HEIGHT;
			
			for(int k=0; k<HEIGHT-i; k++)
			{
				
			//	System.out.println("X:"+(k+i) +" Y"+j);
				
				if(grid[k+i][j] == p)
				{
					count++;
					
				}else if( count < WIN ){
					
					count = 0;
				}			
				
				if( j>i )
				{
					j--;
				}

			}
			
			if(count >= WIN)
			{
				return true;
			}
			
			count = 0;
		}
		
		
		for(int i=0;i<4;i++)
		{
			int j=HEIGHT;
			
			for(int k=0; k<HEIGHT-i; k++)
			{
				
				System.out.println("X:"+k +" Y"+(j-i));
			
				if(grid[k][j-i] == p)
				{
					count++;
					
				}else if( count < WIN ){
					
					count = 0;
				}			
				
			
				if( j>=i )
				{
					j--;
				}
				
				

			}
			
			if(count >= WIN)
			{
				return true;
			}
			
			count = 0;
		}
		
		return false;
		
	}
	
	public ArrayList<Integer> getPossiblePositions()
	{
		ArrayList<Integer> positions = new ArrayList<>();
		
		for(int i=0;i<WIDTH;i++)
		{
			if(!isColFull(i))
				positions.add(i);
		}
		
		return positions;	
	}
	
	public int[][] getGrid()
	{
		return this.grid;
	}
	
	public Object clone() {
		
    	Object o = null;
    	
    	try {

      		o = super.clone();
      		
    	} catch(CloneNotSupportedException cnse) {
      		cnse.printStackTrace(System.err);
	    }
    	
    	return o;
  	}
	
	
}
