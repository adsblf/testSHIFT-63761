<b>НАЗВАНИЕ</b>
    <br>&nbsp;&nbsp;&nbsp;&nbsp;testSHIFT-63761</br>

<b>ВЕРСИЯ</b>
    <br>&nbsp;&nbsp;&nbsp;&nbsp;1.0</br>

<b>ДАТА СБОРКИ</b>
    <br>&nbsp;&nbsp;&nbsp;&nbsp;25.07.2024</br>

<b>ФАЙЛ УТИЛИТЫ</b>
    <br>&nbsp;&nbsp;&nbsp;&nbsp;target\testSHIFT-1.0.jar</br>

<b>ФАЙЛ ИСХОДНОГО КОДА</b>
    <br>&nbsp;&nbsp;&nbsp;&nbsp;src\main\java\org\example\Main.java</br>

<b>НАЗНАЧЕНИЕ</b>
    <br>&nbsp;&nbsp;&nbsp;&nbsp;Программа предназначена для сортировки строк, целочисленных и вещественных чисел.</br>

<b>ПОРЯДОК ЗАПУСКА И РАБОТЫ</b>
        <br>&nbsp;&nbsp;&nbsp;&nbsp;1) В общем виде, программа запускается из консоли командой: java -jar testSHIFT-1.0.jar [параметры] [исходные файлы] </br>
		<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Программа принимает следующие параметры:</br>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;-o: задать путь для результата        			(-o /some/path)
		<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;-p: задать префикс имен выходных файлов      	(-p result_ задают вывод в файлы /some/path/result_integers.txt)</br>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;-a: задать режим добавление в существующий файл
		<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;-s: краткая статистика          				(количество элементов записанных в исходящие файлы)</br>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;-f: подробная статистика        				(для чисел: min и max значение, сумма, среднее. для строк: размер самой длинной и короткой строки)
  <br></br>
	<br>&nbsp;&nbsp;&nbsp;&nbsp;Исходные файлы:</br>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;1. Должны быть в формате ".txt";
		<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;2. Должны находиться в директории с исполняемым файлом;</br>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;3. Количество входных файлов не ограничено.
  <br></br>
	<br>&nbsp;&nbsp;&nbsp;&nbsp;2) Озакомиться с результатами работы программы и оценить полученный результат.</br>
 <br></br>
<b>ОСОБЕННОСТИ РЕАЛИЗАЦИИ</b>
	<br>&nbsp;&nbsp;&nbsp;&nbsp;java 20.0.1 </br>
	&nbsp;&nbsp;&nbsp;&nbsp;Apache Maven 3.9.8
<b>ОСОБЕННОСТИ РАБОТЫ ПРОГРАММЫ</b>
	<br>&nbsp;&nbsp;&nbsp;&nbsp;1) Если в исходных данных отсутствует какой-либо тип данных, например integer, программа не создаст результирующий файл "integer.txt".</br>
	&nbsp;&nbsp;&nbsp;&nbsp;2) Программа не умеет обрабатывать числа превышающие значения long (64 бита) и double (64 бита). Если такое число встречается, программа определяет его как строку и записывает результат в файл "strings.txt"
<br></br>
<b>СВЕДЕНИЯ ОБ АВТОРЕ</b>
    <br>Бережнов Алексей Дмитриевич, SHIFT-63761</rb>
    эл. почта: LstMidnight@yandex.ru
