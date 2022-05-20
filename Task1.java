public class Task1 {

    public static void Start() {
        Book[] books = new Book[] {
                new Book("Програмування мовою Java", "author1", "publishing", 2018),
                new Book("Інтерфейси та взаємодії", "author1", "publishing", 2020),
                new Book("ООП", "author1", "publishing", 2010),
                new Book(".Net мова програмування с#", "author1", "publishing", 2021),
                new Book("Основи програмної інженерії", "author1", "publishing", 2019)
        };

        System.out.println("Книги з словом \"програмування\": ");
        Book.TaskPrint(books);
    }
}
