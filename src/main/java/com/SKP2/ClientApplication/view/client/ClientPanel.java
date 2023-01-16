package com.SKP2.ClientApplication.view.client;

import com.SKP2.ClientApplication.controller.*;

import javax.swing.*;

public class ClientPanel extends JPanel {
    public ClientPanel() {
        JMenuBar menuBar = new JMenuBar();
        add(menuBar);

        // User Service
        JMenu userService = new JMenu("User Service");
        menuBar.add(userService);

        JMenuItem verifyEmail = new JMenuItem("Verify Email");
        userService.add(verifyEmail);
        verifyEmail.addActionListener(new VerificationEmailController());

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

        JMenuItem allCompanies = new JMenuItem("Get All Companies");
        rentalService.add(allCompanies);
        allCompanies.addActionListener(new AllCompaniesController());

        JMenuItem byCompanyID = new JMenuItem("Get By Company ID");
        rentalService.add(byCompanyID);
        byCompanyID.addActionListener(new CompanyByIdController());

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

        rentalService.addSeparator();

        JMenuItem allTypes = new JMenuItem("All Types");
        rentalService.add(allTypes);
        allTypes.addActionListener(new AllTypesController());

        JMenuItem byTypeID = new JMenuItem("Get By Type ID");
        rentalService.add(byTypeID);
        byTypeID.addActionListener(new TypeByIdController());

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

        // Account Settings
        JMenu accountSettings = new JMenu("Account Settings");
        menuBar.add(accountSettings);

        JMenuItem logout = new JMenuItem("Logout");
        accountSettings.add(logout);
        logout.addActionListener(new LogoutController());
    }
}
