package UI;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import AI.MinMax;
import puissance.Grid;
import puissance.Player;

public class PlayArea extends JPanel {

	private static final int MARGIN_LEFT = 43;

	/**
	 * PlayArea , espace de jeux 
	 */
	private static final long serialVersionUID = 1L;

	public static int BOX_SIZE = 60;
	
	Grid grid = null;;
	
	Player player1;
	
	Player player2;
	
	public PlayArea(Grid grid) {
		
		this.setSize(new Dimension(20, GamePlay.WDITH));
		
		this.grid = grid;	
		
	}
	
	public void paintComponent(Graphics g)
	{
		 String imgPath = "assets/playarea.png";
		 
		  try {
		      
			  Image img = ImageIO.read(new File(imgPath));
		  
		      g.drawImage(img, 0, 0, this);
		      
		  }catch (Exception e) {
			  
			  System.out.println(e.getMessage());
		}
		  
		  
		  String playImg = null;
		  
		  for(int i=0;i<Grid.HEIGHT;i++)
		  {
			  for(int j=0;j<Grid.WIDTH;j++)
			  {
				  
				  if( grid.getGrid()[i][j] == Player.FIRST )
				  {
					playImg  = "assets/green.png"; 
					
				  }else if( grid.getGrid()[i][j] == Player.AI )
				  {
					playImg = "assets/red.png";
				  }else{
					  
					  continue;
				  }
				  
				  
				  try {
				      
					  Image img = ImageIO.read(new File(playImg));
				  
				      g.drawImage(img, j*BOX_SIZE + MARGIN_LEFT, i*BOX_SIZE + MARGIN_LEFT, this);
				   
				  } catch (IOException e) {
				      e.printStackTrace();
				  } 
			  }
		  } 
		
	}
	
	public int getRealPosition(int width)
	{	
		return (width - MARGIN_LEFT) / BOX_SIZE ;
	}
	
}

