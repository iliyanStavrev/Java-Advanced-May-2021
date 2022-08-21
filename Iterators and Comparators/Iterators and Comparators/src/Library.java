import java.util.Iterator;

public class Library implements Iterable<Book> {
    private Book[]books;

    public Library(Book...books){
        this.books = books;
    }

    public void setBooks(Book[] books) {
        this.books = books;
    }
    int index = 0;
    @Override
    public Iterator<Book> iterator() {

        Iterator<Book>iterator = new Iterator<Book>() {
            @Override
            public boolean hasNext() {
                return index < books.length;
            }

            @Override
            public Book next() {
                return books[index++];
            }
        };
        return iterator;
    }
}
