package Thivi.Project.Gobi.Dreams.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "photos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Photo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "photographer_id", nullable = false)
    private User photographer;

    @Column(nullable = false)
    private String imageUrl;

    @Column(nullable = false)
    private String title;
}
