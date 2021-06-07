package com.damdeeng.tour.test.service;

import com.damdeeng.tour.test.entity.Account;

public class AccountContext {
    
    private static final ThreadLocal<Account> ACCOUNT_THREAD_LOCAL = new ThreadLocal<>();

    public static void setAccountThreadLocal(Account account) {
        ACCOUNT_THREAD_LOCAL.set(account);
    }

    public static Account getAccountThreadLocal() {
        return ACCOUNT_THREAD_LOCAL.get();
    }

}
