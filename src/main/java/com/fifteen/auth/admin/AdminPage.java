package com.fifteen.auth.admin;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;

import com.fifteen.database.*;
import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import com.intellij.uiDesigner.core.Spacer;

/**
 * Admin GUI where the admin has access to all the users in the database and
 * thereby has the power to edit/delete users
 * and change their passwords in case the user forgets their password
 *
 * @author Ante Maric 1273904
 */

public class AdminPage extends JFrame {
  private JPanel adminPanel;
  private JButton editButton;
  private JButton deleteButton;
  private JTable users;
  private JLabel Database;
  private JFrame frame;

  public AdminPage() {

    DefaultTableModel model = new DefaultTableModel();

    users.setAutoCreateRowSorter(true);
    users.setFillsViewportHeight(true);
    users.setPreferredScrollableViewportSize(new Dimension(550, 200));
    /*
     * model.addColumn("email");
     * model.addColumn("username");
     * model.addColumn("password");
     * model.addRow(new Object[]{"PJ@gmail.com", "PJtheDJ", "AnimeMan69"});
     * model.addRow(new Object[]{"Tim@gmail.com", "SleepingMan", "MemeLegend77"});
     * model.addRow(new Object[]{"Jorge@gmail.com", "ChocolateLover", "YESSEY"});
     */
    users.setModel(model);

    frame = new JFrame("Admin frame");
    frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
    frame.setPreferredSize(new Dimension(600, 300));
    frame.setResizable(false);

    // adding the panel
    frame.add(adminPanel);
    frame.pack();
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);

    DefaultTableModel tblModel = (DefaultTableModel) users.getModel();
    try {
      // create connection to database
      DBMethod.createConnection();
      Statement st = DBConnection.getConnection().createStatement();
      // sql query
      // executeQuery("select * from userdb");
      ResultSet rs = st.executeQuery("select * from userdb");

      while (rs.next()) {
        // data will be added until finish
        String email = String.valueOf(rs.getString("email"));
        String username = rs.getString("username");
        String password = rs.getString("hashed_password");

        // string array to store data into jtable
        String tbData[] = new String[] { email, username, password };
        System.out.println(Arrays.toString(tbData));

        // add string array data into jtable
        tblModel.addRow(tbData);
      }

      DBMethod.closeConnection();
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }

  }

  {
    // GUI initializer generated by IntelliJ IDEA GUI Designer
    // >>> IMPORTANT!! <<<
    // DO NOT EDIT OR ADD ANY CODE HERE!
    $$$setupUI$$$();
  }

  /**
   * Method generated by IntelliJ IDEA GUI Designer
   * >>> IMPORTANT!! <<<
   * DO NOT edit this method OR call it in your code!
   *
   * @noinspection ALL
   */
  private void $$$setupUI$$$() {
    adminPanel = new JPanel();
    adminPanel.setLayout(new GridLayoutManager(1, 2, new Insets(0, 0, 0, 0), -1, -1));
    final Spacer spacer1 = new Spacer();
    adminPanel.add(spacer1, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_CENTER,
        GridConstraints.FILL_VERTICAL, 1, GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
    final JPanel panel1 = new JPanel();
    panel1.setLayout(new GridLayoutManager(7, 1, new Insets(0, 0, 0, 0), -1, -1));
    adminPanel.add(panel1,
        new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH,
            GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
            GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
    panel1.setBorder(BorderFactory.createTitledBorder(null, "", TitledBorder.DEFAULT_JUSTIFICATION,
        TitledBorder.DEFAULT_POSITION, null, null));
    Database = new JLabel();
    Database.setText("Database");
    panel1.add(Database, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE,
        GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
    final Spacer spacer2 = new Spacer();
    panel1.add(spacer2, new GridConstraints(6, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL, 1,
        GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
    final JPanel panel2 = new JPanel();
    panel2.setLayout(new GridLayoutManager(1, 2, new Insets(0, 0, 0, 0), -1, -1));
    panel1.add(panel2,
        new GridConstraints(5, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH,
            GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
            GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
    editButton = new JButton();
    editButton.setText("Edit");
    panel2.add(editButton,
        new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL,
            GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
            GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
    deleteButton = new JButton();
    deleteButton.setText("Delete");
    panel2.add(deleteButton,
        new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL,
            GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
            GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
    final Spacer spacer3 = new Spacer();
    panel1.add(spacer3, new GridConstraints(4, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL, 1,
        GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
    final Spacer spacer4 = new Spacer();
    panel1.add(spacer4, new GridConstraints(2, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL, 1,
        GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
    final JScrollPane scrollPane1 = new JScrollPane();
    panel1.add(scrollPane1,
        new GridConstraints(3, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH,
            GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW,
            GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
    users = new JTable();
    scrollPane1.setViewportView(users);
    final Spacer spacer5 = new Spacer();
    panel1.add(spacer5, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL, 1,
        GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
  }

  /**
   * @noinspection ALL
   */
  public JComponent $$$getRootComponent$$$() {
    return adminPanel;
  }

}
