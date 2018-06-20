package rodolfogusson.testemobilesaude.ui.activities.newslist;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import rodolfogusson.testemobilesaude.R;
import rodolfogusson.testemobilesaude.communication.NewsAPI;
import rodolfogusson.testemobilesaude.communication.RestAdapter;
import rodolfogusson.testemobilesaude.model.News;
import rodolfogusson.testemobilesaude.ui.activities.newslist.adapters.NewsAdapter;

public class NewsListActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private NewsAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_list);
        setupToolbar();
        setupRecyclerView();
        getData();
    }

    private void setupToolbar(){
        TextView title = findViewById(R.id.toolbar_title);
        title.setText(getTitle());
    }

    private void setupRecyclerView(){
        recyclerView = findViewById(R.id.recyclerview);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);
    }

    private void getData(){
        NewsAPI api = RestAdapter.getInstance();
        Call<List<News>> call = api.getNews();
        call.enqueue(new Callback<List<News>>() {
            @Override
            public void onResponse(Call<List<News>> call, Response<List<News>> response) {
                if(response.code() == 200){
                    List<News> newsList = response.body();
                    adapter = new NewsAdapter(newsList);
                    recyclerView.setAdapter(adapter);
                } else {
                    //TODO: failure message
                }
            }

            @Override
            public void onFailure(Call<List<News>> call, Throwable t) {
                //TODO: failure message
                System.out.println(t.getCause().getLocalizedMessage());
            }
        });
    }
}
