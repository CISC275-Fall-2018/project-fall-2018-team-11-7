package GameObjects;
import java.awt.Image;
import java.awt.image.BufferedImage;

public interface GameObjects {

	boolean drag = false;

	BufferedImage getImage();

	int getX();

	int getY();
	
	int getWidth();
	
	int getHeight();

	void updatePosition();

	void setX(int x);

	void setY(int y);

	boolean getDrag();

	void setDrag(boolean b);

	boolean getOrigin();

	void setOrigin(boolean b);

	void updatePosition(int x, int y);

}
