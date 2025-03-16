package Thivi.Project.Gobi.Dreams.controller;

import Thivi.Project.Gobi.Dreams.dto.TalentDTO;
import Thivi.Project.Gobi.Dreams.service.TalentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/talents")
public class TalentController {

    @Autowired
    private TalentService talentService;

    @PostMapping("/register")
    public TalentDTO registerTalent(@RequestBody TalentDTO talentDTO) {
        return talentService.registerTalent(talentDTO);
    }

    @GetMapping("/list")
    public List<TalentDTO> getAllTalents() {
        return talentService.getAllTalents();
    }

    @GetMapping("/{id}")
    public TalentDTO getTalentById(@PathVariable Long id) {
        return talentService.getTalentById(id);
    }
}
