package com.example.musicplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.Toast;

import com.example.musicplayer.databinding.ActivityMusicPlayer2Binding;

public class MusicPlayerActivity2 extends AppCompatActivity {

    ActivityMusicPlayer2Binding binding;

    MediaPlayer mediaPlayer;
    int playingPosition =  0;

    Integer [] allmusic = {R.raw.moment,R.raw.mylife,R.raw.order,R.raw.save_as,R.raw.slow_trap};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        binding=ActivityMusicPlayer2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        binding.playbtn.setOnClickListener( v -> {
            if (binding.playbtn.getTag().equals("play")){
                playMusic(playingPosition);
                binding.playbtn.setTag("pause");
            } else {
                binding.playbtn.setTag("play");
                binding.playbtn.setImageResource(R.drawable.ic_play__24);
                mediaPlayer.pause();

            }

        });




        binding.stopbtn.setOnClickListener( v -> {
            mediaPlayer.stop();


        });

        binding.nextbtn.setOnClickListener( v -> {

            if (playingPosition<allmusic.length-1){
            playingPosition++;
                playMusic(playingPosition);
            } else {

                Toast.makeText(this, "You Played All The Music ", Toast.LENGTH_SHORT).show();
            }

        });





    }

    private void playMusic(int playingPosition) {

        if(mediaPlayer != null ){
            mediaPlayer.pause();
            mediaPlayer.stop();
            mediaPlayer.release();
            mediaPlayer= MediaPlayer.create(this, allmusic[playingPosition]);
            mediaPlayer.start();
            binding.playbtn.setImageResource(R.drawable.ic_pause_24);
        }else {
            mediaPlayer= MediaPlayer.create(this, allmusic[playingPosition]);
            mediaPlayer.start();
            binding.playbtn.setImageResource(R.drawable.ic_pause_24);
        }

        binding.playbtn.setTag("play");



    }
}