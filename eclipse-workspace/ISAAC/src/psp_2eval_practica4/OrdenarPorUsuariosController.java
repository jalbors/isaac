package psp_2eval_practica4;

import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import psp_2eval_practiva4.model.GestorHTTP;
import psp_2eval_practiva4.model.Respuesta;
import psp_2eval_practiva4.model.Usuario;

public class OrdenarPorUsuariosController {

	private ArrayList<Usuario> usuariosADevolver = null;

	public OrdenarPorUsuariosController() {
		super();
	}

	public ArrayList<Usuario> usuariosFinales() {
		this.usuariosADevolver = get();
		return this.usuariosADevolver;
	}

	private ArrayList<Usuario> get() {
		Respuesta respuesta = null;
		Gson gson = new Gson();
		ArrayList<Usuario> usuarios = null;
		try {

			respuesta = GestorHTTP.peticion("http://localhost:8080/ProyectoFinalJorgeAlbors/usuarios/usuariosNormales", "", "GET", "");
			if (respuesta.getCodigoPeticion() == HttpURLConnection.HTTP_OK) {

				usuarios = gson.fromJson(respuesta.getJsonRespuesta(), new TypeToken<List<Usuario>>() {
				}.getType());

				System.out.println(usuarios.toString());
				return (ArrayList<Usuario>) usuarios;

			} else {
				System.out.println("Se ha producido un error: Codigo " + respuesta.getCodigoPeticion());
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
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
