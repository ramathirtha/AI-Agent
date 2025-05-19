package com.prosper.ai.utilities.constants;

public class StringConstants {

    public static final String W2_CATEGORY_PROMPT = " The document is a W2 form. Extract field such as Total Taxable Income, Employer Name, Employer Address, Employee Name, Employee Address, etc.";
    public static final String PAY_STUB_CATEGORY_PROMPT = " The document is a pay stub. Extract field such as Pay Period End Date, Pay Date, Regular Pay or Base Pay, Year to Date total Pay, etc.";
    public static final String BANK_STATEMENT_CATEGORY_PROMPT = " The document is a bank statement. Extract field such as Account Holder Name, Account Balance, Account Time Period with Bank, Type of Account, etc.";
    public static final String INSURANCE_STATEMENT_CATEGORY_PROMPT = " The document is an insurance statement. Extract field such as Insured Location, Coverage good through date, Annual premium converted to monthly amount for Debt Calculations, etc.";
    public static final String OTHER_CATEGORY_PROMPT = " ";

}
