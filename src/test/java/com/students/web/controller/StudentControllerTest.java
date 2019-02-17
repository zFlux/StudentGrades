package com.students.web.controller;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.configurationprocessor.json.JSONArray;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class StudentControllerTest {

    @Value("${json.test.folder}")
    String jsonTestFolder;


    @Autowired
    private MockMvc mvc;

    @Test
    public void studentsAndGrades_getStudentRecords_studentsAndGradesReturned() throws Exception {

        String expectedString = readFile(jsonTestFolder + "/student_grades.get.json", Charset.defaultCharset());
        this.mvc.perform(get("/student_records").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
                .andExpect(content().string(expectedString));
    }

    @Test
    public void noStudentOrGrades_createStudentRecords_studentsAndGradesCreated() throws Exception {

        String studentRecordsToCreate = readFile(jsonTestFolder + "/student_grades.post.json", Charset.defaultCharset());

        String firstStudentRecordToCreate = getStudentRecordAtIndex(studentRecordsToCreate, 0);
        String secondStudentRecordToCreate = getStudentRecordAtIndex(studentRecordsToCreate, 1);

        this.mvc.perform(post("/student_records").content(studentRecordsToCreate).contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());

        this.mvc.perform(get("/student/UOT-001-4").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
                .andExpect(content().json(firstStudentRecordToCreate));

        this.mvc.perform(get("/student/UOT-001-5").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
                .andExpect(content().json(secondStudentRecordToCreate));

        this.mvc.perform(delete("/student/UOT-001-4").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
        this.mvc.perform(delete("/student/UOT-001-5").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());

    }

    @Test
    public void student_getStudentByID_studentReturned() throws Exception {
        String expectedString = readFile(jsonTestFolder + "/student.get.json", Charset.defaultCharset());
        this.mvc.perform(get("/student/UOT-001-2").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
                .andExpect(content().string(expectedString));
    }

    @Test
    public void grades_getGradesByID_gradesReturned() throws Exception {
        String expectedString = readFile(jsonTestFolder + "/grades.get.by.id.json", Charset.defaultCharset());
        this.mvc.perform(get("/grade/UOT-001-2").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
                .andExpect(content().string(expectedString));
    }

    @Test
    public void grade_getGradeByIDAndYear_gradeReturned() throws Exception {
        String expectedString = readFile(jsonTestFolder + "/grade.get.by.id.and.year.json", Charset.defaultCharset());
        this.mvc.perform(get("/grade/UOT-001-2/2014").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
                .andExpect(content().string(expectedString));
    }

    @Test
    public void noGrade_createGrade_GradeCreated() throws Exception {
        String createdGrade = readFile(jsonTestFolder + "/grade.post.json", Charset.defaultCharset());
        this.mvc.perform(post("/grade").contentType(MediaType.APPLICATION_JSON).content(createdGrade)).andExpect(status().isOk());
        this.mvc.perform(get("/grade/UOT-001-3/2019").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
                .andExpect(content().string(createdGrade));
        this.mvc.perform(delete("/grade/UOT-001-3/2019").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
    }

    @Test
    public void noStudent_createStudent_StudentCreated() throws Exception {
        String createdStudent = readFile(jsonTestFolder + "/student.post.json", Charset.defaultCharset());
        this.mvc.perform(post("/student").contentType(MediaType.APPLICATION_JSON).content(createdStudent)).andExpect(status().isOk());
        this.mvc.perform(get("/student/UOT-001-3").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
                .andExpect(content().json(createdStudent));
        this.mvc.perform(delete("/student/UOT-001-3").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
    }

    static String readFile(String path, Charset encoding)
            throws IOException {
        byte[] encoded = Files.readAllBytes(Paths.get(path));
        return new String(encoded, encoding).trim();
    }

    static String getStudentRecordAtIndex(String jsonStudentRecords, int index) throws JSONException {
        JSONObject jsonCreatedStudentRecords = new JSONObject(jsonStudentRecords);
        JSONArray studentRecordArray = jsonCreatedStudentRecords.getJSONArray("data");
        return studentRecordArray.getJSONObject(index).toString(2);
    }


}
