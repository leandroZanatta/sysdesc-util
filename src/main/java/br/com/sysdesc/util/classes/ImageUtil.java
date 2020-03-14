package br.com.sysdesc.util.classes;

import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import br.com.lar.util.resources.Configuracoes;
import br.com.lar.util.vo.DimensionsVO;

public class ImageUtil {

	private ImageUtil() {
	}

	public static ImageIcon resize(String source, Integer width, Integer height) {

		return resize(new File(Configuracoes.FOLDER_IMAGE + File.separator + source), width, height);
	}

	public static ImageIcon resize(File source, Integer width, Integer height) {

		try {
			return resize(ImageIO.read(source), width, height);
		} catch (IOException e) {
			return null;
		}
	}

	public static ImageIcon resize(byte[] source, Integer width, Integer height) {

		try {

			return resize(ImageIO.read(new ByteArrayInputStream(source)), width, height);

		} catch (IOException e) {
			return null;
		}
	}

	public static byte[] resizeToBytes(File source, String formato, Integer width, Integer height) throws IOException {

		return resizeToBytes(resizeToImage(source, width, height), formato, width, height);
	}

	public static byte[] resizeToBytes(BufferedImage imagem, String formato, Integer width, Integer height)
			throws IOException {

		try (ByteArrayOutputStream arrayBytes = new ByteArrayOutputStream()) {

			ImageIO.write(imagem, formato, arrayBytes);

			return arrayBytes.toByteArray();
		}
	}

	public static ImageIcon resize(BufferedImage customImage, Integer width, Integer height) {

		return new ImageIcon(resizeToImage(customImage, width, height));
	}

	public static BufferedImage resizeToImage(BufferedImage customImage, Integer width, Integer height) {

		BufferedImage resizedImg = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

		Graphics2D g2 = resizedImg.createGraphics();

		g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		g2.drawImage(customImage, 0, 0, width, height, null);
		g2.dispose();

		return resizedImg;
	}

	public static BufferedImage resizeToImage(File source, Integer width, Integer height) throws IOException {

		BufferedImage resizedImg = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

		Graphics2D g2 = resizedImg.createGraphics();

		g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		g2.drawImage(new ImageIcon(source.toURI().toURL()).getImage(), 0, 0, width, height, null);
		g2.dispose();

		return resizedImg;
	}

	public static ImageIcon resize(Class<?> resource, String string) {

		return new ImageIcon(resource.getClassLoader().getResource(string));
	}

	public static DimensionsVO calculateDimension(int width, int height) {

		if (width < height) {

			return new DimensionsVO(width, width);
		}

		return new DimensionsVO(height, height);
	}

	public static BufferedImage cortar(BufferedImage imagem, int x, int y, int width, int height) {

		return imagem.getSubimage(x, y, width, height);
	}

}
