package br.univille.dacs2022.service;

import java.util.List;

import br.univille.dacs2022.dto.ConsultaDTO;

public interface ConsultaService {
    public List<ConsultaDTO> getAll();
    public ConsultaDTO save(ConsultaDTO consulta);
    public ConsultaDTO findById(long id);
    public ConsultaDTO delete(long id);
}
