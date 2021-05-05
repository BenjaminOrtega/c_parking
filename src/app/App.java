package app;

import java.awt.EventQueue;

import javax.swing.UIManager;

import view.*;

/**
 * The Class App.
 * @version 05.08.2019/A
 */
public class App {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel");
		} catch (Exception e) {
			// TODO: handle exception
		}

			EventQueue.invokeLater(new Runnable() {
				
				/**
				 * Run.
				 */
				public void run() {
					try {
						Inicio frame = new Inicio();
						frame.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();	
					}
				}
			});
		}				

}
