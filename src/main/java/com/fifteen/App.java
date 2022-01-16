package com.fifteen;

import javax.swing.UIManager;

import com.fifteen.auth.login.LoginPage;
import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatIntelliJLaf;
import com.formdev.flatlaf.FlatLightLaf;

public class App {
  public static void main(String[] args) throws Exception {
    // create the object of Login Page to test if it's working

    try {
      UIManager.setLookAndFeel(new FlatIntelliJLaf());
    } catch (Exception ex) {
      System.err.println("Failed to initialize LaF");
    }

    // Added functionality to the Login page
    // Available user: email: t@g.com | password: B
    new LoginPage();
    // new SignUpPage();

    // new EventPageMain();

    // Sending an email to recipient
    // mailUtils.sendMail("javacomtwentyone@gmail.com");
  }
}
