skillfactory_Project_24.7
---

Первая часть
--

Парсинг .xlsx
https://mkyong.com/java/apache-poi-reading-and-writing-excel-file-in-java/
--

Please click here: 
https://search.maven.org/classic/#search%7Cga%7C1%7Cg%3A%22org.apache.poi%22%20AND%20a%3A%22poi-ooxml%22
for the latest version of this artifact.

Apache POI API Based On OPC and OOXML Schemas:
<!-- https://mvnrepository.com/artifact/org.apache.poi/poi-ooxml -->
<dependency>
    <groupId>org.apache.poi</groupId>
    <artifactId>poi-ooxml</artifactId>
    <version>5.2.2</version>
</dependency>
https://mvnrepository.com/artifact/org.apache.poi/poi-ooxml

Вторая часть
--
Код первой части. (образцовый от SkillFactory)
https://github.com/SkillfactoryCoding/JAVA/tree/master/UniversityInfo_Project/universityInfo-lesson1

В этом уроке необходимо выполнить следующее:
+ [X] Скачать подготовленный файл XLSX. При желании можно продолжить заполнение файла произвольной подходящей информацией.
+ [X] Разместить этот файл в папку ресурсов проекта.
+ [X] Создать класс, отвечающий за чтение файла и создание из него коллекций студентов и университетов.
+ [X] В файле необходимо реализовать запрет на создание экземпляра (приватный конструктор).
- [ ] В файле необходимо реализовать два метода: один — для чтения студентов, второй — для чтения университетов. При чтении эти методы должны построчно читать табличный файл и собирать коллекции соответствующих элементов классов.
- [ ] Реализовать занесение в класс University значения типа StudyProfile. Для этого необходимо текстовое поле из файла преобразовать в элемент enum.
- [ ] Очистить метод main от предыдущего кода. Вместо этого реализовать получение коллекций с использованием написанного в п.4 класса, затем вывести в консоль все полученные элементы коллекций.
- [ ] Дополнительное задание (теоретическое): разобраться, почему для Apache POI оказалось достаточно использовать только одну подключенную в Maven зависимость без указания других частей POI, которые, казалось бы, тоже надо упоминать.

Порядок работы при чтении XLSX-файла:
+ [X] Получаем содержимое файла как FileInputStream.
+ [X] Создаём экземпляр класса XSSFWorkbook, передав его конструктору на вход стрим файла. Для файлов XLS (более старый формат) используется аналогичный класс HSSFWorkbook.
  Здесь Workbook — это сам документ Excel, его представление как объекта.
+ [X] Затем надо получить страницу/лист. Для этого используем метод workbook.getSheet(имя_страницы). Метод возвращает экземпляр класса XSSFSheet (либо HSSFSheet, если мы работаем с XLS).
  Этот класс — представление конкретного листа из файла Excel. Можно получать листы как по их индексу (порядковый номер), так и по названию листа.
+ [X] С листом мы работаем при помощи итератора. Создаём итератор, который перебирает строки нашего листа. Например, sheet.iterator().
- [ ] Если в файле есть заголовок, нам надо его пропустить. Для этого достаточно просто вызвать iterator.next() перед тем, как мы будем обрабатывать информацию внутри цикла.
- [ ] Затем в цикле while перебираем строки, предоставляемые итератором (экземпляры класса Row). Строки, очевидно, содержат в себе ячейки таблицы — элементы класса Cell.
- [ ] Взятие ячейки из строки происходит с помощью метода row.getCell() по индексу ячейки.
- [ ] Для получения значения из ячейки существует ряд методов, позволяющий прочитать значения различных типов. Например, getNumericCellValue(), getStringCellValue().

Третья часть
--

