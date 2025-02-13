package tz.mil.bima.controller;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import tz.mil.bima.entity.Client;
import tz.mil.bima.repository.ClientRepository;

import java.util.List;
import java.util.Optional;


@AllArgsConstructor
@Controller
@NoArgsConstructor
public class ClientGraphql {

    private ClientRepository clientRepository;

    @QueryMapping
    public Optional<Client> getAllClientById(@Argument Long id) {
        return clientRepository.findById(id);
    }

    @QueryMapping
    public List<Client> getAllClient(){
        return clientRepository.findAll();
    }

    @MutationMapping
    public Client createClient(@Argument String name,@Argument Integer code){
        Client client = new Client();
        client.setName(name);
        client.setCode(code);
        return  clientRepository.save(client);
    }

    @MutationMapping
    public Client updateClient(@Argument Long id,@Argument Integer code, @Argument String name,@Argument Boolean isActive) {
        Optional<Client> clientOption = clientRepository.findById(id);
        if (clientOption.isPresent()){
            Client client = clientOption.get();
            if (code != null) client.setCode(code);
            if (name != null) client.setName(name);
            if (isActive != null) client.setActive(isActive);
            return clientRepository.save(client);
        }
        return null;
    }

    @MutationMapping
    public Boolean deleteClient( @Argument Long id) {
        try {
            clientRepository.deleteById(id);
            return  true;
        } catch ( Exception e) {
            return false;
        }
    }
}
