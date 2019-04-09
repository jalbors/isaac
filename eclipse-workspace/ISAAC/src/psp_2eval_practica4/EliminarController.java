package psp_2eval_practica4;

import java.net.HttpURLConnection;

import psp_2eval_practiva4.model.Respuesta;
import psp_2eval_practiva4.model.Usuario;

public class EliminarController {

	private Usuario usuario = null;

	public EliminarController(int idAEliminar) {
		this.usuario = eliminar(idAEliminar);
	}

	public EliminarController() {
		super();
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	private Usuario eliminar(int idAEliminar) {
		Respuesta respuesta = null;

		String urlConId = "http://localhost:8080/ProyectoFinalJorgeAlbors/usuarios" + "/" + idAEliminar;
		respuesta = GestorHTTP.peticion(urlConId, "", "DELETE", "");
		if (respuesta.getCodigoPeticion() == HttpURLConnection.HTTP_OK) {

			System.out.println("user eliminado");

			return null;

		}

		return null;

	}

}
