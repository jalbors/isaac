package psp_2eval_practiva4.model;

import java.net.HttpURLConnection;

public class Respuesta {
	private int codigoPeticion;
	private String jsonRespuesta;
	
	public Respuesta() {
		this.codigoPeticion = HttpURLConnection.HTTP_INTERNAL_ERROR;
		this.jsonRespuesta = "";
	}
	
	public Respuesta(int codigoRespuesta) {
		this.codigoPeticion = codigoRespuesta;
		this.jsonRespuesta = "";
	}
	
	public Respuesta(int codigoRespuesta, String jsonRespuesta) {
		this.codigoPeticion = codigoRespuesta;
		this.jsonRespuesta = jsonRespuesta;
	}
	
	public int getCodigoPeticion() {
		return codigoPeticion;
	}
	public void setCodigoPeticion(int codigoPeticion) {
		this.codigoPeticion = codigoPeticion;
	}
	
	public String getJsonRespuesta() {
		return jsonRespuesta;
	}
	public void setJsonRespuesta(String jsonRespuesta) {
		this.jsonRespuesta = jsonRespuesta;
	}
}
