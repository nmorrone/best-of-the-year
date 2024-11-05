package is.lessons.spring.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.org.lessons.spring.model.Movie;
import it.org.lessons.spring.model.Song;

@Controller
@RequestMapping("/")
public class BestOfTheYearController {

	@GetMapping("/")
	public String saluto(@RequestParam(name = "nome", required = false) String nome, Model model) {
		model.addAttribute("name", "Nicola");
		return "welcome";
	}

	private List<Movie> getBestMovies() {

		List<Movie> bestMovies = new ArrayList<>();

		bestMovies.add(new Movie(5, "Signore degli Anelli - Il Ritorno del Re"));
		bestMovies.add(new Movie(1, "The Joker"));
		bestMovies.add(new Movie(34, "Pirati dei Caraibi - La Maledizione della Prima Luna"));
		bestMovies.add(new Movie(58, "L'Evocazione - il Caso Enfield"));
		bestMovies.add(new Movie(27, "Hereditary - Le Radici del Male"));
		bestMovies.add(new Movie(92, "Lo Hobbit - La Desolazione di Smaug"));
		return bestMovies;

	}

	@GetMapping("/movies")
	public String listMovies(Model model) {
		List<Movie> bestMovies = getBestMovies();
		model.addAttribute("movies", bestMovies);
		return "movies";
	}

	private List<Song> getBestSongs() {
		List<Song> bestSongs = new ArrayList<>();
		bestSongs.add(new Song(32, "Passenger - Let Her Go"));
		bestSongs.add(new Song(26, "Black Sabbath - Paranoid"));
		bestSongs.add(new Song(98, "Led Zeppelin - Immigrant Song"));
		bestSongs.add(new Song(4, "Arctic Monkeys - Do I Wanna Know?"));
		bestSongs.add(new Song(76, "Pink Floyd - Money"));
		bestSongs.add(new Song(11, "Dire Straits  - Sultans of Swing"));
		bestSongs.add(new Song(25, "REM - Losing my Religion"));
		return bestSongs;
	}

	@GetMapping("/songs")
	public String listSongs(Model model) {
		List<Song> songsList = getBestSongs();
		model.addAttribute("songs", songsList);
		return "songs";
	}

	// Mapping ricerca film nella lista
	@GetMapping("/movies/{id}")
	public String idMovie(@PathVariable String id, Model model) {
		List<Movie> bestMovies = getBestMovies();
		int a = Integer.parseInt(id);
		if (a != 0) {
			List<Movie> filmSelezionati = new ArrayList<>();
			for (Movie m : bestMovies) {

				if (m.getId() == a) {

					filmSelezionati.add(m);
				}
			}

			bestMovies = filmSelezionati;

		}

		model.addAttribute("movies", bestMovies);
		model.addAttribute("filtro", id);

		return "movies";
	}

	// Mapping ricerca film nella lista
	@GetMapping("/songs/{id}")
	public String idSong(@PathVariable String id, Model model) {
		List<Song> bestSongs = getBestSongs();
		int a = Integer.parseInt(id);
		if (a != 0) {
			List<Song> canzoneSelezionata = new ArrayList<>();
			for (Song s : bestSongs) {

				if (s.getId() == a) {

					canzoneSelezionata.add(s);
				}
			}

			bestSongs = canzoneSelezionata;

		}

		model.addAttribute("songs", bestSongs);

		return "songs";
	}

}
