package tddbc;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

public class SampleTest {

    @Test
    @DisplayName("should return Hello TDD Boot Camp")
    public void 十円玉50円玉100円玉500円玉1000円札を１つづつ投入できる() throws Exception {

        try {
            // Setup
            VendingMachine sut = new VendingMachine();
            // Exercise
            sut.insert(10);

        } catch (Exception e) {
            fail(e);
        }

    }

}
