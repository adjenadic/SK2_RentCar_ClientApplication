package com.SKP2.ClientApplication.controller;

import com.SKP2.ClientApplication.MainFrame;
import com.SKP2.ClientApplication.dto.TypeDto;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class TypeByIdController implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        MainFrame.getInstance().clearContentPanel();

        JLabel lblGet = new JLabel("Get Type By ID");
        MainFrame.getInstance().getCurrentPanel().add(lblGet);

        JLabel lblTypeID = new JLabel("Type ID");
        MainFrame.getInstance().getCurrentPanel().add(lblTypeID);

        JTextField tfTypeID = new JTextField();
        MainFrame.getInstance().getCurrentPanel().add(tfTypeID);

        JButton btnGet = new JButton("Get");
        MainFrame.getInstance().getCurrentPanel().add(btnGet);
        btnGet.addActionListener(event -> {
            try {
                TypeDto typeDto = MainFrame.getInstance().getRentalService().getTypeById(Long.parseLong(tfTypeID.getText()));
                JOptionPane.showMessageDialog(null, "ID: " + typeDto.getId() + "\nName: " + typeDto.getName(), "Type " + tfTypeID.getText(), JOptionPane.INFORMATION_MESSAGE);
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
