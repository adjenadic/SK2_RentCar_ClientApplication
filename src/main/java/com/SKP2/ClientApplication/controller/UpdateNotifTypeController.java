package com.SKP2.ClientApplication.controller;

import com.SKP2.ClientApplication.MainFrame;
import com.SKP2.ClientApplication.dto.NotificationTypeDto;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class UpdateNotifTypeController implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        MainFrame.getInstance().clearContentPanel();

        JLabel lblUpdate = new JLabel("Update Notification Type");
        MainFrame.getInstance().getCurrentPanel().add(lblUpdate);

        JLabel lblID = new JLabel("ID");
        MainFrame.getInstance().getCurrentPanel().add(lblID);

        JTextField tfID = new JTextField();
        MainFrame.getInstance().getCurrentPanel().add(tfID);

        JLabel lblName = new JLabel("Name");
        MainFrame.getInstance().getCurrentPanel().add(lblName);

        JTextField tfName = new JTextField();
        MainFrame.getInstance().getCurrentPanel().add(tfName);

        JButton btnUpdate = new JButton("Update");
        MainFrame.getInstance().getCurrentPanel().add(btnUpdate);
        btnUpdate.addActionListener(event -> {
            try {
                NotificationTypeDto notificationTypeDto = new NotificationTypeDto(Long.parseLong(tfID.getText()), tfName.getText());
                NotificationTypeDto updatedNotificationTypeDto = MainFrame.getInstance().getNotificationService().updateNotificationType(notificationTypeDto);
                JOptionPane.showMessageDialog(null, "Notification Type " + updatedNotificationTypeDto.getId() + " successfully updated.", "Operation successful", JOptionPane.INFORMATION_MESSAGE);
                MainFrame.getInstance().clearContentPanelAndRefresh();
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Notification Type not updated!", "Operation unsuccessful", JOptionPane.ERROR_MESSAGE);
            }
        });

        JButton btnCancel = new JButton("Cancel");
        MainFrame.getInstance().getCurrentPanel().add(btnCancel);
        btnCancel.addActionListener(event -> MainFrame.getInstance().clearContentPanelAndRefresh());

        MainFrame.getInstance().refresh();
    }
}
