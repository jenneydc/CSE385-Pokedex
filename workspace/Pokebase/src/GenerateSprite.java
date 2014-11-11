// Author: Kyle Busdieker
// Purpose: Convert a byte[] of a pokemon's sprite to an image

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

import javax.imageio.ImageIO;



public class GenerateSprite {
	
	BufferedImage sprite = null;
	InputStream is = null;
	
	// Converts a pokemon's sprite, stored as a byte[], into an image
	public BufferedImage convert(byte[] spriteArray) throws Exception {
		
		is = new ByteArrayInputStream(spriteArray);
		sprite = ImageIO.read(is);
		
		return sprite;
	}
}