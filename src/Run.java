import java.util.Scanner;

import strategy.CryptoStrategyCaesar;
import strategy.CryptoStrategyJava;
import strategy.CryptoStrategyZuordnung;

public class Run {

	public static void main(String[] args) {

		Scanner scan = new Scanner (System.in);
		String fPath = "myText.txt";
		
		int wordCount = 5;
		
		for(int i = 0; i < wordCount; i++){
		
			System.out.println("["+(i+1)+"/"+wordCount+"]Text: ");
			CryptoIO crypt = new CryptoIO(scan.next());
			
			if(hasOnlyLetters(crypt.getText())){
				
				System.out.println("\n\n\tCAESAR");
				crypt.setCryptoStrategy(new CryptoStrategyCaesar(1));
				doStuff(crypt, fPath);
			}
			else
				System.out.println("\n\nOnly use letters to encrypt with Caesar\n\n");

			System.out.println("\tJAVA");
			crypt.setCryptoStrategy(new CryptoStrategyJava());
			doStuff(crypt, fPath);

			System.out.println("\tZUORDNUNG");
			crypt.setCryptoStrategy(new CryptoStrategyZuordnung());
			doStuff(crypt, fPath);
			
		}
		
		System.out.println("Programm beendet!");
		scan.close();
	}

	/**
	 * Verschluesselung und Entschluesselung wird initiiert und 
	 * jeweiliger Text ausgegeben.
	 * @param crypt Verschluesselungsinstanz
	 * @param fPath Dateipfad der Textdatei
	 */
	static void doStuff(CryptoIO crypt, String fPath){

		try{
			crypt.write(fPath);
			System.out.println("Verschluesselt: \""+crypt.getCoded()+"\"");
			crypt.read(fPath);
			System.out.println("Entschluesselt: \""+crypt.getText()+"\"\n");
			
		} catch(Exception e){
			e.printStackTrace();
		}

	}
	
	static boolean hasOnlyLetters(String text){
		
		for(int j = 0; j < text.length(); j++){
			if(!Character.isLetter(text.charAt(j))){
				return false;
			}
		}
		return true;
	}

}
