package com.timnab.fintess_center;

import java.util.LinkedList;
import java.io.*;

public class FileHandler {

    LinkedList<Member> readFile() {
        LinkedList<Member> members = new LinkedList<>();
        String lineRead;
        String[] splitLine;
        Member member;

        try (BufferedReader reader = new BufferedReader(new FileReader("members.csv"))) {
            lineRead = reader.readLine();

            while (lineRead != null) {
                splitLine = lineRead.split(", ");

                if (splitLine[0].equals("S")) {
                    member = new SingleClubMember('S', Integer.parseInt(splitLine[1]), splitLine[2],
                            Double.parseDouble(splitLine[3]), Integer.parseInt(splitLine[4]));
                    members.add(member);
                } else {
                    member = new MultiClubMember('M', Integer.parseInt(splitLine[1]), splitLine[2],
                            Double.parseDouble(splitLine[3]), Integer.parseInt(splitLine[4]));
                    members.add(member);
                }
            }
        } catch (IOException e) {
            System.out.println(e);
        }
        return members;
    }

    void appendFile(String member) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("members.csv", true))) {
            writer.write(member + "\n");
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    void overwriteFile(LinkedList<Member> member) {
        String s;

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("members.temp", false))) {
            for (int i = 0; i < member.size(); i++) {
                s = member.get(i).toString();
                writer.write(s + "\n");
            }

            try {
                File pathToDelOldFile = new File("members.csv");
                File pathToRenameFile = new File("members.temp");
                pathToDelOldFile.delete();
                pathToRenameFile.renameTo(new File("members.csv"));
            } catch (Exception e) {
                System.out.println(e);
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }

}
