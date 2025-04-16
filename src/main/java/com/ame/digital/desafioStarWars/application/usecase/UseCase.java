package com.ame.digital.desafioStarWars.application.usecase;

public interface UseCase <InputDTO, OutputDTO>{
    OutputDTO execute(InputDTO inputDTO);

}
