package gui.admin;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AdminLibraryFrame extends javax.swing.JPanel {

    private javax.swing.JButton addButton;
    private javax.swing.JButton editButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JPanel navigationPanel;
    private javax.swing.JButton removeButton;
    private javax.swing.JButton searchButton;
    private javax.swing.JTextField searchField;
    private javax.swing.JLabel WelcomeText;

    public AdminLibraryFrame() {
        initComponents();
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
                        "Title", "Author", "Score", "Review"
                }));
        jScrollPane1.setViewportView(jTable1);

        editButton.setBackground(new java.awt.Color(204, 204, 204));
        editButton.setText("Edit");
        editButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                editButtonActionPerformed(evt);
            }
        });

        addButton.setBackground(new java.awt.Color(204, 204, 204));
        addButton.setText("Add");
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

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
        WelcomeText.setText("General Library");

        javax.swing.GroupLayout navigationPanelLayout = new javax.swing.GroupLayout(navigationPanel);
        navigationPanel.setLayout(navigationPanelLayout);
        navigationPanelLayout.setHorizontalGroup(
                navigationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(navigationPanelLayout.createSequentialGroup()
                                .addGap(167, 167, 167)
                                .addComponent(WelcomeText)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE,
                                        Short.MAX_VALUE)));
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
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(
                                        javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jScrollPane1,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                458, Short.MAX_VALUE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(searchField,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        221,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(
                                                        javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(searchButton,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        Short.MAX_VALUE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(removeButton)
                                                .addGap(18, 18, 18)
                                                .addComponent(addButton)
                                                .addPreferredGap(
                                                        javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(editButton)))
                                .addContainerGap()));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(navigationPanel,
                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(
                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(
                                        javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(searchField,
                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(searchButton))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(
                                        javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(editButton)
                                        .addComponent(addButton)
                                        .addComponent(removeButton))
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane1,
                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                        201,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE,
                                        Short.MAX_VALUE)));

        DatabaseHandler HB = new DatabaseHandler();
        HB.populateTable(jTable1, "src\\csvfiles\\brodsky.csv");

    }

    // Starter
    public static void Starter() {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new JFrame("Admin Library");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLocationRelativeTo(null);
                frame.getContentPane().add(new AdminLibraryFrame());
                frame.pack();
                frame.setVisible(true);
            }
        });
    }

    private void searchFieldActionPerformed(java.awt.event.ActionEvent evt) {
        search();
    }

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {
        search();
    }

    void search() {
        String query = searchField.getText(); // Get the text from the search field
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel(); // Get the table model

        // Clear the table before populating it with search results
        model.setRowCount(0);

        // Populate the table with search results based on the query
        DatabaseHandler databaseHandler = new DatabaseHandler();
        databaseHandler.populateTable(jTable1, "src\\csvfiles\\brodsky.csv", query);
    }

    private boolean deleteBookFromCSV(String isbnToDelete) {
        try {
            File csvFile = new File("src\\csvfiles\\brodsky.csv");
            List<List<String>> csvData = new ArrayList<>();

            // Read CSV
            BufferedReader reader = new BufferedReader(new FileReader(csvFile));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] row = line.split(",");
                // Skip row if ISBN matches
                if (!row[0].equals(isbnToDelete)) {
                    csvData.add(Arrays.asList(row));
                }
            }
            reader.close();

            // Write modified CSV
            BufferedWriter writer = new BufferedWriter(new FileWriter(csvFile));
            for (List<String> row : csvData) {
                writer.write(String.join(",", row));
                writer.newLine();
            }
            writer.close();

            return true; // Success
        } catch (IOException e) {
            e.printStackTrace();
            return false; // Failure
        }
    }

    private void removeButtonActionPerformed(java.awt.event.ActionEvent evt) {
        int selectedRowIndex = jTable1.getSelectedRow();
        if (selectedRowIndex != -1) {
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            String isbnToDelete = (String) model.getValueAt(selectedRowIndex, 0); // Assuming ISBN is in the first column
            model.removeRow(selectedRowIndex);

            // Call a function to handle CSV file deletion
            if (deleteBookFromCSV(isbnToDelete)) {
                JOptionPane.showMessageDialog(null, "Book deleted successfully.");
            } else {
                JOptionPane.showMessageDialog(null, "Error deleting book.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Please select a book to remove.");
        }
    }

    private void addButtonActionPerformed(ActionEvent evt) {
        new AddBookFrame(this).setVisible(true);
    }

    private void editButtonActionPerformed(ActionEvent evt) {
        int selectedRowIndex = jTable1.getSelectedRow();
        if (selectedRowIndex != -1) {
            // Open the EditBookFrame with selected book details
            new EditBookFrame((DefaultTableModel) jTable1.getModel(), jTable1, selectedRowIndex);
        } else {
            JOptionPane.showMessageDialog(null, "Please select a book to edit.");
        }
    }

    public static void main(String[] args) {
        AdminLibraryFrame.Starter();
    }
}

