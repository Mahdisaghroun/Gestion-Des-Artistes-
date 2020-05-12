package com.gui.net;

import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;

import com.model.artist.Artiste;
import com.mysql.cj.jdbc.Blob;
import com.mysql.cj.protocol.FullReadInputStream;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;

public class Profil {

	public  JFrame frmMahdi;
	public Artiste artiste;
	String fileName = "C://p/tree.png";
	File file = new File(fileName);

	/**
	 * Create the application.
	 */
	public Profil(Artiste artiste) {
		this.artiste=artiste;
		 try  {
			 FileOutputStream fos = new FileOutputStream(file,false);

            Blob blob =artiste.getImage();
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
		frmMahdi = new JFrame();
		frmMahdi.setIconImage(Toolkit.getDefaultToolkit().getImage(Profil.class.getResource("/pro/image/iconfinder_Show_131782.png")));
		frmMahdi.setTitle(artiste.getNom()+" "+artiste.getPrenom());
		frmMahdi.getContentPane().setFont(new Font("Oswald", Font.PLAIN, 12));
		frmMahdi.getContentPane().setForeground(Color.BLUE);
		frmMahdi.setBounds(100, 100, 787, 504);
		frmMahdi.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmMahdi.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel() { public void paintComponent(Graphics g) {  
            Image img = Toolkit.getDefaultToolkit().getImage(  
                    Profil.class.getResource("/pro/image/frank-septillion-Qrspubmx6kE-unsplash (1).jpg"));  
     g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);  
    }  
};  
		panel.setBounds(0, 0, 771, 465);
		frmMahdi.getContentPane().add(panel);
		panel.setLayout(null);
		
		JPanel image = new JPanel(){ public void paintComponent(Graphics g) {  
            Image img = Toolkit.getDefaultToolkit().getImage(  
            	(fileName));  
     g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);  
    }  
};  
		image.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		image.setBounds(298, 0, 169, 145);
		panel.add(image);
		
		JLabel lblNewLabel = new JLabel("User :");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Oswald", Font.PLAIN, 13));
		lblNewLabel.setBounds(316, 168, 67, 14);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nom :");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Oswald", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(10, 211, 46, 28);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Pr\u00E9nom :");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Oswald", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(10, 277, 77, 29);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Date Naissance :");
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setFont(new Font("Oswald", Font.PLAIN, 13));
		lblNewLabel_3.setBounds(10, 353, 104, 28);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Genre Musicale :");
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setFont(new Font("Oswald", Font.PLAIN, 13));
		lblNewLabel_4.setBounds(438, 225, 116, 14);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("ID Spotify :");
		lblNewLabel_5.setForeground(Color.WHITE);
		lblNewLabel_5.setFont(new Font("Oswald", Font.PLAIN, 13));
		lblNewLabel_5.setBounds(438, 277, 84, 29);
		panel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("ID Youtube :");
		lblNewLabel_6.setForeground(Color.WHITE);
		lblNewLabel_6.setFont(new Font("Oswald", Font.PLAIN, 13));
		lblNewLabel_6.setBounds(438, 353, 84, 28);
		panel.add(lblNewLabel_6);
		
		JLabel nom = new JLabel(artiste.getNom());
		nom.setForeground(Color.WHITE);
		nom.setFont(new Font("Oswald", Font.PLAIN, 14));
		nom.setBounds(138, 225, 136, 14);
		panel.add(nom);
		
		JLabel prenom = new JLabel(artiste.getPrenom());
		prenom.setForeground(Color.WHITE);
		prenom.setFont(new Font("Oswald", Font.PLAIN, 14));
		prenom.setBounds(138, 277, 136, 29);
		panel.add(prenom);
		
		JLabel Date_Nais = new JLabel(artiste.getDateNais());
		Date_Nais.setForeground(Color.WHITE);
		Date_Nais.setFont(new Font("Oswald", Font.PLAIN, 14));
		Date_Nais.setBounds(138, 353, 136, 28);
		panel.add(Date_Nais);
		
		JLabel genre = new JLabel(artiste.getGenreMusique());
		genre.setForeground(Color.WHITE);
		genre.setFont(new Font("Oswald", Font.PLAIN, 14));
		genre.setBounds(564, 218, 206, 30);
		panel.add(genre);
		
		JLabel spotify = new JLabel(artiste.getIDSpotify());
		spotify.setForeground(Color.WHITE);
		spotify.setFont(new Font("Oswald", Font.PLAIN, 14));
		spotify.setBounds(532, 277, 206, 29);
		panel.add(spotify);
		
		JLabel youtube = new JLabel(artiste.getIDYoutube());
		youtube.setForeground(Color.WHITE);
		youtube.setFont(new Font("Oswald", Font.PLAIN, 14));
		youtube.setBounds(532, 353, 206, 28);
		panel.add(youtube);
		
		JLabel user = new JLabel(artiste.getUser());
		user.setForeground(Color.WHITE);
		user.setFont(new Font("Oswald", Font.PLAIN, 14));
		user.setBounds(369, 168, 136, 14);
		panel.add(user);
	
		}
		
}

