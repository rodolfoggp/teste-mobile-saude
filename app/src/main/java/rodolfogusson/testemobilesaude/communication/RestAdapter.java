package rodolfogusson.testemobilesaude.communication;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializer;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RestAdapter {

    private RestAdapter() {}

    public static NewsAPI getInstance() {
        Gson gson = new GsonBuilder().registerTypeAdapter(LocalDateTime.class, (JsonDeserializer<LocalDateTime>) (json, type, jsonDeserializationContext) -> {
            String string = json.getAsJsonPrimitive().getAsString();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            return LocalDateTime.parse(string, formatter);
        }).create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(NewsAPI.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        return retrofit.create(NewsAPI.class);
    }

}
