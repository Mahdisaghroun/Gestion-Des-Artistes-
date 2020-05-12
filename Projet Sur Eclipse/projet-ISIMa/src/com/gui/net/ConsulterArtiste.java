package com.gui.net;

import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.List;
import java.awt.ScrollPane;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import com.model.artist.Artiste;

import dataBase.connection.DataBaseConnection;

import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Dimension;
import java.awt.SystemColor;
import javax.swing.UIManager;
import java.awt.Cursor;

public class ConsulterArtiste {

	public JFrame frmConsulterUnArtiste;
	private JTextField textField;
	private JTable table;
	public boolean viewDelete;
	public String Title;
	private boolean rechType;
	private boolean modif;
	private String btnname;
	ArrayList<Artiste> list = new ArrayList<Artiste>();
	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the application.
	 */
	public ConsulterArtiste(String Title,boolean viewDelete,boolean modif) {
		this.Title=Title;
		this.viewDelete=viewDelete;
		this.modif=modif;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		if(this.modif)
			btnname="Modifier";
		else
			btnname="Supprimer";
		frmConsulterUnArtiste = new JFrame();
		frmConsulterUnArtiste.setIconImage(Toolkit.getDefaultToolkit().getImage(ConsulterArtiste.class.getResource("/pro/image/iconfinder_Pinion_131871.png")));
		frmConsulterUnArtiste.setTitle(this.Title);
		frmConsulterUnArtiste.setBounds(100, 100, 802, 504);
		frmConsulterUnArtiste.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmConsulterUnArtiste.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel()  { public void paintComponent(Graphics g) {  
            Image img = Toolkit.getDefaultToolkit().getImage(  
                    menu.class.getResource("/pro/image/frank-septillion-Qrspubmx6kE-unsplash (1).jpg"));  
     g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);  
    }};  
		
		
		panel.setBounds(0, 0, 786, 465);
		frmConsulterUnArtiste.getContentPane().add(panel);
		panel.setLayout(null);
		
		
		JLabel lblNewLabel = new JLabel(this.Title);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Oswald", Font.PLAIN, 23));
		lblNewLabel.setBounds(291, 11, 252, 35);
		panel.add(lblNewLabel);
		
		JRadioButton rechUid = new JRadioButton("Recherche Par UID");
		
		rechUid.setFont(new Font("Oswald", Font.PLAIN, 15));
		rechUid.setFocusable(false);
		rechUid.setForeground(Color.WHITE);
		rechUid.setBackground(Color.BLACK);
		rechUid.setBounds(163, 93, 170, 23);
		panel.add(rechUid);
		
		JRadioButton rechNom = new JRadioButton("Recherche Par Nom");
		
		rechNom.setFont(new Font("Oswald", Font.PLAIN, 15));
		rechNom.setFocusable(false);
		rechNom.setForeground(Color.WHITE);
		rechNom.setBackground(Color.BLACK);
		rechNom.setBounds(393, 93, 170, 23);
		panel.add(rechNom);
		ButtonGroup g= new ButtonGroup();
		g.add(rechNom);
		g.add(rechUid);
		
