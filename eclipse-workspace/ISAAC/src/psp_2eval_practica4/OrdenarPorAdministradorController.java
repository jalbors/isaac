package psp_2eval_practica4;

import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import psp_2eval_practiva4.model.GestorHTTP;
import psp_2eval_practiva4.model.Respuesta;
import psp_2eval_practiva4.model.Usuario;

public class OrdenarPorAdministradorController {

	private ArrayList<Usuario> usuariosADevolver = null;

	public OrdenarPorAdministradorController() {
		super();
	}

	public ArrayList<Usuario> admins() {
		this.usuariosADevolver = getAdmins();
		return this.usuariosADevolver;
	}

	private ArrayList<Usuario> getAdmins() {
		Respuesta respuesta = null;
		Gson gson = new Gson();
		ArrayList<Usuario> usuarios = null;

		String urlConId = "http://localhost:8080/ProyectoFinalJorgeAlbors/usuarios/administradores";

		respuesta = GestorHTTP.peticion(urlConId, "", "GET", "");
		if (respuesta.getCodigoPeticion() == HttpURLConnection.HTTP_OK) {

			usuarios = gson.fromJson(respuesta.getJsonRespuesta(), new TypeToken<List<Usuario>>() {
			}.getType());

			System.out.println(usuarios.toString());
			System.out.println(ToStringBuilder.reflectionToString(usuarios));
			return (ArrayList<Usuario>) usuarios;

		} else {
			System.out
					.println("Se ha producido un error obteniendo los admins: Coigo " + respuesta.getCodigoPeticion());
		}
		return null;
	}

	public ArrayList<Usuario> getUsuariosADevolver() {
		return usuariosADevolver;
	}

	public void setUsuariosADevolver(ArrayList<Usuario> usuariosADevolver) {
		this.usuariosADevolver = usuariosADevolver;
	}

}
