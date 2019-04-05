package utilidades;
import java.util.Scanner;
public class Teclado {
	
	private static Scanner teclado; 
	
	private static void iniciarTeclado () {
		
		teclado= new Scanner (System.in);
		
		
	}
	
	public static int entero() {
		boolean salida = true;
		int ret = 0;
		
		iniciarTeclado();
		
		do {
			
			try {
				
				salida = true;
				ret = teclado.nextInt();
				
			}catch (Exception a1) {
				
				salida = false;
				
			}
			teclado.nextLine();
				
			} while (salida == false);
				

		return ret;
	
	}
	
	public static double real() {
		
		double ret = 0;
		boolean salida = true;
		
		iniciarTeclado();
		
		
		do {
			
			try {
				
				salida = true;
				ret=teclado.nextDouble();
				
			} catch (Exception a1) {
				
				salida = false;
			}
			teclado.nextLine();
			}while (salida==false);

		return ret;

	}
	
	public static String cadena() {
		
		String ret ="";
		boolean salida = true;
		
		iniciarTeclado();
		
		do {
			
			try {
			salida = true;
			ret = teclado.next();
			}catch(Exception a1) {
				
				salida =false;
			}
			teclado.nextLine();
		}while (salida == false);
		
		return ret;
		
	}
	
	public static boolean booleano() {
		
		boolean ret = true;
		boolean salida = true;
		
		iniciarTeclado();
		
		do {
			
			try {
				
				salida=true;
				ret = teclado.nextBoolean();
			}catch (Exception a1) {
				
				salida = false;
			}
			teclado.nextLine();
		}while(salida == false);
		
		return ret;
		
		
	}

}
