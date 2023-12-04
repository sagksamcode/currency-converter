package com.wex.currencyconvert.enums;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.IllegalFormatException;
import java.util.Objects;

public enum IssueEnum {

  UNEXPECTED_ERROR(1, "Unexpected error. Please contact system administrator."),
  BAD_REQUEST(2, "Malformed Request"),
  NOT_FOUND_ID(3, "Not found purchase for this id"),
  NOT_FOUND_COUNTRY(4, "Country not found"),
  PURCHASE_CANNOT_CONVERTED(5, "Purchase cannot be converted to the target currency.");



  private int code;
  private String message;

  private final Logger logger = LoggerFactory.getLogger(IssueEnum.class);

  IssueEnum(final int code, final String message) {
    this.code = code;
    this.message = message;
  }

  public int getCode() {
    return code;
  }

  public String getFormattedMessage(final Object... args) {
    var formattedMessage = "";
    if (Objects.nonNull(message)) {
      try {
        formattedMessage = String.format(message, args);
      } catch (final IllegalFormatException e) {
        logger.warn(e.getMessage(), e);
        formattedMessage = message.replace("%s", "");
      }
    }

    return formattedMessage;
  }
}
