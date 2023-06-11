package at.ac.fhcampuswien.fhmdb.database;

import com.j256.ormlite.dao.Dao;
import javafx.beans.Observable;

import java.util.List;

public class WatchlistRepository {

    Dao<WatchlistMovieEntity, Long> dao;

    //singelton pattern, so gemacht wie es schon in DatabaseManager.java gemacht ist
    private static WatchlistRepository instance;

    public static WatchlistRepository getInstance() throws DataBaseException {
        if (instance == null) {
            instance = new WatchlistRepository();
        }
        return instance;
    }

    public WatchlistRepository() throws DataBaseException {
        try {
            this.dao = DatabaseManager.getInstance().getWatchlistDao();
        } catch (Exception e) {
            throw new DataBaseException(e.getMessage());
        }
    }

    public List<WatchlistMovieEntity> readWatchlist() throws DataBaseException {
        try {
            return dao.queryForAll();
        } catch (Exception e) {
            e.printStackTrace();
            throw new DataBaseException("Error while reading watchlist");
        }
    }
    public void addToWatchlist(WatchlistMovieEntity movie) throws DataBaseException {
        try {
            // only add movie if it does not exist yet
            long count = dao.queryBuilder().where().eq("apiId", movie.getApiId()).countOf();
            if (count == 0) {
                dao.create(movie);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new DataBaseException("Error while adding to watchlist");
        }
    }

    public void removeFromWatchlist(WatchlistMovieEntity movie) throws DataBaseException {
        try {
            dao.delete(movie);
        } catch (Exception e) {
            throw new DataBaseException("Error while removing from watchlist");
        }
    }

    public boolean isOnWatchlist(WatchlistMovieEntity movie) throws DataBaseException {
        try {
            return dao.queryForMatching(movie).size() > 0;
        } catch (Exception e) {
            throw new DataBaseException("Error while checking if movie is on watchlist");
        }
    }
}
