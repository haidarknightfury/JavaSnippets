package com.example.crypto.assymetric;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.xml.bind.DatatypeConverter;

public class AssymetricEncryptionUtils {
	private static final String RSA = "RSA";

	public static KeyPair generateRSAKeyPair() throws Exception {
		SecureRandom secureRandom = new SecureRandom();
		KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(RSA);
		keyPairGenerator.initialize(4096, secureRandom);
		return keyPairGenerator.generateKeyPair();
	}

	public static void main(String args[]) throws Exception {
		KeyPair keyPair = generateRSAKeyPair();
		// private key is longer
		System.out.println("Private Key: " + DatatypeConverter.printHexBinary(keyPair.getPrivate().getEncoded()));
		System.out.println("Public Key: " + DatatypeConverter.printHexBinary(keyPair.getPublic().getEncoded()));

		String plainText = "Hello my name is haidar";
		byte[] cipherText = performRSAEncryption(plainText, keyPair.getPrivate());

		String decrypted = performRSADecryption(cipherText, keyPair.getPublic());
		System.out.println("Decrypted :" + decrypted);

	}

	public static byte[] performRSAEncryption(String plainText, PrivateKey privateKey) throws Exception {
		// not block cipher - no padding necessary
		Cipher cipher = Cipher.getInstance(RSA);
		// encrypt with private key + decrypt with public - assymetric works both ways
		cipher.init(Cipher.ENCRYPT_MODE, privateKey);
		return cipher.doFinal(plainText.getBytes());
	}

	public static String performRSADecryption(byte[] cipherText, PublicKey publicKey) throws Exception {
		Cipher cipher = Cipher.getInstance(RSA);
		cipher.init(Cipher.DECRYPT_MODE, publicKey);
		byte[] result = cipher.doFinal(cipherText);
		return new String(result);
	}
}
