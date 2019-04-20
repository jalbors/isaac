package psp_2eval_practica4;

import java.net.HttpURLConnection;

import psp_2eval_practiva4.model.Respuesta;
import psp_2eval_practiva4.view.Alerta;

public class EliminarController {

	public EliminarController() {
		super();
	}

	public void eli(int idAEliminar, String token) {
		eliminar(idAEliminar, token);
	}

	private void eliminar(int idAEliminar, String tok) {
		Respuesta respuesta = null;

		String urlConId = "http://localhost:8080/ProyectoFinalJorgeAlbors/usuarios" + "/" + idAEliminar;
		respuesta = GestorHTTP.peticion(urlConId, "", "DELETE", tok);
		if (respuesta.getCodigoPeticion() == HttpURLConnection.HTTP_OK) {

			System.out.println("user con id: " + idAEliminar + " eliminado");

		}

	}

}
