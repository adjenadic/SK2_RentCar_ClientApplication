package com.SKP2.ClientApplication.controller;

import com.SKP2.ClientApplication.MainFrame;
import com.SKP2.ClientApplication.dto.ModelDto;
import com.SKP2.ClientApplication.dto.ModelListDto;
import com.SKP2.ClientApplication.util.JTableImpl;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;

public class AllModelsController implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        JDialog jDialog = new JDialog();
        jDialog.setSize(1024, 768);

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
        table.setBounds(0, 0, 1024, 768);

        jDialog.add(new JScrollPane(table));
        jDialog.setVisible(true);
    }
}
