package BACKEND;

public class Begikas   {
private int atstumas;
private int nr;
private String vardas;
private String pavarde;
private String laikas;



public Begikas(int nr, int atstumas, String vardas, String pavarde, String laikas) { 
	this.nr=nr;
	this.atstumas=atstumas;
	this.vardas=vardas;
	this.pavarde=pavarde;
	this.laikas=laikas;
	
}



public int getAtstumas() {
	return atstumas;
}



public void setAtstumas(int atstumas) {
	this.atstumas = atstumas;
}



public int getNr() {
	return nr;
}



public void setNr(int nr) {
	this.nr = nr;
}



public String getVardas() {
	return vardas;
}



public void setVardas(String vardas) {
	this.vardas = vardas;
}



public String getPavarde() {
	return pavarde;
}



public void setPavarde(String pavarde) {
	this.pavarde = pavarde;
}



public String getLaikas() {
	return laikas;
}



public void setLaikas(String laikas) {
	this.laikas = laikas;
}




}
