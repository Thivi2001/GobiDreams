package Thivi.Project.Gobi.Dreams.mapper;

import Thivi.Project.Gobi.Dreams.dto.*;
import Thivi.Project.Gobi.Dreams.entity.*;
import org.springframework.stereotype.Component;

@Component
public class EntityMapper {

    public BookingDTO bookingToBookingDTO(Booking booking) {
        return new BookingDTO(booking.getId(), booking.getCustomer().getId(), booking.getPhotographer().getId(),
                booking.getSessionDate(), booking.getEventType(), booking.getStatus());
    }

    public CustomerDTO customerToCustomerDTO(Customer customer) {
        return new CustomerDTO(customer.getId(), customer.getFirstName(), customer.getLastName(),
                customer.getEmail(), customer.getPhoneNumber(), customer.getAddress());
    }

    public PaymentDTO paymentToPaymentDTO(Payment payment) {
        return new PaymentDTO(payment.getId(), payment.getBooking().getId(), payment.getAmount(),
                payment.getPaymentDate(), payment.getPaymentMethod());
    }

    public PhotoDTO photoToPhotoDTO(Photo photo) {
        return new PhotoDTO(photo.getId(), photo.getBooking().getId(), photo.getFilePath(), photo.getUploadedDate());
    }

    public PhotographerDTO photographerToPhotographerDTO(Photographer photographer) {
        return new PhotographerDTO(photographer.getId(), photographer.getFirstName(), photographer.getLastName(),
                photographer.getEmail(), photographer.getPortfolioLink(), photographer.getExperienceYears());
    }

    public TalentDTO talentToTalentDTO(Talent talent) {
        return new TalentDTO(talent.getId(), talent.getUser().getId(), talent.getPortfolioLink(),
                talent.getSkills(), talent.getBio(), talent.getStatus());
    }

    public UserDTO userToUserDTO(User user) {
        return new UserDTO(user.getId(), user.getFirstName(), user.getLastName(), user.getEmail(), user.getRole());
    }

    public RatingDTO ratingToRatingDTO(Rating rating) {
        return new RatingDTO(rating.getId(), rating.getCustomer().getId(), rating.getRating(), rating.getReview());
    }
}
