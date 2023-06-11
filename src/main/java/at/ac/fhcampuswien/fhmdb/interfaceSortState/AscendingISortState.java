package at.ac.fhcampuswien.fhmdb.interfaceSortState;

import at.ac.fhcampuswien.fhmdb.controllers.MovieListController;
import at.ac.fhcampuswien.fhmdb.models.Movie;
import at.ac.fhcampuswien.fhmdb.models.SortState;


import java.util.Comparator;

public class AscendingISortState implements ISortState {
    @Override
    public void sortMovies(MovieListController movieListController){
        movieListController.getObservableMovies().sort(Comparator.comparing(Movie::getTitle));
        movieListController.setSortedState(SortState.ASCENDING);

    }

}
