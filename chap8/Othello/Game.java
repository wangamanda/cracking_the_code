package Othello;

import java.util.ArrayList;

public class Game{
	private static Game instance;
	private Board board;
	private Player[] players;
	private final int ROW = 10;
	private final int COL = 10;

	public Game(){
		players = new Player[2];
		players[0] = new Player(Color.Black);
		players[1] = new Player(Color.White);
		board = new Board(ROW, COL);
	}

	public static Game getInstance(){
		if(instance == null){
			instance = new Game();
		}
		return instance;
	}

	public Board getBoard(){
		return board;
	}

	public Player[] getPlayers(){
		return players;
	}
}
