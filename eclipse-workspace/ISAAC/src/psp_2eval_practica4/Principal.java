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

import psp_2eval_practiva4.model.Usuario;
import psp_2eval_practiva4.model.UsuarioLogin;

public class Principal {
	public static final String TYPE = "application/json";

	public static void main(String[] args) throws IOException {

		Gson gson = new Gson();
		int opcion = 0;
		int responseCode = 0;
		HttpURLConnection http = null;
		@SuppressWarnings("resource")
		Scanner tec = new Scanner(System.in);
		String token = "";

		do {
			System.out.println("****MENU PRINCIPAL****");
			System.out.println("1. Ver usuarios.");
			System.out.println("2. Ver usuario con id...");
			System.out.println("3. Insertar usuario.");
			System.out.println("4. Actualizar usuario.");
			System.out.println("5. Borrar usuario.");
			System.out.println("6. Login.");
			opcion = tec.nextInt();

			switch (opcion) {
			case 1:
				try {

					URL url = new URL("http://localhost:8080/ProyectoFinalJorgeAlbors/usuarios/");

					http = (HttpURLConnection) url.openConnection();
					http.setRequestMethod("GET");
					http.setRequestProperty("Accept", "application/json");

					BufferedReader br = new BufferedReader(new InputStreamReader(http.getInputStream()));
					StringBuilder sb = new StringBuilder();
					String respuesta;

					while ((respuesta = br.readLine()) != null) {

						sb.append(respuesta);

					}

					responseCode = http.getResponseCode();
					System.out.println("Codigo respuesta: " + responseCode);

					ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
					usuarios = gson.fromJson(sb.toString(), new TypeToken<List<Usuario>>() {
					}.getType());

					for (Usuario zones : usuarios) {
						System.out.println(zones.toString());
					}

					http.disconnect();

				} catch (Exception e) {

					e.printStackTrace();
					http.disconnect();

				}

				break;
			case 2:

				try {

					System.out.println("Introduzca el id");
					String id = tec.nextLine();

					URL url = new URL("http://localhost:8080/ProyectoFinalJorgeAlbors/usuarios/" + id);

					http = (HttpURLConnection) url.openConnection();
					http.setRequestMethod("GET");
					http.setRequestProperty("Accept", TYPE);

					BufferedReader br = new BufferedReader(new InputStreamReader(http.getInputStream()));
					StringBuilder sb = new StringBuilder();
					String respuesta;

					while ((respuesta = br.readLine()) != null) {

						sb.append(respuesta);

					}

					Usuario json_dev = gson.fromJson(sb.toString(), Usuario.class);
					System.out.println("Datos de retorno: " + json_dev.toString());

				} catch (Exception e) {

					e.printStackTrace();

				}

				break;
			case 3:
				try {

					System.out.println("*****************DATOS DEL NUEVO ALUMNO***********");
					System.out.println("Dni:");
					System.out.println("Nombre:");
					System.out.println("Telefono:");
					System.out.println("Direccin:");

					AnyadirUsuarioController post = new AnyadirUsuarioController("aa", "ads", "dsa", "dsa", 43);
					
					System.out.println(post.getUserADevolver().toString());
					
					
					
					
					
//					URL url = new URL("http://localhost:8080/ProyectoFinalJorgeAlbors/usuarios/");
//
//					http = (HttpURLConnection) url.openConnection();
//
//					http.setDoOutput(true);
//					http.setRequestMethod("POST");
//					http.setRequestProperty("Content-Type", TYPE);
//					http.setRequestProperty("Authorization", "bearer " + token);
//
//					System.out.println("Introduzca el nombre");
//					String name = tec.nextLine();
//
//					System.out.println("Introduzca el apellido");
//					String surname = tec.nextLine();
//
//					System.out.println("Introduzca la email");
//					String email = tec.nextLine();
//
//					System.out.println("Introduzca la pass");
//					String pass = tec.nextLine();
//					String passEncrip = encrytpSHA256(pass);
//
//					System.out.println("Introduzca el dinero");
//					double money = tec.nextDouble();
//
//					Usuario cli = new Usuario(name, surname, email, passEncrip, money, "USER");
//					String json = gson.toJson(cli);
//
//					OutputStream os = http.getOutputStream();
//					os.write(json.getBytes());
//					os.flush();
//
//					responseCode = http.getResponseCode();
//					System.out.println("codigo respuesta: " + responseCode);
//
//					BufferedReader br = new BufferedReader(new InputStreamReader(http.getInputStream()));
//					StringBuilder sb = new StringBuilder();
//					String respuesta;
//
//					while ((respuesta = br.readLine()) != null) {
//
//						sb.append(respuesta);
//
//					}
//
//					Usuario json_dev = gson.fromJson(sb.toString(), Usuario.class);
//					json_dev.setPassword("");
//					System.out.println("Datos de retorno: " + json_dev.toString());
//
//					http.disconnect();

				} catch (Exception e) {

					http.disconnect();
					e.getMessage();

				}

				break;

			case 4:
				try {

					System.out.println("Introduzca el id a modificar");
					String id = tec.nextLine();

					URL url = new URL("http://localhost:8080/ProyectoFinalJorgeAlbors/usuarios/" + id);

					http = (HttpURLConnection) url.openConnection();
					http.setDoOutput(true);
					http.setRequestMethod("PUT");
					http.setRequestProperty("Content_Type", TYPE);

					System.out.println("Money");
					double money = tec.nextDouble();

					Usuario usu = new Usuario(money);
					String json = gson.toJson(usu);

					OutputStream os = http.getOutputStream();
					os.write(json.getBytes());
					os.flush();

					responseCode = http.getResponseCode();
					System.out.println("codigo respuesta: " + responseCode);

					BufferedReader br = new BufferedReader(new InputStreamReader(http.getInputStream()));
					StringBuilder sb = new StringBuilder();
					String respuesta;

					while ((respuesta = br.readLine()) != null) {

						sb.append(respuesta);

					}

					// cli.setId(id);
					System.out.println("Datos de retorno: " + usu.toString());

					http.disconnect();

				} catch (Exception e) {

					e.getMessage();

				}
				break;

			case 5:
				try {

					System.out.println("Introduzca el id a eliminar");
					String id = tec.nextLine();

					URL url = new URL("http://localhost:8080/ProyectoFinalJorgeAlbors/usuarios/" + id);

					http = (HttpURLConnection) url.openConnection();
					http.setRequestMethod("DELETE");
					http.setRequestProperty("Accept", TYPE);
					// http.setRequestProperty("Authorization", "bearer " + token);

					responseCode = http.getResponseCode();
					System.out.println("Codigo respuesta: " + responseCode);

				} catch (Exception e) {

					http.disconnect();
					e.printStackTrace();

				}

				break;

			case 6:
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

				break;
			}

		} while (opcion != 7);

		System.out.println("Fin del programa");

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
