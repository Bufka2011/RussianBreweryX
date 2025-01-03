---
description: Конфигурация по-умолчанию в BreweryX
---


# Конфигурация по-умолчанию

Это - дефолтный конфиг на Английском языке, переведённый на Русский:

```yaml  title="config.yml"
# Конфиг для BreweryX.
#   Гайд по конфигурации можно найти здесь: http://brewery.lumamc.net/ru/guide/edit_config/
#   Остались вопросы? Задайте их в официальном Discord-сервере: https://discord.gg/ZTGCzeKg45

# Версия конфига. Не меняйте, если не знаете, что делаете
version: '3.1'


# -- Настройки --
# Значения по умолчанию написаны в []

# -- Хранение данных --
storage:
  # Определяет, какой метод хранения данных использовать [FlatFile]
  # Возможные варианты: FlatFile, MySQL, SQLite
  # Подробнее о вариантах - в гайде по ссылке вверху файла
  type: FlatFile
  # Название базы данных. Если база данных - файл, то таким будет название этого файла [brewery-data]
  database: brewery-data
  tablePrefix: brewery_
  address: localhost
  username: root
  password: ''

# Какой файл локализации использовать (локализации лежат в: plugins/BreweryX/languages)
language: ru

# Включить ли проверку обновлений. Проверяет API CurseForge на предмет обновлений для BreweryX [true]
# Если обнаружено новое обновление, администраторы получат об этом сообщение при входе в игру
updateCheck: true

# Период автосохранения данных (в минутах) [3]
autosave: 3

# Отображать ли отладочные сообщения в логах и в консоли [false]
debug: false

# Префикс плагина, используемый в сообщениях.
# Как и большинство текстов плагина, поддерживает HEX-цвета (пример: &#FFFFFF - белый цвет) ['&2[BreweryX]&f ']
pluginPrefix: '&2[BreweryX]&f '

# Должен ли игрок просыпаться на своей точке дома при заходе на сервер после сильной пьянки [true]
enableHome: true

# Тип телепортации домой
#   bed = Игрок просто появится у своей кровати-спавнпоинта
#   'cmd: home' = /home будет выполнено от имени игрока. Необходимы соответствующие разрешения у игрока, а также отсутствие задержки у команды!
#   'cmd: spawn' = /spawn будет выполнено от имени игрока.
#   'cmd: choUgodno' = /choUgodno будет выполнено от имени игрока.
# Дефолтное значение: ['cmd: home']
homeType: 'cmd: home'

# Должен ли игрок просыпаться в одной из "точек пробуждения" при заходе на сервер после пьянки (точки пробуждения настраиваются админом через '/brew Wakeup add') [true]
# Из всех точек пробуждения выбираются две случайные, после чего игрок появляется на ближайшей из них
enableWake: true

# Должен ли игрок несколько раз пытаться залогиниться, если он пьян [true]
enableLoginDisallow: true

# Должен ли игрок терять сознание (кикаться с сервера), если достиг максимума опьянения [false]
enableKickOnOverdrink: false

# Должен ли игрок блевать при высоком опьянении (выбрасываемые предметы указываются ниже) [true]
# Выблёвываемый предмет не может быть собран и остается на земле, пока не задеспавнится
# (В целом импакт на производительность очень низкий)
enablePuke: true

# Какими предметами должен блевать игрок [Soul_Sand]
# Поддерживается несколько вариантов, например: [Sould_sand, Slime_block, Dirt]
pukeItem: [Soul_Sand]

# Время, в секундах, после которого исчезает блевотина [60]
# Если время деспавна выброшенных предметов (ванильно  300с) изменится в spigot.yml, то pukeDespawntime тоже изменится!
# Прим.пер.: Для крупных (100+ онлайна) серверов советую уменьшить значение до 30, потому что при больших пьянках...
# ...такое количество предметов может вызвать падение FPS
pukeDespawntime: 60

# Насколько сильно игрока шатает (в процентах) в зависимости от того, сколько он выпил. Значения выше 100, или же ноль, тоже допустимы [100]
stumblePercent: 100

# Отображать ли игроку его опьянение после того, как он выпьет, или съест drainItem [true]
showStatusOnDrink: true

# Список отрезвляющей пищи и то, сколько процентов опьянения она снимает. [ID/Число]
drainItems:
  - Bread/4
  - Milk_Bucket/2

# Отображать ли частицы над котлом, если в нем что-то варится [true]
# Изменяемый цвет частиц (настраивается ниже) может быть полезной подсказкой для тайминга рецептов.
enableCauldronParticles: true
# Нужно ли минимизировать количество частиц над котлом [false]
minimalParticles: false

# Включены ли крафт и использование стола для запечатывания (2 бутылки поверх 4 досок в верстаке) [true, true]
# Прим.пер.: Запечатывание используется, чтобы заблокировать дальнейшее настаивание или дистилляцию для напитка, благодаря чему его можно будет безопасно хранить в бочках
craftSealingTable: true
enableSealingTable: true

# Всегда ли отображать 1-5 звезд, в зависимости от качества, в описании напитка. Если false, то звезды будут видны только при настаивании или дистилляции [true]
alwaysShowQuality: true

# Всегда ли отображать алкогольность напитка. Если false, то алкогольность будет отображаться только в зельеварке [false]
alwaysShowAlc: false

# Отображать ли имя того, кто сварил напиток. На момент версии 3.3.3, работает только с напитками, требующими лишь варку в котле. Скорее всего, баг [false]
showBrewer: false

# Обязательно ли на табличке наличие слова barrel (или бочка), чтобы бочка могла быть создана [true]
requireKeywordOnSigns: true

# Включено ли настаивание в ванильных майнкрафтовских бочках [true], и сколько бутылок можно в них положить [6]
ageInMCBarrels: true
maxBrewsInMCBarrels: 6

# Сколько длится 1 "год" (в минутах) во время настаивания напитков. 1 игровой день = 20 минут [20]
agingYearDuration: 20


# Использованные ингредиенты и прочие данные сохраняются прямо в напиток посредством НБТ-данных.
# Чтобы защитить эти данные от читеров, их можно зашифровать.
# Это быстрый процесс, который не позволит игрокам узнать, какой у напитка рецепт, как только этот напиток попадет к ним в руки.
#
# Важно: для использования тех же предметов-напитков/мира на другом сервере, в его конфиге должен быть указан такой же encodeKey.
# Если используете напитки на нескольких серверах (BungeeCord), укажите общую базу данных внизу, в 'multiServerDB' (оно находится далеко внизу, ctrl+f)
#
# Включайте это, если хотите не позволить читерить рецепты, однако не делитесь напитками посредством скачивания карты/схематик построек с напитками [false]
#
#   Прим.пер.: Скорее всего, эта функция создавалась для старых версий, в которых такое действительно было возможно(поддержка версий <1.14 плагином, кстати, скоро будет прекращена).
#   Насколько я знаю, нынче клиент чисто физически не получает от сервера никакие нбт-данные предмета, кроме косметических (цвет зелья, лор, название, customModelData, ...)
#   (по крайней мере, у меня не получалось на ванильном paper 1.18.2 увидеть какие-то стоящие данные предмета, не будучи оператором с доступом к командам сервера)
#   Поэтому вряд ли вам понадобится эта функция.
#   Прим.Пер.№2: Я только что проверил: неважно, включена эта функция или выключена, нбт-данные никак не изменяются.
#   Скорее всего, эта функция теперь включена нативно в плагин, но вырезать её из конфига забыли?
enableEncode: false
encodeKey: 0


# -- Кастомные предметы --
# Здесь можно указать "айдишники" для кастомных ингредиентов и настроить условия, при которых они считаются таковыми
# Прим.пер.: ни один из параметров не является обязательным, но хотя бы один должен присутствовать
# Прим.пер.№2: в этой категории вы лишь "указываете" плагину, при каких условиях какой-то предмет считается таким-то кастом итемом при попадании в котел.
# А над тем, как именно получать предметы с такими параметрами, вы должны подумать сами, способ их получения игроками - целиком на вас.

# Возможные параметры кастом итемов:
# matchAny:
#   если true, то достаточно, чтобы значение ЛЮБОГО из остальных параметров предмета (материал, название, лор, customModelData) 
#   совпадало с указанным в кастом итеме для того, чтобы кидаемый в котел предмет засчитался за соответствующий кастом итем.
#   если false, то необходимо, чтобы значение КАЖДОГО из остальных параметров предмета (материал, название, лор, customModelData)
#   совпадало с указанным в кастом итеме для того, чтобы кидаемый в котел предмет засчитался за соответствующий кастом итем.
#
# material: Майнкрафтовский айдишник кастом итема (например, potato)
#
# name: Какое название должно быть у предмета (если указан цвет (например, &6 или &#<hex>), то тогда необходимо, чтобы цвет в предмете тоже совпадал с указанным для засчитывания в качестве кастом итема)
#
# lore: Какой лор должен быть у предмета. Поддерживает цвета так же, как и name (↑)
#
# customModelData: Какой номер Custom Model Data, который должен быть у предмета. Вписывать в формате списка (см. пример)
customItems:
  # Три примера
  ex-item:
    # Барьер, который называется 'Граница матрицы' и имеет в лоре указанный текст
    material: Barrier
    name: 'Граница матрицы'
    lore:
      - '&7Они наблюдают'

  ex-item2:
    # здесь у нас включен matchAny, поэтому если любой их параметров совпадет, то предмет будет засчитан за этот кастом итем при добавлении в котел
    # В данном случае, предмет должен либо являться акациевой/дубовой/еловой дверью, либо иметь название Выломанная дверь, либо описание '&cЗапили меня'(Обязательно с таким же цветовым кодом)
    matchAny: true
    material:
      - Acacia_Door
      - Oak_Door
      - Spruce_Door
    name:
      - 'Выломанная дверь'
    lore:
      - '&cЗапили меня'

  rasp:
    name: '&cЯ не помню, что такое распберри'

# пример использования customModelData. Если у бумаги есть нбт-тег customModelData со значением 10234 или 30334, то она засчитается за этот кастомный предмет
  modelitem:
    material: paper
    customModelData:
      - 10234
      - 30334

# если предмет является либо васильком, либо синей орхидеей, то он подойдет.
# кстати, если в рецепте указано например 5 таких блю-флаверов, то не получится накидать туда и васильков, и орхидей. Либо 5 одного, либо 5 другого.
  blue-flowers:
    matchAny: true
    material:
      - cornflower
      - blue_orchid




# -- Ингредиенты для котла --
# (я зову этот раздел недовары)

# Раздел определяет, какие ингредиенты принимаются в котел даже если для них нет никакого рецепта, и какое из них получится базовое зелье (недовар)
# Если ингредиент уже указан в каком-либо рецепте в разделе рецептов (или же в кастомных ингредиентах), то тогда его необязательно вписывать сюда,
# кроме случаев, когда вы хотите изменить дизайн недовара для тех или иных ингредиентов.

# name: Название недовара (Поддерживает цвета: &6, &#AABBCC )
#
# ingredients: ингредиенты и их число(опицонально), из которых получается недовар. Пример: Potato/3
#   Используйте /brew ItemName с предметом в руке, чтобы получить его айдишник для конфига 
#   (как правило, соответствует майнкрафтовскому айдишнику, отличаться могут у предметов из других плагинов, поддержка которых есть в BreweryX)
#
# color: цвет зелья-недовара. Дефолтное значение - CYAN.
#   Возможные значения: DARK_RED, RED, BRIGHT_RED, ORANGE, YELLOW, PINK, PURPLE, BLUE, CYAN, WATER, TEAL, OLIVE, GREEN, LIME, BLACK, GREY, BRIGHT_GREY, WHITE
#   Или RGB-цвета (hex: например, '99FF33') (обязательно в '')
#
# cookParticles:
#   Цвет частиц над котлом и время, в которое эти частицы меняют цвет
#   Например, если у нас указано RED/8 и 'ffffff/18', то через 8 минут после добавления ингредиентов частицы над котлом (изначально голубые) станут красными и останутся такими до тех пор,
#   пока не пройдет 18 минут с момента добавления ингредиентов. В этот момент они быстро из красного цвета перетекут в белый (ffffff - белый цвет),
#   и через несколько секунд, если больше никакие цвета не указаны, станут серыми.
#   Подсказка: если хотите, чтобы цвет был постоянно, а не перетекал в серый, то придется указать в конце прошлый цвет второй раз с большим количеством минут.
#   Например: BLUE/3, RED/10, RED/60
#   Синий через три минуты, красный через 10 и красный-серый через 60. Поскольку вряд ли кто-то будет что-то варить 60 минут, 
#   можно сказать, что красный цвет останется навсегда, пусть на самом деле и не навсегда =)
#
# lore: List of additional text on the base potion. (Formatting codes possible: such as &6 or hex as #&<hex>) описание, которое будет у зелья-недовара. Поддерживает цвета: &a или rgb &#AABBCC
#
# customModelData: Custom Model Data, которая будет наложена на зелье-недовар

cauldron:
  # пример со всеми возможными параметрами
  ex:
    name: Пример Недовара
    ingredients:
      - Bedrock/2
      - Diamond  # Этот недовар получится, если вы сварите 2 бедрока и алмаз
    color: BLACK # черный цвет зелья
    cookParticles:
      - 'RED/5' #красные частицы через 5 минут
      - 'WHITE/10' #быстро перетекают в белый через еще 5 минут (10 всего)
      - '800000/25' #быстро перетекают в темно-красный через еще 15 мин, потом в серый
    lore:
      - An example for a Base Potion
      - This is how it comes out of a Cauldron
    customModelData: 545

  # -- One Ingredient: --
  wheat:
    name: Ферментированное пшено
    ingredients: Wheat
    cookParticles:
      - '2d8686/8' # Dark Aqua

  sugarcane:
    name: Сахарное варево
    ingredients: Sugar_Cane
    color: 'f1ffad' # yellowish green
    cookParticles:
      - 'f1ffad/4'
      - '858547/10' # dark olive

  sugar:
    name: Сладкая вода
    ingredients: Sugar
    cookParticles:
      - 'WHITE/4'
      - 'BRIGHT_GREY/25'

  apple:
    name: Яблочное сусло
    ingredients: Apple

  berries:
    name: Виноградное сусло
    ingredients: Sweet_Berries
    color: RED
    cookParticles:
      - 'ff6666/2' # bright red
      - 'RED/7'
      - 'ac6553/13' # brown-red

  potato:
    name: Картофельное месиво
    ingredients: Potato

  grass:
    name: Вареные травы
    ingredients: Grass
    color: '99ff66' # bright green
    cookParticles:
      - 'GREEN/2'
      - '99ff99/20' # faded green

  rmushroom:
    name: Грибное варево
    ingredients: Red_Mushroom
    color: 'ff5c33' # amber red
    cookParticles:
      - 'fab09e/15' # faded red

  bmushroom:
    name: Грибное варево
    ingredients: Brown_Mushroom
    color: 'c68c53' # brighter brown
    cookParticles:
      - 'c68c53/15'

  cocoa:
    name: Шоколадная вода
    ingredients: Cocoa_Beans
    color: '804600' # mocca
    cookParticles:
      - 'a26011/1'
      - '5c370a/3'
      - '4d4133/8' # Gray-brown

  milk:
    name: Молочная вода
    ingredients: Milk_Bucket
    color: BRIGHT_GREY
    cookParticles:
      - 'fbfbd0/1' # yellow-white
      - 'WHITE/6'

  bl_flow:
    name: Синие цветочки
    ingredients: blue-flowers # Да-да, поддерживает кастомные ингредиенты
    color: '0099ff' # sky blue
    cookParticles:
      - '0099ff'

  cactus:
    name: Кактусовое варево
    ingredients: cactus
    color: '00b300' # cactus green
    cookParticles:
      - '00b300/16'

  poi_potato:
    name: Ядовитый Бульон
    ingredients: Poisonous_Potato

  egg:
    name: Липкое варево
    ingredients: Egg


  oak_sapling:
    name: Волокнистый травяной бульон
    ingredients: Oak_Sapling

  vine:
    name: Вареные травы
    ingredients: vine
    color: '99ff66' # bright green
    cookParticles:
      - 'GREEN/2'
      - '99ff99/20' # faded green

  rot_flesh:
    name: Нечистая гадость
    ingredients: Rotten_Flesh
    color: '263300' # brown green
    cookParticles:
      - '263300/8'
      - 'BLACK/20'

  melon:
    name: Сок арбуза
    ingredients: melon_slice

  wheat_seeds:
    name: Горькое варево
    ingredients: Wheat_Seeds

  melon_seeds:
    name: Горькое варево
    ingredients: Melon_Seeds

  pumpkin_seeds:
    name: Горькое варево
    ingredients: Pumpkin_Seeds

  bone_meal:
    name: Костяной клей
    ingredients: bone_meal
    color: BRIGHT_GREY

  cookie:
    name: Шоколадная вода
    ingredients: Cookie
    color: '804600' # mocca
    cookParticles:
      - 'a26011/1'
      - '5c370a/3'
      - '4d4133/8' # Gray-brown

  fer_spid_eye:
    name: Ферментированный глаз
    ingredients: Fermented_Spider_Eye

  ghast_tear:
    name: Соленое варево
    ingredients: ghast_tear

  snowball:
    name: Холодная вода
    ingredients: Snowball

  Gold_Nugget:
    name: Блестящее варево
    ingredients: Gold_Nugget
    color: 'ffd11a' # gold
    cookParticles:
      - 'ffd11a'

  glowstone_dust:
    name: Светящееся варево
    ingredients: Glowstone_Dust
    color: 'ffff33' # bright yellow
    cookParticles:
      - 'ffff99/3'
      - 'd9d926/15' # faded yellow

  # -- Multiple Ingredients: --
  applemead_base:
    name: Яблочный сироп
    ingredients:
      - Sugar_Cane/3
      - Apple
    color: 'e1ff4d' # greenish yellow
    cookParticles:
      - 'e1ff4d/4'

  poi_grass:
    name: Ядовитые травы
    ingredients:
      - Grass
      - Poisonous_Potato
    color: '99ff66' # bright green
    cookParticles:
      - 'GREEN/2'
      - '99ff99/20' # faded green

  juniper: #чё, какой можжевельник...
    name: Синее варево
    ingredients:
      - blue-flowers
      - wheat
    color: '00ccff' # aqua
    cookParticles:
      - '00ccff/8'

  gin_base:
    name: Фруктовое синее варево
    ingredients:
      - blue-flowers
      - wheat
      - apple
    color: '66e0ff' # lighter aqua
    cookParticles:
      - '00ccff/5'

  eggnog_base:
    name: Основа для Эгг-нога
    ingredients:
      - egg
      - sugar
      - milk_bucket
    color: 'ffecb3' # yellow-orange
    cookParticles:
      - 'ffecb3/2'



# -- Рецепты напитков--

# Удобный и локализованный гайд на этот раздел можно найти по ссылке - https://brewery.lumamc.net/guide/recipies/

# name: Имя, ИЛИ три различных имени для плохого/среднего/хорошего качества напитка (Поддерживает цвет: &6 или hex - &#123123)
#   пример: name: 'Плохое пиво/Среднее пиво/&6&lПИЗДАТОЕ ПИВО'
#
# ingredients: 'ID/Количество'
#   https://hub.spigotmc.org/javadocs/spigot/org/bukkit/Material.html
#   Вещи из других плагинов вписывать с префиксом: 'plugin:id/кол-во' (Сейчас поддерживаются Brewery, Oraxen, ItemsAdder)
#   Кастом итемы вписывать, добавив просто их название, без префикса (Например, vinograd/10)
#   Также можно использовать одни напитки в качестве ингредиентов, для других. Формат выглядит вот так: 'brewery:Название(не ID)/число'
#   Например: 'brewery:Среднее пиво/1'
#
# cookingtime: Время, в минутах, которое ингредиенты должны вариться в котле.
#
# distillruns: Сколько кругов дистилляции на зельеварке напиток должен пройти.
#
# distilltime: Сколько секунд занимает один круг дистилляции (Время по умолчанию - 40 сек. Дефолтное время для ванильных зелий - 20 сек)
#
# wood: Из какого дерева должна быть бочка: 0=Любое 1=Береза 2=Дуб 3=Тропическое 4=Ель 5=Акация 6=Темный дуб 7=Багровое 8=Искаженное 9=Мангровое 10=Вишневое 11=Бамбуковое 12=Резная Медь
#   Если включено настаивание в ванильных майнкрафтовских бочках, то они считаются за дубовые.
#
# age: Сколько "лет" напиток должен настояться в бочке.
#
# color: Цвет готового зелья
#   Возможные цвета: DARK_RED, RED, BRIGHT_RED, ORANGE, YELLOW, PINK, PURPLE, BLUE, CYAN, WATER, TEAL, OLIVE, GREEN, LIME, BLACK, GREY, BRIGHT_GREY, WHITE
#   Или RGB-цвета (hex: '99FF33') (обязательно в '')
#
# difficulty: Сложность напитка. Чем выше - тем более точно нужно будет следовать рецепту, чтобы напиток получился 5-звездным
#
# alcohol: Количество опьянения, которое добавляется при употреблении (до 100, поддерживаются отрицательные значения)
#
# lore: Описание готового напитка (Поддерживает цвет: &6, или &#AABBCC)
#   при помощи плюсов можно указать разное описание для разных кровней качества: + bad, ++ normal, +++ good.
#   - +++ Крутейшее пойло.
#   - ++ Ну такое...
#   - + Эх щас бы сливок на соски себе намазать...
#
# servercommands: Команды, выполняемые СЕРВЕРОМ при употреблении (Плейсхолдеры: %player_name%  %quality%)
#   Как и описания, поддерживает различные уровни качества: + bad, ++ normal, +++ good.
#   - +++ op %player_name%
#   - ++ money give %player_name% 10
#   - + essentials:heal %player_name% 
#  Команды могут быть отложены, если добавить "/ <число>s" в конце:
#   - op Jsinco / 3s
# Вместо s можно использовать m или h
#
# playercommands: Команды, выполняемые ИГРОКОМ при употреблении (Плейсхолдеры: %player_name%  %quality%)
#   Как и описания, поддерживает различные уровни качества: + bad, ++ normal, +++ good.
#   - +++ spawn
#   - ++ home
#   - + suicide
#  Команды могут быть отложены, если добавить "/ <число>s" в конце:
#   - op Jsinco / 3s
# Вместо s можно использовать m или h
#
# drinkmessage: Сообщение в чате, которое показывается игроку при употреблении.
#
# drinktitle: Сообщение на экране, которое показывается при употреблении
#
# glint: true/false - должен ли готовый напиток сиять как зачарованный предмет
#
# customModelData: номер Custom Model Data.
#   Можно указать один, а можно сразу для всех уровней качества:
#   customModelData: 1
#   customModelData: 1/2/3
#
# effects: ID/уровень/длительность. Эффект, который накладывается при выпивании.
#   Айдишники эффектов: https://hub.spigotmc.org/javadocs/spigot/org/bukkit/potion/PotionEffectType.html
#   ВАЖНО!!! Если ваша версия ниже 1.20.5, то некоторые эффекты у вас будут иметь другие ID, а не те, что по ссылке выше. Таков костыль Спигота, присутствовавший до 1.20.5:
#   Мгновенный урон HARM, лечение HEAL, тошнота CONFUSION, медлительность SLOW, прыгучесть JUMP, спешка FAST_DIGGING, сила INCREASE_DAMAGE. Наверно, ничего не забыл
#   Уровень и длительность эффекта поддерживают разброс в зависимости от качества приготовления при помощи "-",
#   например: 'SPEED/1-2/30-40' = Скорость I на 30 сек. при худшем качестве и Скорость II на 40 сек. при лучшем качестве.
#   Разброс может быть и в обратную сторону: 'POISON/3-1/20-5' = менее сильное отравление при высоком качестве.
#   Максимальная длительность - 1638 секунд. Мгновенным эффектам, по типу Лечения, необязательно указывать длительность.

recipes:
  #  Пример со всеми возможными параметрами:
  ex:
    name: Bad Example/Example/Good Example
    ingredients:
      - Diamond/1
      - Spruce_Planks/8
      - Bedrock/1
      - Brewery:Пшеничное пиво/2
#      - Oraxen:Grape/3
      - ex-item/4
    cookingtime: 3
    distillruns: 2
    distilltime: 60
    wood: 4
    age: 11
    color: DARK_RED
    difficulty: 3
    alcohol: 14
    lore:
      - This is an examble brew
      - ++Just a normal Example
      - This text would be on the brew
      - + Smells disgusting
      - ++ Smells alright
      - +++ Smells really good
    servercommands:
      - +++ weather clear
      - + weather rain
    playercommands:
      - homes
    drinkmessage: Tastes good
    drinktitle: Warms you from inside
    glint: true
    customModelData: 556/557/557
    effects:
      - FIRE_RESISTANCE/20
      - HEAL/1
      - WEAKNESS/2-3/50-60
      - POISON/1-0/20-0

  wheatbeer:
    name: Вонючее пшеничное пиво/Пшеничное пиво/Хорошее пшеничное пиво
    ingredients:
      - Wheat/3
    cookingtime: 8
    wood: 1
    age: 2
    color: 'ffb84d' # Orange
    difficulty: 1
    alcohol: 5
    lore: +++ &8Пей пиво пенное, будет рожа оху...

  beer:
    name: Вонючее пиво/Пиво/Хорошее пиво
    ingredients:
      - Wheat/6
    cookingtime: 8
    wood: 0
    age: 3
    color: 'ffd333' # Bright Orange
    difficulty: 1
    lore:
      - +++ &8Освежает
    alcohol: 6

  darkbeer:
    name: Вонючее темное пиво/Темное пиво/Хорошее темное пиво
    ingredients:
      - Wheat/6
    cookingtime: 8
    distillruns: 0
    wood: 6
    age: 8
    color: '650013' # Dark Red-Brown
    difficulty: 2
    lore:
      - +++ &8Крепкий вкус
    alcohol: 7

  wine:
    name: Красное вино
    ingredients:
      - Sweet_Berries/5
    cookingtime: 5
    distillruns: 0
    wood: 0
    age: 20
    color: RED
    difficulty: 4
    alcohol: 8
    lore:
      - '+ &8Кислятина'
      - '++ &8Мягкий вкус'
      - '+++ &8Насыщенный вкус'

  mead:
    name: Неудавшаяся медовуха/Медовуха/&6Золотая медовуха
    ingredients:
      - Sugar_Cane/6
    cookingtime: 3
    distillruns: 0
    wood: 2
    age: 4
    color: ORANGE
    difficulty: 2
    lore:
      - +++ Золотистая...
    alcohol: 9

  ap_mead:
    name: Засахаренные яблоки/Яблочный Мёд/&6Золотистый яблочный мёд
    ingredients:
      - Sugar_Cane/6
      - Apple/2
    cookingtime: 4
    distillruns: 0
    wood: 2
    age: 4
    color: ORANGE
    difficulty: 4
    alcohol: 11
    lore:
      - + Приторно
      - ++ Освежающе
      - +++ Волшебный напиток, который сочетает в себе сладость меда и яркие ноты спелых яблок. При первом глотке ощущается нежная сладость, плавно переходящая в легкую кислинку, подчеркивающую фруктовый характер. Аромат меда гармонично обвивает фруктовую базу, создавая уютное и теплое послевкусие. Ноты свежих, сочных яблок придают напитку свежесть, а в сочетании с легкими древесными и пряными оттенками создается удивительное разнообразие вкусовых ощущений. Каждый глоток ощущается, как обнимание летним днем, оставляя за собой легкое послевкусие, которое манит к следующим путешествиям по миру яблочной сладости. # хехехе
    effects:
      - WATER_BREATHING/1-2/150

  cidre:
    name: Кислый сидр/Сидр/Яблочный сидр
    ingredients:
      - Apple/14
    cookingtime: 7
    distillruns: 0
    wood: 0
    age: 3
    color: 'f86820' # Red-Orange
    difficulty: 4
    alcohol: 7

  apple_liquor:
    name: Кислый яблочный ликер/Яблочный ликер/Calvados
    ingredients:
      - Apple/12
    cookingtime: 16
    distillruns: 3
    wood: 5
    age: 6
    color: BRIGHT_RED
    difficulty: 5
    alcohol: 14
    lore:
      - + Ужасная кислятина
      - +++ Знаменитый яблочный ликер

  whiskey:
    name: Невзрачный виски/Виски/Шотландский виски
    ingredients:
      - Wheat/10
    cookingtime: 10
    distillruns: 2
    distilltime: 50
    wood: 4
    age: 18
    color: ORANGE
    difficulty: 7
    alcohol: 26
    lore: '&7Односолодовый'

  rum:
    name: Горький ром/Ром/&6Пиратский ром
    ingredients:
      - Sugar_Cane/18
    cookingtime: 6
    distillruns: 2
    distilltime: 30
    wood: 2
    age: 14
    color: DARK_RED
    difficulty: 6
    alcohol: 30
    effects:
      - FIRE_RESISTANCE/1/20-100
      - POISON/1-0/30-0
    lore:
      - + &8Слишком горький
      - ++ &8Пряный вкус
      - +++ &eТвой проводник к рутрекеру

  vodka:
    name: Палёная водка/Водка/Русская водка
    ingredients:
      - Potato/10
    cookingtime: 15
    distillruns: 3
    age: 0
    color: WHITE
    difficulty: 4
    alcohol: 20
    lore: + &8 На свой страх и риск...
    effects:
      - WEAKNESS/15
      - POISON/10

  shroom_vodka:
    name: Грибная водка/Грибная водка/Светящаяся грибная водка
    ingredients:
      - Potato/10
      - Red_Mushroom/3
      - Brown_Mushroom/3
    cookingtime: 18
    distillruns: 5
    age: 0
    color: 'ff9999' # Pink-Red
    difficulty: 7
    alcohol: 18
    lore: +++&aСветится в темноте
    effects:
      - WEAKNESS/80
      - CONFUSION/27
      - NIGHT_VISION/50-80
      - BLINDNESS/12-2
      - SLOW/10-3

  gin:
    name: Мутный джин/Джин/Джин Old Tom
    ingredients:
      - Wheat/9
      - blue-flowers/6  # Custom-Item: Blue Orchids or Cornflowers
      - Apple/1
    cookingtime: 6
    distillruns: 2
    color: '99ddff' # Very light blue
    difficulty: 6
    alcohol: 20
    lore:
      - Со вкусом можжевельника

  tequila:
    name: Мескаль/Текила/Текила Anejo #автору плагина явно мескаль не понравился
    ingredients:
      - cactus/8
    cookingtime: 15
    distillruns: 2
    color: 'f5f07e' # Green-Orange
    difficulty: 5
    wood: 1
    age: 12
    alcohol: 20
    lore: Дух пустыни

  absinthe:
    name: Плохой абсент/Абсент/Крепкий абсент
    ingredients:
      - Grass/15
    cookingtime: 3
    distillruns: 6
    distilltime: 80
    color: GREEN
    difficulty: 8
    alcohol: 42
    effects:
      - POISON/15-25
    lore: '+++&8Абсент, напиток художников'

  gr_absinthe:
    name: Плохой абсент/Зеленый абсент/Хороший зеленый абсент
    ingredients:
      - Grass/17
      - Poisonous_Potato/2
    cookingtime: 5
    distillruns: 6
    distilltime: 85
    color: LIME
    difficulty: 9
    alcohol: 46
    effects:
      - POISON/25-40
      - HARM/2
      - NIGHT_VISION/40-60
    lore: '&aНе ядовито ли?'

  potato_soup:
    name: Картофельный суп
    ingredients:
      - Potato/5
      - Grass/3
    cookingtime: 3
    color: ORANGE
    difficulty: 1
    effects:
      - HEAL/0-1

  coffee:
    name: Несвежий кофе/Кофе/Крепкий кофе
    ingredients:
      - Cocoa_Beans/12
      - Milk_Bucket/2
    cookingtime: 2
    color: BLACK
    difficulty: 3
    alcohol: -6
    lore: + &8Ему, наверно, уже неделя...
    effects:
      - REGENERATION/1/2-5
      - SPEED/1/30-140

  eggnog:
    name: Яичный Ликер/Эгг-ног/Advocaat
    ingredients:
      - Egg/5
      - Sugar/2
      - Milk_Bucket/1
    cookingtime: 2
    color: 'ffe680'
    difficulty: 4
    alcohol: 10
    wood: 0
    age: 3
    lore: Приготовлено при помощи яиц




# Другие рецепты, предлагаемые оригинальным автором (не переведено):

  # g_vodka:
  #   name: 'Rancid Vodka/&6Golden Vodka/&6Shimmering Golden Vodka'
  #   ingredients:
  #     - Potato/10
  #     - Gold_Nugget/2
  #   cookingtime: 18
  #   distillruns: 3
  #   age: 0
  #   color: ORANGE
  #   difficulty: 6
  #   alcohol: 20
  #   effects:
  #     - WEAKNESS/28
  #     - POISON/4

  # fire_whiskey:
  #   name: Powdery Whiskey/Burning Whiskey/Blazing Whiskey
  #   ingredients:
  #     - Wheat/10
  #     - Blaze_Powder/2
  #   cookingtime: 12
  #   distillruns: 3
  #   distilltime: 55
  #   wood: 4
  #   age: 18
  #   color: ORANGE
  #   difficulty: 7
  #   alcohol: 28
  #   drinkmessage: 'You get a burning feeling in your mouth'

# Without Alcohol:

  # hot_choc:
  #   name: Hot Chocolate
  #   ingredients:
  #     - cookie/3
  #   cookingtime: 2
  #   color: DARK_RED
  #   difficulty: 2
  #   effects:
  #     - FAST_DIGGING/40

  # iced_coffee:
  #   name: Watery Coffee/Iced Coffee/Strong Iced Coffee
  #   ingredients:
  #     - cookie/8
  #     - snowball/4
  #     - milk_bucket/1
  #   cookingtime: 1
  #   color: BLACK
  #   difficulty: 4
  #   alcohol: -8
  #   effects:
  #     - REGENERATION/30
  #     - SPEED/10


# More Recipe ideas:
# Dandelion Liquor
# Beetroot Spirit,
# Poppy Liquor: Macum/Grand Poppy,
# Bamboo Liquor: Chu Yeh Ching,
# Cachaca,
# Cognac,
# Sake,
# Buorbon,
# Moonshine,
# Different Wines,
# Brandy,
# Amaretto,
# etc. as well as variations like,
# Pumpkin Spice Beer,
# Melon Vodka
# There are a lot of items in Minecraft like Vines, Milk and items added by plugins that would make great ingredients.


# -- Совместимость --

# Должны ли бочки учитывать приваты разных плагинов [true]
useWorldGuard: true
useLWC: true
useGriefPrevention: true
useTowny: true
useBlockLocker: true
useGMInventories: true

# Использовать ли "виртуальный сундук при открывании бочек".
# Могут возникнуть проблемы при использовании античита.
# Используйте с плагином 'Residence' и прочими плагинами, которые не просчитывают все варианты в playerInteractEvent
useVirtualChestPerms: false


# Логгировать ли бочки в LogBlock [true]
useLogBlock: true


# -- Прочие настройки --

# Можно ли добавлять в котел также вещи из второй руки [false]
useOffhandForCauldron: false

# Должны ли данные бочек и котлов загружаться ассинхронно [true]
loadDataAsync: true

# Количество дней, в течение которых данные об опьянении игрока остаются в памяти после его выхода, чтобы при заходе наложить похмелье, тпшнуть его домой, и пр. [7]
hangoverDays: 7

# Окрашивать ли информацию об этапах приготовления, в зависимости от качества, внутри бочек и зельеварок [true, true]
colorInBarrels: true
colorInBrewer: true

# Можно ли открыть большую бочку нажатием на любой ее блок, а не только табличку/забор, чтобы открыть ее. Всегда включено для маленьких бочек [true]
openLargeBarrelEverywhere: true

# Можно лм опустошить бутылку с напитком нажатием ею по воронке [true]
brewHopperDump: true


# -- Коверкание чата --

# Включить ли коверкание сообщений пьяных игроков в чате.
# Степень искажения зависит от того, насколько пьян игрок
# Ниже есть настройки того, как именно и что именно и с каким шансом искажать.
enableChatDistortion: true

# Сохранять ли в логи сервера оригинальные сообщения игрока, до того как они были изменены [false]
logRealChat: false

# Текст после данных команд будет исковеркан, но сами команды - нет (список) [- /gl]
distortCommands:
- /gl
- /global
- /fl
- /s
- /letter
- /g
- /l
- /lokal
- /local
- /mail send
- /m
- /msg
- /w
- /whisper
- /reply
- /r
- /t
- /tell

# Искажать ли текст, написанный на табличках во время опьянения [false]
distortSignText: false

# Если сообщение "обёрнуто" в приведенные ниже знаки, то оно не будет исковеркано (разделяйте начальный и конечный знаки при помощи запятой) (список) [- '[,]']
#   Пример:| Vutka1: *Сиськи письки*
#   Такое сообщение не будет исковеркано.
distortBypass:
- '*,*'
- '[,]'

# words: Слова и буквы, которые будут заменены во время пьяного письма.
# Этот список обрабатывается в порядке от начала до конца. Написанные сообщения коверкаются так же.

# replace: Слово/буква/выражение, которое будет заменено
#   (особые варианты: "-space": заменмть пробел, "-random": вписать в случайном месте, "-all": заменить сообщение целиком, "-start": добавить в начало сообщения, "-end": добавить в конец сообщения)
# to: на что заменить вышеуказанное слово/букву/выражение
# pre: какие слова/буквы/выражения должны быть перед указанным в 'replace:', чтобы можно было заменить на 'to:' (разделять при помощи ",")
# match:  true = одно из слов в 'pre:' должно быть перед целевым словом, чтобы коверкание сработало,  false = наоборот, т.е. слов из 'pre:' быть не должно, чтобы коверкание сработало.
# alcohol: 1-100 минимальное опьянение, необходимое для того, чтобы данное коверкание сработало
# percentage: шанс того, что данное коверкание произойдет


#  Ваш покорный слуга в лице меня, Vutka1, решил проявить величайшую щедрость и поделился своим, уже русифицированным, тэйблом коверкания. Он находится в самом низу в закомментированном виде.
#  Вам остается лишь удалить всё, что написано ниже, вплоть до него (только 'words:' не удалите...), а затем раскомментировать (убрать решетки) закомментированное
words: #удалять, начиная со СЛЕДУЮЩЕЙ строчки
-  replace: s
   to: sh
   percentage: 90
   alcohol: 30

-  replace: ch
   to: sh
   pre: u,s,o,a
   match: false
   alcohol: 10
   percentage: 70

-  replace: h
   to: hh
   pre: sch,h,t
   match: false
   percentage: 60
   alcohol: 20

-  replace: th
   to: thl
   percentage: 40
   alcohol: 30

-  replace: sch
   to: shk
   percentage: 60
   alcohol: 40

-  replace: u
   to: uuh
   percentage: 20

-  replace: y
   to: yy
   percentage: 60
   alcohol: 15

-  replace: e
   to: ee
   percentage: 40
   alcohol: 15

-  replace: you
   to: u
   percentage: 40

-  replace: u
   to: uo
   pre: u
   match: false
   percentage: 60

-  replace: that
   to: taht
   percentage: 20
   alcohol: 40

-  replace: p
   to: b
   percentage: 30

-  replace: p
   to: b
   percentage: 70
   alcohol: 60

-  replace: up
   to: ubb
   percentage: 80
   alcohol: 25

-  replace: o
   to: oh
   percentage: 20

-  replace: ei
   to: i
   percentage: 30
   alcohol: 15

-  replace: b
   to: bb
   percentage: 80
   alcohol: 40

-  replace: '!!!'
   to: '!!!111!!!eleven!1!'
   pre: '!'
   match: false
   percentage: 20
   alcohol: 70

-  replace: '!'
   to: '!!'
   pre: '!'
   match: false
   percentage: 90

-  replace: drunk
   to: dhrkunn
   pre: are
   match: false
   percentage: 70
   alcohol: 65

-  replace: walk
   to: whhealhk
   pre: you can, you can still, you can not
   match: false
   percentage: 80
   alcohol: 30

-  replace: wtf
   to: wft
   percentage: 20
   alcohol: 40

-  replace: lol
   to: loool
   percentage: 80
   alcohol: 10

-  replace: afk
   to: aafkayyy
   percentage: 30
   alcohol: 30

-  replace: write
   to: wreitt
   pre: you can,you can still,you can not
   match: false
   percentage: 80
   alcohol: 50

-  replace: drink
   to: booze
   percentage: 80
   alcohol: 70

-  replace: '?'
   to: '????'
   pre: '?'
   match: false
   percentage: 80
   alcohol: 40

-  replace: -space
   to: ''
   pre: h,g,w
   match: true
   alcohol: 10

-  replace: -space
   to: ''
   percentage: 30
   alcohol: 35

-  replace: -space
   to: ''
   percentage: 10

-  replace: -start
   to: dho
   percentage: 15
   alcohol: 50

-  replace: -start
   to: hhn
   percentage: 10
   alcohol: 50

-  replace: -random
   to: lu
   percentage: 10

-  replace: -random
   to: lug
   percentage: 10
   alcohol: 50

-  replace: -random
   to: blub
   percentage: 20
   alcohol: 80

-  replace: -random
   to: lerg
   percentage: 40
   alcohol: 85

-  replace: -random
   to: gul
   percentage: 40
   alcohol: 80

-  replace: -random
   to: ' '
   percentage: 100
   alcohol: 70

-  replace: -random
   to: ' '
   percentage: 60
   alcohol: 40

-  replace: -random
   to: ' '
   percentage: 50
   alcohol: 30

-  replace: -end
   to: '!'
   percentage: 40
   alcohol: 30

-  replace: -random
   to: ' *hic* '
   percentage: 80
   alcohol: 70

-  replace: -random
   to: ' *hic* '
   percentage: 15
   alcohol: 40

-  replace: -space
   to: ' *hic* '
   percentage: 5
   alcohol: 20

-  replace: -end
   to: ' *hic*'
   percentage: 70
   alcohol: 50

-  replace: -all
   to: '*burp*'
   percentage: 3
   alcohol: 60

-  replace: -all
   to: '*burp*'
   percentage: 6
   alcohol: 80
# удалять то, что сверху.
# после удаления раскомментировать строки ниже:
# -  replace: с
   # to: ш
   # percentage: 30
   # alcohol: 25

# -  replace: с
   # to: сс
   # percentage: 30
   # alcohol: 25

# -  replace: ч
   # to: ш
   # alcohol: 10
   # percentage: 10

# -  replace: х
   # to: хх
   # percentage: 50
   # alcohol: 20

# -  replace: th
   # to: thl
   # percentage: 30
   # alcohol: 30

# -  replace: ш
   # to: щ
   # percentage: 40
   # alcohol: 35

# -  replace: у
   # to: уф
   # percentage: 25
   # alcohol: 20

# -  replace: у
   # to: уу
   # percentage: 50
   # alcohol: 15

# -  replace: е
   # to: ее
   # percentage: 30
   # alcohol: 15

# -  replace: ты
   # to: тыыэ
   # percentage: 30
   # alcohol: 25

# -  replace: во
   # to: уо
   # percentage: 30
   # alcohol: 25

# -  replace: это
   # to: этт
   # percentage: 20
   # alcohol: 40

# -  replace: п
   # to: б
   # percentage: 20

# -  replace: п
   # to: б
   # percentage: 30
   # alcohol: 60

# -  replace: вверх
   # to: ввьиерх
   # percentage: 60
   # alcohol: 25

# -  replace: о
   # to: оо
   # percentage: 20
   # alcohol: 15

# -  replace: э
   # to: ЭЭэЭЭэ
   # percentage: 30
   # alcohol: 45

# -  replace: б
   # to: бб
   # percentage: 50
   # alcohol: 40

# -  replace: б
   # to: п
   # percentage: 20
   # alcohol: 30

# -  replace: '!!!'
   # to: '!!!111!!!1!1!'
   # pre: '!'
   # match: false
   # percentage: 20
   # alcohol: 70

# -  replace: '!'
   # to: '!!1'
   # percentage: 50
   # alcohol: 10

# -  replace: пьяный
   # to: ппбьянй
   # pre: are
   # match: false
   # percentage: 60
   # alcohol: 65

# -  replace: ходить
   # to: хходитьть
   # percentage: 70
   # alcohol: 30

# -  replace: уходи
   # to: уухходии
   # percentage: 70
   # alcohol: 30

# -  replace: идти
   # to: иийдьти
   # percentage: 70
   # alcohol: 30

# -  replace: втф
   # to: чзхХх
   # percentage: 30
   # alcohol: 40

# -  replace: лол
   # to: лЛлол
   # percentage: 60
   # alcohol: 10

# -  replace: афк
   # to: ааыаффк
   # percentage: 50
   # alcohol: 30

# -  replace: write
   # to: wreitt
   # pre: you can,you can still,you can not
   # match: false
   # percentage: 80
   # alcohol: 50

# -  replace: drink
   # to: booze
   # percentage: 80
   # alcohol: 70

# -  replace: '?'
   # to: '?7'
   # percentage: 50
   # alcohol: 20

# -  replace: c
   # to: ' '
   # alcohol: 10
   # percentage: 15

# -  replace: т
   # to: тт
   # alcohol: 10
   # percentage: 20

# -  replace: -space
   # to: ''
   # pre: х,г,у
   # match: true
   # alcohol: 10
   # percentage: 15

# -  replace: -space
   # to: ''
   # percentage: 25
   # alcohol: 25

# -  replace: -space
   # to: ''
   # percentage: 20
   # alcohol: 10

# -  replace: -start
   # to: Уфхх
   # percentage: 10
   # alcohol: 50

# -  replace: -start
   # to: Хх
   # percentage: 10
   # alcohol: 50

# -  replace: -random
   # to: й
   # percentage: 10

# -  replace: -random
   # to: бьб
   # percentage: 10
   # alcohol: 80

# -  replace: -random
   # to: буээ
   # percentage: 20
   # alcohol: 85

# -  replace: -random
   # to: уфх
   # percentage: 20
   # alcohol: 80

# -  replace: -random
   # to: ' '
   # percentage: 70
   # alcohol: 70

# -  replace: -random
   # to: ' '
   # percentage: 35
   # alcohol: 40

# -  replace: -random
   # to: ' '
   # percentage: 30
   # alcohol: 30

# -  replace: -random
   # to: ' '
   # percentage: 25
   # alcohol: 20

# -  replace: -end
   # to: '!'
   # percentage: 30
   # alcohol: 30

# -  replace: -random
   # to: ' *ик* '
   # percentage: 70
   # alcohol: 70

# -  replace: -random
   # to: '*ик*'
   # percentage: 30
   # alcohol: 30

# -  replace: -random
   # to: ' *ик* '
   # percentage: 15
   # alcohol: 25

# -  replace: -space
   # to: ' *ик* '
   # percentage: 5
   # alcohol: 20

# -  replace: -end
   # to: ' *ик*'
   # percentage: 60
   # alcohol: 50

# -  replace: -random
   # to: '*рыг*'
   # percentage: 15
   # alcohol: 40


# -  replace: бля
   # to: бБляать
   # percentage: 30
   # alcohol: 30

# -  replace: бля
   # to: ББЛЯАЯТЬ
   # percentage: 35
   # alcohol: 65

# -  replace: сук
   # to: сСсука
   # percentage: 25
   # alcohol: 20

# -  replace: х
   # to: хх
   # percentage: 30
   # alcohol: 20

# -  replace: -all
   # to: '*Ухх бл*'
   # percentage: 5
   # alcohol: 80

# -  replace: -all
   # to: '*Этиловое пение*'
   # percentage: 5
   # alcohol: 85

# -  replace: -all
   # to: 'Ттыы м*ик*ьеня ув.. уважжаешь??'
   # percentage: 5
   # alcohol: 80

# -  replace: -all
   # to: 'Хьихихи)'
   # percentage: 5
   # alcohol: 75

# -  replace: -all
   # to: 'Хехьехее)'
   # percentage: 5
   # alcohol: 75

# -  replace: -all
   # to: '*пьяный поросячий визг*'
   # percentage: 4
   # alcohol: 90

# -  replace: -all
   # to: '*рыг*'
   # percentage: 6
   # alcohol: 80

```
