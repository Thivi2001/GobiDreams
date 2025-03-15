package Thivi.Project.Gobi.Dreams.controller;

import Thivi.Project.Gobi.Dreams.entity.Talent;
import Thivi.Project.Gobi.Dreams.service.TalentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/talented")
public class TalentController {

    @Autowired
    private TalentService talentService;

    @PostMapping("/register")
    public ResponseEntity<Talent> registerTalent(@RequestBody Talent talent) {
        return ResponseEntity.ok(talentService.registerTalent(talent));
    }

    @GetMapping("/list")
    public ResponseEntity<List<Talent>> getAllTalents() {
        return ResponseEntity.ok(talentService.getAllTalents());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Talent> getTalentById(@PathVariable Long id) {
        Optional<Talent> talent = talentService.getTalentById(id);
        return talent.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
