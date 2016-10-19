package strategy;

public class CryptoStrategyCaesar implements CryptoStrategy {

	private int encryptDistance = 6;

	public CryptoStrategyCaesar(int distance){
		this.encryptDistance = distance;
	}
	
	@Override
	public String encrypt(String text) {
		String encrypted = "";
		int value = 0;

		for(int i = 0; i < text.length(); i++){
			
			value = ((int) text.charAt(i)) + encryptDistance;
			if( ((value > (int)'Z') && (value < (int)'a')) || value > (int)'z')
				value -= 26;
			
			encrypted += (char)value;
		}

		return encrypted;
	}

	@Override
	public String decrypt(String text) {
		String decrypted = "";
		int value = 0;

		for(int i = 0; i < text.length(); i++){
			
			value = ((int)text.charAt(i))-encryptDistance;
			if( ((value > (int)'Z') && (value < (int)'a')) || value < (int)'A')
				value += 26;
			
			decrypted += (char)value;
		}

		return decrypted;
	}
}