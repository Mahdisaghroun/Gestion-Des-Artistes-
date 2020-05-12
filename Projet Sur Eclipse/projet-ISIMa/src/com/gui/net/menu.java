package com.gui.net;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;

public class menu {

	public JFrame frmGestionDesArtistes;

	
	public menu() {
		initialize();
	}

	
	private void initialize() {
		frmGestionDesArtistes = new JFrame();
		frmGestionDesArtistes.setIconImage(Toolkit.getDefaultToolkit().getImage(menu.class.getResource("/pro/image/music-icon-75.png")));
		frmGestionDesArtistes.setTitle("Gestion Des Artistes");
		frmGestionDesArtistes.setResizable(false);
		frmGestionDesArtistes.setBounds(100, 100, 744, 485);
		frmGestionDesArtistes.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmGestionDesArtistes.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel() { public void paintComponent(Graphics g) {  
		                     Image img = Toolkit.getDefaultToolkit().getImage(  
					                                menu.class.getResource("/pro/image/frank-septillion-Qrspubmx6kE-unsplash (1).jpg"));  
				                     g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);  
					                }  
				           };  
		panel.setBackground(Color.WHITE);
		panel.setBounds(-7, -1, 747, 460);
		frmGestionDesArtistes.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Gestion Des Artistes");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblNewLabel.setBounds(247, 11, 361, 59);
		panel.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Modifier Un Artiste");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConsulterArtiste window = new ConsulterArtiste("Modifier Artiste",true,true);
				window.frmConsulterUnArtiste.setVisible(true);
			}
		});
		btnNewButton.setBorder(null);
		btnNewButton.setFocusable(false);
		btnNewButton.setFont(new Font("Oswald", Font.PLAIN, 14));
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(Color.BLACK);
		btnNewButton.setBounds(93, 324, 191, 59);
		panel.add(btnNewButton);
		
		JButton btnAjouterUnArtiste = new JButton("Ajouter Un Artiste");
		btnAjouterUnArtiste.setBorder(null);
		btnAjouterUnArtiste.setFocusable(false);
		btnAjouterUnArtiste.setFont(new Font("Oswald", Font.PLAIN, 14));
		btnAjouterUnArtiste.setForeground(Color.WHITE);
		btnAjouterUnArtiste.setBackground(Color.BLACK);
		btnAjouterUnArtiste.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AjouterArtiste window = new AjouterArtiste();
				window.frmAjouterUnArtiste.setVisible(true);
			}
		});
		btnAjouterUnArtiste.setBounds(93, 166, 191, 59);
		panel.add(btnAjouterUnArtiste);
		
		JButton btnConsulterUnArtiste = new JButton("Consulter Un Artiste");
		btnConsulterUnArtiste.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ConsulterArtiste window = new ConsulterArtiste("Consulter Un Artiste",false,false);
				window.frmConsulterUnArtiste.setVisible(true);
			}
		});
		btnConsulterUnArtiste.setBorder(null);
		
		btnConsulterUnArtiste.setFocusable(false);
		btnConsulterUnArtiste.setFont(new Font("Oswald", Font.PLAIN, 14));
		btnConsulterUnArtiste.setForeground(Color.WHITE);
		btnConsulterUnArtiste.setBackground(Color.BLACK);
		btnConsulterUnArtiste.setBounds(451, 166, 191, 59);
		panel.add(btnConsulterUnArtiste);
		
		JButton btnSupprimerUnArtiste = new JButton("Supprimer Un Artiste");
		btnSupprimerUnArtiste.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConsulterArtiste window = new ConsulterArtiste("Supprimer Un Artiste",true,false);
				window.frmConsulterUnArtiste.setVisible(true);
			}
		});
		btnSupprimerUnArtiste.setBorder(null);
		btnSupprimerUnArtiste.setFocusable(false);
		btnSupprimerUnArtiste.setFont(new Font("Oswald", Font.PLAIN, 14));
		btnSupprimerUnArtiste.setForeground(Color.WHITE);
		btnSupprimerUnArtiste.setBackground(Color.BLACK);
		btnSupprimerUnArtiste.setBounds(451, 324, 191, 59);
		panel.add(btnSupprimerUnArtiste);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(Color.WHITE);
		frmGestionDesArtistes.setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("A propos");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("A propos");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Apropos win = new Apropos();
				win.frmApropos.setVisible(true);
			}
		});
		mnNewMenu.add(mntmNewMenuItem);
	}
}
