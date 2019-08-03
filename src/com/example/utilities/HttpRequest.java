package com.example.utilities;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class HttpRequest {

	public static void main(String [] args) throws IOException {
		OkHttpClient client = new OkHttpClient();

		Request request = new Request.Builder()
		  .url("http://netcat.127.0.0.1.xip.io:8080/")
		  .method("UDACITY", null)
		  .addHeader("HOST", "haidar")
		  .addHeader("X-Udacity-Exercise-Header", "udacity header")
		  .addHeader("Date", "Wed, 11 Jan 1995 23:00:00 GMT")
		  .build();

		Response response = client.newCall(request).execute();
		System.out.println(response.body().toString());
	}
}
