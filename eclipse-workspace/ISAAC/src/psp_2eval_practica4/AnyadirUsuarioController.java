package psp_2eval_practica4;

import java.net.HttpURLConnection;
import java.security.MessageDigest;
import java.util.Base64;

import com.google.gson.Gson;

import psp_2eval_practiva4.model.Respuesta;
import psp_2eval_practiva4.model.Usuario;

public class AnyadirUsuarioController {

	private Usuario userADevolver = null;

	public AnyadirUsuarioController(String nombre, String apellido, String email, String contra, double dinero, String receptor) {
		//usuarioLogged();
		this.userADevolver = postito(nombre, apellido, email, contra, dinero, receptor);

	}

	public AnyadirUsuarioController() {
		super();
	}

	//el metodo funciona hasta que le paso un token, ahi explota
	//campos que recive cuando el usuario crea uno nuevo y devuelve un usuario
	private Usuario postito(String nombre, String apellido, String email, String contra, double dinero, String receptor) {
		Respuesta respuesta = null;
		Gson gson = new Gson();
		String pas = encrytpSHA256(contra);
		Usuario nuevoAlumno = new Usuario(nombre, apellido, email, pas, dinero, "USER");

		System.out.println("receptor fginal:  "+ receptor);
		respuesta = GestorHTTP.peticion("http://localhost:8080/ProyectoFinalJorgeAlbors/usuarios/",
				gson.toJson(nuevoAlumno), "POST", receptor);
		
		if (respuesta.getCodigoPeticion() == HttpURLConnection.HTTP_CREATED) {
			
			System.out.println("3   Aqui entra?");
			userADevolver = gson.fromJson(respuesta.getJsonRespuesta(), Usuario.class);
			return userADevolver;
		} else {
			System.out.println(
					"Se ha producido un error creando el nuevo alumno: Codigo " + respuesta.getCodigoPeticion());
		}
		return nuevoAlumno;

	}

	public Usuario getUserADevolver() {
		return userADevolver;
	}

	public void setUserADevolver(Usuario userADevolver) {
		this.userADevolver = userADevolver;
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
