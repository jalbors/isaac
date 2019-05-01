package psp_2eval_practica4.utilities;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

import psp_2eval_practiva4.view.Login;

public class IconoAplicacion{

	public static BufferedImage icono() {
		try {
			InputStream imgStream = Login.class.getResourceAsStream("/resources/images/emple.png");
			BufferedImage bfImage = ImageIO.read(imgStream);
			return bfImage;
		} catch (IOException e1) {
			System.out.println("Error obteniendo el icono de la app "+ e1.getMessage());
		}
		return null;
	}

}
