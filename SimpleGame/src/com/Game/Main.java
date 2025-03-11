package com.Game;

public class Main {
    public static void main(String[] args) {
        Player1 player = new Player1("Ajay", "sword", 100);
//        System.out.println(player.getName());
//        System.out.println(player.getHealth());
//        System.out.println(player.getWeapon());
//        player.damagedByGun1();
//        player.damagedByGun1();
        player.damagedByGun2();

        Player2 betterPlayer = new Player2("Abhay", "machineGun",100, false );
        betterPlayer.damagedByGun2();
        betterPlayer.damagedByGun1();
        player.heal();

    }
}
