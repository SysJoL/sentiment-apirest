package com.sentiment.demo.mapper;

import com.sentiment.demo.dto.ComentarioResponseDTO;
import com.sentiment.demo.entity.Comentario;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring") // "spring" permite inyectarlo con @Autowired
public interface ComentarioMapper {

    ComentarioMapper INSTANCE = Mappers.getMapper(ComentarioMapper.class);

    // MapStruct entiende automáticamente que si los nombres de los campos
    // son iguales, debe mapearlos solos.
    ComentarioResponseDTO toDTO(Comentario comentario);
}

