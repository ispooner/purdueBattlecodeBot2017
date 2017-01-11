package testingfuncsplayer;

import battlecode.common.*;

/**
 * Created by reddr on 2017-01-11.
 */
public class RobotPlayer {
    static RobotController rc;

    public static void run(RobotController rc) throws GameActionException
    {
        RobotPlayer.rc = rc;

        switch(rc.getType())
        {
            case ARCHON:
                runArchon();
                break;
            case GARDENER:
                runGardener();
                break;
            case SOLDIER:
                runSoldier();
                break;
            case TANK:
                runTank();
                break;
            case SCOUT:
                runScout();
                break;
            case LUMBERJACK:
                runLumberjack();
                break;
        }
    }

    static void runArchon()
    {
        try
        {
            rc.hireGardener(Direction.getEast());
        }
        catch(GameActionException e)
        {
            System.out.println("There was an issue creating the gardener or moving the archon");
        }
        while(true)
        {
            try {
                rc.move(Direction.getWest());
            }
            catch(GameActionException e)
            {
                System.out.println("The archon can move no more.");
            }
            Clock.yield();
        }
    }

    //This is my attempt at testing how close together you can place trees. 

    static void runGardener()
    {
        TreeInfo[] myTrees;
        int index = 0;
        while(true)
        {
            myTrees = rc.senseNearbyTrees(2);
            try {
                rc.water(myTrees[index].getID());
            }
            catch (GameActionException e)
            {
                System.out.println("Could not water tree " + index);
                System.out.println("There are " + myTrees.length + " trees.");
            }
            Clock.yield();
        }
    }

    static void runSoldier()
    {
        while(true)
        {
            Clock.yield();
        }
    }

    static void runTank()
    {
        while(true)
        {
            Clock.yield();
        }
    }

    static void runScout()
    {
        while(true)
        {
            Clock.yield();
        }
    }

    static void runLumberjack()
    {
        while(true)
        {
            Clock.yield();
        }
    }
}

























