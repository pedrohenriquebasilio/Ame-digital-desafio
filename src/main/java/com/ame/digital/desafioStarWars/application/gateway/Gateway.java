package com.ame.digital.desafioStarWars.application.gateway;

import java.util.List;

public interface Gateway <Object>{
    Object save(Object object);
    Object update(Object object);
    void delete(Object object);
    Object getId(int ObjectId);
    List<Object> getAll();
    Object getByName(String name);
}
