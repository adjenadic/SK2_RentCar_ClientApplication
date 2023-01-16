package com.SKP2.ClientApplication.controller;

import com.SKP2.ClientApplication.MainFrame;
import com.SKP2.ClientApplication.dto.ReviewDto;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class FindByIdController implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        MainFrame.getInstance().clearContentPanel();

        JLabel lblGet = new JLabel("Get Review By ID:");
        MainFrame.getInstance().getCurrentPanel().add(lblGet);

        JLabel lblID = new JLabel("Review ID");
        MainFrame.getInstance().getCurrentPanel().add(lblID);

        JTextField tfID = new JTextField();
        MainFrame.getInstance().getCurrentPanel().add(tfID);

        JButton btnGet = new JButton("Get");
        MainFrame.getInstance().getCurrentPanel().add(btnGet);
        btnGet.addActionListener(event -> {
            try {
                ReviewDto reviewDto = MainFrame.getInstance().getRentalService().findById(Long.parseLong(tfID.getText()));
                JOptionPane.showMessageDialog(null, "ID: " + reviewDto.getId() + "\nCompany ID: " + reviewDto.getCompanyId() + "\nRate: " + reviewDto.getRate()
                        + "\nDescription: " + reviewDto.getDesc(), "Review " + tfID.getText(), JOptionPane.INFORMATION_MESSAGE);
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
