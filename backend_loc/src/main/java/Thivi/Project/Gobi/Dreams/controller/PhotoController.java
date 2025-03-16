package Thivi.Project.Gobi.Dreams.controller;

import Thivi.Project.Gobi.Dreams.dto.PhotoDTO;
import Thivi.Project.Gobi.Dreams.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/photos")
public class PhotoController {

    private final PhotoService photoService;

    @Autowired
    public PhotoController(PhotoService photoService) {
        this.photoService = photoService;
    }

    @PostMapping
    public ResponseEntity<PhotoDTO> uploadPhoto(@RequestBody PhotoDTO photoDTO) {
        PhotoDTO uploadedPhoto = photoService.uploadPhoto(photoDTO);
        return ResponseEntity.ok(uploadedPhoto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PhotoDTO> getPhotoById(@PathVariable Long id) {
        PhotoDTO photoDTO = photoService.getPhotoById(id);
        return ResponseEntity.ok(photoDTO);
    }

    @GetMapping
    public ResponseEntity<List<PhotoDTO>> getAllPhotos() {
        List<PhotoDTO> photos = photoService.getAllPhotos();
        return ResponseEntity.ok(photos);
    }
}
