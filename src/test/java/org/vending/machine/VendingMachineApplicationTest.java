package org.vending.machine;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class VendingMachineApplicationTest {

	VendingMachineService vendingMachineService;

	@Before
	public void setUp() {
		vendingMachineService = VendingMachineService.getInstance();
	}
	@Test
	public void canInsertValidCoin(){
		Assert.assertTrue(vendingMachineService.isCoinAcceptedDenomination("1"));
	}

	@Test
	public void canNotInsertInvalidCoin(){
		Assert.assertFalse(vendingMachineService.isCoinAcceptedDenomination("0.05"));
	}
	

}
