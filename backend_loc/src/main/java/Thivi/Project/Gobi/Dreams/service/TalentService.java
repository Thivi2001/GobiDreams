package Thivi.Project.Gobi.Dreams.service;

import Thivi.Project.Gobi.Dreams.dto.TalentDTO;
import Thivi.Project.Gobi.Dreams.entity.Talent;
import Thivi.Project.Gobi.Dreams.mapper.EntityMapper;
import Thivi.Project.Gobi.Dreams.repository.TalentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TalentService {

    @Autowired
    private TalentRepository talentRepository;

    @Autowired
    private EntityMapper entityMapper;

    public TalentDTO registerTalent(TalentDTO talentDTO) {
        Talent talent = new Talent();
        talent.setPortfolioLink(talentDTO.getPortfolioLink());
        talent.setSkills(talentDTO.getSkills());
        talent.setBio(talentDTO.getBio());
        talent.setStatus(talentDTO.getStatus());
        talentRepository.save(talent);
        return entityMapper.talentToTalentDTO(talent);
    }

    public List<TalentDTO> getAllTalents() {
        List<Talent> talents = talentRepository.findAll();
        return talents.stream()
                .map(entityMapper::talentToTalentDTO)
                .collect(Collectors.toList());
    }

    public TalentDTO getTalentById(Long id) {
        Talent talent = talentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Talent not found with id " + id));
        return entityMapper.talentToTalentDTO(talent);
    }
}
