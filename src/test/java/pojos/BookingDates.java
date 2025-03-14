package pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)

public class BookingDates {
    //    {
//        "bookingid": 11,
//            "booking": {
//        "firstname": "Ahmet",
//                "lastname": "Domurcuk",
//                "totalprice": 150000,
//                "depositpaid": true,
//                "bookingdates": {
//            "checkin": "2022-09-09",
//                    "checkout": "2022-09-01"
//        }
//    }
//    }
    private String checkin;
    private String checkout;

    public String getCheckin() {
        return checkin;
    }

    public String getCheckout() {
        return checkout;
    }

    public void setCheckin(String checkin) {
        this.checkin = checkin;
    }

    public void setCheckout(String checkout) {
        this.checkout = checkout;
    }

    public BookingDates() {
    }

    public BookingDates(String checkin, String checkout) {
        this.checkin = checkin;
        this.checkout = checkout;
    }

    @Override
    public String toString() {
        return "BookingDates{" +
                "checkin='" + checkin + '\'' +
                ", checkout='" + checkout + '\'' +
                '}';
    }
}
