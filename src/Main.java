import businessstrategy.Console;
import businessstrategy.Repository;
import domain.books.Book;
import domain.books.BookSample;
import domain.user.GraduationStudent;
import domain.user.PosGraduationStudent;
import domain.user.Professor;
import domain.user.User;
import strategy.ProfessorLoanStrategy;
import strategy.StudentLoanStrategy;

public class Main {
    public static void main(String[] args) {

        Repository repositorio = Repository.getInstace();
        Console console = Console.getInstance();

        User us1 = new GraduationStudent("123", "João da Silva", new StudentLoanStrategy());
        User us2 = new PosGraduationStudent("456", "Luiz Fernando Rodrigues", new StudentLoanStrategy());
        User us3 = new GraduationStudent("789", "Pedro Paulo", new StudentLoanStrategy());
        User us4 = new Professor("100", "Carlos Lucena", new ProfessorLoanStrategy());

        Book b1 = new Book("100", "Engenharia de Software", "Addison Wesley", "Ian Sommervile", "6ª", "2000");
        Book b2 = new Book("101", "UML - Guia do Usuário", "Campus", "Grady Booch, James Rumbaugh, Ivar, Jacobson", "7ª", "2000");
        Book b3 = new Book("200", "Code Complete", "Microsoft Press", "Steve McConnell", "2ª", "2014");
        Book b4 = new Book("201", "Agile Software Development Principles, Patterns and Practices", "Prentice Hall", "Robert Martin", "1ª", "2002");
        Book b5 = new Book("300", "Refactoring: Improving the Design of Existing Code", "Addison Wesley Professional", "Martin Fowler", "1ª", "1999");
        Book b6 = new Book("301", "Software Metrics: A rigorous and Practical Approach", "CRC Press", "Norman Fenton, James Bieman", "3ª", "2014");
        Book b7 = new Book("400", "Design Patterns: Element of Reusable Object-Oriented Software", "Addison Wesley Professional", "Erich Gamma, Richard Helm, Ralph Johnson, John Vlissides", "1ª", "1994");
        Book b8 = new Book("401", "UML Distilled: A Brief Guide to the Standard Object Modeling Language", "Addison Wesley Professional", "Martin Fowler", "3ª", "2003");

        b1.addSample(new BookSample("01", b1));
        b1.addSample(new BookSample("02", b1));
        b2.addSample(new BookSample("03", b2));
        b3.addSample(new BookSample("04", b3));
        b4.addSample(new BookSample("05", b4));
        b5.addSample(new BookSample("06", b5));
        b7.addSample(new BookSample("07", b7));
        b7.addSample(new BookSample("08", b7));

        repositorio.addUser(us1);
        repositorio.addUser(us2);
        repositorio.addUser(us3);
        repositorio.addUser(us4);

        repositorio.addBook(b1);
        repositorio.addBook(b2);
        repositorio.addBook(b3);
        repositorio.addBook(b4);
        repositorio.addBook(b5);
        repositorio.addBook(b6);
        repositorio.addBook(b7);
        repositorio.addBook(b8);

        console.start();
    }
}
