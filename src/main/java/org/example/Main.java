package org.example;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws Exception {

        List<Student> students = new ArrayList<>();
        students.add(new Student("Eshmat", 24));
        students.add(new Student("Toshmat", 18));
        students.add(new Student("Jasur", 22));

        String json = new Gson().toJson(students);
        System.out.println("Json file: " + json);

        Files.writeString(Path.of("students"), json);
        String students1 = Files.readString(Path.of("students"));
        Type type = TypeToken.getParameterized(List.class, Student.class).getType();
        Gson gson = new Gson();
        List<Student> studentList = gson.fromJson(students1, type);
        Stream<Student> stream = studentList.stream();
        Optional<Integer> reduce = stream.map(Student::getAge).reduce(Integer::sum);
        double i = reduce.get();
        double result = (i /studentList.size());
        System.out.println("O'rtacha yosh: " + result);

    }
}

class Student {
    private String fullname;
    private int age;

    public int getAge() {
        return age;
    }

    public Student(String fullname, int age) {
        this.fullname = fullname;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "fullname='" + fullname + '\'' +
                ", age=" + age +
                '}';
    }
}