class AddBookFrame extends JFrame {

    private JLabel lblTitle, lblAuthor, lblRating, lblReview;
    private JTextField txtTitle, txtAuthor, txtRating, txtReview;
    private JButton btnAdd;

    private AdminLibraryFrame parentFrame;

    public AddBookFrame(AdminLibraryFrame parentFrame) {
        this.parentFrame = parentFrame;
        setTitle("Add Book");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);

        lblTitle = new JLabel("Title:");
        lblTitle.setBounds(20, 20, 80, 25);
        add(lblTitle);

        txtTitle = new JTextField();
        txtTitle.setBounds(120, 20, 200, 25);
        add(txtTitle);

        lblAuthor = new JLabel("Author:");
        lblAuthor.setBounds(20, 60, 80, 25);
        add(lblAuthor);

        txtAuthor = new JTextField();
        txtAuthor.setBounds(120, 60, 200, 25);
        add(txtAuthor);

        lblRating = new JLabel("Rating:");
        lblRating.setBounds(20, 100, 80, 25);
        add(lblRating);

        txtRating = new JTextField();
        txtRating.setBounds(120, 100, 200, 25);
        add(txtRating);

        lblReview = new JLabel("Review:");
        lblReview.setBounds(20, 140, 80, 25);
        add(lblReview);

        txtReview = new JTextField();
        txtReview.setBounds(120, 140, 200, 25);
        add(txtReview);

        btnAdd = new JButton("Add");
        btnAdd.setBounds(150, 200, 100, 30);
        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String title = txtTitle.getText();
                String author = txtAuthor.getText();
                double rating = Double.parseDouble(txtRating.getText());
                String review = txtReview.getText();

                // Call a function to add the book to the database
                addBookToDatabase(title, author, rating, review);

                // Close the window after adding the book
                dispose();
            }
        });
        add(btnAdd);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void addBookToDatabase(String title, String author, double rating, String review) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("src\\csvfiles\\brodsky.csv", true))) {
            writer.write(title + "," + author + "," + rating + "," + review);
            writer.newLine();
            System.out.println("Book added to database and CSV file.");
            // Refresh the table in the parent frame
            parentFrame.search(); // Assuming you have a method to refresh the table in the parent frame
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class EditBookFrame extends JFrame {

    private JTextField txtTitle, txtAuthor, txtRating, txtReview;
    private JButton btnSave;

    private DefaultTableModel tableModel;
    private int selectedRowIndex;

    public EditBookFrame(DefaultTableModel tableModel, JTable table, int selectedRowIndex) {
        this.tableModel = tableModel;
        this.selectedRowIndex = selectedRowIndex;

        setTitle("Edit Book");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);

        JLabel lblTitle = new JLabel("Title:");
        lblTitle.setBounds(20, 20, 80, 25);
        add(lblTitle);

        txtTitle = new JTextField();
        txtTitle.setBounds(120, 20, 200, 25);
        add(txtTitle);

        JLabel lblAuthor = new JLabel("Author:");
        lblAuthor.setBounds(20, 60, 80, 25);
        add(lblAuthor);

        txtAuthor = new JTextField();
        txtAuthor.setBounds(120, 60, 200, 25);
        add(txtAuthor);

        JLabel lblRating = new JLabel("Rating:");
        lblRating.setBounds(20, 100, 80, 25);
        add(lblRating);

        txtRating = new JTextField();
        txtRating.setBounds(120, 100, 200, 25);
        add(txtRating);

        JLabel lblReview = new JLabel("Review:");
        lblReview.setBounds(20, 140, 80, 25);
        add(lblReview);

        txtReview = new JTextField();
        txtReview.setBounds(120, 140, 200, 25);
        add(txtReview);

        btnSave = new JButton("Save");
        btnSave.setBounds(150, 200, 100, 30);
        btnSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveChanges();
            }
        });
        add(btnSave);

        setLocationRelativeTo(null);
        setVisible(true);

        // Populate fields with selected book details
        populateFields();
    }

    private void populateFields() {
        // Get selected book details from the table
        String title = (String) tableModel.getValueAt(selectedRowIndex, 0);
        String author = (String) tableModel.getValueAt(selectedRowIndex, 1);
        String rating = (String) tableModel.getValueAt(selectedRowIndex, 2);
        String review = (String) tableModel.getValueAt(selectedRowIndex, 3);

        // Set the fields with the selected book details
        txtTitle.setText(title);
        txtAuthor.setText(author);
        txtRating.setText(rating);
        txtReview.setText(review);
    }

    private void saveChanges() {
        // Get edited details from the fields
        String title = txtTitle.getText();
        String author = txtAuthor.getText();
        String rating = txtRating.getText();
        String review = txtReview.getText();

        // Update the table model with the edited details
        tableModel.setValueAt(title, selectedRowIndex, 0);
        tableModel.setValueAt(author, selectedRowIndex, 1);
        tableModel.setValueAt(rating, selectedRowIndex, 2);
        tableModel.setValueAt(review, selectedRowIndex, 3);

        // Update the CSV file with the edited details
        DatabaseHandler databaseHandler = new DatabaseHandler();
        databaseHandler.updateBookInCSV(title, author, rating, review);

        // Close the window after saving changes
        dispose();
    }
}

