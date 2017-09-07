package com.trustedshops.examples.javaDesignPatterns.chain;

public abstract class AbstractChainElement<T> {
    private AbstractChainElement<T> sucessor;

    public AbstractChainElement<T> getSucessor() {
        return sucessor;
    }

    public AbstractChainElement<T> setSucessor(AbstractChainElement<T> sucessor) {
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