		JPanel ZoneRech = new JPanel();
		ZoneRech.setBackground(Color.BLACK);
		ZoneRech.setBounds(39, 153, 446, 42);
		panel.add(ZoneRech);
		ZoneRech.setLayout(null);
		ZoneRech.setVisible(false);
		rechUid.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ZoneRech.setVisible(true);
				rechType=true;
				
			}
		});
		rechNom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ZoneRech.setVisible(true);
				rechType=false;
				
			}
		});
		textField = new JTextField();
		
		textField.setFont(new Font("Oswald", Font.PLAIN, 15));
		textField.setForeground(Color.WHITE);
		textField.setBackground(Color.BLACK);
		textField.setBounds(10, 5, 267, 33);
		ZoneRech.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Rechercher");
		
		btnNewButton.setFont(new Font("Oswald", Font.PLAIN, 15));
		btnNewButton.setFocusable(false);
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(Color.BLACK);
		btnNewButton.setBounds(315, 10, 126, 23);
		ZoneRech.add(btnNewButton);
		
		
	 
	        String[] entetes = {"UID", "Nom", "Prenom"};
	     DefaultTableModel  model = new DefaultTableModel(null,entetes);
	     DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
	     centerRenderer.setHorizontalAlignment( SwingConstants.CENTER );
	  
		table = new JTable(model);
		  
		table.setSelectionBackground(Color.ORANGE);
		table.setSize(new Dimension(3, 3));
		table.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		table.setGridColor(Color.BLACK);
		table.setRowHeight(40);
		table.setRowMargin(0);
		table.setFont(new Font("DialogInput", Font.PLAIN, 16));
		table.setForeground(new Color(0, 0, 0));
		table.setIgnoreRepaint(true);
		table.setBorder(null);
		table.setOpaque(false);
		table.setFocusable(false);
		table.setBackground(new Color(227, 227, 227));
		
		 table.setDefaultRenderer(String.class, centerRenderer);

		JScrollPane j = new JScrollPane(table);
		j.setFont(new Font("Oswald", Font.PLAIN, 15));
				j.setBounds(0, 216, 786, 134);
				j.setBackground(SystemColor.inactiveCaptionBorder);
				j.setForeground(Color.BLACK);
		panel.add(j);
		
		JButton btnVoirProfil = new JButton("Voir Profil");
		btnVoirProfil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				int i = table.getSelectedRow();
				Profil window = new Profil(list.get(i));
				
				window.frmMahdi.setVisible(true);
				
			}
		});
		btnVoirProfil.setForeground(Color.WHITE);
		btnVoirProfil.setFont(new Font("Oswald", Font.PLAIN, 14));
		btnVoirProfil.setFocusable(false);
		btnVoirProfil.setBorder(null);
		btnVoirProfil.setBackground(SystemColor.textHighlight);
		if(viewDelete)
		btnVoirProfil.setBounds(494, 383, 141, 42);
		else
			btnVoirProfil.setBounds(271, 384, 141, 42);
		btnVoirProfil.setVisible(false);
		btnVoirProfil.setEnabled(false);
		panel.add(btnVoirProfil);
		
			JButton delete = new JButton(btnname);
		delete.setFocusable(false);
		delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(!modif) {
				try {
					int i=JOptionPane.showConfirmDialog(frmConsulterUnArtiste, "Voulez-vous vraiment supprimer cet Artiste ? ", "Attention",JOptionPane.YES_NO_OPTION);
					if(i==JOptionPane.YES_OPTION) {
				if(DataBaseConnection.DeleteArtiste(table.getModel().getValueAt(table.getSelectedRow(), 0).toString())) {
					 JOptionPane.showMessageDialog(frmConsulterUnArtiste, "Artiste Supprimer Avec Succés  ", "Congratulation !", JOptionPane.INFORMATION_MESSAGE,new ImageIcon ( menu.class.getResource("/pro/image/iconfinder_Yes_131856.png")));
				     model.removeRow(table.getSelectedRow());
				     if(table.getRowCount()==0) {
				    		j.setVisible(false);
							btnVoirProfil.setVisible(false);
							
								delete.setVisible(false);
				     }
				
				}else
					JOptionPane.showMessageDialog(frmConsulterUnArtiste, "Une erreur produit", "Oops", JOptionPane.ERROR_MESSAGE);
					}}
				catch(Exception e){
					JOptionPane.showMessageDialog(frmConsulterUnArtiste, "Une erreur produit", "Oops", JOptionPane.ERROR_MESSAGE);
					}
				
				
				
			}
				else
				{
				ProfilChange window = new ProfilChange(list.get(table.getSelectedRow()));
				      window.frmModifierArtiste.setVisible(true);
				}
					}
				
		});
		delete.setBackground(SystemColor.textHighlight);
		delete.setForeground(Color.WHITE);
		delete.setFont(new Font("Oswald", Font.PLAIN, 13));
		delete.setBounds(136, 384, 141, 42);
		delete.setVisible(false);
		delete.setEnabled(false);
		panel.add(delete);
		j.setVisible(false);
		
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				  
				  
				btnVoirProfil.setEnabled(true);
				delete.setEnabled(true);
			}
		;
	    });
	
		btnNewButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				j.setVisible(false);
				btnVoirProfil.setVisible(false);
				
					delete.setVisible(false);
				
			int num = model.getRowCount();
		  if(num!=0)
			for(int j =0; j<num;j++) {
				model.removeRow(j);
			}
			list=(ArrayList<Artiste>) DataBaseConnection.ConsulterArtiste(textField.getText(),rechType);
			for(int i=0 ; i<list.size();i++) {
				model.addRow(new Object[] {list.get(i).getUser(),list.get(i).getNom(),list.get(i).getPrenom()});
			}
			    if(!list.isEmpty()) {
				j.setVisible(true);
			   btnVoirProfil.setVisible(true);
			   if(viewDelete) 
				   delete.setVisible(true);   
			    }
			    else {
			    	JOptionPane.showMessageDialog(frmConsulterUnArtiste, "Aucun Artiste Trouvé", "Oops", JOptionPane.ERROR_MESSAGE);
			    }
			}
		});
	}
}
