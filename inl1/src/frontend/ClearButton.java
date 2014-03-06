package frontend;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class ClearButton extends JButton implements ActionListener {

	private GridPanel m_gridPanel;
	
	public ClearButton( GridPanel gridPanel ){
		super( "Clear" );
		m_gridPanel = gridPanel;
		setToolTipText( "Clear grid" );
		addActionListener( this );
	}
	
	public void actionPerformed(ActionEvent arg0) {
		m_gridPanel.Clear();
	}
	
}
