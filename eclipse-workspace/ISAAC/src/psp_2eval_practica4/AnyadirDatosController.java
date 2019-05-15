package psp_2eval_practica4;

import java.net.HttpURLConnection;

import com.google.gson.Gson;

import psp_2eval_practica4.utilities.GestorHTTP;
import psp_2eval_practiva4.model.Respuesta;
import psp_2eval_practiva4.model.Usuario;

public class AnyadirDatosController {
	private Usuario usuario = null;
	private Integer usuarioDevuelto = null;

	public AnyadirDatosController() {
		super();
	}

	public int editedUsuario(String id, String adress, String phone, String yearsWork, String description) {
		this.usuarioDevuelto = edit(id, adress, phone, yearsWork, description);
		return this.usuarioDevuelto;
	}

	private int edit(String id, String adress, String phone, String yearsWork, String description) {
		Respuesta respuesta = null;
		Gson gson = new Gson();
		System.out.println(id+adress+phone+yearsWork+description);
		int idAEnc = Integer.parseInt(id);
		Usuario us = new Usuario(idAEnc,adress, phone, yearsWork, description);

		String urlConId = "http://localhost:8080/ProyectoFinalJorgeAlbors/usuarios/"+idAEnc+"/anydir";

		respuesta = GestorHTTP.peticion(urlConId, gson.toJson(us), "PUT", "");

		if (respuesta.getCodigoPeticion() == HttpURLConnection.HTTP_CREATED) {
			System.out.println("Usuario con id " + id + " actualizado");
			return 1;
		} else {

			System.out.println("Se ha producido un error actualizando  id " + id + ": Codigo " + respuesta.getCodigoPeticion());
			return 2;
		}

	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Integer getUsuarioDevuelto() {
		return usuarioDevuelto;
	}

	public void setUsuarioDevuelto(Integer usuarioDevuelto) {
		this.usuarioDevuelto = usuarioDevuelto;
	}

}
