/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.idevexpert.schoolnotes_fts3096_desktop.data.dao;

import com.idevexpert.schoolnotes_fts3096_desktop.data.api.Api;
import com.idevexpert.schoolnotes_fts3096_desktop.data.rest.request.LoginAccountRequest;
import com.idevexpert.schoolnotes_fts3096_desktop.data.rest.response.LoginAccountResponse;
import com.idevexpert.schoolnotes_fts3096_desktop.data.service.LoginAccountService;
import com.idevexpert.schoolnotes_fts3096_desktop.view.JframeMain;
import com.idevexpert.schoolnotes_fts3096_desktop.view.login.LoginJPanel;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import raven.popup.GlassPanePopup;
import retrofit2.Response;

/**
 *
 * @author Jesus Gutierrez
 */
public class LoginDao {

    public ImageIcon iconGif = new ImageIcon(getClass().getResource("/gif.gif"));
    private Api api;

    public LoginDao() {
        api = new Api(LoginAccountService.class);
    }

    protected String[] asyncMethod(JTextField user, JPasswordField password, LoginJPanel loginJPanel, JframeMain jframeMain) {
        String passString = new String(password.getPassword());
        LoginAccountRequest accountLoginRequest = new LoginAccountRequest();
        accountLoginRequest.setPassword(passString);
        accountLoginRequest.setUsername(user.getText());
        try {
            Response<LoginAccountResponse> response = api.getService(LoginAccountService.class).loginAccount("desktop", accountLoginRequest).execute();

            if (response.isSuccessful()) {
                LoginAccountResponse responseBody = response.body();
                if (responseBody.getCode().equals(200)) {
                    jframeMain.setEnabled(true);
                    jframeMain.jLabel1.setText(responseBody.getAccountType());
                    GlassPanePopup.closePopupAll();
                    return new String[]{responseBody.getAccountType(), responseBody.getToken()};
                } else {
                    System.out.println("Error ------------------");
                    jframeMain.setEnabled(true);
                    loginJPanel.button1.setIcon(null);
                    loginJPanel.button1.setText("INICIAR SESIÓN");
                    loginJPanel.jLabel2.setText(responseBody.getMessage());
                    return null;
                }
            } else {
                JOptionPane.showMessageDialog(null, "Error vuelva a intentarlo otra vez",
                        "Error", JOptionPane.OK_OPTION, new ImageIcon());
                return null;
            }
        } catch (IOException ex) {
            jframeMain.setEnabled(true);
            loginJPanel.button1.setIcon(null);
            loginJPanel.button1.setText("INICIAR SESIÓN");
            JOptionPane.showMessageDialog(null, "Error de conexion",
                    "Error", JOptionPane.OK_OPTION, new ImageIcon());
            return null;
        }
    }

    protected String[] accountVerification(JTextField user, JPasswordField password, LoginJPanel loginJPanel, JframeMain jframeMain) {

        String passString = new String(password.getPassword());
        if (user.getText().isBlank() && passString.isBlank()) {
            loginJPanel.textField1.setHelperText("Inserte usuario");
            loginJPanel.passwordField1.setHelperText("Inserte contraseña");
            jframeMain.setEnabled(true);
            loginJPanel.button1.setIcon(null);
            loginJPanel.button1.setText("INICIAR SESIÓN");
            return null;
        }
        if (user.getText().isBlank()) {
            loginJPanel.textField1.setHelperText("Inserte usuario");
            jframeMain.setEnabled(true);
            loginJPanel.button1.setIcon(null);
            loginJPanel.button1.setText("INICIAR SESIÓN");
            return null;
        }
        if (passString.isBlank()) {
            loginJPanel.passwordField1.setHelperText("Inserte contraseña");
            jframeMain.setEnabled(true);
            loginJPanel.button1.setIcon(null);
            loginJPanel.button1.setText("INICIAR SESIÓN");
            return null;
        }
        return asyncMethod(user, password, loginJPanel, jframeMain);
    }

}
