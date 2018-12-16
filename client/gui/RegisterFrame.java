package client.gui;

import javax.swing.*;
import java.awt.*;

public class RegisterFrame extends JFrame {
    private JPanel registerPanel;
    private JLabel usernameLbl;
    private JTextField usernameField;
    private JLabel paswLbl;
    private JPasswordField passwordField;
    private JButton registerButton;

    public RegisterFrame() throws HeadlessException {
        this.add(registerPanel);
        this.setSize(200,100);
    }

    public JPanel getRegisterPanel() {
        return registerPanel;
    }

    public void setRegisterPanel(JPanel registerPanel) {
        this.registerPanel = registerPanel;
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

    public JLabel getPaswLbl() {
        return paswLbl;
    }

    public void setPaswLbl(JLabel paswLbl) {
        this.paswLbl = paswLbl;
    }

    public JPasswordField getPasswordField() {
        return passwordField;
    }

    public void setPasswordField(JPasswordField passwordField) {
        this.passwordField = passwordField;
    }

    public JButton getRegisterButton() {
        return registerButton;
    }

    public void setRegisterButton(JButton registerButton) {
        this.registerButton = registerButton;
    }
}
