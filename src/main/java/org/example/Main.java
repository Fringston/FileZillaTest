package org.example;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;


public class Main {
    public static void main(String[] args) throws IOException {

        //Instansiera klasser
        DataManager dataManager = new DataManager();
        Menu menu = new Menu();
        menu.displayMenu();

    }
}

