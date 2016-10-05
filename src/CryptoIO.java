import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

import strategy.CryptoStrategy;

class CryptoIO {

	private CryptoStrategy cs;
	private String text;
	private String coded = "";
	
	
	/**
	 * Konstruktor der Verschluesselungsinsatz
	 * @param t zu verschluesselnder Text
	 */
	public CryptoIO (String t) {
		this.text = t;
	}

	/**
	 * Auswahl der Verschluesselungsart
	 * @param cs gewaehlter Algorithmus
	 */
	public void setCryptoStrategy(CryptoStrategy cs){
		this.cs = cs;
	}

	/**
	 * Text verschluesselt in eine Textdatei schreiben.
	 * @param fPath Textpfad
	 * @throws UnsupportedEncodingException
	 * @throws FileNotFoundException
	 */
	public void write(String fPath) throws FileNotFoundException, UnsupportedEncodingException {
		String encText = cs.encrypt(text);
		coded = encText;
		
		PrintWriter writer = new PrintWriter(fPath, "UTF-8");
		writer.println(encText);
		writer.close();
	}

	/**
	 * Text entschluesselt aus Textdatei auslesen.
	 * @param fPath
	 * @throws FileNotFoundException
	 */
	public void read(String fPath) throws FileNotFoundException{
		Scanner scan = new Scanner(new File(fPath));
		String encText = scan.useDelimiter("\\Z").next();
		scan.close();

		text = cs.decrypt(encText);
	}

	public String getText(){
		return text;
	}

	public String getCoded(){
		return coded;
	}
}
