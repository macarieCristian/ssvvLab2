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
    public void addStudentIdNullTest() {
        try {
            studentRepo.save(new Student(null,"name",112, "email@gmail.com", "prof"));
            fail();
        } catch (ValidationException e) {

        }
    }

    @Test
    public void addStudentIdEmptyTest() {
        try {
            studentRepo.save(new Student("","name",112, "email@gmail.com", "prof"));
            fail();
        } catch (ValidationException e) {

        }
    }

    @Test
    public void addStudentIdMinus1Test() {
        try {
            studentRepo.save(new Student("-1","name",112, "email@gmail.com", "prof"));
            fail();
        } catch (ValidationException e) {

        }
    }

    @Test
    public void addStudentId9999Test() {
        try {
            studentRepo.save(new Student("9999","name",112, "email@gmail.com", "prof"));
        } catch (ValidationException e) {
            fail();
        }
    }

    @Test
    public void addStudentId0Test() {
        try {
            studentRepo.save(new Student("0","name",112, "email@gmail.com", "prof"));
        } catch (ValidationException e) {
            fail();
        }
    }

    @Test
    public void addStudentId1Test() {
        try {
            studentRepo.save(new Student("1","name",112, "email@gmail.com", "prof"));
        } catch (ValidationException e) {
            fail();
        }
    }

    @Test
    public void addStudentId2Test() {
        try {
            studentRepo.save(new Student("2","name",112, "email@gmail.com", "prof"));
        } catch (ValidationException e) {
            fail();
        }
    }

    @Test
    public void addStudentGroup110Test() {
        try {
            studentRepo.save(new Student("110","name",110, "email@gmail.com", "prof"));
            fail();
        } catch (ValidationException e) {

        }
    }

    @Test
    public void addStudentGroup938Test() {
        try {
            studentRepo.save(new Student("938","name",938, "email@gmail.com", "prof"));
            fail();
        } catch (ValidationException e) {

        }
    }

    @Test
    public void addStudentGroup937Test() {
        try {
            studentRepo.save(new Student("937","name",937, "email@gmail.com", "prof"));
        } catch (ValidationException e) {
            fail();
        }
    }

    @Test
    public void addStudentPenultimateDigit0Test() {
        try {
            studentRepo.save(new Student("101","name",101, "email@gmail.com", "prof"));
            fail();
        } catch (ValidationException e) {

        }
    }

    @Test
    public void addStudentPenultimateDigit1Test() {
        try {
            studentRepo.save(new Student("111","name",113, "email@gmail.com", "prof"));
        } catch (ValidationException e) {
            fail();
        }
    }

    @Test
    public void addStudentUltimateDigit8Test() {
        try {
            studentRepo.save(new Student("118","name",118, "email@gmail.com", "prof"));
            fail();
        } catch (ValidationException e) {

        }
    }

    @Test
    public void addStudentUltimateDigit7Test() {
        try {
            studentRepo.save(new Student("117","name",117, "email@gmail.com", "prof"));
        } catch (ValidationException e) {
            fail();
        }
    }

    @Test
    public void addStudentNume1abc2Test() {
        try {
            studentRepo.save(new Student("123","1abc2",112, "email@gmail.com", "prof"));
            fail();
        } catch (ValidationException e) {

        }
    }

    @Test
    public void addStudentNume_aTest() {
        try {
            studentRepo.save(new Student("124","a",112, "email@gmail.com", "prof"));
        } catch (ValidationException e) {
            fail();
        }
    }

    @Test
    public void addStudentNumeEmptyTest() {
        try {
            studentRepo.save(new Student("125","",112, "email@gmail.com", "prof"));
            fail();
        } catch (ValidationException e) {

        }
    }

    @Test
    public void addStudentEmailMihaiAtYahooTest() {
        try {
            studentRepo.save(new Student("126","name",112, "mihai@yahoo", "prof"));
            fail();
        } catch (ValidationException e) {

        }
    }

    @Test
    public void addStudentEmailMihaiDotComTest() {
        try {
            studentRepo.save(new Student("127","name",112, "mihai.com", "prof"));
            fail();
        } catch (ValidationException e) {

        }
    }

    @Test
    public void addStudentProfesorTest() {
        try {
            studentRepo.save(new Student("128","name",112, "mihai@yahoo.com", "'''''"));
        } catch (ValidationException e) {
            fail();
        }
    }

    @Test
    public void findStudentTest() {
        assert studentRepo.findOne("11").getNume().equals("name");
    }
}