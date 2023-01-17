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

        JMenuItem allClients = new JMenuItem("All Clients");
        userService.add(allClients);
        allClients.addActionListener(new AllClientsController());

        userService.addSeparator();

        JMenuItem byClientId = new JMenuItem("Get By Client ID");
        userService.add(byClientId);
        byClientId.addActionListener(new ClientByIdController());

        JMenuItem updateClient = new JMenuItem("Update Client");
        userService.add(updateClient);
        updateClient.addActionListener(new UpdateClientController());

        JMenuItem deleteClient = new JMenuItem("Delete Client");
        userService.add(deleteClient);
        deleteClient.addActionListener(new DeleteClientController());

        userService.addSeparator();

        JMenuItem discount = new JMenuItem("Get Discount By ID");
        userService.add(discount);
        discount.addActionListener(new DiscountController());

        userService.addSeparator();

        JMenuItem verifyEmail = new JMenuItem("Verify Email");
        userService.add(verifyEmail);
        verifyEmail.addActionListener(new VerificationEmailManagerController());

        // Rental Service
        JMenu rentalService = new JMenu("Rental Service");
        menuBar.add(rentalService);

        JMenuItem allCars = new JMenuItem("All Cars");
        rentalService.add(allCars);
        allCars.addActionListener(new AllCarsController());

        JMenuItem byCarId = new JMenuItem("Get By Car ID");
        rentalService.add(byCarId);
        byCarId.addActionListener(new CarByIdController());

        JMenuItem sortASC = new JMenuItem("Sort Cars ASC");
        rentalService.add(sortASC);
        sortASC.addActionListener(new SortASCController());

        JMenuItem sortDESC = new JMenuItem("Sort Cars DESC");
        rentalService.add(sortDESC);
        sortDESC.addActionListener(new SortDESCController());

        JMenuItem filter = new JMenuItem("Filter");
        rentalService.add(filter);
        filter.addActionListener(new FilterController());

        rentalService.addSeparator();

        JMenuItem registerCar = new JMenuItem("Register Car");
        rentalService.add(registerCar);
        registerCar.addActionListener(new RegisterCarController());

        JMenuItem deleteCar = new JMenuItem("Delete Car");
        rentalService.add(deleteCar);
        deleteCar.addActionListener(new DeleteCarController());

        JMenuItem updateCar = new JMenuItem("Update Car");
        rentalService.add(updateCar);
        updateCar.addActionListener(new UpdateCarController());

        rentalService.addSeparator();

        JMenuItem allCompanies = new JMenuItem("Get All Companies");
        rentalService.add(allCompanies);
        allCompanies.addActionListener(new AllCompaniesController());

        JMenuItem byCompanyID = new JMenuItem("Get By Company ID");
        rentalService.add(byCompanyID);
        byCompanyID.addActionListener(new CompanyByIdController());

        JMenuItem sortCompaniesByRate = new JMenuItem("Sort Companies By Rate");
        rentalService.add(sortCompaniesByRate);
        sortCompaniesByRate.addActionListener(new SortCompaniesByRateController());

        JMenuItem registerCompany = new JMenuItem("Register Company");
        rentalService.add(registerCompany);
        registerCompany.addActionListener(new RegisterCompanyController());

        JMenuItem deleteCompany = new JMenuItem("Delete Company");
        rentalService.add(deleteCompany);
        deleteCompany.addActionListener(new DeleteCompanyController());

        JMenuItem updateCompany = new JMenuItem("Update Company");
        rentalService.add(updateCompany);
        updateCompany.addActionListener(new UpdateCompanyController());

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

        JMenuItem addReservation = new JMenuItem("Add Reservation");
        rentalService.add(addReservation);
        addReservation.addActionListener(new AddReservationController());

        JMenuItem cancelReservation = new JMenuItem("Cancel Reservation");
        rentalService.add(cancelReservation);
        cancelReservation.addActionListener(new CancelReservationController());

        rentalService.addSeparator();

        JMenuItem findAllReviews = new JMenuItem("Find All Reviews");
        rentalService.add(findAllReviews);
        findAllReviews.addActionListener(new FindAllController());

        JMenuItem byReviewID = new JMenuItem("Find By Review ID");
        rentalService.add(byReviewID);
        byReviewID.addActionListener(new FindByIdController());

        JMenuItem filterReview = new JMenuItem("Filter Review");
        rentalService.add(filterReview);
        filterReview.addActionListener(new FilterReviewController());

        JMenuItem addReview = new JMenuItem("Add Review");
        rentalService.add(addReview);
        addReview.addActionListener(new AddReviewController());

        JMenuItem deleteReview = new JMenuItem("Delete Review");
        rentalService.add(deleteReview);
        deleteReview.addActionListener(new DeleteReviewController());

        JMenuItem updateReview = new JMenuItem("Update Review");
        rentalService.add(updateReview);
        updateReview.addActionListener(new UpdateReviewController());

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

        notificationService.addSeparator();

        JMenuItem allNotifTypes = new JMenuItem("All Notification Types");
        notificationService.add(allNotifTypes);
        allNotifTypes.addActionListener(new AllNotificationTypesController());

        JMenuItem notifTypeByID = new JMenuItem("Notification Type By ID");
        notificationService.add(notifTypeByID);
        notifTypeByID.addActionListener(new NotifTypeByIdController());

        JMenuItem registerNotif = new JMenuItem("Register Notification Type");
        notificationService.add(registerNotif);
        registerNotif.addActionListener(new RegisterNotifTypeController());

        JMenuItem deleteNotif = new JMenuItem("Delete Notification Type");
        notificationService.add(deleteNotif);
        deleteNotif.addActionListener(new DeleteNotifTypeController());

        JMenuItem updateNotif = new JMenuItem("Update Notification Type");
        notificationService.add(updateNotif);
        updateNotif.addActionListener(new UpdateNotifTypeController());
    }
}
