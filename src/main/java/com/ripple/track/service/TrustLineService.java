package com.ripple.track.service;

public interface TrustLineService {

    Number recordCredit(Number creditedAmount);
    void trustLineDebit(Number creditedAmount);
}
