/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lessonfour;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author amith
 */
public class DataFormTableUpgraded extends JFrame {
    private JTable table;
    private DefaultTableModel tableModel;
    private JTextField nameField, emailField;
    private JButton submitButton, removeButton; // Added removeButton

    public DataFormTableUpgraded() {
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
        removeButton = new JButton("Remove Selected"); // Initialize removeButton

        formPanel.add(new JLabel("Name:"));
        formPanel.add(nameField);
        formPanel.add(new JLabel("Email:"));
        formPanel.add(emailField);
        formPanel.add(submitButton);
        formPanel.add(removeButton); // Add removeButton to the formPanel

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

        // Button Action for Removing Selected Row
        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int[] selectedRows = table.getSelectedRows();
                for (int i = selectedRows.length - 1; i >= 0; i--) {
                    tableModel.removeRow(selectedRows[i]);
                }
            }
        });
    }
}
