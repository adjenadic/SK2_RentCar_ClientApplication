package com.SKP2.ClientApplication.controller;

import com.SKP2.ClientApplication.MainFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class VerificationEmailController implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        MainFrame.getInstance().clearContentPanel();

        JLabel lblVerify = new JLabel("Verify Email");
        MainFrame.getInstance().getCurrentPanel().add(lblVerify);

        JLabel lblVerification = new JLabel("Verification Text");
        MainFrame.getInstance().getCurrentPanel().add(lblVerification);

        JTextField tfVerification = new JTextField();
        MainFrame.getInstance().getCurrentPanel().add(tfVerification);

        JButton btnVerify = new JButton("Verify");
        MainFrame.getInstance().getCurrentPanel().add(btnVerify);
        btnVerify.addActionListener(event -> {
            try {
                if (MainFrame.getInstance().getUserService().verificationEmail(tfVerification.getText())) {
                    JOptionPane.showMessageDialog(null, "Client " + tfVerification.getText() + " successfully verified.", "Operation successful", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Client " + tfVerification.getText() + " has not been verified due to an error.", "Operation unsuccessful", JOptionPane.ERROR_MESSAGE);
                }
                MainFrame.getInstance().clearContentPanelAndRefresh();
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "User has not been verified!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        JButton btnBack = new JButton("Back");
        btnBack.addActionListener(event -> MainFrame.getInstance().clearContentPanelAndRefresh());
        MainFrame.getInstance().getCurrentPanel().add(btnBack);

        MainFrame.getInstance().refresh();
    }
}