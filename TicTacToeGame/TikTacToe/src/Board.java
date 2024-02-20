import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

public class Board {

	private String[][] board = new String[3][3];
	private boolean isP1Turn = true;
	private int turnCount = 0;
	private String P1Name = "";
	private String P2Name = "";

	// the ints passed to the GridLayout are, in order: rows, columns, 
	// horizontal gap, vertical gap.
	private GridLayout gridLayout = new GridLayout(3, 3, 5, 5);
	private ImageIcon blankIcon = new ImageIcon("src/Blank.png");
	private ImageIcon xIcon = new ImageIcon("src/X.png");
	private ImageIcon oIcon = new ImageIcon("src/O.png");

	public void startGame() {

		// Create JFrame.
		JFrame mainFrame = new JFrame();

		// Name JFrame.
		mainFrame.setTitle("TikTacToe");

		// Sets the location of the top left of the Frame at the center of the screen.
		mainFrame.setLocationRelativeTo(null);

		// Centers the middle of the frame.
		mainFrame.setLocation(mainFrame.getX() - 180, mainFrame.getY() - 180);

		// Gridlayout is used to place GUI elements in a grid.
		mainFrame.setLayout(gridLayout);

		// 2D array of JButtons. I really don't think I need to use a 2D array and it
		// would be less complicated if it were a 1D array?
		JButton[][] gameTile = new JButton[3][3];

		// Populate the gameTile array.
		for (int i = 0; i < gameTile.length; i++) {

			for (int j = 0; j < gameTile[i].length; j++) {

				// Creates a JButton with a blank icon.
				gameTile[i][j] = new JButton(blankIcon);

				// Adds an actionListener to the button so that you can click it and it executes
				// what is in the actionPerformed method.
				gameTile[i][j].addActionListener(new ActionListener() {

					public void actionPerformed(ActionEvent e) {

						// Get the source of the buttonClicked.
						Object clickedTile = e.getSource();

						// Boolean for sentinel of the While loop.
						boolean isFound = false;
						// First index of the array.
						int index1 = 0;

						// Second index of the array.
						int index2 = 0;

						// Is this easy to read???????? or isFound = false better?
						while (!isFound) {

							// Finding the index of the button in the button array.
							for (int k = 0; k < gameTile.length; k++) {

								for (int l = 0; l < gameTile[k].length; l++) {

									if (clickedTile == gameTile[k][l]) {
										index1 = k;
										index2 = l;

										// Breaks loop.
										isFound = true;
									}

								}

							}

						}

					}

				});

				// Add the button to the JFrame
				mainFrame.add(gameTile[i][j]);

			}

		}

		// Sets the size of the JFrame.
		mainFrame.setSize(360, 360);

		// Displays the JFrame.
		mainFrame.setVisible(true);

	}
}
