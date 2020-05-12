package com.gui.net;

import java.awt.EventQueue;
import dataBase.*;
import dataBase.connection.DataBaseConnection;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.plaf.IconUIResource;

import com.model.artist.Artiste;
import com.mysql.cj.jdbc.Blob;

import javax.swing.border.EmptyBorder;
import javax.swing.border.BevelBorder;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Cursor;
import javax.swing.border.MatteBorder;

public class AjouterArtiste {

	public JFrame frmAjouterUnArtiste;
	private JTextField uid;
	private JTextField nom;
	private JTextField prenom;
	private JTextField dateNais;
	private JTextField idsp;
	private JTextField idyt;
	private JTextField photo;

	/**
	 * Launch the application.
	
	/**
	 * Create the application.
	 */
	public AjouterArtiste() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAjouterUnArtiste = new JFrame();
		frmAjouterUnArtiste.setIconImage(Toolkit.getDefaultToolkit().getImage(AjouterArtiste.class.getResource("/pro/image/iconfinder_Add_131846.png")));
		frmAjouterUnArtiste.setTitle("Ajouter Un Artiste");
		frmAjouterUnArtiste.setResizable(false);
		frmAjouterUnArtiste.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmAjouterUnArtiste.setBounds(100, 100, 883, 506);
		frmAjouterUnArtiste.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel() { public void paintComponent(Graphics g) {  
            Image img = Toolkit.getDefaultToolkit().getImage(  
                    menu.class.getResource("/pro/image/frank-septillion-Qrspubmx6kE-unsplash (1).jpg"));  
     g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);  
    }  
}; 
		panel.setForeground(Color.WHITE);
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 867, 467);
		frmAjouterUnArtiste.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("UID");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Oswald", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(52, 131, 94, 21);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("Ajouter Un Artiste");
		lblNewLabel.setBounds(353, 5, 212, 33);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Oswald", Font.PLAIN, 27));
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1_1 = new JLabel("Nom");
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Oswald", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(52, 186, 46, 21);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Prenom");
		lblNewLabel_1_2.setForeground(Color.WHITE);
		lblNewLabel_1_2.setFont(new Font("Oswald", Font.PLAIN, 14));
		lblNewLabel_1_2.setBounds(52, 250, 46, 21);
		panel.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Date Naissance");
		lblNewLabel_1_3.setForeground(Color.WHITE);
		lblNewLabel_1_3.setFont(new Font("Oswald", Font.PLAIN, 14));
		lblNewLabel_1_3.setBounds(52, 314, 94, 21);
		panel.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("Genre Musicale");
		lblNewLabel_1_4.setForeground(Color.WHITE);
		lblNewLabel_1_4.setFont(new Font("Oswald", Font.PLAIN, 14));
		lblNewLabel_1_4.setBounds(52, 379, 94, 21);
		panel.add(lblNewLabel_1_4);
		
		uid = new JTextField();
		uid.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.WHITE));
		uid.setCaretColor(Color.WHITE);
		uid.setForeground(Color.WHITE);
		uid.setBackground(Color.BLACK);
		uid.setFont(new Font("Oswald", Font.PLAIN, 13));
		uid.setBounds(166, 121, 179, 33);
		panel.add(uid);
		uid.setColumns(10);
		
		nom = new JTextField();
		nom.setCaretColor(Color.WHITE);
		nom.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.WHITE));
		nom.setForeground(Color.WHITE);
		nom.setBackground(Color.BLACK);
		nom.setFont(new Font("Oswald", Font.PLAIN, 13));
		nom.setColumns(10);
		nom.setBounds(166, 176, 179, 33);
		panel.add(nom);
		
		JComboBox genre = new JComboBox();
		genre.setForeground(Color.WHITE);
		genre.setBackground(Color.BLACK);
		genre.setModel(new DefaultComboBoxModel(new String[] {"Hip Hop", "Rap", "Chaabi", "Electro", "Jazz", "Latin", "Pop", "Rock", "Rai"}));
		genre.setBounds(166, 379, 179, 23);
		panel.add(genre);
		
		prenom = new JTextField();
		prenom.setCaretColor(Color.WHITE);
		prenom.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.WHITE));
		prenom.setForeground(Color.WHITE);
		prenom.setFont(new Font("Oswald", Font.PLAIN, 13));
		prenom.setColumns(10);
		prenom.setBackground(Color.BLACK);
		prenom.setBounds(166, 238, 179, 33);
		panel.add(prenom);
		
		dateNais = new JTextField();
		dateNais.setCaretColor(Color.WHITE);
		dateNais.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.WHITE));
		dateNais.setForeground(Color.WHITE);
		dateNais.setFont(new Font("Oswald", Font.PLAIN, 13));
		dateNais.setColumns(10);
		dateNais.setBackground(Color.BLACK);
		dateNais.setBounds(166, 309, 179, 33);
		panel.add(dateNais);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("ID Spotify");
		lblNewLabel_1_2_1.setForeground(Color.WHITE);
		lblNewLabel_1_2_1.setFont(new Font("Oswald", Font.PLAIN, 14));
		lblNewLabel_1_2_1.setBounds(452, 131, 72, 21);
		panel.add(lblNewLabel_1_2_1);
		
		JLabel lblNewLabel_1_2_2 = new JLabel("Photo ");
		lblNewLabel_1_2_2.setForeground(Color.WHITE);
		lblNewLabel_1_2_2.setFont(new Font("Oswald", Font.PLAIN, 14));
		lblNewLabel_1_2_2.setBounds(452, 250, 46, 21);
		panel.add(lblNewLabel_1_2_2);
		
		JLabel lblNewLabel_1_2_3 = new JLabel("ID Youtube");
		lblNewLabel_1_2_3.setForeground(Color.WHITE);
		lblNewLabel_1_2_3.setFont(new Font("Oswald", Font.PLAIN, 14));
		lblNewLabel_1_2_3.setBounds(452, 192, 72, 21);
		panel.add(lblNewLabel_1_2_3);
		
		idsp = new JTextField();
		idsp.setCaretColor(Color.WHITE);
		idsp.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.WHITE));
		idsp.setForeground(Color.WHITE);
		idsp.setFont(new Font("Oswald", Font.PLAIN, 13));
		idsp.setColumns(10);
		idsp.setBackground(Color.BLACK);
		idsp.setBounds(573, 126, 179, 33);
		panel.add(idsp);
		
		idyt = new JTextField();
		idyt.setCaretColor(Color.WHITE);
		idyt.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.WHITE));
		idyt.setForeground(Color.WHITE);
		idyt.setFont(new Font("Oswald", Font.PLAIN, 13));
		idyt.setColumns(10);
		idyt.setBackground(Color.BLACK);
		idyt.setBounds(573, 189, 179, 33);
		panel.add(idyt);
		
		photo = new JTextField();
		photo.setEnabled(false);
		photo.setCaretColor(Color.WHITE);
		photo.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.WHITE));
		photo.setForeground(Color.WHITE);
		photo.setFont(new Font("Oswald", Font.PLAIN, 13));
		photo.setColumns(10);
		photo.setBackground(Color.BLACK);
		photo.setBounds(573, 246, 179, 33);
		
		panel.add(photo);
		JButton btnNewButton = new JButton("Choisir Image");
		btnNewButton.setBackground(SystemColor.activeCaption);
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setFont(new Font("Oswald", Font.PLAIN, 12));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser choix = new JFileChooser();
				int retour=choix.showOpenDialog(frmAjouterUnArtiste);
				if(retour==JFileChooser.APPROVE_OPTION){
				   
				 choix.getSelectedFile().getName();
				  
				 photo.setText(choix.getSelectedFile().
				          getAbsolutePath());
				  
				}else {
					JOptionPane.showMessageDialog(frmAjouterUnArtiste, "Aucun Image Choisi","Oops",JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnNewButton.setBounds(608, 290, 120, 36);
		panel.add(btnNewButton);
		JButton ajouter = new JButton("Ajouter");
		ajouter.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		ajouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Blob b=null;
				
				Artiste artist = new Artiste(uid.getText(),nom.getText(),prenom.getText(),dateNais.getText(),idsp.getText(),idyt.getText(),b,genre.getSelectedItem().toString());
			    artist.setImageString(photo.getText());
				String mesg= DataBaseConnection.AjouterArtiste(artist);
				  if(mesg==null)
			  JOptionPane.showMessageDialog(frmAjouterUnArtiste, "Artiste Ajouté Avec Succés  ", "Congratulation !", JOptionPane.INFORMATION_MESSAGE,new ImageIcon ( menu.class.getResource("/pro/image/iconfinder_Yes_131856.png")));
				  else
					  JOptionPane.showMessageDialog(frmAjouterUnArtiste, mesg, "Ops !", JOptionPane.ERROR_MESSAGE);
				  uid.setText("");
				  
				  nom.setText("");
				  prenom.setText("");
				  dateNais.setText("");
				  idsp.setText("");
				  idyt.setText("");
				  photo.setText("");
				  
				  
			}
		});
		ajouter.setForeground(Color.WHITE);
		ajouter.setFont(new Font("Oswald", Font.PLAIN, 14));
		ajouter.setFocusable(false);
		ajouter.setBorder(null);
		ajouter.setBackground(SystemColor.activeCaption);
		ajouter.setBounds(561, 360, 191, 59);
		panel.add(ajouter);
		
		
	}
}
