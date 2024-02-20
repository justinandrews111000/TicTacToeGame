import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

public class Board {

	private boolean isP1Turn = true;
	private boolean hasWon = false;
	private String p1Name = "Player1";
	private String p2Name = "Player2";
	private String winner = "";

	// the ints passed to the GridLayout are, in order: rows, columns,
	// horizontal gap, vertical gap.
	private GridLayout gridLayout = new GridLayout(3, 3, 5, 5);
	private JFrame mainFrame = new JFrame();
	private ImageIcon blankIcon = new ImageIcon("src/Blank.png");
	private ImageIcon xIcon = new ImageIcon("src/X.png");
	private ImageIcon oIcon = new ImageIcon("src/O.png");

	public void startGame() {

		// Name JFrame.
		mainFrame.setTitle("TicTacToe");

		// Sets the location of the top left of the Frame at the center of the screen.
		mainFrame.setLocationRelativeTo(null);

		// Centers the middle of the frame.
		mainFrame.setLocation(mainFrame.getX() - 180, mainFrame.getY() - 180);

		// Gridlayout is used to place GUI elements in a grid.
		mainFrame.setLayout(gridLayout);

		// Closes JFrame when clicked the "X" button on the frame.
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// 2D array of JButtons. I really don't think I need to use a 2D array and it
		// would be less complicated if it were a 1D array?
		JButton[][] gameButton = new JButton[3][3];

		// Populate the gameButton array.
		for (int i = 0; i < gameButton.length; i++) {

			for (int j = 0; j < gameButton[i].length; j++) {

				// Creates a JButton with a blank icon.
				gameButton[i][j] = new JButton(blankIcon);

				// Adds an actionListener to the button so that you can click it and it executes
				// what is in the actionPerformed method.
				gameButton[i][j].addActionListener(new ActionListener() {

					public void actionPerformed(ActionEvent e) {

						// Get the source of the buttonClicked.
						Object clickedTile = e.getSource();

						// Boolean for sentinel of the While loop.
						boolean isFound = false;
						// First index of the array.
						int index1 = 0;

						// Second index of the array.
						int index2 = 0;

						while (!isFound) {

							// Finding the index of the button in the button array.
							for (int k = 0; k < gameButton.length; k++) {

								for (int l = 0; l < gameButton[k].length; l++) {

									if (clickedTile == gameButton[k][l]) {
										index1 = k;
										index2 = l;

										// Breaks loop.
										isFound = true;
									}

								}

							}

						}

						// Logic for changing the button to either an 'X' or an 'O'.
						if (gameButton[index1][index2].getIcon() == blankIcon) {

							if (isP1Turn == true) {
								gameButton[index1][index2].setIcon(xIcon);
								isP1Turn = false;
							} else {
								gameButton[index1][index2].setIcon(oIcon);
								isP1Turn = true;
							}
						}

						// Checks the board for a win condition.
						winConditions(gameButton);

					}

				});

				// Add the button to the JFrame
				mainFrame.add(gameButton[i][j]);

			}

		}

		// Sets the size of the JFrame.
		mainFrame.setSize(360, 360);

		// Displays the JFrame.
		mainFrame.setVisible(true);
		mainFrame.setAlwaysOnTop(true);

	}

	// Checks all possible win conditions.
	public void winConditions(JButton[][] gameButton) {
		if (gameButton[0][0].getIcon() == gameButton[0][1].getIcon() && gameButton[0][1].getIcon() == gameButton[0][2].getIcon()
				&& gameButton[0][0].getIcon() != blankIcon) {

			if (!hasWon) {
				winCalcs(gameButton);
			}

		}

		if (gameButton[1][0].getIcon() == gameButton[1][1].getIcon() && gameButton[1][1].getIcon() == gameButton[1][2].getIcon()
				&& gameButton[1][0].getIcon() != blankIcon) {

			if (!hasWon) {
				winCalcs(gameButton);
			}

		}

		if (gameButton[2][0].getIcon() == gameButton[2][1].getIcon() && gameButton[2][1].getIcon() == gameButton[2][2].getIcon()
				&& gameButton[2][0].getIcon() != blankIcon) {

			if (!hasWon) {
				winCalcs(gameButton);
			}
			;

		}

		if (gameButton[0][0].getIcon() == gameButton[1][0].getIcon() && gameButton[1][0].getIcon() == gameButton[2][0].getIcon()
				&& gameButton[0][0].getIcon() != blankIcon) {

			if (!hasWon) {
				winCalcs(gameButton);
			}

		}

		if (gameButton[0][1].getIcon() == gameButton[1][1].getIcon() && gameButton[1][1].getIcon() == gameButton[2][1].getIcon()
				&& gameButton[0][1].getIcon() != blankIcon) {

			if (!hasWon) {
				winCalcs(gameButton);
			}

		}

		if (gameButton[0][2].getIcon() == gameButton[1][2].getIcon() && gameButton[1][2].getIcon() == gameButton[2][2].getIcon()
				&& gameButton[0][2].getIcon() != blankIcon) {

			if (!hasWon) {
				winCalcs(gameButton);
			}

		}

		if (gameButton[0][0].getIcon() == gameButton[1][1].getIcon() && gameButton[1][1].getIcon() == gameButton[2][2].getIcon()
				&& gameButton[0][0].getIcon() != blankIcon) {

			if (!hasWon) {
				winCalcs(gameButton);
			}

		}

		if (gameButton[2][0].getIcon() == gameButton[1][1].getIcon() && gameButton[1][1].getIcon() == gameButton[0][2].getIcon()
				&& gameButton[2][0].getIcon() != blankIcon) {

			if (!hasWon) {
				winCalcs(gameButton);
			}

		}
	}

	// Win state calculations.
	public void winCalcs(JButton[][] gameButton) {
		hasWon = true;

		// Since the turn switches after the click of a button, the turn needs to be
		// inverted to be correct. Better logic could fix this?
		if (!isP1Turn == true) {
			winner = p1Name;
		} else {
			winner = p2Name;
		}

		// iterates between the buttons, changed their icon to none, sets the background
		// color to green, disables them, and deselects them.
		for (int i = 0; i < gameButton.length; i++) {
			for (int j = 0; j < gameButton[i].length; j++) {
				gameButton[i][j].setIcon(null);
				gameButton[i][j].setBackground(new Color(0, 150, 0));
				gameButton[i][j].setEnabled(false);
				gameButton[i][j].setSelected(false);

			}
		}

		// displays the winner across the game board.
		gameButton[0][0].setText(winner);
		gameButton[1][1].setText("has");
		gameButton[2][2].setText("won!");
	}

}
