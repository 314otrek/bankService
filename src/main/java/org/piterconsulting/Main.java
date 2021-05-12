package org.piterconsulting;

import org.piterconsulting.repository.ClientSpringJpaRepository;
import org.piterconsulting.repository.entity.Account;
import org.piterconsulting.repository.entity.Client;
import org.piterconsulting.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class Main implements CommandLineRunner {

    private  final BankService bankService;
    private final ClientSpringJpaRepository repository;
    @Autowired
    public Main(BankService bankService, ClientSpringJpaRepository repository) {
        this.bankService = bankService;
        this.repository = repository;
    }

    public static void main(String[] args) {
        SpringApplication.run(Main.class,args);
    }


    @Override
    public void run(String... args) throws Exception {

    final List<Client> list  = repository.findByName("Piotr");
    list.forEach(System.out::println);

        System.out.println("------------------");
    final Page<Client> pagex = repository.findByName("Piotr",PageRequest.of(0,1));
    pagex.getContent().forEach(System.out::println);

        System.out.println("-----------------------");

    for (int i =0;i<pagex.getTotalPages();i++){
        final Page<Client> page = repository.findByName("Piotr",PageRequest.of(i,1));
        page.getContent().forEach(System.out::println);
    }

        System.out.println("Sorted list by name ------------------------");
    final List<Client> list2 = repository.findAll(Sort.by("name"));
    list2.forEach(System.out::println);







//        try (Scanner scanner = new Scanner(System.in)) {
//            while (true) {
//                System.out.println("1 - add User");
//                System.out.println("2 - find User");
//                System.out.println("3 - exit App");
//                final String next = scanner.next();
//                if (next.equals("1")) {
//                    addUser(scanner);
//                }
//                if (next.equals("2")) {
//                    printUser(scanner);
//                }
//                if (next.equals("3")) {
//                    break;
//                }
//
//
//            }
//        }
    }

    private void printUser(Scanner scanner) {
        System.out.println("Enter mail: ");
        final String mail = scanner.next();
        System.out.println(bankService.findByEmail(mail));
    }

    private void addUser(Scanner scanner) {

        System.out.println("Enter name: ");
        final String name = scanner.next();
        System.out.println("Enter mail: ");
        final String mail = scanner.next();
        System.out.println("Enter balance: ");
        final double balance = scanner.nextDouble();
        final Account account = new Account(balance,"PLN");
        final List<Account>accounts = List.of(account);
       bankService.save(new Client(name,mail,accounts));

    }


}
