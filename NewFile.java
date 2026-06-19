import com.fullstack.demo.Course;

public class NewFile {
    public static void main(String[] args) {
        
        Course course = new Course("C101", "Java Programming", 40, "Beginner");
        course.setCategory("Programming");
        course.setActive(true);
        course.printSummary();

    }
}
