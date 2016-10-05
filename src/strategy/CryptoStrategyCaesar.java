package strategy;

public class CryptoStrategyCaesar implements CryptoStrategy {

	static int encryptDistance = 6;

	@Override
	public String encrypt(String text) {
		String encrypted = "";

		for(int i = 0; i < text.length(); i++){
			encrypted += (char)(((int)text.charAt(i))+encryptDistance);
		}

		return encrypted;
	}

	@Override
	public String decrypt(String text) {
		String decrypted = "";

		for(int i = 0; i < text.length(); i++){
			decrypted += (char)(((int)text.charAt(i))-encryptDistance);
		}

		return decrypted;
	}
}