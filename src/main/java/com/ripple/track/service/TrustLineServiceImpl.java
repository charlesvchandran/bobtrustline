package com.ripple.track.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class TrustLineServiceImpl implements TrustLineService {

	Logger logger = LoggerFactory.getLogger(getClass());
	
	private Number debt;
	
	public TrustLineServiceImpl() {
		debt = 0;
		logger.info("Welcome to the Trustline");
		logger.info("Trustline balance is: " + debt);
	}

    @Override
    public Number recordCredit(Number creditedAmount) {
       return debt = debt.doubleValue() + creditedAmount.doubleValue();
    }

    @Override
    public void trustLineDebit(Number creditedAmount) {
    	StringBuilder strBuilder = new StringBuilder("You were paid ");
    	strBuilder.append(creditedAmount);
    	strBuilder.append("!");
    	logger.info(strBuilder.toString());

    	StringBuilder balanceStrBuilder = new StringBuilder("Trustline balance is: ");
    	balanceStrBuilder.append(debt);
        logger.info(balanceStrBuilder.toString());
    }
}
