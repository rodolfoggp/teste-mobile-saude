package rodolfogusson.testemobilesaude.ui.activities.newslist.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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
        News news = newsList.get(position);
        //bind whatever needed here
        holder.itemView.setOnClickListener(v -> showDetailsActivity(holder.itemView.getContext(), position));
    }

    private void showDetailsActivity(Context context, int position){
        Intent intent = new Intent(context, NewsDetailsActivity.class);
        intent.putExtra("News", newsList.get(position));
        context.startActivity(intent);
    }

    @Override
    public int getItemCount() {
        return newsList != null ? newsList.size() : 0;
    }

    class NewsViewHolder extends RecyclerView.ViewHolder {

        //CardView card;

        NewsViewHolder(View itemView){
            super(itemView);
            //card = itemView.findViewById(R.id.card);
        }
    }
}
