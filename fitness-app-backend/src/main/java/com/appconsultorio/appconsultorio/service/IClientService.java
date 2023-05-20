package com.appconsultorio.appconsultorio.service;
import com.appconsultorio.appconsultorio.dtos.request.ClientDTO;
import com.appconsultorio.appconsultorio.model.Client;

import java.time.LocalDateTime;
import java.util.List;

public interface IClientService {
    void createClient(ClientDTO clientDTO);
    void updateClient(ClientDTO clientDTO);
    void removeClient(int id);
    List<Client> getClient() ;
    List<Client> getClientByDateForProfessionals(LocalDateTime dt);
}
