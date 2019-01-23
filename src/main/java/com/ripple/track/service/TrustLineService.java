package com.ripple.track.service;

public interface TrustLineService {

    void recordCredit(Number creditedAmount);
    void trustLineDebit(Number creditedAmount);
}
