package com.SKP2.ClientApplication.controller;

import com.SKP2.ClientApplication.MainFrame;
import com.SKP2.ClientApplication.dto.TypeDto;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class UpdateTypeController implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        MainFrame.getInstance().clearContentPanel();

        JLabel lblUpdate = new JLabel("Update Type");
        MainFrame.getInstance().getCurrentPanel().add(lblUpdate);

        JLabel lblID = new JLabel("ID");
        MainFrame.getInstance().getCurrentPanel().add(lblID);

        JTextField tfID = new JTextField();
        MainFrame.getInstance().getCurrentPanel().add(tfID);

        JLabel lblTypeName = new JLabel("Type Name");
        MainFrame.getInstance().getCurrentPanel().add(lblTypeName);

        JTextField tfTypeName = new JTextField();
        MainFrame.getInstance().getCurrentPanel().add(tfTypeName);

        JButton btnUpdate = new JButton("Update");
        MainFrame.getInstance().getCurrentPanel().add(btnUpdate);
        btnUpdate.addActionListener(event -> {
            try {
                TypeDto typeDto = new TypeDto(Long.parseLong(tfID.getText()), tfTypeName.getText());
                TypeDto updatedTypeDto = MainFrame.getInstance().getRentalService().updateType(typeDto);
                JOptionPane.showMessageDialog(null, "Type " + updatedTypeDto.getId() + " successfully updated.", "Operation successful", JOptionPane.INFORMATION_MESSAGE);
                MainFrame.getInstance().clearContentPanelAndRefresh();
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Type not updated!", "Operation unsuccessful", JOptionPane.ERROR_MESSAGE);
            }
        });

        JButton btnCancel = new JButton("Cancel");
        MainFrame.getInstance().getCurrentPanel().add(btnCancel);
        btnCancel.addActionListener(event -> MainFrame.getInstance().clearContentPanelAndRefresh());

        MainFrame.getInstance().refresh();
    }
}
