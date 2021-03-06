package models;

public class Individual extends TaxPayer {
	
	private Double healthExpenditures;
	
	
	public Individual() {
		super();
	}
	
	public Individual(String name, Double anualIncome, Double healthExpenditures) {
		super(name, anualIncome);
		this.healthExpenditures = healthExpenditures;
	}



	@Override
	public Double tax() {
		Double renda = 0.0;
		if(super.getAnualIncome() < 20000.00 ) {
			renda = (super.getAnualIncome() * 0.15) - (healthExpenditures * 0.50);
		}
		else if(super.getAnualIncome() >= 20000.00) {
			renda = (super.getAnualIncome() * 0.25) - (healthExpenditures * 0.50);
		}
		return renda;
	}

}
