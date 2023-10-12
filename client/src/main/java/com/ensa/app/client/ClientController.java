package com.ensa.app.client;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/clients")
@AllArgsConstructor
public class ClientController {
    private final ClientService clientService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Client> getClients(){
        return  this.clientService.getClients();
    }

    @RequestMapping(method = RequestMethod.POST)
    public Client addClient(@RequestBody() ClientRequestDto clientRequestDto) {
        return this.clientService.addClient(clientRequestDto);
    }
}
