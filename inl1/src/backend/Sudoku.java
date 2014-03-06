package backend;

import frontend.OneLetterField;

public class Sudoku {

	private int[][] m_sudokuMatrix;

	public Sudoku() {
		m_sudokuMatrix = new int[9][9];
	}

	/**
	 * Read the grid values and places them in m_sudokuMatrix if they are in a
	 * legal placement
	 * 
	 * @param fields
	 *            the fields from the grid to read from
	 * @return true if it was possible to add all the numbers, else false
	 */
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
					if (!LegalNumberPlacement(i, j, value)) {
						return false;
					}
				}
				m_sudokuMatrix[i][j] = value;
			}
		}

		return true;
	}

	/**
	 * Solves the sudoku
	 */
	public boolean Solve() {
		return SolveSudoku(0, 0);
	}

	/**
	 * Solves sudoku
	 * 
	 * @param column
	 *            , row the numbers position( column = x position, row = y )
	 * @return true if it was possible to find a fitting number or if we checked
	 *         every position, else false
	 */
	private boolean SolveSudoku(int column, int row) {
		// If its the last column reset it to 0 and jump down a row
		if (column == 9) {
			column = 0;
			row++;

			// If we checked all row return true
			if (row == 9) {
				return true;
			}
		}

		// Skip all already filled numbers
		if (m_sudokuMatrix[column][row] == 0) {
			for (int i = 0; i <= 9; i++) {
				if (LegalNumberPlacement(column, row, i)) {
					m_sudokuMatrix[column][row] = i;

					if (SolveSudoku(column + 1, row)) {
						return true;
					} else {
						// If failure, reset to try again
						m_sudokuMatrix[column][row] = 0;
					}
				}
			}
		} else {
			// If the first value is already set we need this
			if (SolveSudoku(column + 1, row)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Checks if the numberplacement is legal
	 * 
	 * @param column
	 *            , row, value column and row is the position and value the
	 *            number to check
	 * @return true if it was legal placement, else false
	 */
	private boolean LegalNumberPlacement(int column, int row, int value) {

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

	/**
	 * Returns a matrix with the sudokus values
	 * 
	 * @return Integer Matrix
	 */
	public int[][] GetMatrix() {
		// rv = return value
		int[][] rv = m_sudokuMatrix;

		return rv;
	}

	/**
	 * Replace the old matrix with a new one
	 */
	public void ResetMatrix() {
		m_sudokuMatrix = new int[9][9];
	}
}
