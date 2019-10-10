import java.util.ArrayList;
import java.util.List;

public class CinemaSeats {

    String[][] list = new String[9][8];
    int total;
    static int totalBooking;

    void setCinemaMethod(String[][] list) {
        this.list = list;
    }
    void show(){
        for (int i = 0; i < list.length; i++) {
            for (int j = 0; j < list[i].length; j++) {
                System.out.print(list[i][j] + " ");
            }
            System.out.println();
        }
    }

    void clear(){
        for (int i = 0; i < list.length; i++) {
            for (int j = 0; j < list[i].length; j++) {
               list[i][j] = ("#");
            }
        }
    }

    boolean isSeatBooking(int row, int seat) {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < seat; j++) {
                if(list[row][seat].equals("x")){
                    return true;
                }else {
                    return false;
                }
            }
        }
        return false;
    }

    boolean bookSeat(int row, int seat) {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < seat; j++) {
                if (list[j].equals("x")) {
                    return true;
                } else {
                    return false;
                }
            }
        }
        return false;
    }

    boolean book(int tickets, String location) {
        totalBooking += tickets;
        int [] array = location.chars().map(c -> c-'0').toArray();
        System.out.println(array[0]);
        System.out.println(array[1]);
        for (int i = 0; i < array[0]; i++) {
            for (int j = 0; j < array[1]; j++) {
                if(list[array[0]][array[1]].equals("#")) {
                    list[i][j] = "x";
                }
                if (list[j].equals("x")) {
                    if (i > 0 && i <= 3) {
                        total += 25;
                    } else if (i > 3 && i <= 6) {
                        total += 35;
                    } else {
                        total += 31;
                    }
                } else {
                    return false;
                }
            }
        }
        return false;
    }

    int totalIncome(){
        return total;
    }

    int totalBookings(){
        return totalBooking;
    }

    public static void main(String[] args) {
//        int[][] list = new int[9][8];
        CinemaSeats cinemaSeats = new CinemaSeats();
        try {
            cinemaSeats.clear();
//            cinemaSeats.show();
            cinemaSeats.book(3, "64");
            cinemaSeats.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
