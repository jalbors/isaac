package psp_2eval_practica4.utilities;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import psp_2eval_practiva4.model.Respuesta;

public class GestorHTTP {

	public final static int READ_TIMEOUT = 30000; // milliseconds
	public final static int CONNECT_TIMEOUT = 35000; // milliseconds
	public final static String CONTENT_TYPE_JSON = "application/json";

	public static Respuesta peticion(String uri, String json, String metodo, String token) {
		Respuesta respuesta = new Respuesta();
		try {
			URL url = new URL(uri);
			HttpURLConnection conexion = (HttpURLConnection) url.openConnection();
			conexion.setReadTimeout(READ_TIMEOUT);
			conexion.setConnectTimeout(CONNECT_TIMEOUT);			if (!token.isEmpty()) {
				conexion.setRequestProperty("Authorization", "bearer " + token);
			}
			if (metodo.equals("POST") || metodo.equals("PUT")) {
				conexion.setRequestProperty("Content-Type", CONTENT_TYPE_JSON);
				conexion.setDoOutput(true);
				conexion.setFixedLengthStreamingMode(json.getBytes().length);
			} else {
				conexion.setRequestProperty("Accept", CONTENT_TYPE_JSON);
			}
			conexion.connect();
			if (metodo.equals("POST") || metodo.equals("PUT")) {
				OutputStream os = new BufferedOutputStream(conexion.getOutputStream());
				os.write(json.getBytes());
				os.flush();
			}
			int codigoPeticion = conexion.getResponseCode();
			respuesta.setCodigoPeticion(codigoPeticion);
			if (codigoPeticion == HttpURLConnection.HTTP_OK || codigoPeticion == HttpURLConnection.HTTP_CREATED) {
				respuesta.setJsonRespuesta(getStringFromInputStream(conexion.getInputStream()));
			}

			conexion.disconnect();
		} catch (MalformedURLException e) {
			respuesta.setCodigoPeticion(HttpURLConnection.HTTP_BAD_REQUEST);
			System.out.println("Error al crear la URL: " + uri + ". \nMensaje de error: " + e.getMessage());
			e.printStackTrace();
		} catch (ProtocolException e) {
			System.out.println("Error de protocolo: " + e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Error de E/S: " + e.getMessage());
			e.printStackTrace();
		}

		return respuesta;
	}

	// convert InputStream to String
	private static String getStringFromInputStream(InputStream is) {

		BufferedReader br = null;
		StringBuilder sb = new StringBuilder();

		String line;
		try {

			br = new BufferedReader(new InputStreamReader(is));
			while ((line = br.readLine()) != null) {
				sb.append(line);
			}

		} catch (IOException e) {
			System.out.println("Error al convertir la respuesta a string");
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		return sb.toString();

	}
}
