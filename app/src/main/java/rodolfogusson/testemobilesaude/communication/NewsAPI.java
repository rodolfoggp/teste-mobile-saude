package rodolfogusson.testemobilesaude.communication;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import rodolfogusson.testemobilesaude.model.News;

public interface NewsAPI {
    String BASE_URL = "http://mobilesaude.com.br/";

    @GET("challenge/lista.json")
    Call<List<News>> getNews();
}
