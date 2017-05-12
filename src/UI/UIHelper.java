package UI;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public abstract class UIHelper {

	public static JButton createSimpleButton(String text) {
		  JButton button = new JButton(text);
		  button.setForeground(Color.BLACK);
		  button.setBackground(Color.WHITE);
		  Border line = new LineBorder(Color.BLACK);
		  Border margin = new EmptyBorder(5, 15, 5, 15);
		  Border compound = new CompoundBorder(line, margin);
		  button.setBorder(compound);
		  return button;
	}
	
	public static JComboBox<String> createSimpleCombo(String [] list) {
		  JComboBox<String> jcombo =  new JComboBox<String>(list);
		  Border line = new LineBorder(Color.WHITE);
		  Border margin = new EmptyBorder(0, 0, 0, 0);
		  Border compound = new CompoundBorder(line, margin);
		  jcombo.setBorder(compound);
		  return jcombo;
	}
	
}
