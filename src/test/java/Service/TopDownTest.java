package Service;

import Domain.Nota;
import Domain.Student;
import Domain.Teme;
import Repository.NoteRepo;
import Repository.StudentRepo;
import Repository.TemeRepo;
import Validator.NotaValidator;
import Validator.StudentValidator;
import Validator.TemeValidator;
import Validator.ValidationException;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

import java.util.AbstractMap;

import static org.junit.Assert.fail;

public class TopDownTest {

    private static final StudentRepo studentRepo = new StudentRepo(new StudentValidator(), "src/main/java/studenti.xml");
    private static final TemeRepo temeRepo = new TemeRepo(new TemeValidator(), "src/main/java/teme.xml");
    private static final NoteRepo noteRepo = new NoteRepo(new NotaValidator());

    @Before
    public void setUp() throws Exception {
//        studentRepo.save(new Student("11","name",111, "email@gmail.com", "prof"));
    }

    @Test
    public void addStudentTest() {
        try {
            studentRepo.save(new Student("19", "name", 112, "email@gmail.com", "prof"));
        } catch (ValidationException e) {
            fail();
        }
    }

    @Test
    public void addStudentAndAssignment() {
        try {
            studentRepo.save(new Student("19", "name", 112, "email@gmail.com", "prof"));
            temeRepo.save(new Teme(5, "Hello", 5, 6));
        } catch (ValidationException e) {
            TestCase.fail();
        }
    }

    @Test
    public void addStudentAndAssignmentAndGrade() {
        try {
            Student s = studentRepo.save(new Student("19", "name", 112, "email@gmail.com", "prof"));
            Teme t = temeRepo.save(new Teme(5, "Hello", 5, 6));

            noteRepo.save(new Nota(
                    new AbstractMap.SimpleEntry<String, Integer>("Alex", 1),
                    s,
                    t,
                    5.5f,
                    5
            ), "Elevul a invatat bine");
        } catch (ValidationException e) {
            TestCase.fail();
        }
    }
}
