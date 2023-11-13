package com.duckrace.app;
// app controller, it directs flow of app, does all user prompting.

import com.duckrace.Board;
import com.duckrace.Reward;

import java.util.Locale;
import java.util.Scanner;

public class DuckRaceApp {
    private final Board board = new Board();
    private Scanner scanner = new Scanner(System.in);

    public void execute(){
        welcome();
        showBoard();
        int id = promptForId();
        Reward reward = promptForReward();
        updateBoard(id, reward);
        showBoard();
    }

    private void updateBoard(int id, Reward reward) {
        board.update(id, reward);
    }

    private Reward promptForReward() {
        Reward reward = null;
        while (true) {
            System.out.println("Enter 'P' for prize or 'D' for debit card: ");
            String in = scanner.nextLine().trim().toUpperCase(Locale.ROOT);
            if (in.matches("D || P")) {
                reward = ("D".equals(in)) ? Reward.DEBIT_CARD : Reward.PRIZES;
                return reward;
            }
        }
    }

    private int promptForId() {
        int id = 0;
        while(true) {
            System.out.print("Enter winner ID (1-19): ");
            String in = scanner.nextLine().trim();
            if(in.matches("\\d{1, 2}") && Integer.parseInt(in) >= 1 && Integer.parseInt(in) <= 19) {
                id = Integer.parseInt(in);
                return id;
            }
        }
    }

    private void showBoard() {
        board.show();
    }

    private void welcome() {
        System.out.println();
        System.out.println("---------------------------------------------------");
        System.out.println("W E L C O M E    T O    T H E    D U C K    R A C E");
        System.out.println("---------------------------------------------------");
    }
}