package com.SKP2.ClientApplication.controller;

import com.SKP2.ClientApplication.MainFrame;
import com.SKP2.ClientApplication.dto.ModelDto;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class UpdateModelController implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        MainFrame.getInstance().clearContentPanel();

        JLabel lblUpdate = new JLabel("Update Model");
        MainFrame.getInstance().getCurrentPanel().add(lblUpdate);

        JLabel lblID = new JLabel("ID");
        MainFrame.getInstance().getCurrentPanel().add(lblID);

        JTextField tfID = new JTextField();
        MainFrame.getInstance().getCurrentPanel().add(tfID);

        JLabel lblModelName = new JLabel("Model Name");
        MainFrame.getInstance().getCurrentPanel().add(lblModelName);

        JTextField tfModelName = new JTextField();
        MainFrame.getInstance().getCurrentPanel().add(tfModelName);

        JButton btnUpdate = new JButton("Update");
        MainFrame.getInstance().getCurrentPanel().add(btnUpdate);
        btnUpdate.addActionListener(event -> {
            try {
                ModelDto modelDto = new ModelDto(Long.parseLong(tfID.getText()), tfModelName.getText());
                ModelDto updatedModelDto = MainFrame.getInstance().getRentalService().updateModel(modelDto);
                JOptionPane.showMessageDialog(null, "Model " + updatedModelDto.getId() + " successfully updated.", "Operation successful", JOptionPane.INFORMATION_MESSAGE);
                MainFrame.getInstance().clearContentPanelAndRefresh();
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Model not updated!", "Operation unsuccessful", JOptionPane.ERROR_MESSAGE);
            }
        });

        JButton btnCancel = new JButton("Cancel");
        MainFrame.getInstance().getCurrentPanel().add(btnCancel);
        btnCancel.addActionListener(event -> MainFrame.getInstance().clearContentPanelAndRefresh());

        MainFrame.getInstance().refresh();
    }
}
