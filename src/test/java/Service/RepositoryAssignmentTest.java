package Service;

import Domain.Teme;
import Repository.TemeRepo;
import Validator.TemeValidator;
import Validator.ValidationException;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.fail;

public class RepositoryAssignmentTest {
    private static final TemeRepo temeRepo = new TemeRepo(
            new TemeValidator(), "src/main/java/teme.xml");

    @Before
    public void setUp() throws Exception {
//        studentRepo.save(new Student("11","name",111, "email@gmail.com", "prof"));
    }

    @Test
    public void addAssignmentInvalid() {
        try {
            temeRepo.save(new Teme(null,
                    "Hello",
                    -1, -1));
            fail();
        } catch (ValidationException e) {
        }
    }

    @Test
    public void addAssignmentValid() {
        try {
            temeRepo.save(new Teme(5,
                    "Hello",
                    5, 6));
        } catch (ValidationException e) {
            fail();
        }
    }
}
