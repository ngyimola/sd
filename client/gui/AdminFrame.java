package client.gui;

import javax.swing.*;
import java.awt.*;

public class AdminFrame extends JFrame{
    private JPanel adminPanel;
    private JTabbedPane tabbedPane;
    private JPanel packagesPanel;
    private JPanel addPackagePanel;
    private JLabel senderIdLbl;
    private JTextField senderIdField;
    private JLabel receiverIdLbl;
    private JTextField receiverIdField;
    private JLabel nameLbl;
    private JTextField nameField;
    private JLabel descriptionLbl;
    private JTextArea descriptionArea;
    private JLabel senderCityLbl;
    private JTextField senderCityField;
    private JLabel destinationCityLbl;
    private JTextField destinationCityField;
    private JButton newPackageBtn;
    private JPanel clientsPanel;
    private JTable packageTabel;
    private JTable clientTable;
    private JPanel operationPanel;
    private JPanel deletePanel;
    private JPanel trackPanel;
    private JPanel checkPanel;
    private JLabel deletePLbl;
    private JTextField idToDeleteField;
    private JButton deletePackageBtn;
    private JLabel trackPbl;
    private JTextField idToTrackField;
    private JButton trackBtn;
    private JLabel pathLbl;
    private JTextField pathField;
    private JLabel locationLbl;
    private JTextField locationField;
    private JButton checkButton;
    private JPanel viewPathPanel;
    private JLabel intrIdLbl;
    private JTextField viewPathPackIDField;
    private JButton viewPathBtn;
    private JTextArea pathArea;

    public AdminFrame() throws HeadlessException {
        this.add(adminPanel);
        this.setSize(700, 500);
    }

    public JPanel getAdminPanel() {
        return adminPanel;
    }

    public void setAdminPanel(JPanel adminPanel) {
        this.adminPanel = adminPanel;
    }

    public JTabbedPane getTabbedPane() {
        return tabbedPane;
    }

    public void setTabbedPane(JTabbedPane tabbedPane) {
        this.tabbedPane = tabbedPane;
    }

    public JPanel getPackagesPanel() {
        return packagesPanel;
    }

    public void setPackagesPanel(JPanel packagesPanel) {
        this.packagesPanel = packagesPanel;
    }

    public JPanel getAddPackagePanel() {
        return addPackagePanel;
    }

    public void setAddPackagePanel(JPanel addPackagePanel) {
        this.addPackagePanel = addPackagePanel;
    }

    public JTextField getSenderIdField() {
        return senderIdField;
    }

    public void setSenderIdField(JTextField senderIdField) {
        this.senderIdField = senderIdField;
    }

    public JTextField getReceiverIdField() {
        return receiverIdField;
    }

    public void setReceiverIdField(JTextField receiverIdField) {
        this.receiverIdField = receiverIdField;
    }

    public JTextField getNameField() {
        return nameField;
    }

    public void setNameField(JTextField nameField) {
        this.nameField = nameField;
    }

    public JTextArea getDescriptionArea() {
        return descriptionArea;
    }

    public void setDescriptionArea(JTextArea descriptionArea) {
        this.descriptionArea = descriptionArea;
    }

    public JTextField getSenderCityField() {
        return senderCityField;
    }

    public void setSenderCityField(JTextField senderCityField) {
        this.senderCityField = senderCityField;
    }

    public JTextField getDestinationCityField() {
        return destinationCityField;
    }

    public void setDestinationCityField(JTextField destinationCityField) {
        this.destinationCityField = destinationCityField;
    }

    public JButton getNewPackageBtn() {
        return newPackageBtn;
    }

    public void setNewPackageBtn(JButton newPackageBtn) {
        this.newPackageBtn = newPackageBtn;
    }

    public JPanel getClientsPanel() {
        return clientsPanel;
    }

    public void setClientsPanel(JPanel clientsPanel) {
        this.clientsPanel = clientsPanel;
    }

    public JTable getPackageTabel() {
        return packageTabel;
    }

    public void setPackageTabel(JTable packageTabel) {
        this.packageTabel = packageTabel;
    }

    public JTable getClientTable() {
        return clientTable;
    }

    public void setClientTable(JTable clientTable) {
        this.clientTable = clientTable;
    }

    public JLabel getSenderIdLbl() {
        return senderIdLbl;
    }

    public void setSenderIdLbl(JLabel senderIdLbl) {
        this.senderIdLbl = senderIdLbl;
    }

    public JLabel getReceiverIdLbl() {
        return receiverIdLbl;
    }

