package com.SKP2.ClientApplication.controller;

import com.SKP2.ClientApplication.MainFrame;
import com.SKP2.ClientApplication.dto.EmailDto;
import com.SKP2.ClientApplication.dto.EmailListDto;
import com.SKP2.ClientApplication.dto.FilterEmailDto;
import com.SKP2.ClientApplication.util.JTableImpl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class FilterEmailsController implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        MainFrame.getInstance().clearContentPanel();

        JLabel lblFilter = new JLabel("Filter Parameters");
        MainFrame.getInstance().getCurrentPanel().add(lblFilter);

        JLabel lblEmail = new JLabel("Email");
        MainFrame.getInstance().getCurrentPanel().add(lblEmail);

        JTextField tfEmail = new JTextField();
        MainFrame.getInstance().getCurrentPanel().add(tfEmail);

        JLabel lblSubject = new JLabel("Subject");
        MainFrame.getInstance().getCurrentPanel().add(lblSubject);

        JTextField tfSubject = new JTextField();
        MainFrame.getInstance().getCurrentPanel().add(tfSubject);

        JLabel lblStartDate = new JLabel("Start date");
        MainFrame.getInstance().getCurrentPanel().add(lblStartDate);

        JTextField tfStartDate = new JTextField();
        MainFrame.getInstance().getCurrentPanel().add(tfStartDate);

        JLabel lblEndDate = new JLabel("End date");
        MainFrame.getInstance().getCurrentPanel().add(lblEndDate);

        JTextField tfEndDate = new JTextField();
        MainFrame.getInstance().getCurrentPanel().add(tfEndDate);

        JButton btnFilter = new JButton("Filter");
        MainFrame.getInstance().getCurrentPanel().add(btnFilter);

        EmailListDto list;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date startDate = sdf.parse(tfStartDate.getText());
            java.sql.Date startDateToSqlDate = new java.sql.Date(startDate.getTime());
            Date endDate = sdf.parse(tfEndDate.getText());
            java.sql.Date endDateToSqlDate = new java.sql.Date(endDate.getTime());
            FilterEmailDto filterEmailDto = new FilterEmailDto(tfEmail.getText(), tfSubject.getText(), startDateToSqlDate, endDateToSqlDate);
            list = MainFrame.getInstance().getNotificationService().getFilterEmails(filterEmailDto);
        } catch (IOException | ParseException ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
        List<EmailDto> content = list.getContent();
        Object[][] data = new Object[50][50];
        int k = 0;
        for (EmailDto dto : content)
            data[k++] = new Object[]{dto.getSubject(), dto.getContext(), dto.getEmailFrom(), dto.getEmailTo(),
                    dto.getDate()};

        String[] header = {"Subject", "Context", "Email from", "Email to", "Date"};
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
