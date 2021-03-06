package models;

/**
 * @author Judy
 * @param A Genre enum, a data type consisting of a set of named values called elements
 * 
 * @return a hash map for individual genre elements
 */
import java.util.HashMap;
import java.util.Map;

public  enum Genre {
	UNKNOWN(0),
	ACTION(1),
	ADVENTURE(2),
	ANIMATION(3),
	CHILDRENS(4),
	COMEDY(5),
	CRIME(6),
	DOCUMENTARY(7),
	DRAMA(8),
	FANTASY(9),
	FILMNOIR(10),
	HORROR(11),
	MUSICAL(12),
	MYSTERY(13),
	ROMANCE(14),
	SCIFI(15),
	THRILLER(16),
	WAR(17),
	WESTERN(18);

	public static  Map<Integer, Genre> genreMap = genreMap();
	public int id;

	Genre(int id) {
		this.id = id;

	}


	/** Creating a HashSet of Type Genre. 
	 * 
	 * @return A Hashset of Genre
	 */


	private static Map<Integer, Genre> genreMap() {
		genreMap = new HashMap<>();
		for(Genre genre : Genre.values()) {

			genreMap.put(genre.getId(), genre);
		}
		return genreMap;
	}

	public static Map<Integer, Genre> getGenreMap() {
		return genreMap;
	}


	public static void setGenreMap(Map<Integer, Genre> genreMap) {
		Genre.genreMap = genreMap;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}



	public static Genre fromId(int genreId) {

		return genreMap.get(genreId);
	}

}