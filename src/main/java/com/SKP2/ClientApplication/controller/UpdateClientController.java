package com.SKP2.ClientApplication.controller;

import com.SKP2.ClientApplication.MainFrame;
import com.SKP2.ClientApplication.dto.ClientDto;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UpdateClientController implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        MainFrame.getInstance().clearContentPanel();

        JLabel lblUpdateClient = new JLabel("Update Client");
        MainFrame.getInstance().getCurrentPanel().add(lblUpdateClient);

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

        JLabel lblPassport = new JLabel("Passport");
        MainFrame.getInstance().getCurrentPanel().add(lblPassport);

        JTextField tfPassport = new JTextField();
        MainFrame.getInstance().getCurrentPanel().add(tfPassport);

        JButton btnUpdate = new JButton("Update");
        MainFrame.getInstance().getCurrentPanel().add(btnUpdate);
        btnUpdate.addActionListener(event -> {
            try {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                Date birthDate = sdf.parse(tfDayOfBirth.getText());
                java.sql.Date birthDateToSqlDate = new java.sql.Date(birthDate.getTime());
                ClientDto clientDto = new ClientDto(Long.parseLong(tfID.getText()), tfUsername.getText(), tfPassword.getText(), tfEmail.getText(), tfPhone.getText(),
                        birthDateToSqlDate, tfFirstname.getText(), tfLastname.getText(), tfPassport.getText());
                ClientDto updatedClientDto = MainFrame.getInstance().getUserService().updateClient(clientDto);
                JOptionPane.showMessageDialog(null, "Client successfully updated.\nID: " + updatedClientDto.getId() + "\nUsername: " + updatedClientDto.getUsername() + "\nPassword: " + updatedClientDto.getPassword()
                        + "\nEmail: " + updatedClientDto.getEmail() + "\nDate of Birth: " + updatedClientDto.getDayOfBirth() + "\nFirst name: " + updatedClientDto.getFirstName() + "\nLast name: " + updatedClientDto.getLastName()
                        + "\nPassport: " + updatedClientDto.getPassport(), "Operation successful", JOptionPane.INFORMATION_MESSAGE);
                MainFrame.getInstance().clearContentPanelAndRefresh();
            } catch (IOException | ParseException ex) {
                JOptionPane.showMessageDialog(null, "Client account not updated!", "Operation unsuccessful", JOptionPane.ERROR_MESSAGE);
            }
        });

        JButton btnCancel = new JButton("Cancel");
        MainFrame.getInstance().getCurrentPanel().add(btnCancel);
        btnCancel.addActionListener(event -> MainFrame.getInstance().clearContentPanelAndRefresh());

        MainFrame.getInstance().refresh();
    }
}
