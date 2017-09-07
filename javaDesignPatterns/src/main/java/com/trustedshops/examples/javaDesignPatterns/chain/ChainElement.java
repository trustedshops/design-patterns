package com.trustedshops.examples.javaDesignPatterns.chain;

public abstract class ChainElement<T> {
    private ChainElement<T> sucessor;

    public ChainElement<T> getSucessor() {
        return sucessor;
    }

    public ChainElement<T> setSucessor(ChainElement<T> sucessor) {
        this.sucessor = sucessor;
        return sucessor;
    }

    public void execute(T item) {
        boolean doContinue = doExecute(item);
        if(doContinue && getSucessor() != null) {
            getSucessor().execute(item);
        }
    }

    protected abstract boolean doExecute(T item);
}
