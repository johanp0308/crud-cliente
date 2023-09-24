package com.training.crudcliente.repositories;

import org.springframework.data.repository.CrudRepository;
import com.training.crudcliente.persistences.documents.ClienteDocument;

public interface ClienteRepository extends CrudRepository<ClienteDocument,String>{
    
}

