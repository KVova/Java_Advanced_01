package volodymyr;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestWatcher;

public class CinemaTest {
	
	@Rule
	public TestWatcher testWatcher = new TestWatcher() {
		
		protected void failed(Throwable e, org.junit.runner.Description description) {
			System.out.println("Test FAILED -> "+ description.getMethodName());
		};
		protected void succeeded(org.junit.runner.Description description) {
			System.out.println("Test SUCCEEDED -> "+description.getMethodName());
		};			
	};
	
	@Before
	public void beforeTest() throws Exception {
		cinemaTest = new Cinema(new Time(00, 07), new Time(00, 23));
//
	//	cinemaTest2 = new Cinema(new Time(00, 03), new Time(34, 44));
//		
		movie = new Movie("film", new Time(00, 01));
		movie2 = new Movie("film2", new Time(20, 02));		
	}
	
	@After
	public void afterTest() {
		cinemaTest = null;
//		
		cinemaTest2 = null;
//
		movie = null;
		movie2 = null;
	}
	
	@Test
	public void addCinemaTest() throws Exception {
		cinemaTest.addMovie(movie);
		//cinemaTest.addMovie(movie2);
		
		ArrayList<Movie> real = cinemaTest.getMoviesLibrary();
		ArrayList<Movie> expected = new ArrayList<>();
		expected.add(movie);
	//	expected.add(movie2);

		Assert.assertEquals(expected, real);
	}
	
	@Test (expected = Exception.class)
	public void addCinemaTest2() throws Exception {
	//	cinemaTest2.addMovie(movie);
		cinemaTest2.addMovie(movie2);
		
		ArrayList<Movie> real2 = cinemaTest2.getMoviesLibrary();
		ArrayList<Movie> expected2 = new ArrayList<>();
	//	expected2.add(movie);
		expected2.add(movie2);
		
		Assert.assertEquals(expected2, real2);
	}
	
	@Test
	public void removeCinemaTest() {
		cinemaTest.addMovie(movie);
		cinemaTest.addMovie(movie2);
		
		cinemaTest.removeMovie(movie);
		
		ArrayList<Movie> real = cinemaTest.getMoviesLibrary();
		ArrayList<Movie> expected = new ArrayList<>();	
		expected.add(movie2);
		
		Assert.assertEquals(expected, real);
		
	}
	
	@Test (expected = Exception.class)
	public void removeCinemaTest2() {
		cinemaTest2.addMovie(movie2);
		cinemaTest2.removeMovie(movie2);
		
		ArrayList<Movie> real = cinemaTest2.getMoviesLibrary();
		ArrayList<Movie> expected = new ArrayList<>();	
		expected.add(movie2);
		
		Assert.assertEquals(expected, real);
	}	
	
	private Cinema cinemaTest;
	private Cinema cinemaTest2;
	
	private Movie movie;
	private Movie movie2;
}
