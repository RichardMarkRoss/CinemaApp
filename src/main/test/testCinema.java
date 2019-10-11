//import CinemaSeats;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class testCinema {
    @Test
    public void shouldBookSeat() {
        CinemaSeats cinemaSeats = new CinemaSeats();
        cinemaSeats.bookSeat(6, 4);
        assertEquals(true,cinemaSeats.isSeatBooking(6, 4));
    }
    @Test
    public void bookingMultipleSeats(){
        CinemaSeats cinemaSeats = new CinemaSeats();
        cinemaSeats.bookSeat(6, 4);
        cinemaSeats.bookSeat(6, 5);
        cinemaSeats.bookSeat(6, 6);
//          cinemaSeats.show();
        assertEquals(true,cinemaSeats.isSeatBooking(6, 4));
        assertEquals(true,cinemaSeats.isSeatBooking(6, 5));
        assertEquals(true,cinemaSeats.isSeatBooking(6, 6));
    }
    @Test
    public void CalculatingTheAmountSold(){
        CinemaSeats cinemaSeats = new CinemaSeats();
        cinemaSeats.bookSeat(4, 1);
        cinemaSeats.bookSeat(4, 2);
        cinemaSeats.bookSeat(4, 3);
        assertEquals(75,cinemaSeats.totalIncome());
    }
    @Test
    public void amountOfSeatsSold(){
        CinemaSeats cinemaSeats = new CinemaSeats();
        cinemaSeats.bookSeat(4, 1);
        cinemaSeats.bookSeat(3, 2);
        cinemaSeats.bookSeat(1, 3);
        assertEquals(3,cinemaSeats.totalBookings());
    }
    @Test
    public void showTheSeating(){
        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        CinemaSeats cinemaSeats = new CinemaSeats();
        cinemaSeats.show();
        assertEquals("------SCREEN------\n"+
        "1. # # # # # # # # \n"+
        "2. # # # # # # # # \n"+
        "3. # # # # # # # # \n"+
        "4. # # # # # # # # \n"+
        "5. # # # # # # # # \n"+
        "6. # # # # # # # # \n"+
        "7. # # # # # # # # \n"+
        "8. # # # # # # # # \n"+
        "9. # # # # # # # # \n"+
        "   1 2 3 4 5 6 7 8 \n",outContent.toString());
    }
}
