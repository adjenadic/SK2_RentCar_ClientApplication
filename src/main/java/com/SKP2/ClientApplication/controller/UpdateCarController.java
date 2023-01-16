package com.SKP2.ClientApplication.controller;

import com.SKP2.ClientApplication.MainFrame;
import com.SKP2.ClientApplication.dto.CarDto;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UpdateCarController implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        MainFrame.getInstance().clearContentPanel();

        JLabel lblUpdateCar = new JLabel("Update Car");
        MainFrame.getInstance().getCurrentPanel().add(lblUpdateCar);

        JLabel lblID = new JLabel("ID");
        MainFrame.getInstance().getCurrentPanel().add(lblID);

        JTextField tfID = new JTextField();
        MainFrame.getInstance().getCurrentPanel().add(tfID);

        JLabel lblModelName = new JLabel("Model name");
        MainFrame.getInstance().getCurrentPanel().add(lblModelName);

        JTextField tfModelName = new JTextField();
        MainFrame.getInstance().getCurrentPanel().add(tfModelName);

        JLabel lblTypeName = new JLabel("Type name");
        MainFrame.getInstance().getCurrentPanel().add(lblTypeName);

        JTextField tfTypeName = new JTextField();
        MainFrame.getInstance().getCurrentPanel().add(tfTypeName);

        JLabel lblCompanyName = new JLabel("Company name");
        MainFrame.getInstance().getCurrentPanel().add(lblCompanyName);

        JTextField tfCompanyName = new JTextField();
        MainFrame.getInstance().getCurrentPanel().add(tfCompanyName);

        JLabel lblRentalDayPrice = new JLabel("Rental Day Price");
        MainFrame.getInstance().getCurrentPanel().add(lblRentalDayPrice);

        JTextField tfRentalDayPrice = new JTextField();
        MainFrame.getInstance().getCurrentPanel().add(tfRentalDayPrice);

        JLabel lblStartDate = new JLabel("Start date");
        MainFrame.getInstance().getCurrentPanel().add(lblStartDate);

        JTextField tfStartDate = new JTextField();
        MainFrame.getInstance().getCurrentPanel().add(tfStartDate);

        JLabel lblEndDate = new JLabel("End date");
        MainFrame.getInstance().getCurrentPanel().add(lblEndDate);

        JTextField tfEndDate = new JTextField();
        MainFrame.getInstance().getCurrentPanel().add(tfEndDate);

        JButton btnUpdate = new JButton("Update");
        MainFrame.getInstance().getCurrentPanel().add(btnUpdate);
        btnUpdate.addActionListener(event -> {
            try {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                Date startDate = sdf.parse(tfStartDate.getText());
                java.sql.Date startDateToSqlDate = new java.sql.Date(startDate.getTime());
                Date endDate = sdf.parse(tfEndDate.getText());
                java.sql.Date endDateToSqlDate = new java.sql.Date(startDate.getTime());
                CarDto carDto = new CarDto(Long.parseLong(tfID.getText()), tfModelName.getText(), tfTypeName.getText(), tfCompanyName.getText(), Integer.parseInt(tfRentalDayPrice.getText()),
                        false, startDateToSqlDate, endDateToSqlDate);
                CarDto updatedCarDto = MainFrame.getInstance().getRentalService().updateCar(carDto);
                JOptionPane.showMessageDialog(null, "Car successfully updated.\nID: " + updatedCarDto.getId() + "\nModel name: " + updatedCarDto.getModelName() + "\nType name: " + updatedCarDto.getTypeName()
                        + "\nCompany name: " + updatedCarDto.getCompanyName() + "\nRental day price: " + updatedCarDto.getRentalDayPrice() + "\nReserved status: " + updatedCarDto.isReserved() + "\nStart date: " + updatedCarDto.getStartDate() + "\nEnd date: " + updatedCarDto.getEndDate(), "Operation successful", JOptionPane.INFORMATION_MESSAGE);
                MainFrame.getInstance().clearContentPanelAndRefresh();
            } catch (IOException | ParseException ex) {
                JOptionPane.showMessageDialog(null, "Car not updated!", "Operation unsuccessful", JOptionPane.ERROR_MESSAGE);
            }
        });

        JButton btnCancel = new JButton("Cancel");
        MainFrame.getInstance().getCurrentPanel().add(btnCancel);
        btnCancel.addActionListener(event -> MainFrame.getInstance().clearContentPanelAndRefresh());

        MainFrame.getInstance().refresh();
    }
}
