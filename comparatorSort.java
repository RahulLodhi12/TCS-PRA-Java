import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class comparatorSort {
    public static void main(String[] args) {
        List<myStudent> lst = new ArrayList<>();

        lst.add(new myStudent(22, "Alice"));
        lst.add(new myStudent(11, "Charlie"));
        lst.add(new myStudent(33, "Bob"));

        lst.sort(Comparator.comparing((myStudent s)-> s.rollno));

        for(myStudent s: lst){
            System.out.println(s.rollno +" : "+ s.name);
        }
    }
}

class myStudent{
    int rollno;
    String name;
    
    public myStudent(int rollno, String name) {
        this.rollno = rollno;
        this.name = name;
    }

    public int getRollno() {
        return rollno;
    }

    public void setRollno(int rollno) {
        this.rollno = rollno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    
}
