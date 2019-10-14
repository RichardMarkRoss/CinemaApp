import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestBookMethod {

    @Test
    public void TestFrontSeats() {
        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        CinemaSeats cinemaSeats = new CinemaSeats();
        cinemaSeats.book(5,"front");
        cinemaSeats.show();
        assertEquals("------SCREEN------\n" +
                "1. x x x x x # # # \n" +
                "2. # # # # # # # # \n" +
                "3. # # # # # # # # \n" +
                "4. # # # # # # # # \n" +
                "5. # # # # # # # # \n" +
                "6. # # # # # # # # \n" +
                "7. # # # # # # # # \n" +
                "8. # # # # # # # # \n" +
                "9. # # # # # # # # \n" +
                "   1 2 3 4 5 6 7 8 \n", outContent.toString());
    }

    @Test
    public void TestMultipleFrontSeats() {
        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        CinemaSeats cinemaSeats = new CinemaSeats();
        cinemaSeats.book(5,"front");
        cinemaSeats.book(5,"front");
        cinemaSeats.book(2,"front");
        cinemaSeats.show();
        assertEquals("------SCREEN------\n" +
                "1. x x x x x x x # \n" +
                "2. x x x x x # # # \n" +
                "3. # # # # # # # # \n" +
                "4. # # # # # # # # \n" +
                "5. # # # # # # # # \n" +
                "6. # # # # # # # # \n" +
                "7. # # # # # # # # \n" +
                "8. # # # # # # # # \n" +
                "9. # # # # # # # # \n" +
                "   1 2 3 4 5 6 7 8 \n", outContent.toString());
    }

    @Test
    public void TestMultipleRows() {
        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        CinemaSeats cinemaSeats = new CinemaSeats();
        cinemaSeats.book(5,"front");
        cinemaSeats.book(5,"front");
        cinemaSeats.book(2,"front");
        cinemaSeats.book(4,"middle");
        cinemaSeats.book(3,"middle");
        cinemaSeats.book(6,"back");
        cinemaSeats.book(3,"back");
        cinemaSeats.show();
        assertEquals("------SCREEN------\n" +
                "1. x x x x x x x # \n" +
                "2. x x x x x # # # \n" +
                "3. # # # # # # # # \n" +
                "4. x x x x x x x # \n" +
                "5. # # # # # # # # \n" +
                "6. # # # # # # # # \n" +
                "7. x x x x x x # # \n" +
                "8. x x x # # # # # \n" +
                "9. # # # # # # # # \n" +
                "   1 2 3 4 5 6 7 8 \n", outContent.toString());
    }

    @Test
    public void TestFrontSeatsIfTheresNotMore() {
        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        CinemaSeats cinemaSeats = new CinemaSeats();
        cinemaSeats.book(8,"front");
        cinemaSeats.book(8,"front");
        cinemaSeats.book(8,"front");
        assertEquals(false,cinemaSeats.book(1,"front"));
        cinemaSeats.show();
        assertEquals("------SCREEN------\n" +
                "1. x x x x x x x x \n" +
                "2. x x x x x x x x \n" +
                "3. x x x x x x x x \n" +
                "4. # # # # # # # # \n" +
                "5. # # # # # # # # \n" +
                "6. # # # # # # # # \n" +
                "7. # # # # # # # # \n" +
                "8. # # # # # # # # \n" +
                "9. # # # # # # # # \n" +
                "   1 2 3 4 5 6 7 8 \n", outContent.toString());
    }
}