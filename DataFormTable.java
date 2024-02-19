/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lessonfour;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author amith
 */
public class DataFormTable extends JFrame {
    private JTable table;
    private DefaultTableModel tableModel;
    private JTextField nameField, emailField;
    private JButton submitButton;

    public DataFormTable() {
        setTitle("Excel-like JTable with Form Submission");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Table Model Setup
        tableModel = new DefaultTableModel();
        // Define column names
        String[] columnNames = {"Name", "Email"};
        for (String columnName : columnNames) {
            tableModel.addColumn(columnName);
        }

        // Table Setup
        table = new JTable(tableModel);
        table.setGridColor(Color.GRAY);
        table.setSelectionBackground(Color.BLUE);
        table.setSelectionForeground(Color.WHITE);
        table.setRowHeight(25);
        table.setCellSelectionEnabled(true);
        JScrollPane scrollPane = new JScrollPane(table);

        // Form Setup
        JPanel formPanel = new JPanel();
        nameField = new JTextField(10);
        emailField = new JTextField(10);
        submitButton = new JButton("Submit");

        formPanel.add(new JLabel("Name:"));
        formPanel.add(nameField);
        formPanel.add(new JLabel("Email:"));
        formPanel.add(emailField);
        formPanel.add(submitButton);

        // Add components to the frame
        getContentPane().add(formPanel, BorderLayout.NORTH);
        getContentPane().add(scrollPane, BorderLayout.CENTER);

        // Button Action for Form Submission
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText().trim();
                String email = emailField.getText().trim();
                if (!name.isEmpty() && !email.isEmpty()) {
                    tableModel.addRow(new Object[]{name, email});
                    nameField.setText(""); // Clear the name field
                    emailField.setText(""); // Clear the email field
                }
            }
        });
    }
    
}
