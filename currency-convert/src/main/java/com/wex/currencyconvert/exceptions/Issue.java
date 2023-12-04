package com.wex.currencyconvert.exceptions;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.wex.currencyconvert.enums.IssueEnum;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class Issue implements Serializable {
    @JsonProperty
    private final int code;
    @JsonProperty private final String message;
    @JsonProperty private List<String> details;

    public Issue(final IssueEnum issue) {
        code = issue.getCode();
        message = issue.getFormattedMessage();
    }

    public Issue(final IssueEnum issue, final Object... args) {
        code = issue.getCode();
        message = issue.getFormattedMessage(args);
    }

    public Issue(final IssueEnum issue, final List<String> details) {
        this(issue);
        this.details = details;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public List<String> getDetails() {
        return details;
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, details, message);
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        final var other = (Issue) obj;
        return code == other.code
                && Objects.equals(details, other.details)
                && Objects.equals(message, other.message);
    }

}
