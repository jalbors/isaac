package psp_2eval_practica4;

import java.net.HttpURLConnection;
import com.google.gson.Gson;
import psp_2eval_practica4.utilities.GestorHTTP;
import psp_2eval_practiva4.model.Respuesta;
import psp_2eval_practiva4.model.Usuario;

public class EditarController {

	private Usuario usuario = null;
	private Usuario usuarioDevuelto = null;

	public EditarController() {
		super();
	}

	public Usuario devolver(int idABuscar) {
		this.usuario = getId(idABuscar);
		return this.usuario;
	}

	public Usuario editedUsuario(int id, String nombre, String apellido, String email, String contra, double dinero) {
		this.usuarioDevuelto = edit(id, nombre, apellido, email, contra, dinero);
		return this.usuarioDevuelto;
	}

	private Usuario edit(int id, String nombre, String apellido, String email, String contra, double dinero) {
		//int dineroFinal = Integer.parseInt(dinero);
		Respuesta respuesta = null;
		Gson gson = new Gson();
		Usuario us = new Usuario(nombre, apellido, email, contra, dinero);

		String urlConId = "http://localhost:8080/ProyectoFinalJorgeAlbors/usuarios" + "/" + id;

		respuesta = GestorHTTP.peticion(urlConId, gson.toJson(us), "PUT", "");

		if (respuesta.getCodigoPeticion() == HttpURLConnection.HTTP_CREATED) {
			System.out.println("Usuario con id " + id + " actualizado");
		} else {
			System.out.println(
					"Se ha producido un error actualizando  id " + id + ": Codigo " + respuesta.getCodigoPeticion());
		}

		return null;
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
		return null;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Usuario getUsuarioDevuelto() {
		return usuarioDevuelto;
	}

	public void setUsuarioDevuelto(Usuario usuarioDevuelto) {
		this.usuarioDevuelto = usuarioDevuelto;
	}

}
