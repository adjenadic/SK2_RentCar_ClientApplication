package com.SKP2.ClientApplication.controller;

import com.SKP2.ClientApplication.MainFrame;
import com.SKP2.ClientApplication.dto.CarDto;
import com.SKP2.ClientApplication.dto.CarListDto;
import com.SKP2.ClientApplication.util.JTableImpl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;

public class SortDESCController implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        JDialog jDialog = new JDialog();
        jDialog.setSize(1024, 768);
        CarListDto list;
        try {
            list = MainFrame.getInstance().getRentalService().sortDESC();
        } catch (IOException ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
        List<CarDto> content = list.getContent();
        Object[][] data = new Object[50][50];
        int k = 0;
        for (CarDto dto : content)
            data[k++] = new Object[]{dto.getId(), dto.getModelName(), dto.getTypeName(), dto.getCompanyName(),
                    dto.getRentalDayPrice(), dto.isReserved(), dto.getStartDate(), dto.getEndDate()};

        String[] header = {"ID", "Model Name", "Type Name", "Company Name", "Rental Day Price", "Reserved Status",
                "Start Date", "End Date"};
        JTableImpl table = new JTableImpl(header, data);

        JPanel panel = new JPanel(new BorderLayout());
        panel.add(table.getTableHeader(), BorderLayout.NORTH);
        panel.add(table, BorderLayout.CENTER);

        JButton btnBack = new JButton("Back");
        btnBack.addActionListener(event -> MainFrame.getInstance().clearContentPanelAndRefresh());

        jDialog.add(panel);
        jDialog.add(btnBack);
        jDialog.setVisible(true);
    }
}
