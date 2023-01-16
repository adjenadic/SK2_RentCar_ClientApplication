package com.SKP2.ClientApplication.controller;

import com.SKP2.ClientApplication.MainFrame;
import com.SKP2.ClientApplication.dto.DiscountDto;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class DiscountController implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        MainFrame.getInstance().clearContentPanel();

        JLabel lblGet = new JLabel("Get Discount By ID");
        MainFrame.getInstance().getCurrentPanel().add(lblGet);

        JLabel lblUserID = new JLabel("Discount ID");
        MainFrame.getInstance().getCurrentPanel().add(lblUserID);

        JTextField tfDiscountID = new JTextField();
        MainFrame.getInstance().getCurrentPanel().add(tfDiscountID);

        JButton btnGet = new JButton("Get");
        MainFrame.getInstance().getCurrentPanel().add(btnGet);
        btnGet.addActionListener(event -> {
            try {
                DiscountDto discountDto = MainFrame.getInstance().getUserService().getDiscount(Long.parseLong(tfDiscountID.getText()));
                JOptionPane.showMessageDialog(null, "Discount: " + discountDto.getDiscount(), "Discount " + tfDiscountID.getText(), JOptionPane.INFORMATION_MESSAGE);
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
