package com.SKP2.ClientApplication.view.manager;

import com.SKP2.ClientApplication.controller.*;

import javax.swing.*;

public class ManagerPanel extends JPanel {
    public ManagerPanel() {
        setLayout(null);

        JMenuBar menuBar = new JMenuBar();
        menuBar.setBounds(0, 0, 1024, 30);
        add(menuBar);

        // User Service
        JMenu userService = new JMenu("User Service");
        menuBar.add(userService);

        JMenuItem byManagerId = new JMenuItem("Get By Manager ID");
        userService.add(byManagerId);
        byManagerId.addActionListener(new ManagerByIdController());

        // TODO REGISTER MANAGER BUTTON

        JMenuItem deleteManager = new JMenuItem("Delete Manager");
        userService.add(deleteManager);
        deleteManager.addActionListener(new DeleteManagerController());

        JMenuItem updateManager = new JMenuItem("Update Manager");
        userService.add(updateManager);
        updateManager.addActionListener(new UpdateManagerController());

        userService.addSeparator();

        JMenuItem verifyEmail = new JMenuItem("Verify Email");
        userService.add(verifyEmail);
        verifyEmail.addActionListener(new VerificationEmailManagerController());

        userService.addSeparator();

        JMenuItem discount = new JMenuItem("Get Discount By ID");
        userService.add(discount);
        discount.addActionListener(new DiscountController());

        // Rental Service
        JMenu rentalService = new JMenu("Rental Service");
        menuBar.add(rentalService);

        JMenuItem allCars = new JMenuItem("All Cars");
        rentalService.add(allCars);
        allCars.addActionListener(new AllCarsController());

        JMenuItem byCarId = new JMenuItem("Get By Car ID");
        rentalService.add(byCarId);
        byCarId.addActionListener(new CarByIdController());

        JMenuItem filter = new JMenuItem("Filter");
        rentalService.add(filter);
        filter.addActionListener(new FilterController());

        rentalService.addSeparator();

        JMenuItem sortCompaniesByRate = new JMenuItem("Sort Companies By Rate");
        rentalService.add(sortCompaniesByRate);
        sortCompaniesByRate.addActionListener(new SortCompaniesByRateController());

        rentalService.addSeparator();

        JMenuItem allModels = new JMenuItem("All Models");
        rentalService.add(allModels);
        allModels.addActionListener(new AllModelsController());

        JMenuItem byModelID = new JMenuItem("Get By Model ID");
        rentalService.add(byModelID);
        byModelID.addActionListener(new ModelByIdController());

        JMenuItem registerModel = new JMenuItem("Register Model");
        rentalService.add(registerModel);
        registerModel.addActionListener(new RegisterModelController());

        JMenuItem deleteModel = new JMenuItem("Delete Model");
        rentalService.add(deleteModel);
        deleteModel.addActionListener(new DeleteModelController());

        JMenuItem updateModel = new JMenuItem("Update Model");
        rentalService.add(updateModel);
        updateModel.addActionListener(new UpdateModelController());

        rentalService.addSeparator();

        JMenuItem cancelReservation = new JMenuItem("Cancel Reservation");
        rentalService.add(cancelReservation);
        cancelReservation.addActionListener(new CancelReservationController());

        rentalService.addSeparator();

        JMenuItem allTypes = new JMenuItem("All Types");
        rentalService.add(allTypes);
        allTypes.addActionListener(new AllTypesController());

        JMenuItem byTypeID = new JMenuItem("Get By Type ID");
        rentalService.add(byTypeID);
        byTypeID.addActionListener(new TypeByIdController());

        JMenuItem registerType = new JMenuItem("Register Type");
        rentalService.add(registerType);
        registerType.addActionListener(new RegisterTypeController());

        JMenuItem deleteType = new JMenuItem("Delete Type");
        rentalService.add(deleteType);
        deleteType.addActionListener(new DeleteTypeController());

        JMenuItem updateType = new JMenuItem("Update Type");
        rentalService.add(updateType);
        updateType.addActionListener(new UpdateTypeController());

        // Notification Service
        JMenu notificationService = new JMenu("Notification Service");
        menuBar.add(notificationService);

        JMenuItem allEmails = new JMenuItem("All Emails");
        notificationService.add(allEmails);
        allEmails.addActionListener(new AllEmailsController());

        JMenuItem filterEmails = new JMenuItem("Filter Emails");
        notificationService.add(filterEmails);
        filterEmails.addActionListener(new FilterEmailsController());
    }
}
