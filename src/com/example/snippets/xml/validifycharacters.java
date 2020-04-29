package com.example.snippets.xml;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class validifycharacters {

	public static void main(String[] args) throws IOException {
		String cleanXMLString = null;
		Pattern pattern = null;
		Matcher matcher = null;

		InputStream is = new FileInputStream("files/donnesge1.xml");
		BufferedReader buf = new BufferedReader(new InputStreamReader(is));
		String line = buf.readLine();
		StringBuilder sb = new StringBuilder();
		while (line != null) {
			sb.append(line).append("\n");
			line = buf.readLine();
		}
		String fileAsString = sb.toString();
		System.out.println("Contents : " + fileAsString);

		String dirtyXMLString = fileAsString;
		pattern = Pattern.compile("[\\000]*");
		
	    FileOutputStream fos = new FileOutputStream("files/output.xml");
	    DataOutputStream outStream = new DataOutputStream(new BufferedOutputStream(fos));
	
	    
		matcher = pattern.matcher(dirtyXMLString);
		if (matcher.find()) {
			System.out.println("match");
			cleanXMLString = matcher.replaceAll("");
			System.out.println(cleanXMLString);
		    outStream.writeBytes(cleanXMLString);
		    outStream.close();
		}
	}
}
