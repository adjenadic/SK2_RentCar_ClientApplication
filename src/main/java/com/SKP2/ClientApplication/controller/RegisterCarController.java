package com.SKP2.ClientApplication.controller;

import com.SKP2.ClientApplication.MainFrame;
import com.SKP2.ClientApplication.dto.CarCreateDto;
import com.SKP2.ClientApplication.dto.CarDto;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class RegisterCarController implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        MainFrame.getInstance().clearContentPanel();

        JLabel lblRegisterCar = new JLabel("Register Car");
        MainFrame.getInstance().getCurrentPanel().add(lblRegisterCar);

        JLabel lblModelID = new JLabel("Model ID");
        MainFrame.getInstance().getCurrentPanel().add(lblModelID);

        JTextField tfModelID = new JTextField();
        MainFrame.getInstance().getCurrentPanel().add(tfModelID);

        JLabel lblTypeID = new JLabel("Type ID");
        MainFrame.getInstance().getCurrentPanel().add(lblTypeID);

        JTextField tfTypeID = new JTextField();
        MainFrame.getInstance().getCurrentPanel().add(tfTypeID);

        JLabel lblCompanyID = new JLabel("Company ID");
        MainFrame.getInstance().getCurrentPanel().add(lblCompanyID);

        JTextField tfCompanyID = new JTextField();
        MainFrame.getInstance().getCurrentPanel().add(tfCompanyID);

        JLabel lblRentalDayPrice = new JLabel("Rental Day Price");
        MainFrame.getInstance().getCurrentPanel().add(lblRentalDayPrice);

        JTextField tfRentalDayPrice = new JTextField();
        MainFrame.getInstance().getCurrentPanel().add(tfRentalDayPrice);

        JButton btnRegister = new JButton("Register");
        MainFrame.getInstance().getCurrentPanel().add(btnRegister);
        btnRegister.addActionListener(event -> {
            try {
                CarCreateDto carDto = new CarCreateDto(Long.parseLong(tfModelID.getText()), Long.parseLong(tfTypeID.getText()), Long.parseLong(tfCompanyID.getText()), Integer.parseInt(tfRentalDayPrice.getText()));
                CarDto updatedCarDto = MainFrame.getInstance().getRentalService().registerCar(carDto);
                JOptionPane.showMessageDialog(null, "Car successfully registered.\nID: " + updatedCarDto.getId() + "\nModel name: " + updatedCarDto.getModelName() + "\nType name: " + updatedCarDto.getTypeName()
                        + "\nCompany name: " + updatedCarDto.getCompanyName() + "\nRental day price: " + updatedCarDto.getRentalDayPrice() + "\nReserved: " + updatedCarDto.isReserved() + "\nStart date: " + updatedCarDto.getStartDate()
                        + "\nEnd date: " + updatedCarDto.getEndDate(), "Operation successful", JOptionPane.INFORMATION_MESSAGE);
                MainFrame.getInstance().clearContentPanelAndRefresh();
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Car not registered!", "Operation unsuccessful", JOptionPane.ERROR_MESSAGE);
            }
        });

        JButton btnCancel = new JButton("Cancel");
        MainFrame.getInstance().getCurrentPanel().add(btnCancel);
        btnCancel.addActionListener(event -> MainFrame.getInstance().clearContentPanelAndRefresh());

        MainFrame.getInstance().refresh();
    }
}
