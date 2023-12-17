package com.msaggik.fifthlessonstringanalyzer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    // поля
    // строка для анализа
    private String poem = "У лукоморья дуб зелёный\nЗлатая цепь на дубе том:\nИ днём и ночью кот учёный\n" +
            "Всё ходит по цепи кругом;\nИдёт направо — песнь заводит,\nНалево — сказку говорит.\n" +
            "Там чудеса: там леший бродит,\nРусалка на ветвях сидит;\nТам на неведомых дорожках\n" +
            "Следы невиданных зверей;\nИзбушка там на курьих ножках\nСтоит без окон, без дверей;\n" +
            "Там лес и дол видений полны;\nТам о заре прихлынут волны\nНа брег песчаный и пустой,\n" +
            "И тридцать витязей прекрасных\nЧредой из вод выходят ясных,\nИ с ними дядька их морской;\n" +
            "Там королевич мимоходом\nПленяет грозного царя;\nТам в облаках перед народом\n" +
            "Через леса, через моря\nКолдун несёт богатыря;\nВ темнице там царевна тужит,\n" +
            "А бурый волк ей верно служит;\nТам ступа с Бабою Ягой\nИдёт, бредёт сама собой,\n" +
            "Там царь Кащей над златом чахнет;\nТам русский дух… там Русью пахнет!\nИ там я был, и мёд я пил;\n" +
            "У моря видел дуб зелёный;\nПод ним сидел, и кот учёный\nСвои мне сказки говорил.\n";

    private int numberOfCharacters; // число символов в строке
    private int numberOfWords; // число слов в строке
    private int numberOfCharactersL; // число букв "л" в строке
    private String numberWordOfFiveCharacters; // наличие слова из 5 букв
    private String wordsCharactersA; // строка из слов начинающихся на букву "A"

    // создание дополнительных полей для вывода на экран полученных значений
    private TextView infoApp; // поле вывода информации анализа строки

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        numberOfCharacters = numberOfCharacters(poem);
        numberOfWords = numberOfWords(poem);
        numberOfCharactersL = numberOfCharactersL(poem);
        numberWordOfFiveCharacters = numberWordOfFiveCharacters(poem);
        wordsCharactersA = wordsCharactersA(poem);

        // привязка поля к разметке по id
        infoApp = findViewById(R.id.infoApp);

        // вывод информации на экран смартфона
        infoApp.setText("Число символов в строке " + numberOfCharacters + "\n"
                + "Число слов в строке " + numberOfWords + "\n"
                + "Число букв \"л\" в строке " + numberOfCharactersL + "\n"
                + "Наличие слов из 5 букв " + numberWordOfFiveCharacters + "\n"
                + "Строка из слов начинающихся на букву \"а\" " + wordsCharactersA);
    }

    // модуль компоновки строки из слов на букву "A" строки задачи
    private String wordsCharactersA(String stringPoem) {
        String stringA = ""; // строка из слов на букву "A" строки задачи
        String stPoem = stringPoem.replace("\n", " ").trim(); // замена всех переходов на следующую строку пробелами, затем удаление начальных и конечных пробелов
        String[] arrayPoem = stPoem.split(" "); // деление строки на подстроки по пробелу

        for (String string : arrayPoem) { // перебор всех слов массива
            if (string.charAt(0) == 'А' | string.charAt(0) == 'а') { // если первый символ строки буква "А"
                stringA += string + " "; // то прибавление к целевой строке данного слова с разделяющим пробелом в конце
            }
        }
        return stringA.trim(); // возврат требуемого значения с удалением пробела на конце
    }

    // модуль определения наличия в строке слов из 5 букв
    private String numberWordOfFiveCharacters(String stringPoem) {
        String count; // результат
        int numberFive = 0; // количество слов из 5 букв
        String stPoem = stringPoem.replace("\n", " ").trim(); // замена всех переходов на следующую строку пробелами, затем удаление начальных и конечных пробелов
        String[] arrayPoem = stPoem.split(" "); // деление строки на подстроки по пробелу
        for (String string : arrayPoem) { // перебор всех слов массива
            if (string.length() == 5) { // если 5 букв то +1
                numberFive += 1;
            }
        }
        if (numberFive == 0){count = "Нет";}
        else {count = "Да, " + numberFive + " шт.";}
        return count; // возврат требуемого значения
    }

    // модуль определения числа букв "л" в строке
    private int numberOfCharactersL(String stringPoem) {
        int count = 0; // счётчик числа слов в строке
        // цикл перебора символов в строке
        for (int i = 0; i < stringPoem.length(); i++) {
            if (stringPoem.charAt(i) == 'л') { // если символ с индексом i является буквой "л"
                count++;
            }
        }
        return count;
    }

    // модуль определения числа слов в строке
    private int numberOfWords(String stringPoem) {
        String stPoem = stringPoem.trim(); // удаление начальных и конечных проблелов
        int count = 0; // счётчик числа слов в строке
        // цикл перебора символов в строке
        for (int i = 0; i < stPoem.length(); i++) {
            if (stPoem.charAt(i) == ' ' | stPoem.charAt(i) == '\n') { // если символ с индексом i является пробелом или переходом на следующую строку
                count++;
            }
        }
        return count;
    }

    // модуль определения количества символов в строке
    private int numberOfCharacters(String stringPoem) {
        return stringPoem.length();
    }
}