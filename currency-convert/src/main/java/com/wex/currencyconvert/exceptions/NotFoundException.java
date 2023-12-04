package com.wex.currencyconvert.exceptions;

import com.wex.currencyconvert.enums.IssueEnum;

public class NotFoundException extends GlobalException{

    private static final long serialVersionUID = 1L;

    protected NotFoundException(final Issue issue){
        super(issue);
    }

    public static NotFoundException notFoundId() {

        return new NotFoundException(new Issue(IssueEnum.NOT_FOUND_ID));
    }

    public static NotFoundException notFoundCountry() {

        return new NotFoundException(new Issue(IssueEnum.NOT_FOUND_ID));
    }
}
