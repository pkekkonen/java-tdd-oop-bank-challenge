package com.booleanuk.core;

import java.util.*;


public class Bank {

    private HashMap<Customer, ArrayList<Account>> accounts;

    public Bank() {
        accounts = new HashMap<>();
    }

    public int createCurrentAccount(Customer customer) {
        Account account = new Account(customer);
        addAccountToCustomer(customer, account);
        return account.getId();
    }

    public int createSavingsAccount(Customer customer) {
        Account account = new Account(customer);
        addAccountToCustomer(customer, account);
        return account.getId();
    }


    // For testing purposes
    protected ArrayList<Account> getAccounts(Customer customer) {
        return accounts.get(customer);
    }

    private void addAccountToCustomer(Customer customer, Account account) {
        if(accounts.containsKey(customer)) {
            ArrayList<Account> customerAccounts = accounts.get(customer);
            customerAccounts.add(account);
            accounts.put(customer, customerAccounts);
            return;
        }
        accounts.put(customer, new ArrayList<>(Collections.singletonList(account)));
    }

    //TODO: check so amount it >0
    public String deposit(int amount, Customer customer, int accountId) {
        if(!accounts.containsKey(customer)) {
            return "Customer doesn't exist.";
        }
        ArrayList<Account> customerAccounts = accounts.get(customer);
        for(Account customerAccount: customerAccounts) {
            if(customerAccount.getId() == accountId) {
                customerAccount.deposit(amount);
                return "The deposit has been performed.";
            }
        }
        return "Account doesn't exist.";
    }

    public String withdraw(int amount, Customer customer, int accountId) {
        if(!accounts.containsKey(customer)) {
            return "Customer doesn't exist.";
        }
        return "Account doesn't exist.";
    }
}
