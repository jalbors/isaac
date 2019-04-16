package psp_2eval_practica4;

import java.net.HttpURLConnection;

import com.google.gson.Gson;

import psp_2eval_practiva4.model.RecivirToken;
import psp_2eval_practiva4.model.Respuesta;
import psp_2eval_practiva4.model.UsuarioLogin;

public class Principal {

	public static UsuarioLogin main(String[] args) {
		Respuesta respuesta = null;
		Gson gson = new Gson();
		UsuarioLogin userLoged = null;

		UsuarioLogin nuevoAlumno = new UsuarioLogin("xixo@xixo.com", "tAeM0Po7/UU+rgIw0rUuzs/7vu4FwZ5iTAeQwnlmTdU=");

		respuesta = GestorHTTP.peticion("http://localhost:8080/ProyectoFinalJorgeAlbors/usuarios/login",
				gson.toJson(nuevoAlumno), "POST", "");

		if (respuesta.getCodigoPeticion() == HttpURLConnection.HTTP_OK) {
			userLoged = gson.fromJson(respuesta.getJsonRespuesta(), UsuarioLogin.class);

			// este token nose como sacarlo sin una variabler estatica
			System.out.println(userLoged.getToken());
			userLoged.setToken(userLoged.getToken());
			
			
			//aqui me llega el token y lo guardo y lo envio a la clase recivir token
			String tokenAEnv = userLoged.getToken();
			RecivirToken rt = new RecivirToken(tokenAEnv);
			
			
			//VARIABLE ESTATICA... :(
			//TOKEN = userLoged.getToken();

			return userLoged;
		} else {
			System.out.println("Se ha producido un error: Codigo " + respuesta.getCodigoPeticion());
		}
		return nuevoAlumno;
	}

}
