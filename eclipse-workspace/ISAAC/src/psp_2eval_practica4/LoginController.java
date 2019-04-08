package psp_2eval_practica4;

import java.net.HttpURLConnection;
import java.security.MessageDigest;
import java.util.Base64;

import com.google.gson.Gson;

import psp_2eval_practiva4.model.Respuesta;
import psp_2eval_practiva4.model.Usuario;
import psp_2eval_practiva4.model.UsuarioLogin;

public class LoginController {

	private UsuarioLogin userLoged = null;

	public LoginController(String email, String password) {
		this.userLoged = postito(email, password);
	}
	
	

	public UsuarioLogin getUserLoged() {
		return userLoged;
	}

	public void setUserLoged(UsuarioLogin userLoged) {
		this.userLoged = userLoged;
	}

	private UsuarioLogin postito(String email, String password) {
		// TODO Auto-generated method stub
		Respuesta respuesta = null;
		Gson gson = new Gson();
		String pas = encrytpSHA256(password);
		
		//saca un 200 pero da fallo
		UsuarioLogin nuevoAlumno = new UsuarioLogin(email, pas);

		respuesta = GestorHTTP.peticion("http://localhost:8080/ProyectoFinalJorgeAlbors/usuarios/login",
				gson.toJson(nuevoAlumno), "POST", "");

		if (respuesta.getCodigoPeticion() == 200) {
			userLoged = gson.fromJson(respuesta.getJsonRespuesta(), UsuarioLogin.class);
			
			//este token nose como sacarlo sin una variabler estatica
			System.out.println(userLoged.getToken());
			
			
			return userLoged;
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
