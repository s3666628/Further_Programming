package model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class CirclesModel implements Iterable<SingleCircleModel> {
	
	public static final String SELECTED_COLOR_CHANGE = "Selected Color Changed";
	
	private final PropertyChangeSupport pcs = new PropertyChangeSupport(this);
	private Collection<SingleCircleModel> allCircles;
	private CircleColor selectedColor;
	
	
	public CirclesModel(int numberOfCircles) {
		super();
		
		allCircles = new ArrayList<>(numberOfCircles); 
		selectedColor = CircleColor.ORANGE; //default colour 
		
		int counter = 0;
		while (counter < numberOfCircles) {
			allCircles.add(new SingleCircleModel(CircleColor.getRandom()));	
			
			
			
			counter+=1;
		}
	}

	public CircleColor getSelectedColor() {
		return selectedColor;
	}

	public void setSelectedColor(CircleColor selectedColor) {
		CircleColor oldValue = this.selectedColor;
		
		this.selectedColor = selectedColor;
		System.out.println("model selected color =" + selectedColor);
		
		
		this.pcs.firePropertyChange(SELECTED_COLOR_CHANGE, oldValue, selectedColor);
	}

	@Override
	// allows us to iterate over the collection of all circles
	public Iterator<SingleCircleModel> iterator() {
		// TODO Auto-generated method stub
		return allCircles.iterator();
	}
	


    public void addPropertyChangeListener(PropertyChangeListener listener) {
        this.pcs.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        this.pcs.removePropertyChangeListener(listener);
    }

	

}
