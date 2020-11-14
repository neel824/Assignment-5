import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class HolidayBonusTestSTUDENT {
	
	private double[][] dataSetSTUDENT = {{1,3,5},{2,2},{5,6,7}};	
	
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

		@Test
		public void testCalculateHolidayBonus() {
			try{
			double[] result = HolidayBonus.calculateHolidayBonus(dataSetSTUDENT,6000,2000,3000);
			assertEquals(7000.0,result[0],.001);
			assertEquals(5000.0,result[1],.001);
			assertEquals(18000.0,result[2],.001);
					}
			catch (Exception e) {
				fail("This should not have caused an Exception");
			} 
			
		}
	@Test
	public void testCalculateTotalHolidayBonus() {
		assertEquals(30000.0,HolidayBonus.calculateTotalHolidayBonus(dataSetSTUDENT, 6000, 2000, 3000),.001);
	
	}

}