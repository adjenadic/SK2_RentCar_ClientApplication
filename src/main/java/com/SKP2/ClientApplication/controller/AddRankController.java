package com.SKP2.ClientApplication.controller;

import com.SKP2.ClientApplication.MainFrame;
import com.SKP2.ClientApplication.dto.RankCreateDto;
import com.SKP2.ClientApplication.dto.RankDto;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class AddRankController implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        MainFrame.getInstance().clearContentPanel();

        JLabel lblRankName = new JLabel("Rank Name:");
        MainFrame.getInstance().getCurrentPanel().add(lblRankName);

        JTextField tfRankName = new JTextField();
        MainFrame.getInstance().getCurrentPanel().add(tfRankName);

        JLabel lblMinTotalNumberOfRentCar = new JLabel("Minimum Total Number Of Rent Car:");
        MainFrame.getInstance().getCurrentPanel().add(lblMinTotalNumberOfRentCar);

        JTextField tfMinTotalNumberOfRentCar = new JTextField();
        MainFrame.getInstance().getCurrentPanel().add(tfMinTotalNumberOfRentCar);

        JLabel lblMaxTotalNumberOfRentCar = new JLabel("Maximum Total Number Of Rent Car:");
        MainFrame.getInstance().getCurrentPanel().add(lblMaxTotalNumberOfRentCar);

        JTextField tfMaxTotalNumberOfRentCar = new JTextField();
        MainFrame.getInstance().getCurrentPanel().add(tfMaxTotalNumberOfRentCar);

        JLabel lblDiscount = new JLabel("Discount:");
        MainFrame.getInstance().getCurrentPanel().add(lblDiscount);

        JTextField tfDiscount = new JTextField();
        MainFrame.getInstance().getCurrentPanel().add(tfDiscount);

        JButton btnAdd = new JButton("Add Rank");
        MainFrame.getInstance().getCurrentPanel().add(btnAdd);
        btnAdd.addActionListener(event -> {
            try {
                RankDto rankDto = MainFrame.getInstance().getUserService().addRank(new RankCreateDto(tfRankName.getText(), Integer.parseInt(tfMinTotalNumberOfRentCar.getText()), Integer.parseInt(tfMaxTotalNumberOfRentCar.getText()), Integer.parseInt(tfDiscount.getText())));
                JOptionPane.showMessageDialog(null, "Rank successfully created.\nID: " + rankDto.getId() + "\nRank Name: " + rankDto.getName() + "\nMin Cars: " + rankDto.getMinTotalNumberOfRentCar()
                        + "\nMax Cars: " + rankDto.getMaxTotalNumberOfRentCar() + "\nDiscount: " + rankDto.getDiscount(), "Operation successful", JOptionPane.INFORMATION_MESSAGE);
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
