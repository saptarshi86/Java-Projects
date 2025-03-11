package com.Game;

public class Player2 extends Player1 {
    private int health;
    private boolean armour;

    public Player2(String name, String weapon, int health1, boolean armour) {
        super(name, weapon, health1);
        this.armour = armour;
    }

    @Override
    public void damagedByGun2() {
        {
            if(armour){ // if armour on
                this.health -=40;
                if(this.health <= 0) this.health =0;
                System.out.println("Armour is on. Got hit by gun2. Health is reduced by 40."+
                        "New health is " + this.health);
            }
            if(!armour){ // if no armour
                this.health -=50;
                if(this.health <= 0) this.health =0;
                System.out.println("Armour is off. Got hit by gun2. Health is reduced by 50."+
                        "New health is " +this.health);
            }
            if(this.health ==0) System.out.println(getName()+" is Dead.");
        }
    }

    @Override
    public void damagedByGun1() {
        if(armour){
            this.health -=20;
            if(this.health <= 0) this.health =0;
            System.out.println("Armour is on. Got hit by gun1. Health is reduced by 20."+
                    "New health is " + this.health);
        }
        if(!armour){
            this.health -=30;
            if(this.health <= 0) this.health =0;
            System.out.println("Armour is off. Got hit by gun1. Health is reduced by 30."+
                    "New health is " +this.health);
        }
        if(this.health ==0) System.out.println(getName()+" is Dead.");
    }
}
