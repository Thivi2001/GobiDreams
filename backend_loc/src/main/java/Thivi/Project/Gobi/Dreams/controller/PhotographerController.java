package Thivi.Project.Gobi.Dreams.controller;

import Thivi.Project.Gobi.Dreams.dto.PhotographerDTO;
import Thivi.Project.Gobi.Dreams.service.PhotographerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/photographers")
public class PhotographerController {

    @Autowired
    private PhotographerService photographerService;

    @PostMapping
    public PhotographerDTO createPhotographer(@RequestBody PhotographerDTO photographerDTO) {
        return photographerService.createPhotographer(photographerDTO);
    }

    @GetMapping("/list")
    public List<PhotographerDTO> getAllPhotographers() {
        return photographerService.getAllPhotographers();
    }

    @GetMapping("/{id}")
    public PhotographerDTO getPhotographerById(@PathVariable Long id) {
        return photographerService.getPhotographerById(id);
    }
}
