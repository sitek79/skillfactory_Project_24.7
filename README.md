skillfactory_Project_24.7
---

Первая часть
--

Парсинг .xlsx:  
https://mkyong.com/java/apache-poi-reading-and-writing-excel-file-in-java/

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
#### 26.9. ПРОМЕЖУТОЧНАЯ СДАЧА ПРОЕКТА (HW-02)
##### создана ветка в репозитории проекта с именем [project_26](https://github.com/sitek79/skillfactory_Project_24.7/tree/project_26 "git checkout project_26")

+ [X] Создать интерфейсы-компараторы для классов Student, University. Унаследовать их от класса Comparator<>.
- [ ] Для каждого поля классов Student, University создать классы-компараторы, реализующие интерфейс созданных в п.1 компараторов.
- [ ] При сравнении значений в методе compare() использовать методы соответствующих классов (Integer, Float, ...), для строковых значений использовать метод StringUtils.compare() библиотеки Apache Commons. Сравнение среднего балла студентов реализовать по убыванию.
- [ ] Создать два enum, один — для перечисления вариантов компараторов класса Student, второй — класса University.
- [ ] Создать утилитный класс (то есть класс, не позволяющий создать свой экземпляр, работающий исключительно по статическим методам), в котором реализовать два метода, принимающих на вход enum с типом компаратора, определяющих и возвращающих необходимый из реализованных компараторов.
Пояснение: на вход метода подаётся параметр, представляющий собой enum. Например, вот так: public static IMyComparator getMyComparator(MyEnum myEnum). Внутри метода по этому значению определяем, какую реализацию компаратора надо взять. На выходе метода, как видно из его описания, мы получаем тот или иной объект, реализующий наш интерфейс компаратора.
- [ ] В методе main реализовать получение компаратора по типу (вызов метода утилитного класса). Сохранить полученные значения (то есть экземпляры компараторов) в переменные с типом интерфейса компаратора (аналогично тому, как в коллекциях делается List<T> someList = new ArrayList()).
- [ ] В методе main заменить циклический вывод текстовой информации на использование Stream API. Перед выводом выполнить сортировку с использованием полученных компараторов. Вывод реализовать также в стриме с использованием синтаксиса ::

Четвертая часть
--
#### Практическая неделя 3. Проект.
+ [X] Добавить в pom.xml зависимость для библиотеки Google Gson. Данные для подключения можно взять на сайте.
- [ ] Создать утилитный класс JsonUtil. Запретить создание экземпляра класса.
- [ ] В классе JsonUtil реализовать 4 метода сериализации в JSON и 4 метода десериализации из JSON в объекты: сериализация/десериализация отдельных объектов студентов и университетов, сериализация/десериализация коллекций этих объектов. Сериализация должна выполняться в форматированном виде (PrettyPrinting).
- [ ] В методе main выполнить сериализацию коллекций, вывести получившиеся JSON-строки в консоль.
- [ ] В методе main выполнить десериализацию полученных строк, сохранить результаты в новые коллекции.
- [ ] Сравнить количество элементов в исходной и в десериализованной коллекциях, чтобы убедиться, что десериализация выполняется корректно.
- [ ] С помощью Java Stream API выполнить для исходных коллекций сериализацию отдельных элементов.
- [ ] Там же внутри стрима выводить получающиеся JSON-строки.
- [ ] Там же внутри стрима десериализовывать объекты из полученных JSON-строк.
- [ ] Там же внутри стрима выводить десериализованные объекты на печать, чтобы убедиться в корректности операции.
- [ ] В классах Student и University добавить аннотации @SerializedName для каждого поля, чтобы изменить названия полей в сериализованном JSON-е. Названия можно изменить на произвольные, но подходящие по смыслу.
- [ ] Убедиться в том, что сериализация/десериализация с измененными именами происходит также корректно.

Пятая часть
--
#### 27.8. Проект. Промежуточная сдача проекта (HW-02)
+ [X] Создать ещё один модельный класс Statistics (с конструктором, геттерами и сеттерами), в котором должны быть, как минимум, следующие поля: профиль обучения, средний балл за экзамен, количество студентов по профилю, количество университетов по профилю, названия университетов.
+ [X] Создать класс XlsWriter, в котором реализовать метод генерации таблицы и её записи в файл. Метод получает на вход коллекцию объектов статистики и путь к файлу.
+ [X] В методе генерации нужно реализовать с помощью Apache POI создание нового Workbook, добавить на него новую страницу. В странице заполнить заголовок с текстовыми наименованиями (то есть подписать колонки таблицы). Заголовки должны иметь настроенный стиль — как минимум, сделать всё жирным шрифтом и с указанным размером шрифта.
+ [ ] Также в этом методе реализовать заполнение строк таблицы данными, хранящимися в коллекции элементов Statistics.
+ [ ] После генерации в этом же методе файл необходимо создать (используя FileOutputStream), задав ему полученное на вход метода имя.
+ [ ] Создать утилитный класс для обработки коллекций студентов и университетов.
+ [ ] В утилитном классе необходимо реализовать метод, получающий на вход коллекции студентов и университетов, возвращающий коллекцию элементов класса Statistics.
+ [ ] С помощью Java Stream API собрать статистику. Необходимо для каждого профиля обучения, по которому есть хотя бы один университет, создать экземпляр класса Statistics. Заполнить все его поля.
+ [ ] При сборе статистики нужно учесть, что каких-то данных может не быть в исходной таблице. Например, в подготовленном ранее файле не по всем университетам есть студенты, соответственно, средняя оценка по некоторым профилям может отсутствовать. Для этого можно использовать Optional-типы, например Optional<Double> или OptionalDouble.
+ [ ] Также нужно учесть, что средняя оценка при подсчёте может иметь длинную дробную часть. Для решения этой проблемы рекомендуется использовать класс BigDecimal с его возможностями по округлению. Округление производить математически.
+ [ ] Вызвать в методе main обработку статистики, получить коллекцию с элементами статистики, передать коллекцию в метод генерации XLSX-файла.

