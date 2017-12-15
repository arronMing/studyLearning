package designModel.iteratorModel;

public class BookShelf implements Aggregate {

    private Book[] books;

    private int last = 0;

    public BookShelf(int size) {
        this.books = new Book[size];
    }

    public Book getBookAt(int index) {
        return books[index];
    }

    public void appendBook(Book book) {
        books[last] = book;
        last++;
    }

    public int getLength() {
        return last;
    }


    public Iterator iterator() {
        return new BookShelfIterator(this);
    }
}
