package edu.uw.echee.activityresultexample.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import edu.uw.echee.activityresultexample.databinding.ItemTweetBinding

class TweetsAdapter(
    private var tweets: List<String>
): RecyclerView.Adapter<TweetsAdapter.TweetViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TweetViewHolder {
        val itemTweetBinding = ItemTweetBinding.inflate(LayoutInflater.from(parent.context))
        return TweetViewHolder(itemTweetBinding)
    }

    override fun getItemCount(): Int = tweets.size

    override fun onBindViewHolder(holder: TweetViewHolder, position: Int) {
        val tweetMsg = tweets[position]
        with (holder.binding) {
            tvTweet.text = tweetMsg
        }
    }

    class TweetViewHolder(val binding: ItemTweetBinding): RecyclerView.ViewHolder(binding.root)

    fun addTweet(tweetMsg: String) {
        tweets = tweets.toMutableList().apply {
            add(tweetMsg)
        }
    }
}

