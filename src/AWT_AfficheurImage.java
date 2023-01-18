package mvc;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

import javax.imageio.ImageIO;


public class AWT_AfficheurImage extends Canvas implements Observer {

	Image img = null;

	public AWT_AfficheurImage(Modèle m) {
		super();
		this.setPreferredSize(new Dimension(640,360));
		String imgDefaut = m.images.get(0).chemin;
		try {
			img = ImageIO.read(new File(imgDefaut));
		} catch (IOException e) {
			throw new RuntimeException("L'image "+imgDefaut+" est introuvable");
		}
		
		m.addObserver(this);
	}

	public void paint(Graphics g) {
		g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), null);
	}

	@Override
	public void update(Observable o, Object arg) {
		ImageModèle im = (ImageModèle)arg;
		try {
			img = ImageIO.read(new File(im.chemin));
			repaint();
		} catch (IOException e) {
			throw new RuntimeException("L'image " + im.chemin + " est introuvable");
		}
	
	}

}
