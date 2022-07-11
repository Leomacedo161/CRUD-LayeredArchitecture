package br.univille.dacs2022.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import br.univille.dacs2022.dto.CidadeDTO;
import br.univille.dacs2022.entity.Cidade;

@Mapper(componentModel = "spring")
public interface CidadeMapper {
    List<CidadeDTO> mapListCidade(List<Cidade> Cidade);
    List<Cidade> mapListCidadeDTO(List<CidadeDTO> Cidade);

    CidadeDTO mapCidade(Cidade Cidade);
    Cidade mapCidadeDTO(CidadeDTO Cidade);

}
