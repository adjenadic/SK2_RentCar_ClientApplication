package com.SKP2.ClientApplication.controller;

import com.SKP2.ClientApplication.MainFrame;
import com.SKP2.ClientApplication.dto.CompanyDto;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class CompanyByIdController implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        MainFrame.getInstance().clearContentPanel();

        JLabel lblGet = new JLabel("Get Company By ID");
        MainFrame.getInstance().getCurrentPanel().add(lblGet);

        JLabel lblCompanyID = new JLabel("Company ID");
        MainFrame.getInstance().getCurrentPanel().add(lblCompanyID);

        JTextField tfCompanyID = new JTextField();
        MainFrame.getInstance().getCurrentPanel().add(tfCompanyID);

        JButton btnGet = new JButton("Get");
        MainFrame.getInstance().getCurrentPanel().add(btnGet);
        btnGet.addActionListener(event -> {
            try {
                CompanyDto companyDto = MainFrame.getInstance().getRentalService().getCompanyById(Long.parseLong(tfCompanyID.getText()));
                JOptionPane.showMessageDialog(null, "ID: " + companyDto.getId() + "\nCompany name: " + companyDto.getName() + "\nDescription: " + companyDto.getDescription()
                        + "\nNum of Cars: " + companyDto.getNumOfCars() + "\nCity: " + companyDto.getCity() + "\nCar List: " + companyDto.getCarList(), "Company " + tfCompanyID.getText(), JOptionPane.INFORMATION_MESSAGE);
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
