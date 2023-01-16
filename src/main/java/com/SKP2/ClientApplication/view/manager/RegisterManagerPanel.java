package com.SKP2.ClientApplication.view.manager;

import com.SKP2.ClientApplication.MainFrame;
import com.SKP2.ClientApplication.dto.ManagerCreateDto;
import com.SKP2.ClientApplication.dto.ManagerDto;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class RegisterManagerPanel extends JPanel {
    public RegisterManagerPanel() {
        setLayout(new GridLayout(10, 1));

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
        JLabel lblCompanyName = new JLabel("Company Name:");
        lblCompanyName.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0));
        JTextField tfCompanyName = new JTextField();
        JLabel lblEmploymentDay = new JLabel("Employment Day:");
        lblEmploymentDay.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0));
        JTextField tfEmploymentDay = new JTextField();

        JButton btnRegisterManager = new JButton("Register Manager");
        btnRegisterManager.addActionListener(e -> {
            try {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                Date birthDate = sdf.parse(tfDayOfBirth.getText());
                java.sql.Date birthDateToSqlDate = new java.sql.Date(birthDate.getTime());
                ManagerCreateDto managerCreateDto = new ManagerCreateDto(tfUsername.getText(), tfPassword.getText(), tfEmail.getText(),
                        tfPhone.getText(), birthDateToSqlDate, tfFirstName.getText(), tfLastName.getText(), tfCompanyName.getText(),
                        tfEmploymentDay.getText());
                ManagerDto managerDto = MainFrame.getInstance().getUserService().registerManager(managerCreateDto);
                JOptionPane.showMessageDialog(null, "Manager successfully created!\nID: " + managerDto.getId() + "\nUsername: " + managerDto.getUsername() + "\nPassword: " + managerDto.getPassword()
                        + "\nEmail: " + managerDto.getEmail() + "\nDate of Birth: " + managerDto.getDayOfBirth() + "\nFirst name: " + managerDto.getFirstName() + "\nLast name: " + managerDto.getLastName()
                        + "\nCompany Name: " + managerDto.getCompanyName() + "\nEmployment Day: " + managerDto.getEmploymentDay(), "Operation successful", JOptionPane.INFORMATION_MESSAGE);
                MainFrame.getInstance().showLoginPanel();
            } catch (IOException | ParseException ex) {
                JOptionPane.showMessageDialog(null, "Manager account not created!", "Operation unsuccessful", JOptionPane.ERROR_MESSAGE);
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
        add(lblCompanyName);
        add(tfCompanyName);
        add(lblEmploymentDay);
        add(tfEmploymentDay);
        add(btnBack);
        add(btnRegisterManager);
    }
}
