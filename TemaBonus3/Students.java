import java.util.ArrayList;
import java.util.List;

public class Students {
    String name;
    double avgGrade;
    List<Courses> cours=new ArrayList<Courses>();

    public Students(String name, double avgGrade, List<Courses> cours) {
        this.name = name;
        this.avgGrade = avgGrade;
        this.cours = cours;
    }

    public String getName() {
        return name;
    }
}
