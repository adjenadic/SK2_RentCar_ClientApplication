package com.SKP2.ClientApplication.controller;

import com.SKP2.ClientApplication.MainFrame;
import com.SKP2.ClientApplication.dto.ClientDto;
import com.SKP2.ClientApplication.dto.ClientListDto;
import com.SKP2.ClientApplication.util.JTableImpl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;

public class AllClientsController implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        MainFrame.getInstance().clearContentPanel();
        ClientListDto list = null;
        try {
            list = MainFrame.getInstance().getUserService().getAllClients();
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
        List<ClientDto> content = list.getContent();
        Object[][] data = new Object[50][50];
        int k = 0;
        for (ClientDto dto : content)
            data[k++] = new Object[]{dto.getId(), dto.getUsername(), dto.getPassword(), dto.getEmail(),
                    dto.getDayOfBirth(), dto.getFirstName(), dto.getLastName(), dto.getPassport()};
        String[] header = {"ID", "Username", "Password", "Email", "Date of Birth",
                "Firstname", "Lastname", "Passport"};

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
