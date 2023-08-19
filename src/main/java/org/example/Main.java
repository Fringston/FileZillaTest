package org.example;

import org.apache.commons.net.ftp.FTPClient;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;



public class Main {
    public static void main(String[] args) throws IOException {

        //Anropa metod
        //uploadToFTP();
        fetchFromFTP();

    }

    static String server = "127.0.0.1";
    static int port = 21;
    static String userName = "fredrik";
    static String password = "123456";
    static String virtualPath = "/upload/";
    static String localFilePath = "src/main/resources/data.txt";


    static void uploadToFTP() {

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

        static void fetchFromFTP() {
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

                //Stänga anslutningen
                fos.close();
                ftpClient.logout();
                ftpClient.disconnect();

                System.out.println("File uploaded");

            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }