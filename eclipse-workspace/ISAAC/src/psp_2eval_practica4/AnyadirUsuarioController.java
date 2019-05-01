package psp_2eval_practica4;

import java.net.HttpURLConnection;
import java.security.MessageDigest;
import java.util.Base64;
import com.google.gson.Gson;
import psp_2eval_practica4.utilities.GestorHTTP;
import psp_2eval_practiva4.model.Respuesta;
import psp_2eval_practiva4.model.Usuario;

public class AnyadirUsuarioController {

	private Usuario userADevolver = null;

	public AnyadirUsuarioController() {
		super();
	}
	
	//llamo al metodo que devuelve userADevolver relleno
	public Usuario userFinalAnyadido(String nombre, String apellido, String email, String contra, double dinero, String receptor) {
		this.userADevolver = postito(nombre, apellido, email, contra, dinero, receptor);
		return this.userADevolver;
	}

	//receptor es el token
	private Usuario postito(String nombre, String apellido, String email, String contra, double dinero, String receptor) {
		Respuesta respuesta = null;
		Gson gson = new Gson();
		//le envio la contra encriptada para guardarla guardada
		String pas = encrytpSHA256(contra);
		
		//creo el usuario
		Usuario nuevoAlumno = new Usuario(nombre, apellido, email, pas, dinero, "USER");

		System.out.println("receptor fginal:  "+ receptor);
		
		//le paso el token aqui y le envio el json a la api
		respuesta = GestorHTTP.peticion("http://localhost:8080/ProyectoFinalJorgeAlbors/usuarios/",
				gson.toJson(nuevoAlumno), "POST", receptor);
		
		//201
		if (respuesta.getCodigoPeticion() == HttpURLConnection.HTTP_CREATED) {
			
			//devuelvo el usuario que me llega de la api con los datos insertados en la BD
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
	
	//metodo para encriptar la contrasenya
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
