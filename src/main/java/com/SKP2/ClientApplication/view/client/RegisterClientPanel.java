package com.SKP2.ClientApplication.view.client;

import com.SKP2.ClientApplication.MainFrame;
import com.SKP2.ClientApplication.dto.ClientCreateDto;
import com.SKP2.ClientApplication.dto.ClientDto;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class RegisterClientPanel extends JPanel {
    public RegisterClientPanel() {
        setLayout(new GridLayout(9, 1));

        JLabel lblUsername = new JLabel("Username:");
        lblUsername.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0));
        JTextField tfUsername = new JTextField();
        JLabel lblPassword = new JLabel("Password:");
        lblPassword.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0));
        JTextField tfPassword = new JTextField();
        JLabel lblEmail = new JLabel("Email:");
        lblEmail.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0));
        JTextField tfEmail = new JTextField();
        JLabel lblPhone = new JLabel("Phone:");
        lblPhone.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0));
        JTextField tfPhone = new JTextField();
        JLabel lblDayOfBirth = new JLabel("Day of Birth:");
        lblDayOfBirth.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0));
        JTextField tfDayOfBirth = new JTextField();
        JLabel lblFirstName = new JLabel("First Name:");
        lblFirstName.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0));
        JTextField tfFirstName = new JTextField();
        JLabel lblLastName = new JLabel("Last Name:");
        lblLastName.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0));
        JTextField tfLastName = new JTextField();
        JLabel lblPassport = new JLabel("Passport:");
        lblPassport.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0));
        JTextField tfPassport = new JTextField();

        JButton btnRegisterClient = new JButton("Register Client");
        btnRegisterClient.addActionListener(e -> {
            try {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                Date birthDate = sdf.parse(tfDayOfBirth.getText());
                java.sql.Date birthDateToSqlDate = new java.sql.Date(birthDate.getTime());
                ClientCreateDto clientCreateDto = new ClientCreateDto(tfUsername.getText(), tfPassword.getText(), tfEmail.getText(),
                        tfPhone.getText(), birthDateToSqlDate, tfFirstName.getText(), tfLastName.getText(), tfPassport.getText());
                ClientDto clientDto = MainFrame.getInstance().getUserService().registerClient(clientCreateDto);
                JOptionPane.showMessageDialog(null, "Client successfully created!\nID: " + clientDto.getId() + "\nUsername: " + clientDto.getUsername() + "\nPassword: " + clientDto.getPassword()
                        + "\nEmail: " + clientDto.getEmail() + "\nDate of Birth: " + clientDto.getDayOfBirth() + "\nFirst name: " + clientDto.getFirstName() + "\nLast name: " + clientDto.getLastName()
                        + "\nPassport: " + clientDto.getPassport(), "Operation successful", JOptionPane.INFORMATION_MESSAGE);
                MainFrame.getInstance().showLoginPanel();
            } catch (IOException | ParseException ex) {
                JOptionPane.showMessageDialog(null, "Client account not created!", "Operation unsuccessful", JOptionPane.ERROR_MESSAGE);
            }
        });
        JButton btnBack = new JButton("Back");
        btnBack.addActionListener(e -> MainFrame.getInstance().showLoginPanel());

        add(lblUsername);
        add(tfUsername);
        add(lblPassword);
        add(tfPassword);
        add(lblEmail);
        add(tfEmail);
        add(lblPhone);
        add(tfPhone);
        add(lblDayOfBirth);
        add(tfDayOfBirth);
        add(lblFirstName);
        add(tfFirstName);
        add(lblLastName);
        add(tfLastName);
        add(lblPassport);
        add(tfPassport);
        add(btnBack);
        add(btnRegisterClient);
    }
}
