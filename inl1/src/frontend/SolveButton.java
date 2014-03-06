package frontend;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class SolveButton extends JButton implements ActionListener {
	
	private GridPanel m_gridPanel;
	public SolveButton(  GridPanel gridPanel) {
		super( "Solve" );
		setToolTipText( "Solve Sudoku" );
		addActionListener( this );
		
		m_gridPanel = gridPanel;
	}
	
	public void actionPerformed(ActionEvent arg0) {
		m_gridPanel.Solve();
	}

}
