package com.example.crypto.symetric;

import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.xml.bind.DatatypeConverter;

public class SymetricCryptoUtils {

	public static final String AES = "AES";
	private static String AES_CIPHER_ALGORITH = "AES/CBC/PKCS5Padding";

	public static void main(String[] args) throws Exception {
		performSymetricEncryption();
	}

	public static void performSymetricEncryption() throws Exception {
		// Creating a secret key
		SecretKey key = createAESKey();
		System.out.println(DatatypeConverter.printHexBinary(key.getEncoded()));

		// An initialisation vector to initialise the algorithm - acts as a salt value
		byte[] initializationVector = createInitializationVector();
		String plainText = "Haidar dargaye";
		// key is passed + initialisation
		byte[] cipherText = performAESEncryption(plainText, key, initializationVector);
		System.out.println(cipherText);

		// Symettric encryption - encryption & decryption done using same key+
		// initialization vector
		String deCryptedText = performAESDecryption(cipherText, key, initializationVector);
		System.out.println(deCryptedText);

	}

	public static byte[] createInitializationVector() {
		byte[] initializationVectore = new byte[16];
		SecureRandom secureRandom = new SecureRandom();
		secureRandom.nextBytes(initializationVectore);
		return initializationVectore;
	}

	public static byte[] performAESEncryption(String plainText, SecretKey secretKey, byte[] initializationVector)
			throws Exception {
		Cipher cipher = Cipher.getInstance(AES_CIPHER_ALGORITH);
		IvParameterSpec inIvParameterSpec = new IvParameterSpec(initializationVector);
		cipher.init(Cipher.ENCRYPT_MODE, secretKey, inIvParameterSpec);
		return cipher.doFinal(plainText.getBytes());
	}

	public static String performAESDecryption(byte[] cipherText, SecretKey secretKey, byte[] initializationVector)
			throws Exception {
		Cipher cipher = Cipher.getInstance(AES_CIPHER_ALGORITH);
		IvParameterSpec inIvParameterSpec = new IvParameterSpec(initializationVector);
		cipher.init(Cipher.DECRYPT_MODE, secretKey, inIvParameterSpec);
		byte[] result = cipher.doFinal(cipherText);
		return new String(result);

	}

	public static SecretKey createAESKey() throws Exception {
		SecureRandom secureRandom = new SecureRandom();
		KeyGenerator keyGenerator = KeyGenerator.getInstance(AES);
		keyGenerator.init(256, secureRandom);
		return keyGenerator.generateKey();
	}

}
