package com.SKP2.ClientApplication;

import com.SKP2.ClientApplication.dto.UserDto;
import com.SKP2.ClientApplication.rest.NotificationService;
import com.SKP2.ClientApplication.rest.RentalService;
import com.SKP2.ClientApplication.rest.UserService;
import com.SKP2.ClientApplication.token.TokenDecoder;
import com.SKP2.ClientApplication.view.LoginPanel;
import com.SKP2.ClientApplication.view.admin.AdminPanel;
import com.SKP2.ClientApplication.view.client.ClientPanel;
import com.SKP2.ClientApplication.view.client.RegisterClientPanel;
import com.SKP2.ClientApplication.view.manager.ManagerPanel;
import com.SKP2.ClientApplication.view.manager.RegisterManagerPanel;
import lombok.Getter;
import lombok.Setter;

import javax.swing.*;

@Getter
@Setter
public class MainFrame extends JFrame {
    private static MainFrame instance = null;
    private String token;
    private UserDto activeUser;
    private TokenDecoder tokenDecoder;

    private UserService userService;
    private RentalService rentalService;
    private NotificationService notificationService;

    private JPanel currentPanel = null;
    private JPanel registerManagerPanel;
    private JPanel registerClientPanel;
    private JPanel loginPanel;
    private JPanel adminPanel;
    private JPanel managerPanel;
    private JPanel clientPanel;

    public MainFrame() {
        setTitle("SK_Project2");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1024, 768);
        setResizable(false);

        tokenDecoder = new TokenDecoder();
        userService = new UserService();
        rentalService = new RentalService();
        notificationService = new NotificationService();

        registerManagerPanel = new RegisterManagerPanel();
        registerClientPanel = new RegisterClientPanel();
        loginPanel = new LoginPanel();
        adminPanel = new AdminPanel();
        managerPanel = new ManagerPanel();
        clientPanel = new ClientPanel();

        showLoginPanel();
    }

    public static MainFrame getInstance() {
        if (instance == null) {
            instance = new MainFrame();
        }
        return instance;
    }

    public void showRegisterManagerPanel() {
        currentPanel = registerManagerPanel;
        this.getContentPane().setVisible(false);
        this.getContentPane().removeAll();
        this.getContentPane().add(registerManagerPanel);
        this.getContentPane().setVisible(true);
    }

    public void showRegisterClientPanel() {
        currentPanel = registerClientPanel;
        this.getContentPane().setVisible(false);
        this.getContentPane().removeAll();
        this.getContentPane().add(registerClientPanel);
        this.getContentPane().setVisible(true);
    }

    public void showLoginPanel() {
        currentPanel = loginPanel;
        this.getContentPane().setVisible(false);
        this.getContentPane().removeAll();
        this.getContentPane().add(loginPanel);
        this.getContentPane().setVisible(true);
    }

    public void showAdminPanel() {
        currentPanel = adminPanel;
        this.getContentPane().setVisible(false);
        this.getContentPane().removeAll();
        this.getContentPane().add(adminPanel);
        this.getContentPane().setVisible(true);
    }

    public void showManagerPanel() {
        currentPanel = managerPanel;
        this.getContentPane().setVisible(false);
        this.getContentPane().removeAll();
        this.getContentPane().add(managerPanel);
        this.getContentPane().setVisible(true);
    }

    public void showClientPanel() {
        currentPanel = clientPanel;
        this.getContentPane().setVisible(false);
        this.getContentPane().removeAll();
        this.getContentPane().add(clientPanel);
        this.getContentPane().setVisible(true);
    }

    public void refresh() {
        this.getContentPane().setVisible(false);
        this.getContentPane().removeAll();
        this.getContentPane().add(currentPanel);
        this.getContentPane().setVisible(true);
    }

    public void clearContentPanel() {
        currentPanel.removeAll();
    }

    public void clearContentPanelAndRefresh() {
        currentPanel.removeAll();
        this.getContentPane().setVisible(false);
        this.getContentPane().removeAll();
        this.getContentPane().add(currentPanel);
        this.getContentPane().setVisible(true);
    }
}