import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.movies.Movie;
import ru.netology.movies.MovieManager;

public class MovieManagerTest {

    Movie movie1 = new Movie(1, "Bloodshot", 2020, "Action");
    Movie movie2 = new Movie(5, "Onvard", 2020, "Cartoon");
    Movie movie3 = new Movie(9, "Hotel belgrade", 2020, "Comedy");
    Movie movie4 = new Movie(14, "The Gentlemen", 2020, "Action");
    Movie movie5 = new Movie(6, "The Invisible Man", 2020, "Horror");
    Movie movie6 = new Movie(19, "Trolls", 2020, "Cartoon");
    Movie movie7 = new Movie(15, "Number one", 2020, "Comedy");


    @Test
    public void showAllMovies() {
        MovieManager mng = new MovieManager();

        mng.add(movie1);
        mng.add(movie2);
        mng.add(movie3);
        mng.add(movie4);
        mng.add(movie5);
        mng.add(movie6);
        mng.add(movie7);

        Movie[] expected = {movie1, movie2, movie3, movie4, movie5, movie6, movie7};
        Movie[] actual = mng.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void showLastMoviesWithDefaultSize() {
        MovieManager mng = new MovieManager();

        mng.add(movie1);
        mng.add(movie2);
        mng.add(movie3);
        mng.add(movie4);
        mng.add(movie5);

        Movie[] expected = {movie5, movie4, movie3, movie2, movie1};
        Movie[] actual = mng.findLast();
        Assertions.assertArrayEquals(expected, actual);
    }


    @Test
    public void showLastMoviesIfDefaultSizeLessThanFilms() {
        MovieManager mng = new MovieManager();

        mng.add(movie1);
        mng.add(movie2);
        mng.add(movie3);
        mng.add(movie4);
        mng.add(movie5);
        mng.add(movie6);
        mng.add(movie7);

        Movie[] expected = {movie7, movie6, movie5, movie4, movie3};
        Movie[] actual = mng.findLast();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void showLastMoviesIfDefaultSizeMoreThanFilms() {
        MovieManager mng = new MovieManager();

        mng.add(movie1);
        mng.add(movie2);
        mng.add(movie3);

        Movie[] expected = {movie3, movie2, movie1};
        Movie[] actual = mng.findLast();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void showLastMoviesIfNewDefaultSizeLessThanFilms() {
        MovieManager mng = new MovieManager(6);

        mng.add(movie1);
        mng.add(movie2);
        mng.add(movie3);
        mng.add(movie4);
        mng.add(movie5);
        mng.add(movie6);
        mng.add(movie7);

        Movie[] expected = {movie7, movie6, movie5, movie4, movie3, movie2};
        Movie[] actual = mng.findLast();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void showLastMoviesIfNewSizeMoreThanFilms() {
        MovieManager mng = new MovieManager(11);

        mng.add(movie1);
        mng.add(movie2);
        mng.add(movie3);
        mng.add(movie4);
        mng.add(movie5);
        mng.add(movie6);
        mng.add(movie7);

        Movie[] expected = {movie7, movie6, movie5, movie4, movie3, movie2, movie1};
        Movie[] actual = mng.findLast();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldAddNewMovie() {
        MovieManager mng = new MovieManager();

        Movie movie8 = new Movie(31, "Harry Potter", 2011, "Fantastic");

        mng.add(movie8);

        Movie[] expected = {movie8};
        Movie[] actual = mng.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }


    @Test
    public void shouldNotAddAnyMovies() {
        MovieManager mng = new MovieManager();

        Movie[] expected = {};
        Movie[] actual = mng.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }
}