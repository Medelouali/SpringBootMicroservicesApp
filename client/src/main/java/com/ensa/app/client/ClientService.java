package com.ensa.app.client;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class ClientService {
    private final ClientRepository clientRepository;
    private final FeignClientInterface feignClientInterface;

    public List<Client> getClients(){
        return this.clientRepository.findAll();
    }

    public Client addClient(ClientRequestDto clientRequestDto) {
        // To do:  We should do some validation first
        log.info(clientRequestDto.email());
        Client client=Client.builder().
                firstName(clientRequestDto.firstName())
                .lastName(clientRequestDto.lastName())
                .email(clientRequestDto.email())
                .build();
        client=this.clientRepository.save(client);
        feignClientInterface.flagClient(client.getId());
        return client;
    }
}
