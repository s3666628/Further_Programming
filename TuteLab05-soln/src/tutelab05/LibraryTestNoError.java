package tutelab05;

import tutelab05.library.Book;
import tutelab05.library.DigitalVersatileDisc;
import tutelab05.library.Library;
import tutelab05.library.Media;

public class LibraryTestNoError
{
   public static void main(String[] args)
   {
      Library<Media> myMedias = new Library<Media>();
      Library<? super Book> my5 = myMedias;

      my5.add(new Book());
      myMedias.add(new DigitalVersatileDisc());
      // prints: Library: { \n a book \n a really versatile disc of the digital type \n }
      my5.print();
   }
}
