package TicTacToe;
import java.util.*;
import static TicTacToe.PlayerStatus.*;

public class GameAlgo extends TicTacToe {
    public PlayerStatus judge(ArrayList<ArrayList<String>> chequerboard, int moves){
        for (int x = 0;x < chequerboard.size();x++) {
            if (chequerboard.get(x).get(0).equals(chequerboard.get(x).get(1)) && chequerboard.get(x).get(1).equals(chequerboard.get(x).get(2)) && chequerboard.get(x).get(2).equals(chequerboard.get(x).get(0)) && chequerboard.get(x).get(0).equals(role)) {
                System.out.println("You won!");
                return WIN;
            }
            else if (chequerboard.get(x).get(0).equals(chequerboard.get(x).get(1)) && chequerboard.get(x).get(1).equals(chequerboard.get(x).get(2)) && chequerboard.get(x).get(2).equals(chequerboard.get(x).get(0)) && chequerboard.get(x).get(0).equals(opposite_role)) {
                System.out.println("You failed.");
                return LOSE;
            }

        }
        for (int y = 0;y < chequerboard.get(0).size();y++) {
            if (chequerboard.get(0).get(y).equals(chequerboard.get(1).get(y)) && chequerboard.get(1).get(y).equals(chequerboard.get(2).get(y)) && chequerboard.get(2).get(y).equals(chequerboard.get(0).get(y)) && chequerboard.get(0).get(y).equals(role)) {
                System.out.println("You won!");
                return WIN;
            }
            else if (chequerboard.get(0).get(y).equals(chequerboard.get(1).get(y)) && chequerboard.get(1).get(y).equals(chequerboard.get(2).get(y)) && chequerboard.get(2).get(y).equals(chequerboard.get(0).get(y)) && chequerboard.get(0).get(y).equals(opposite_role)) {
                System.out.println("You failed.");
                return LOSE;
            }
        }
        if (
                (chequerboard.get(0).get(0).equals(chequerboard.get(1).get(1)) && chequerboard.get(1).get(1).equals(chequerboard.get(2).get(2)) && chequerboard.get(2).get(2).equals(chequerboard.get(0).get(0)) && chequerboard.get(0).get(0).equals(role))
                        ||
                        (chequerboard.get(0).get(2).equals(chequerboard.get(1).get(1)) && chequerboard.get(1).get(1).equals(chequerboard.get(2).get(0)) && chequerboard.get(2).get(0).equals(chequerboard.get(0).get(2)) && chequerboard.get(0).get(2).equals(role))
        ) {
            System.out.println("You won!");
            return WIN;
        }
        else if (
                (chequerboard.get(0).get(0).equals(chequerboard.get(1).get(1)) && chequerboard.get(1).get(1).equals(chequerboard.get(2).get(2)) && chequerboard.get(2).get(2).equals(chequerboard.get(0).get(0)) && chequerboard.get(0).get(0).equals(opposite_role))
                        ||
                        (chequerboard.get(0).get(2).equals(chequerboard.get(1).get(1)) && chequerboard.get(1).get(1).equals(chequerboard.get(2).get(0)) && chequerboard.get(2).get(0).equals(chequerboard.get(0).get(2)) && chequerboard.get(0).get(2).equals(opposite_role))
        ) {
            System.out.println("You failed.");
            return LOSE;
        }
        else if (moves >= 9) {
            System.out.println("Tie board, yinz both lose.");
            return TIE;
        }
        return NORMAL;
    }
}
