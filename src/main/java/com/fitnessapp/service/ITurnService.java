package com.fitnessapp.service;
import com.fitnessapp.dtos.request.TurnDTO;
import com.fitnessapp.model.Turn;

import java.util.List;

public interface ITurnService {
    void createTurn(TurnDTO turnDTO) throws Exception;
    void updateTurn(Turn turn);
    void removeTurn(int id);
    List<Turn> getTurn();
    List<Turn> findTurnosLikeFinalizado();
    List<Turn> findTurnosLikeReprogramed();
    //void createReprogramedTurn(TurnDTO turnDTO) throws Exception;
}
