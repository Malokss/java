package zadatak1_napredna;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "Ana", 22, 4.5));
        students.add(new Student(2, "Ivan", 21, 3.8));
        students.add(new Student(3, "Marta", 23, 3.2));
        students.add(new Student(4, "Petar", 22, 4.0));
        students.add(new Student(5, "Lucija", 21, 3.5));

        // Filtriranje studenata s ocjenama iznad 4.0
        List<Student> filteredList = StudentUtils.filterStudents(students, student -> student.getGpa() > 4.0);
        System.out.println("Filtrirani popis:");
        for (Student student : filteredList) {
            System.out.println(student.getName() + ", " + student.getGpa());
        }

        // Mapiranje svih studenata s poveæanjem ocjene za 0.5
        List<Student> mappedList = StudentUtils.mapStudents(students, student -> {
            student.setGpa(student.getGpa() + 0.5);
            return student;
        });
        System.out.println("Mapirani popis:");
        for (Student student : mappedList) {
            System.out.println(student.getName() + ", " + student.getGpa());
        }
    }
}
