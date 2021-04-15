package edu.uw.echee.activityresultexample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import edu.uw.echee.activityresultexample.databinding.ActivityCreateTweetBinding

const val USERNAME_KEY = "USERNAME_KEY"
const val TWEET_MSG_KEY = "TWEET_MSG_KEY"

class CreateTweetActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCreateTweetBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCreateTweetBinding.inflate(layoutInflater).apply { setContentView(root) }
        with(binding) {

            btnTweet.setOnClickListener {
                val username = etUsername.text.toString()
                val tweetMsg = etTweetMsg.text.toString()

                setResult(RESULT_OK, Intent().apply {
                    putExtra(USERNAME_KEY, username)
                    putExtra(TWEET_MSG_KEY, tweetMsg)
                })
                finish()
            }

        }
    }
}

/*
...
title
supportActionBar?.setDisplayHomeAsUpEnabled(true)
override fun onSupportNavigateUp(): Boolean {
 */
