package com.fitnessapp.service;
import com.fitnessapp.dtos.request.TurnDTO;
import com.fitnessapp.model.Professional;
import com.fitnessapp.model.Client;
import com.fitnessapp.model.Turn;
import com.fitnessapp.repository.IProfessionalRepository;
import com.fitnessapp.repository.IClientRepository;
import com.fitnessapp.repository.ITurnRepository;
import com.fitnessapp.utils.TurnSatusProvider;
import java.sql.Timestamp;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@AllArgsConstructor
public class TurnService implements ITurnService {

    ITurnRepository iTurnRepository;

    IClientRepository iClientRepository;

    IProfessionalRepository iProfessionalRepository;

    @Override
    public Integer createTurn(TurnDTO turnDTO) {

        if (!isValidTurnCreationStatus(turnDTO)) {
            throw new RuntimeException("status del turno invalido");
        }

        if (iProfessionalRepository.findById(turnDTO.getIdProfessional()).isEmpty()) {
            throw new RuntimeException("Profesional no encontrado");
        }
        Professional professional = iProfessionalRepository.getById(turnDTO.getIdProfessional());
        Timestamp startTimeLimit = Timestamp.valueOf(turnDTO.getStartTime().minusMinutes(30));
        Timestamp endTimeLimit = Timestamp.valueOf(turnDTO.getStartTime().plusMinutes(30));

        List<Turn> overlappingTurns = iTurnRepository.findTurnsWithinMargin(startTimeLimit, endTimeLimit);

        if (!overlappingTurns.isEmpty()) {
            throw new RuntimeException("El turno se superpone con un turno existente: " + overlappingTurns.get(0).getStartTime());
        }

        Client client = iClientRepository.findById(turnDTO.getIdClient()).orElseThrow(() -> new RuntimeException("Paciente no encontrado"));
        Turn turn = new Turn();

        turn.setDescription(turnDTO.getDescription());
        turn.setStatus(TurnSatusProvider.PENDING);
        turn.setStartTime(Timestamp.valueOf(turnDTO.getStartTime()));
        turn.setClient(client);
        turn.setCalendar(professional.getCalendar());

        iTurnRepository.save(turn);
        return turn.getId();
    }

    private boolean isValidTurnCreationStatus(TurnDTO turnDTO) {
        return (TurnSatusProvider.PENDING.equals(turnDTO.getStatus().toLowerCase()) ||
            TurnSatusProvider.REPROGRAMMED.equals(turnDTO.getStatus().toLowerCase()) ||
            TurnSatusProvider.COMPLETED.equals(turnDTO.getStatus().toLowerCase()));
    }

    private boolean isValidTurnUpdateStatus(String newStatus, String oldStatus) {
        if (newStatus.equals(oldStatus)) {
            return true;
        }
        return (TurnSatusProvider.PENDING.equals(oldStatus) || TurnSatusProvider.REPROGRAMMED.equals(oldStatus))
            && (TurnSatusProvider.REPROGRAMMED.equals(newStatus) || TurnSatusProvider.COMPLETED.equals(newStatus));
    }

    @Override
    public Integer updateTurn(TurnDTO turnDTO) {
        if (turnDTO.getId() == null) {
            throw new RuntimeException("turn to update no reference");
        }
        Turn existingTurn = iTurnRepository.findById(turnDTO.getId())
            .orElseThrow(() -> new RuntimeException("Turno no encontrado"));
        if(Timestamp.valueOf(turnDTO.getStartTime()).before(existingTurn.getStartTime())) {
            throw new RuntimeException("El horario es invalido");
        }
        if (!isValidTurnUpdateStatus(turnDTO.getStatus(), existingTurn.getStatus())) {
            throw new RuntimeException("status del turno invalido");
        }
        removeTurn(existingTurn.getId());
        System.out.println("deleted turn: " + turnDTO.getId());
        return createTurn(turnDTO);
    }

    @Override
    public void removeTurn(int id) {
        iTurnRepository.deleteById(id);
    }

    @Override
    public List<Turn> getTurn() {
        return iTurnRepository.getAll();
    }

    public List<Turn> findTurnosLikeFinalizado(){
        List<Turn> turnList = iTurnRepository.findTurnosLikeFinalizado();
        System.out.println("findTurnosLikeFinalizado" + turnList);
        return turnList;
    }

    public List<Turn> findTurnosLikeReprogramed(){
        List<Turn> turnList = iTurnRepository.findTurnosLikeReprogramed();
        System.out.println("findTurnosLikeReprogramed" + turnList);
        return turnList;
    }
}
