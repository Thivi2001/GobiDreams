package Thivi.Project.Gobi.Dreams.repository;

import Thivi.Project.Gobi.Dreams.entity.Photo;
import Thivi.Project.Gobi.Dreams.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PhotoRepository extends JpaRepository<Photo, Long> {
    List<Photo> findByPhotographer(User photographer); // Get all photos uploaded by a photographer
}
