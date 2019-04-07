package psp_2eval_practica4;

import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import psp_2eval_practiva4.model.Respuesta;
import psp_2eval_practiva4.model.Usuario;

public class Get {

	ArrayList<Usuario> userADevolver = null;

	public Get(ArrayList<Usuario> use) {
		this.userADevolver = get(use);
	}

	public ArrayList<Usuario> getUserADevolver() {
		return userADevolver;
	}

	public void setUserADevolver(ArrayList<Usuario> userADevolver) {
		this.userADevolver = userADevolver;
	}

	private ArrayList<Usuario> get(ArrayList<Usuario> use) {
		Respuesta respuesta = null;
		Gson gson = new Gson();
		try {

			respuesta = GestorHTTP.peticion("http://localhost:8080/ProyectoFinalJorgeAlbors/usuarios/", "", "GET", "");
			if (respuesta.getCodigoPeticion() == HttpURLConnection.HTTP_OK) {
				userADevolver = gson.fromJson(respuesta.getJsonRespuesta(), new TypeToken<List<Usuario>>() {
				}.getType());
				return (ArrayList<Usuario>) userADevolver;

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