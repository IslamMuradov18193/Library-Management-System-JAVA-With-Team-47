package constructor;
import java.util.ArrayList;

public class Book{
    private String title;
    private String author;
    private double rating;
    private ArrayList<String> reviews;

    public Book(String title, String author, double rating) {
        this.title = title;
        this.author = author;
        this.rating = rating;
        this.reviews = new ArrayList<>();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }
    
    public void setAuthor(String author) {
        this.author = author;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public ArrayList<String> getReviews(){
        return reviews;
    }

    public void addReview(String review) {
        reviews.add(review);
    }
    
    // CRUD Operations
    
    // Create
    public static Book createBook(String title, String author, double rating) {
        return new Book(title, author, rating);
    }
    
    // Read
    public void displayBookDetails() {
        System.out.println("Title: " + title + "\nAuthor: " + author + "\nRating: " + rating + "\nReviews: " + reviews);
    }
    
    // Update
    public void updateBook(String title, String author, double rating) {
        this.title = title;
        this.author = author;
        this.rating = rating;
    }
    
    // Delete
    public void deleteBook() {
        // Assuming you have some book management system where you remove the book from the library
        // For simplicity, let's just nullify the object here
        this.title = null;
        this.author = null;
        this.rating = 0.0;
        this.reviews.clear();
    }

    public void loadCSV(){
        // Method to load book data from CSV file
    }
    
    @Override
    public String toString() {
        return "Title: " + title + "\nAuthor: " + author + "\nRating: " + rating + "\nReviews: " + reviews;
    }
}
