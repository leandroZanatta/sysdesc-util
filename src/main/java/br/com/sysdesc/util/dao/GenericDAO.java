package br.com.sysdesc.util.dao;

import java.util.List;

import com.mysema.query.BooleanBuilder;

public interface GenericDAO<T> {

    public abstract T previows(Long id);

    public abstract T next(Long id);

    public abstract T last();

    public abstract T first();

    public abstract void salvar(T objetoPesquisa);

    public abstract List<T> listar();

    public abstract List<T> salvar(List<T> persist);

    public abstract void remove(T remove);

    public abstract T obterPorId(Long id);

    public abstract T obterPorId(Long id, BooleanBuilder filter);

    public void invalidarObjeto();

}