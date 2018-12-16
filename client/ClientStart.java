package client;

import client.gui.GuiController;
import wsclient.Admin;
import wsclient.AdminService;
import wsclient.Path;
import wsclient.User;
import wsclientclient.ArrayOfArrayOfstring;
import wsclientclient.Client;
import wsclientclient.IClient;

import java.util.ArrayList;
import java.util.List;

public class ClientStart {
    public static void main(String[] args) {
        GuiController guiController = new GuiController();
        guiController.setupControl();
    }
}
