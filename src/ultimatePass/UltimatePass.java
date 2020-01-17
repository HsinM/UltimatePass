package ultimatePass;

import java.util.InputMismatchException;
import java.util.Random;
import java.awt.Font;
import java.awt.event.*;
import java.security.SecureRandom;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

/**
 * @author Hsin, Wei-Ming 
 * @version 1.5, June 2016
 * @since 1.0, May 2016
 */
public class UltimatePass extends JFrame {

	/**
	 * Parted Auto Generated.
	 * timeS, timeN, thdRunstate using by class "tdTimer" and "ListenEvents".
	 * Declaration variables if you want change that at actionPerformed.
	 */
	public static UltimatePass frame;
	private static final long serialVersionUID = -2528623800876708032L;
	private static int count = 0;
	private static long timeS, pickedNumber;
	private static long min = 0, max = 0, MinS, MaxS;
	private static String timeResult;
	private boolean thdRunstate = true;
	private static boolean customPass = false;
	private JButton btnGuess, btnRe;
	private JPanel contentPane;
	private JLabel lblRng, lblInput;
	private JTextField txtMin, txtMax, txtInput;
	private JPasswordField txtPass;
	private JCheckBox chkOpt;
	
	/**
	 * Create the frame.
	 */
	public UltimatePass() {
		setTitle("\u7D42\u6975\u5BC6\u78BC");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		addWindowListener(new WindowAdapter() {
			 public void windowClosing(WindowEvent e)
			 {
				int choice = JOptionPane.showConfirmDialog(null,"真的要離開遊戲嗎？","確認",
						JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
				switch (choice) {
				case JOptionPane.YES_OPTION:
					setDefaultCloseOperation(EXIT_ON_CLOSE);
					break;

				default:
					setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);//cancel
					break;
				}
			 }
			
		});
		
		btnGuess = new JButton("\u958B\u59CB!!");
		btnGuess.setFont(new Font("微軟正黑體", Font.PLAIN, 15));
		
		JLabel lblMin = new JLabel("\u6700\u5C0F\u503C:");
		lblMin.setFont(new Font("微軟正黑體", Font.PLAIN, 12));
		
		JLabel lblMax = new JLabel("\u6700\u5927\u503C:");
		lblMax.setFont(new Font("微軟正黑體", Font.PLAIN, 12));
		
		txtMin = new JTextField();
		txtMin.setFont(new Font("微軟正黑體", Font.PLAIN, 12));
		txtMin.setText("0");
		txtMin.setColumns(1);
		
		txtMax = new JTextField();
		txtMax.setFont(new Font("微軟正黑體", Font.PLAIN, 12));
		txtMax.setText("1000");
		txtMax.setColumns(1);
		
		lblInput = new JLabel("\u731C\u4E00\u500B\u6578\u5B57\uFF1A");
		lblInput.setFont(new Font("微軟正黑體", Font.PLAIN, 40));
		lblInput.setVisible(false);
		
		txtInput = new JTextField();
		txtInput.setFont(new Font("微軟正黑體", Font.PLAIN, 40));
		txtInput.setColumns(10);
		txtInput.setVisible(false);
		
		lblRng = new JLabel("\u3000");
		lblRng.setHorizontalAlignment(SwingConstants.CENTER);
		lblRng.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		lblRng.setLabelFor(lblInput);
		
		chkOpt = new JCheckBox("\u81EA\u8A02\u5BC6\u78BC\uFF1A");
		chkOpt.setFont(new Font("微軟正黑體", Font.PLAIN, 12));
		
		txtPass = new JPasswordField();
		txtPass.setEnabled(false);
		txtPass.setFont(new Font("微軟正黑體", Font.PLAIN, 12));
		
		btnRe = new JButton("\u91CD\u8A2D");
		btnRe.setFont(new Font("微軟正黑體", Font.PLAIN, 12));
		btnRe.setVisible(false);
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(170)
					.addComponent(btnGuess, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 87, Short.MAX_VALUE)
					.addComponent(btnRe, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblInput, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txtInput, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblRng, GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(100)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(chkOpt)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtPass, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
							.addGap(8))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblMin)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtMin, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
							.addGap(38)
							.addComponent(lblMax)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txtMax, GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE)
					.addGap(101))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(28, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblMax)
						.addComponent(lblMin)
						.addComponent(txtMin, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtMax, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(chkOpt)
						.addComponent(txtPass, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(21)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblInput)
						.addComponent(txtInput, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblRng)
					.addGap(16)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnGuess, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnRe, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
		
		/**
		 * Add Listener for components
		 */
		btnRe.addActionListener(new ListenEvents());
		btnGuess.addActionListener(new ListenEvents());
		chkOpt.addItemListener(new ItemEvents());
	}
	
	/** 
	 * Create ActionListener and ActionPerformed to receive actions. 
	 */
	private class ListenEvents implements ActionListener { 
							
		public void actionPerformed(ActionEvent e) {
			try {
								
				String command = e.getActionCommand();
				if (command.equals("\u958B\u59CB!!")) {
					if (txtPass.getPassword().length != 0) {
						customPass = true;
						MinS = min = Integer.parseInt(txtMin.getText());
						MaxS = max = Integer.parseInt(txtMax.getText());
						String strPass = String.valueOf(txtPass.getPassword());
						int intPass = Integer.parseInt(strPass);
						if (intPass < min || intPass > max) {
							throw new InputMismatchException("自訂密碼超出範圍!!");
						}
						chkOpt.setVisible(false); txtPass.setVisible(false);
						pickedNumber = Integer.parseInt(strPass);
					}
					else {
						if (txtPass.isEnabled() == true && txtPass.getPassword().length == 0) {
							throw new NumberFormatException("For password string: \"\"");
						}
						customPass = false;
						MinS = min = Integer.parseInt(txtMin.getText());
						MaxS = max = Integer.parseInt(txtMax.getText());
						//Generate the random number.
						SecureRandom csprng = new SecureRandom();
						Random rand = new Random();
						int rndSeed = Math.abs(rand.nextInt() + 1);
						rand.setSeed(csprng.nextInt(rndSeed));
						//Formula => from + rand.nextInt(to - from + 1)
						if ((Long.valueOf(max) - Long.valueOf(min)) > 2147483646) {
							throw new Exception("輸入差值請小於或等於\"2147483646\"!");
						}
						//Integer type line 210-211 already checked!! 
						pickedNumber = rand.nextInt( (int)max - (int)min + 1) + min;
						chkOpt.setVisible(false); txtPass.setVisible(false);
					}
					btnRe.setVisible(true);
					txtMin.setEnabled(false); txtMax.setEnabled(false);
					lblInput.setVisible(true); txtInput.setVisible(true);
					lblRng.setText("密碼產生完成!!");
					btnGuess.setText("猜!");
					txtInput.requestFocus();
					txtInput.selectAll();
					count = 0;
					//multithreading
					thdRunstate = true;
					thdTimer thd = new thdTimer();
					timeS = System.currentTimeMillis();
					thd.start();
				} 
				else if (command.equals("猜!")) {
					int userAnswer = Integer.parseInt(txtInput.getText());
					if (pickedNumber < userAnswer && userAnswer < max) {
						max = userAnswer;
						count++;
						lblRng.setText(min + "<= Ans. <=" + max);
					} 
					else if (pickedNumber < userAnswer && userAnswer > max) {
						txtInput.setText("");
					}
					else if (pickedNumber > userAnswer && userAnswer > min) {
						min = userAnswer;
						count++;
						lblRng.setText(min + "<= Ans. <=" + max);
					}
					else if (pickedNumber > userAnswer && userAnswer < min) {
						txtInput.setText("");
					}
					else if (pickedNumber == userAnswer) {
						count++;
						thdRunstate = false;
						UltimatePass.frame.setTitle("終極密碼");
						timeResult = showTimediff("finish");
						JOptionPane.showMessageDialog(null, "恭喜猜中!!\n共猜了 " + count + " 次，花了 " + timeResult);
						ultimatePass.CsvWriter.writeCsvFile("records.csv");
						ResetAll();
						}
					txtInput.requestFocus();
					txtInput.selectAll();
				}
				else if (command.equals("\u91CD\u8A2D")) {
					ResetAll();
				}
			} 
			catch (Exception ex) {
				// TODO: handle exception
				if (txtInput.isVisible() != true) {
					btnGuess.setText("\u958B\u59CB!!");
					lblRng.setText("　");
				}
				JOptionPane.showConfirmDialog(null,"花生錯誤，請查明原因後再試，謝謝!!\n錯誤訊息為: " + ex.toString()
					,"警告",JOptionPane.CLOSED_OPTION,JOptionPane.ERROR_MESSAGE);
				//ex.printStackTrace();
			}
		}
		
		private void ResetAll() {
			//Reset All Variables
			thdRunstate = false;
			min = max = MinS = MaxS = count = 0;
			btnGuess.setText("\u958B\u59CB!!");
			lblRng.setText("　"); txtInput.setText(""); txtPass.setText("");
			frame.setTitle("終極密碼");
			btnRe.setVisible(false);
			chkOpt.setVisible(true); txtPass.setVisible(true);
			txtMin.setEnabled(true); txtMax.setEnabled(true);
			lblInput.setVisible(false); txtInput.setVisible(false);
		}
	}
	
	private class ItemEvents implements ItemListener {
		@Override
		public void itemStateChanged(ItemEvent e) {
			
			 if(e.getStateChange() == ItemEvent.SELECTED){
                 txtPass.setEnabled(true);
                 txtPass.requestFocus();
             }
             else if(e.getStateChange() == ItemEvent.DESELECTED){
            	 txtPass.setEnabled(false);
            	 txtPass.setText("");
             }
             repaint();
		}
		
	}
	
	private class thdTimer extends Thread {
		@Override
		public void run() {
			try {
				while (thdRunstate) {
					showTimediff("thd");
					sleep(50);	
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}	

	private String showTimediff(String choice) {
		long timeDsec = (System.currentTimeMillis() - timeS) / 1000;
		int timeDmin = (int)Math.floor(timeDsec / 60);
		switch (choice) {
		case "finish":
			if (timeDsec >= 60) {
				return timeDmin + " 分 " + (timeDsec - timeDmin * 60) + " 秒。";
			}
			else if (timeDsec < 60) {
				return timeDsec + " 秒。";
			}
			break;
		case "thd":
			if (timeDsec >= 60) {
				UltimatePass.frame.setTitle("終極密碼，經過了 " + timeDmin + " 分 " + (timeDsec - timeDmin * 60) + " 秒");
			}
			else if (timeDsec < 60) {
				UltimatePass.frame.setTitle("終極密碼，經過了 " + timeDsec + " 秒");
			}
			break;
		}
		return "";
	}
	
	public static String saveRecord() {
		final String COMMA_DELIMITER = ",";
		String time[] = timeResult.split("。");
		String Record = count + COMMA_DELIMITER + time[0] + COMMA_DELIMITER + MinS + "~" + MaxS + COMMA_DELIMITER +  pickedNumber + COMMA_DELIMITER + String.valueOf(customPass);
		return Record;
	}

}