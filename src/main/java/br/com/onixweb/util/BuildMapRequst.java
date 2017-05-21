package br.com.onixweb.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLDecoder;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

public class BuildMapRequst {
	
	public static HashMap<String, String> buildQueryMap(HttpServletRequest request) throws IOException {

		InputStream requestStream = request.getInputStream();
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

		byte[] buffer = new byte[32];
		int read = 0;

		while (read >= 0) {

			read = requestStream.read(buffer);
			if (read >= 0) {
				outputStream.write(buffer, 0, read);
			}
		}

		String pageParameters = new String(outputStream.toByteArray(), "UTF-8");

		String[] params = pageParameters.split("&");
		HashMap<String, String> map = new HashMap<String, String>();

		System.err.println(":: params: " + params.length);

		for (int i = 0; i < params.length; i++) {
			String[] split = params[i].split("=", -1);

			System.out.println("Valor: " + params[i].split("=", -1).toString());

			map.put(URLDecoder.decode(split[0], "UTF-8"), URLDecoder.decode(split[1], "UTF-8"));

			System.out.println("Map: "
					+ map.put(URLDecoder.decode(split[0], "UTF-8"), URLDecoder.decode(split[1], "UTF-8")).toString());
		}

		return map;
	}
}
