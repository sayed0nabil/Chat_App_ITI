package org.example.model;

import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;

public class Contact extends HBox {
    private String name;
    private Image image;
    private UserStatus status;

    public Contact(String name, Image image, UserStatus status) {
        this.name = name;
        this.image = image;
        this.status = status;
        Circle circle = new Circle();
        circle.setRadius(30);
        circle.setFill(new ImagePattern(image));
        circle.setCenterY(75);
        Label nameLabel = new Label(name);
        nameLabel.setStyle("-fx-font-family: 'Comic Sans MS';-fx-font-size: 18;-fx-font-weight: 500;-fx-text-fill: WHITE;-fx-padding: 5 0 0 0;");
        HBox hBox = new HBox(5);
        Circle statusCircle = new Circle(5);
        statusCircle.setStyle("-fx-fill:  #33FF4B");
        Label statusLabel = new Label("Online");
        statusLabel.setStyle("-fx-text-fill: White");
        hBox.getChildren().addAll(statusCircle, statusLabel);
        VBox vBox = new VBox(10);
        vBox.getChildren().addAll(nameLabel, hBox);

        getChildren().addAll(circle, vBox);
    }

    {
        setSpacing(20);
        getStyleClass().add("contact");
        /*setStyle("-fx-background-color:  #1e82dc;\n" +
                "    " +
                "-fx-padding: 10 0 10 15; -fx-border-width: 2px;\n" +
                "    -fx-border-color: #1e82dc #1e82dc white #1e82dc");*/
        setHeight(150);
    }
}
