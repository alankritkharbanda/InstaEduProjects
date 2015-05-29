package monopoly.gui;

import javax.swing.JOptionPane;

import monopoly.*;
//Main class, basically takes input and starts the game
public class Main {

	private static int inputNumberOfPlayers(MainWindow window) {
		int numPlayers = 0;
		while(numPlayers <= 0 || numPlayers > GameMaster.MAX_PLAYER) {
			String numberOfPlayers = JOptionPane.showInputDialog(window, "How many players");
			if(numberOfPlayers == null) {
				System.exit(0);
			}
			try {
				numPlayers = Integer.parseInt(numberOfPlayers);
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(window, "Please input a number");
			}
			if (numPlayers <= 0 || numPlayers > GameMaster.MAX_PLAYER) {
				JOptionPane.showMessageDialog(window, "Please input a number between one and eight");
			} else {
				GameMaster.instance().setNumberOfPlayers(numPlayers);
			}
		}
		return numPlayers;
	}

	public static void main(String[] args) {
//gets new instance of game master class
		GameMaster master = GameMaster.instance();
//make a new containier ,gui window with 4 boundaries
		MainWindow window = new MainWindow();
		GameBoard gameBoard = null;
//if to run game in test mode for a class or not
		if(args.length > 0) {
			if(args[0].equals("test")) {
				master.setTestMode(true);
			}
			try {
				Class c = Class.forName(args[1]);
				gameBoard = (GameBoard)c.newInstance();
			}
			catch (ClassNotFoundException e) {
				JOptionPane.showMessageDialog(window, "Class Not Found.  Program will exit");
				System.exit(0);
			}
			catch (IllegalAccessException e ) {
				JOptionPane.showMessageDialog(window, "Illegal Access of Class.  Program will exit");
				System.exit(0);
			}
			catch (InstantiationException e) {
				JOptionPane.showMessageDialog(window, "Class Cannot be Instantiated.  Program will exit");
				System.exit(0);
			}
		}
//else start the game
		else {
//gives all the cells name and properties in game
			gameBoard = new GameBoardFull();
		}
		
//      GameBoard gameBoard = new GameBoardFull();
//		GameBoard gameBoard = new GameBoardCCMovePlayer();
//		GameBoard gameBoard = new GameBoardCCLoseMoney();
//		GameBoard gameBoard = new GameBoardCCJail();
//		GameBoard gameBoard = new GameBoardUtility();
//		GameBoard gameBoard = new GameBoardRailRoad();
//		GameBoard gameBoard = new GameBoard14();
//		GameBoard gameBoard = new SimpleGameBoard();
//		GameBoard gameBoard = new GameBoardJail();
//		GameBoard gameBoard = new GameBoardFreeParking();

//adds all cells to the main board
		master.setGameBoard(gameBoard);
//input number of players and there name
		int numPlayers = inputNumberOfPlayers(window);
		for(int i = 0; i < numPlayers; i++) {
			String name = 
				JOptionPane.showInputDialog(window, "Please input name for Player " + (i+1));
			GameMaster.instance().getPlayer(i).setName(name);
		}
//set up the the window and add game board to main window
		window.setupGameBoard(gameBoard);
		window.show();

		master.setGUI(window);
//starts the game
		master.startGame();
	}
}
