package model;

public class MovieModel {

	private int movieid;
	private String movieName;
	
	public MovieModel(String movieName) {
		this.movieName=movieName;
	}
	/**
	 * @return the movieid
	 */
	public int getMovieid() {
		return movieid;
	}
	/**
	 * @param movieid the movieid to set
	 */
	public void setMovieid(int movieid) {
		this.movieid = movieid;
	}
	/**
	 * @return the movieName
	 */
	public String getMovieName() {
		return movieName;
	}
	/**
	 * @param movieName the movieName to set
	 */
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	
	
	
}
