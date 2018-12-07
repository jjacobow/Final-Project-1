package pkgTest;

import static org.junit.Assert.*;

import org.junit.Test;

import pkgCore.Retirement;

public class RetirementTest {

	@Test
	public void TestPV() {
		double dExpectedPV = -1454485.55;
		int iYearsRetired = 20;
		double dAnnualReturn = 0.02;
		double dRequiredIncome = 10000;
		double dSSIAmt = 2642;
		Retirement Freedom = new Retirement();
		Freedom.setiYearsRetired(iYearsRetired);
		Freedom.setdAnnualReturnRetired(dAnnualReturn);
		Freedom.setdRequiredIncome(dRequiredIncome);
		Freedom.setdMonthlySSI(dSSIAmt);
		assertEquals(dExpectedPV,Freedom.TotalAmountSaved(),0.05);
	}
	@Test
	public void TestPMT() {
		double ExpectedPMT = 554.13;
		int iYearsWork = 40;
		double dAnnualReturnWork = 0.07;
		double dExpectedPV = -1454485.55;
		int iYearsRetired = 20;
		double dAnnualReturn = 0.02;
		double dRequiredIncome = 10000;
		double dSSIAmt = 2642;
		
		Retirement Freedom = new Retirement();
		Freedom.setiYearsToWork(iYearsWork);
		Freedom.setdAnnualReturnWorking(dAnnualReturnWork);
		Freedom.setiYearsRetired(iYearsRetired);
		Freedom.setdAnnualReturnRetired(dAnnualReturn);
		Freedom.setdRequiredIncome(dRequiredIncome);
		Freedom.setdMonthlySSI(dSSIAmt);
		assertEquals(dExpectedPV,Freedom.TotalAmountSaved(),0.05);
		assertEquals(ExpectedPMT, Freedom.AmountToSave(),0.05);
	}

}
