package com.SKP2.ClientApplication.controller;

import com.SKP2.ClientApplication.MainFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class ForbidController implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        MainFrame.getInstance().clearContentPanel();

        JLabel lblBlock = new JLabel("Forbid a User Account:");
        MainFrame.getInstance().getCurrentPanel().add(lblBlock);

        JLabel lblUserID = new JLabel("User ID");
        MainFrame.getInstance().getCurrentPanel().add(lblUserID);

        JTextField tfUserID = new JTextField();
        MainFrame.getInstance().getCurrentPanel().add(tfUserID);

        JButton btnBlock = new JButton("Block");
        MainFrame.getInstance().getCurrentPanel().add(btnBlock);
        btnBlock.addActionListener(event -> {
            try {
                if (MainFrame.getInstance().getUserService().forbid(Long.parseLong(tfUserID.getText()))) {
                    JOptionPane.showMessageDialog(null, "Client " + tfUserID.getText() + " successfully deleted.", "Operation successful", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Client " + tfUserID.getText() + " has not been deleted due to an error.", "Operation unsuccessful", JOptionPane.ERROR_MESSAGE);
                }
                MainFrame.getInstance().clearContentPanelAndRefresh();
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "User has not been blocked!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        JButton btnBack = new JButton("Back");
        btnBack.addActionListener(event -> MainFrame.getInstance().clearContentPanelAndRefresh());
        MainFrame.getInstance().getCurrentPanel().add(btnBack);

        MainFrame.getInstance().refresh();
    }
}