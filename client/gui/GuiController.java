package client.gui;

import com.google.gson.Gson;
import wsclient.User;
import wsclient.Path;
import wsclient.Package;
import wsclient.AdminService;
import wsclient.Admin;
import wsclientclient.ArrayOfArrayOfstring;
import wsclientclient.ArrayOfstring;
import wsclientclient.Client;
import wsclientclient.IClient;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class GuiController {

    private LoginFrame loginFrame;
    private AdminFrame adminFrame;
    private ClientFrame clientFrame;
    private RegisterFrame registerFrame;

    public Admin admin;
    public IClient clientService;
    private User user;

    public GuiController() {
        AdminService adminService = new AdminService();
        admin = adminService.getAdminPort();

        Client c = new Client();
        clientService = c.getBasicHttpBindingIClient();

        loginFrame = new LoginFrame();
        adminFrame = new AdminFrame();
        clientFrame = new ClientFrame();
        registerFrame = new RegisterFrame();

        loginFrame.setVisible(true);
    }

    public void setupControl() {

        // set action listener to buttons
        // login
        loginFrame.getLoginBtn().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = loginFrame.getUsernameField().getText();
                String password = loginFrame.getPasswordField().getText();
                user = admin.loginControl(username, password);
                System.out.println(user.toString());
                if(user == null) {
                    JOptionPane.showMessageDialog(null, "User not found");
                } else if (user.getIsAdmin() == (byte) 0) {
                    updateOrderedPackages();
                    updateSentPackages();
                    loginFrame.setVisible(false);
                    clientFrame.setVisible(true);
                    //JOptionPane.showMessageDialog(null, "This is an simple client");
                } else {
                    updatePackageTable();
                    updateClientTable();
                    loginFrame.setVisible(false);
                    adminFrame.setVisible(true);
                }

            }
        });

        // add package
        adminFrame.getNewPackageBtn().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String senderId = adminFrame.getSenderIdField().getText();
                String receiverId = adminFrame.getReceiverIdField().getText();
                String name = adminFrame.getNameField().getText();
                String description = adminFrame.getDescriptionArea().getText();
                String senderCity = adminFrame.getSenderCityField().getText();
                String destinationCity = adminFrame.getDestinationCityField().getText();

                Package p = admin.addPackage(
                        senderId,
                        receiverId,
                        name,
                        description,
                        senderCity,
                        destinationCity);

                updatePackageTable();

                if(p != null) {
                    JOptionPane.showMessageDialog(null, "Element was added with success");
                    adminFrame.getSenderIdField().setText("");
                    adminFrame.getReceiverIdField().setText("");
                    adminFrame.getNameField().setText("");
                    adminFrame.getDescriptionArea().setText("");
                    adminFrame.getSenderCityField().setText("");
                    adminFrame.getDestinationCityField().setText("");
                } else {
                    JOptionPane.showMessageDialog(null, "Error");
                }

            }
        });

        // delete package
        adminFrame.getDeletePackageBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String packageId = adminFrame.getIdToDeleteField().getText();
                admin.deletePackage(packageId);
                updatePackageTable();
                JOptionPane.showMessageDialog(null, "Your package was deleted.");
            }
        });

        // track package
        adminFrame.getTrackBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String packageId = adminFrame.getIdToTrackField().getText();
                admin.trackPackage(packageId);
                updatePackageTable();
                JOptionPane.showMessageDialog(null, "The package is set on the way.");
            }
        });

        // add station to path
        adminFrame.getCheckButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String packageID = adminFrame.getPathField().getText();
                String location = adminFrame.getLocationField().getText();
                admin.addPath(location, packageID);
                JOptionPane.showMessageDialog(null, "Checkin successful");
            }
        });

        // view path of a package
        adminFrame.getViewPathBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String packageId = adminFrame.getViewPathPackIDField().getText();
                String path = admin.getPathForPackage(packageId);
                adminFrame.getPathArea().setText(path);
            }
        });


        // find package for client
        clientFrame.getFindPackageBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String packageId = clientFrame.getFindPackageField().getText();
                ArrayOfstring pack = clientService.findPackageById(Integer.parseInt(packageId));
                String p ="";
                for(String pi: pack.getString()) {
                    p += pi + " ";
                }
                clientFrame.getFindPackageArea().setText(p);
            }
        });

        //find Path for package
        clientFrame.getFindPathBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String packageId = clientFrame.getPacakageIdPathField().getText();
                String path = clientService.getPathForPackage(Integer.parseInt(packageId));
                clientFrame.getPathArea().setText(path);
            }
        });

        // register
        loginFrame.getRegBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registerFrame.setVisible(true);
            }
        });

        registerFrame.getRegisterButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = registerFrame.getUsernameField().getText();
                String password = registerFrame.getPasswordField().getText();
                if(username != null && password != null) {
                    clientService.addUser(username, password);
                    registerFrame.setVisible(false);
                }
                else {
                    JOptionPane.showMessageDialog(null, "All fields are mandatory");
                }
            }
        });


    }

    private void updatePackageTable() {
        ArrayList<Package> packages = (ArrayList<Package>) admin.getAllPackages();
        adminFrame.getPackageTabel().removeAll();
        DefaultTableModel packageModel = new DefaultTableModel(null, new Object[] {
                "ID",
                "Sender ID",
                "Receiver ID",
                "Name",
                "Description",
                "Sender city",
                "Destination city",
                "Tracking"
        });
        packageModel.addRow(new Object[] { "ID",
                "Sender ID",
                "Receiver ID",
                "Name",
                "Description",
                "Sender city",
                "Destination city",
                "Tracking"
        });

        for(Package p: packages) {
            packageModel.addRow(new Object[]{
                    p.getId(),
                    p.getUserBySender().getId(),
                    p.getUserByReceiver().getId(),
                    p.getName(),
                    p.getDescription(),
                    p.getSenderCity(),
                    p.getDestinationCity(),
                    p.getTracking()
            });
        }
        adminFrame.getPackageTabel().setModel(packageModel);
    }

    private void updateClientTable() {
        ArrayList<User> users = (ArrayList<User>) admin.getAllUsers();
        adminFrame.getClientTable().removeAll();
        DefaultTableModel clientModel = new DefaultTableModel(null, new Object[] {"ID", "Name"});
        clientModel.addRow(new Object[] { "ID", "Name"});
        for(User u: users) {
            clientModel.addRow(new Object[]{u.getId(), u.getUsername() });
        }
        adminFrame.getClientTable().setModel(clientModel);
    }

    private void updateSentPackages() {
        List<ArrayOfstring> sentpackages = clientService.getSentPackages(user.getId()).getArrayOfstring();
        clientFrame.getSentPackagesTable().removeAll();
        DefaultTableModel packageModel = new DefaultTableModel(null, new Object[] {
                "ID",
                "Sender ID",
                "Receiver ID",
                "Name",
                "Description",
                "Sender city",
                "Destination city",
                "Tracking"
        });
        packageModel.addRow(new Object[] { "ID",
                "Sender ID",
                "Receiver ID",
                "Name",
                "Description",
                "Sender city",
                "Destination city",
                "Tracking"
        });

        for(ArrayOfstring p : sentpackages) {
            if(p != null && !p.getString().isEmpty()) {
                packageModel.addRow(new Object[]{
                        p.getString().get(0),
                        p.getString().get(1),
                        p.getString().get(2),
                        p.getString().get(3),
                        p.getString().get(4),
                        p.getString().get(5),
                        p.getString().get(6),
                        p.getString().get(7)
                });
            }
        }
        clientFrame.getSentPackagesTable().setModel(packageModel);
    }

    private void updateOrderedPackages() {
        List<ArrayOfstring> orderedPackages = clientService.getOrederedPackages(user.getId()).getArrayOfstring();
        clientFrame.getOrderedPackagesTable().removeAll();
        DefaultTableModel packageModel = new DefaultTableModel(null, new Object[] {
                "ID",
                "Sender ID",
                "Receiver ID",
                "Name",
                "Description",
                "Sender city",
                "Destination city",
                "Tracking"
        });
        packageModel.addRow(new Object[] { "ID",
                "Sender ID",
                "Receiver ID",
                "Name",
                "Description",
                "Sender city",
                "Destination city",
                "Tracking"
        });

        for(ArrayOfstring p : orderedPackages) {
            if(p != null && !p.getString().isEmpty()) {
                packageModel.addRow(new Object[]{
                        p.getString().get(0),
                        p.getString().get(1),
                        p.getString().get(2),
                        p.getString().get(3),
                        p.getString().get(4),
                        p.getString().get(5),
                        p.getString().get(6),
                        p.getString().get(7)
                });
            }
        }
        clientFrame.getOrderedPackagesTable().setModel(packageModel);
    }
}
