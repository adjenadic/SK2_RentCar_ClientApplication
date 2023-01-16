package com.SKP2.ClientApplication.controller;

import com.SKP2.ClientApplication.MainFrame;
import com.SKP2.ClientApplication.dto.CompanyCreateDto;
import com.SKP2.ClientApplication.dto.CompanyDto;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class RegisterCompanyController implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        MainFrame.getInstance().clearContentPanel();

        JLabel lblRegisterCompany = new JLabel("Register Company");
        MainFrame.getInstance().getCurrentPanel().add(lblRegisterCompany);

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

        JButton btnRegister = new JButton("Register");
        MainFrame.getInstance().getCurrentPanel().add(btnRegister);
        btnRegister.addActionListener(event -> {
            try {
                CompanyCreateDto companyCreateDto = new CompanyCreateDto(tfCompanyName.getText(), tfDescription.getText(), Integer.parseInt(tfNumOfCars.getText()), tfCity.getText());
                CompanyDto updatedCompanyDto = MainFrame.getInstance().getRentalService().registerCompany(companyCreateDto);
                JOptionPane.showMessageDialog(null, "Company successfully registered.\nID: " + updatedCompanyDto.getId() + "\nCompany name: " + updatedCompanyDto.getName() + "\nDescription: " + updatedCompanyDto.getDescription()
                        + "\nNum of Cars: " + updatedCompanyDto.getNumOfCars() + "\nCity: " + updatedCompanyDto.getCity(), "Operation successful", JOptionPane.INFORMATION_MESSAGE);
                MainFrame.getInstance().clearContentPanelAndRefresh();
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Company not registered!", "Operation unsuccessful", JOptionPane.ERROR_MESSAGE);
            }
        });

        JButton btnCancel = new JButton("Cancel");
        MainFrame.getInstance().getCurrentPanel().add(btnCancel);
        btnCancel.addActionListener(event -> MainFrame.getInstance().clearContentPanelAndRefresh());

        MainFrame.getInstance().refresh();
    }
}
