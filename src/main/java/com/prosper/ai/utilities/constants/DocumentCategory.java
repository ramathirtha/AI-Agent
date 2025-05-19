package com.prosper.ai.utilities.constants;

import static com.prosper.ai.utilities.constants.StringConstants.BANK_STATEMENT_CATEGORY_PROMPT;
import static com.prosper.ai.utilities.constants.StringConstants.INSURANCE_STATEMENT_CATEGORY_PROMPT;
import static com.prosper.ai.utilities.constants.StringConstants.OTHER_CATEGORY_PROMPT;
import static com.prosper.ai.utilities.constants.StringConstants.PAY_STUB_CATEGORY_PROMPT;
import static com.prosper.ai.utilities.constants.StringConstants.W2_CATEGORY_PROMPT;

public enum DocumentCategory {

    // 4 types of Enums, W2, PAYSTUB, BANK_STATEMENT, OTHER
    W2("W2", W2_CATEGORY_PROMPT),
    PAY_STUB("PAY_STUB", PAY_STUB_CATEGORY_PROMPT),
    BANK_STATEMENT("BANK_STATEMENT", BANK_STATEMENT_CATEGORY_PROMPT),
    INSURANCE_STATEMENT("INSURANCE_STATEMENT", INSURANCE_STATEMENT_CATEGORY_PROMPT),
    OTHER("OTHER", OTHER_CATEGORY_PROMPT);

    private final String value;
    private final String categoryRelatedQuery;

    DocumentCategory(String value, String categoryRelatedQuery) {
        this.value = value;
        this.categoryRelatedQuery = categoryRelatedQuery;
    }

    public String getValue() {
        return value;
    }

    public String getCategoryRelatedQuery() {
        return categoryRelatedQuery;
    }

    @Override
    public String toString() {
        return value;
    }

}
