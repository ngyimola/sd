package client.gui;

import javax.swing.*;
import java.awt.*;

public class LoginFrame extends JFrame{
    private JPanel loginPanel;
    private JLabel usernameLbl;
    private JTextField usernameField;
    private JLabel passwordLbl;
    private JPasswordField passwordField;
    private JButton loginBtn;
    private JButton regBtn;

    public LoginFrame() throws HeadlessException {
        this.add(loginPanel);
        this.setVisible(true);
        this.setSize(400, 300);
    }

    public JPanel getLoginPanel() {
        return loginPanel;
    }

    public void setLoginPanel(JPanel loginPanel) {
        this.loginPanel = loginPanel;
    }

    public JLabel getUsernameLbl() {
        return usernameLbl;
    }

    public void setUsernameLbl(JLabel usernameLbl) {
        this.usernameLbl = usernameLbl;
    }

    public JTextField getUsernameField() {
        return usernameField;
    }

    public void setUsernameField(JTextField usernameField) {
        this.usernameField = usernameField;
    }

    public JLabel getPasswordLbl() {
        return passwordLbl;
    }

    public void setPasswordLbl(JLabel passwordLbl) {
        this.passwordLbl = passwordLbl;
    }

    public JPasswordField getPasswordField() {
        return passwordField;
    }

    public void setPasswordField(JPasswordField passwordField) {
        this.passwordField = passwordField;
    }

    public JButton getLoginBtn() {
        return loginBtn;
    }

    public void setLoginBtn(JButton loginBtn) {
        this.loginBtn = loginBtn;
    }

    public JButton getRegBtn() {
        return regBtn;
    }

    public void setRegBtn(JButton regBtn) {
        this.regBtn = regBtn;
    }
}
