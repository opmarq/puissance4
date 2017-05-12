package puissance;

import java.util.Scanner;

import AI.MinMax;
import UI.GamePlay;

public class Puissance {

	public static void main(String[] args) {
		
		Grid grid = new Grid();
	
		
		Player player1 = new Player(Player.FIRST, grid);

		Player player2 = new Player(Player.AI, grid);
		
		

		
		GamePlay gameplay = new GamePlay();
		
	//	MinMax minmax = new MinMax(grid,7);
		
		
/*	
	//	minmax.AI();
		
		Scanner sc = new Scanner(System.in);
		
		int position = -1;
		
		boolean switchTurns = true;
		
		grid.printGrid();
		
		while(!grid.isFull())
		{
			
			
			if(switchTurns)
			{
				System.out.println("Player 1 : ");
				position = sc.nextInt();
				player1.play(position);
				
				System.out.println("Progress of P1 : " + grid.evalProgress(Player.FIRST));
				
			}else{
				minmax.AI();
				
				System.out.println("Progress of AI : " + grid.evalProgress(Player.AI));
			}
				
			if(grid.checkWin(Player.AI))
			{
				System.out.println("AI win");
				break;
			}else if(grid.checkWin(Player.FIRST))
			{
				System.out.println("Player win");
				break;
			}
			
			switchTurns = !switchTurns;

			
			
			grid.printGrid();
			
		}

	*/	 
		 
	}

}
