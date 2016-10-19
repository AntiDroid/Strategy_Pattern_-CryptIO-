package strategy;

public interface CryptoStrategy {
	
	String encrypt(String text);
	String decrypt(String text);
}
