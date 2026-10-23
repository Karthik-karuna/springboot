package crudpackage.crudapi.repository;

import crudpackage.crudapi.model.Adminmodel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepostiroy extends JpaRepository<Adminmodel, Integer> {
}
