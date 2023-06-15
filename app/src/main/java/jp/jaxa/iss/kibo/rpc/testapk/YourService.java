package jp.jaxa.iss.kibo.rpc.defaultapk;


import android.util.Log;

import gov.nasa.arc.astrobee.Result;
import gov.nasa.arc.astrobee.types.Point;
import gov.nasa.arc.astrobee.types.Quaternion;
import jp.jaxa.iss.kibo.rpc.api.KiboRpcService;

/**
 * Class meant to handle commands from the Ground Data System and execute them in Astrobee
 */

public class YourService extends KiboRpcService {
    @Override
    protected void runPlan1(){
        // write your plan 1 here

        Log.i("hsnu is not a big deal","mission start");

        api.startMission(); //開始

        //從起點移動到一點上
        Point point1 = new Point(1.0,2.0,3.0);
        Quaternion quaternion = new Quaternion(0.0f,1.0f,0.0f,0.001f);
        api.moveTo(point1,quaternion,false);

        //發射雷射光
        Result r = api.laserControl(true);

        int numberTry = 3;
        while(r == null && numberTry != 0) {
            r = api.laserControl(true);
            numberTry--;
        }
    }

    @Override
    protected void runPlan2(){
        // write your plan 2 here
    }

    @Override
    protected void runPlan3(){
        // write your plan 3 here
    }

}

