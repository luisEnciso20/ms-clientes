package com.example.ms_clientes.repository;
import com.example.ms_clientes.model.Client;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.boot.jdbc.test.autoconfigure.AutoConfigureTestDatabase;
import java.time.LocalDate;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class ClientRepositoryTest {

    @Autowired
    private ClientRepository clientRepository;

    @Test
    void shouldSaveClient() {

        Client client = Client.builder()
                .name("Mario")
                .lastname("Enciso")
                .age(30)
                .birthdate(LocalDate.of(1995, 5, 5))
                .build();

        Client saved = clientRepository.save(client);

        assertThat(saved.getId()).isNotNull();
    }

}