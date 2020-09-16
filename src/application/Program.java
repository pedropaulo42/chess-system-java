package application;

import java.util.InputMismatchException;
import java.util.Scanner;

import chess.ChessException;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;

public class Program {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		ChessMatch chessMatch = new ChessMatch();
		
		while(true) {
			try {
				UI.clearScreen();
				UI.printBoard(chessMatch.getPieces());
				System.out.print("\nSource: ");
				ChessPosition source = UI.readChessPosition(scan);
				System.out.print("\nTarget: ");
				ChessPosition target = UI.readChessPosition(scan);
				
				ChessPiece capturedPiece = chessMatch.performChessMove(source, target);
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
