package edu.uw.echee.activityresultexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import edu.uw.echee.activityresultexample.databinding.ActivityCreateTweetBinding

class CreateTweetActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCreateTweetBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCreateTweetBinding.inflate(layoutInflater).apply { setContentView(root) }
        with(binding) {
        }
    }
}

/*
...
title
supportActionBar?.setDisplayHomeAsUpEnabled(true)
override fun onSupportNavigateUp(): Boolean {
 */
