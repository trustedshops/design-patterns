package com.trustedshops.examples.patterns.chain;

public interface ChainElement<T> {
    ChainElement<T> getSucessor();

    ChainElement<T> setSucessor(ChainElement<T> sucessor);

    void execute(T item);
}
