package designModel.iteratorModel;

public class BookShelfIterator implements Iterator {

    private BookShelf bookShelf;

    private int index = 0;


    public BookShelfIterator(BookShelf bookShelf) {
        this.bookShelf = bookShelf;
    }

    public boolean hasNext() {

        if (index >= bookShelf.getLength()) {
            return false;
        } else {
            return true;
        }

    }

    public Object next() {
        Book book = bookShelf.getBookAt(index);
        index++;
        return book;
    }
}
