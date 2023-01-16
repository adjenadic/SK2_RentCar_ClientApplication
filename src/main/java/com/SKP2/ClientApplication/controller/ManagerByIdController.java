package com.SKP2.ClientApplication.controller;

import com.SKP2.ClientApplication.MainFrame;
import com.SKP2.ClientApplication.dto.ManagerDto;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class ManagerByIdController implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        MainFrame.getInstance().clearContentPanel();

        JLabel lblGet = new JLabel("Get Manager By ID:");
        MainFrame.getInstance().getCurrentPanel().add(lblGet);

        JLabel lblManagerID = new JLabel("Manager ID");
        MainFrame.getInstance().getCurrentPanel().add(lblManagerID);

        JTextField tfManagerID = new JTextField();
        MainFrame.getInstance().getCurrentPanel().add(tfManagerID);

        JButton btnGet = new JButton("Get");
        MainFrame.getInstance().getCurrentPanel().add(btnGet);
        btnGet.addActionListener(event -> {
            try {
                ManagerDto managerDto = MainFrame.getInstance().getUserService().getManagerById(Long.parseLong(tfManagerID.getText()));
                JOptionPane.showMessageDialog(null, "ID: " + managerDto.getId() + "\nUsername: " + managerDto.getUsername() + "\nPassword: " + managerDto.getPassword()
                        + "\nEmail: " + managerDto.getEmail() + "\nDate of Birth: " + managerDto.getDayOfBirth() + "\nFirst name: " + managerDto.getFirstName() + "\nLast name: " + managerDto.getLastName()
                        + "\nCompany name: " + managerDto.getCompanyName() + "\nEmployment day: " + managerDto.getEmploymentDay(), "Manager " + tfManagerID.getText(), JOptionPane.INFORMATION_MESSAGE);
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
