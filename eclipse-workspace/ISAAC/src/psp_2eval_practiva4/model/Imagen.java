package psp_2eval_practiva4.model;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 *
 * @author Jorge
 */

//CLASE GENERAL PARA RECUPERAR UNA IMAGEN PASDANDOLE EL URL ;)
public class Imagen {

	private ImageIcon imagenAEnviar;

	public Imagen() {
		super();
	}

	public ImageIcon imagenDevolver(String url) {
		this.imagenAEnviar = imagen(url);
		return imagenAEnviar;
	}

	private ImageIcon imagen(String url) {

		BufferedImage image;
		try {
			image = ImageIO.read(getClass().getResource(url));
			ImageIcon icon = new ImageIcon(image);
			return icon;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;

	}

	public ImageIcon getImagenAEnviar() {
		return imagenAEnviar;
	}

	public void setImagenAEnviar(ImageIcon imagenAEnviar) {
		this.imagenAEnviar = imagenAEnviar;
	}
}
