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
    }

    @Override
    public void recordCredit(Number creditedAmount) {
        debt = debt.doubleValue() + creditedAmount.doubleValue();
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