import com.course.structure.*;

public class q1BuildingPackages {
    public static void main(String[] args) {
        School s = new School();
        s.setClas(10);
        s.setGrade("Something");
        System.out.println(s.getGrade());
    
        House h = new House();
        h.setBaths(3);
        System.out.println(h.getBaths());
    }
}