package HjelpeKlasser;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;

public class image {
	
	private String[] categories;
	private String thumb;
	private String medium;
	private String large;
	private String xlarge;
	public String[] getCategories() {
		return categories;
	}
	public void setCategories(String[] categories) {
		this.categories = categories;
	}
	public String getThumb() {
		return thumb;
	}
	public void setThumb(String thumb) {
		this.thumb = thumb;
	}
	public String getMedium() {
		return medium;
	}
	public void setMedium(String medium) {
		this.medium = medium;
	}

	public String getLarge() {
		return large;
	}
	public void setLarge(String large) {
		this.large = large;
	}
	public String getXlarge() {
		return xlarge;
	}
	public void setXlarge(String xlarge) {
		this.xlarge = xlarge;
	}
	
	public String toString() {
		String str = "";
		for (int i = 0; i<categories.length; i++) {
			str += categories[i];
		}
		str += thumb + "," + medium + "," + large + "," + xlarge;
		return str;
	}
	
	

	public static Image createImageIcon(String imageURL) {
		try {
			URL url = new URL(imageURL);
			BufferedImage c = ImageIO.read(url);

			return SwingFXUtils.toFXImage(c, null);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	
	
}

