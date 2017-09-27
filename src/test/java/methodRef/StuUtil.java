package methodRef;

public class StuUtil {


    public static int compareByNameStatic(Student student1, Student student2) {
        return student1.getName().compareToIgnoreCase(student2.getName());
    }

    public static int compareByScoreStatic(Student student1, Student student2) {
        return student1.getScore() - student2.getScore();
    }


    public int compareByName(Student student1, Student student2) {
        return student1.getName().compareToIgnoreCase(student2.getName());
    }

    public int compareByScore(Student student1, Student student2) {
        return student1.getScore() - student2.getScore();
    }

}
