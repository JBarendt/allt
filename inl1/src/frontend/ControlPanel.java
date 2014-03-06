package frontend;

import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

public class ControlPanel extends JPanel {

	private JPanel m_panel;
	
	private JButton m_clearButton;
	private JButton m_solveButton;
	
	public ControlPanel( GridPanel gridPanel ){
		m_solveButton = new SolveButton( gridPanel );
		m_clearButton = new ClearButton( gridPanel );
		
		setLayout( new FlowLayout( FlowLayout.LEFT ));
		add( m_clearButton );
		add( m_solveButton );
	}
}
