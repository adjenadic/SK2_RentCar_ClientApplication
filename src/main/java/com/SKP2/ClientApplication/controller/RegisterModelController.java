package com.SKP2.ClientApplication.controller;

import com.SKP2.ClientApplication.MainFrame;
import com.SKP2.ClientApplication.dto.ModelCreateDto;
import com.SKP2.ClientApplication.dto.ModelDto;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class RegisterModelController implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        MainFrame.getInstance().clearContentPanel();

        JLabel lblRegisterCompany = new JLabel("Register Model");
        MainFrame.getInstance().getCurrentPanel().add(lblRegisterCompany);

        JLabel lblModelName = new JLabel("Model Name");
        MainFrame.getInstance().getCurrentPanel().add(lblModelName);

        JTextField tfModelName = new JTextField();
        MainFrame.getInstance().getCurrentPanel().add(tfModelName);

        JButton btnRegister = new JButton("Register");
        MainFrame.getInstance().getCurrentPanel().add(btnRegister);
        btnRegister.addActionListener(event -> {
            try {
                ModelCreateDto modelCreateDto = new ModelCreateDto(tfModelName.getText());
                ModelDto modelDto = MainFrame.getInstance().getRentalService().registerModel(modelCreateDto);
                JOptionPane.showMessageDialog(null, "Model successfully registered.", "Operation successful", JOptionPane.INFORMATION_MESSAGE);
                MainFrame.getInstance().clearContentPanelAndRefresh();
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Model not registered!", "Operation unsuccessful", JOptionPane.ERROR_MESSAGE);
            }
        });

        JButton btnCancel = new JButton("Cancel");
        MainFrame.getInstance().getCurrentPanel().add(btnCancel);
        btnCancel.addActionListener(event -> MainFrame.getInstance().clearContentPanelAndRefresh());

        MainFrame.getInstance().refresh();
    }
}
