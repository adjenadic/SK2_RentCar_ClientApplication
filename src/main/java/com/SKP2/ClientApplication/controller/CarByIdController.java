package com.SKP2.ClientApplication.controller;

import com.SKP2.ClientApplication.MainFrame;
import com.SKP2.ClientApplication.dto.CarDto;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class CarByIdController implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        MainFrame.getInstance().clearContentPanel();

        JLabel lblGet = new JLabel("Get Car By ID");
        MainFrame.getInstance().getCurrentPanel().add(lblGet);

        JLabel lblCarID = new JLabel("Car ID");
        MainFrame.getInstance().getCurrentPanel().add(lblCarID);

        JTextField tfCarID = new JTextField();
        MainFrame.getInstance().getCurrentPanel().add(tfCarID);

        JButton btnGet = new JButton("Get");
        MainFrame.getInstance().getCurrentPanel().add(btnGet);
        btnGet.addActionListener(event -> {
            try {
                CarDto carDto = MainFrame.getInstance().getRentalService().getCarById(Long.parseLong(tfCarID.getText()));
                JOptionPane.showMessageDialog(null, "ID: " + carDto.getId() + "\nModel Name: " + carDto.getModelName() + "\nType Name: " + carDto.getTypeName()
                        + "\nCompany Name: " + carDto.getCompanyName() + "\nRental Day Price: " + carDto.getRentalDayPrice() + "\nReserved Status: " + carDto.isReserved()
                        + "\nStart Date: " + carDto.getStartDate() + "\nEnd Date: " + carDto.getEndDate(), "Car " + tfCarID.getText(), JOptionPane.INFORMATION_MESSAGE);
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