    public void setReceiverIdLbl(JLabel receiverIdLbl) {
        this.receiverIdLbl = receiverIdLbl;
    }

    public JLabel getNameLbl() {
        return nameLbl;
    }

    public void setNameLbl(JLabel nameLbl) {
        this.nameLbl = nameLbl;
    }

    public JLabel getDescriptionLbl() {
        return descriptionLbl;
    }

    public void setDescriptionLbl(JLabel descriptionLbl) {
        this.descriptionLbl = descriptionLbl;
    }

    public JLabel getSenderCityLbl() {
        return senderCityLbl;
    }

    public void setSenderCityLbl(JLabel senderCityLbl) {
        this.senderCityLbl = senderCityLbl;
    }

    public JLabel getDestinationCityLbl() {
        return destinationCityLbl;
    }

    public void setDestinationCityLbl(JLabel destinationCityLbl) {
        this.destinationCityLbl = destinationCityLbl;
    }

    public JPanel getOperationPanel() {
        return operationPanel;
    }

    public void setOperationPanel(JPanel operationPanel) {
        this.operationPanel = operationPanel;
    }

    public JPanel getDeletePanel() {
        return deletePanel;
    }

    public void setDeletePanel(JPanel deletePanel) {
        this.deletePanel = deletePanel;
    }

    public JPanel getTrackPanel() {
        return trackPanel;
    }

    public void setTrackPanel(JPanel trackPanel) {
        this.trackPanel = trackPanel;
    }

    public JPanel getCheckPanel() {
        return checkPanel;
    }

    public void setCheckPanel(JPanel checkPanel) {
        this.checkPanel = checkPanel;
    }

    public JLabel getDeletePLbl() {
        return deletePLbl;
    }

    public void setDeletePLbl(JLabel deletePLbl) {
        this.deletePLbl = deletePLbl;
    }

    public JTextField getIdToDeleteField() {
        return idToDeleteField;
    }

    public void setIdToDeleteField(JTextField idToDeleteField) {
        this.idToDeleteField = idToDeleteField;
    }

    public JButton getDeletePackageBtn() {
        return deletePackageBtn;
    }

    public void setDeletePackageBtn(JButton deletePackageBtn) {
        this.deletePackageBtn = deletePackageBtn;
    }

    public JLabel getTrackPbl() {
        return trackPbl;
    }

    public void setTrackPbl(JLabel trackPbl) {
        this.trackPbl = trackPbl;
    }

    public JTextField getIdToTrackField() {
        return idToTrackField;
    }

    public void setIdToTrackField(JTextField idToTrackField) {
        this.idToTrackField = idToTrackField;
    }

    public JButton getTrackBtn() {
        return trackBtn;
    }

    public void setTrackBtn(JButton trackBtn) {
        this.trackBtn = trackBtn;
    }

    public JLabel getPathLbl() {
        return pathLbl;
    }

    public void setPathLbl(JLabel pathLbl) {
        this.pathLbl = pathLbl;
    }

    public JTextField getPathField() {
        return pathField;
    }

    public void setPathField(JTextField pathField) {
        this.pathField = pathField;
    }

    public JLabel getLocationLbl() {
        return locationLbl;
    }

    public void setLocationLbl(JLabel locationLbl) {
        this.locationLbl = locationLbl;
    }

    public JTextField getLocationField() {
        return locationField;
    }

    public void setLocationField(JTextField locationField) {
        this.locationField = locationField;
    }

    public JButton getCheckButton() {
        return checkButton;
    }

    public void setCheckButton(JButton checkButton) {
        this.checkButton = checkButton;
    }

    public JPanel getViewPathPanel() {
        return viewPathPanel;
    }

    public void setViewPathPanel(JPanel viewPathPanel) {
        this.viewPathPanel = viewPathPanel;
    }

    public JLabel getIntrIdLbl() {
        return intrIdLbl;
    }

    public void setIntrIdLbl(JLabel intrIdLbl) {
        this.intrIdLbl = intrIdLbl;
    }

    public JTextField getViewPathPackIDField() {
        return viewPathPackIDField;
    }

    public void setViewPathPackIDField(JTextField viewPathPackIDField) {
        this.viewPathPackIDField = viewPathPackIDField;
    }

    public JButton getViewPathBtn() {
        return viewPathBtn;
    }

    public void setViewPathBtn(JButton viewPathBtn) {
        this.viewPathBtn = viewPathBtn;
    }

    public JTextArea getPathArea() {
        return pathArea;
    }

    public void setPathArea(JTextArea pathArea) {
        this.pathArea = pathArea;
    }
}


