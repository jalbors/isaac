package psp_2eval_practica4;

import java.net.HttpURLConnection;
import com.google.gson.Gson;
import psp_2eval_practica4.utilities.GestorHTTP;
import psp_2eval_practiva4.model.Respuesta;
import psp_2eval_practiva4.model.Usuario;

public class BuscarIdController {
	private Usuario usuario = null;

//	public BuscarIdController(int idABuscar) {
//		this.usuario = getId(idABuscar);
//	}

	public BuscarIdController() {
		super();
	}


	public Usuario devolver(int idABuscar) {
		this.usuario = getId(idABuscar);
		return this.usuario;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	private Usuario getId(int id) {
		Respuesta respuesta = null;
		Gson gson = new Gson();

		String urlConId = "http://localhost:8080/ProyectoFinalJorgeAlbors/usuarios" + "/" + id;

		respuesta = GestorHTTP.peticion(urlConId, "", "GET", "");
		if (respuesta.getCodigoPeticion() == HttpURLConnection.HTTP_OK) {
			Usuario al = gson.fromJson(respuesta.getJsonRespuesta(), Usuario.class);
			return al;

		} else {
			System.out.println(
					"Se ha producido un error obteniendo el id " + id + ": Coigo " + respuesta.getCodigoPeticion());
		}
		return usuario; 
	}

}
