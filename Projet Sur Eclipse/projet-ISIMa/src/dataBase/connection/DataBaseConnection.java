package dataBase.connection;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.ObjectInputStream.GetField;
import java.lang.reflect.Constructor;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import com.model.artist.Artiste;
import com.mysql.cj.jdbc.Blob;

public class DataBaseConnection {

	
	public static Connection connectToBD() {
		Connection conn = null;
	
		try {
			 Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			 conn =
				       DriverManager.getConnection("jdbc:mysql://localhost:3308/gestion des artistes?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","");
			
		} catch (Exception e) {
			System.out.print(e);
		}
	 return conn;	
	}
	public static String AjouterArtiste(Artiste artiste) {
		PreparedStatement stat=null;
		Connection conn=connectToBD();
		FileInputStream file =null;
		File image=new File(artiste.getImageString());
		try {
			file = new FileInputStream(image);
		 String sql="insert into artiste (`user`, `nom`, `prenom`, `DateNais`, `genre de musique`, `idspotify`, `idyoutube`, `image`) values(?,?,?,?,?,?,?,?)";
	      stat=conn.prepareStatement(sql)	;
	      stat.setString(1, artiste.getUser());  
	      stat.setString(2, artiste.getNom());
	      stat.setString(3, artiste.getPrenom());
	      stat.setString(4, artiste.getDateNais());
	      stat.setString(5, artiste.getGenreMusique());
	      stat.setString(6, artiste.getIDSpotify());
	      stat.setString(7, artiste.getIDYoutube());
	      stat.setBinaryStream(8,(InputStream)file,(int)(image.length()) );
	      stat.executeUpdate();
	   
	      conn.close();
	      return null;
	      }
		catch(Exception e ) {
		return e.getMessage();
		}
		
	}
	public static List<Artiste> ConsulterArtiste(String User,boolean isUid) {
		PreparedStatement stat=null;
		String sql;
		List<Artiste>ListArtiste =new ArrayList<Artiste>();
		Connection conn=connectToBD();
		try {
			if(isUid)
		  sql="select* from artiste where user=?";
			else
				sql ="select* from artiste where nom=?";
		 
	      stat=conn.prepareStatement(sql)	;
	      stat.setString(1, User);
          ResultSet res=stat.executeQuery();
          
	      while(res.next()) {
	    	  Artiste a = new Artiste(); 
	    	  a.setUser(res.getString(1));
	    	  a.setNom(res.getString(2));
	    	  a.setPrenom(res.getString(3));
	    	  a.setDateNais(res.getString(4));
	    	  a.setGenreMusique(res.getString(5));
	    	  a.setIDSpotify(res.getString(6));
	    	  a.setIDYoutube(res.getString(7));
	    	  a.setImage((Blob) res.getBlob(8));
	    	  ListArtiste.add(a);
	    	  
	      

	     } stat.close();
			conn.close();}
		  catch(Exception e ) {
			System.out.print(e.getMessage());
		    }
		return ListArtiste;
        	}
	public static boolean DeleteArtiste(String uid) {
		PreparedStatement stat=null;
		int i=0;
		Connection conn=connectToBD();
		String sql="delete from artiste where user=?";
		try {
		stat=conn.prepareStatement(sql);
		stat.setString(1, uid);
		
		i =stat.executeUpdate();
		stat.close();
		conn.close();
		}
		catch(Exception e) {
			return false;
		}
		if(i!=0) {
			return true;
			
		}
		return false;
	}
	public static boolean UpdateArtist(Artiste artist) {
		PreparedStatement stat=null;
		int i=0;
		Connection conn=connectToBD();
		FileInputStream file =null;
		File image=new File(artist.getImageString());
		String sql="update artiste set nom=?,prenom=?,`genre de musique`=?,DateNais=?,idspotify=?,idyoutube=?,image=? where user=?";
		try {
			file = new FileInputStream(image);
			stat=conn.prepareStatement(sql);
			stat.setString(1, artist.getNom());
			stat.setString(2, artist.getPrenom());
			stat.setString(3,artist.getGenreMusique());
			stat.setString(4, artist.getDateNais());
			stat.setString(5, artist.getIDSpotify());
			stat.setString(6, artist.getIDYoutube());
			
			 stat.setBinaryStream(7,(InputStream)file,(int)(image.length()) );
			stat.setString(8, artist.getUser());
			i=stat.executeUpdate();
			stat.close();
			conn.close();
		}catch(Exception e){
			System.out.print(e.getMessage());
			return false;
		}
		if(i!=0)
			return true;
		return false;
	}
   
}
