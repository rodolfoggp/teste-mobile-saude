package rodolfogusson.testemobilesaude.communication;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import rodolfogusson.testemobilesaude.model.DetailedNews;
import rodolfogusson.testemobilesaude.model.NewsListElement;

public interface NewsAPI {
    String BASE_URL = "http://mobilesaude.com.br/";

    @GET("challenge/lista.json")
    Call<List<NewsListElement>> getNewsList();

    @GET("challenge/{id}.json")
    Call<DetailedNews> getNewsById(@Path("id") int id);
}
