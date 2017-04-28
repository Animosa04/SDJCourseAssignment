package tests;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import viabus.Tour;
import viabus.TourFactory;

public class TourFactoryTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetTour() {
		TourFactory tf = new TourFactory();
		Tour trip1 = tf.getTour(true);
		Tour trip2 = tf.getTour(true);
		Tour travel1 = tf.getTour(false);
		Tour travel2 = tf.getTour(false);
		assertEquals(trip1.getClass(), trip2.getClass());
		assertEquals(travel1.getClass(), travel2.getClass());
		Assert.assertNotEquals(trip1.getClass(), travel1.getClass());
	}

}
