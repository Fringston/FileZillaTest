package org.example;

import java.util.Scanner;

public class Menu {

    static Scanner scanner = new Scanner(System.in);
    boolean run = true;

    public void displayMenu() {
        while (run) {
                System.out.println("\n1. Upload file to FTP server");
                System.out.println("2. Download file from FTP server");
                System.out.println("3. Show all files on FTP server");
                System.out.println("4. Exit");
                System.out.println("\nEnter your choice: ");

                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        System.out.printf("Uploading file to FTP server...");
                        uploadToFTP();
                        break;
                    case 2:
                        System.out.println("Downloading file from FTP server...");
                        fetchFromFTP();
                        break;
                    case 3:
                        System.out.println("Showing all files on FTP server...");
                        getAllFiles();
                        break;
                    case 4:
                        System.out.println("Exiting...");
                        run = false;
                    default:
                        System.out.println("Invalid choice");
                }
        }
    }

    static void uploadToFTP() {
        System.out.println("Enter file name: ");
        String fileNameChoice = scanner.next();
    }
}