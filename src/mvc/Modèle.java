package mvc;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Observable;

public class Modèle extends Observable { 

	public ArrayList<ImageModèle> images;

	int indexImageSelectionnée = 0;

	public Modèle() {
		String dir;

		try (XMLDecoder decoder=new XMLDecoder(new BufferedInputStream(new FileInputStream("images.xml")))) {

			  this.images = (ArrayList) decoder.readObject();
			 
			} catch (IOException c) {
			  dir = "images";
			  System.out.println("coucou");
			  File repImages = new File(dir);
				File[] imagesListe = repImages.listFiles();
				this.images = new ArrayList<>();
				for (File file : imagesListe) {
					String nomImage = file.getName().split("\\.")[0];
					this.images.add(new ImageModèle(nomImage, "images/"+file.getName(), 0));
				}
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
	public void enregistrer() {
		try {
	        XMLEncoder encoder = new XMLEncoder(new FileOutputStream("images.xml"));
			
			encoder.writeObject(this.images);
			encoder.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

	public ArrayList<ImageModèle> getImages() {
		return images;
	}

	public void setImages(ArrayList<ImageModèle> images) {
		this.images = images;
	}

	public int getIndexImageSelectionnée() {
		return indexImageSelectionnée;
	}

	public void setIndexImageSelectionnée(int indexImageSelectionnée) {
		this.indexImageSelectionnée = indexImageSelectionnée;
	}

}
