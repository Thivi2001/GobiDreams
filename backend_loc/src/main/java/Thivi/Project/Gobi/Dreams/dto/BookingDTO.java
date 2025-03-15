package Thivi.Project.Gobi.Dreams.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookingDTO {
    private Long id;
    private Long customerId;
    private Long photographerId;
    private LocalDateTime bookingDate;
    private String packageType;
    private String status;
}
