package rodolfogusson.testemobilesaude.ui.activities.newsdetails;

import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

import rodolfogusson.testemobilesaude.R;

public class NewsDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_details);
        setupToolbar();
    }

    private void setupToolbar(){
        Toolbar toolbar = findViewById(R.id.toolbar);
        Drawable backArrow = getDrawable(android.support.v7.appcompat.R.drawable.abc_ic_ab_back_material);
        toolbar.setNavigationIcon(backArrow);
        toolbar.setNavigationOnClickListener(v -> onBackPressed());
        TextView title = findViewById(R.id.toolbar_title);
        title.setText(getTitle());
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
