package psp_2eval_practica4;

import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import psp_2eval_practiva4.model.Respuesta;
import psp_2eval_practiva4.model.Usuario;

public class Get {

	private ArrayList<Usuario> usuariosADevolver = null;

	public Get(ArrayList<Usuario> use) {
		this.usuariosADevolver = get(use);
	}

	public ArrayList<Usuario> getUserADevolver() {
		return usuariosADevolver;
	}

	public void setUserADevolver(ArrayList<Usuario> userADevolver) {
		this.usuariosADevolver = userADevolver;
	}

	private ArrayList<Usuario> get(ArrayList<Usuario> use) {
		Respuesta respuesta = null;
		Gson gson = new Gson();
		try {

			respuesta = GestorHTTP.peticion("http://localhost:8080/ProyectoFinalJorgeAlbors/usuarios/", "", "GET", "");
			if (respuesta.getCodigoPeticion() == HttpURLConnection.HTTP_OK) {
				usuariosADevolver = gson.fromJson(respuesta.getJsonRespuesta(), new TypeToken<List<Usuario>>() {
				}.getType());
				return (ArrayList<Usuario>) usuariosADevolver;

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