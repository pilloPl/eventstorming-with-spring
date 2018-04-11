package io.dddbyexamples.demo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import javax.persistence.Entity;

@Repository
@RepositoryRestResource(path = "plastic-cards",
        collectionResourceRel = "plastic-cards",
        itemResourceRel = "plastic-cards")
interface PlasticCardController extends CrudRepository<PlasticCard, Long> {

}

@Entity
class PlasticCard {

    //..
}