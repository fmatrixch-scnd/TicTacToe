package TicTacToe;
import java.util.*;
import static TicTacToe.PlayerStatus.*;
import static TicTacToe.Statements.*;

public class TicTacToe {
    public static String role;
    public static String opposite_role;
    public static Statements stm = BEGIN;
    public static PlayerStatus game() {
        GameAlgo ga = new GameAlgo();
        Scanner sc = new Scanner(System.in);
        PlayerStatus result = NORMAL;
        int move_count = 0;
        ArrayList<ArrayList<String>> chequerboard = new ArrayList<>(Arrays.asList(
                new ArrayList<String>(Arrays.asList("1","2","3")),
                new ArrayList<String>(Arrays.asList("4","5","6")),
                new ArrayList<String>(Arrays.asList("7","8","9"))
        ));
        while (true) {
            //System.out.println(move_count);
            String your_place, opposite_place;
            for (int x = 0;x < chequerboard.size();x++) {
                for (int y = 0;y < chequerboard.get(x).size();y++) {
                    System.out.print(chequerboard.get(x).get(y) + " ");
                }
                System.out.println();
            }
            System.out.print("Select your place (1-9): ");
            your_place = sc.nextLine();
            for (int i = 0;i < chequerboard.size();i++) {
                for (int o = 0;o < chequerboard.get(i).size();o++) {
                    if (chequerboard.get(i).get(o).equals(your_place) && !(chequerboard.get(i).get(o).equals("O") || chequerboard.get(i).get(o).equals("X"))) {
                        ArrayList<String> row = chequerboard.get(i); 
                        row.set(o,role);
                        move_count++;
                    }
                }
            }
            for (int x = 0;x < chequerboard.size();x++) {
                for (int y = 0; y < chequerboard.get(x).size(); y++) {
                    System.out.print(chequerboard.get(x).get(y) + " ");
                }
                System.out.println();
            }
            result = ga.judge(chequerboard,move_count);
            if (result != NORMAL){
                return result;
            }
            System.out.print("Select your place (opposite, 1-9): ");
            opposite_place = sc.nextLine();
            for (int i = 0;i < chequerboard.size();i++) {
                for (int o = 0; o < chequerboard.get(i).size(); o++) {
                    if (chequerboard.get(i).get(o).equals(opposite_place) && !(chequerboard.get(i).get(o).equals("O") || chequerboard.get(i).get(o).equals("X"))) {
                        ArrayList<String> row = chequerboard.get(i);
                        row.set(o, opposite_role);
                        move_count++;
                    }
                }
            }
            result = ga.judge(chequerboard,move_count);
            if (result != NORMAL){
                return result;
            }
        }
    }
    public static int fun() {
        System.out.println("TicTacToe");
        while(true) {
            if (stm == BEGIN) {
                int wing = lead();
                if (wing >= 2) {
                    stm = ABS_WIN;
                }
                else {
                    stm = ABS_LOSE;
                }
            }
            else if (stm == ABS_WIN) {
                System.out.println("You absolutely won!");
                return 0;
            }
            else if (stm == ABS_LOSE) {
                System.out.println("Have fun next time!");
                return 0;
            }
        }
    }
    public static int start(){
        stm = PROCESSING;
        int winning_games = 0;
        for (int x = 0;x < 3;x++) {
            PlayerStatus temp_res = game();
            if (temp_res == WIN) {
                winning_games++;
            }
        }
        return winning_games;
    }
    public static int lead(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Select your role (X/O): ");
        role = sc.nextLine();
        if (role.equals("X")) {
            opposite_role = "O";
            return start();
        }
        else if (role.equals("O")) {
            opposite_role = "X";
            return start();
        }
        else {
            System.out.println("You haven't chose a role yet!");
            return -1;
        }
    }
}
