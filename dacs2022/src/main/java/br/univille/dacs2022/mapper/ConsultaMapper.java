package br.univille.dacs2022.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import br.univille.coredacs2022.entity.Consulta;
import br.univille.dacs2022.dto.ConsultaDTO;

@Mapper
public interface ConsultaMapper {
    List<ConsultaDTO> mapListConsulta(List<Consulta> consulta);
    List<Consulta> mapListConsultaDTO(List<ConsultaDTO> consulta);
    ConsultaDTO mapConsulta(Consulta consulta);
    Consulta mapConsultaDTO(ConsultaDTO consulta);

}
