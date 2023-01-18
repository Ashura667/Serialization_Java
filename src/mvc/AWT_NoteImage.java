package mvc;

import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.FlowLayout;
import java.awt.Panel;
import java.awt.event.ItemListener;
import java.util.Observable;
import java.util.Observer;

public class AWT_NoteImage extends Panel implements Observer {
	
	Checkbox[] étoiles = new Checkbox[5];
	
	public static String[] libellés = {"1 étoile", "2 étoiles", "3 étoiles", "4 étoiles", "5 étoiles"};
	
	public AWT_NoteImage(ItemListener l, Modèle m) {
		
		this.setLayout(new FlowLayout());
		
		CheckboxGroup cg=new CheckboxGroup();
		for (int i=0; i<5; i++) {
			this.étoiles[i] = new Checkbox(libellés[i], false, cg);
			this.étoiles[i].addItemListener(l);
			this.add(this.étoiles[i]);
		}
		m.addObserver(this);
	}
	
	@Override
	public void update(Observable o, Object arg) {
		ImageModèle im = (ImageModèle)arg;
		this.étoiles[(int)im.note].setState(true);
	}
}
