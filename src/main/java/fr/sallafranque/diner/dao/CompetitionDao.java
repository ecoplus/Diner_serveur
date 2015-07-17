package fr.sallafranque.diner.dao;

import org.springframework.data.repository.CrudRepository;

import fr.sallafranque.diner.modele.Competition;

public interface CompetitionDao extends CrudRepository<Competition, Long>  {

}
