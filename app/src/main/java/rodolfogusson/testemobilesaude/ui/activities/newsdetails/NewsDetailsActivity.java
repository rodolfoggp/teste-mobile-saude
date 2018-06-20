package rodolfogusson.testemobilesaude.ui.activities.newsdetails;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import rodolfogusson.testemobilesaude.R;
import rodolfogusson.testemobilesaude.communication.NewsAPI;
import rodolfogusson.testemobilesaude.communication.RestAdapter;
import rodolfogusson.testemobilesaude.model.DetailedNews;

public class NewsDetailsActivity extends AppCompatActivity {

    private int id;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_details);
        setupToolbar();
        getNewsId();
        getData();
    }

    private void setupToolbar(){
        Toolbar toolbar = findViewById(R.id.toolbar);
        Drawable backArrow = getDrawable(android.support.v7.appcompat.R.drawable.abc_ic_ab_back_material);
        toolbar.setNavigationIcon(backArrow);
        toolbar.setNavigationOnClickListener(v -> onBackPressed());
        TextView title = findViewById(R.id.toolbar_title);
        title.setText(getTitle());
    }

    private void getNewsId(){
        Intent intent = getIntent();
        id = intent.getIntExtra("newsId", 0);
    }

    private void getData(){
        NewsAPI api = RestAdapter.getInstance();
        Call<DetailedNews> call = api.getNewsById(id);
        call.enqueue(new Callback<DetailedNews>() {
            @Override
            public void onResponse(Call<DetailedNews> call, Response<DetailedNews> response) {
                if(response.code() == 200){
                    DetailedNews news = response.body();
                    System.out.println(news.toString());
                } else {
                    //TODO: failure message
                }
            }

            @Override
            public void onFailure(Call<DetailedNews> call, Throwable t) {
                //TODO: failure message
                System.out.println(t.getCause().getLocalizedMessage());
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.slide_in_back_right, R.anim.slide_out_front_right);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
        }
        return true;
    }
}
