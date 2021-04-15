package edu.uw.echee.activityresultexample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import edu.uw.echee.activityresultexample.databinding.ActivityMainBinding
import edu.uw.echee.activityresultexample.recyclerview.TweetsAdapter

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).apply { setContentView(root) }
        initListOfTweets()
        with(binding) {

            btnCompose.setOnClickListener {
                startActivity(Intent(this@MainActivity, CreateTweetActivity::class.java))
            }

        }
    }







    // region List of Tweets
    private lateinit var tweetsAdapter: TweetsAdapter
    private fun initListOfTweets() = with(binding) {
        tweetsAdapter = TweetsAdapter(listOf())
        rvTweets.adapter = tweetsAdapter
    }

    private fun addTweet(tweetMsg: String?) {
        if (tweetMsg != null) {
            tweetsAdapter.addTweet(tweetMsg)
        }
    }
    // endregion List of Tweets


}

/*
...
private val requestForData = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
*/
