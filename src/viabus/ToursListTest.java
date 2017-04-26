package viabus;

import java.rmi.RemoteException;
import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ToursListTest {

	ToursList t;

	@Before
	public void setUp() throws Exception {
		t = new ToursList();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() throws RemoteException {
		t.add(new Trip("sfadf", new Date(), "dsfds", "dfsfs"));
	}

}
