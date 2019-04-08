package psp_2eval_practica4;

import java.net.HttpURLConnection;
import java.security.MessageDigest;
import java.util.Base64;

import com.google.gson.Gson;

import psp_2eval_practiva4.model.Respuesta;
import psp_2eval_practiva4.model.Usuario;
import psp_2eval_practiva4.model.UsuarioLogin;

public class AnyadirUsuarioController {

	private Usuario userADevolver = null;

	public AnyadirUsuarioController(String nombre, String apellido, String email, String contra, double dinero) {
		this.userADevolver = postito(nombre, apellido, email, contra, dinero);
	}

	public Usuario getUserADevolver() {
		return userADevolver;
	}

	public void setUserADevolver(Usuario userADevolver) {
		this.userADevolver = userADevolver;
	}

	private Usuario postito(String nombre, String apellido, String email, String contra, double dinero) {
		// TODO Auto-generated method stub
		Respuesta respuesta = null;
		Gson gson = new Gson();
		String pas = encrytpSHA256(contra);
		Usuario nuevoAlumno = new Usuario(nombre, apellido, email, pas, dinero, "USER");
		UsuarioLogin userL = new UsuarioLogin();

		respuesta = GestorHTTP.peticion("http://localhost:8080/ProyectoFinalJorgeAlbors/usuarios/",
				gson.toJson(nuevoAlumno), "POST", userL.getToken());
		
		if (respuesta.getCodigoPeticion() == HttpURLConnection.HTTP_CREATED) {
			userADevolver = gson.fromJson(respuesta.getJsonRespuesta(), Usuario.class);
			return userADevolver;
		} else {
			System.out.println(
					"Se ha producido un error creando el nuevo alumno: Codigo " + respuesta.getCodigoPeticion());
		}
		return nuevoAlumno;

	}

	public static String encrytpSHA256(String mensaje) {
		MessageDigest md;

		try {
			md = MessageDigest.getInstance("SHA-256");
			byte dataBytes[] = mensaje.getBytes();
			md.update(dataBytes);
			byte resumen[] = md.digest();
			return new String(Base64.getEncoder().encode(resumen));

		} catch (Exception e) {
			return e.getMessage();

		}

	}

}
