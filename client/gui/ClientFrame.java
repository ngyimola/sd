package client.gui;

import javax.swing.*;

public class ClientFrame extends JFrame{
    private JPanel clientPanel;
    private JTabbedPane clientPane;
    private JPanel findPackagePanel;
    private JPanel sentPackagesPanel;
    private JPanel orderedPackagesPanel;
    private JPanel packagePathPanel;
    private JLabel packageIdLbl;
    private JTextField findPackageField;
    private JTextArea findPackageArea;
    private JTable sentPackagesTable;
    private JTable orderedPackagesTable;
    private JTable pathTable;
    private JButton findPackageBtn;
    private JLabel packageIdPathLbl;
    private JTextField pacakageIdPathField;
    private JButton findPathBtn;
    private JTextArea pathArea;

    public ClientFrame() {
        this.add(clientPanel);
        this.setSize(700, 500);
    }

    public JPanel getClientPanel() {
        return clientPanel;
    }

    public void setClientPanel(JPanel clientPanel) {
        this.clientPanel = clientPanel;
    }

    public JTabbedPane getClientPane() {
        return clientPane;
    }

    public void setClientPane(JTabbedPane clientPane) {
        this.clientPane = clientPane;
    }

    public JPanel getFindPackagePanel() {
        return findPackagePanel;
    }

    public void setFindPackagePanel(JPanel findPackagePanel) {
        this.findPackagePanel = findPackagePanel;
    }

    public JPanel getSentPackagesPanel() {
        return sentPackagesPanel;
    }

    public void setSentPackagesPanel(JPanel sentPackagesPanel) {
        this.sentPackagesPanel = sentPackagesPanel;
    }

    public JPanel getOrderedPackagesPanel() {
        return orderedPackagesPanel;
    }

    public void setOrderedPackagesPanel(JPanel orderedPackagesPanel) {
        this.orderedPackagesPanel = orderedPackagesPanel;
    }

    public JPanel getPackagePathPanel() {
        return packagePathPanel;
    }

    public void setPackagePathPanel(JPanel packagePathPanel) {
        this.packagePathPanel = packagePathPanel;
    }

    public JLabel getPackageIdLbl() {
        return packageIdLbl;
    }

    public void setPackageIdLbl(JLabel packageIdLbl) {
        this.packageIdLbl = packageIdLbl;
    }

    public JTextField getFindPackageField() {
        return findPackageField;
    }

    public void setFindPackageField(JTextField findPackageField) {
        this.findPackageField = findPackageField;
    }

    public JTextArea getFindPackageArea() {
        return findPackageArea;
    }

    public void setFindPackageArea(JTextArea findPackageArea) {
        this.findPackageArea = findPackageArea;
    }

    public JTable getSentPackagesTable() {
        return sentPackagesTable;
    }

    public void setSentPackagesTable(JTable sentPackagesTable) {
        this.sentPackagesTable = sentPackagesTable;
    }

    public JTable getOrderedPackagesTable() {
        return orderedPackagesTable;
    }

    public void setOrderedPackagesTable(JTable orderedPackagesTable) {
        this.orderedPackagesTable = orderedPackagesTable;
    }

    public JTable getPathTable() {
        return pathTable;
    }

    public void setPathTable(JTable pathTable) {
        this.pathTable = pathTable;
    }

    public JButton getFindPackageBtn() {
        return findPackageBtn;
    }

    public void setFindPackageBtn(JButton findPackageBtn) {
        this.findPackageBtn = findPackageBtn;
    }

    public JLabel getPackageIdPathLbl() {
        return packageIdPathLbl;
    }

    public void setPackageIdPathLbl(JLabel packageIdPathLbl) {
        this.packageIdPathLbl = packageIdPathLbl;
    }

    public JTextField getPacakageIdPathField() {
        return pacakageIdPathField;
    }

    public void setPacakageIdPathField(JTextField pacakageIdPathField) {
        this.pacakageIdPathField = pacakageIdPathField;
    }

    public JButton getFindPathBtn() {
        return findPathBtn;
    }

    public void setFindPathBtn(JButton findPathBtn) {
        this.findPathBtn = findPathBtn;
    }

    public JTextArea getPathArea() {
        return pathArea;
    }

    public void setPathArea(JTextArea pathArea) {
        this.pathArea = pathArea;
    }
}
