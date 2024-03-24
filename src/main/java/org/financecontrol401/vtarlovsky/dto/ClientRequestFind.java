package org.financecontrol401.vtarlovsky.dto;

public class ClientRequestFind<T> {
    //--------------------


    private T findParam;

    public ClientRequestFind(T findParam) {
        this.findParam = findParam;
    }

    public T getFindParam() {
        return findParam;
    }


}
