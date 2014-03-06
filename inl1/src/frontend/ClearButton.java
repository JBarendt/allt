package frontend;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class ClearButton extends JButton implements ActionListener {

	private Grid m_grid;
	
	public ClearButton( Grid grid ){
		super( "Clear" );
		m_grid = grid;
		setToolTipText( "Clear grid" );
		addActionListener( this );
	}
	
	public void actionPerformed(ActionEvent arg0) {
		m_grid.Clear();
	}
	
}
