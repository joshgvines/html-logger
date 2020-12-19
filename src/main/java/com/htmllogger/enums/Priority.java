package com.htmllogger.enums;

/**
 * HTML Output Logger Types.
 */
public enum Priority {

    CUSTOM("<p style=\"color:cornflowerblue\" > LOG : "), 
    OKAY("<p style=\"color:green\" > LOG : OKAY : "),
    ERROR("<p style=\"color:orange\" > LOG : ERROR : "), 
    RIP("<p style=\"color:red\" > LOG : RIP : ");

    private String priority;

    private Priority(String priority) {
        this.priority = priority;
    }

    public String getPriority() {
        return priority;
    }

}
