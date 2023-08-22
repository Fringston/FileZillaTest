package org.example;
import org.apache.commons.net.ftp.FTPClient;

import java.util.Scanner;

public class Menu {

    private DataManager datamanager;
    static Scanner scanner = new Scanner(System.in);
    boolean run = true;


    public Menu() {
       DataManager datamanager = new DataManager();
    }

    public void displayMenu() {
        while (run) {
                System.out.println("\n1. Upload file to FTP server");
                System.out.println("2. Download file from FTP server");
                System.out.println("3. Show all files on FTP server");
                System.out.println("4. Change name of file on FTP server");
                System.out.println("5. Change content on file");
                System.out.println("6. Exit");
                System.out.println("\nEnter your choice: ");

                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        System.out.println("What file would you like to upload? It must be an existing file.");
                        String fileToUpload = scanner.nextLine();
                        datamanager.uploadToFTP(fileToUpload);
                        if (fileToUpload exists() {
                        System.out.println("Uploading successfull!"); }
                        else {
                            System.out.println("File does not exist!");
                        }
                        break;
                    case 2:
                        System.out.println("What file would you like to download?");
                        String fileToDownload = scanner.nextLine();
                        System.out.println("Downloading " + fileToDownload + " from FTP server...");
                        break;
                    case 3:
                        System.out.println("Showing all files on FTP server...");

                        break;
                        case 4:
                            System.out.println("What file do you want to change name on?");
                            String fileName = scanner.nextLine();
                            if (fileName.equals("")){
                                fileName = scanner.nextLine();
                            }
                        System.out.println("What do you want to change the name to?");
                        String newName = scanner.nextLine();
                        break;
                    case 5:
                        System.out.println("What file do you want to change content on?");
                        System.out.println("What do you want to change the content to?");
                        break;
                    case 6:
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