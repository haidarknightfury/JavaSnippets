package com.example.crypto.hash;

import java.io.ByteArrayOutputStream;
import java.security.MessageDigest;
import java.security.SecureRandom;

import javax.xml.bind.DatatypeConverter;

import org.mindrot.jbcrypt.BCrypt;

public class HashUtils {

	// rainbow table
	private static final String SHA2_ALGORITHM = "SHA-256";

	public static void main(String[] args) throws Exception {

		System.out.println("SALT: " + generateRandomSalt());
		String valueToHash = "Haidar";

		byte[] salt = generateRandomSalt();

		// using normal hash - SHA-256
		byte[] hashed = createSHA2Hash(valueToHash, salt);
		System.out.println("HASHED: " + DatatypeConverter.printHexBinary(hashed));
		System.out.println("REHASHED: " + DatatypeConverter.printHexBinary(createSHA2Hash(valueToHash, salt)));

		// Using BCrypt algorithm
		String password = "haidardargaye";
		String passwordHash = hashPassword(password);
		System.out.println(verifyPassword(password, passwordHash));

	}

	public static byte[] generateRandomSalt() {
		byte[] salt = new byte[16];
		SecureRandom secureRandom = new SecureRandom();
		secureRandom.nextBytes(salt);
		return salt;
	}

	public static byte[] createSHA2Hash(String input, byte[] salt) throws Exception {
		// add salt to input - salt prevent rainbow table attacks
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

		byteArrayOutputStream.write(salt);
		// input + salt
		byteArrayOutputStream.write(input.getBytes());
		byte[] valueToHash = byteArrayOutputStream.toByteArray();

		MessageDigest messageDigest = MessageDigest.getInstance(SHA2_ALGORITHM);
		return messageDigest.digest(valueToHash);

	}

	public static String hashPassword(String password) {
		// contain number of rounds + hash + salt
		return BCrypt.hashpw(password, BCrypt.gensalt());
	}

	public static Boolean verifyPassword(String password, String hashedPw) {
		return BCrypt.checkpw(password, hashedPw);

	}
}
