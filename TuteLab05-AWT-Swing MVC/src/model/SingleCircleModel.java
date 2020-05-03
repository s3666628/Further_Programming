package model;

import java.util.ArrayList;
import java.util.Collection;

// Concrete Subject - from the observer pattern
// a Cicle has a state which one of five colors
// get State and set State

public class SingleCircleModel implements ObservableCircle {

	private CircleColor color;
	private Collection<CircleObserver> observers; // stores all of the different observers

	public SingleCircleModel(CircleColor color) {
		super();
		this.color = color;
		this.observers = new ArrayList<CircleObserver>();
	}

	public CircleColor getColor() {
		return color;
	}

	public void setColor(CircleColor color) {
		this.color = color;
		// tell everyone that the color has been updated
		updateAll();
	}

	@Override
	public void register(CircleObserver observer) {

		// add observer to the collection
		observers.add(observer);

	}

	@Override
	public void remove(CircleObserver observer) {
//		// remove an observer from the collection
		observers.remove(observer);

	}

	@Override
	public void updateAll() {
//		// updates
		for (CircleObserver observer : observers) {
			observer.updatesColor(color);
		}

	}

}
