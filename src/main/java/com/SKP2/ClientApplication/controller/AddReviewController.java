package com.SKP2.ClientApplication.controller;

import com.SKP2.ClientApplication.MainFrame;
import com.SKP2.ClientApplication.dto.ReviewCreateDto;
import com.SKP2.ClientApplication.dto.ReviewDto;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class AddReviewController implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        MainFrame.getInstance().clearContentPanel();

        JLabel lblAddReview = new JLabel("Add Review");
        MainFrame.getInstance().getCurrentPanel().add(lblAddReview);

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

        JButton btnAdd = new JButton("Add");
        MainFrame.getInstance().getCurrentPanel().add(btnAdd);
        btnAdd.addActionListener(event -> {
            try {
                ReviewCreateDto reviewCreateDto = new ReviewCreateDto(Long.parseLong(tfCompanyID.getText()), Integer.parseInt(tfRate.getText()), tfDesc.getText());
                ReviewDto reviewDto = MainFrame.getInstance().getRentalService().add(reviewCreateDto);
                JOptionPane.showMessageDialog(null, "Review successfully added.", "Operation successful", JOptionPane.INFORMATION_MESSAGE);
                MainFrame.getInstance().clearContentPanelAndRefresh();
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Review not added!", "Operation unsuccessful", JOptionPane.ERROR_MESSAGE);
            }
        });

        JButton btnCancel = new JButton("Cancel");
        MainFrame.getInstance().getCurrentPanel().add(btnCancel);
        btnCancel.addActionListener(event -> MainFrame.getInstance().clearContentPanelAndRefresh());

        MainFrame.getInstance().refresh();
    }
}