class DatabaseHandler {

    public void populateTable(JTable table, String filePath) {
        // Populate the table from a CSV file
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                model.addRow(data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void populateTable(JTable table, String filePath, String query) {
        // Populate the table with search results from a CSV file
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                // Check if the query matches any data
                for (String value : data) {
                    if (value.contains(query)) {
                        model.addRow(data);
                        break;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void updateBookInCSV(String title, String author, String rating, String review) {
        try {
            File csvFile = new File("src\\csvfiles\\brodsky.csv");
            List<List<String>> csvData = new ArrayList<>();
    
            // Debugging statement
            System.out.println("Attempting to update book: " + title + " by " + author);
    
            BufferedReader reader = new BufferedReader(new FileReader(csvFile));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] row = line.split(",");
                // Debugging: print row elements
                System.out.println("Row elements: " + Arrays.toString(row));
    
                // Check if the row has at least two elements (for title and author)
                if (row.length >= 2) {
                    // Check for empty elements and adjust indices accordingly
                    String csvTitle = "";
                    String csvAuthor = "";
                    if (!row[0].isEmpty()) {
                        csvTitle = row[0].trim().toLowerCase();
                    }
                    if (!row[1].isEmpty()) {
                        csvAuthor = row[1].trim().toLowerCase();
                    }
                    // Check if titles and authors match, ignoring case
                    if (csvTitle.equals(title.trim().toLowerCase()) && csvAuthor.equals(author.trim().toLowerCase())) {
                        // Debugging statement
                        System.out.println("Found book to update.");
    
                        // Update rating and review if available
                        if (row.length >= 3) {
                            row[2] = rating;
                        } else {
                            row = Arrays.copyOf(row, 3);
                            row[2] = rating;
                        }
                        if (row.length >= 4) {
                            row[3] = review;
                        } else {
                            row = Arrays.copyOf(row, 4);
                            row[3] = review;
                        }
                        System.out.println("Updated rating: " + rating);
                        System.out.println("Updated review: " + review);
                    }
                } else {
                    // Print a warning if the row does not have enough elements
                    System.err.println("Skipping row: " + Arrays.toString(row) + " (insufficient elements)");
                }
                csvData.add(Arrays.asList(row));
            }
            reader.close();
    
            BufferedWriter writer = new BufferedWriter(new FileWriter(csvFile));
            for (List<String> row : csvData) {
                writer.write(String.join(",", row));
                writer.newLine();
            }
            writer.close();
            // Debugging statement
            System.out.println("CSV file updated successfully.");
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Error updating CSV file: " + e.getMessage());
        }
    }
    
    
    
    
    
    
}
