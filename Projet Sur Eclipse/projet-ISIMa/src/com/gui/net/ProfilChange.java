package com.gui.net;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.model.artist.Artiste;
import com.mysql.cj.jdbc.Blob;

import dataBase.connection.DataBaseConnection;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.awt.event.ActionEvent;
import java.awt.Cursor;

public class ProfilChange {

	public JFrame frmModifierArtiste;
	private JTextField textField;
	private JTextField prenom;
	private JTextField dateNais;
	private JTextField idstfy;
	private JTextField idyt;
	private JTextField genre;
	private Artiste artist;
	private String photo;
	String fileName = "C://p/tree.png";
	File file = new File(fileName);

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the application.
	 */
	public ProfilChange(Artiste artist) {
		this.artist=artist;
		
        
		 try  {
			 FileOutputStream fos = new FileOutputStream(file,false);

            Blob blob =artist.getImage();
            int len = (int) blob.length();

            byte[] buf = blob.getBytes(1, len);

            fos.write(buf, 0, len);
            
        } catch (Exception ex) {
            System.out.print(ex);
           
        }
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmModifierArtiste = new JFrame();
		frmModifierArtiste.setIconImage(Toolkit.getDefaultToolkit().getImage(ProfilChange.class.getResource("/pro/image/iconfinder_Revert_131718.png")));
		frmModifierArtiste.setTitle("Modifier Artiste"+"[ "+artist.getNom()+" "+artist.getPrenom()+"  ]");
		frmModifierArtiste.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		frmModifierArtiste.setBounds(100, 100, 844, 512);
		frmModifierArtiste.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmModifierArtiste.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel(){ public void paintComponent(Graphics g) {  
            Image img = Toolkit.getDefaultToolkit().getImage(  
                    menu.class.getResource("/pro/image/frank-septillion-Qrspubmx6kE-unsplash (1).jpg"));  
     g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);  
    }};  
		panel.setForeground(new Color(255, 255, 255));
		panel.setBounds(0, 0, 828, 473);
		frmModifierArtiste.getContentPane().add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel() { public void paintComponent(Graphics g) {  
            Image img = Toolkit.getDefaultToolkit().getImage(  
            		(fileName));  
     g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);  
    }  
};  
		panel_1.setBounds(329, 0, 179, 140);
		panel.add(panel_1);
		
		JLabel nom = new JLabel("Nom");
		nom.setFont(new Font("Oswald", Font.PLAIN, 14));
		nom.setForeground(new Color(255, 255, 255));
		nom.setBounds(10, 193, 86, 21);
		panel.add(nom);
		
		textField = new JTextField(artist.getNom());
		textField.setFont(new Font("Oswald", Font.PLAIN, 12));
		textField.setBackground(Color.BLACK);
		textField.setCaretColor(Color.WHITE);
		textField.setForeground(Color.WHITE);
		textField.setBounds(137, 190, 173, 32);
		panel.add(textField);
		textField.setColumns(10);
		
		prenom = new JTextField(artist.getPrenom());
		prenom.setFont(new Font("Oswald", Font.PLAIN, 12));
		prenom.setBackground(Color.BLACK);
		prenom.setCaretColor(Color.WHITE);
		prenom.setForeground(Color.WHITE);
		prenom.setColumns(10);
		prenom.setBounds(137, 266, 173, 29);
		panel.add(prenom);
		
		JLabel lblPrenom = new JLabel("prenom");
		lblPrenom.setFont(new Font("Oswald", Font.PLAIN, 14));
		lblPrenom.setForeground(new Color(255, 255, 255));
		lblPrenom.setBounds(10, 269, 86, 26);
		panel.add(lblPrenom);
		
		dateNais = new JTextField(artist.getDateNais());
		dateNais.setFont(new Font("Oswald", Font.PLAIN, 12));
		dateNais.setBackground(Color.BLACK);
		dateNais.setCaretColor(Color.WHITE);
		dateNais.setForeground(Color.WHITE);
		dateNais.setColumns(10);
		dateNais.setBounds(137, 339, 173, 29);
		panel.add(dateNais);
		
		JLabel lblDateNaissance = new JLabel("Date Naissance");
		lblDateNaissance.setFont(new Font("Oswald", Font.PLAIN, 14));
		lblDateNaissance.setForeground(new Color(255, 255, 255));
		lblDateNaissance.setBounds(10, 342, 86, 26);
		panel.add(lblDateNaissance);
		
		idstfy = new JTextField(artist.getIDSpotify());
		idstfy.setFont(new Font("Oswald", Font.PLAIN, 12));
		idstfy.setBackground(Color.BLACK);
		idstfy.setCaretColor(Color.WHITE);
		idstfy.setForeground(Color.WHITE);
		idstfy.setColumns(10);
		idstfy.setBounds(572, 190, 179, 32);
		panel.add(idstfy);
		
		JLabel lblIdSpotify = new JLabel("ID Spotify");
		lblIdSpotify.setFont(new Font("Oswald", Font.PLAIN, 14));
		lblIdSpotify.setForeground(new Color(255, 255, 255));
		lblIdSpotify.setBounds(447, 204, 86, 26);
		panel.add(lblIdSpotify);
		
		idyt = new JTextField(artist.getIDYoutube());
		idyt.setFont(new Font("Oswald", Font.PLAIN, 12));
		idyt.setBackground(Color.BLACK);
		idyt.setCaretColor(Color.WHITE);
		idyt.setForeground(Color.WHITE);
		idyt.setColumns(10);
		idyt.setBounds(572, 266, 179, 29);
		panel.add(idyt);
		
		JLabel lblIdYoutube = new JLabel("ID Youtube");
		lblIdYoutube.setFont(new Font("Oswald", Font.PLAIN, 14));
		lblIdYoutube.setForeground(new Color(255, 255, 255));
		lblIdYoutube.setBounds(447, 269, 86, 26);
		panel.add(lblIdYoutube);
		
		genre = new JTextField(artist.getGenreMusique());
		genre.setFont(new Font("Oswald", Font.PLAIN, 12));
		genre.setBackground(Color.BLACK);
		genre.setCaretColor(Color.WHITE);
		genre.setForeground(Color.WHITE);
		genre.setColumns(10);
		genre.setBounds(572, 339, 179, 29);
		panel.add(genre);
		
		JLabel lblGenreMusicale = new JLabel("Genre Musicale");
		lblGenreMusicale.setFont(new Font("Oswald", Font.PLAIN, 14));
		lblGenreMusicale.setForeground(new Color(255, 255, 255));
		lblGenreMusicale.setBounds(447, 342, 86, 26);
		panel.add(lblGenreMusicale);
		
		JLabel lblUser = new JLabel("User");
		lblUser.setFont(new Font("Oswald", Font.PLAIN, 14));
		lblUser.setForeground(new Color(255, 255, 255));
		lblUser.setBounds(339, 151, 46, 14);
		panel.add(lblUser);
		
		JLabel user = new JLabel(artist.getUser());
		user.setForeground(Color.RED);
		user.setFont(new Font("Oswald", Font.PLAIN, 14));
		user.setBounds(395, 148, 157, 21);
		panel.add(user);
		artist.setImageString(file.getAbsolutePath());
		JButton changer = new JButton("Enregister");
		changer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				artist.setNom(textField.getText());
				artist.setPrenom(prenom.getText());
				artist.setDateNais(dateNais.getText());
			    artist.setGenreMusique(genre.getText());
			    artist.setIDSpotify(idstfy.getText());
			    artist.setIDYoutube(idyt.getText());
			  
				if(DataBaseConnection.UpdateArtist(artist)) 
			JOptionPane.showMessageDialog(frmModifierArtiste, "Artiste Mise A jour Avec Succés  ", "Congratulation !", JOptionPane.INFORMATION_MESSAGE,new ImageIcon ( menu.class.getResource("/pro/image/iconfinder_Yes_131856.png")));
			else
				JOptionPane.showMessageDialog(frmModifierArtiste, "Une erreue s'est produite  ", "Ooops!", JOptionPane.ERROR_MESSAGE);
				
				
			}
		});
		changer.setFocusable(false);
		changer.setBackground(SystemColor.textHighlight);
		changer.setFont(new Font("Oswald", Font.PLAIN, 14));
		changer.setForeground(Color.WHITE);
		changer.setBounds(329, 406, 146, 43);
		panel.add(changer);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser choix = new JFileChooser();
				int retour=choix.showOpenDialog(frmModifierArtiste);
				if(retour==JFileChooser.APPROVE_OPTION){
				   
				 choix.getSelectedFile().getName();
				  
				 artist.setImageString(choix.getSelectedFile().
				          getAbsolutePath());
				  
				 
				  
				}else {
					JOptionPane.showMessageDialog(frmModifierArtiste, "Aucun Image Choisi","Oops",JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnNewButton.setIcon(new ImageIcon(ProfilChange.class.getResource("/pro/image/iconfinder_Camera_131725.png")));
		btnNewButton.setBounds(518, 106, 46, 32);
		panel.add(btnNewButton);
	}

}
