package rodolfogusson.testemobilesaude.ui.activities.newslist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import rodolfogusson.testemobilesaude.R;
import rodolfogusson.testemobilesaude.model.News;
import rodolfogusson.testemobilesaude.ui.activities.newslist.adapters.NewsAdapter;

public class NewsListActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private NewsAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_list);
        setupRecyclerView();
    }

    private void setupRecyclerView(){
        recyclerView = findViewById(R.id.recyclerview);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);
        //set adapter in api call
        //TODO: Remove these:
        List<News> list = new ArrayList<>();
        list.add(new News());
        adapter = new NewsAdapter(list);
        recyclerView.setAdapter(adapter);
    }
}
