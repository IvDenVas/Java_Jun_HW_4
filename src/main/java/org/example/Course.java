package org.example;

import javax.persistence.*;
import java.util.Random;

@Entity
@Table(name = "courses")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private int duration;
    private static final String[] titles = new String[] { "Алгебра", "Геометрия", "Физика", "Химия", "Биология",
            "История", "Информатика", "Физ-ра" };
    private static final Random random = new Random();

    public Course(int id, String title, int duration) {
        this.id = id;
        this.title = title;
        this.duration = duration;
    }

    public Course(String title, int duration) {
        this.title = title;
        this.duration = duration;
    }

    public Course() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", duration=" + duration +
                '}';
    }
    public static Course create() {
        return new Course(titles[random.nextInt(titles.length)],random.nextInt(300,500));
    }
    public void updateDuration(){
        duration = random.nextInt(300, 500);
    }

    public void updateTitle(){
        title = titles[random.nextInt(titles.length)];
    }
}
