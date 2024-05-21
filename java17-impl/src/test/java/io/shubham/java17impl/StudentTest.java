package io.shubham.java17impl;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentTest extends BaseTest {

    @Test
    public void testOrganizationResource() {
        Student student = stub(Student.class);
        Student organizationResource_fail = new Student("id", student.name());
        Student organizationResource_pass = new Student(student.id(),
                student.name());
        assertNotEquals(student, organizationResource_fail);
        assertEquals(student, organizationResource_pass);
    }

}