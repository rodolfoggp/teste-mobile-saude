package rodolfogusson.testemobilesaude.communication;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import rodolfogusson.testemobilesaude.model.DetailedNews;
import rodolfogusson.testemobilesaude.model.NewsListElement;

/**
 * Interface that determines methods to consume the REST Api.
 */
public interface NewsAPI {
    String BASE_URL = "http://mobilesaude.com.br/";

    /**
     * Method to get a list of {@link NewsListElement}.
     * @return The call with said list.
     */
    @GET("challenge/lista.json")
    Call<List<NewsListElement>> getNewsList();

    /**
     * Method to get a specific {@link DetailedNews}, using its {@code id}.
     * @param id Used to fetch a specific object from the api.
     * @return The call with said {@link DetailedNews}.
     */
    @GET("challenge/{id}.json")
    Call<DetailedNews> getNewsById(@Path("id") int id);
}
