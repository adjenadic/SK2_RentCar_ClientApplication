package com.SKP2.ClientApplication.controller;

import com.SKP2.ClientApplication.MainFrame;
import com.SKP2.ClientApplication.dto.CompanyDto;
import com.SKP2.ClientApplication.dto.CompanyListDto;
import com.SKP2.ClientApplication.util.JTableImpl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;

public class SortCompaniesByRateController implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        MainFrame.getInstance().clearContentPanel();
        CompanyListDto list;
        try {
            list = MainFrame.getInstance().getRentalService().sortCompaniesByRate();
        } catch (IOException ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
        List<CompanyDto> content = list.getContent();
        Object[][] data = new Object[50][50];
        int k = 0;
        for (CompanyDto dto : content)
            data[k++] = new Object[]{dto.getId(), dto.getName(), dto.getDescription(), dto.getNumOfCars(),
                    dto.getCity(), dto.getCarList()};

        String[] header = {"ID", "Name", "Description", "Num of Cars", "City", "Car List"};
        JTableImpl table = new JTableImpl(header, data);

        JPanel panel = new JPanel(new BorderLayout());
        panel.add(table.getTableHeader(), BorderLayout.NORTH);
        panel.add(table, BorderLayout.CENTER);

        JButton btnBack = new JButton("Back");
        btnBack.addActionListener(event -> MainFrame.getInstance().clearContentPanelAndRefresh());

        MainFrame.getInstance().getCurrentPanel().add(panel);
        MainFrame.getInstance().getCurrentPanel().add(btnBack);
        MainFrame.getInstance().refresh();
    }
}
