package Thivi.Project.Gobi.Dreams.service;

import Thivi.Project.Gobi.Dreams.entity.Photo;
import Thivi.Project.Gobi.Dreams.entity.User;
import Thivi.Project.Gobi.Dreams.repository.PhotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PhotoService {

    @Autowired
    private PhotoRepository photoRepository;

    public Photo uploadPhoto(Photo photo) {
        return photoRepository.save(photo);
    }

    public List<Photo> getPhotosByPhotographer(User photographer) {
        return photoRepository.findByPhotographer(photographer);
    }

    public Optional<Photo> getPhotoById(Long id) {
        return photoRepository.findById(id);
    }
}
