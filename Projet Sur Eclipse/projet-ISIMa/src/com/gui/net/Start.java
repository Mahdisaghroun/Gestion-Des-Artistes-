package com.gui.net;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JProgressBar;
import java.awt.BorderLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;

public class Start {

	public JFrame frmConnexion;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					File f = new File("C://p");
					if(!f.exists()) {
						
						 boolean bool = f.mkdir();}
					Start window = new Start();
					window.frmConnexion.setVisible(true);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, e.getMessage(), "Oops",JOptionPane.ERROR_MESSAGE);
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Start() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmConnexion = new JFrame();
		frmConnexion.setResizable(false);
		frmConnexion.getContentPane().setBackground(Color.WHITE);
		frmConnexion.setIconImage(Toolkit.getDefaultToolkit().getImage(Start.class.getResource("/pro/image/iconfinder_Right_131879.png")));
		frmConnexion.setTitle("Connexion");
		frmConnexion.setBounds(100, 100, 572, 368);
		frmConnexion.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmConnexion.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Admin");
		lblNewLabel.setFont(new Font("Oswald", Font.PLAIN, 19));
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setBounds(251, 57, 67, 69);
		frmConnexion.getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		
		textField.setBounds(195, 137, 191, 41);
		frmConnexion.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Mot de passe");
		lblNewLabel_1.setFont(new Font("Oswald", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(90, 140, 113, 41);
		frmConnexion.getContentPane().add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setIconTextGap(0);
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String mdp=textField.getText();
				if(mdp.toString().equals((String)"0000")) {
					
					frmConnexion.dispose();
					try {
						Thread.sleep(4000);
						menu window = new menu();
					    window.frmGestionDesArtistes.setVisible(true);	
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
				else
					JOptionPane.showMessageDialog(frmConnexion, "Mot De Passe Incorrect !!","Oops",JOptionPane.ERROR_MESSAGE);
				
			}
		});
		btnNewButton.setIcon(new ImageIcon(Start.class.getResource("/pro/image/iconfinder_Right_131879.png")));
		btnNewButton.setBounds(229, 211, 102, 35);
		frmConnexion.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("(Par D\u00E9fault 0000)");
		lblNewLabel_2.setFont(new Font("Verdana", Font.PLAIN, 9));
		lblNewLabel_2.setBounds(73, 183, 120, 14);
		frmConnexion.getContentPane().add(lblNewLabel_2);
	}

}
