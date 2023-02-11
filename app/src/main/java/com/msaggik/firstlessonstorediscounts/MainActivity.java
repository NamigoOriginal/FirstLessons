package com.msaggik.firstlessonstorediscounts;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    // задание полей
    float palto = 70; // пальто
    byte paltoDiscount = 77; // скидка (в процентах)
    float shlyapa = 25; // шляпа
    byte shlyapaDiscount = 37;
    float delkost = 39; // деловой комстюм
    byte delcostDiscount = 44;
    float sorochka = 19; // сорочка
    float tufli = 21; // туфли
    byte tufliDiscount = 32;
    float account = 312; // счёт пользователя

    // метод подсчёта стоимости гардероба
    private float calculation() {
        // создание и инициализация переменной подсчёта стоимости
        float count = (palto * (100 - paltoDiscount) + shlyapa * (100 - shlyapaDiscount)
                + delkost * (100 - delcostDiscount) + sorochka
                + tufli * (100 - tufliDiscount)) / 100;
        return count; // возврат подсчитанного значения
    }

    // метод определения возможностей бюджета покупки гардероба
    private boolean possibility() {
        if (calculation() <= account) { // если стоимость комплекта меньше имеющихся средств
            return true; // то возврат истинного значения
        } else { // иначе
            return false; // возврат ложного значения
        }
    }

    // метод определения возможной сдачи
    private float balance() {
        if(possibility()) { // если имеется возможность купить гардероб
            return account - calculation(); // то возвращается остаток от покупки
        } else { // иначе
            return -1; // возвращается маркер недостатка денежных средств
        }
    }

    // создание дополнительных полей для вывода на экран полученных значений
    private TextView possibilityOut; // поле возможности покупки
    private TextView balanceOut; // поле возможного остатка от покупки

    // вывод на экран полученных значений
    @Override
    protected void onCreate(Bundle savedInstanceState) { // создание жизненного цикла активности
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // присваивание жизненному циклу активити представления activity_main

        // присваивание переменным активити элементов представления activity_main
        possibilityOut = findViewById(R.id.possibilityOut); // вывод информации о возможности покупки
        balanceOut = findViewById(R.id.balanceOut); // вывод информации о возможном остатке от покупки

        // запонение экрана
        if (possibility()) { // если имеется возможность купить серверный комплект
            possibilityOut.setText("Имеется достаточно средств для покупки гардероба");
            balanceOut.setText("Остаток от покупки " + balance() + " серебрянных монет");
        } else { // иначе
            possibilityOut.setText("Недостаточно средств для покупки гардероба");
            balanceOut.setText(" - ");
        }
    }
}