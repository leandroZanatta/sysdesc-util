package br.com.sysdesc.util.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;

import com.mysema.query.BooleanBuilder;
import com.mysema.query.jpa.JPASubQuery;
import com.mysema.query.jpa.impl.JPAQuery;
import com.mysema.query.jpa.sql.JPASQLQuery;
import com.mysema.query.sql.SQLTemplates;
import com.mysema.query.types.EntityPath;
import com.mysema.query.types.path.NumberPath;

import br.com.sysdesc.util.classes.LongUtil;
import br.com.sysdesc.util.exception.SysDescException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class AbstractGenericDAO<T> implements GenericDAO<T>, Serializable {

	private static final long serialVersionUID = 1L;
	private final EntityManager entityManager = Conexao.getEntityManager();
	private final SQLTemplates sqlTemplates = Conexao.getSqlTemplates();
	private EntityPath<T> entityPath;
	private NumberPath<Long> campoId;

	public AbstractGenericDAO(EntityPath<T> entityPath, NumberPath<Long> idLogin) {
		this.entityPath = entityPath;
		this.campoId = idLogin;
	}

	@Override
	public void salvar(T persist) {
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(persist);
			entityManager.flush();
			entityManager.getTransaction().commit();
		} catch (Exception e) {

			log.error("Erro ao salvar objeto {}", persist, e);

			entityManager.getTransaction().rollback();

			throw new SysDescException(e.getMessage());
		}
	}

	@Override
	public List<T> salvar(List<T> persist) {
		entityManager.getTransaction().begin();
		for (T t : persist) {
			entityManager.persist(t);
		}
		entityManager.flush();
		entityManager.getTransaction().commit();
		return persist;
	}

	@Override
	public void remove(T remove) {
		entityManager.getTransaction().begin();
		entityManager.remove(remove);
		entityManager.flush();
		entityManager.getTransaction().commit();
	}

	@Override
	public T obterPorId(Long id) {
		return from().where(campoId.eq(id)).singleResult(entityPath);
	}

	@Override
	public List<T> listar() {
		return query().from(entityPath).list(entityPath);
	}

	@Override
	public T obterPorId(Long id, BooleanBuilder filter) {

		filter.and(campoId.eq(id));

		return from().where(filter).singleResult(entityPath);
	}

	@Override
	public T next(Long id) {

		if (LongUtil.isNullOrZero(id)) {
			return last();
		}

		T objeto = from().where(campoId.gt(id)).orderBy(campoId.asc()).limit(1L).singleResult(entityPath);

		if (objeto == null) {
			return first();
		}

		return objeto;

	}

	@Override
	public T previows(Long id) {

		if (LongUtil.isNullOrZero(id)) {
			return last();
		}

		T objeto = from().where(campoId.lt(id)).orderBy(campoId.desc()).limit(1L).singleResult(entityPath);

		if (objeto == null) {
			return last();
		}

		return objeto;

	}

	@Override
	public T last() {
		return from().orderBy(campoId.desc()).singleResult(entityPath);
	}

	@Override
	public T first() {
		return from().orderBy(campoId.asc()).singleResult(entityPath);
	}

	protected JPASQLQuery sqlQuery() {

		return new JPASQLQuery(entityManager, sqlTemplates);
	}

	protected JPASQLQuery sqlFrom() {
		return new JPASQLQuery(entityManager, sqlTemplates).from(entityPath);
	}

	protected JPASubQuery subQuery() {
		return new JPASubQuery();
	}

	protected JPAQuery query() {
		return new JPAQuery(entityManager);
	}

	protected JPAQuery from() {
		return new JPAQuery(entityManager).from(entityPath);
	}

	protected EntityPath<T> getEntityPath() {
		return entityPath;
	}

	protected void setEntityPath(EntityPath<T> entityPath) {
		this.entityPath = entityPath;
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public NumberPath<Long> getCampoId() {
		return campoId;
	}

	public void setCampoId(NumberPath<Long> campoId) {
		this.campoId = campoId;
	}

}