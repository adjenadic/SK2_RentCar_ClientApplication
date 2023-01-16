package com.SKP2.ClientApplication.controller;

import com.SKP2.ClientApplication.MainFrame;
import com.SKP2.ClientApplication.dto.ManagerDto;
import com.SKP2.ClientApplication.dto.ManagerListDto;
import com.SKP2.ClientApplication.util.JTableImpl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;

public class AllManagersController implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        MainFrame.getInstance().clearContentPanel();
        ManagerListDto list = null;
        try {
            list = MainFrame.getInstance().getUserService().getAllManagers();
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
        List<ManagerDto> content = list.getContent();
        Object[][] data = new Object[50][50];
        int k = 0;
        for (ManagerDto dto : content)
            data[k++] = new Object[]{dto.getId(), dto.getUsername(), dto.getPassword(), dto.getEmail(),
                    dto.getDayOfBirth(), dto.getFirstName(), dto.getLastName(), dto.getCompanyName(), dto.getEmploymentDay()};
        String[] header = {"ID", "Username", "Password", "Email", "Date of Birth",
                "Firstname", "Lastname", "Company Name", "Employment Day"};

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
