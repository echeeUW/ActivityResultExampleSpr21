package edu.uw.echee.activityresultexample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.result.contract.ActivityResultContracts
import edu.uw.echee.activityresultexample.databinding.ActivityMainBinding
import edu.uw.echee.activityresultexample.recyclerview.TweetsAdapter

private const val TAG = "MainActivity"

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).apply { setContentView(root) }
        initListOfTweets()
        with(binding) {

            btnCompose.setOnClickListener {
                requestForData.launch(Intent(this@MainActivity, CreateTweetActivity::class.java))
            }
        }
    }

    private val requestForData = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == RESULT_OK) {
            // We have been given data!

            val extraData = result.data?.extras
            if (extraData != null) {
                // Pull the data out of the intent that was sent back to us
                val username = extraData.getString(USERNAME_KEY)
                val tweetMsg = extraData.getString(TWEET_MSG_KEY)
                Log.i(TAG, "@$username : $tweetMsg")

                addTweet(tweetMsg)
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
