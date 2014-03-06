package frontend;

import backend.Sudoku;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class GridPanel extends JPanel{
	
	private OneLetterField[][] m_fields;
	private Sudoku m_sudoku;
	
	public GridPanel(){
		setLayout(new GridLayout(9, 9));
		m_fields = new OneLetterField[9][9];
		m_sudoku = new Sudoku();
		
		for(int i = 0; i < 9; i++){
			for(int j = 0; j < 9; j++){
				m_fields[i][j] = new OneLetterField();
				m_fields[i][j].setText( "" );
				
				if( i/3 != 1 && j/3 != 1 || i/3 == 1 && j/3 == 1){
					m_fields[i][j].setBackground(new Color(192, 192, 192));
				}
				add( m_fields[i][j] );
			}
		}
	}
	
	public void Clear(){
		for(int i = 0; i < 9; i++){
			for(int j = 0; j < 9; j++){
				m_fields[i][j].setText( "" );
				
			}
		}
		
		m_sudoku.ResetMatrix();
	}
	
	public void Solve() {
		if( !m_sudoku.ReadGridValues( m_fields ) ){
			JOptionPane.showMessageDialog(null, "Invalid input");
		} else{
			if( m_sudoku.Solve() ){
				for(int i = 0; i < 9; i++){
					for(int j = 0; j < 9; j++){
						m_fields[i][j].setText( String.valueOf( m_sudoku.GetMatrix()[i][j] ) );
					}
				}
				
				JOptionPane.showMessageDialog(null, "Sudoku solved!");
			} else {
				JOptionPane.showMessageDialog(null, "Cant solve Sudoku!");
			}
		}
	}

}
