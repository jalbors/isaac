package psp_2eval_practica4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import psp_2eval_practiva4.model.UsuarioLogin;

public class Lo {

	public static void main(String[] args) throws IOException {

		Gson gson = new Gson();
		int opcion = 0;
		int responseCode = 0;
		HttpURLConnection http = null;
		@SuppressWarnings("resource")
		Scanner tec = new Scanner(System.in);
		String token = "";

		URL url = new URL("http://localhost:8080/ProyectoFinalJorgeAlbors/usuarios/login");

		http = (HttpURLConnection) url.openConnection();
		http.setDoOutput(true);
		http.setRequestMethod("POST");
		http.setRequestProperty("Content-Type", "application/json");
		System.out.println("111");

		System.out.println("Introduzca usuario");
		String user = tec.nextLine();
		System.out.println("Introduzca pass");
		String pass = tec.nextLine();
		String pass_encrytp = encrytpSHA256(pass);

		System.out.println("222");

		// le pasamos el usuario transformado a json
		UsuarioLogin user_pass = new UsuarioLogin(user, pass_encrytp);
		String json = gson.toJson(user_pass);

		System.out.println("3333");
		// escribimos el json
		OutputStream os = http.getOutputStream();
		os.write(json.getBytes());
		os.flush();// ENVIA INFO AL SERVER

		System.out.println("44444");
		responseCode = http.getResponseCode();
		System.out.println("Codigo de respuesta: " + responseCode);

		// leemos la respuesta
		BufferedReader br = new BufferedReader(new InputStreamReader(http.getInputStream()));
		StringBuilder sb = new StringBuilder();
		String respuesta2;

		System.out.println("5555");

		while ((respuesta2 = br.readLine()) != null) {
			sb.append(respuesta2);// ANYADIR DATO AL STRING BUILDER

		}

		System.out.println("66666");

		// String token2 = "";
		UsuarioLogin user_token = gson.fromJson(sb.toString(), UsuarioLogin.class);

		token = user_token.getToken();
		System.out.println(token);

		System.out.println("Usuario: " + user_token.toString());
		http.disconnect();
	}

	public static String encrytpSHA256(String mensaje) {
		MessageDigest md;

		try {
			md = MessageDigest.getInstance("SHA-256");
			byte dataBytes[] = mensaje.getBytes();
			md.update(dataBytes);
			byte resumen[] = md.digest();
			return new String(Base64.getEncoder().encode(resumen));

		} catch (Exception e) {
			return e.getMessage();

		}

	}

}
