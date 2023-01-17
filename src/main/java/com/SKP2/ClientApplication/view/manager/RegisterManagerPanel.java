package com.SKP2.ClientApplication.view.manager;

import com.SKP2.ClientApplication.MainFrame;
import com.SKP2.ClientApplication.dto.ManagerCreateDto;
import com.SKP2.ClientApplication.dto.ManagerDto;

import javax.swing.*;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class RegisterManagerPanel extends JPanel {
    public RegisterManagerPanel() {
        setLayout(null);

        JLabel lblUsername = new JLabel("Username:");
        lblUsername.setBounds(40, 40, 250, 30);
        JTextField tfUsername = new JTextField();
        tfUsername.setBounds(40, 70, 250, 30);

        JLabel lblPassword = new JLabel("Password:");
        lblPassword.setBounds(40, 100, 250, 30);
        JTextField tfPassword = new JTextField();
        tfPassword.setBounds(40, 130, 250, 30);

        JLabel lblEmail = new JLabel("Email:");
        lblEmail.setBounds(40, 160, 250, 30);
        JTextField tfEmail = new JTextField();
        tfEmail.setBounds(40, 190, 250, 30);

        JLabel lblPhone = new JLabel("Phone:");
        lblPhone.setBounds(40, 220, 250, 30);
        JTextField tfPhone = new JTextField();
        tfPhone.setBounds(40, 250, 250, 30);

        JLabel lblDayOfBirth = new JLabel("Day of Birth:");
        lblDayOfBirth.setBounds(40, 280, 250, 30);

        JTextField tfDayOfBirth = new JTextField();
        tfDayOfBirth.setBounds(40, 310, 250, 30);

        JLabel lblFirstName = new JLabel("First Name:");
        lblFirstName.setBounds(40, 340, 250, 30);

        JTextField tfFirstName = new JTextField();
        tfFirstName.setBounds(40, 370, 250, 30);

        JLabel lblLastName = new JLabel("Last Name:");
        lblLastName.setBounds(40, 400, 250, 30);

        JTextField tfLastName = new JTextField();
        tfLastName.setBounds(40, 430, 250, 30);

        JLabel lblCompanyName = new JLabel("Company Name:");
        lblCompanyName.setBounds(40, 460, 250, 30);

        JTextField tfCompanyName = new JTextField();
        tfCompanyName.setBounds(40, 490, 250, 30);

        JLabel lblEmploymentDay = new JLabel("Employment Day:");
        lblEmploymentDay.setBounds(40, 520, 250, 30);

        JTextField tfEmploymentDay = new JTextField();
        tfEmploymentDay.setBounds(40, 550, 250, 30);

        JButton btnRegisterManager = new JButton("Register Manager");
        btnRegisterManager.setBounds(40, 580, 250, 30);
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
        btnBack.setBounds(40, 610, 250, 30);
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
