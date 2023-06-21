package com.mycompany.app.model.repository;

import com.mycompany.app.model.entity.Personne;


public class PersonneRepository extends CrudJpa<Personne>  {
    public PersonneRepository() {
        super(new Personne());
    }
}
