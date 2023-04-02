package com.appconsultorio.appconsultorio.service;
import com.appconsultorio.appconsultorio.dtos.request.ClientDTO;
import com.appconsultorio.appconsultorio.model.Client;
import com.appconsultorio.appconsultorio.repository.IClientRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class ClientService implements IClientService {

    ModelMapper mapper;
    IClientRepository iClientRepository;

    @Override
    public List<Client> getClientByDateForProfessionals(LocalDateTime date){
        return iClientRepository.getClientByDateForProfessionals(date);
    }

    @Override
    public void createClient(ClientDTO clientDTO) {
        Client client = mapper.map(clientDTO, Client.class);
        iClientRepository.save(client);
    }

    @Override
    public void updateClient(ClientDTO clientDTO) {
        Client client = mapper.map(clientDTO, Client.class);
        iClientRepository.save(client);
    }

    @Override
    public void removeClient(int id) {
        iClientRepository.deleteById(id);
    }

    @Override
    public List<Client> getClient() {
        return iClientRepository.findAll();
    }
}
