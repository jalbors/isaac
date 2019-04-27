package psp_2eval_practica4;

import java.net.HttpURLConnection;
import java.security.MessageDigest;
import java.util.Base64;

import com.google.gson.Gson;

import psp_2eval_practiva4.model.GestorHTTP;
import psp_2eval_practiva4.model.Respuesta;
import psp_2eval_practiva4.model.UsuarioLogin;

public class LoginController {

	private UsuarioLogin userLoged = null;

	public LoginController() {
		super();
	}
	
	// desde la clase llamo a esta clase publica que devuelve el resultado del
	// usuario logged
	public UsuarioLogin prueba(String email, String password) {
		this.userLoged = postito(email, password);
		return this.userLoged;

	}

	private UsuarioLogin postito(String email, String password) {
		Respuesta respuesta = null;
		Gson gson = new Gson();
		//encrpto la pass para compararla
		String pas = encrytpSHA256(password);
		UsuarioLogin user = null;
		// creo un usuario con los datos recividos del usuario
		UsuarioLogin nuevoAlumno = new UsuarioLogin(email, pas);

		// genero el http
		respuesta = GestorHTTP.peticion("http://localhost:8080/ProyectoFinalJorgeAlbors/usuarios/login",
				gson.toJson(nuevoAlumno), "POST", "");

		// getJsonRespuesta() -> 200
		if (respuesta.getCodigoPeticion() == HttpURLConnection.HTTP_OK) {

			// genero el usuario
			user = gson.fromJson(respuesta.getJsonRespuesta(), UsuarioLogin.class);
			System.out.println("token 1  " + user.getToken());

			// devuelvo el usuario generado
			return user;

		} else {
			System.out.println("Se ha producido un error: Codigo " + respuesta.getCodigoPeticion());
		}
		return nuevoAlumno;

	}

	public UsuarioLogin getUserLoged() {
		return userLoged;
	}

	public void setUserLoged(UsuarioLogin userLoged) {
		this.userLoged = userLoged;
	}

	// metodo para encriptar la contrasenya - SHA-256
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
