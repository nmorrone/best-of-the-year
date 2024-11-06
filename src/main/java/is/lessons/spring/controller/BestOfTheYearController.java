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

		bestMovies.add(new Movie(5, "Signore degli Anelli - Il Ritorno del Re", "Peter Jackson", 201));
		bestMovies.add(new Movie(1, "The Joker", "Todd Phillips", 122));
		bestMovies.add(new Movie(34, "Pirati dei Caraibi - La Maledizione della Prima Luna", "Gore Verbinski", 143));
		bestMovies.add(new Movie(58, "L'Evocazione - il Caso Enfield", "James Wan", 134));
		bestMovies.add(new Movie(27, "Hereditary - Le Radici del Male", "Ari Aster", 127));
		bestMovies.add(new Movie(92, "Lo Hobbit - La Desolazione di Smaug", "Peter Jackson", 161));
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
		bestSongs.add(new Song(32, "Passenger - Let Her Go", "Passenger", "All the Little Lights"));
		bestSongs.add(new Song(26, "Black Sabbath - Paranoid", "Black Sabbat", "Paranoid"));
		bestSongs.add(new Song(98, "Led Zeppelin - Immigrant Song", "Led Zeppelin", "Led Zeppelin III"));
		bestSongs.add(new Song(4, "Arctic Monkeys - Do I Wanna Know?", "Arctic Monkeys", "AM"));
		bestSongs.add(new Song(76, "Pink Floyd - Money", "Pink Floyd", "The Dark Side of the Moon"));
		bestSongs.add(new Song(11, "Dire Straits  - Sultans of Swing", "Dire Straits", "Dire Straits"));
		bestSongs.add(new Song(25, "REM - Losing my Religion", "REM", "Out of Time"));
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
	
	// Mapping pagina dettaglio Film
		@GetMapping("/movies/info/{id}")
		public String infoMovie(@PathVariable String id, Model model) {
			
			List<Movie> bestMovies = getBestMovies();
			Movie film = new Movie();
			int a = Integer.parseInt(id);
	
			if (a != 0) {
				
				for (Movie m : bestMovies) {
					if (m.getId() == a) {
						film = m;
					}
				}

			}

			model.addAttribute("movie", film);

			return "info-movie";
		}

		// Mapping pagina dettaglio Film
		@GetMapping("/songs/info/{id}")
		public String infoSong(@PathVariable String id, Model model) {
			
			List<Song> bestSongs = getBestSongs();
			Song canzone = new Song();
			int a = Integer.parseInt(id);

			if (a != 0) {
				
				for (Song s : bestSongs) {
					if (s.getId() == a) {
						canzone = s;
					}
				}

			}

			model.addAttribute("song", canzone);

			return "info-song";
		}

}
