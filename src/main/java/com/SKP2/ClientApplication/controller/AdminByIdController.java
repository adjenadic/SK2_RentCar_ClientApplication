package com.SKP2.ClientApplication.controller;

import com.SKP2.ClientApplication.MainFrame;
import com.SKP2.ClientApplication.dto.AdminDto;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class AdminByIdController implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        MainFrame.getInstance().clearContentPanel();

        JLabel lblGet = new JLabel("Get Admin By ID");
        MainFrame.getInstance().getCurrentPanel().add(lblGet);

        JLabel lblAdminID = new JLabel("Admin ID");
        MainFrame.getInstance().getCurrentPanel().add(lblAdminID);

        JTextField tfAdminID = new JTextField();
        MainFrame.getInstance().getCurrentPanel().add(tfAdminID);

        JButton btnGet = new JButton("Get");
        MainFrame.getInstance().getCurrentPanel().add(btnGet);
        btnGet.addActionListener(event -> {
            try {
                AdminDto adminDto = MainFrame.getInstance().getUserService().getAdminById(Long.parseLong(tfAdminID.getText()));
                JOptionPane.showMessageDialog(null, "ID: " + adminDto.getId() + "\nUsername: " + adminDto.getUsername() + "\nPassword: " + adminDto.getPassword()
                        + "\nEmail: " + adminDto.getEmail() + "\nDate of Birth: " + adminDto.getDayOfBirth() + "\nFirst name: " + adminDto.getFirstName() + "\nLast name: " + adminDto.getLastName(), "Admin " + tfAdminID.getText(), JOptionPane.INFORMATION_MESSAGE);
                MainFrame.getInstance().clearContentPanelAndRefresh();
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "An error has occurred!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        JButton btnBack = new JButton("Back");
        btnBack.addActionListener(event -> MainFrame.getInstance().clearContentPanelAndRefresh());
        MainFrame.getInstance().getCurrentPanel().add(btnBack);

        MainFrame.getInstance().refresh();
    }
}
