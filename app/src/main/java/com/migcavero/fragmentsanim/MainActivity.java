package com.migcavero.fragmentsanim;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.List;

public class MainActivity extends AppCompatActivity implements DroidsAdapter.OnClickCallback {

    public int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initFragment();
    }

    @Override
    public void OnClick(int id) {
        initFragment();
    }

    private void initFragment(){
        List<Integer> list;
        switch (counter){
            case 1:
                list = AndroidImageAssets.getBodies();
                break;
            case 2:
                list = AndroidImageAssets.getLegs();
                break;
            default:
                list = AndroidImageAssets.getHeads();
                counter = 0;
                break;
        }

        MainFragment mainFragment = new MainFragment();
        mainFragment.setData(list);
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .setCustomAnimations(android.R.anim.slide_in_left, android.R.anim.fade_out)
                .replace(R.id.main_container, mainFragment)
                .commit();

        counter++;
    }
}
