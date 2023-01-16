package com.SKP2.ClientApplication.controller;

import com.SKP2.ClientApplication.MainFrame;
import com.SKP2.ClientApplication.dto.ModelDto;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class ModelByIdController implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        MainFrame.getInstance().clearContentPanel();

        JLabel lblGet = new JLabel("Get Model By ID");
        MainFrame.getInstance().getCurrentPanel().add(lblGet);

        JLabel lblModelID = new JLabel("Model ID");
        MainFrame.getInstance().getCurrentPanel().add(lblModelID);

        JTextField tfModelID = new JTextField();
        MainFrame.getInstance().getCurrentPanel().add(tfModelID);

        JButton btnGet = new JButton("Get");
        MainFrame.getInstance().getCurrentPanel().add(btnGet);
        btnGet.addActionListener(event -> {
            try {
                ModelDto modelDto = MainFrame.getInstance().getRentalService().getModelById(Long.parseLong(tfModelID.getText()));
                JOptionPane.showMessageDialog(null, "ID: " + modelDto.getId() + "\nName: " + modelDto.getName(), "Model " + tfModelID.getText(), JOptionPane.INFORMATION_MESSAGE);
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
