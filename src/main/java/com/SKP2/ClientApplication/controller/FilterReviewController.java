package com.SKP2.ClientApplication.controller;

import com.SKP2.ClientApplication.MainFrame;
import com.SKP2.ClientApplication.dto.ReviewDto;
import com.SKP2.ClientApplication.dto.ReviewFilterDto;
import com.SKP2.ClientApplication.dto.ReviewListDto;
import com.SKP2.ClientApplication.util.JTableImpl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;

public class FilterReviewController implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        MainFrame.getInstance().clearContentPanel();

        JLabel lblFilter = new JLabel("Filter Parameters");
        MainFrame.getInstance().getCurrentPanel().add(lblFilter);

        JLabel lblCity = new JLabel("City");
        MainFrame.getInstance().getCurrentPanel().add(lblCity);

        JTextField tfCity = new JTextField();
        MainFrame.getInstance().getCurrentPanel().add(tfCity);

        JLabel lblCompanyID = new JLabel("Company ID");
        MainFrame.getInstance().getCurrentPanel().add(lblCompanyID);

        JTextField tfCompanyID = new JTextField();
        MainFrame.getInstance().getCurrentPanel().add(tfCompanyID);

        JButton btnFilter = new JButton("Filter");
        MainFrame.getInstance().getCurrentPanel().add(btnFilter);

        ReviewListDto list;
        try {
            ReviewFilterDto reviewFilterDto = new ReviewFilterDto(tfCity.getText(), Long.parseLong(tfCompanyID.getText()));
            list = MainFrame.getInstance().getRentalService().filterReview(reviewFilterDto);
        } catch (IOException ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
        List<ReviewDto> content = list.getContent();
        Object[][] data = new Object[50][50];
        int k = 0;
        for (ReviewDto dto : content)
            data[k++] = new Object[]{dto.getId(), dto.getCompanyId(), dto.getRate(), dto.getDesc()};

        String[] header = {"ID", "Company ID", "Rate", "Description"};
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
