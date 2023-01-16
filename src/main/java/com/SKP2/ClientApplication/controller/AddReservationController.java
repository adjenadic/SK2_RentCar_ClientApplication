package com.SKP2.ClientApplication.controller;

import com.SKP2.ClientApplication.MainFrame;
import com.SKP2.ClientApplication.dto.ReservationCreateDto;
import com.SKP2.ClientApplication.dto.ReservationDto;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AddReservationController implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        MainFrame.getInstance().clearContentPanel();

        JLabel lblAdd = new JLabel("Add Reservation");
        MainFrame.getInstance().getCurrentPanel().add(lblAdd);

        JLabel lblCarID = new JLabel("Car ID");
        MainFrame.getInstance().getCurrentPanel().add(lblCarID);

        JTextField tfCarID = new JTextField();
        MainFrame.getInstance().getCurrentPanel().add(tfCarID);

        JLabel lblStartDate = new JLabel("Start date");
        MainFrame.getInstance().getCurrentPanel().add(lblStartDate);

        JTextField tfStartDate = new JTextField();
        MainFrame.getInstance().getCurrentPanel().add(tfStartDate);

        JLabel lblEndDate = new JLabel("End date");
        MainFrame.getInstance().getCurrentPanel().add(lblEndDate);

        JTextField tfEndDate = new JTextField();
        MainFrame.getInstance().getCurrentPanel().add(tfEndDate);

        JButton btnAdd = new JButton("Add");
        MainFrame.getInstance().getCurrentPanel().add(btnAdd);
        btnAdd.addActionListener(event -> {
            try {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                Date startDate = sdf.parse(tfStartDate.getText());
                java.sql.Date startDateToSqlDate = new java.sql.Date(startDate.getTime());
                Date endDate = sdf.parse(tfEndDate.getText());
                java.sql.Date endDateToSqlDate = new java.sql.Date(endDate.getTime());
                ReservationCreateDto reservationCreateDto = new ReservationCreateDto(Long.parseLong(tfCarID.getText()), startDateToSqlDate, endDateToSqlDate);
                ReservationDto reservationDto = MainFrame.getInstance().getRentalService().addReservation(reservationCreateDto);
                JOptionPane.showMessageDialog(null, "Reservation successfully added.", "Operation successful", JOptionPane.INFORMATION_MESSAGE);
                MainFrame.getInstance().clearContentPanelAndRefresh();
            } catch (IOException | ParseException ex) {
                JOptionPane.showMessageDialog(null, "Reservation not registered!", "Operation unsuccessful", JOptionPane.ERROR_MESSAGE);
            }
        });

        JButton btnCancel = new JButton("Cancel");
        MainFrame.getInstance().getCurrentPanel().add(btnCancel);
        btnCancel.addActionListener(event -> MainFrame.getInstance().clearContentPanelAndRefresh());

        MainFrame.getInstance().refresh();
    }
}
