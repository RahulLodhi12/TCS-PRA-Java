import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class comparatorSort_twoClasses {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        List<Student> st = new ArrayList<>(n);

        for(int i=0;i<n;i++){
            int a = sc.nextInt(); sc.nextLine();
            String b = sc.nextLine();

            int size = sc.nextInt(); sc.nextLine();
            List<Marks> mk = new ArrayList<>(size);
            for(int j=0;j<size;j++){
                String aa = sc.nextLine();
                int bb = sc.nextInt(); sc.nextLine();

                mk.add(new Marks(aa,bb));
            }

            st.add(new Student(a, b, mk));
        }

        System.out.println("okk");

        int id = sc.nextInt();

        List<Pair<String,Integer>> ans = getListByRollNo(st,id);

        ans.sort(Comparator.comparing((Pair<String, Integer> p) -> p.getKey()));

        for(Pair<String,Integer> p: ans){
            System.out.println(p.getKey()+" : "+p.getValue());
        }
    }

    public static List<Pair<String,Integer>> getListByRollNo(List<Student> st, int id){
        List<Pair<String,Integer>> res = new ArrayList<>();

        for(Student s: st){
            if(s.getRollno()==id){
                for(Marks m: s.marksList){
                    res.add(new Pair<String,Integer>(m.getSubjectName(),m.getSubjectMarks()));
                }
            }
        }

        return res;
    }
}

class Marks {
    String subjectName;
    int subjectMarks;

    public Marks(String subjectName, int subjectMarks) {
        this.subjectName = subjectName;
        this.subjectMarks = subjectMarks;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public int getSubjectMarks() {
        return subjectMarks;
    }

    public void setSubjectMarks(int subjectMarks) {
        this.subjectMarks = subjectMarks;
    }

    
}

class Student {
    int rollno;
    String name;
    List<Marks> marksList;

    public Student(int rollno, String name, List<Marks> marksList) {
        this.rollno = rollno;
        this.name = name;
        this.marksList = marksList;
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

    public List<Marks> getMarksList() {
        return marksList;
    }

    public void setMarksList(List<Marks> marksList) {
        this.marksList = marksList;
    }

    
}

/*
2
11
rahul
4
maths
88
bio
78
eng
90
sst
85
22
mohit
3
maths
66
cs
99
evs
44
okk
11
bio : 78
eng : 90
maths : 88
sst : 85
*/
