package Thivi.Project.Gobi.Dreams.repository;

import Thivi.Project.Gobi.Dreams.entity.Talent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TalentRepository extends JpaRepository<Talent, Long> {
}
