package Lesson3;

import java.util.*;

public class Lesson3 {

    public static void main(String[] args) {
        stringExercise();
    }

    public static void massiveIntroduction() {
        int[] mass = new int[10]; // ������������� ������� ������� � ������� 10
        int[] posNumber = {1, 2, 10, 3}; // ������������� ������� ��� � ��������� ����������

        // ������� ���������� �������
        for (int i = 0; i < posNumber.length; i++) {
            System.out.println(posNumber[i]);
        }

        // ���������� ����� for_each
        for (int element : posNumber) {
            System.out.println(element);
        }

        // ��������� �������� � ������ ����� ����
        Random random = new Random();
        for (int i = 0; i < mass.length; i++) {
            mass[i] = random.nextInt(-100, 200);
        }

        // ����� ��������, ���������, �����, �����
        int min = mass[0], max = mass[0], sum = 0, find_element = 1, find_index = -1;
        for (int i = 0; i < mass.length; i++) {
            // min
            if (mass[i] < min) {
                min = mass[i];
            }
            // max
            if (mass[i] > max) {
                max = mass[i];
            }
            // sum
            sum += mass[i];
            // find
            if (mass[i] == find_element) {
                find_index = i;
            }
        }

        // �� �� �����, �� ����� ��������� �������
        System.out.println("�������:" + min + "\n��������:" + max + "\n�����:" + sum);
        System.out.println("�������:" + Arrays.stream(mass).min().getAsInt()
                + "\n��������:" + Arrays.stream(mass).max().getAsInt()
                + "\n�����:" + Arrays.stream(mass).sum()
                + "\n������� " + find_element + " ������ � ������� " + find_index);
    }

    public static void stringIntroduction() {
        String tmp = "test string";
        String tmp2 = "test string";
        // String tmp2 = new String("test string"); old style
        System.out.println(tmp.equals(tmp2)); // ����� ��������� ����� ���������, �.�. String �������� �������� ������. ������ ������������ ������� equals
        System.out.println(tmp.toUpperCase()); // ���������� ������ � �������� ��������
        System.out.println(tmp.replace('t', 'a')); // �������� ������ ������������ ������ ���������� �� ������ ������������ ������ ����������
        System.out.println(tmp.charAt(0)); // ��������� ������� �� ������ �������. ������ ������� ���������� � 0.
        System.out.println(tmp.indexOf('e')); // ����� ������� ������� � ������. �� ���� ���� ������ ��������� ������� � ������ � ���������� �������, ���� ������ �� �������, ������ -1.
        System.out.println(tmp.lastIndexOf('e')); // ����� ������� ������� � ������. �� ���� ���� ��������� ��������� ������� � ������ � ���������� �������, ���� ������ �� �������, ������ -1.
        System.out.println(tmp.substring(5)); // ������ ��������� �� 6 ������� ������������ �� ����� ������
        System.out.println(tmp.substring(5, 8)); // ������ ��������� �� 6 ������� ������������ �� 8 �� ������������.
        System.out.println(tmp.contains("str")); // ������ true ��� false � ����������� �� ����, ���� �� ������������ ���������� ������ ������ ������ tmp

        String tmp3 = "   !!!, test !!!";
        System.out.println(tmp3.strip()); // ������� ��� ������ ������� � ������ � ����� ������ �������� ��� �������� �� ����� ���������
        System.out.println(tmp3.trim()); // ������� ��� ������ ������� � ������ � ����� ������ �������� ��� removes only characters <= U+0020 (space);

        System.out.println(tmp3.length()); // ���������� ������ ������. �� ���� ���������� ��������.
        System.out.println(tmp3.charAt(tmp3.length() - 1)); // �������� ��������� ������
        System.out.println(tmp3.trim().length());
    }

    public static void stringExercise() {
        Dictionary<Character, Integer> vowelsDict = new Hashtable<>(); // �������� �������, ����� ������ �������� �������������� �����
        // ����� ���������� ����� � ������� ��������(0)
        vowelsDict.put('�', 0);
        vowelsDict.put('�', 0);
        vowelsDict.put('�', 0);
        vowelsDict.put('�', 0);
        vowelsDict.put('�', 0);
        vowelsDict.put('�', 0);
        vowelsDict.put('�', 0);
        vowelsDict.put('�', 0);
        vowelsDict.put('�', 0);
        int countVowels = 0;
        String vowels = "���������";
        String tmp = "���� ���� ����, � ���� ����� ������";

        String[] words = tmp.split(" ");

        System.out.println("���������� ����: " + words.length);

        for (int i = 0; i < tmp.length(); i++) {
            if (vowels.contains(String.valueOf(tmp.charAt(i)))) {
                countVowels++;
                // ���� ����� ��������, �� ���-�� �������� �������� ������� �� ���� ����� �� 1
                vowelsDict.put(tmp.charAt(i), vowelsDict.get(tmp.charAt(i)) + 1);
            }
        }

        System.out.println("���������� ������� � �����������: " + countVowels);

        System.out.println("������� ����:");

        var iterator = vowelsDict.keys().asIterator(); // ������� �������� ������, ����� ��������� �������
        while (iterator.hasNext()) // ���� ����� ����� ������
        {
            char symbol = iterator.next(); // ����� ������ ����
            System.out.println(symbol + " : " + vowelsDict.get(symbol)); // ����������� ��� ���� � ����������� ��������.
        }
    }
}
