package rodolfogusson.testemobilesaude.ui.activities.newsdetails;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.MenuItem;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.time.format.DateTimeFormatter;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import rodolfogusson.testemobilesaude.R;
import rodolfogusson.testemobilesaude.communication.NewsAPI;
import rodolfogusson.testemobilesaude.communication.RestAdapter;
import rodolfogusson.testemobilesaude.model.DetailedNews;


/**
 * Activity that shows a more detailed news object,fetched using {@link NewsAPI#getNewsById(int)}.
 */
public class NewsDetailsActivity extends AppCompatActivity {

    private int id;
    private ImageView imageView;
    private TextView title;
    private TextView date;
    private WebView content;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_details);
        setupFields();
        setupToolbar();
        getNewsId();
        getData();
    }

    /**
     * Gets the reference from the layout file for all the views needed in this activity.
     */
    private void setupFields(){
        imageView = findViewById(R.id.details_imageview);
        title = findViewById(R.id.details_title);
        date = findViewById(R.id.details_date);
        content = findViewById(R.id.details_content);
    }

    /**
     * Sets the activity title and back icon on the custom toolbar.
     */
    private void setupToolbar(){
        Toolbar toolbar = findViewById(R.id.toolbar);
        Drawable backArrow = getDrawable(android.support.v7.appcompat.R.drawable.abc_ic_ab_back_material);
        toolbar.setNavigationIcon(backArrow);
        toolbar.setNavigationOnClickListener(v -> onBackPressed());
        TextView toolbarTitle = findViewById(R.id.toolbar_title);
        toolbarTitle.setText(getTitle());
    }

    /**
     * Receives the id from the corresponding news card clicked on
     * {@link rodolfogusson.testemobilesaude.ui.activities.newslist.NewsListActivity}, passed inside
     * {@link rodolfogusson.testemobilesaude.ui.activities.newslist.adapters.NewsListAdapter#showDetailsActivity(Context, int)}
     */
    private void getNewsId(){
        Intent intent = getIntent();
        id = intent.getIntExtra("newsId", 0);
    }

    /**
     * Fetches a {@link DetailedNews} object using {@link NewsAPI#getNewsById(int)} and shows it
     * in the UI.
     */
    private void getData(){
        NewsAPI api = RestAdapter.getInstance();
        Call<DetailedNews> call = api.getNewsById(id);
        call.enqueue(new Callback<DetailedNews>() {
            @Override
            public void onResponse(Call<DetailedNews> call, Response<DetailedNews> response) {
                if(response.code() == 200){
                    DetailedNews news = response.body();
                    if(news != null){
                        Picasso.with(NewsDetailsActivity.this)
                                .load(news.getPictureURL())
                                .into(imageView);
                        title.setText(news.getTitle());
                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(
                                getString(R.string.details_date));
                        date.setText(news.getDate().format(formatter));
                        //content.setText(Html.fromHtml(news.getContent(), Html.FROM_HTML_MODE_LEGACY));
                        content.loadData(news.getContent(), "text/html; charset=utf-8", "UTF-8");
                    }
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

    /**
     * Overrides the default transition animations when changing activities.
     */
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
