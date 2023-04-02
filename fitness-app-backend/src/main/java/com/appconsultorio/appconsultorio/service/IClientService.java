package com.appconsultorio.appconsultorio.service;
import com.appconsultorio.appconsultorio.dtos.request.ClientDTO;
import com.appconsultorio.appconsultorio.model.Client;

import java.time.LocalDateTime;
import java.util.List;

public interface IClientService {
    public void createClient(ClientDTO clientDTO);
    public void updateClient(ClientDTO clientDTO);
    public void removeClient(int id);
    public List<Client> getClient() ;
    List<Client> getClientByDateForProfessionals(LocalDateTime dt);
}
