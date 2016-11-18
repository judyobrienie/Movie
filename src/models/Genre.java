package models;

import java.util.Collections;
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

	public static  Map<Integer, String> genreMap = genreMap();
	public int id;
	
	Genre(int id) {
		this.id = id;
		
	}
	
	
	private static Map<Integer, String> genreMap() {
		genreMap = new HashMap<>();
		for(Genre genre : Genre.values()) {
			
			genreMap.put(genre.getId(), genre.name());
		}
		return genreMap;
	}
	
	public static Map<Integer, String> getGenreMap() {
		return genreMap;
	}


	public static void setGenreMap(Map<Integer, String> genreMap) {
		Genre.genreMap = genreMap;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}



	public static String fromId(int genreId) {
		
		return genreMap.get(genreId);
}

}