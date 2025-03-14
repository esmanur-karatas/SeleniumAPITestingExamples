package test;

import baseURLDeposu.HerokuappBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import pojos.Booking;
import pojos.BookingDates;
import pojos.Bookingid;

import static io.restassured.RestAssured.given;

public class API_PostRequestWithPojo extends HerokuappBaseUrl {
    @Test
    public void test01() {
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
        specHerokuapp.pathParam("pp1", "booking");
        BookingDates bookingDates = new BookingDates("2022-09-09","2022-09-01");
        //System.out.println(bookingDates);
        Booking booking = new Booking("Ahmet", "Domurcuk",150000, true, bookingDates);
        System.out.println(booking);
        Response response = given()
                .contentType(ContentType.JSON)
                .spec(specHerokuapp)
                .when()
                .body(booking)
                .post("{pp1}");
        response.prettyPrint();

        Bookingid responseBody = response.as(Bookingid.class);
        Assert.assertEquals(200, response.getStatusCode());

        Assert.assertEquals(booking.getFirstname(), responseBody.getBooking().getFirstname());
        Assert.assertEquals(booking.getLastname(), responseBody.getBooking().getLastname());
        Assert.assertEquals(booking.getTotalprice(), responseBody.getBooking().getTotalprice());
        Assert.assertEquals(booking.isDepositpaid(), responseBody.getBooking().isDepositpaid());
        Assert.assertEquals(booking.getBookingdates().getCheckin(),responseBody.getBooking().getBookingdates().getCheckin());
        Assert.assertEquals(booking.getBookingdates().getCheckout(),responseBody.getBooking().getBookingdates().getCheckout());
    }
}
