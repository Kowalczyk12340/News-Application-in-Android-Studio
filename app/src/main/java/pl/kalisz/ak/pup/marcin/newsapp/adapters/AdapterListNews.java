package pl.kalisz.ak.pup.marcin.newsapp.adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import pl.kalisz.ak.pup.marcin.newsapp.R;
import pl.kalisz.ak.pup.marcin.newsapp.clicklisteners.AdapterItemClickListener;
import pl.kalisz.ak.pup.marcin.newsapp.databinding.NewsBinding;
import pl.kalisz.ak.pup.marcin.newsapp.model.News;

public class AdapterListNews extends RecyclerView.Adapter<AdapterListNews.NewsViewHolder> {

    private List<News> items;
    private AdapterItemClickListener adapterItemClickListener;

    public AdapterListNews(List<News> items, AdapterItemClickListener adapterItemClickListener) {
        this.items = items;
        this.adapterItemClickListener = adapterItemClickListener;
    }

    @Override
    public NewsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        NewsBinding newsBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_news_dashboard, parent, false);
        return new NewsViewHolder(newsBinding);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(NewsViewHolder holder, final int position) {
        holder.bind(getItem(position), adapterItemClickListener);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    private News getItem(int position) {
        return items.get(position);
    }

    public class NewsViewHolder extends RecyclerView.ViewHolder {
        private NewsBinding newsBinding;

        public NewsViewHolder(NewsBinding newsBinding) {
            super(newsBinding.getRoot());
            this.newsBinding = newsBinding;
        }

        public void bind(News news, AdapterItemClickListener adapterItemClickListener) {
            this.newsBinding.setNews(news);
            this.newsBinding.setClickListener(adapterItemClickListener);
        }

    }

}