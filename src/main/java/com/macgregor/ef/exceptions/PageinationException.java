package com.macgregor.ef.exceptions;

import java.io.Serializable;

public class PageinationException extends Exception implements Serializable {
    private static final long serialVersionUID = 1L;
    public PageinationException() {
        super();
    }
    public PageinationException(String msg)   {
        super(msg);
    }
    public PageinationException(String msg, Exception e)  {
        super(msg, e);
    }
}
