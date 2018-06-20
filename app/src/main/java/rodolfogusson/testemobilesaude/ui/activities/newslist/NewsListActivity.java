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
import rodolfogusson.testemobilesaude.model.NewsListElement;
import rodolfogusson.testemobilesaude.ui.activities.newslist.adapters.NewsListAdapter;
import rodolfogusson.testemobilesaude.utils.UIUtil;

/**
 * Activity that shows a list of news, fetched using {@link NewsAPI#getNewsList()}.
 */
public class NewsListActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private NewsListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_list);
        setupToolbar();
        setupRecyclerView();
        getData();
    }

    /**
     * Sets the activity's title on the custom toolbar.
     */
    private void setupToolbar(){
        TextView toolbarTitle = findViewById(R.id.toolbar_title);
        toolbarTitle.setText(getTitle());
    }

    /**
     * Initial setup for recyclerView.
     */
    private void setupRecyclerView(){
        recyclerView = findViewById(R.id.recyclerview);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);
    }

    /**
     * Gets a list of {@link NewsListElement} from the api using {@link NewsAPI#getNewsList()},
     * creates and sets a new {@link NewsListAdapter} for the recyclerView, passing the recently
     * fetched list.
     */
    private void getData(){
        NewsAPI api = RestAdapter.getInstance();
        Call<List<NewsListElement>> call = api.getNewsList();
        call.enqueue(new Callback<List<NewsListElement>>() {
            @Override
            public void onResponse(Call<List<NewsListElement>> call, Response<List<NewsListElement>> response) {
                if(response.code() == 200){
                    List<NewsListElement> newsList = response.body();
                    adapter = new NewsListAdapter(newsList);
                    recyclerView.setAdapter(adapter);
                } else {
                    UIUtil.showError(NewsListActivity.this);
                }
            }

            @Override
            public void onFailure(Call<List<NewsListElement>> call, Throwable t) {
                UIUtil.showError(NewsListActivity.this);
            }
        });
    }
}
