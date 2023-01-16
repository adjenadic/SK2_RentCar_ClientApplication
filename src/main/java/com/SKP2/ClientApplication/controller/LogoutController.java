package com.SKP2.ClientApplication.controller;

import com.SKP2.ClientApplication.MainFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LogoutController implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        MainFrame.getInstance().clearContentPanel();
        MainFrame.getInstance().setToken(null);
        MainFrame.getInstance().setActiveUser(null);
        MainFrame.getInstance().showLoginPanel();
    }
}
