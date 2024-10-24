package Lesson4;

public class Lesson4 {
    public static void main(String[] args) {
        exerciseString();
    }
    public static String deletePunctuation(String word) {
        while (!Character.isAlphabetic(word.charAt(0)) || !Character.isAlphabetic(word.charAt(word.length()-1)))
        {
            if (!Character.isAlphabetic(word.charAt(0)))
                word = word.substring(1);
            if (!Character.isAlphabetic(word.charAt(word.length()-1)))
                word = word.substring(0, word.length()-1);
        }
        return word;
    }

    public static void introductionString() {
        String str = "   Мама мыла раму, папа читал газету";

        // По индексам
        for (int i = 0; i < str.length(); i++)
            System.out.println(str.charAt(i));

        // По элементам
        for (char symbol : str.toCharArray()) {
            System.out.println(symbol);
        }

        // Представление в виде массива символов
        char[] symbols = str.toCharArray();

        // Получить символ по индексу - str.charAt(index)
        System.out.println(str.charAt(0));
        // Получить подстроку из строки - str.substring(beginIndex, [endIndex]). endIndex - не включительно
        System.out.println(str.substring(str.length() - 6)); // газету
        System.out.println(str.substring(0, 4)); // Мама
        // Проверить содержит ли строка подстроку - str.contains(substr)
        System.out.println(str.contains("Мама"));
        // Привести строку к нижнему или верхнему регистру(прописные или заглавные буквы) - toLowerCase(), toUpperCase()
        System.out.println(str.toLowerCase().contains("мама"));

        // Убрать "незначащие" пробелы в конце и начале строки - str.trim(). Расширенная версия trim - strip.
        // Работает в кодировки unicode
        str = str.trim();
        // Получить массив подстрок - str.split(splitter) - где splitter - разделитель в виде строки.
        String [] words = str.split(" ");
        for (String word : words) {
            System.out.println(word);
        }
        // Получить индекс по символу(найти позицию символа - str.indexOf(charFind/strFind, [indexBegin]).
        // Может искать как символы, так и строки. IndexBegin - откуда начинается поиск - это замена lastIndexOf
        System.out.println(str.toLowerCase().indexOf('м'));
        System.out.println(str.toLowerCase().indexOf('м', 1));

        // Заменить символы/подстроки на другие str.replace(oldSymbol(-s), newSymbol(-s))
        System.out.println(str.replace('м', 'т'));

    }

    public static void exerciseString() {
        String str = "Мама мыла раму, папа читал око, в котором говорилось про Радар";

        // Найти позицию третей буквы а(гарантировано, что она существует)
        int countA = 0, lastPosA = 0;
        while (countA < 3)
        {
             lastPosA = str.indexOf('а', lastPosA + 1);
             countA++;
        }
        System.out.println("Third a on position:" + lastPosA);

        // Найти позицию третей буквы а с проверкой существования 3 третей буквы а
        while (countA < 3 && (lastPosA = str.indexOf('а', lastPosA + 1)) != -1)
            countA++;
        System.out.println(countA == 3 ? "Third a on position: " + lastPosA : "Doesn't exist third A");

        // Найти слово в предложении длиннее 4 символов
        String[] words = str.split(" ");
        for(String word: words)
        {
            if (word.length() > 4)
            {
                System.out.println("Word with length bigest 4 is:" + word);
                break;
            }
        }

        // Найти слово в предложении длиннее 4 символов(не учитывая знаков препинания)
        words = str.split(" ");
        for(String word: words)
        {
            deletePunctuation(word);
            if (word.length() > 4)
            {
                System.out.println("Word with length bigest 4 is:" + word);
                break;
            }
        }

        // Найти все палиндромы в строке

        words = str.split(" ");
        String[] massAnswer = {};
        for(String word: words)
        {
            word = word.toLowerCase();
            // Убираем пунктуацию и цифры у всех слов
            deletePunctuation(word);
            if(word.length() > 1)
            {
                StringBuilder reverseWord = new StringBuilder();
                for (int i = word.length() -1; i >= 0; i--)
                    reverseWord.append(word.charAt(i));
                if (word.equals(reverseWord.toString()))
                {
                    String[] tmp = new String[massAnswer.length + 1];
                    System.arraycopy(massAnswer, 0, tmp, 0, massAnswer.length);
                    tmp[massAnswer.length] = word;
                    massAnswer = tmp;
                }
            }
        }
        System.out.print("Массив палиндромов: ");
        for (String s : massAnswer) System.out.print(s + " ");
    }


}
