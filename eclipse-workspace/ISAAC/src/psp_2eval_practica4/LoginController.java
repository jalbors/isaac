package psp_2eval_practica4;

import java.net.HttpURLConnection;
import java.security.MessageDigest;
import java.util.Base64;

import com.google.gson.Gson;

import psp_2eval_practiva4.model.RecivirToken;
import psp_2eval_practiva4.model.Respuesta;
import psp_2eval_practiva4.model.Usuario;
import psp_2eval_practiva4.model.UsuarioLogin;
import psp_2eval_practiva4.view.AnyadirUsuario;
import psp_2eval_practiva4.view.ListarUsuarios;

public class LoginController {
	public static String TOKEN = null;

	private UsuarioLogin userLoged = null;
	private Usuario user = null;

	public LoginController() {
		super();
	}

	public LoginController(String email, String password) {
		this.userLoged = postito(email, password);
	}

	private UsuarioLogin postito(String email, String password) {
		Respuesta respuesta = null;
		Gson gson = new Gson();
		String pas = encrytpSHA256(password);
		UsuarioLogin nuevoAlumno = new UsuarioLogin(email, pas);
		respuesta = GestorHTTP.peticion("http://localhost:8080/ProyectoFinalJorgeAlbors/usuarios/login",
				gson.toJson(nuevoAlumno), "POST", "");
		if (respuesta.getCodigoPeticion() == HttpURLConnection.HTTP_OK) {
			userLoged = gson.fromJson(respuesta.getJsonRespuesta(), UsuarioLogin.class);

			// esto me saca el token
			System.out.println("token 1  "+userLoged.getToken());

			// aqui el token lo guardo y lo envio a la clase recivir token
			String tokenAEnv = userLoged.getToken();
			ListarUsuarios an = new ListarUsuarios(tokenAEnv);
			an.setVisible(true);
			
			
			//RecivirToken rt = new RecivirToken(tokenAEnv);

			// esto me saca correctasmente el token del usuario osea que si se rellena y
			// devuelve el token correctamente
			//System.out.println("jorge puto amo   " + rt.getToken().toString());

			// VARIABLE ESTATICA... :(
			// TOKEN = userLoged.getToken();

			return userLoged;
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

	public Usuario getUser() {
		return user;
	}

	public void setUser(Usuario user) {
		this.user = user;
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
