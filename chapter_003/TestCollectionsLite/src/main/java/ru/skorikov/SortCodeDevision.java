package ru.skorikov;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.ListIterator;

/**
 * Created with IntelliJ IDEA.
 *
 * @ author: Alex_Skorikov.
 * @ date: 05.10.17
 * @ version: java_kurs
 */
public class SortCodeDevision {
    /**
     * Предварительный.
     * Метод проходит по листу и добавляет недостающие элементы.
     *
     * @param list лист
     * @return новый лист.
     */
    private ArrayList<String> addedMissingElemint(ArrayList<String> list) {
        ListIterator iterator = list.listIterator();
        while (iterator.hasNext()) {
            String[] strArr = iterator.next().toString().split("\\\\");
            if (strArr.length == 3) {
                String str1 = strArr[0];
                String str2 = strArr[0] + "\\" + strArr[1];
                if (!list.contains(str1)) {
                    iterator.add(str1);
                }
                if (!list.contains(str2)) {
                    iterator.add(str2);
                }
            } else {
                if (strArr.length == 2) {
                    String str = strArr[0];
                    if (!list.contains(str)) {
                        iterator.add(str);
                    }
                }
            }
        }

        return list;
    }

    /**
     * Предварительный.
     * Метод получает числовой размер строки.
     *
     * @param string строка - код подразделения.
     * @return трехзначный номер.
     */
    private int getNumberDivision(String string) {
        String str = string.replaceAll("[^0-9]+", "");
        int number = Integer.parseInt(str);
        if (str.length() == 2) {
            number = number * 10;
        } else {
            if (str.length() == 1) {
                number = number * 100;
            }
        }
        return number;
    }

    /**
     * Сортируем лист кодов по возрастанию.
     *
     * @param listDiv лист кодов.
     */
    private void sortDivisinUp(List<String> listDiv) {
        Collections.sort(listDiv, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int sort = 0;

                int intStr01 = getNumberDivision(o1);
                int intStr02 = getNumberDivision(o2);

                //Сравнение.
                if (intStr01 < intStr02) {
                    sort = -1;
                } else {
                    sort = 1;
                }

                return sort;
            }
        });
    }

    /**
     * Сортируем лист кодов по убыванию.
     *
     * @param listDiv лист кодов.
     */
    private void sortDivisinDown(List<String> listDiv) {
        Collections.sort(listDiv, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int sort = 0;

                int intStr01 = getNumberDivision(o1);
                int intStr02 = getNumberDivision(o2);
                int int1 = intStr01 / 100;
                int int01 = intStr01 % 100 / 10;
                int int001 = intStr01 % 10;
                int int2 = intStr02 / 100;
                int int02 = intStr02 % 100 / 10;
                int int002 = intStr02 % 10;

                //Сравнение.

                if (int1 > int2) {
                    sort = -1;
                } else {
                    sort = 1;
                }
                if (int1 == int2) {
                    if (int01 != int02) {
                        if (int01 > int02) {
                            if (int02 == 0) {
                                sort = 1;
                            } else {
                                sort = -1;
                            }
                        } else {
                            if (int01 == 0) {
                                sort = -1;
                            } else {
                                sort = 1;
                            }
                        }
                    } else {
                        if (int001 > int002) {
                            if (int002 == 0) {
                                sort = 1;
                            } else {
                                sort = -1;
                            }
                        } else {
                            if (int001 == 0) {
                                sort = -1;
                            } else {
                                sort = 1;
                            }
                        }
                    }
                }
                return sort;
            }
        });
    }

    /**
     * Результирующший
     * Метод возвращает отсортированный лист по возрастанию
     * с добавлением недостающих элементов.
     *
     * @param list лист.
     */
    public void sortedCodesDivisionUp(ArrayList<String> list) {
        addedMissingElemint(list);
        sortDivisinUp(list);
    }

    /**
     * Результирующий.
     * Метод возвращает отсортированный лист по убыванию.
     * с добавлением недостающих элементов.
     *
     * @param list лист.
     */
    public void sortCodesDivisionDown(ArrayList<String> list) {
        addedMissingElemint(list);
        sortDivisinDown(list);
    }


}
