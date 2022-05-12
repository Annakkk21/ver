package com.example.itog;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    int start_x = 0;
    int end_x = 0;

    @Override
    //Функция определения свайпа
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {//определение метода
            case MotionEvent.ACTION_UP://если нажатие
                start_x = (int) event.getX();//Определяем координату Х
                break;
            case MotionEvent.ACTION_DOWN://Если отжатие
                end_x = (int) event.getX();//Определяем координату Х
                break;
        }

        if (start_x != 0 && end_x != 0) {//Если координаты не 0
            if (start_x > end_x) {
                //свайп влево
                setContentView(R.layout.activity_main);//меняем экран
            } else if (start_x < end_x) {//если начальная координата меньше последней
                //свайп вправо
                setContentView(R.layout.regin);//меняем экран
            }

            start_x = 0;//обнуляем координаты
            end_x = 0;//обнуляем координаты
        }

        return false;
    }
}