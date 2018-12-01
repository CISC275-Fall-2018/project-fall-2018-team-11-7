import java.awt.Image;
import java.awt.image.BufferedImage;

public interface GameObjects {

	BufferedImage getImage();

	int getX();

	int getY();
	
	int getWidth();
	
	int getHeight();

	void updatePosition();

}
