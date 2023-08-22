package org.example;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Scanner;


public class DataManager {

    //Statiska variabler som vi kan använda i hela klassen
    static String server = "127.0.0.1";
    static int port = 21;
    static String userName = "fredrik";
    static String password = "123456";
    static String virtualPath = "/upload/";
    static String localFilePath = "src/main/resources/data.txt";
    Scanner scanner = new Scanner(System.in);

    //Metod för att skicka upp en fil till FTP-servern
    public static void uploadToFTP() {

        //Skapa ett FTP-klient objekt
        FTPClient ftpClient = new FTPClient();

        try {
            //Etablera en anslutning till FTP-servern
            ftpClient.connect(server, port);
            ftpClient.login(userName, password);

            //Gå till rätt FTP-server katalog
            ftpClient.changeWorkingDirectory(virtualPath);

            //Skicka upp .txt fil till FTP servern
            FileInputStream fis = new FileInputStream(localFilePath);
            ftpClient.storeFile("FTPdata.txt", fis);

            //Stäng anslutningen
            fis.close();
            ftpClient.logout();
            ftpClient.disconnect();

            System.out.println("File uploaded");

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //Metod för att hämta en fil från FTP-servern
    public static void fetchFromFTP() {

        //Skapa ett FTP-klient objekt
        FTPClient ftpClient = new FTPClient();

        try {
            //Etablera en anslutning till FTP-servern
            ftpClient.connect(server, port);
            ftpClient.login(userName, password);

            //Gå till rätt FTP-server katalog
            ftpClient.changeWorkingDirectory(virtualPath);

            //Hämta .txt fil från FTP servern
            FileOutputStream fos = new FileOutputStream(localFilePath);
            ftpClient.retrieveFile("FTPdata.txt", fos);


            //Stäng anslutningen
            fos.close();
            ftpClient.logout();
            ftpClient.disconnect();

            System.out.println("Anslutning stängd.");

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //Metod för att lista upp alla filer på FTP-servern
    public static void getAllFiles() {

        //Skapa ett FTP-klient objekt
        FTPClient ftpClient = new FTPClient();

        try {
            //Etablera en anslutning till FTP-servern
            ftpClient.connect(server, port);
            ftpClient.login(userName, password);

            //Gå till rätt FTP-server katalog
            ftpClient.changeWorkingDirectory(virtualPath);

            //Lista upp alla tillgängliga filer
            FTPFile[] files = ftpClient.listFiles();
            for (FTPFile file : files) {
                System.out.println("Tillgänglig fil: " + file.getName());

            }

            //Stäng anslutningen
            ftpClient.logout();
            ftpClient.disconnect();

            System.out.println("Anslutning stängd.\n");

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
