package frontend;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class SolveButton extends JButton implements ActionListener {
	
	private Grid m_grid;
	public SolveButton(  Grid grid) {
		super("Solve" );
		setToolTipText( "Solve Sudoku" );
		addActionListener( this );
		
		m_grid = grid;
	}
	
	public void actionPerformed(ActionEvent arg0) {
		m_grid.Solve();
	}

}
