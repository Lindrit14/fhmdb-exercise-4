package at.ac.fhcampuswien.fhmdb.BuilderAPI;

import at.ac.fhcampuswien.fhmdb.models.Genre;

public class MovieAPIRequestBuilder {

    private StringBuilder urlBuilder;

    public MovieAPIRequestBuilder(String baseURL){
        urlBuilder = new StringBuilder(baseURL);
    }

    public void appendQueryParam(String key, String value){
        if (urlBuilder.indexOf("?")==-1){ //wenn kein ? vorhanden ist
            urlBuilder.append("?"); //fuege ein ? hinzu
        }else {
            urlBuilder.append("&");
        }
        urlBuilder.append(key).append("=").append(value);
    }

//    public MovieAPIRequestBuilder addQueryParam(String key, String value){
//        if(value != null && !value.isEmpty()){
//            appendQueryParam(key,value);
//        }
//        return this;
//    }

    public MovieAPIRequestBuilder query(String query){
        if(query != null && !query.isEmpty()){
            appendQueryParam("query", query);
        }
        return this;
    }

    public MovieAPIRequestBuilder genre(Genre genre){
        if(genre != null){
            appendQueryParam("genre", String.valueOf(genre));
        }
        return this;
    }

    public MovieAPIRequestBuilder releaseYear(String releaseYear){
        if(releaseYear != null && !releaseYear.isEmpty()){
            appendQueryParam("releaseYear", releaseYear);
        }
        return this;
    }

    public MovieAPIRequestBuilder ratingFrom(String ratingFrom){
        if(ratingFrom != null && !ratingFrom.isEmpty()){
            appendQueryParam("ratingFrom", ratingFrom);
        }
        return this;
    }


    public String build(){
        return  urlBuilder.toString();
    }

}
