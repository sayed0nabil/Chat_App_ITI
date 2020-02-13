package org.example;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import org.example.model.Contact;
import org.example.model.MSG;
import org.example.model.UserStatus;
import org.kordamp.ikonli.javafx.FontIcon;
import javafx.scene.control.Tooltip;
import java.net.URL;
import java.util.ResourceBundle;

public class ChatController implements Initializable, IChatController {

    @FXML
    TextArea messageTextArea;
    @FXML
    FontIcon profileIcon, groupIcon, logoutIcon, addFriendIcon, notificationIcon, saveChatIcon;

    @FXML
    VBox contactsList;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setToolTip();
        Contact contact=new Contact("Abdelrahman",new Image(getClass().getResourceAsStream("abdo.jpg")), UserStatus.ONLINE);
        contactsList.getChildren().add(contact);
    }

    public void sendMessage() {
        String message = messageTextArea.getText();
        messageTextArea.setText("");
        System.out.println(message);
    }

    public void sendAudio() {

    }

    public void saveChat() {

    }

    public void updateProfile() {

    }

    public void addContact() {

    }

    public void createGroupChat() {

    }

    public void changeStatus() {

    }

    public void showNotifications() {

    }

    public void enableChatBot() {

    }

    public void logout() {

    }

    public void exit() {

    }

    private void setToolTip(){
        Tooltip profileTooltip, groupTooltip, addFriendTooltip, notificationTooltip, saveChatTooltip, logoutTooltip;
        profileTooltip = new Tooltip("Profile");
        groupTooltip = new Tooltip("Group Chat");
        addFriendTooltip = new Tooltip("Add Friend");
        notificationTooltip = new Tooltip("Notification");
        saveChatTooltip = new Tooltip("Save Chat");
        logoutTooltip = new Tooltip("Logout");

        profileTooltip.setStyle("-fx-font-size: 14");
        groupTooltip.setStyle("-fx-font-size: 14");
        addFriendTooltip.setStyle("-fx-font-size: 14");
        notificationTooltip.setStyle("-fx-font-size: 14");
        saveChatTooltip.setStyle("-fx-font-size: 14");
        logoutTooltip.setStyle("-fx-font-size: 14");

        Tooltip.install(profileIcon, profileTooltip);
        Tooltip.install(groupIcon, groupTooltip);
        Tooltip.install(addFriendIcon, addFriendTooltip);
        Tooltip.install(notificationIcon, notificationTooltip);
        Tooltip.install(saveChatIcon, saveChatTooltip);
        Tooltip.install(logoutIcon, logoutTooltip);

    }

    @Override
    public void display(MSG message) {

    }
}
