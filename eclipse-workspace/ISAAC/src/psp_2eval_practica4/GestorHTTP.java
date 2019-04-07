package psp_2eval_practica4;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

import psp_2eval_practiva4.model.Respuesta;


public class GestorHTTP {
    

    public final static int READ_TIMEOUT = 10000; // milliseconds
    public final static int CONNECT_TIMEOUT = 15000; // milliseconds
    public final static String CONTENT_TYPE_JSON = "application/json";

    public static Respuesta peticion(String uri, String json, String metodo, String token){
    	Respuesta respuesta = new Respuesta();

        try{
        	//Se crea la conexion y se asignan tiempos de timeout
            URL url = new URL(uri);
            HttpURLConnection conexion = (HttpURLConnection) url.openConnection();
            conexion.setReadTimeout(READ_TIMEOUT);
            conexion.setConnectTimeout(CONNECT_TIMEOUT);

            //Anyadimos token en caso de que se envia
            if(!token.isEmpty()) {
                conexion.setRequestProperty("Authorization", "bearer " + token);
            }
            
            //Se anyade el mwtodo a usar (GET, POST, PUT, DELETE) y se configura para recibir informacion de respuesta
            conexion.setRequestMethod(metodo);
            
            //En caso de POST y PUT se configura para poder enviar información, con el tamanyo a enviar.
            if(metodo.equals("POST") || metodo.equals("PUT")){
            	conexion.setRequestProperty("Content-Type", CONTENT_TYPE_JSON);
                conexion.setDoOutput(true);
                conexion.setFixedLengthStreamingMode(json.getBytes().length);
            }else{
            	//GETs o DELETE
            	conexion.setRequestProperty("Accept", CONTENT_TYPE_JSON);
            }


            //Se abre la conexion
            conexion.connect();

            //En caso de POST y PUT se envia la informacion a guardar o actualizar
            if(metodo.equals("POST") || metodo.equals("PUT")){
                OutputStream os = new BufferedOutputStream(conexion.getOutputStream());
                os.write(json.getBytes());
                os.flush();
            }

            //Se obtiene el codigo de respueta
            int codigoPeticion = conexion.getResponseCode();
            respuesta.setCodigoPeticion(codigoPeticion);
            
            if(codigoPeticion == HttpURLConnection.HTTP_OK || codigoPeticion == HttpURLConnection.HTTP_CREATED){
	            //Se obtiene informacion de respuesta
	            respuesta.setJsonRespuesta(getStringFromInputStream(conexion.getInputStream()));
            }
            
            //Se acaba la peticoon
            conexion.disconnect();
        }
        catch (MalformedURLException e) {
        	respuesta.setCodigoPeticion(HttpURLConnection.HTTP_BAD_REQUEST);
            System.out.println("Error al crear la URL: " + uri + ". \nMensaje de error: " + e.getMessage());
            e.printStackTrace();
        } catch (ProtocolException e) {
        	System.out.println("Error de protocolo: " + e.getMessage());
            e.printStackTrace();
        } catch (IOException e) {
        	System.out.println("Error de E/S: " + e.getMessage());
            e.printStackTrace();
        }
        
        
        return respuesta;
    }



    // convert InputStream to String
    private static String getStringFromInputStream(InputStream is) {

        BufferedReader br = null;
        StringBuilder sb = new StringBuilder();

        String line;
        try {

            br = new BufferedReader(new InputStreamReader(is));
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }

        } catch (IOException e) {
            System.out.println("Error al convertir la respuesta a string");
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return sb.toString();

    }
}
