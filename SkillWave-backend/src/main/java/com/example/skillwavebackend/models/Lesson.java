package com.example.skillwavebackend.models;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "lessons")
@Data
public class Lesson {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Column(columnDefinition = "TEXT")
    private String content;

    private String videoUrl;

    private Integer lessonOrder;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;
}
