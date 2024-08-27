
# Создание нового рецепта

Создание новых рецептов в BreweryX довольно лёгкое. Достаточно заполнить следующие параметры:

***

## Название напитка: `name`

| Обязательно? | Значение | Дефолтное значение |
| --------- | ----- | ------------- |
|Да|`Плохое Название/Название/Хорошее название`|Нет|

Название напитка. Может отличаться в зависимости от качества напитка, если установлено вот так:

```yaml
ТестовыйНапиток:
    name: Плохой напиток/Напиток/Хороший напиток
```

Названия напитков поддерживают цветовые коды и HEX цвета:

```yaml
Разноцветный напиток:
    name: '&8Плохой напиток/Напиток/&#ffb424Хороший напиток'
```
Что удивительно - как название так и ID напитка поддерживает русский язык!

Если не хочешь делать вариации названия - поставь одно название

```yaml
ТестовыйНапиток:
    name: Напиток
```

***

## Ингредиенты: `ingredients`

| Обязательно? | Значение | Дефолтное значение |
| --------- | ----- | ------------- |
|Да|`- НазваниеПредмета/Количество`|Нет|

Это ингредиенты, нужные для варки. Принимаются такие значения:

- Название предмета из майнкрафта

- Название напитка BreweryX

- Название кастомного предмета BreweryX

