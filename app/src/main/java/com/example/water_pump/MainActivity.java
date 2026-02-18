package com.example.water_pump;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import com.example.water_pump.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private boolean isRunning = false;
    private  boolean isHydrantOn = false;
    private boolean isSprinklerOn = false;
    private boolean isV5On = false;
    private boolean isV4On = false;
    private boolean isV3On = false;
    private boolean isV2On = false;

    AppCompatButton btn_start;
    //ViewBinding ->
    private final int Blue = Color.parseColor("#0F3F9B");
    private final int Gray = Color.parseColor("#b0b0b0");
    private Object upDatePressure;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnStart.setOnClickListener(v -> {

            changedPipesColor();

//         setUpListener();
        });
//        binding.imgSprinkler.setOnClickListener(v -> {
//            if (!isSprinklerOn) {
//                binding.showerWater.setVisibility(View.VISIBLE);
//                binding.showerWater.playAnimation();
//                isSprinklerOn = true;
//            } else {
//                binding.showerWater.cancelAnimation();
//                binding.showerWater.setVisibility(View.GONE);
//                isSprinklerOn = false;
//            }
//        });
        // hydranton
//        binding.v5BottomPipe.setOnClickListener(v -> {
//            if (!isHydrantOn) {
//                binding.waterAnimation.setVisibility(View.VISIBLE);
//                binding.waterAnimation.playAnimation();
//                isHydrantOn = true;
//            } else {
//                binding.waterAnimation.cancelAnimation();
//                binding.waterAnimation.setVisibility(View.GONE);
//                isHydrantOn = false;
//            }
//        });

        // V5-hydrant
        binding.v5Hydrant.setOnClickListener(v -> {
            if (!isV3On) {
                return;
            }    if (!isHydrantOn) {
                binding.waterAnimation.setVisibility(View.VISIBLE);
                binding.waterAnimation.playAnimation();
                isHydrantOn = true;
            } else {
                binding.waterAnimation.cancelAnimation();
                binding.waterAnimation.setVisibility(View.GONE);
                isHydrantOn = false;
            }
            if (!isV5On) {
                isV5On = true;
                binding.txtV5Off.setText("ON");
                binding.v5BottomPipe.setBackgroundTintList(ColorStateList.valueOf(Blue));
            } else {
                isV5On = false;
                binding.txtV5Off.setText("OFF");
                binding.v5BottomPipe.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#b0b0b0")));

            }
        });
        // v3- hydrant
        binding.imgVerticalHydrant.setOnClickListener(v -> {
            V3hydrant();
        });
        //  V4-hydrant
        binding.v4Hydrant.setOnClickListener(v -> {
            setV4hydrant();
        });
        // v2-hydrant
        binding.v2Hydrant.setOnClickListener(v -> {
            setV2hydrant();
        });

    }


    // portrait layout
    private void setV2hydrant() {
        if (!isV2On) {
            isV2On = true;
            binding.txtV2Off.setText("ON");
            binding.poolHorizontalPipe.setBackgroundTintList(ColorStateList.valueOf(Blue));
            binding.verticalPipePool.setBackgroundTintList(ColorStateList.valueOf(Blue));
        } else {
            isV2On = false;
            binding.txtV2Off.setText("OFF");
            binding.poolHorizontalPipe.setBackgroundTintList(ColorStateList.valueOf(Gray));
            binding.verticalPipePool.setBackgroundTintList(ColorStateList.valueOf(Gray));

        }
    }

    // portrait layout
    private void V3hydrant() {
        if (!isRunning) {
            return;
        }
        if (!isV3On) {
            isV3On = true;
            binding.txtV3Off.setText("ON");
            binding.txtV1Off.setText("ON");
            binding.imgVerticalHydrantPipe.setBackgroundTintList(ColorStateList.valueOf(Blue));
            binding.mainPipe.setBackgroundTintList(ColorStateList.valueOf(Blue));
            binding.v5TopPipe.setBackgroundTintList(ColorStateList.valueOf(Blue));

        } else {
            isV3On = false;
            binding.txtV3Off.setText("OFF");
            binding.imgVerticalHydrantPipe.setBackgroundTintList(ColorStateList.valueOf(Gray));
            binding.mainPipe.setBackgroundTintList(ColorStateList.valueOf(Gray));
            binding.v5TopPipe.setBackgroundTintList(ColorStateList.valueOf(Gray));
            binding.v4HydrantPipe.setBackgroundTintList(ColorStateList.valueOf(Gray));
            binding.v5BottomPipe.setBackgroundTintList(ColorStateList.valueOf(Gray));
            binding.txtV4Off.setText("OFF");
            binding.txtV5Off.setText("OFF");
            if (isSprinklerOn) {
                binding.showerWater.cancelAnimation();
                binding.showerWater.setVisibility(View.GONE);
                isSprinklerOn = false;
            } if(isHydrantOn){
                binding.waterAnimation.cancelAnimation();
                binding.waterAnimation.setVisibility(View.GONE);
                isHydrantOn = false;
            }
            isV4On = false;
            isV5On = false;
        }
    }

    // portrait layout
    private void setV4hydrant() {
        if (!isV3On) {
            return;
        }
        if (!isSprinklerOn) {
            binding.showerWater.setVisibility(View.VISIBLE);
            binding.showerWater.playAnimation();
            isSprinklerOn = true;
        } else {
            binding.showerWater.cancelAnimation();
            binding.showerWater.setVisibility(View.GONE);
            isSprinklerOn = false;
        }
        if (!isV4On) {
            isV4On = true;
            binding.txtV4Off.setText("ON");
            binding.v4HydrantPipe.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#0F3F9B")));
        } else {
            isV4On = false;
            binding.txtV4Off.setText("OFF");
            binding.v4HydrantPipe.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#b0b0b0")));
        }

    }

    // portrait layout
    private void changedPipesColor() {
        View[] pipes = {

                binding.meterPipe,
                binding.topMeterPicturePipe,
                binding.meterSmallPipe,
                binding.pumpHorizontal,
                binding.pumpPipe,
                binding.poolLengthyPipe,
                binding.poolPipe,
                binding.showerWater,
                binding.waterAnimation

        };
        if (!isRunning) {
            for (View pipe : pipes) {
                pipe.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#0F3F9B")));
            }
            binding.btnStart.setText("STOP");
            binding.txtV1Off.setText("ON");
            binding.btnStart.setSupportBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#bb171a")));
            isRunning = true;
        } else {
            for (View pipe : pipes) {
                pipe.setBackgroundTintList(ColorStateList.valueOf(Color.GRAY));
            }
            binding.txtV1Off.setText("OFF");
            binding.btnStart.setText("START");
            binding.btnStart.setSupportBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#0d3115")));
            isV2On = false;
            isV3On = false;
            isV4On = false;
            isV5On = false;
            binding.txtV2Off.setText("OFF");
            binding.txtV3Off.setText("OFF");
            binding.txtV4Off.setText("OFF");
            binding.txtV5Off.setText("OFF");
            binding.mainPipe.setBackgroundTintList(ColorStateList.valueOf(Gray));
            binding.v5TopPipe.setBackgroundTintList(ColorStateList.valueOf(Gray));
            binding.imgVerticalHydrantPipe.setBackgroundTintList(ColorStateList.valueOf(Gray));
            binding.v4HydrantPipe.setBackgroundTintList(ColorStateList.valueOf(Gray));
            binding.v5BottomPipe.setBackgroundTintList(ColorStateList.valueOf(Gray));
            if (isSprinklerOn) {
                binding.showerWater.cancelAnimation();
                binding.showerWater.setVisibility(View.GONE);
                isSprinklerOn = false;
            } if(isHydrantOn){
                binding.waterAnimation.cancelAnimation();
                binding.waterAnimation.setVisibility(View.GONE);
                isHydrantOn = false;
            }
            isRunning = false;

        }
    }

}