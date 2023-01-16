package com.SKP2.ClientApplication.controller;

import com.SKP2.ClientApplication.MainFrame;
import com.SKP2.ClientApplication.dto.ClientDto;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class ClientByIdController implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        MainFrame.getInstance().clearContentPanel();

        JLabel lblGet = new JLabel("Get Client By ID:");
        MainFrame.getInstance().getCurrentPanel().add(lblGet);

        JLabel lblUserID = new JLabel("User ID");
        MainFrame.getInstance().getCurrentPanel().add(lblUserID);

        JTextField tfUserID = new JTextField();
        MainFrame.getInstance().getCurrentPanel().add(tfUserID);

        JButton btnGet = new JButton("Get");
        MainFrame.getInstance().getCurrentPanel().add(btnGet);
        btnGet.addActionListener(event -> {
            try {
                ClientDto clientDto = MainFrame.getInstance().getUserService().getClientById(Long.parseLong(tfUserID.getText()));
                JOptionPane.showMessageDialog(null, "ID: " + clientDto.getId() + "\nUsername: " + clientDto.getUsername() + "\nPassword: " + clientDto.getPassword()
                        + "\nEmail: " + clientDto.getEmail() + "\nDate of Birth: " + clientDto.getDayOfBirth() + "\nFirst name: " + clientDto.getFirstName() + "\nLast name: " + clientDto.getLastName()
                        + "\nPassport: " + clientDto.getPassport(), "Client " + tfUserID.getText(), JOptionPane.INFORMATION_MESSAGE);
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
