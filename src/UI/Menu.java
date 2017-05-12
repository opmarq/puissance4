package UI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;

import puissance.Grid;

public class Menu extends JPanel {

	/**
	 * Class qui s'occupe de la creation du menu
	 */
	private static final long serialVersionUID = 1L;

	String[] algos = { "MinMax", "AlphaBeta"};
	
	JComboBox<String> comboMenu = null;
	
	JLabel jprofondeur = null;
	

	public Menu()
	{	
	
		comboMenu = UIHelper.createSimpleCombo(algos);
		
		jprofondeur = new JLabel("Profondeur");
		
		jprofondeur.setForeground(Color.WHITE);
		
		this.add(comboMenu);
		
		this.add(jprofondeur);


	}
	
	public void paintComponent(Graphics g)
	{
		 String imgPath = "assets/menu.png";
		  try {
		      
			  Image img = ImageIO.read(new File(imgPath));
		  
		      g.drawImage(img, 0, 0, this);
		      
		  }catch (Exception e) {
			  
			  System.out.println(e.getMessage());
		}
	}
	
}
