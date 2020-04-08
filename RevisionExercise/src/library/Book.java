package library;

public class Book {

	// implement requirements A - D here
	private String bookID;
	private String title;
	private String author;
	private String borrowerID;
	// e book ID, title, author and borrower ID
	// create constructor book ID, title and author for the book in question
	public Book (String bookID, String title, String author) {
		
		this.bookID = bookID;
		this.title = title;
		this.author = author;
		this.borrowerID = null; //set this to null when new Book object is created.
		
	}

	// ...
	// method which allows the Book to be "returned" if it has been borrowed
	public boolean returnBook() {
		// if borrower ID has been set (ie. book has been borrowed)
		if (this.borrowerID != null) {
			// reset borrowerID to null and return true result
			this.borrowerID = null;
			return true;
		} else {
			// otherwise book is not currently borrowed so return false result
			return false;
		}
	}
	
//	 Once the system is up and running, we will need to be able to update the borrower ID when the
//	 Book has been borrowed - add a method public boolean borrow(String borrowerID) which
//	 checks if the book is available and if so sets the borrowerID instance variable to the borrowerID
//	 parameter. The method should return true if the book was borrowed otherwise false.

	public boolean borrow(String borrowerID) {
		// check if book is null which means it has not been borrowed
		if (this.borrowerID == null) {
			// book is null therefore can update it with value that has been passed in
			this.borrowerID = borrowerID;
			return true;
		}
		return false;
		
	}
	
	// format Book details to a String (useful for printing!)
	public String toString() {
		return String.format("Book ID: %s\nTitle: %s\nAuthor: %s\nBorrowed by: %s\n", this.bookID, this.title,
				this.author, this.borrowerID != null ? this.borrowerID : "Available");
	}
	// setters and getters 
	/**
	 * @return the bookID
	 */
	public String getBookID() {
		return bookID;
	}

	/**
	 * @param bookID the bookID to set
	 */
	public void setBookID(String bookID) {
		this.bookID = bookID;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

}
