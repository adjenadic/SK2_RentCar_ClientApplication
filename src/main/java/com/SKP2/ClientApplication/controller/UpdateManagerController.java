package com.SKP2.ClientApplication.controller;

import com.SKP2.ClientApplication.MainFrame;
import com.SKP2.ClientApplication.dto.ManagerDto;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UpdateManagerController implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        MainFrame.getInstance().clearContentPanel();

        JLabel lblUpdateManager = new JLabel("Update Manager");
        MainFrame.getInstance().getCurrentPanel().add(lblUpdateManager);

        JLabel lblID = new JLabel("ID");
        MainFrame.getInstance().getCurrentPanel().add(lblID);

        JTextField tfID = new JTextField();
        MainFrame.getInstance().getCurrentPanel().add(tfID);

        JLabel lblUsername = new JLabel("Username");
        MainFrame.getInstance().getCurrentPanel().add(lblUsername);

        JTextField tfUsername = new JTextField();
        MainFrame.getInstance().getCurrentPanel().add(tfUsername);

        JLabel lblPassword = new JLabel("Password");
        MainFrame.getInstance().getCurrentPanel().add(lblPassword);

        JTextField tfPassword = new JTextField();
        MainFrame.getInstance().getCurrentPanel().add(tfPassword);

        JLabel lblEmail = new JLabel("Email");
        MainFrame.getInstance().getCurrentPanel().add(lblEmail);

        JTextField tfEmail = new JTextField();
        MainFrame.getInstance().getCurrentPanel().add(tfEmail);

        JLabel lblPhone = new JLabel("Phone");
        MainFrame.getInstance().getCurrentPanel().add(lblPhone);

        JTextField tfPhone = new JTextField();
        MainFrame.getInstance().getCurrentPanel().add(tfPhone);

        JLabel lblDayOfBirth = new JLabel("Date of Birth");
        MainFrame.getInstance().getCurrentPanel().add(lblDayOfBirth);

        JTextField tfDayOfBirth = new JTextField();
        MainFrame.getInstance().getCurrentPanel().add(tfDayOfBirth);

        JLabel lblFirstname = new JLabel("First name");
        MainFrame.getInstance().getCurrentPanel().add(lblFirstname);

        JTextField tfFirstname = new JTextField();
        MainFrame.getInstance().getCurrentPanel().add(tfFirstname);

        JLabel lblLastname = new JLabel("Last name");
        MainFrame.getInstance().getCurrentPanel().add(lblLastname);

        JTextField tfLastname = new JTextField();
        MainFrame.getInstance().getCurrentPanel().add(tfLastname);

        JLabel lblCompanyName = new JLabel("Company name");
        MainFrame.getInstance().getCurrentPanel().add(lblCompanyName);

        JTextField tfCompanyName = new JTextField();
        MainFrame.getInstance().getCurrentPanel().add(tfCompanyName);

        JLabel lblEmploymentDay = new JLabel("Employment date");
        MainFrame.getInstance().getCurrentPanel().add(lblEmploymentDay);

        JTextField tfEmploymentDay = new JTextField();
        MainFrame.getInstance().getCurrentPanel().add(tfEmploymentDay);

        JButton btnUpdate = new JButton("Update");
        MainFrame.getInstance().getCurrentPanel().add(btnUpdate);
        btnUpdate.addActionListener(event -> {
            try {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                Date birthDate = sdf.parse(tfDayOfBirth.getText());
                java.sql.Date birthDateToSqlDate = new java.sql.Date(birthDate.getTime());
                ManagerDto managerDto = new ManagerDto(Long.parseLong(tfID.getText()), tfUsername.getText(), tfPassword.getText(), tfEmail.getText(), tfPhone.getText(),
                        birthDateToSqlDate, tfFirstname.getText(), tfLastname.getText(), tfCompanyName.getText(), tfEmploymentDay.getText());
                ManagerDto updateManagerDto = MainFrame.getInstance().getUserService().updateManager(managerDto);
                JOptionPane.showMessageDialog(null, "Manager successfully updated.\nID: " + updateManagerDto.getId() + "\nUsername: " + updateManagerDto.getUsername() + "\nPassword: " + updateManagerDto.getPassword()
                        + "\nEmail: " + updateManagerDto.getEmail() + "\nDate of Birth: " + updateManagerDto.getDayOfBirth() + "\nFirst name: " + updateManagerDto.getFirstName() + "\nLast name: " + updateManagerDto.getLastName()
                        + "\nCompany name: " + updateManagerDto.getCompanyName() + "\nEmployment day: " + updateManagerDto.getEmploymentDay(), "Operation successful", JOptionPane.INFORMATION_MESSAGE);
                MainFrame.getInstance().clearContentPanelAndRefresh();
            } catch (IOException | ParseException ex) {
                JOptionPane.showMessageDialog(null, "Manager account not updated!", "Operation unsuccessful", JOptionPane.ERROR_MESSAGE);
            }
        });

        JButton btnCancel = new JButton("Cancel");
        MainFrame.getInstance().getCurrentPanel().add(btnCancel);
        btnCancel.addActionListener(event -> MainFrame.getInstance().clearContentPanelAndRefresh());

        MainFrame.getInstance().refresh();
    }
}
