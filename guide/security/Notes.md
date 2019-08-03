1. Symmetric Key - Encrypt + Decrypt using the same key - Example uses a block cipher which uses padding - AES algorithm is a symmetric algorithm

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

2. Asymmetric algorithm in JAVA - use of public and private key

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

3. Hashing - Hashing a message - to check if document has not been modified

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

4. Digital Signature

    public class DigitalSignatureString {
    
    	private static final String SIGNING_ALGORITHM = "SHA256withRSA";
    
    	public static byte[] createDigitalSignature(byte[] input, PrivateKey privateKey) throws Exception {
    		Signature signature = Signature.getInstance(SIGNING_ALGORITHM);
    		signature.initSign(privateKey);
    		signature.update(input);
    		return signature.sign();
    	}
    
    	public static Boolean verifyDigitalSignature(byte[] input, byte[] signatureToVerify, PublicKey publicKey)
    			throws Exception {
    		Signature signature = Signature.getInstance(SIGNING_ALGORITHM);
    		signature.initVerify(publicKey);
    		signature.update(input);
    		return signature.verify(signatureToVerify);
    
    	}
    
    	public static void main(String[] args) throws Exception {
    		URL url = DigitalSignatureString.class.getClassLoader().getResource("demo.txt");
    		Path path = Paths.get(url.toURI());
    		byte[] input = Files.readAllBytes(path);
    		KeyPair keyPair = AssymetricEncryptionUtils.generateRSAKeyPair();
    		byte[] signature = createDigitalSignature(input, keyPair.getPrivate());
    		System.out.println(DatatypeConverter.printHexBinary(signature));
    		verifyDigitalSignature(input, signature, keyPair.getPublic());
    	}
    
    }

5. KeyStore

    public class KeyStoreUtils {
    
    	// default type does not store private key
    	private static final String SECRET_KEY_KEYSTORE_TYPE = "JCEKS";
    
    	public static KeyStore createKeyStore(String keystorePassword, String keyAlias, SecretKey secretKey,
    			String secretKeyPassword) throws Exception {
    		KeyStore keyStore = KeyStore.getInstance(SECRET_KEY_KEYSTORE_TYPE);
    		keyStore.load(null, keystorePassword.toCharArray());
    		KeyStore.ProtectionParameter entryPassword = new KeyStore.PasswordProtection(secretKeyPassword.toCharArray());
    		KeyStore.SecretKeyEntry privateKeyEntry = new KeyStore.SecretKeyEntry(secretKey);
    		keyStore.setEntry(keyAlias, privateKeyEntry, entryPassword);
    		return keyStore;
    	}
    
    	public static void main(String[] args) throws Exception {
    		SecretKey secretKey = SymetricCryptoUtils.createAESKey();
    		String secretKeyHex = DatatypeConverter.printHexBinary(secretKey.getEncoded());
    		KeyStore keyStore = KeyStoreUtils.createKeyStore("password", "foo", secretKey, "keyPassword");
    
    		keyStore.load(null, "password".toCharArray());
    		KeyStore.ProtectionParameter entryPassword = new KeyStore.PasswordProtection("keyPassword".toCharArray());
    		KeyStore.SecretKeyEntry resultEntry = (KeyStore.SecretKeyEntry) keyStore.getEntry("foo", entryPassword);
    		SecretKey result = resultEntry.getSecretKey();
    		String resultKeyHex = DatatypeConverter.printHexBinary(result.getEncoded());
    
    		System.out.println(secretKeyHex);
    		System.out.println(resultKeyHex);
    		// equal key
    
    	}
    }