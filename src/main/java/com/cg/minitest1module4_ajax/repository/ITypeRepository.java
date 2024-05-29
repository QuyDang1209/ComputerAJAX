package com.cg.minitest1module4_ajax.repository;

import com.cg.minitest1module4_ajax.model.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.Repository;

public interface ITypeRepository extends JpaRepository<Type, Long> {
}
