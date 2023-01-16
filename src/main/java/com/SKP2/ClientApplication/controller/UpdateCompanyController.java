package com.SKP2.ClientApplication.controller;

import com.SKP2.ClientApplication.MainFrame;
import com.SKP2.ClientApplication.dto.CompanyDto;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class UpdateCompanyController implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        MainFrame.getInstance().clearContentPanel();

        JLabel lblUpdateCompany = new JLabel("Update Company");
        MainFrame.getInstance().getCurrentPanel().add(lblUpdateCompany);

        JLabel lblID = new JLabel("ID");
        MainFrame.getInstance().getCurrentPanel().add(lblID);

        JTextField tfID = new JTextField();
        MainFrame.getInstance().getCurrentPanel().add(tfID);

        JLabel lblCompanyName = new JLabel("Company Name");
        MainFrame.getInstance().getCurrentPanel().add(lblCompanyName);

        JTextField tfCompanyName = new JTextField();
        MainFrame.getInstance().getCurrentPanel().add(tfCompanyName);

        JLabel lblDescription = new JLabel("Description");
        MainFrame.getInstance().getCurrentPanel().add(lblDescription);

        JTextField tfDescription = new JTextField();
        MainFrame.getInstance().getCurrentPanel().add(tfDescription);

        JLabel lblNumOfCars = new JLabel("Num of Cars");
        MainFrame.getInstance().getCurrentPanel().add(lblNumOfCars);

        JTextField tfNumOfCars = new JTextField();
        MainFrame.getInstance().getCurrentPanel().add(tfNumOfCars);

        JLabel lblCity = new JLabel("City");
        MainFrame.getInstance().getCurrentPanel().add(lblCity);

        JTextField tfCity = new JTextField();
        MainFrame.getInstance().getCurrentPanel().add(tfCity);

        JButton btnUpdate = new JButton("Update");
        MainFrame.getInstance().getCurrentPanel().add(btnUpdate);
        btnUpdate.addActionListener(event -> {
            try {
                CompanyDto cDto = MainFrame.getInstance().getRentalService().getCompanyById(Long.parseLong(tfID.getText()));
                CompanyDto companyDto = new CompanyDto(Long.parseLong(tfID.getText()), tfCompanyName.getText(), tfDescription.getText(), Integer.parseInt(tfNumOfCars.getText()), tfCity.getText(),
                        cDto.getCarList());
                CompanyDto updatedCompanyDto = MainFrame.getInstance().getRentalService().updateCompany(companyDto);
                JOptionPane.showMessageDialog(null, "Company " + updatedCompanyDto.getId() + " successfully updated.", "Operation successful", JOptionPane.INFORMATION_MESSAGE);
                MainFrame.getInstance().clearContentPanelAndRefresh();
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Company not updated!", "Operation unsuccessful", JOptionPane.ERROR_MESSAGE);
            }
        });

        JButton btnCancel = new JButton("Cancel");
        MainFrame.getInstance().getCurrentPanel().add(btnCancel);
        btnCancel.addActionListener(event -> MainFrame.getInstance().clearContentPanelAndRefresh());

        MainFrame.getInstance().refresh();
    }
}
