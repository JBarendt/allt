package backend;

import frontend.OneLetterField;

public class Sudoku {

	private int[][] m_sudokuMatrix;

	public Sudoku() {
		m_sudokuMatrix = new int[9][9];
	}

	public boolean ReadGridValues(OneLetterField[][] fields) {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				int value;

				// If field is empty set it to 0, else parse the values to int
				// and check if its a legal placement
				if (!fields[i][j].getText().equals("")) {
					value = Integer.parseInt(fields[i][j].getText());
				} else {
					value = 0;
				}
				if (value != 0) {
					m_sudokuMatrix[i][j] = 0;
					if (!LegalNumberPlacement(j, i, value)) {
						return false;
					}
				}
				m_sudokuMatrix[i][j] = value;
			}
		}

		return true;
	}

	public boolean Solve() {
		return SolveSudoku(0, 0);
	}

	private boolean SolveSudoku(int row, int column) {

		if(column == 9){
			column = 0;
			row++;
			
			if(row == 9){
				return true;
			}
		}
		
		if(m_sudokuMatrix[column][row] == 0){
		for(int i = 0; i <= 9; i++){
			if(LegalNumberPlacement(row, column, i)){
				m_sudokuMatrix[column][row] = i;
				
				if(SolveSudoku(row, column+1)){
					return true;
				} else{
					m_sudokuMatrix[column][row] = 0;
				}
			}
		}
		} else {
			if(SolveSudoku(row, column+1)){
				return true;
			}
		}
		return false;
	}

	private boolean LegalNumberPlacement(int row, int column, int value) {

			// Check if the number exists in the current row
			for (int i = 0; i < 9; i++) {
				if (m_sudokuMatrix[i][row] == value) {
					return false;
				}
			}

			// Check if the number exists in the current column
			for (int i = 0; i < 9; i++) {
				if (m_sudokuMatrix[column][i] == value) {
					return false;
				}
			}

			// Check if the number exists in the current 3x3 section
			int rowOffset = (row / 3) * 3;
			int columnOffset = (column / 3) * 3;
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					if (m_sudokuMatrix[columnOffset + i][rowOffset + j] == value) {
						return false;
					}
				}
			}
			


		return true;
	}

	public int[][] GetMatrix() {
		// rv = return value
		int[][] rv = m_sudokuMatrix;

		return rv;
	}
	
	public void ResetMatrix(){
		m_sudokuMatrix = new int[9][9];
	}
}
