package gui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import constructor.SortableTable;
import scripts.DatabaseHandler;

public class PersonalLibraryFrame extends javax.swing.JPanel {

    public PersonalLibraryFrame() {
        initComponents();
        SortableTable.makeSortable(jTable1); // Make the table sortable
    }

    private void initComponents() {
        searchField = new javax.swing.JTextField();
        searchButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        editButton = new javax.swing.JButton();
        addButton = new javax.swing.JButton();
        removeButton = new javax.swing.JButton();
        navigationPanel = new javax.swing.JPanel();
        WelcomeText = new javax.swing.JLabel();

        setBackground(new java.awt.Color(44, 46, 67));

        searchField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchFieldActionPerformed(evt);
            }
        });

        searchButton.setBackground(new java.awt.Color(204, 204, 204));
        searchButton.setText("Search");
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null}
                },
                new String[]{
                        "Title", "Author", "Review", "Score"
                }));

        jScrollPane1.setViewportView(jTable1);

        editButton.setBackground(new java.awt.Color(204, 204, 204));
        editButton.setText("Edit");

        addButton.setBackground(new java.awt.Color(204, 204, 204));
        addButton.setText("Add");

        removeButton.setBackground(new java.awt.Color(204, 204, 204));
        removeButton.setText("Remove");
        removeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeButtonActionPerformed(evt);
            }
        });

        navigationPanel.setBackground(new java.awt.Color(89, 82, 96));

        WelcomeText.setFont(new java.awt.Font("Lucida Grande", 0, 18));
        WelcomeText.setForeground(new java.awt.Color(255, 213, 35));
        WelcomeText.setText("Personal Library");

        javax.swing.GroupLayout navigationPanelLayout = new javax.swing.GroupLayout(navigationPanel);
        navigationPanel.setLayout(navigationPanelLayout);
        navigationPanelLayout.setHorizontalGroup(
                navigationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(navigationPanelLayout.createSequentialGroup()
                                .addGap(161, 161, 161)
                                .addComponent(WelcomeText)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
        navigationPanelLayout.setVerticalGroup(
                navigationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(WelcomeText, javax.swing.GroupLayout.DEFAULT_SIZE, 35,
                                Short.MAX_VALUE));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(navigationPanel, javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout
                                .createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        458, Short.MAX_VALUE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        Short.MAX_VALUE)
                                                .addComponent(removeButton)
                                                .addGap(18, 18, 18)
                                                .addComponent(addButton)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(editButton))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING,
                                                layout.createSequentialGroup().addGap(29, 29, 29)
                                                        .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                221, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(18, 18, 18).addComponent(searchButton,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE, 103,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(0, 0, Short.MAX_VALUE)))
                                .addContainerGap()));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(navigationPanel, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14,
                                        Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(searchButton))
                                .addGap(40, 40, 40)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(editButton).addComponent(addButton).addComponent(removeButton))
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 201,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap()));

        DatabaseHandler HB = new DatabaseHandler();
        HB.populateTable(jTable1, "src\\csvfiles\\PersonalDatabse.csv");
    }

    public static void starter() {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new JFrame("Personal Library");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.getContentPane().add(new PersonalLibraryFrame());
                frame.pack();
                frame.setVisible(true);
                frame.setLocationRelativeTo(null);
            }
        });

    }

    private void searchFieldActionPerformed(java.awt.event.ActionEvent evt) {
        search();
    }

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {
        search();
    }

    private void search() {
        String query = searchField.getText();
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);
        DatabaseHandler databaseHandler = new DatabaseHandler();
        databaseHandler.populateTable(jTable1, "src\\csvfiles\\PersonalDatabse.csv", query);
    }

    private void removeButtonActionPerformed(java.awt.event.ActionEvent evt) {
        int selectedRowIndex = jTable1.getSelectedRow();
        if (selectedRowIndex == -1) {
            return;
        }
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        String title = (String) model.getValueAt(selectedRowIndex, 0);
        String author = (String) model.getValueAt(selectedRowIndex, 1);
        DatabaseHandler databaseHandler = new DatabaseHandler();
        boolean removed = databaseHandler.removeBook("src\\csvfiles\\PersonalDatabse.csv", title, author);
        if (removed) {
            model.removeRow(selectedRowIndex);
        } else {
            JOptionPane.showMessageDialog(this, "Failed to remove book from the database.", "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private javax.swing.JLabel WelcomeText;
    private javax.swing.JButton addButton;
    private javax.swing.JButton editButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JPanel navigationPanel;
    private javax.swing.JButton removeButton;
    private javax.swing.JButton searchButton;
    private javax.swing.JTextField searchField;

}

