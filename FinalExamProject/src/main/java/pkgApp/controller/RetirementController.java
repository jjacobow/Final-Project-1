package pkgApp.controller;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import pkgApp.RetirementApp;
import pkgCore.Retirement;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;


public class RetirementController implements Initializable {

	private RetirementApp mainApp = null;
	
	@FXML
	private Label LbLSaveEachMonth;
	@FXML
	private TextField txtYearsToWork;
	@FXML
	private TextField txtAnnualReturnWorking;
	@FXML
	private Label LbLWhatYouNeedSaved;
	@FXML
	private TextField txtYearsRetired;
	@FXML
	private TextField txtAnnualReturnRetired;
	@FXML
	private TextField txtRequiredIncome;
	@FXML
	private TextField txtMonthlySSI;

	public RetirementApp getMainApp() {
		return mainApp;
	}

	public void setMainApp(RetirementApp mainApp) {
		this.mainApp = mainApp;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {		
	}
	
	@FXML
	public void btnClear(ActionEvent event) {
		
		LbLSaveEachMonth.setText("");
		txtYearsToWork.setText("");;
		txtAnnualReturnWorking.setText("");
		LbLWhatYouNeedSaved.setText("");
		txtYearsRetired.setText("");
		txtAnnualReturnRetired.setText("");
		txtRequiredIncome.setText("");
		txtMonthlySSI.setText("");
	}
	
	@FXML
	public void btnCalculate(ActionEvent event) {
		try {
		int iYearsWork = Integer.parseInt(txtYearsToWork.getText());
		double dAnnualReturnWork = Double.parseDouble(txtAnnualReturnWorking.getText());
		int iYearsRetired = Integer.parseInt(txtYearsRetired.getText());
		double dAnnualReturnRetired = Double.parseDouble(txtAnnualReturnRetired.getText());
		double dSSIAmt = Double.parseDouble(txtMonthlySSI.getText());
		double dRequiredIncome = Double.parseDouble(txtRequiredIncome.getText());
		//"Retirement basically means Freedom"//
		Retirement Freedom = new Retirement();
		Freedom.setiYearsRetired(iYearsRetired);
		Freedom.setdAnnualReturnRetired(dAnnualReturnRetired);
		Freedom.setdMonthlySSI(dSSIAmt);
		Freedom.setdRequiredIncome(dRequiredIncome);
		Freedom.setiYearsToWork(iYearsWork);
		Freedom.setdAnnualReturnWorking(dAnnualReturnWork);

		LbLSaveEachMonth.setText(String.format("%d",Freedom.AmountToSave()));
		LbLWhatYouNeedSaved.setText(String.format("%d", Freedom.TotalAmountSaved()*-1));
	}catch(NumberFormatException e) {
		LbLSaveEachMonth.setText("Not a #");
		LbLWhatYouNeedSaved.setText("Not a #");
	}catch(Exception e) {
		LbLSaveEachMonth.setText("Error");
		LbLWhatYouNeedSaved.setText("Error");  
	}
	}	
}
