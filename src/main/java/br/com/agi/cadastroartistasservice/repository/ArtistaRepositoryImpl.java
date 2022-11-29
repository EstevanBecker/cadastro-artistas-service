package br.com.agi.cadastroartistasservice.repository;

import br.com.agi.cadastroartistasservice.entidade.Artista;
import org.springframework.stereotype.Repository;

@Repository
public class ArtistaRepositoryImpl implements ArtistaRepository {
    @Override
    public Artista cadastrar(Artista artista) {
        throw new RuntimeException("Não implementado");
    }

}
