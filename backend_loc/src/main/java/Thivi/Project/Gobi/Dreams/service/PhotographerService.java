package Thivi.Project.Gobi.Dreams.service;

import Thivi.Project.Gobi.Dreams.dto.PhotographerDTO;
import Thivi.Project.Gobi.Dreams.entity.Photographer;
import Thivi.Project.Gobi.Dreams.mapper.EntityMapper;
import Thivi.Project.Gobi.Dreams.repository.PhotographerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PhotographerService {

    @Autowired
    private PhotographerRepository photographerRepository;

    @Autowired
    private EntityMapper entityMapper;

    public PhotographerDTO createPhotographer(PhotographerDTO photographerDTO) {
        Photographer photographer = new Photographer();
        photographer.setFirstName(photographerDTO.getFirstName());
        photographer.setLastName(photographerDTO.getLastName());
        photographer.setEmail(photographerDTO.getEmail());
        photographer.setPortfolioLink(photographerDTO.getPortfolioLink());
        photographer.setExperienceYears(photographerDTO.getExperienceYears());
        photographerRepository.save(photographer);
        return entityMapper.photographerToPhotographerDTO(photographer);
    }

    public List<PhotographerDTO> getAllPhotographers() {
        List<Photographer> photographers = photographerRepository.findAll();
        return photographers.stream()
                .map(entityMapper::photographerToPhotographerDTO)
                .collect(Collectors.toList());
    }

    public PhotographerDTO getPhotographerById(Long id) {
        Photographer photographer = photographerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Photographer not found with id " + id));
        return entityMapper.photographerToPhotographerDTO(photographer);
    }
}
