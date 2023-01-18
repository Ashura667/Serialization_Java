package mvc;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Arrays;

import gestion_images.AWT_RatingImage;

public class Controleur implements ItemListener {
	
	Modèle modl;
	
	public Controleur(Modèle m) {
		this.modl = m;
	}
	
	@Override
	public void itemStateChanged(ItemEvent e) {
		if (e.getSource() instanceof java.awt.List) {
			this.modl.sélection((Integer)e.getItem());	
		} 
		else if (e.getSource() instanceof java.awt.Checkbox) {
			int index = Arrays.binarySearch(AWT_NoteImage.libellés, e.getItem());
			this.modl.changeNote(index);
		}
	}
	
}
