package dev.rafael.springbootdatajpa.paginator;

public class PageIntem {

    private int numero;
    private boolean actual;

    public PageIntem(int numero, boolean actual) {
        this.numero = numero;
        this.actual = actual;
    }

    public int getNumero() {
        return numero;
    }

    public boolean isActual() {
        return actual;
    }
}
