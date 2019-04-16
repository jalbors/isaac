package psp_2eval_practica4;

import java.net.HttpURLConnection;
import java.security.MessageDigest;
import java.util.Base64;

import com.google.gson.Gson;

import psp_2eval_practiva4.model.RecivirToken;
import psp_2eval_practiva4.model.Respuesta;
import psp_2eval_practiva4.model.Usuario;
import psp_2eval_practiva4.model.UsuarioLogin;

public class AnyadirUsuarioController {

	private Usuario userADevolver = null;
	private UsuarioLogin userLog = null;

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

		// creo el objeto recivir token para poder acceder al metodo get, antes ya seteado
		RecivirToken recivir = new RecivirToken();

		// en el ultimo campo del constructor de GestorHTTP.peticion llamo al metodo gettoken2, guardado antes
		// pero peta dice que es nulo
		respuesta = GestorHTTP.peticion("http://localhost:8080/ProyectoFinalJorgeAlbors/usuarios/",
				gson.toJson(nuevoAlumno), "POST", receptor);
		//no se que hacer ya como guardarlo he echo unos cuantos metodos y no he conseguido nada
		//en ved de pasarle el token tambien probe pasandole el usuario entero y despues haciendole
		//un getUser().getToken() pero nada, sigue dando nulo
		//nose como puedo guardar el token y una vez quiera llamarlo, llamar a la clase RecivirToken y 
		//gastarlo desde ahi con su metodo get
		
		// esto siempre sale nulo
		System.out.println(recivir.getToken2());

		if (respuesta.getCodigoPeticion() == HttpURLConnection.HTTP_CREATED) {
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
	


	private void usuarioLogged() {
		UsuarioLogin userLogueado = new UsuarioLogin();
		userLog = userLogueado;

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
