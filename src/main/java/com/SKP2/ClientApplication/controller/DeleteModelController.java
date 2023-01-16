package com.SKP2.ClientApplication.controller;

import com.SKP2.ClientApplication.MainFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class DeleteModelController implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        MainFrame.getInstance().clearContentPanel();

        JLabel lblDeleteID = new JLabel("Delete ID:");
        MainFrame.getInstance().getCurrentPanel().add(lblDeleteID);

        JLabel lblID = new JLabel("Model ID");
        MainFrame.getInstance().getCurrentPanel().add(lblID);

        JTextField tfID = new JTextField();
        MainFrame.getInstance().getCurrentPanel().add(tfID);

        JButton btnDelete = new JButton("Delete");
        MainFrame.getInstance().getCurrentPanel().add(btnDelete);
        btnDelete.addActionListener(event -> {
            try {
                if (MainFrame.getInstance().getRentalService().deleteModel(Long.parseLong(tfID.getText()))) {
                    JOptionPane.showMessageDialog(null, "Model " + tfID.getText() + " successfully deleted.", "Operation successful", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Model " + tfID.getText() + " has not been deleted due to an error.", "Operation unsuccessful", JOptionPane.ERROR_MESSAGE);
                }
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
