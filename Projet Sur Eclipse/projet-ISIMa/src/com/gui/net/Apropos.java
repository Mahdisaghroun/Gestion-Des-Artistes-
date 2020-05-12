package com.gui.net;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JEditorPane;
import java.awt.Color;
import java.awt.Toolkit;

public class Apropos {

	public JFrame frmApropos;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the application.
	 */
	public Apropos() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmApropos = new JFrame();
		frmApropos.getContentPane().setBackground(Color.WHITE);
		frmApropos.setResizable(false);
		frmApropos.setIconImage(Toolkit.getDefaultToolkit().getImage(Apropos.class.getResource("/pro/image/iconfinder_Search_text_131785.png")));
		frmApropos.setTitle("Apropos");
		frmApropos.setBounds(100, 100, 679, 407);
		frmApropos.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmApropos.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Gestion Des Artistes");
		lblNewLabel.setFont(new Font("Montserrat", Font.PLAIN, 27));
		lblNewLabel.setBounds(194, 29, 308, 50);
		frmApropos.getContentPane().add(lblNewLabel);
		
		JEditorPane dtrpnApplicationDevoloppPar = new JEditorPane();
		dtrpnApplicationDevoloppPar.setFont(new Font("Lato", Font.PLAIN, 18));
		dtrpnApplicationDevoloppPar.setForeground(Color.BLUE);
		dtrpnApplicationDevoloppPar.setEditable(false);
		dtrpnApplicationDevoloppPar.setText("Application devolopp\u00E9 par : Mahdi Saghroun (\u00E9tudiant a l'isima LFI2B)\r\nc'est une CRUD application (create,read,update,delete),sert a g\u00E9rer\r\n les artistes stock\u00E9s dans la base de donn\u00E9 (gestion des artistes) \r\n\r\n\r\n\r\n");
		dtrpnApplicationDevoloppPar.setBounds(10, 125, 643, 204);
		frmApropos.getContentPane().add(dtrpnApplicationDevoloppPar);
	}

}
