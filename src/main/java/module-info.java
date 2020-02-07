module org.example {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires mysql.connector.java;
    requires java.naming;
    requires org.kordamp.ikonli.javafx;
    opens org.example to javafx.fxml;
    exports org.example;
}
