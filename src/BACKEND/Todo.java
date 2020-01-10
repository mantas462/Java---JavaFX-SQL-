package BACKEND;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Statement;

public class Todo {

	
	
	Connection con =null;
	
	public ArrayList<Begikas> getBegikas() throws SQLException {
		connectToDB();
		
		ArrayList<Begikas> begikai = new ArrayList();
		
		Statement ps = (Statement) con.createStatement();
		ResultSet result = ps.executeQuery("SELECT * FROM begikas");
		
		while(result.next()) {
			int nr = result.getInt(1);
			int atstumas = result.getInt(2);
			String vardas = result.getString(3);
			String pavarde = result.getString(4);
			String laikas = result.getString(5);
	
			Begikas begikas=new Begikas(nr, atstumas, vardas, pavarde, laikas);

			begikai.add(begikas);
		}
		
		
		
		disconnectFromDB();
		return begikai;
	}
	
	public ArrayList<Begikas> getNeededBegikas(int reikiamasAtstumas) throws SQLException {
		connectToDB();
		
		
		ArrayList<Begikas> begikai = new ArrayList();
		
		String sqlSentence = "SELECT * from begikas where atstumas=?";
		PreparedStatement ps = con.prepareStatement(sqlSentence);
		ps.setInt(1, reikiamasAtstumas);
		ResultSet result = ps.executeQuery();
		
		while(result.next()) {
			int nr = result.getInt(1);
			int atstumas = result.getInt(2);
			String vardas = result.getString(3);
			String pavarde = result.getString(4);
			String laikas = result.getString(5);
	
			Begikas begikas=new Begikas(nr, atstumas, vardas, pavarde, laikas);

			begikai.add(begikas);
		}
		
		
		
		disconnectFromDB();
		return begikai;
	}
	
	
	public int getirasuskaicius() throws SQLException {
		connectToDB();
		
		int irasuskaicius=0;
		
		Statement ps = (Statement) con.createStatement();
		ResultSet result = ps.executeQuery("SELECT * FROM begikas");
		
		while(result.next()) {
		irasuskaicius++;
		}
		
		
		
		disconnectFromDB();
		return irasuskaicius;
	}
	
	
	public int getreikiamuirasuskaicius(int reikiamasatstumas) throws SQLException {
		connectToDB();
		
		int irasuskaicius=0;
		
		String sqlSentence = "SELECT * from begikas where atstumas=?";
		PreparedStatement ps = con.prepareStatement(sqlSentence);
		ps.setInt(1, reikiamasatstumas);
		ResultSet result = ps.executeQuery();
		
		while(result.next()) {
			irasuskaicius++;
		}
		
		
		disconnectFromDB();
		return irasuskaicius;
	}
	
	
	
	
	
	
	
	public int[] getAtstumai() throws SQLException {
		connectToDB();
		
		int masyvoIlgis=0;
		
		Statement ps = (Statement) con.createStatement();
		ResultSet result = ps.executeQuery("SELECT atstumas FROM begikas");
		
		while(result.next()) {
			masyvoIlgis++;
		}
		
		Statement ps2 = (Statement) con.createStatement();
		ResultSet result2 = ps2.executeQuery("SELECT atstumas FROM begikas");
		
		int [] atstumuskaicius=new int[masyvoIlgis];
		int nr=0;
		
		while(result2.next()) {
			int atstumas = result2.getInt(1);
			atstumuskaicius[nr]=atstumas;
			nr++;
		}
		
		disconnectFromDB();
		return atstumuskaicius;
		
	}
	
	
	public void connectToDB() {
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/atsiskaitymas", "root", "");
			System.out.println("CONNECTED");
		}
		catch (Exception e) {
			System.out.println("Not connected to database");
		}
	}

	public void disconnectFromDB() {
		try {
			con.close();
		}
		catch (Exception e) {
			System.out.println("Not connected");
		}
	}
}
