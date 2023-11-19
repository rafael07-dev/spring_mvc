package dev.rafael.springbootdatajpa.paginator;

import org.springframework.data.domain.Page;

import java.util.ArrayList;
import java.util.List;

public class PageRender<T> {

    private String url;
    private Page<T> page;
    private int totalPaginas;
    private int numeroElementosPagina;
    private int paginaActual;
    private List<PageIntem> paginas;
    public PageRender(String url, Page<T> page) {
        this.url = url;
        this.page = page;
        this.paginas = new ArrayList<PageIntem>();
        numeroElementosPagina = page.getSize();
        totalPaginas = page.getTotalPages();
        paginaActual = page.getNumber() + 1;

        int desde, hasta;

        if(totalPaginas <= numeroElementosPagina){
            desde = 1;
            hasta = totalPaginas;
        }else{
            if(paginaActual <= numeroElementosPagina / 2){
                desde = 1;
                hasta = numeroElementosPagina;
            }else if(paginaActual >= totalPaginas - numeroElementosPagina / 2){
                desde = totalPaginas - numeroElementosPagina +1;
                hasta = numeroElementosPagina;
            }else {
                desde = paginaActual - numeroElementosPagina / 2;
                hasta = numeroElementosPagina;
            }
        }
        for(int i = 0; i < hasta; i ++){
            paginas.add(new PageIntem(desde + i, paginaActual == desde + i));
        }
    }

    public String getUrl() {
        return url;
    }

    public int getTotalPaginas() {
        return totalPaginas;
    }

    public int getPaginaActual() {
        return paginaActual;
    }

    public List<PageIntem> getPaginas() {
        return paginas;
    }

    public boolean isFirst(){
        return page.isFirst();
    }
    public boolean isLast(){
        return page.isLast();
    }

    public boolean isHasNext(){
        return page.hasNext();
    }

    public boolean isHasPrevious(){
        return page.hasPrevious();
    }
}
