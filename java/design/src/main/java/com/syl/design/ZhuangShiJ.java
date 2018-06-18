package com.syl.design;

import java.io.FilterInputStream;
import java.io.InputStream;

public class ZhuangShiJ {

}
class LowerCaseInputStream extends FilterInputStream{
    /**
     * Creates a <code>FilterInputStream</code>
     * by assigning the  argument <code>in</code>
     * to the field <code>this.in</code> so as
     * to remember it for later use.
     *
     * @param in the underlying input stream, or <code>null</code> if
     *           this instance is to be created without an underlying stream.
     */
    protected LowerCaseInputStream(InputStream in) {
        super(in);
    }
}
class As{
    private As(){}
    public As(int a){}

}
class Asss extends As{
    private Asss() {
        super(2);
    }
}