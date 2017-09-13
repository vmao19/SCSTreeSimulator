import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Driver {
	public static void main(String[] args){
		ScreenWindow window = new ScreenWindow();
		new Thread(window).start();
		
		
		
	}
}
