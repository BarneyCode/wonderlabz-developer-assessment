package com.barney.wonderlabzdeveloperassessmentcore.common;

import java.util.List;
import java.util.Optional;

/**
 * Project Name: wonderlabz-developer-assessment-core
 * Developer   : bkatakwa
 * Date        : 21/4/2021
 * Time        : 21:48
 */
public interface AppService<T> {
    Optional<T> findById(Long id);
    List<T> findAll();
    T save(T t);
}
