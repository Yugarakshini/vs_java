import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class StudentGradeCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of students: ");
        int n = scanner.nextInt();

        System.out.print("Enter the maximum marks: ");
        int maxMarks = scanner.nextInt();

        Student[] students = new Student[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Enter the name of student " + (i + 1) + ": ");
            String name = scanner.next();

            System.out.print("Enter the marks of student " + (i + 1) + ": ");
            int marks = scanner.nextInt();

            students[i] = new Student(name, marks);
        }

        ExecutorService executorService = Executors.newFixedThreadPool(n);
        Future[] futures = new Future[n];
        for (int i = 0; i < n; i++) {
            futures[i] = executorService.submit(new StudentGradeCalculatorTask(students[i], maxMarks));
        }

        for (int i = 0; i < n; i++) {
            try {
                System.out.println("Student " + students[i].getName() + " has scored " + ((StudentGradeCalculatorTask) futures[i]).getGrade() + "%");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        executorService.shutdown();
    }
}

class Student {

    private String name;
    private int marks;

    public Student(String name, int marks) {
        this.name = name;
        this.marks = marks;
    }

    public String getName() {
        return name;
    }

    public int getMarks() {
        return marks;
    }
}

class StudentGradeCalculatorTask implements Runnable {

    private Student student;
    private int maxMarks;

    public StudentGradeCalculatorTask(Student student, int maxMarks) {
        this.student = student;
        this.maxMarks = maxMarks;
    }

    @Override
    public void run() {
        int grade = (student.getMarks() * 100) / maxMarks;
        student.setGrade(grade);
    }

    public int getGrade() {
        return student.getGrade();
    }
}