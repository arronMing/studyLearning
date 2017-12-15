package designModel.iteratorModel;

public class main {

    public static void main(String args[]) {

        BookShelf bookShelf = new BookShelf(4);
        bookShelf.appendBook(new Book("1111111"));
        bookShelf.appendBook(new Book("2222222"));
        bookShelf.appendBook(new Book("3333333"));
        bookShelf.appendBook(new Book("4444444"));
        Iterator iterator = bookShelf.iterator();
        while (iterator.hasNext()) {
            Book book = (Book) iterator.next();
            System.out.println(book.getName());
        }


    }
}
