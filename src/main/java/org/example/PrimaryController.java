package org.example;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.example.App;
import org.example.ChatController;
import org.example.utilies.Validation;

public class PrimaryController {

    @FXML
    private TextField phoneNumber;

    @FXML
    private Text errorPhoneNumber;

    @FXML
    private PasswordField password;

    @FXML
    private Text errorPassword;

    @FXML
    private Button loginButton;
    @FXML
    private void switchToLogin()  {
        try {
            App.setRoot("register");
        }
        catch(IOException e){
            System.out.println("no fxml file");
        }
    }

    @FXML
    private void phoneNumberChanged(KeyEvent evnet){
        if(!Validation.validatePhoneNumber(phoneNumber.getText())){
            errorPhoneNumber.setVisible(true);
            password.setDisable(true);
            loginButton.setDisable(true);
            errorPhoneNumber.setText("Not A Valid Phone Number");
        }
        else{
            password.setDisable(false);
            loginButton.setDisable(false);
            errorPhoneNumber.setVisible(false);
        }

    }
    @FXML
    private void loginButtonClicked(ActionEvent event){
        if(!Validation.validatePhoneNumber(phoneNumber.getText())){
            errorPhoneNumber.setVisible(true);
            errorPhoneNumber.setText("Not A Valid Phone Number");
        }
        else{
            password.setDisable(false);
            errorPhoneNumber.setVisible(false);
            loadChatPage(event);
        }
    }

    private void loadChatPage(ActionEvent event){
        try {
            App.setRoot("chat");
        }
            catch(IOException e){
            System.out.println("no chat.fxml file");
        }
    }
}
