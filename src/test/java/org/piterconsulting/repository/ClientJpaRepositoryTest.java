//package org.piterconsulting.repository;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.piterconsulting.repository.entity.Client;
//import org.piterconsulting.service.BankService;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class ClientJpaRepositoryTest {
//
//    private ClientSpringJpaRepository repository;
//    private BankService bankService;
//
//    @BeforeEach
//    public void steup(){
//        repository = mock()
//    }
//
//
//    @Test
//    public void veryfiyIfUserIsAddingCorrectlyToTheRepository(){
//        //given
//        final Client alek = new Client("Alek", "A@A.com", new ArrayList<>());
//        final Client expectedClient = new Client("Alek", "A@A.com", new ArrayList<>());
//
//        //when
//        repository.save(alek);
//
//        final Client actualClient = clients
//                .stream()
//                .findFirst()
//                .get();
//        //then
//
//        assertEquals(expectedClient,actualClient);
//
//    }
//
//}
