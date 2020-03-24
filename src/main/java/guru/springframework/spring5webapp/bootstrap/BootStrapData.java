package guru.springframework.spring5webapp.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;

@Component
public class BootStrapData implements CommandLineRunner {
	
	private final AuthorRepository authorRepository;
	private final BookRepository bookRepository;
	private final PublisherRepository publisherRepository;
	
	public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository ) {
		super();
		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
		this.publisherRepository = publisherRepository;
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
        Publisher Pengu = new Publisher("Pengu","2Street");
        publisherRepository.save(Pengu);
		
		Author Asif = new Author("Asiful", "Chowdhury");
		Book ddd = new Book("Domain Driven Design", "12323");
		
		Asif.getBooks().add(ddd);
		ddd.getAuthors().add(Asif);
		
		ddd.setPublisher(Pengu);
		Pengu.getBooks().add(ddd);
		
		authorRepository.save(Asif);
		bookRepository.save(ddd);
		publisherRepository.save(Pengu);
		
		Author John = new Author("John", "Rod");
		Book J2EE = new Book("J2EE Developer", "12424");
		
		John.getBooks().add(J2EE);
		J2EE.getAuthors().add(John);
		
		J2EE.setPublisher(Pengu);
		Pengu.getBooks().add(J2EE);
		
		authorRepository.save(John);
		bookRepository.save(J2EE);
		publisherRepository.save(Pengu);
	
		System.out.println("Started in Bootstrap");
		System.out.println("Number of Book: "+ bookRepository.count());
		System.out.println("Number of Publisher: " + publisherRepository.count());
		System.out.println("Number of Publisher Book:" + Pengu.getBooks().size());
	}

}
