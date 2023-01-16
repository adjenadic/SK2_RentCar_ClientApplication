package com.SKP2.ClientApplication.controller;

import com.SKP2.ClientApplication.MainFrame;
import com.SKP2.ClientApplication.dto.ModelDto;
import com.SKP2.ClientApplication.dto.ModelListDto;
import com.SKP2.ClientApplication.util.JTableImpl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;

public class AllModelsController implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        MainFrame.getInstance().clearContentPanel();
        ModelListDto list;
        try {
            list = MainFrame.getInstance().getRentalService().getAllModels();
        } catch (IOException ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
        List<ModelDto> content = list.getContent();
        Object[][] data = new Object[50][50];
        int k = 0;
        for (ModelDto dto : content)
            data[k++] = new Object[]{dto.getId(), dto.getName()};

        String[] header = {"ID", "Name"};
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
