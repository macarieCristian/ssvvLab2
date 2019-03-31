package Service;

import Domain.Student;
import Repository.StudentRepo;
import Validator.StudentValidator;
import Validator.ValidationException;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.stream.StreamSupport;

import static org.junit.Assert.*;

public class RepositoryStudentTest {
    private static final StudentRepo studentRepo = new StudentRepo(new StudentValidator(),"src/main/java/studenti.xml");

    @Before
    public void setUp() throws Exception {
//        studentRepo.save(new Student("11","name",111, "email@gmail.com", "prof"));
    }

    @Test
    public void addStudentTest() {
        try {
            studentRepo.save(new Student("19","name",112, "email@gmail.com", "prof"));
        } catch (ValidationException e) {
            fail();
        }
    }

    @Test
    public void findStudentTest() {
        assert studentRepo.findOne("11").getNume().equals("name");
    }
}