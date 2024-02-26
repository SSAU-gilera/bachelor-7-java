# Спецкурс по языку Java

#### Гордеева Ольга Александровна

4 курс 1 полугодие (7 семестр)

# Лабораторные работы

> Если в папке лабораторной работы нет файлов программы или появляются ошибки при запуске, вы всегда можете найти код в конце отчёта.

## Лабораторная работа 1

Основы языка Ява. Пакеты. Области видимости.

**Цель задания:** изучить структуру исходного кода программ на Java, особенности областей видимости, структуру пакетов, особенности использования командной строки для компиляции и запуска программ на Java.

Для выполнения задания использовать простейший текстовый редактор (блокнот). Для компиляции и запуска приложений использовать командную строку. Рекомендуется каждое задание выполнять в отдельном каталоге.

**Задание 1**
Запустите компилятор javac и изучите форматы задания параметров компилятора. Запустите программу java и изучите с форматы задания параметров запуска виртуальной машины Java (JVM).

**Задание 2**

Cоздайте файл FirstProgram.java, содержащий исходный код одного пустого класса с именем FirstClass:

\```java
(FirstProgram.java)
class FirstClass {
}
\```

Для запуска исполняемого файла выполните следующие действия:
- откомпилируйте файл с помощью компилятора javac. Для этого необходимо выполнить команду “javac <Полное имя файла с расширением>”;
- запустите полученный файл класса на выполнение с помощью команды `“java <Имя класса>”`. 

Примечание: запуск файла класса лучше выполнить командой `“java –classpath <Путь к файлу> <Имя файла класса без расширения>”`

Обратите внимание на то, что на вход компилятора необходимо подавать имя файла с расширением, на вход JVM – без расширения. Имена файлов не должны содержать пробелов и русских символов.

Добавьте в класс метод main():

\```
--- FirstProgram.java ----------------------------------------
class FirstClass {
	void main(String[] s) {
		System.out.println(“Hello world!!!”);
	}
}
------------------------------------------------------------------
\```

Откомпилируйте и запустите программу на выполнение.

Логично предположить, что метод main() должен быть статическим, т.к. на момент запуска программы ни одного объекта типа MyFirstClass не существует. Сделайте метод статическим, снова откомпилируйте и запустите программу.

Внесите в текст программы необходимые для ее запуска изменения, откомпилируйте и запустите программу.

**Задание 3**

Замените текст метода main() на следующий:

\```
--- FirstClass.main -------------------------------------------
for (int i = 0; i < s.length; i++)
	System.out.println(s[i]);
------------------------------------------------------------------
\```

Откомпилируйте и запустите программу, добавив в командную строку ряд аргументов. Аргументы командной строки записываются после имени запускаемого файла через пробелы. Например,  `“java –classpath <Путь к файлу> FirstClass arg1 arg2 arg3 arg4 arg5”.`

**Задание 4**

В том же файле FirstProgram.java после описания класса FirstClass добавьте описание второго класса SecondClass, реализующего следующую функциональность:
- имеет два приватных поля типа int;
- методы для получения и модификации их значений;
- конструктор, создающий объект и инициализирующий значения полей;
- метод с возвращаемым типом int, реализующий над этими числами какое-либо действие (сложение, умножение и т.п.).

Код метода FirstClass.main() при этом следует заменить на следующий (в угловых скобках указаны элементы, имена которых следует подставить при написании программы):

\```
--- FirstClass.main --------------------------------------------
<Создание и инициализация объекта “o” типа SecondClass>;
int i, j;
for (i = 1; i <= 8; i++) {
	for(j = 1; j <= 8; j++) {
		o.<Метод установки значения первого числового поля>(i);
		o.<Метод установки значения второго числового поля>(j);
		System.out.print(o.<Метод, реализующий действие над числами>());
		System.out.print(" ");
	}
	System.out.println();
}
------------------------------------------------------------------
\```

Откомпилируйте и запустите программу.

Задание 5

Вынесите код класса SecondClass без изменений в отдельный файл с именем FirstPackage.java, и поместите его в поддиректорию FirstPackage.

Откомпилируйте исходный код. 

Попробуйте откомпилировать файл FirstProgram.java.

Добавьте в начало исходного кода в файле FirstProgram.java следующий код:

\```
--- FirstProgram.java ------------------------------------------
import FirstPackage.*;
------------------------------------------------------------------
\```

Снова попробуйте откомпилировать FirstProgram.java. Далее, следуя сообщениям компилятора и изменяя исходный код программы, добейтесь ее работоспособности.

**Задание 6**

Запустите программу jar, предназначенную для создания архивов, и  изучите форматы задания ключей для формирования архивов.

Скопируйте в рабочую папку, сохранив структуру каталогов, только файлы с расширением class, полученные в результате выполнения задания 5.

Создайте файл manifest.mf, содержащий следующий код:

\```
--- manifest.mf -------------------------------------------------
Manifest-Version: 1.0
Created-By: <Ваши фамилии>
Main-Class: FirstClass
------------------------------------------------------------------
\```

Создайте архив myfirst.jar, включив в него полученные ранее файлы классов и указав созданный вами манифест-файл. Переместите полученный файл в другую директорию и запустите его на выполнение.

**Примечание 1:** Команда создания jar-архива выглядит следующим образом: “jar –cvfm <Полное имя jar-архива с расширением> <Полное имя манифест-файла с расширением> -C <Путь к папке с файлами class>\ .”; выделенный фрагмент является частью синтаксиса, его не терять.
команда запуска jar-архива выглядит следующим образом: “java –jar <Полное имя jar-архива с расширением>” .
**Примечание 2:** В примечании 1 символы < и > означают начало и конец пользовательской информации, их не нужно писать в команде. 
