package sit707_week5;


import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Test;
public class WeatherControllerTest {
	
	private static WeatherController wController;
    private static int nHours;
    private static double minTemperature;
    private static double maxTemperature;
    private static double averageTemp;
	
    @BeforeClass
    public static void setUp() {
    	 // Initialise controller
        wController = WeatherController.getInstance();

        // Retrieve all the hours temperatures recorded as for today
        nHours = wController.getTotalHours();
        minTemperature = 1000;
        maxTemperature = -1;
        double sumTemp = 0;
        for (int i=0; i<nHours; i++) {
            
            double temperatureVal = wController.getTemperatureForHour(i+1); 
            if (minTemperature > temperatureVal) {
                minTemperature = temperatureVal;
            }
            if (maxTemperature < temperatureVal) {
                maxTemperature = temperatureVal;
            }
            sumTemp += temperatureVal;
        }
        averageTemp = sumTemp / nHours;
    }
    
    @AfterClass
    public static void tearDown() {
        // Shutdown controller
        wController.close();
    }
	
	@Test
	public void testStudentIdentity() {
		String studentId = "221105067";
		Assert.assertNotNull("Student ID is ", studentId);
	}

	@Test
	public void testStudentName() {
		String studentName = "jiaqi li";
		Assert.assertNotNull("Student name is ", studentName);
	}

	@Test
	public void testTemperatureMin() {
		 System.out.println("+++ testTemperatureMin +++");

	      

	        // Should be equal to the min value that is cached in the controller.
	        Assert.assertTrue(wController.getTemperatureMinFromCache() == minTemperature);	
	}
	
	@Test
	public void testTemperatureMax() {
		System.out.println("+++ testTemperatureMax +++");
		
		
		
		// Should be equal to the min value that is cached in the controller.
		Assert.assertTrue(wController.getTemperatureMaxFromCache() == maxTemperature);
		
	}

	@Test
	public void testTemperatureAverage() {
		System.out.println("+++ testTemperatureAverage +++");
		
		
		// Should be equal to the min value that is cached in the controller.
		Assert.assertTrue(wController.getTemperatureAverageFromCache() == averageTemp);
		
		
	}
	
	@Test
	public void testTemperaturePersist() {
		/*
		 * Remove below comments ONLY for 5.3C task.
		 */
//		System.out.println("+++ testTemperaturePersist +++");
//		
//		// Initialise controller
//		WeatherController wController = WeatherController.getInstance();
//		
//		String persistTime = wController.persistTemperature(10, 19.5);
//		String now = new SimpleDateFormat("H:m:s").format(new Date());
//		System.out.println("Persist time: " + persistTime + ", now: " + now);
//		
//		Assert.assertTrue(persistTime.equals(now));
//		
//		wController.close();
	}
}
