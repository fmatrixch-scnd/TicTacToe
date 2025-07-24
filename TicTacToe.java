package TicTacToe;
import java.util.*;

public class TicTacToe {
    private static String role;
    private static String opposite_role;
    public static int winning_games = 0;
    public boolean game() {
        Scanner sc = new Scanner(System.in);
        boolean result = false;
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
                for (int y = 0;y < chequerboard.get(x).size();y++) {
                    System.out.print(chequerboard.get(x).get(y) + " ");
                }
                System.out.println();
            }
            for (int x = 0;x < chequerboard.size();x++) {
                if (chequerboard.get(x).get(0).equals(chequerboard.get(x).get(1)) && chequerboard.get(x).get(1).equals(chequerboard.get(x).get(2)) && chequerboard.get(x).get(2).equals(chequerboard.get(x).get(0)) && chequerboard.get(x).get(0).equals(role)) {
                    result = true;
                    System.out.println("You won!");
                    return result;
                }
				else if (chequerboard.get(x).get(0).equals(chequerboard.get(x).get(1)) && chequerboard.get(x).get(1).equals(chequerboard.get(x).get(2)) && chequerboard.get(x).get(2).equals(chequerboard.get(x).get(0)) && chequerboard.get(x).get(0).equals(opposite_role)) {
                    System.out.println("You failed.");
                    return result;
                }

            }
            for (int y = 0;y < chequerboard.get(0).size();y++) {
                if (chequerboard.get(0).get(y).equals(chequerboard.get(1).get(y)) && chequerboard.get(1).get(y).equals(chequerboard.get(2).get(y)) && chequerboard.get(2).get(y).equals(chequerboard.get(0).get(y)) && chequerboard.get(0).get(y).equals(role)) {
                    result = true;
                    System.out.println("You won!");
                    return result;
                }
				else if (chequerboard.get(0).get(y).equals(chequerboard.get(1).get(y)) && chequerboard.get(1).get(y).equals(chequerboard.get(2).get(y)) && chequerboard.get(2).get(y).equals(chequerboard.get(0).get(y)) && chequerboard.get(0).get(y).equals(opposite_role)) {
                    System.out.println("You failed.");
                    return result;
                }
            }
            if (
                    (chequerboard.get(0).get(0).equals(chequerboard.get(1).get(1)) && chequerboard.get(1).get(1).equals(chequerboard.get(2).get(2)) && chequerboard.get(2).get(2).equals(chequerboard.get(0).get(0)) && chequerboard.get(0).get(0).equals(role))
            ||
                    (chequerboard.get(0).get(2).equals(chequerboard.get(1).get(1)) && chequerboard.get(1).get(1).equals(chequerboard.get(2).get(0)) && chequerboard.get(2).get(0).equals(chequerboard.get(0).get(2)) && chequerboard.get(0).get(2).equals(role))
				) {
                result = true;
                System.out.println("You won!");
                return result;
            }
			else if (
                    (chequerboard.get(0).get(0).equals(chequerboard.get(1).get(1)) && chequerboard.get(1).get(1).equals(chequerboard.get(2).get(2)) && chequerboard.get(2).get(2).equals(chequerboard.get(0).get(0)) && chequerboard.get(0).get(0).equals(opposite_role))
            ||
                    (chequerboard.get(0).get(2).equals(chequerboard.get(1).get(1)) && chequerboard.get(1).get(1).equals(chequerboard.get(2).get(0)) && chequerboard.get(2).get(0).equals(chequerboard.get(0).get(2)) && chequerboard.get(0).get(2).equals(opposite_role))
				) {
                System.out.println("You failed.");
                return result;
            }
			else if (move_count >= 9) {
                System.out.println("Tie board, yinz both lose.");
                return result;
            }
            else {
                System.out.print("Select your place (opposite, 1-9): ");
                opposite_place = sc.nextLine();
                for (int i = 0;i < chequerboard.size();i++) {
                    for (int o = 0;o < chequerboard.get(i).size();o++) {
                        if (chequerboard.get(i).get(o).equals(opposite_place) && !(chequerboard.get(i).get(o).equals("O") || chequerboard.get(i).get(o).equals("X"))) {
                            ArrayList<String> row = chequerboard.get(i);
                            row.set(o,opposite_role);
                            move_count++;
                        }
                    }
                }
                for (int x = 0;x < chequerboard.size();x++) {
                    if (chequerboard.get(x).get(0).equals(chequerboard.get(x).get(1)) && chequerboard.get(x).get(1).equals(chequerboard.get(x).get(2)) && chequerboard.get(x).get(2).equals(chequerboard.get(x).get(0)) && chequerboard.get(x).get(0).equals(role)) {
                        result = true;
                        System.out.println("You won!");
                        return result;
                    }
					else if (chequerboard.get(x).get(0).equals(chequerboard.get(x).get(1)) && chequerboard.get(x).get(1).equals(chequerboard.get(x).get(2)) && chequerboard.get(x).get(2).equals(chequerboard.get(x).get(0)) && chequerboard.get(x).get(0).equals(opposite_role)) {
                        System.out.println("You failed.");
                        return result;
                    }

                }
                for (int y = 0;y < chequerboard.get(0).size();y++) {
                    if (chequerboard.get(0).get(y).equals(chequerboard.get(1).get(y)) && chequerboard.get(1).get(y).equals(chequerboard.get(2).get(y)) && chequerboard.get(2).get(y).equals(chequerboard.get(0).get(y)) && chequerboard.get(0).get(y).equals(role)) {
                        result = true;
                        System.out.println("You won!");
                        return result;
                    }
					else if (chequerboard.get(0).get(y).equals(chequerboard.get(1).get(y)) && chequerboard.get(1).get(y).equals(chequerboard.get(2).get(y)) && chequerboard.get(2).get(y).equals(chequerboard.get(0).get(y)) && chequerboard.get(0).get(y).equals(opposite_role)) {
                        System.out.println("You failed.");
                        return result;
                    }
                }
                if (
                        (chequerboard.get(0).get(0).equals(chequerboard.get(1).get(1)) && chequerboard.get(1).get(1).equals(chequerboard.get(2).get(2)) && chequerboard.get(2).get(2).equals(chequerboard.get(0).get(0)) && chequerboard.get(0).get(0).equals(role))
                ||
                        (chequerboard.get(0).get(2).equals(chequerboard.get(1).get(1)) && chequerboard.get(1).get(1).equals(chequerboard.get(2).get(0)) && chequerboard.get(2).get(0).equals(chequerboard.get(0).get(2)) && chequerboard.get(0).get(2).equals(role))
					) {
                    result = true;
                    System.out.println("You won!");
                    return result;
                }
				else if (
                        (chequerboard.get(0).get(0).equals(chequerboard.get(1).get(1)) && chequerboard.get(1).get(1).equals(chequerboard.get(2).get(2)) && chequerboard.get(2).get(2).equals(chequerboard.get(0).get(0)) && chequerboard.get(0).get(0).equals(opposite_role))
                ||
                        (chequerboard.get(0).get(2).equals(chequerboard.get(1).get(1)) && chequerboard.get(1).get(1).equals(chequerboard.get(2).get(0)) && chequerboard.get(2).get(0).equals(chequerboard.get(0).get(2)) && chequerboard.get(0).get(2).equals(opposite_role))
					) {
                    System.out.println("You failed.");
                    return result;
                }else if (move_count >= 9) {
                    System.out.println("Sounds like a tie. Auto quit.");
                    return result;
                }
            }
        }
    }
    public int fun() {
        Scanner sc = new Scanner(System.in);
        System.out.println("TicTacToe");
        System.out.print("Select your role (X/O): ");
        role = sc.nextLine();
        if (role.equals("X")) {
            opposite_role = "O";
        }
        else if (role.equals("O")) {
            opposite_role = "X";
        }
        else {
            System.out.println("You haven't chose a role yet!");
            return -1;
        }
        for (int x = 0;x < 3;x++) {
            boolean temp_res = game();
            if (temp_res){
                winning_games++;
            }
        }
        if (winning_games >= 2){
            System.out.println("You absolutely won!");
        }else{
            System.out.println("Have fun next time!");
        }
        return 0;
    }
}
