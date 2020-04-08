package library;

public class LibrarySystem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		 Create two new Book objects and assign them to references b1 and b2 - the first book is
//		 Divergent by Veronica Roth (Book ID: B001) and the second book is Green Eggs and Ham by
//		 Dr Seuss (Book ID: B002).
		//public Book (String bookID, String title, String author)
		
		Book b1 = new Book("B001", "Divergent", "Veronica Roth");
		Book b2 = new Book("B002", "Green Eggs and Ham", "Dr Seuss");
		

		
		b1.borrow("m1234");
		
		System.out.print(b1.toString());
		System.out.print(b2.toString());
		
		if (b1.returnBook() ==true) {
			System.out.print(b1.getTitle() + " has been returned successfully");
		}
		else {
			System.out.print(b1.getTitle() + " book is not on loan");
		}
		
		System.out.print(b1.toString());
		System.out.print(b2.toString());
	}

}
