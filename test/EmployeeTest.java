
import com.example.hr.domain.Employee;
import com.example.hr.domain.FiatCurrency;
import org.junit.jupiter.api.Test;

import java.util.function.Consumer;

import static org.junit.jupiter.api.Assertions.*;

public class EmployeeTest {
    @Test
    void test() {
        var jack = new Employee.Builder("11111111110")
                .iban("tr1")
                .department("IT")
                .fullname("jack", "bauer")
                .salary(10_000, FiatCurrency.EUR)
                .jobStyle("FULL_TIME")
                .birthYear(1965)
                .build();

        assertEquals("jack", jack.getFullName().getFirstName());
        assertEquals("bauer", jack.getFullName().getLastName());

    }

}
