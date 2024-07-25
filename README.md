НАЗВАНИЕ
	<br>	testSHIFT-63761</br>
<br></br>
ВЕРСИЯ
    <br>	1.0</br>
<br></br>
ДАТА СБОРКИ
    <br>	25.07.2024</br>
<br></br>
<ФАЙЛ УТИЛИТЫ
    <br>	target\testSHIFT-1.0.jar</br>
<br></br>
ФАЙЛ ИСХОДНОГО КОДА
    <br>	src\main\java\org\example\Main.java</br>
<br></br>
НАЗНАЧЕНИЕ
    <br>	Программа предназначена для сортировки строк, целочисленных и вещественных чисел.</br>
<br></br>
ПОРЯДОК ЗАПУСКА И РАБОТЫ
        <br>	1) В общем виде, программа запускается из консоли командой: java -jar testSHIFT-1.0.jar [параметры] [исходные файлы] </br>
		<br>Программа принимает следующие параметры:</br>
		<br>	-o: задать путь для результата        			(-o /some/path)</br>
		<br>	-p: задать префикс имен выходных файлов      	(-p result_ задают вывод в файлы /some/path/result_integers.txt, /some/path/result_strings.txt)</br>
		<br>	-a: задать режим добавление в существующий файл</br>
		<br>	-s: краткая статистика          				(количество элементов записанных в исходящие файлы)</br>
		<br>	-f: подробная статистика        				(для чисел: минимальное и максимальное значение, сумма, среднее. для строк: размер самой длинной и короткой строки)</br>
	<br>	Исходные файлы:</br>
		<br>	1. Должны быть в формате ".txt";</br>
		<br>	2. Должны находиться в директории с исполняемым файлом;</br>
		<br>	3. Количество входных файлов не ограничено.</br>
	<br>	2) Озакомиться с результатами работы программы и оценить полученный результат.</br>
<br></br>
ОСОБЕННОСТИ РЕАЛИЗАЦИИ
	<br>	java 20.0.1 </br>
	<br>	Apache Maven 3.9.8</br>
<br></br>
ОСОБЕННОСТИ РАБОТЫ ПРОГРАММЫ
	<br>	1) Если в исходных данных отсутствует какой-либо тип данных, например integer, программа не создаст результирующий файл "integer.txt".</br>
	<br>	2) Программа не умеет обрабатывать числа превышающие значения long (64 бита) и double (64 бита). Если такое число встречается, программа определяет его как строку и записывает результат в файл "strings.txt".</br>
<br></br>
СВЕДЕНИЯ ОБ АВТОРЕ
    <br>	Бережнов Алексей Дмитриевич, SHIFT-63761</br>
    <br>	эл. почта: LstMidnight@yandex.ru</br>
