// TicTacToe.cpp : This file contains the 'main' function. Program execution begins and ends there.
// This tic-tac-toe game is Human v. Machine (single-player versus random algorithms inside the computer)

#include <iostream>
#include <vector>
#include <string>
using namespace std;

enum Statements {
	BEGIN,
	PROCESSING,
	ABS_WIN,
	ABS_LOSE
};

enum PlayerStatus {
	NORMAL,
	WIN,
	LOSE,
	TIE
};

class TicTacToe {
private:
	string role;
	string opposite_role;
	Statements stm = BEGIN;
public:
	PlayerStatus judge(vector<vector<string>> chequerboard,int moves) {
		for (int x = 0;x < chequerboard.size();x++) {
			if (chequerboard[x][0] == chequerboard[x][1] and chequerboard[x][1] == chequerboard[x][2] and chequerboard[x][2] == chequerboard[x][0] and chequerboard[x][0] == role) {
				cout << "You won!" << endl;
				return WIN;
			}
			else if (chequerboard[x][0] == chequerboard[x][1] and chequerboard[x][1] == chequerboard[x][2] and chequerboard[x][2] == chequerboard[x][0] and chequerboard[x][0] == opposite_role) {
				cout << "You failed." << endl;
				return LOSE;
			}

		}
		for (int y = 0;y < chequerboard[0].size();y++) {
			if (chequerboard[0][y] == chequerboard[1][y] and chequerboard[1][y] == chequerboard[2][y] and chequerboard[2][y] == chequerboard[0][y] and chequerboard[0][y] == role) {
				cout << "You won!" << endl;
				return WIN;
			}
			else if (chequerboard[0][y] == chequerboard[1][y] and chequerboard[1][y] == chequerboard[2][y] and chequerboard[2][y] == chequerboard[0][y] and chequerboard[0][y] == opposite_role) {
				cout << "You failed." << endl;
				return LOSE;
			}
		}
		if (
			(chequerboard[0][0] == chequerboard[1][1] and chequerboard[1][1] == chequerboard[2][2] and chequerboard[2][2] == chequerboard[0][0] and chequerboard[0][0] == role)
			or
			(chequerboard[0][2] == chequerboard[1][1] and chequerboard[1][1] == chequerboard[2][0] and chequerboard[2][0] == chequerboard[0][2] and chequerboard[0][2] == role)
			) {
			cout << "You won!" << endl;
			return WIN;
		}
		else if (
			(chequerboard[0][0] == chequerboard[1][1] and chequerboard[1][1] == chequerboard[2][2] and chequerboard[2][2] == chequerboard[0][0] and chequerboard[0][0] == opposite_role)
			or
			(chequerboard[0][2] == chequerboard[1][1] and chequerboard[1][1] == chequerboard[2][0] and chequerboard[2][0] == chequerboard[0][2] and chequerboard[0][2] == opposite_role)
			) {
			cout << "You failed." << endl;
			return LOSE;
		}
		else if (moves >= 9) {
			cout << "Tie board, yinz both stuck." << endl;
			return TIE;
		}
		return NORMAL;
	}

	PlayerStatus game() {
		PlayerStatus result = NORMAL;
		int move_count = 0;
		vector<vector<string>> chequerboard = { 
			{"1","2","3"},
			{"4","5","6"},
			{"7","8","9"} 
		};
		while (true) {
			//cout << move_count << endl;
			string your_place, opposite_place;
			for (int x = 0;x < chequerboard.size();x++) {
				for (int y = 0;y < chequerboard[x].size();y++) {
					cout << chequerboard[x][y] << " ";
				}
				cout << endl;
			}
			cout << "Select your place (1-9): ";
			cin >> your_place;
			for (int i = 0;i < chequerboard.size();i++) {
				for (int o = 0;o < chequerboard[i].size();o++) {
					if (chequerboard[i][o] == your_place and !(chequerboard[i][o] == "O" or chequerboard[i][o] == "X")) {
						chequerboard[i][o] = role;
						move_count++;
					}
				}
			}
			for (int x = 0;x < chequerboard.size();x++) {
				for (int y = 0;y < chequerboard[x].size();y++) {
					cout << chequerboard[x][y] << " ";
				}
				cout << endl;
			}
			result = judge(chequerboard, move_count);
			if (result != NORMAL) {
				return result;
			}
			cout << "Select your place (opposite, 1-9): ";
			cin >> opposite_place;
			for (int i = 0;i < chequerboard.size();i++) {
				for (int o = 0;o < chequerboard[i].size();o++) {
					if (chequerboard[i][o] == opposite_place and !(chequerboard[i][o] == "O" or chequerboard[i][o] == "X")) {
						chequerboard[i][o] = opposite_role;
						move_count++;
					}
				}
			}
			result = judge(chequerboard, move_count);
			if (result != NORMAL) {
				return result;
			}
		}
		return result;
	}

	int fun() {
		cout << "TicTacToe" << endl;
		while (true) {
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
				cout << "You absolutely won!" << endl;
				return 0;
			}
			else if (stm == ABS_LOSE) {
				cout << "Have fun next time!" << endl;
				return 0;
			}
		}
		return 0;
	}

	int start() {
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

	int lead() {
		cout << "Select your role (X/O): ";
		cin >> role;
		if (role == "X") {
			opposite_role = "O";
			return start();
		}
		else if (role == "O") {
			opposite_role = "X";
			return start();
		}
		else {
			cout << "You haven't chose a role yet!" << endl;
			return -1;
		}
	}
};

int main()
{
	TicTacToe ttt;
	return ttt.fun();
}

