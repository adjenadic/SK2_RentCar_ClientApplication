package com.SKP2.ClientApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ClientApplication {
    public static void main(String[] args) {
        MainFrame mainFrame = MainFrame.getInstance();
        mainFrame.setVisible(true);
    }
}
