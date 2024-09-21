import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Student {
    private String name;
    private int score;

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public void calculateGrade() {
        char grade;

        if (score >= 90) {
            grade = 'A';
        } else if (score >= 80) {
            grade = 'B';
        } else if (score >= 70) {
            grade = 'C';
        } else if (score >= 60) {
            grade = 'D';
        } else {
            grade = 'F';
        }

        System.out.println(name + " scored " + score + ", and the grade is " + grade);
    }
}

public class ExamGradeCalculator {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(5); // Create a thread pool with 5 threads

        Student[] students = {
            new Student("Student1", 92),
            new Student("Student2", 78),
            new Student("Student3", 64),
            new Student("Student4", 88),
            new Student("Student5", 73)
        };

        for (Student student : students) {
            executor.execute(() -> student.calculateGrade());
        }

        executor.shutdown(); // Shutdown the thread pool when done
    }
}
