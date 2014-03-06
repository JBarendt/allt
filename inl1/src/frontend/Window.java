package frontend;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JTextField;

public class Window {

	private Grid m_grid;
	private ControlPanel m_controlPanel;

	public Window(String title) {
		JFrame window = new JFrame(title);
		m_grid = new Grid();
		m_controlPanel = new ControlPanel(m_grid);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		window.add(m_grid, BorderLayout.NORTH);
		window.add(m_controlPanel, BorderLayout.SOUTH);

		window.pack();
		window.setVisible(true);
	}
}
