package io.egen.rentalflix;
import org.junit.Test;
import junit.framework.Assert;

/**
 * JUnit test cases for MovieService
 */
public class MovieServiceTest 
{
	@Test
	public void testFindAll()
	{
		Movie m1= new Movie(1,"spectre",2015,"English");
		Movie m2= new Movie(2,"martian",2015,"English");
		Movie m3= new Movie(3,"madmax",2015,"English");
		Movie m4= new Movie(4,"starwars",2015,"English");
		Movie m5= new Movie(5,"revenant",2015,"English");
	
		MovieService ms = new MovieService();
		ms.create(m1);
		ms.create(m2);
		ms.create(m3);
		ms.create(m4);
		ms.create(m5);
		int actual = ms.findAll().size();
		Assert.assertEquals(5,actual);

	}
	@Test
	public void testFindByName()
	{
		Movie m1 = new Movie(1,"spectre",2015,"English");
		
		MovieService ms=new MovieService();
		ms.create(m1);
		
		boolean actual = ms.findByName("spec").contains(m1);
		Assert.assertEquals(true, actual);
	}
	@Test
	public void testCreate()
	{
		Movie m3 = new Movie(3,"madmax",2015,"English");
		MovieService ms = new MovieService();
		String actual = ms.create(m3).getTitle();
		Assert.assertEquals("madmax", actual);
	}
	@Test
	public void testUpdate()
	{
		Movie m4 = new Movie(4,"starwars",2015,"English");
		MovieService ms = new MovieService();
		ms.create(m4);
		m4.setTitle("startrek");
		String actual = ms.update(m4).getTitle();
		Assert.assertEquals("startrek", actual);
	}
	@Test
	public void testDelete()
	{
		Movie m2 = new Movie(2,"martian",2015,"English");
		Movie m5 = new Movie(5,"revenant",2015,"English");
		MovieService ms = new MovieService();
		ms.create(m2);
		ms.create(m5);
		int actual = ms.delete(5).getId();
		Assert.assertEquals(5, actual);
		
	}
	@Test
	public void testRentMovie1()
	{
		Movie m1 = new Movie(1,"spectre",2015,"English");
		Movie m4 = new Movie(4,"starwars",2015,"English");
		MovieService ms = new MovieService();
		ms.create(m1);
		ms.create(m4);
		boolean actual = ms.rentMovie(1, "Shubham");
		Assert.assertEquals(true, actual);
	}
	@Test(expected = IllegalArgumentException.class)
	public void testRentMovie2()
	{
		Movie m1 = new Movie(1,"spectre",2015,"English");
		Movie m4 = new Movie(4,"starwars",2015,"English");
		MovieService ms = new MovieService();
		ms.create(m1);
		ms.create(m4);
		boolean actual = ms.rentMovie(1, "Shubham");
		Assert.assertEquals(true, actual);
	}
	
	
	

}
