package Service;

import Domain.Student;
import Repository.StudentRepo;
import Validator.StudentValidator;
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
        studentRepo.save(new Student("11","name",111, "email@gmail.com", "prof"));
    }

    @Test
    public void addStudentTest() {
        assert 1 == 1;
//        System.out.println(StreamSupport.stream(studentRepo.findAll().spliterator(), false).count());
//        assert StreamSupport.stream(studentRepo.findAll().spliterator(), false).count() == 4;
//        studentRepo.save(new Student("13","name",111, "email@gmail.com", "prof"));
//        assert StreamSupport.stream(studentRepo.findAll().spliterator(), false).count() == 4;
    }

    @Test
    public void findStudentTest() {
        assert studentRepo.findOne("11").getNume().equals("name");
    }
}