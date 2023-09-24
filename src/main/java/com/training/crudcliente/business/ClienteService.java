package com.training.crudcliente.business;

import java.util.List;

import com.training.crudcliente.persistences.documents.ClienteDocument;

public interface ClienteService {
    List<ClienteDocument> finAll();

    void save(ClienteDocument cliente);

    ClienteDocument findOne(String id);

    void delete(String id);
}
