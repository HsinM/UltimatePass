package ultimatePass;

import java.awt.EventQueue;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;

/**
 * @author Hsin, Wei-Ming 
 * @version 1.5, June 2016
 * @since 1.0, May 2016
 */
public class Main {
	
	/**
	 * Launch the application.
	 * @param args 本程式沒有使用此參數
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					UltimatePass.frame = new UltimatePass();
					UltimatePass.frame.setLocationRelativeTo(null);
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					UltimatePass.frame.setVisible(true);
					SwingUtilities.updateComponentTreeUI(UltimatePass.frame);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
