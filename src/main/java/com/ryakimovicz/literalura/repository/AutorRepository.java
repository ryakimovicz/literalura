package com.ryakimovicz.literalura.repository;

import com.ryakimovicz.literalura.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutorRepository extends JpaRepository<Autor, Long> {
}