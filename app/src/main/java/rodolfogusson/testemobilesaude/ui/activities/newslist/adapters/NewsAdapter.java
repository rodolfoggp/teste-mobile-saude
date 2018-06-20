package rodolfogusson.testemobilesaude.ui.activities.newslist.adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.squareup.picasso.Picasso;

import java.time.format.DateTimeFormatter;
import java.util.List;

import rodolfogusson.testemobilesaude.R;
import rodolfogusson.testemobilesaude.model.News;
import rodolfogusson.testemobilesaude.ui.activities.newsdetails.NewsDetailsActivity;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsViewHolder>{

    private List<News> newsList;

    public NewsAdapter(List list){
        newsList = list;
    }

    @Override
    public NewsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new NewsViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.news_list_row, parent, false));
    }

    @Override
    public void onBindViewHolder(NewsViewHolder holder, int position) {
        Context context = holder.itemView.getContext();
        News news = newsList.get(position);
        Picasso.with(context).load(news.getPictureURL()).into(holder.imageView);
        holder.title.setText(news.getTitle());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(context.getString(R.string.written_date));
        holder.date.setText(news.getDate().format(formatter));
        holder.itemView.setOnClickListener(v -> showDetailsActivity(holder.itemView.getContext(), position));
    }

    private void showDetailsActivity(Context context, int position){
        Intent intent = new Intent(context, NewsDetailsActivity.class);
        intent.putExtra("News", newsList.get(position));
        context.startActivity(intent);
        ((Activity)context).overridePendingTransition(R.anim.slide_in_front_left, R.anim.slide_out_back_left);
    }

    @Override
    public int getItemCount() {
        return newsList != null ? newsList.size() : 0;
    }

    class NewsViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView title;
        TextView date;

        NewsViewHolder(View itemView){
            super(itemView);
            imageView = itemView.findViewById(R.id.imageview);
            title = itemView.findViewById(R.id.title_textview);
            date = itemView.findViewById(R.id.date_textview);
        }
    }
}
