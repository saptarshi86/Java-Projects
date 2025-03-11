package com.musicPlayer;

import java.util.*;

public class Main {
    private static ArrayList<Album> albums = new ArrayList<Album>();
    public static void main(String[] args){

        Album album = new Album("GOAT", "Divine");
        album.addSong("Mirchi", 4.5);
        album.addSong("3.59", 5.0);
        album.addSong("Yalgaar", 3.5);
        albums.add(album);
        album = new Album("Revival", "Eminem");
        album.addSong("Rap God", 5.03);
        album.addSong("Not Afraid", 4.25);
        album.addSong("Untouchable ", 6.01);

        LinkedList<Song> playList_1 = new LinkedList<>();

        albums.get(0).addToPlayList("Mirchi", playList_1);
        albums.get(0).addToPlayList("3.59", playList_1);
        albums.get(0).addToPlayList("Yalgaar", playList_1);
//        albums.get(1).addToPlayList("RapGod", playList_1);
//        albums.get(2).addToPlayList("Not Afraid", playList_1);

        play(playList_1);
    }
    private static void play(LinkedList<Song> playList){
        Scanner sc = new Scanner(System.in);
        boolean quit = false;
        boolean forward = true;
        ListIterator<Song> listIterator= playList.listIterator();

        if(playList.size() == 0){
            System.out.println("This play list has no song.");
        }else{
            System.out.println("Now Playing "+listIterator.next().toString());
            printMenu();
        }
        while(!quit){
            int action = sc.nextInt();
            sc.nextLine();

            switch (action) {
                case 1:
                    if (!forward) {
                        if (listIterator.hasNext())
                            listIterator.next();
                        forward = true;
                    }
                    if(listIterator.hasNext())
                        System.out.println("Now Playing "+listIterator.next().toString());
                    else{
                        System.out.println("No song available, reached to the end of the list");
                        forward = false;
                    }break;
                case 2:
                    if(forward){
                        if(listIterator.hasPrevious())
                            listIterator.previous();
                    }
                    forward = false;
                    if (listIterator.hasPrevious())
                        System.out.println("Now Playing "+listIterator.previous().toString());
                    else{
                        System.out.println("We are at the start of the List.");
                        forward = false;
                    }break;
                case 3:
                    if(forward){
                        if(listIterator.hasPrevious()) {
                            System.out.println("Now Playing " + listIterator.next().toString());
                            forward = false;
                        }else{
                            System.out.println("This is the start of the list. ");
                        }
                    }
                    else System.out.println("We have reached the end of the list.");
                    break;
                case 4:
                    printList(playList);
                    break;
                case 5:
                    printMenu(); break;
                case 6:
                    if(playList.size() > 0){
                        listIterator.remove();
                        if(listIterator.hasNext()){
                            System.out.println("Now Playing "+listIterator.next().toString());
                        }
                        else{
                            if(listIterator.hasPrevious())
                                System.out.println("Now Playing "+listIterator.previous().toString());
                        }
                    }else{
                        System.out.println("Play List is empty, No songs to delete ! ");
                    }break;
                case 7:
                    System.out.println("PlayList complete");
                    quit = true;
                    break;
            }

        }
    }
    private static void printMenu(){
        System.out.println("Available options\n press\n" +
                "1- to play next song\n" +
                "2- to play previous song\n" +
                "3- to play the current song again\n" +
                "4- list of all songs\n" +
                "5- print all available options\n" +
                "6- delete current song\n" +
                "7- exit");
    }
    public static void printList(LinkedList<Song> playList){
        Iterator<Song> iterator = playList.iterator();
        System.out.println("-----------------------");

        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println("-----------------------");
    }
}
