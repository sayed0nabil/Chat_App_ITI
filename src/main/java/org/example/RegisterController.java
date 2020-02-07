package org.example;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import org.example.App;

public class RegisterController implements Initializable {


    @FXML
    public void handleResetAction(){

    }
    @FXML
    public void handleSubmitAction() {
        try {
            App.setRoot("login");
        }
        catch(IOException e){
            System.out.println("no fxml file");
        }
    }
    @FXML
    public void handleBackAction(){
        try {
            App.setRoot("login");
        }
        catch(IOException e){
            System.out.println("no fxml file");
        }
    }
    @FXML
    ComboBox<String> country;
    @FXML
    RadioButton female;
    @FXML
    RadioButton male;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ToggleGroup tg = new ToggleGroup();
        female.setToggleGroup(tg);
        male.setToggleGroup(tg);
    }
}