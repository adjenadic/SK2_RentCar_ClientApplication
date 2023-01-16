package com.SKP2.ClientApplication.controller;

import com.SKP2.ClientApplication.MainFrame;
import com.SKP2.ClientApplication.dto.AdminDto;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UpdateAdminController implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        MainFrame.getInstance().clearContentPanel();

        JLabel lblUpdateAdmin = new JLabel("Update Admin");
        MainFrame.getInstance().getCurrentPanel().add(lblUpdateAdmin);

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

        JButton btnUpdate = new JButton("Update");
        MainFrame.getInstance().getCurrentPanel().add(btnUpdate);
        btnUpdate.addActionListener(event -> {
            try {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                Date birthDate = sdf.parse(tfDayOfBirth.getText());
                java.sql.Date birthDateToSqlDate = new java.sql.Date(birthDate.getTime());
                AdminDto adminDto = new AdminDto(Long.parseLong(tfID.getText()), tfUsername.getText(), tfPassword.getText(), tfEmail.getText(), tfPhone.getText(),
                        birthDateToSqlDate, tfFirstname.getText(), tfLastname.getText());
                AdminDto updatedAdminDto = MainFrame.getInstance().getUserService().updateAdmin(adminDto);
                JOptionPane.showMessageDialog(null, "Admin successfully updated.\nID: " + updatedAdminDto.getId() + "\nUsername: " + updatedAdminDto.getUsername() + "\nPassword: " + updatedAdminDto.getPassword()
                        + "\nEmail: " + updatedAdminDto.getEmail() + "\nDate of Birth: " + updatedAdminDto.getDayOfBirth() + "\nFirst name: " + updatedAdminDto.getFirstName() + "\nLast name: " + updatedAdminDto.getLastName(), "Operation successful", JOptionPane.INFORMATION_MESSAGE);
                MainFrame.getInstance().clearContentPanelAndRefresh();
            } catch (IOException | ParseException ex) {
                JOptionPane.showMessageDialog(null, "Admin account not updated!", "Operation unsuccessful", JOptionPane.ERROR_MESSAGE);
            }
        });

        JButton btnCancel = new JButton("Cancel");
        MainFrame.getInstance().getCurrentPanel().add(btnCancel);
        btnCancel.addActionListener(event -> MainFrame.getInstance().clearContentPanelAndRefresh());

        MainFrame.getInstance().refresh();
    }
}
