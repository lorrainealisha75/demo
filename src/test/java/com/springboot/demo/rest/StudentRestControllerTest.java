package com.springboot.demo.rest;

import com.springboot.demo.entity.Student;
import com.springboot.demo.service.StudentService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@ExtendWith(SpringExtension.class)
@WebMvcTest(value= StudentRestController.class)
@WithMockUser
public class StudentRestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private StudentService studentService;

    Student mockStudent = new Student(1, "Thorin", "Oakheart", "to@gmail.com");

    @Test
    public void getStudent() throws Exception {
        Mockito.when(studentService.findById(Mockito.anyInt())).thenReturn(mockStudent);

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/students/1").accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        System.out.println(result.getResponse().getContentAsString());

        String expected = "{\"id\":1,\"firstName\":\"Thorin\",\"lastName\":\"Oakheart\",\"email\":\"to@gmail.com\"}";

        JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
    }
}
