package dev.rafael.springbootneo4j.services;

import dev.rafael.springbootneo4j.models.Lesson;
import dev.rafael.springbootneo4j.repositories.LessonRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LessonService {
    private final LessonRepository lessonRepository;

    public LessonService( LessonRepository lessonRepository ) {
        this.lessonRepository = lessonRepository;
    }

    public List<Lesson> getAllLessonsByCourseIdentifier(String identifier){
        return lessonRepository.findLessonByCourseIdentifier(identifier);
    }
}
