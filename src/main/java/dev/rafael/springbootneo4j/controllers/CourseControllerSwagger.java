package dev.rafael.springbootneo4j.controllers;

import dev.rafael.springbootneo4j.DTO.CourseDTO;
import dev.rafael.springbootneo4j.models.Course;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import java.util.List;

@Tag(name = "1. Courses", description = "Administration for Course entity")
public interface CourseControllerSwagger {

    @Operation(summary = "Get list of Courses")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    content = { @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = Course.class))})
    })
    ResponseEntity<List<Course>> courseIndex1();

    @Operation(summary = "Get list of Courses with Lessons")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    content = { @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = CourseDTO.class))})
    })
    ResponseEntity<List<CourseDTO>> courseIndex();

    @Operation(summary = "Get Course Details")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    content = { @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = CourseDTO.class))})
    })
    ResponseEntity<CourseDTO> courseDetails(String identifier);
}

