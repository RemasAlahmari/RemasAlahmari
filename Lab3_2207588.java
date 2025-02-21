package labs.lab3_2207588;

import java.io.*;
import java.util.Scanner;

public class Lab3_2207588 {

    public static void main(String[] args) throws Exception {
        File File1 = new File("File1.txt");
        File File2 = new File("File2.txt");
        File FinalFile = new File("File1-File2.txt");
        int[] counter = new int[26];

        if (!File1.exists()) {
            System.out.println("The file <" + File1.getName() + "> is not found.\nCheck " + File1.getAbsolutePath());
            System.exit(0);
        }

        if (!File2.exists()) {
            System.out.println("The file <" + File2.getName() + "> is not found.");
            System.out.println("Check " + File2.getAbsolutePath());
            System.exit(0);
        }

        Scanner Fileinput1 = new Scanner(File1);
        Scanner Fileinput2 = new Scanner(File2);

        PrintWriter OutputFile = new PrintWriter(FinalFile);

        while (Fileinput1.hasNext() && Fileinput2.hasNext()) {

            String firstName = Fileinput1.nextLine();

            String LastName = Fileinput2.nextLine();

            String fullName = firstName + " " + LastName;

            String fullNameWithoutSpace = firstName + LastName;

            System.out.println(fullName);
            
            OutputFile.println(fullName);

            for (int i = 0; i < fullNameWithoutSpace.length(); i++) {

                char letter = fullNameWithoutSpace.charAt(i);

                letter = Character.toUpperCase(letter);

                counter[letter - 'A']++;

            }

        }
        
        for (int i = 0; i <counter.length; i++) {
            char c = (char)(65+i);
            System.out.println(c+"'s = "+counter[i]);
        }
        
        OutputFile.flush();
        
        OutputFile.close();

    }
}
