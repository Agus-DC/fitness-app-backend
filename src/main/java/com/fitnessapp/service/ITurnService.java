package com.fitnessapp.service;
import com.fitnessapp.dtos.request.TurnDTO;
import com.fitnessapp.model.Turn;

import java.util.List;

public interface ITurnService {
    Integer createTurn(TurnDTO turnDTO) throws Exception;
    Integer updateTurn(TurnDTO turn);
    void removeTurn(int id);
    List<Turn> getTurn();
    List<Turn> findTurnosLikeFinalizado();
    List<Turn> findTurnosLikeReprogramed();

    //void createReprogramedTurn(TurnDTO turnDTO) throws Exception;
}
