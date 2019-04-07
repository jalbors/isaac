package psp_2eval_practica4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import psp_2eval_practiva4.model.Respuesta;
import psp_2eval_practiva4.model.Usuario;

public class Get {

	public Get() {
		get();
	}

	public ArrayList<Usuario> get() {
		Respuesta respuesta = null;
		Gson gson = new Gson();
		try {

//			Gson gson = new Gson();
//			int responseCode = 0;
//			HttpURLConnection http = null;
//			URL url = new URL("http://localhost:8080/ProyectoFinalJorgeAlbors/usuarios/");
//
//			http = (HttpURLConnection) url.openConnection();
//			http.setRequestMethod("GET");
//			http.setRequestProperty("Accept", "application/json");
//
//			BufferedReader br = new BufferedReader(new InputStreamReader(http.getInputStream()));
//			StringBuilder sb = new StringBuilder();
//			String respuesta;
//
//			while ((respuesta = br.readLine()) != null) {
//
//				sb.append(respuesta);
//
//			}
//
//			responseCode = http.getResponseCode();
//			System.out.println("Codigo respuesta: " + responseCode);
//
//			ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
//			usuarios = gson.fromJson(sb.toString(), new TypeToken<List<Usuario>>() {
//			}.getType());
//			http.disconnect();
//			return usuarios;

			respuesta = GestorHTTP.peticion("http://localhost:8080/ProyectoFinalJorgeAlbors/usuarios/", "", "GET", "");
			if (respuesta.getCodigoPeticion() == HttpURLConnection.HTTP_OK) {
				List<Usuario> alumnos = gson.fromJson(respuesta.getJsonRespuesta(), new TypeToken<List<Usuario>>() {
				}.getType());
				return (ArrayList<Usuario>) alumnos;

			} else {
				System.out.println(
						"Se ha producido un error obteniendo los alumnos: Codigo " + respuesta.getCodigoPeticion());
			}

		} catch (Exception e) {

			e.printStackTrace();
			return null;

		}
		return null;

	}
}