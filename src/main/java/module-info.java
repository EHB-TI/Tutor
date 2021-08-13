module Tutor {
    requires javafx.controls;
    requires javafx.base;
    requires javafx.graphics;
    requires javafx.fxml;
    requires java.sql;
    requires com.google.zxing;
    requires com.google.zxing.javase;
    requires twilio;
    requires totp;
    requires org.apache.commons.codec;
    requires jbcrypt;
    requires javax.mail.api;
    requires activation;




    exports GUI;
    exports Controller;
    exports DB;
    exports Entity;
    exports Exceptions;
}