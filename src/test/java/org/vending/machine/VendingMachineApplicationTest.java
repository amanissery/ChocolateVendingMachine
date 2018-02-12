package org.vending.machine;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

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

    @Test
    public void shouldAddUpBalanceOnCoinInsertion(){
        vendingMachineService.processCoin("0.5");
        vendingMachineService.processCoin("1");
        Assert.assertEquals(1.5, vendingMachineService.getBalanceAmount(), 0.001);
    }

    @Test
    public void shouldAddMoreMoneyIfCoinsInsertedIsLessThanTwoDollars(){
        List<String> availableProducts = new ArrayList<String>();
        availableProducts.add("4. Insert more coins");
        Assert.assertEquals(availableProducts, vendingMachineService.getAvailableOptions(1.9));
    }

    @Test
    public void displayMoreSelectionsIfCoinsInsertedGreater(){
        Assert.assertEquals(3, vendingMachineService.getAvailableOptions(3.1).size());
    }

    @Test
    public void shouldDispenseChangeIfMoreCoinsInserted(){
        Assert.assertEquals(new BigDecimal(0.9,
                new MathContext(1, RoundingMode.HALF_EVEN)), vendingMachineService.dispenseChange(4.0, "3"));
    }

    @Test
    public void shouldDispenseZeroChangeIfExactCoinsInserted(){
        Assert.assertEquals(new BigDecimal(0.0,
                new MathContext(1, RoundingMode.HALF_EVEN)), vendingMachineService.dispenseChange(3.1, "3"));
    }

}
