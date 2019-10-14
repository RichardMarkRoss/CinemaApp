import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestString {
    String values = "";
    String[][] list = new String[9][8];
    List<String> passing = new ArrayList<String>();

    void CreateList() {
        for (int i = 0; i < list.length; i++) {
            for (int j = 0; j < list[i].length; j++) {
                list[i][j] = ("#");
            }
        }
    }
    String creatingRow(int i){

        for(int j= 0; j < i ; j++){
            passing.add("#");
        }
        values = String.join("",passing);
        System.out.println(values);
        return values;
    }

    public static void main(String[] args) {
        TestString testString = new TestString();
        testString.CreateList();
        String name = testString.creatingRow(4);
        String roughDraft = String.join("",testString.list[0]);
        System.out.println(roughDraft.equals(name));
    }
}