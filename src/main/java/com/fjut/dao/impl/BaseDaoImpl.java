package com.fjut.dao.impl;

import com.fjut.dao.BaseDao;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

public class BaseDaoImpl<T> extends HibernateDaoSupport implements BaseDao<T> {

    private Class clazz;

    //提供构造方法，在构造方法中传入具体类型的class
    public BaseDaoImpl (){
        Class clazz = this.getClass();

        Type type = clazz.getGenericSuperclass();

        ParameterizedType pType = (ParameterizedType) type;

        Type[] types = pType.getActualTypeArguments();
        this.clazz = (Class) types[0];
    }

    @Override
    public void save(T t) {
        this.getHibernateTemplate().save(t);
    }

    @Override
    public void delete(T t) {
        this.getHibernateTemplate().delete(t);
    }

    @Override
    public void update(T t) {
        this.getHibernateTemplate().update(t);
    }

    @Override
    public T findById(Serializable id) {
        return (T) this.getHibernateTemplate().get(clazz,id);
    }

    @Override
    //查询所有
    public List<T> findAll() {
        return (List<T>) this.getHibernateTemplate().find("from "+clazz.getSimpleName());
    }

    @Override
    //统计个数
    public Integer findCount(DetachedCriteria detachedCriteria) {
        //设置统计个数的条件
        detachedCriteria.setProjection(Projections.rowCount());
        List<Long> list = (List<Long>) this.getHibernateTemplate().findByCriteria(detachedCriteria);
        if(list.size()>0){
            return list.get(0).intValue();
        }
        return null;
    }

    @Override
    //分页查询
    public List<T> findByPage(DetachedCriteria detachedCriteria, Integer begin, Integer pageSize) {
        detachedCriteria.setProjection(null);
        return (List<T>) this.getHibernateTemplate().findByCriteria(detachedCriteria,begin,pageSize);
    }
}
