package service;

import java.util.Calendar;
import java.util.Date;

import entities.Contract;
import entities.Installment;

public class ContractService {
	
	
	private OnlinePaymentService onlinePaymentService;
	
	// INJE??O DE DEP?NCIA VIA CONSTRUTOR.
	
	public ContractService(OnlinePaymentService onlinePaymentService) {
		this.onlinePaymentService = onlinePaymentService;
	}
	
	public void processContract(Contract contract, Integer months) {
	double parcela = contract.getTotalValue() / months; // 600 / 3 = 200 valor com 3 contratos.
		for(int i = 1; i<= months; i++) {
			 Date date = addMonths(contract.getDate(), i);
			double parcelaJuros = parcela + onlinePaymentService.interest(parcela, i);
			double parcelaAtualizada = parcelaJuros + onlinePaymentService.paymentFee(parcelaJuros);
			
			contract.addInstallments(new Installment(date, parcelaAtualizada));
		}
		
	}
	
	private Date addMonths(Date date, int n) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.MONTH, n);
		return cal.getTime();
	}

}
