import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.RenderingHints;

import javax.swing.JLabel;
import javax.swing.JTextField;

public class HelloWorld {

	private JFrame frame;
	
	String A=new String();
	/**
	 * @wbp.nonvisual location=419,-6
	 */
	private final JPanel panel = new JPanel();
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HelloWorld window = new HelloWorld();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public HelloWorld() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("¼ÆËãÆ÷");
		frame.setBounds(100, 100, 481, 538);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton btnNewButton = new JButton("0");
		btnNewButton.setBounds(28, 426, 65, 52);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				A=A.concat("0");
				textField.setText(A);
			}
		});
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(btnNewButton);
		
		JButton button = new JButton(".");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				A=A.concat(".");
				textField.setText(A);
			}
		});
		button.setBounds(107, 426, 65, 52);
		frame.getContentPane().add(button);
		
		JButton button_1 = new JButton("3");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				A=A.concat("3");
				textField.setText(A);
			}
		});
		button_1.setBounds(186, 361, 65, 52);
		frame.getContentPane().add(button_1);
		
		JButton button_2 = new JButton("=");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					A=Calculate.numberCalculate(Calculate.ConvertTopostfix(A));
					System.out.println(A);
					textField.setText(String.valueOf(A));
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		button_2.setBounds(359, 296, 90, 182);
		frame.getContentPane().add(button_2);
		
		JButton button_3 = new JButton("1");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				A=A.concat("1");
				textField.setText(A);
			}
		});
		button_3.setBounds(28, 361, 65, 52);
		frame.getContentPane().add(button_3);
		
		JButton button_4 = new JButton("2");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				A=A.concat("2");
				textField.setText(A);
			}
		});
		button_4.setBounds(107, 361, 65, 52);
		frame.getContentPane().add(button_4);
		
		JButton button_5 = new JButton("6");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				A=A.concat("6");
				textField.setText(A);
			}
		});
		button_5.setBounds(186, 296, 65, 52);
		frame.getContentPane().add(button_5);
		
		JButton button_6 = new JButton("-");
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				A=A.concat("-");
				textField.setText(A);
			}
		});
		button_6.setBounds(265, 361, 82, 52);
		frame.getContentPane().add(button_6);
		
		JButton button_7 = new JButton("4");
		button_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				A=A.concat("4");
				textField.setText(A);
			}
		});
		button_7.setBounds(28, 296, 65, 52);
		frame.getContentPane().add(button_7);
		
		JButton button_8 = new JButton("5");
		button_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				A=A.concat("5");
				textField.setText(A);
			}
		});
		button_8.setBounds(107, 296, 65, 52);
		frame.getContentPane().add(button_8);
		
		JButton button_9 = new JButton("9");
		button_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				A=A.concat("9");
				textField.setText(A);
			}
		});
		button_9.setBounds(186, 231, 65, 52);
		frame.getContentPane().add(button_9);
		
		JButton button_10 = new JButton("*");
		button_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				A=A.concat("*");
				textField.setText(A);
			}
		});
		button_10.setBounds(265, 296, 82, 52);
		frame.getContentPane().add(button_10);
		
		JButton button_11 = new JButton("7");
		button_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				A=A.concat("7");
				textField.setText(A);
			}
		});
		button_11.setBounds(28, 231, 65, 52);
		frame.getContentPane().add(button_11);
		
		JButton button_12 = new JButton("8");
		button_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				A=A.concat("8");
				textField.setText(A);
			}
		});
		button_12.setBounds(107, 231, 65, 52);
		frame.getContentPane().add(button_12);
		
		JButton button_14 = new JButton("/");
		button_14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				A=A.concat("/");
				textField.setText(A);
			}
		});
		button_14.setBounds(265, 231, 82, 52);
		frame.getContentPane().add(button_14);
		
		JButton button_15 = new JButton("+");
		button_15.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				A=A.concat("+");
				textField.setText(A);
			}
		});
		button_15.setBounds(265, 426, 82, 52);
		frame.getContentPane().add(button_15);
		
		JButton button_16 = new JButton(")");
		button_16.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				A=A.concat(")");
				textField.setText(A);
			}
		});
		button_16.setBounds(107, 166, 65, 52);
		frame.getContentPane().add(button_16);
		
		JButton button_17 = new JButton("(");
		button_17.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				A=A.concat("(");
				textField.setText(A);
			}
		});
		button_17.setBounds(28, 166, 65, 52);
		frame.getContentPane().add(button_17);
		
		JButton btnMod = new JButton("mod");
		btnMod.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				A=A.concat("%");
				textField.setText(A);
			}
		});
		btnMod.setBounds(265, 166, 82, 52);
		frame.getContentPane().add(btnMod);
		
		JButton btnXy = new JButton("x^y");
		btnXy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				A=A.concat("^");
				textField.setHorizontalAlignment(textField.RIGHT);
				textField.setText(A);
			}
		});
		btnXy.setBounds(186, 166, 65, 52);
		frame.getContentPane().add(btnXy);
		
		JButton button_13 = new JButton("\u5F52\u96F6");
		button_13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				A="";
				textField.setHorizontalAlignment(textField.RIGHT);
				textField.setText(A);
			}
		});
		button_13.setBounds(359, 231, 82, 52);
		frame.getContentPane().add(button_13);
		
		JButton button_18 = new JButton("\u9000\u683C");
		button_18.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				A=A.substring(0,A.length()-1);
				textField.setText(A);
			}
		});
		button_18.setBounds(359, 166, 82, 52);
		frame.getContentPane().add(button_18);
		
		textField = new JTextField();
		textField.setBounds(28, 56, 413, 64);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		textField.setEditable(false);
		textField.setHorizontalAlignment(textField.RIGHT);
		textField.setFont(new Font("ËÎÌå", Font.PLAIN, 30));
	}
}
