package application;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import chess.ChessException;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;

public class Program {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		ChessMatch chessMatch = new ChessMatch();
		List<ChessPiece> captured = new ArrayList<>();
		
		while(true) {
			try {
				UI.clearScreen();
				UI.printMatch(chessMatch, captured);
				System.out.print("\nSource: ");
				ChessPosition source = UI.readChessPosition(scan);
				
				boolean[][] possibleMoves = chessMatch.possibleMoves(source);
				UI.clearScreen();
				UI.printBoard(chessMatch.getPieces(), possibleMoves);
				
				System.out.print("\nTarget: ");
				ChessPosition target = UI.readChessPosition(scan);
				
				ChessPiece capturedPiece = chessMatch.performChessMove(source, target);
				
				if (capturedPiece != null) {
					captured.add(capturedPiece);
				}
			}
			catch (ChessException error) {
				System.out.println(error.getMessage());
				System.out.println("Press ENTER to continue.");
				scan.nextLine();
			}
			catch (InputMismatchException error) {
				System.out.println(error.getMessage());
				System.out.println("Press ENTER to continue.");
				scan.nextLine();
			}
		}
	}
}
