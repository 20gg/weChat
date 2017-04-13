package com.team.system.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.team.mybatis.core.annotation.StdWho;

/**
 * @author shengyang.zhou@hand-china.com
 */
public interface IBaseService<T> {

    List<T> select( T condition, int pageNum, int pageSize);

    T insert( @StdWho T record);

    T insertSelective( @StdWho T record);

    T updateByPrimaryKey( @StdWho T record);

    @Transactional(rollbackFor = Exception.class)
    T updateByPrimaryKeySelective( @StdWho T record);

    T selectByPrimaryKey( T record);

    int deleteByPrimaryKey(T record);

    /**
     * DO NOT USE this method when multi-language query
     * @return
     */

    List<T> selectAll();

    List<T> batchUpdate( @StdWho List<T> list);

    int batchDelete(List<T> list);
}
