package scripts;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class DatabaseHandler {

    // Method to populate the table with all data from the file
    public void populateTable(JTable table, String link) {
        populateTable(table, link, null); // Call the main method with null searchQuery
    }

    // Method to populate the table with data from the file based on search query
    public void populateTable(JTable table, String link, String searchQuery) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0); // Clear the table

        try (BufferedReader br = new BufferedReader(new FileReader(link))) {
            String line;
            boolean firstRow = true;
            while ((line = br.readLine()) != null) {
                if (firstRow) { // If skipFirstRow is true and it's the first row, skip it
                    firstRow = false;
                    continue;
                }
                String[] parts = line.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)"); // Split the line with regex
                if (parts.length >= 2) { // Ensure there are at least title and author columns
                    String[] rowData = new String[parts.length]; // Array to hold data for each row

                    // Loop through each part and add it to the rowData array
                    for (int i = 0; i < parts.length; i++) {
                        String data = parts[i].trim().replaceAll("^\"|\"$", ""); // Remove surrounding quotes
                        rowData[i] = data;
                    }

                    // Check if the search query is provided and if it matches any part of the row
                    // data
                    boolean match = true;
                    if (searchQuery != null) {
                        match = false;
                        for (String data : rowData) {
                            if (data.toLowerCase().contains(searchQuery.toLowerCase())) {
                                match = true;
                                break;
                            }
                        }
                    }

                    // If the row matches the search query (or if no search query is provided), add
                    // it to the table model
                    if (match) {
                        model.addRow(rowData);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean deleteBook(String title, String author) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteBook'");
    }

    public static void addToDatabase(String string, String[] rowData) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addToDatabase'");
    }

    public void appendDataToFile(String filePath, String data) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            writer.write(data);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void appendDataToPersonalDatabase(String data) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'appendDataToPersonalDatabase'");
    }

    // Method to remove a book from the database
    public boolean removeBook(String filePath, String title, String author) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            StringBuffer sb = new StringBuffer();
            String line;
            boolean removed = false;

            while ((line = reader.readLine()) != null) {
                if (line.contains(title) && line.contains(author)) {
                    removed = true;
                    continue;
                }
                sb.append(line);
                sb.append("\n");
            }
            reader.close();

            if (removed) {
                BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));
                writer.write(sb.toString());
                writer.close();
            }

            return removed;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}
