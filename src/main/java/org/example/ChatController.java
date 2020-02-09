package org.example;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import org.kordamp.ikonli.javafx.FontIcon;
import javafx.scene.control.Tooltip;
import java.net.URL;
import java.util.ResourceBundle;

public class ChatController implements Initializable, ChatControllerInterface {

    @FXML
    TextArea messageTextArea;
    @FXML
    FontIcon profileIcon, groupIcon, logoutIcon, addFriendIcon, notificationIcon, saveChatIcon;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setToolTip();
    }

    @Override
    public void sendMessage() {
        String message = messageTextArea.getText();
        messageTextArea.setText("");
        System.out.println(message);
    }

    @Override
    public void sendAudio() {

    }

    @Override
    public void saveChat() {

    }

    @Override
    public void updateProfile() {

    }

    @Override
    public void addContact() {

    }

    @Override
    public void createGroupChat() {

    }

    @Override
    public void changeStatus() {

    }

    @Override
    public void showNotifications() {

    }

    @Override
    public void enableChatBot() {

    }

    @Override
    public void logout() {

    }

    @Override
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
}
