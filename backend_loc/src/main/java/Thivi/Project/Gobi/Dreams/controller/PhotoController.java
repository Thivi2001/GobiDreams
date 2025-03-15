package Thivi.Project.Gobi.Dreams.controller;

import Thivi.Project.Gobi.Dreams.entity.Photo;
import Thivi.Project.Gobi.Dreams.entity.User;
import Thivi.Project.Gobi.Dreams.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/photos")
public class PhotoController {

    @Autowired
    private PhotoService photoService;

    @PostMapping("/upload")
    public ResponseEntity<Photo> uploadPhoto(@RequestBody Photo photo) {
        return ResponseEntity.ok(photoService.uploadPhoto(photo));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Photo> getPhotoById(@PathVariable Long id) {
        Optional<Photo> photo = photoService.getPhotoById(id);
        return photo.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/photographer")
    public ResponseEntity<List<Photo>> getPhotosByPhotographer(@RequestBody User photographer) {
        return ResponseEntity.ok(photoService.getPhotosByPhotographer(photographer));
    }
}
