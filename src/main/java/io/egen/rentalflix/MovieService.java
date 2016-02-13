package io.egen.rentalflix;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;


/**
 * Service implementing IFlix interface
 * You can use any Java collection type to store movies
 */
public class MovieService implements IFlix {
	
	List<Movie> movies = new ArrayList<Movie>();
	
	@Override
	public List<Movie> findAll()
	{
		return movies;
	}
	
	@Override
	public List<Movie> findByName(String name)
	{
		List<Movie> movieList=new ArrayList<Movie>();
		for(Movie m: movies)
		{
			if(m.getTitle().contains(name))
			{
				movieList.add(m);
			}
		}
		return movieList;
	}
	
	@Override
	public Movie create(Movie movie)
	{
		movies.add(movie);
		return movie;
	}
	
	@Override
	public Movie update(Movie movie)
	{
		boolean moviePresent = movies.contains(movie);
		if(!moviePresent)
		{
			throw new IllegalArgumentException("Update Error: movie with this id is not found");
		}
		movies.set(movie.getId(), movie);
		return movie;
	}
	

	@Override
	public Movie delete(int id)
	{
		Movie m = movies.get(id);
		if(m == null)
		{
			throw new IllegalArgumentException("Delete Error: movie with this id is not found");
		}
		movies.remove(m);
		return m;
	}
	
	@Override
	public boolean rentMovie(int movieId, String user) 
	{
	   	Movie m = movies.get(movieId);
		if(m.isRented())
		{
			throw new IllegalArgumentException("Movie already rented");
		}
		m.setRent(true);
		return true;
	}
	

}
