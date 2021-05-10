package org.piterconsulting;

import org.piterconsulting.repository.ClientRipository;
import org.piterconsulting.repository.HibernateClientRepository;
import org.piterconsulting.repository.entity.Account;
import org.piterconsulting.repository.entity.Client;
import org.piterconsulting.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class Main implements CommandLineRunner {

    private  final BankService bankService;
    @Autowired
    public Main(BankService bankService) {
        this.bankService = bankService;
    }

    public static void main(String[] args) {
        SpringApplication.run(Main.class,args);
    }


    @Override
    public void run(String... args) throws Exception {


        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.println("1 - add User");
                System.out.println("2 - find User");
                System.out.println("3 - exit App");
                final String next = scanner.next();
                if (next.equals("1")) {
                    addUser(scanner);
                }
                if (next.equals("2")) {
                    printUser(scanner);
                }
                if (next.equals("3")) {
                    break;
                }


            }
        }
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
