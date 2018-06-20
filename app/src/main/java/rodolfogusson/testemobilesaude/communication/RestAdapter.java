package rodolfogusson.testemobilesaude.communication;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializer;

import org.joda.time.LocalDateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Adapter class that initializes {@link Retrofit} with the wanted configurations.
 */
public class RestAdapter {

    private RestAdapter() {}

    /**
     * Method used to get a configured instance of the http client, to make the calls
     * defined in {@link NewsAPI}. It creates a {@link Gson} object, registering a type adapter
     * to deserialize {@link LocalDateTime} objects correctly and initializes a {@link Retrofit}
     * object with it, using a defined {@value NewsAPI#BASE_URL}.
     * @return A {@link Retrofit} object configured to make said calls.
     */
    public static NewsAPI getInstance() {
        Gson gson = new GsonBuilder().registerTypeAdapter(LocalDateTime.class, (JsonDeserializer<LocalDateTime>) (json, type, jsonDeserializationContext) -> {
            String string = json.getAsJsonPrimitive().getAsString();
            DateTimeFormatter dtf = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss");
            return dtf.parseLocalDateTime(string);
        }).create();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(NewsAPI.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        return retrofit.create(NewsAPI.class);
    }

}
