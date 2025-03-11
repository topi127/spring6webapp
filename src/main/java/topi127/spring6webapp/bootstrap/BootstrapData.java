package topi127.spring6webapp.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import topi127.spring6webapp.domain.Author;
import topi127.spring6webapp.domain.Book;
import topi127.spring6webapp.repositories.AuthorRepository;
import topi127.spring6webapp.repositories.BookRepository;

@Component
public class BootstrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author kevin = new Author();
        kevin.setFirstName("Kevin");
        kevin.setLastName("Mitnick");

        Book kevinBook = new Book();
        kevinBook.setTitle("The Art of Invisibility");
        kevinBook.setIsbn("123456789");

        Author kevinSaved = authorRepository.save(kevin);
        Book kevinBookSaved = bookRepository.save(kevinBook);

        Author rodrigo = new Author();
        rodrigo.setFirstName("Rodrigo");
        rodrigo.setLastName("Rodrigues");

        Book rodrigoBook = new Book();
        rodrigoBook.setTitle("Java Book");
        rodrigoBook.setIsbn("12345389");

        Author rodrigoSaved = authorRepository.save(rodrigo);
        Book rodrioBookSaved = bookRepository.save(rodrigoBook);

        kevinSaved.getBooks().add(kevinBookSaved);
        rodrigoSaved.getBooks().add(rodrioBookSaved);
        
        kevinBookSaved.getAuthors().add(kevinSaved);
        rodrigoBook.getAuthors().add(rodrigoSaved);

        authorRepository.save(kevinSaved);
        authorRepository.save(rodrigoSaved);

        System.out.println("In bootstrap");
        System.out.println("Author count " + authorRepository.count());
        System.out.printf("Book count" + bookRepository.count());
    }
}
