package com.example.demo.controller;


import com.example.demo.dto.MovieDto;
import com.example.demo.model.Movie;
import com.example.demo.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movie")
public class MovieController {

	@Autowired
	private final MovieService movieService;

	public MovieController(MovieService movieService) {
		this.movieService = movieService;
	}

	@PostMapping("/create")
	@ResponseStatus(HttpStatus.CREATED)
	public Movie create(@RequestBody MovieDto movie) {
		return movieService.save(movie);
	}
	
	@GetMapping("/all")
	@ResponseStatus(HttpStatus.OK)
	public List<MovieDto> read() {
		return movieService.getAllMovies();
	}
	
	@GetMapping("/read/{id}")
	@ResponseStatus(HttpStatus.OK)
	public MovieDto read(@PathVariable Long id) {
		return movieService.getMovieById(id);
	}
	
	@DeleteMapping("/delete/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		movieService.deleteMovie(id);
	}
	
	@ResponseStatus(HttpStatus.OK)
	@PutMapping("/update/{id}")
	public Movie update(@PathVariable Long id, @RequestBody Movie movie) {
		return movieService.updateMovie(movie, id);
	}
}
























