package org.example;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Locale;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import org.example.utilies.Validation;

public class RegisterController implements Initializable,RegisterInt {
    @FXML
    ComboBox<String> countryBox;
    @FXML
    Circle circlePhoto;
    @FXML
    RadioButton female;
    @FXML
    RadioButton male;
    @FXML
    Text errorPhoneNumber;
    @FXML
    TextField phoneNumber;
    @FXML
    TextField name;
    @FXML
    Text nameError;
    @FXML
    TextField password;
    @FXML
    Text passwordError;
    @FXML
    Text ConfirmePasswordError;
    @FXML
    TextField confirmPassword;
    @FXML
    TextField email;
    @FXML
    Text emailError;
    @FXML
    Text radioButtonError;
    @FXML
    DatePicker dateOfBirth;
    @FXML
    Text countryError;
    @FXML
    Text dateError;
    @FXML
    Text bioError;
    @FXML
    TextArea bio;
    ToggleGroup tg;
    ArrayList<String> countries;
    Image defaultImage = new Image("file:/C:/Users/Aya/Desktop/IO/Icon.jpg");
    //Image defaultImage = new Image("files:resources.org.example.Icon.jpg");




    public boolean checkingRadioButtons(){

         if( tg.getSelectedToggle()==null){
             radioButtonError.setVisible(true);
             radioButtonError.setText("Required field");
             return false;
        }
        else {
             radioButtonError.setVisible(false);
             return true;
        }

    }
    public boolean checkDatePicker(){
        if(dateOfBirth.getValue()==null) {
            dateError.setVisible(true);
            dateError.setText("Required field");
            return false;
        } else {
            dateError.setVisible(false);
            return true;
        }

    }

    public boolean checkingPhoneNum(){
        if(phoneNumber.getText().equals("")){
            errorPhoneNumber.setVisible(true);
            errorPhoneNumber.setText("Required field");
            return false;
        }
        else if(!Validation.validatePhoneNumber(phoneNumber.getText())){
            errorPhoneNumber.setVisible(true);
            errorPhoneNumber.setText("Not a Valid Phone Number");
            return false;
        }
        else {
            errorPhoneNumber.setVisible(false);
            return true;
        }

    }

    public boolean checkingName(){
        if(name.getText().equals("")){
            nameError.setVisible(true);
            nameError.setText("Required field");
            return false;
        }else{
            nameError.setVisible(false);
            return true;
        }
    }

    public boolean checkingEmail(){
        if(email.getText().equals("")){
            emailError.setVisible(true);
            emailError.setText("Required field");
            return false;
        }
        else if(!Validation.validateEmail(email.getText())){
            emailError.setVisible(true);
            emailError.setText("Not a valid email");
            return false;
        }
        else{
            emailError.setVisible(false);
            return true;
        }
    }
    public boolean checkComboBox(){

        if(countryBox.getSelectionModel().isEmpty()){

            if(countryBox.getValue()!=null &&countries.contains(countryBox.getValue().toLowerCase())){
                countryError.setVisible(false);
                return true;
            }
            else if(countryBox.getValue()==null||countryBox.getValue().equals("")){
                countryError.setVisible(true);
                countryError.setText("Required field");
                return false;
            }
            else{
                countryError.setVisible(true);
                countryError.setText("Not a valid country name");
                return false;
            }

        }
        else{
            countryError.setVisible(false);
            return true;
        }





    }
    public boolean checkBio(){
        if(bio.getText().equals("")){
            bioError.setVisible(true);
            bioError.setText("Required field");
            return false;
        }
        else{
            bioError.setVisible(false);
            return true;
        }
    }
    @FXML
    public boolean checkingPassword(){
        if(!confirmPassword.getText().equals("")){
            checkingConfirmPassword();
        }
        if(password.getText().equals("")){
            passwordError.setVisible(true);
            passwordError.setText("Required field");
            return false;
        }
        else if(!Validation.validatePassword(password.getText())){
            passwordError.setVisible(true);
            passwordError.setText("Not a Valid Password");
            return false;
        }
        else{
            passwordError.setVisible(false);
            return true;
        }

    }
    @FXML
    public boolean checkingConfirmPassword(){
        if(confirmPassword.getText().equals("")){
            ConfirmePasswordError.setVisible(true);
            ConfirmePasswordError.setText("Required field");
            return false;
        }
        else if(!Validation.validateConfiermedPassword(confirmPassword.getText(),password.getText())){
            ConfirmePasswordError.setVisible(true);
            ConfirmePasswordError.setText("Not matched");
            return false;
        }
        else{
            ConfirmePasswordError.setVisible(false);
            return true;
        }
    }




    @FXML
    public void handleAddPhotoAction(){
        FileChooser open = new FileChooser();
        open.getExtensionFilters().addAll(new javafx.stage.FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg"));
        File file = open.showOpenDialog(null);
        if (file != null) {
            Image image1 = new Image(file.toURI().toString());
            circlePhoto.setFill(new ImagePattern(image1));
        }

    }
    @FXML
    public void handleSubmitAction() {
        if(checkingPhoneNum()&checkingRadioButtons()&checkComboBox()&checkBio()&checkingName()&checkingEmail()&checkingPassword()&checkingConfirmPassword()&checkDatePicker()) {
            try {
                App.setRoot("login");
            } catch (IOException e) {
                System.out.println("no fxml file");
            }
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
    public void handleResetAction(){
        phoneNumber.setText("");
        name.setText("");
        password.setText("");
        confirmPassword.setText("");
        email.setText("");
        bio.setText("");
        countryBox.getSelectionModel().select(0);
        countryBox.getSelectionModel().clearSelection();
        countryBox.setPromptText("Country");
        dateOfBirth.setValue(null);
        female.setSelected(false);
        male.setSelected(false);
        errorPhoneNumber.setVisible(false);
        nameError.setVisible(false);
        passwordError.setVisible(false);
        ConfirmePasswordError.setVisible(false);
        emailError.setVisible(false);
        dateError.setVisible(false);
        bioError.setVisible(false);
        countryError.setVisible(false);
        radioButtonError.setVisible(false);
        circlePhoto.setFill(new ImagePattern(defaultImage));
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        tg = new ToggleGroup();
        female.setToggleGroup(tg);
        male.setToggleGroup(tg);

        circlePhoto.setFill(new ImagePattern(defaultImage));

        countries = new ArrayList<String>();
        String[] countryCodes = Locale.getISOCountries();
        for (int i = 0; i < countryCodes.length; i++) {
            Locale obj = new Locale("", countryCodes[i]);
          //  countries.add( obj.getDisplayCountry());
            countryBox.getItems().addAll(obj.getDisplayCountry());
            countries.add( obj.getDisplayCountry().toLowerCase());

        }
        //countryBox.getItems().addAll(countries);

    }

    public RegisterController() {
    }
}