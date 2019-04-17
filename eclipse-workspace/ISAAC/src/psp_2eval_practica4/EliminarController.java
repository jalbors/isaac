package psp_2eval_practica4;

import java.net.HttpURLConnection;

import psp_2eval_practiva4.model.Respuesta;
import psp_2eval_practiva4.model.Usuario;

public class EliminarController {

	private Usuario usuario = null;

	public EliminarController(int idAEliminar, String token) {
		this.usuario = eliminar(idAEliminar, token);
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

	private Usuario eliminar(int idAEliminar, String tok) {
		Respuesta respuesta = null;

		String urlConId = "http://localhost:8080/ProyectoFinalJorgeAlbors/usuarios" + "/" + idAEliminar;
		respuesta = GestorHTTP.peticion(urlConId, "", "DELETE", tok);
		if (respuesta.getCodigoPeticion() == HttpURLConnection.HTTP_OK) {

			System.out.println("user con id: "+ idAEliminar +" eliminado");

			return null;

		}

		return null;

	}

}
