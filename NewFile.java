import com.fullstack.demo.Course;
import com.fullstack.demo.Instructor;

public class NewFile {
    public static void main(String[] args) {

        Instructor instructor1 =
                new Instructor("I001", "Shahir", "Java");

        Course course1 = new Course(
                "A1",
                "Java Programming",
                40,
                "Beginner",
                "Programming",
                true
        );
        
        course1.setInstructor(instructor1);
        course1.printSummary();
    }
}