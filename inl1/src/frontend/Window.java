package frontend;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JTextField;

public class Window {
	
	private GridPanel m_gridPanel;
	private ControlPanel m_controlPanel;

	public Window(String title){
		JFrame window = new JFrame( title );
		m_gridPanel = new GridPanel();
		m_controlPanel = new ControlPanel( m_gridPanel );
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		window.add( m_gridPanel, BorderLayout.NORTH );
		window.add( m_controlPanel, BorderLayout.SOUTH );
		
		window.pack();
		window.setVisible( true );
	}
}