- ID предмета из Itemsadder - работает только с установленным [IAOraxen Plugin](https://www.spigotmc.org/resources/iaoraxenaddon-breweryx-addon.114778/)

- ID предмета из Oraxen - работает только с установленным  [IAOraxen Plugin](https://www.spigotmc.org/resources/iaoraxenaddon-breweryx-addon.114778/)

Формат предмета выглядит вот так - `Предмет/Его количество`

Пример:

```yaml
ТестовыйНапиток:
    name: Плохой напиток/Напиток/Хороший напиток
    ingredients:
        - Apple/10 # Тебе нужно 10 яблок
        - Brewery:РазноцветныйНапиток/2 # Тебе нужно 2 РазноцветныхНапитка (из примера выше)
        - blue_flowers/2 # Тебе нужно два кастомных предмета, записанных под blue_flowers
```

***

## Время варки: `cookingtime`

| Обязательно? | Значение | Дефолтное значение |
| --------- | ----- | ------------- |
|Да|Число|Нет|

Сколько (в минутах) нужно варить напиток до идеального состояния.

```yaml
ТестовыйНапиток:
    name: Плохой напиток/Напиток/Хороший напиток
    cookingtime: 12 # 12 minutes
```

***

## Сколько раз дистиллировать: `distillruns`

| Обязательно? | Значение | Дефолтное значение |
| --------- | ----- | ------------- |
|Нет, если нет `distillruns`|Число|0|

How much times player need to distill brew

```yaml
ТестовыйНапиток:
    name: Плохой напиток/Напиток/Хороший напиток
    distillruns: 4
```

***

## Время дистилляции: `distilltime`

| Обязательно? | Значение | Дефолтное значение |
| --------- | ----- | ------------- |
|Нет|Время в секундах|0|

Сколько (по времени,в секундах) будет идти одна дистилляция

```yaml
ТестовыйНапиток:
    name: Плохой напиток/Напиток/Хороший напиток
    distilltime: 10
```

***

## Тип дерева бочки: `wood`

| Обязательно? | Значение | Дефолтное значение |
| --------- | ----- | ------------- |
|Нет|Цифра типа дерева|Нет|

Тип дерева, в котором нужно бродить напитку. Принимает такие значения:

- 0 - Любое дерево

- 1 - Берёза

- 2 - Дуб

- 3 - Джунглиевые 

- 4 - Ель

- 5 - Акация 

- 6 - Тёмный дуб 

- 7 - Багровые

- 8 - Искаженные

- 9 - Мангровые

- 10 - Вишня

- 11 - Бамбук

```yaml
ТестовыйНапиток:
    name: Плохой напиток/Напиток/Хороший напиток
    wood: 4 # Бочка из ели
```

***

## Время брожения: `age`

| Обязательно? | Значение | Дефолтное значение |
| --------- | ----- | ------------- |
|Нет|Число в игровых днях|0|

Сколько внутриигровых дней напитку нужно побродить для идеального качества.

```yaml
ТестовыйНапиток:
    name: Плохой напиток/Напиток/Хороший напиток
    age: 12 # 12 игровых дней
```

***

## Цвет напитка: `color`

| Обязательно? | Значение | Дефолтное значение |
| --------- | ----- | ------------- |
|Нет|HEX цвет или название цвета|`WHITE`|

Цвет напитка. Может быть HEX цветом или одним из `DARK_RED`, `RED`, `BRIGHT_RED`, `ORANGE`, `YELLOW`, `PINK`, `PURPLE`, `BLUE`, `CYAN`, `WATER`, `TEAL`, `OLIVE`, `GREEN`, `LIME`, `BLACK`, `GREY`, `BRIGHT_GREY`, `WHITE`

```yaml
ТестовыйНапиток:
    name: Плохой напиток/Напиток/Хороший напиток
    color: RED # Красный
    # Или...
    color: '99FF33' # Жёлтоватый такой
```

***

## Сложность напитка: `difficulty`

| Обязательно? | Значение | Дефолтное значение |
| --------- | ----- | ------------- |
|Да|Число `1` - `10`|Нет|

Насколько сильно нужно следовать рецепту, от `1` до `10`, где `1` - можно ошибаться, а `10` - ошибаться нельзя вообще.

Меньше цифра - легче напиток, и наоборот.

```yaml
ТестовыйНапиток:
    name: Плохой напиток/Напиток/Хороший напиток
    difficulty: 5
```

***

## Уровень алкоголя: `alcohol`

| Обязательно? | Значение | Дефолтное значение |
| --------- | ----- | ------------- |
|Нет|Число `0` - `100`|`0`|

Сколько алкоголя находится в напитке, от `0` до `100`, где `0` - отсутствие алкоголя, а `100` - пьяный угар

```yaml
ТестовыйНапиток:
    name: Плохой напиток/Напиток/Хороший напиток
    alcohol: 45
```

***

## Описание напитка: `lore`

| Обязательно? | Значение | Дефолтное значение |
| --------- | ----- | ------------- |
|Нет|Список|Нет|

Просто описание напитка. Может варьироваться в зависимости от качества напитка.

```yaml
ТестовыйНапиток:
    name: Плохой напиток/Напиток/Хороший напиток
    lore:
    - "Этот текст будет всегда, независимо от качества"
    - + "Этот текст будет только если у напитка плохое качество"
    - ++ "Этот текст будет только если у напитка нормальное качество"
    - +++ "Этот текст будет только если у напитка хорошее качество"
```

***

## Серверные команды: `servercommands`

| Обязательно? | Значение | Дефолтное значение |
| --------- | ----- | ------------- |
|Нет|Список|Нет|

Команды, которые будут прописаны от лица сервера при выпивании напитка. Может варьироваться в зависимости от качества напитка.

Добавив `\<число>s` в конце строчки, команда "задержится" на прописанное кол-во секунд.

```yaml
ТестовыйНапиток:
    name: Плохой напиток/Напиток/Хороший напиток
    servercommands:
    - say Эта команда пропишется независимо от всего!
    - say Эта команда пропишется через 5 секунд! \5s
    - + kill %player% # Эта команда пропишется если качество напитка плохое
    - ++ heal %player% # Эта команда пропишется если качество напитка нормальное
    - +++ op %player% # Эта команда пропишется если качество напитка хорошее. И не выдавайте ОПки кому попало =)
```

***

## Команды игрока: `playercommands`

| Обязательно? | Значение | Дефолтное значение |
| --------- | ----- | ------------- |
|Нет|Список|Нет|

Команды, которые будут прописаны от лица игрока. Может варьироваться в зависимости от качества напитка.

Добавив `\<число>s` в конце строчки, команда "задержится" на прописанное кол-во секунд.

```yaml
ТестовыйНапиток:
    name: Плохой напиток/Напиток/Хороший напиток
    playercommands:
    - me Эта команда пропишется независимо от всего!
    - me Эта команда пропишется через 5 секунд! \5s
    - + suicide # Эта команда пропишется если качество напитка плохое. Осуждаем кста
    - ++ home # Эта команда пропишется если качество напитка нормальное
    - +++ give %player% diamond 9999 # Эта команда пропишется если качество напитка хорошее. И не выдавайте ОПки кому попало =)
```

***

## Сообщение при выпивании: `drinkmessage`

| Обязательно? | Значение | Дефолтное значение |
| --------- | ----- | ------------- |
|Нет|Строка|Нет|

Сообщение, которое напишется игроку в чат после выпивания напитка.

```yaml
ТестовыйНапиток:
    name: Плохой напиток/Напиток/Хороший напиток
    drinkmessage: "ДА ТЫ В ГОВНО!"
```

***

## Title после выпивания: `drinktitle`

| Обязательно? | Значение | Дефолтное значение |
| --------- | ----- | ------------- |
|Нет|Строка|Нет|

"Title" сообщение, которое покажется игроку после выпивания напитка.

```yaml
ТестовыйНапиток:
    name: Плохой напиток/Напиток/Хороший напиток
    drinktitle: "ДА ТЫ В ГОВНО И ЭТО ТАЙТЛ!"
```

***

## Эффект зачарования: `glint`

| Обязательно? | Значение | Дефолтное значение |
| --------- | ----- | ------------- |
|Нет|Булевое значение `true` или `false`|Нет|

Добавлять ли напитку эффект зачарования.

```yaml
ТестовыйНапиток:
    name: Плохой напиток/Напиток/Хороший напиток
    glint: true
```

***

## CMD предмета: `customModelData`

| Обязательно? | Значение | Дефолтное значение |
| --------- | ----- | ------------- |
|Нет|`Плохое CMD/CMD/Хорошее CMD`|Нет|

Custom model data напитка. Может варьироваться в зависимости от качества напитка - Плохое/Нормальное/Хорошее

```yaml
ТестовыйНапиток:
    name: Плохой напиток/Напиток/Хороший напиток
    customModelData: 1337/1338/1339
```

***

## Эффекты: `effects`

| Обязательно? | Значение | Дефолтное значение |
| --------- | ----- | ------------- |
|Нет|`НАЗВАНИЕ_ЭФФЕКТА/УРОВЕНЬ/ПРОДОЛЖИТЕЛЬНОСТЬ`|Нет|

Эффекты, которые будут даны игроку после употребления алкоголя.

Возможные эффекты: <https://hub.spigotmc.org/javadocs/spigot/org/bukkit/potion/PotionEffectType.html>

Уровни или диапазоны длительности могут быть указаны через "-", например, `SPEED/1-2/30-40` - в худшем случае 1 уровень и 30 секунд, а в лучшем случае 2 уровня и 40 секунд.

Диапазоны также работают от высокого до низкого, например, `POISON/3-1/20-5` для погодных эффектов с хорошим качеством.

Максимально возможная продолжительность: 1638 секунд. Для мгновенных эффектов не требуется указывать продолжительность.

```yaml
ТестовыйНапиток:
    name: Плохой напиток/Напиток/Хороший напиток
    effects:
      - FIRE_RESISTANCE/20 # Эффект огнеупорности, выдаётся всегда
      - WEAKNESS/3-1/50-10 # Эффект слабости, лучше напиток - ниже уровень эффекта и его время действия
      - REGENERATION/1-3/10-50 # И наоборот
```

***

## Примеры

```yaml
  g_vodka:
    name: 'Такая себе водка/&6Золотая водка/&6Сияюще-золотая водка'
    ingredients:
      - Potato/10
      - Gold_Nugget/2
    cookingtime: 18
    distillruns: 3
    age: 0
    color: ORANGE
    difficulty: 6
    alcohol: 20
    effects:
      - WEAKNESS/28
      - POISON/4

  whiskey:
    name: Скотч/Виски/&6Виски
    ingredients:
      - Wheat/10
      - Blaze_Powder/2
    cookingtime: 12
    distillruns: 3
    distilltime: 55
    wood: 4
    age: 18
    color: ORANGE
    difficulty: 7
    alcohol: 28
    drinkmessage: 'Ух, хороша!'
```