package Thivi.Project.Gobi.Dreams.controller;

import Thivi.Project.Gobi.Dreams.dto.RatingDTO;
import Thivi.Project.Gobi.Dreams.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ratings")
public class RatingController {

    private final RatingService ratingService;

    @Autowired
    public RatingController(RatingService ratingService) {
        this.ratingService = ratingService;
    }

    @PostMapping
    public ResponseEntity<RatingDTO> addRating(@RequestBody RatingDTO ratingDTO) {
        RatingDTO addedRating = ratingService.addRating(ratingDTO);
        return ResponseEntity.ok(addedRating);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RatingDTO> getRatingById(@PathVariable Long id) {
        RatingDTO ratingDTO = ratingService.getRatingById(id);
        return ResponseEntity.ok(ratingDTO);
    }

    @GetMapping
    public ResponseEntity<List<RatingDTO>> getAllRatings() {
        List<RatingDTO> ratings = ratingService.getAllRatings();
        return ResponseEntity.ok(ratings);
    }
}
