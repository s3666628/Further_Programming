package view;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.util.Collection;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import model.GameEngineImpl;
import model.Player;

@SuppressWarnings("serial")

public class AllPlayersTable extends JFrame implements TableModel{

	private JButton close = new JButton("Close");
	

	// example based on code from here
	// https://www.javatpoint.com/java-jtable
	
	
	public void updateAllPlayersTable(GameEngineImpl theModel) {
		
		Collection<Player> allPlayers = theModel.getAllPlayers();
		String []  tableHeaders = { "Player ID", "Player Name", "Player Points" };
		String[][] playerDetails = new String[allPlayers.size()][tableHeaders.length];
		int rowCounter = 0;
		for (Player player : allPlayers) {
			playerDetails[rowCounter][0] = player.getId();
			playerDetails[rowCounter][1] = player.getName();
			playerDetails[rowCounter][2] = String.valueOf(player.getPoints());

			rowCounter += 1;

		}
		
		
	}

	public AllPlayersTable(GameEngineImpl theModel) {
		
		
		System.out.println("Player Panel has been created");
		Collection<Player> allPlayers = theModel.getAllPlayers();
		String []  tableHeaders = { "Player ID", "Player Name", "Player Points" };
		String[][] playerDetails = new String[allPlayers.size()][tableHeaders.length]; // rows is num players cols is
																						// based on col header

		
		
		int rowCounter = 0;

		System.out.println("Number of Players" + allPlayers.size());
		for (Player player : allPlayers) {
			playerDetails[rowCounter][0] = player.getId();
			playerDetails[rowCounter][1] = player.getName();
			playerDetails[rowCounter][2] = String.valueOf(player.getPoints());

			rowCounter += 1;

		}

		// button cancelling and closing the screen
		JPanel tablePanel = new JPanel();//
		JTable playerSummaryTable = new JTable(playerDetails, tableHeaders);
		playerSummaryTable.setBounds(30, 40, 400, 400);
		playerSummaryTable.setShowGrid(true);
		tablePanel.setSize(540, 540);
	    tablePanel.add(playerSummaryTable);
	    JScrollPane scrollPane = new JScrollPane(playerSummaryTable);
	    tablePanel.add(scrollPane, BorderLayout.CENTER);

	    tablePanel.setVisible(true);
	    this.add(tablePanel);
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE); // so it closes
		this.setSize(540, 540); // confused about the "this"
		this.setTitle("All Players Summary");
	
	}
	// this is for the close button

	public void cancelButtonListener(ActionListener CloseButtonActionListener) {

		close.addActionListener(CloseButtonActionListener);
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getColumnName(int columnIndex) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addTableModelListener(TableModelListener l) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeTableModelListener(TableModelListener l) {
		// TODO Auto-generated method stub
		
	}

}
