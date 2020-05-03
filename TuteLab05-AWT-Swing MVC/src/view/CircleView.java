package view;

import javax.swing.JLabel;

import model.SingleCircleModel;
import model.CircleColor;
import model.CircleObserver;
import model.ObservableCircle;

@SuppressWarnings("serial")
public class CircleView extends JLabel implements CircleObserver {
	
//	private CircleColor color; do not need this

	public CircleView(SingleCircleModel singleCircleModel) {
		// TODO Auto-generated constructor stub
		super(singleCircleModel.getColor().getImageIcon());
//		color = singleCircleModel.getColor(); do not need this
		singleCircleModel.register(this); // register 
	}

	@Override
	public void updatesColor(CircleColor color) {
		// TODO Auto-generated method stub
		setIcon(color.getImageIcon());
		
		
	}

}
