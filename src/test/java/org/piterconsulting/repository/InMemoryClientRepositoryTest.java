package org.piterconsulting.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.piterconsulting.Client;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InMemoryClientRepositoryTest {

    private InMemoryClientRepository repository;
    private List<Client> clients;

    @BeforeEach
    public void steup(){
        clients = new ArrayList<>();
        repository = new InMemoryClientRepository(clients);
    }

    @Test
    public void veryfiyIfUserIsAddingCorrectlyToTheRepository(){
        //given
        final Client alek = new Client("Alek", "A@A.com", 100);
        final Client expectedClient = new Client("Alek", "A@A.com", 100);

        //when
        repository.save(alek);

        final Client actualClient = clients
                .stream()
                .findFirst()
                .get();
        //then

        assertEquals(expectedClient,actualClient);

    }

}
