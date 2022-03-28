package com.timnab.fintess_center;

import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Scanner;

public class MembershipManagement {

    private final Scanner scanner = new Scanner(System.in);

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
                String ERROR = "ERROR: INVALID INPUT. Please try again:";
                System.out.println(ERROR);
            }
        }
        return choice;
    }

    private void printClubOptions() {
        String CLUBS_MENU = """
                1) Club Mercury \n
                2) Club Neptune \n
                3) Club Jupiter \n
                4) Multi Clubs \n
                """;
        System.out.println(CLUBS_MENU);
    }

    public int getChoice() {
        int choice;
        String WELCOME_MENU = """
                \n
                WELCOME TO OZONE FITNESS CENTER
                =====================
                1) Add Member \n
                2) Remove Member \n
                3) Display Member Information \n
                Please select an option (or Enter -1 to quit);
                """;
        System.out.println(WELCOME_MENU);
        choice = getIntInput();
        return choice;
    }

    public String addMembers(LinkedList<Member> m) {
        String name;
        int club;
        String mem;
        double fees;
        int memberID;
        Member mbr;
        Calculator<Integer> cal;

        System.out.print("\nPlease enter the member's name: ");
        name = scanner.nextLine();

        printClubOptions();
        System.out.print("\n Please enter the member's clubID: ");
        club = getIntInput();
        while (club < 1 || club > 4) {
            System.out.print("\n Invalid Club ID. Please try again: ");
            club = getIntInput();
        }

        if (m.size() > 0) {
            memberID = m.getLast().getMemberID() + 1;
        } else {
            memberID = 1;
        }

        if (club != 4) {
            cal = (n) -> switch (n) {
                case 1 -> 900;
                case 2 -> 950;
                case 3 -> 1000;
                default -> -1;
            };

            fees = cal.calculateFees(club);

            mbr = new SingleClubMember('S', memberID, name, fees, club);
            m.add(mbr);
            mem = mbr.toString();

            System.out.println("\nSTATUS: Single Club Member added\n");
        } else {
            cal = (n) -> {
                if (n == 4) {
                    return 1200;
                } else {
                    return -1;
                }
            };
            fees = cal.calculateFees(club);
            mbr = new MultiClubMember('M', memberID, name, fees, 100);
            m.add(mbr);
            mem = mbr.toString();
            System.out.println("\nSTATUS: Multi Club Member added\n");
        }
        return mem;
    }

    public void removeMember(LinkedList<Member> m) {
        int memberID;
        System.out.print("\n Please enter member's ID to remove: ");
        memberID = getIntInput();

        for (int i = 0; i < m.size(); i++) {
            if (m.get(i).getMemberID() == memberID) {
                m.remove(i);
                System.out.print("\n Member with this ID was deleted: ");
                return;
            }
        }
        System.out.print("\nMember with this ID don't find in Member's list: ");
    }

    public void printMemberInfo(LinkedList<Member> m) {
        int memberID;
        System.out.print("\nEnter Member ID to display information: ");
        memberID = getIntInput();

        for (Member member : m) {
            if (member.getMemberID() == memberID) {
                String[] memberInfo = member.toString().split(", ");

                System.out.println("Member Type = " + memberInfo[0]);
                System.out.println("Member ID = " + memberInfo[1]);
                System.out.println("Member Name = " + memberInfo[2]);
                System.out.println("Membership Fees = " + memberInfo[3]);

                if (memberInfo[0].equals("S")) {
                    System.out.println("Club ID = " + memberInfo[4]);
                } else {
                    System.out.println("Membership Points = " + memberInfo[4]);
                }
                return;
            }
        }
        System.out.println("\nMember ID not found\n");
    }

}
