import javax.swing.JCheckBoxMenuItem;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class MyFrame {
	
	JTextArea output;
	JScrollPane scrollPane;
	
	public JMenuBar createMenuBar() {
		JMenuBar menuBar;
		JMenu menu, submenu;
		JMenuItem menuitem;
		JRadioButtonMenuItem rbMenuItem;
		JCheckBoxMenuItem cbMenuItem;
		
		// create the menu bar
		menuBar = new JMenuBar();
		
		// build first menu
		menu = new JMenu("A Menu");
		menu.getAccessibleContext().setAccessibleDescription("The only menu in this program that has menut items");
		menu.add(menu);
	}

}
