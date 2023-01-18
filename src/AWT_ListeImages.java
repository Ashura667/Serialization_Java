package mvc;

import java.awt.List;
import java.awt.Panel;
import java.awt.event.ItemListener;
import java.util.Observable;
import java.util.Observer;

public class AWT_ListeImages extends Panel implements Observer {
	
	List listeImages;
	Modèle modl;
	
	public AWT_ListeImages(ItemListener l, Modèle m) {
		
		this.modl = m;
		listeImages = new List(20);
		for (int i=0; i<m.images.size(); i++) {
			listeImages.add(m.images.get(i).toString());
		}
		this.add(listeImages);
		listeImages.addItemListener(l);
		listeImages.select(0);
		
		m.addObserver(this);
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		int i = this.listeImages.getSelectedIndex();
		this.listeImages.replaceItem(arg1.toString(), i);
		this.listeImages.select(i);
	}
}
