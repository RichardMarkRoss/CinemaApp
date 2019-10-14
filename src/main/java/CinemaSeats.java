import java.util.ArrayList;
import java.util.List;

public class CinemaSeats {

    String[][] list = new String[9][8];
    static int total;
    static int totalBooking;
    List<String> passing = new ArrayList<String>();

    CinemaSeats() {
        clear();
    }

    void setCinemaMethod(String[][] list) {
        this.list = list;
    }

    void show() {
        System.out.println("------SCREEN------");
        for (int i = 0; i < list.length; i++) {
            System.out.print((i + 1) + ". ");
            for (int j = 0; j < list[i].length; j++) {
                System.out.print(list[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("   1 2 3 4 5 6 7 8 ");
    }

    void clear() {
        for (int i = 0; i < list.length; i++) {
            for (int j = 0; j < list[i].length; j++) {
                list[i][j] = ("#");
            }
        }
    }

    boolean isSeatBooking(int row, int seat) {
        if (list[row - 1][seat - 1].equals("x")) {
            return true;
        } else {
            return false;
        }
    }

    boolean bookSeat(int row, int seat) {
        if (list[row - 1][seat - 1].equals("x")) {
            return false;
        } else {
            list[row - 1][seat - 1] = "x";
        }
        return false;
    }

    boolean book(int tickets, String location) {
        totalBooking += tickets;
        int ticket = 0;

        for (int j = 0; j < tickets; j++) {
            passing.add("#");
        }
            if (location.equalsIgnoreCase("front")) {
                for (int j = 0; j < 3; j++) {
                    if (String.join("", list[j]).contains(String.join("", passing))) {
                        for (int k = 0; k < list[j].length; k++) {
                            if (list[j][k].equals("#")) {
                                if (ticket < tickets) {
                                    ticket++;
                                    list[j][k] = "x";
                                }
                            }
                        }
                        passing.clear();
                    } else if (j == 2) {
                        return false;
                    }
                }
            } else if (location.equalsIgnoreCase("middle")) {
                for (int j = 3; j < 6; j++) {
                    if (String.join("", list[j]).contains(String.join("", passing))) {
                        for (int k = 0; k < list[j].length; k++) {
                            if (list[j][k].equals("#")) {
                                if (ticket < tickets) {
                                    ticket++;
                                    list[j][k] = "x";
                                }
                            }
                        }
                        passing.clear();
                    } else if (j == 5) {
                        return false;
                    }
                }
            } else if (location.equalsIgnoreCase("back")) {
                for (int j = 6; j < 9; j++) {
                    if (String.join("", list[j]).contains(String.join("", passing))) {
                        for (int k = 0; k < list[j].length; k++) {
                            if (list[j][k].equals("#")) {
                                if (ticket < tickets) {
                                    ticket++;
                                    list[j][k] = "x";
                                }
                            }
                        }
                        passing.clear();
                    } else if (j == 8) {
                        return false;
                    }
                }
            } else {
                return false;
            }
        return false;
    }


    int totalIncome() {
        for (int i = 0; i < list.length; i++) {
            for (int j = 0; j < list[i].length; j++) {
                if (list[i][j].equals("x")) {
                    if (i > 0 && i <= 3) {
                        total = total + 25;
                    } else if (i > 3 && i <= 6) {
                        total = total + 35;
                    } else {
                        total = total + 31;
                    }
                }
            }
        }
        return total;
    }

    int totalBookings() {
        for (int i = 0; i < list.length; i++) {
            for (int j = 0; j < list[i].length; j++) {
                if (list[i][j].equals("x")) {
                    totalBooking++;
                }
            }
        }
        return totalBooking;
    }

    public static void main(String[] args) {
        CinemaSeats cinemaSeats = new CinemaSeats();
        try {
            cinemaSeats.book(3, "front");
            cinemaSeats.book(2, "front");
            cinemaSeats.book(1, "front");
            cinemaSeats.book(5, "front");
            cinemaSeats.book(4, "front");
            cinemaSeats.book(3, "front");

            cinemaSeats.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
