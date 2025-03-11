package com.musicPlayer;
import java.util.ArrayList;
import java.util.LinkedList;

public class Album {
    private String title;
    private  String artist;
    private ArrayList<Song> songs;

    public Album(String name, String artist) {
        this.title = name;
        this.artist = artist;
        this.songs = new ArrayList<Song>();
    }
    public Album(){ }

    public Song findSong(String title){
        for(Song checkedSong: songs){
            if(checkedSong.getTitle().equals(title))
                return checkedSong;
        }
        return null;
    }

    // addSong checks whether the song is there in the list.
    // If yes prints already exists+returns false
    // If not then it adds it
    public boolean addSong(String title, double duration){
        if( findSong(title) == null){
            songs.add(new Song(title, duration));
//            System.out.println(title + " successfully added to the list.");
            return true;
        }
        else{
            System.out.println("Song with name "+title+" already exists in the list.");
            return false;
        }
    }
    // now I need to check whether a particular song already exists in my list or not
    // and then add that song in my PlayList if returns false
    public boolean addToPlayList(int trackNumber, LinkedList<Song> PlayList){
        int index = trackNumber -1;
        if(index>0 && index <= songs.size()){
            PlayList.add(this.songs.get(index));
            return true;
        }
        System.out.println("this album does not has any song with trackNumber "+trackNumber);
        return false;
    }


    public boolean addToPlayList(String title, LinkedList<Song> PlayList){
        for(Song checkedSong : this.songs){
            if(checkedSong.getTitle().equals(title)){
                PlayList.add(checkedSong);
                return true;
            }
        }
        System.out.println(title+" there is no such song in the album.");
        return false;
    }
}
