package br.com.antoniocdp.challengeforumhub.controller;

import aj.org.objectweb.asm.commons.Remapper;
import br.com.antoniocdp.challengeforumhub.topico.Topico;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public class TopicoRepository {
    public void save(Topico topico) {

    }

    public Remapper findAll(Pageable pageable) {
        return null;
    }

    public void deleteById(Long id) {
    }

    public Object getReferenceById(Long id) {
        return null;
    }

    public Optional<Object> findById(Long id) {
        return Optional.empty();
    }
}
