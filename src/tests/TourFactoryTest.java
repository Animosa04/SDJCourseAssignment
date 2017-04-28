package tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import viabus.TourFactory;
import viabus.Travel;
import viabus.Trip;

public class TourFactoryTest {
	private TourFactory tf;

	@Before
	public void setUp() throws Exception {
		tf = new TourFactory();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test(expected = IllegalArgumentException.class)
	public void testGetTour() throws IllegalArgumentException {
		Assert.assertTrue(tf.getTour("trip") instanceof Trip);
		Assert.assertTrue(tf.getTour("travel") instanceof Travel);
		Assert.assertTrue(tf.getTour("Trip") instanceof Trip);
		Assert.assertTrue(tf.getTour("Travel") instanceof Travel);
		Assert.assertTrue(tf.getTour("TrIp") instanceof Trip);
		Assert.assertTrue(tf.getTour("tRaVeL") instanceof Travel);
		tf.getTour("foobar");
	}

}
