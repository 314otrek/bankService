package org.piterconsulting;

import org.hibernate.Transaction;
import org.piterconsulting.repository.entity.Account;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class,args);
    }






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

