package com.SKP2.ClientApplication.view;

import com.SKP2.ClientApplication.MainFrame;
import com.SKP2.ClientApplication.dto.TokenRequestDto;
import com.SKP2.ClientApplication.dto.TokenResponseDto;
import com.SKP2.ClientApplication.token.TokenDecoder;

import javax.swing.*;
import java.io.IOException;

public class LoginPanel extends JPanel {
    public LoginPanel() {
        setLayout(null);

        JLabel lblUsername = new JLabel("Username:");
        lblUsername.setBounds(40, 40, 250, 30);

        JTextField tfUsername = new JTextField();
        tfUsername.setBounds(40, 70, 250, 30);

        JLabel lblPassword = new JLabel("Password:");
        lblPassword.setBounds(40, 100, 250, 30);

        JTextField tfPassword = new JTextField();
        tfPassword.setBounds(40, 130, 250, 30);

        JButton btnLogin = new JButton("Login");
        btnLogin.setBounds(40, 160, 250, 30);
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
        btnRegisterClient.setBounds(40, 190, 250, 30);
        btnRegisterClient.addActionListener(e -> MainFrame.getInstance().showRegisterClientPanel());

        JButton btnRegisterManager = new JButton("Register Manager");
        btnRegisterManager.setBounds(40, 220, 250, 30);
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
