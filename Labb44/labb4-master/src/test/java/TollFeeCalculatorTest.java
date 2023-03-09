import edu.lernia.labb4.TollFeeCalculator;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TollFeeCalculatorTest {

    @Test
    public void testGetTotalFeeCost() {
        LocalDateTime[] dates = {
                LocalDateTime.parse("2022-03-01 06:15", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")),
                LocalDateTime.parse("2022-03-01 07:45", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")),
                LocalDateTime.parse("2022-03-01 15:10", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")),
                LocalDateTime.parse("2022-03-01 17:30", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"))
        };
        int expectedFee = 52;
        int actualFee = TollFeeCalculator.getTotalFeeCost(dates);
        assertEquals(expectedFee, actualFee);
    }

    @Test
    public void testIsTollFreeDate() {
        LocalDateTime tollFreeDate = LocalDateTime.parse("2022-03-05 12:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
        assertTrue(TollFeeCalculator.isTollFreeDate(tollFreeDate));
        LocalDateTime notTollFreeDate = LocalDateTime.parse("2022-03-07 12:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
        assertFalse(TollFeeCalculator.isTollFreeDate(notTollFreeDate));
    }

    @Test
    public void testGetTollFeePerPassing() {
        LocalDateTime[] dates = {
                LocalDateTime.parse("2022-03-01 06:15", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")),
                LocalDateTime.parse("2022-03-01 07:45", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")),
                LocalDateTime.parse("2022-03-01 15:10", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")),
                LocalDateTime.parse("2022-03-01 17:30", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"))
        };
        int[] expectedFees = {13, 18, 8, 13};
        for(int i = 0; i < dates.length; i++) {
            int actualFee = TollFeeCalculator.getTollFeePerPassing(dates[i]);
            assertEquals(expectedFees[i], actualFee);
        }
    }

}
