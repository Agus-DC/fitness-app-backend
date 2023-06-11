package com.appconsultorio.appconsultorio.service;
import com.appconsultorio.appconsultorio.dtos.request.TurnDTO;
import com.appconsultorio.appconsultorio.model.Professional;
import com.appconsultorio.appconsultorio.model.Client;
import com.appconsultorio.appconsultorio.model.Turn;
import com.appconsultorio.appconsultorio.repository.IProfessionalRepository;
import com.appconsultorio.appconsultorio.repository.IClientRepository;
import com.appconsultorio.appconsultorio.repository.ITurnRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;

@Service
@AllArgsConstructor
public class TurnService implements ITurnService {

    ITurnRepository iTurnRepository;

    IClientRepository iClientRepository;

    IProfessionalRepository iProfessionalRepository;

    @Override
    public void createTurn(TurnDTO turnDTO) throws Exception{

        if(turnDTO.getStatus().equals("Reprogramado")) turnDTO = createReprogramedTurn(turnDTO);

        Client client = iClientRepository.findById(turnDTO.getIdClient()).orElseThrow(() -> new RuntimeException("Paciente no encontrado"));
        Turn turn = new Turn();
        Set<Professional> professionals = new HashSet<>();//Collections.emptySet() -> Si pongo esto no puedo agregar optionals

        turn.setDescription(turnDTO.getDescription());
        turn.setStatus(turnDTO.getStatus());
        if(turnDTO.getIdToReprogTurn() != null) turn.setIdToReprogTurn(turnDTO.getIdToReprogTurn());
        if(!saveTurnTime(turnDTO.getStartTime())) throw new RuntimeException("Turno no disponible");

        turn.setStartTime(turnDTO.getStartTime());
        turn.setStartTime(turnDTO.getStartTime());
        turn.setClient(client);


        turnDTO.getIdProfessional().forEach(a ->
                professionals.add(iProfessionalRepository.findById(a).orElse(null)));

        if (professionals.contains(null)) {
            throw new RuntimeException("Profesional no encontrado");
        }


        professionals.forEach(b -> b.getCalendars().createTurn(turn.getStartTime()));

        turn.setProfessionalset(professionals);
        iTurnRepository.save(turn);
    }

    private boolean saveTurnTime(LocalDateTime startDate){
        boolean res = false;
        long minutes = startDate.getMinute();
        if(minutes == 30 || minutes == 0) res = true;
        return res;
    }


    private TurnDTO createReprogramedTurn(TurnDTO turnDTO) throws Exception{
        Turn turn = iTurnRepository.findById(turnDTO.getIdToReprogTurn()).orElseThrow(() -> new RuntimeException("Turno no encontrado"));
        changeStatusOfTurn(turn, "Reprogramado");
        if(turn.getStartTime().compareTo(turnDTO.getStartTime()) == 0) throw new RuntimeException("El horario de la reprogramacion no puede ser el mismo que el original");
        return new TurnDTO(
                turn.getDescription(),
                "Pendiente",
                turnDTO.getIdToReprogTurn(),
                turnDTO.getStartTime(),
                turnDTO.getIdClient(),
                turnDTO.getIdProfessional());
    }

    private void changeStatusOfTurn(Turn turn, String status){
        turn.setStatus(status);
        iTurnRepository.save(turn);
    }

    @Override
    public void updateTurn(Turn turn) {
        iTurnRepository.save(turn);
    }

    @Override
    public void removeTurn(int id) {
        iTurnRepository.deleteById(id);
    }

    @Override
    public List<Turn> getTurn() {
        return iTurnRepository.findAll();
    }

    public List<Turn> findTurnosLikeFinalizado(){
        return iTurnRepository.findTurnosLikeFinalizado();
    }

    public List<Turn> findTurnosLikeReprogramed(){return iTurnRepository.findTurnosLikeReprogramed();}
}
