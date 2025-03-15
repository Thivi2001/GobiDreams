package Thivi.Project.Gobi.Dreams.service;

import Thivi.Project.Gobi.Dreams.entity.Talent;
import Thivi.Project.Gobi.Dreams.repository.TalentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TalentService {

    @Autowired
    private TalentRepository talentRepository;

    public Talent registerTalent(Talent talent) {
        return talentRepository.save(talent);
    }

    public List<Talent> getAllTalents() {
        return talentRepository.findAll();
    }

    public Optional<Talent> getTalentById(Long id) {
        return talentRepository.findById(id);
    }
}
