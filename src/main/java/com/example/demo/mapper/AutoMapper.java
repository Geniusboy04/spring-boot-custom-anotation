package com.example.demo.mapper;


import com.example.demo.dto.MovieDto;
import com.example.demo.model.Movie;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AutoMapper {

    AutoMapper MAPPER = Mappers.getMapper(AutoMapper.class);

    // todo nomi har xil bolgan field lar uchun
    @Mapping(target="id", source="movieDto.id")
    @Mapping(target="name", source="movieDto.name")
    @Mapping(target="genera", source="movieDto.genera")
    @Mapping(target="releaseDate", source="movieDto.releaseDate")
    Movie mapToMovie(MovieDto movieDto);

    MovieDto mapToMovieDto(Movie movie);
}
