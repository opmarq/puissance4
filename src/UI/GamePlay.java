package UI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Stack;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import AI.MinMax;
import puissance.Grid;
import puissance.Player;

public class GamePlay extends JFrame {

	/**
	 * Class qui va crée l'interface de gamePlay
	 */
	private static final long serialVersionUID = 1L;
	
	public final static int HEIGHT = 480;
	public final static int WDITH = 500;
	
	Stack<Integer> gamePlayHistory = new Stack<>();
	
	boolean switchTurn = true;
	
	String gameTitle = "AI Puissance 4";
	
	Grid grid = null;
	
	MinMax minmax = null;
	
	public GamePlay()
	{
		this.setTitle(gameTitle);
		this.setSize(new Dimension(WDITH, HEIGHT));
		this.setResizable(false);
		
		grid = new Grid();
		
		minmax = new MinMax(grid, 5);
		
		Menu menu = new Menu();
		
		PlayArea playarea = new PlayArea(grid);	
		
		JTextField jprofValue = new JTextField();
		
		jprofValue.setPreferredSize(new Dimension(30, 25));
		
		jprofValue.setBorder(
						BorderFactory.createCompoundBorder(jprofValue.getBorder(),
						BorderFactory.createEmptyBorder(5, 5, 5, 5))
						);
		
		jprofValue.setText("5");
		
		playarea.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				
				if(switchTurn)
				{
					grid.addValue(Player.FIRST, playarea.getRealPosition(e.getX()));
				}else{
					
					grid.addValue(Player.AI, playarea.getRealPosition(e.getX()));

				}
				
				gamePlayHistory.push(playarea.getRealPosition(e.getX()));
				
				switchTurn = !switchTurn;
				
				playarea.repaint();
				
				
				whoWins();
				
			}
			
			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
				
		JButton playAI = UIHelper.createSimpleButton("PLAY AI");
		
		playAI.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
			if( !switchTurn )
			{
				
				int prof = 5;
				
				try {
					prof = Integer.parseInt(jprofValue.getText());
					
				} catch (Exception e2) {
					
					System.out.println("Profondeur n'est pas valide");
				}
				 
				minmax.setProf(prof);
				
				gamePlayHistory.push(minmax.AI());
				
				repaint();
				
				switchTurn = !switchTurn;
				
				whoWins();
			}
			
			}
		});
		
		JButton backPlay = UIHelper.createSimpleButton("BACK");
		
		backPlay.setForeground(Color.WHITE);
		
		backPlay.setBackground(Color.RED);	
		
		backPlay.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				grid.delValue(gamePlayHistory.pop());
				
				switchTurn = !switchTurn;
				
				playarea.repaint();

			}
		});
		
		JButton clearBtn = UIHelper.createSimpleButton("CLEAR");
		
		clearBtn.setForeground(Color.BLACK);
		clearBtn.setBackground(Color.GREEN);
		
		clearBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				grid.init();
				
				playarea.repaint();
				
			}
		});
		
		menu.add(jprofValue);
		menu.add(playAI);
		menu.add(backPlay);
		menu.add(clearBtn);
				
		this.getContentPane().add(menu, BorderLayout.NORTH);
		
		this.getContentPane().add(playarea, BorderLayout.CENTER);
		
		
		this.setVisible(true);
	}
	
	public void whoWins()
	{
		
		if(grid.checkWin(Player.FIRST))
		{
        	JOptionPane.showMessageDialog(null, "GREEN PLAYER WINS", "WINNER", JOptionPane.INFORMATION_MESSAGE);

		}else if(grid.checkWin(Player.AI))
		{
			JOptionPane.showMessageDialog(null, "RED PLAYER WINS", "WINNER", JOptionPane.INFORMATION_MESSAGE);
		}
		
	}
	
}
