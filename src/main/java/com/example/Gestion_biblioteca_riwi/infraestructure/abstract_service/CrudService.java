package com.example.Gestion_biblioteca_riwi.infraestructure.abstract_service;

import org.springframework.data.domain.Page;

public interface CrudService <RQ,RS,ID>{
    public RS create(RQ request);
    public RS update(RQ request, ID id);
    public RS getById(ID id);
    public void delete(ID id);
    public Page<RS> getAll(int page, int size);
}
