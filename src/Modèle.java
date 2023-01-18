package mvc;

import java.io.File;
import java.util.ArrayList;
import java.util.Observable;

public class Modèle extends Observable { 

	public ArrayList<ImageModèle> images;

	int indexImageSelectionnée = 0;

	public Modèle(String dir) {
		
		File repImages = new File(dir);
		File[] imagesListe = repImages.listFiles();
		this.images = new ArrayList<>();
		for (File file : imagesListe) {
			String nomImage = file.getName().split("\\.")[0];
			this.images.add(new ImageModèle(nomImage, "images/"+file.getName(), 0));
		}
	}

	public void sélection(int item) {
		this.indexImageSelectionnée = item;
		this.setChanged();
		this.notifyObservers(this.images.get(this.indexImageSelectionnée));
	}

	public void changeNote(int nouveauRating) {
		this.images.get(this.indexImageSelectionnée).note = nouveauRating;
		this.setChanged();
		this.notifyObservers(this.images.get(this.indexImageSelectionnée));
	}

}
