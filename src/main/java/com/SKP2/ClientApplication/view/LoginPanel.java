package com.SKP2.ClientApplication.view;

import com.SKP2.ClientApplication.MainFrame;
import com.SKP2.ClientApplication.dto.TokenRequestDto;
import com.SKP2.ClientApplication.dto.TokenResponseDto;
import com.SKP2.ClientApplication.token.TokenDecoder;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class LoginPanel extends JPanel {
    public LoginPanel() {
        setLayout(new GridLayout(4, 1));

        JLabel lblUsername = new JLabel("Username:");
        lblUsername.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0));
        JLabel lblPassword = new JLabel("Password:");
        lblPassword.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0));
        JTextField tfUsername = new JTextField();
        JTextField tfPassword = new JTextField();

        JButton btnLogin = new JButton("Login");
        btnLogin.addActionListener(e -> {
            TokenRequestDto tokenRequestDto = new TokenRequestDto(tfUsername.getText(), tfPassword.getText());
            try {
                TokenResponseDto tokenResponseDto = MainFrame.getInstance().getUserService().login(tokenRequestDto);
                String token = tokenResponseDto.getToken();
                MainFrame.getInstance().setToken(token);
                MainFrame.getInstance().setActiveUser(TokenDecoder.decodeToken(token));
                String role = MainFrame.getInstance().getActiveUser().getRole();
                tfUsername.setText("");
                tfPassword.setText("");

                switch (role) {
                    case "ROLE_ADMIN":
                        MainFrame.getInstance().showAdminPanel();
                        break;
                    case "ROLE_MANAGER":
                        MainFrame.getInstance().showManagerPanel();
                        break;
                    case "ROLE_CLIENT":
                        MainFrame.getInstance().showClientPanel();
                        break;
                }
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Invalid credentials or blocked account.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        JButton btnRegisterClient = new JButton("Register Client");
        btnRegisterClient.addActionListener(e -> MainFrame.getInstance().showRegisterClientPanel());

        JButton btnRegisterManager = new JButton("Register Manager");
        btnRegisterManager.addActionListener(e -> MainFrame.getInstance().showRegisterManagerPanel());

        add(lblUsername);
        add(tfUsername);
        add(lblPassword);
        add(tfPassword);
        add(new JLabel());
        add(btnLogin);
        add(btnRegisterClient);
        add(btnRegisterManager);
    }
}
