package br.com.crcarvalho.lembrete.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.crcarvalho.lembrete.entity.Lembrete;

public interface LembreteRepository extends JpaRepository<Lembrete, Long> {

}
