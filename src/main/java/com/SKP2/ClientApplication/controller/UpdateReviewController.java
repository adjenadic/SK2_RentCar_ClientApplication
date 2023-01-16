package com.SKP2.ClientApplication.controller;

import com.SKP2.ClientApplication.MainFrame;
import com.SKP2.ClientApplication.dto.ReviewDto;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class UpdateReviewController implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        MainFrame.getInstance().clearContentPanel();

        JLabel lblUpdateCar = new JLabel("Update Review");
        MainFrame.getInstance().getCurrentPanel().add(lblUpdateCar);

        JLabel lblID = new JLabel("ID");
        MainFrame.getInstance().getCurrentPanel().add(lblID);

        JTextField tfID = new JTextField();
        MainFrame.getInstance().getCurrentPanel().add(tfID);

        JLabel lblCompanyID = new JLabel("Company ID");
        MainFrame.getInstance().getCurrentPanel().add(lblCompanyID);

        JTextField tfCompanyID = new JTextField();
        MainFrame.getInstance().getCurrentPanel().add(tfCompanyID);

        JLabel lblRate = new JLabel("Rate");
        MainFrame.getInstance().getCurrentPanel().add(lblRate);

        JTextField tfRate = new JTextField();
        MainFrame.getInstance().getCurrentPanel().add(tfRate);

        JLabel lblDesc = new JLabel("Description");
        MainFrame.getInstance().getCurrentPanel().add(lblDesc);

        JTextField tfDesc = new JTextField();
        MainFrame.getInstance().getCurrentPanel().add(tfDesc);

        JButton btnUpdate = new JButton("Update");
        MainFrame.getInstance().getCurrentPanel().add(btnUpdate);
        btnUpdate.addActionListener(event -> {
            try {
                ReviewDto reviewDto = new ReviewDto(Long.parseLong(tfID.getText()), Long.parseLong(tfCompanyID.getText()), Integer.parseInt(tfRate.getText()), tfDesc.getText());
                ReviewDto updatedReviewDto = MainFrame.getInstance().getRentalService().update(reviewDto);
                JOptionPane.showMessageDialog(null, "Review " + updatedReviewDto.getId() + " successfully updated.", "Operation successful", JOptionPane.INFORMATION_MESSAGE);
                MainFrame.getInstance().clearContentPanelAndRefresh();
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Review not updated!", "Operation unsuccessful", JOptionPane.ERROR_MESSAGE);
            }
        });

        JButton btnCancel = new JButton("Cancel");
        MainFrame.getInstance().getCurrentPanel().add(btnCancel);
        btnCancel.addActionListener(event -> MainFrame.getInstance().clearContentPanelAndRefresh());

        MainFrame.getInstance().refresh();
    }
}
