package com.example.demo.service;


import com.example.demo.annotation.CheckPermission;
import com.example.demo.dto.MovieDto;
import com.example.demo.mapper.AutoMapper;
import com.example.demo.model.Movie;
import com.example.demo.repository.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
//@RequiredArgsConstructor
public class MovieService {

	private final MovieRepository movieRepository;

	public MovieService(MovieRepository movieRepository) {
		this.movieRepository = movieRepository;
	}

	@CheckPermission(hasPermission = false)
	public Movie save(MovieDto movieDto) {
		Movie movie = AutoMapper.MAPPER.mapToMovie(movieDto);
		return movieRepository.save(movie);
	}

	@CheckPermission()
	public List<MovieDto> getAllMovies() {
		return movieRepository.findAll().stream().map(AutoMapper.MAPPER::mapToMovieDto)
				.collect(Collectors.toList());
	}
	@CheckPermission()
	public MovieDto getMovieById(Long id) {
		return AutoMapper.MAPPER.mapToMovieDto(movieRepository.findById(id).orElseThrow(() -> new RuntimeException("Movie found for the id "+id)));
	}

	@CheckPermission(hasPermission = false)
	public Movie updateMovie(Movie movie, Long id) {
		Movie existingMovie = movieRepository.findById(id).get();
		return movieRepository.save(existingMovie);
	}

	@CheckPermission(hasPermission = false)
	public void deleteMovie(Long id) {
		Movie existingMovie = movieRepository.findById(id).get();
		movieRepository.delete(existingMovie);
		
	}
}




















