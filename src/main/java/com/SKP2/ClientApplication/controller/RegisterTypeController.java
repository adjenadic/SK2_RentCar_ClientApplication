package com.SKP2.ClientApplication.controller;

import com.SKP2.ClientApplication.MainFrame;
import com.SKP2.ClientApplication.dto.TypeCreateDto;
import com.SKP2.ClientApplication.dto.TypeDto;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class RegisterTypeController implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        MainFrame.getInstance().clearContentPanel();

        JLabel lblRegisterType = new JLabel("Register Type");
        MainFrame.getInstance().getCurrentPanel().add(lblRegisterType);

        JLabel lblTypeName = new JLabel("Type Name");
        MainFrame.getInstance().getCurrentPanel().add(lblTypeName);

        JTextField tfTypeName = new JTextField();
        MainFrame.getInstance().getCurrentPanel().add(tfTypeName);

        JButton btnRegister = new JButton("Register");
        MainFrame.getInstance().getCurrentPanel().add(btnRegister);
        btnRegister.addActionListener(event -> {
            try {
                TypeCreateDto typeCreateDto = new TypeCreateDto(tfTypeName.getText());
                TypeDto typeDto = MainFrame.getInstance().getRentalService().registerType(typeCreateDto);
                JOptionPane.showMessageDialog(null, "Type successfully registered.", "Operation successful", JOptionPane.INFORMATION_MESSAGE);
                MainFrame.getInstance().clearContentPanelAndRefresh();
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Type not registered!", "Operation unsuccessful", JOptionPane.ERROR_MESSAGE);
            }
        });

        JButton btnCancel = new JButton("Cancel");
        MainFrame.getInstance().getCurrentPanel().add(btnCancel);
        btnCancel.addActionListener(event -> MainFrame.getInstance().clearContentPanelAndRefresh());

        MainFrame.getInstance().refresh();
    }
}
