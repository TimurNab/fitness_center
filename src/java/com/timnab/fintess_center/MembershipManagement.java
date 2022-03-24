package com.timnab.fintess_center;

import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Scanner;

public class MembershipManagement {
    private final String ERROR = "ERROR: INVALID INPUT. Please try again:";

    final private Scanner scanner = new Scanner(System.in);

    private int getIntInput() {
        int choice = 0;
        while (choice == 0) {
            try {
                choice = scanner.nextInt();
                if (choice == 0) {
                    throw new InputMismatchException();
                }
                scanner.nextLine();
            } catch (InputMismatchException e) {
                scanner.nextLine();
                System.out.println(ERROR);
            }
        }
        return choice;
    }

}
