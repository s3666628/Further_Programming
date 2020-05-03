package model;

// this is part of the subject in the observer pattern

public interface ObservableCircle {
	
	void register(CircleObserver observer); 
	void remove(CircleObserver observer); 
	void updateAll(); //tell all the things that are registered that update has occured to the things they are observing

}
