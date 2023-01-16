package com.SKP2.ClientApplication.controller;

import com.SKP2.ClientApplication.MainFrame;
import com.SKP2.ClientApplication.dto.NotificationTypeCreateDto;
import com.SKP2.ClientApplication.dto.NotificationTypeDto;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class RegisterNotifTypeController implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        MainFrame.getInstance().clearContentPanel();

        JLabel lblAdd = new JLabel("Add Notification Type");
        MainFrame.getInstance().getCurrentPanel().add(lblAdd);

        JLabel lblName = new JLabel("Notification Name");
        MainFrame.getInstance().getCurrentPanel().add(lblName);

        JTextField tfName = new JTextField();
        MainFrame.getInstance().getCurrentPanel().add(tfName);

        JButton btnAdd = new JButton("Add");
        MainFrame.getInstance().getCurrentPanel().add(btnAdd);
        btnAdd.addActionListener(event -> {
            try {
                NotificationTypeCreateDto notificationTypeCreateDto = new NotificationTypeCreateDto(tfName.getText());
                NotificationTypeDto notificationTypeDto = MainFrame.getInstance().getNotificationService().registerNotificationType(notificationTypeCreateDto);
                JOptionPane.showMessageDialog(null, "Notification type successfully added.", "Operation successful", JOptionPane.INFORMATION_MESSAGE);
                MainFrame.getInstance().clearContentPanelAndRefresh();
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Notification type not added!", "Operation unsuccessful", JOptionPane.ERROR_MESSAGE);
            }
        });

        JButton btnCancel = new JButton("Cancel");
        MainFrame.getInstance().getCurrentPanel().add(btnCancel);
        btnCancel.addActionListener(event -> MainFrame.getInstance().clearContentPanelAndRefresh());

        MainFrame.getInstance().refresh();
    }
}
