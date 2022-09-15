package br.univille.dacs2022.service.impl;

import java.util.List;
import java.util.Optional;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.univille.coredacs2022.entity.Consulta;
import br.univille.coredacs2022.repository.ConsultaRepository;
import br.univille.dacs2022.dto.ConsultaDTO;
import br.univille.dacs2022.mapper.ConsultaMapper;
import br.univille.dacs2022.service.ConsultaService;

@Service
public class ConsultaServiceImpl implements ConsultaService{

    @Autowired
    private ConsultaRepository repository;
    private ConsultaMapper mapper = Mappers.getMapper(ConsultaMapper.class);


    @Override
    public List<ConsultaDTO> getAll() {
        return mapper.mapListConsulta(repository.findAll());
    }

    @Override
    public ConsultaDTO save(ConsultaDTO consulta) {
        Consulta consultaEntity = mapper.mapConsultaDTO(consulta);
        consultaEntity = repository.save(consultaEntity);

        return mapper.mapConsulta(consultaEntity);
    }

    @Override
    public ConsultaDTO findById(long id) {
        Optional<Consulta> consultaEntity = repository.findById(id);

        if (consultaEntity.isPresent()) {
            return mapper.mapConsulta(consultaEntity.get());
        }

        return new ConsultaDTO();
    }

    @Override
    public ConsultaDTO delete(long id) {
        Optional<Consulta> consultaEntity = repository.findById(id);

        if (consultaEntity.isPresent()) {
            Consulta consulta = consultaEntity.get(); 
            repository.delete(consulta);;

            return mapper.mapConsulta(consulta);
        }
        return null;      
    }
    
}
