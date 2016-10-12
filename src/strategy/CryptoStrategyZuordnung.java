package strategy;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CryptoStrategyZuordnung implements CryptoStrategy {

	private static String fAssignment = "Zuordnung.txt";
	
	private List<String> normal = new ArrayList<String>();
	private List<String> code = new ArrayList<String>();

	public CryptoStrategyZuordnung() {
		
		try {
			Scanner scan;
			scan = new Scanner(new File(fAssignment));

			while(scan.hasNext()){
				normal.add(scan.useDelimiter("\\s+").next());
				code.add(scan.useDelimiter("\\s+").next());
			}
			scan.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public String encrypt(String text) {
		String encrypted = "";

		for(int i = 0; i < text.length(); i++){
			for(int j = 0; j < normal.size(); j++){
				if(text.charAt(i) == normal.get(j).charAt(0)){
					encrypted += code.get(j);
					encrypted += " ";
				}
			}
		}

		return encrypted;
	}

	@Override
	public String decrypt(String text) {
		String decrypted = "";
		String[] data = text.split("\\s+");

		for(int i = 0; i < data.length; i++){
			for(int j = 0; j < code.size(); j++){
				if(Integer.parseInt(data[i]) == Integer.parseInt(code.get(j))){
					decrypted += normal.get(j);
				}
			}
		}

		return decrypted;
	}
}
