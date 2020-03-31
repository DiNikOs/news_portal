
-- Updated Stanislav Ryzhkov 28/03/2020
-- Подправил скрипт, БД заполняется 11 тестовыми статьями с обширным текстом, тегами, форматирующими текст и тегами картинок
-- В тегах картинок только название файла, url формируется на сервере, исходя из режима "разработка" или "продакшен"
-- (соответственно, добавляется http://localhost:port/path/ или https://example.com/path )

INSERT INTO articles (category_id,created, last_view_date, main_picture_url, published, status_id, title, text, total_views)
VALUES
(
    1,
    current_date,
    current_date,
    '<img src="http://localhost:8199/news/images/news/img01.jpg"/>',
    current_date,
    1,
    'Заголовок01',
    '<img src="img01.jpg"/>
    <p>
        Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ipsum consequat nisl vel pretium. Praesent elementum facilisis leo vel fringilla est. Mauris sit amet massa vitae tortor. Nulla porttitor massa id neque aliquam vestibulum. Malesuada bibendum arcu vitae elementum curabitur. Arcu dui vivamus arcu felis bibendum. Fermentum et sollicitudin ac orci phasellus egestas tellus. Ornare aenean euismod elementum nisi. Porttitor eget dolor morbi non arcu risus. Lacus sed turpis tincidunt id aliquet. Viverra tellus in hac habitasse platea. Aliquet bibendum enim facilisis gravida neque convallis a. Ligula ullamcorper malesuada proin libero nunc consequat interdum varius sit. Scelerisque mauris pellentesque pulvinar pellentesque habitant. Et leo duis ut diam quam nulla porttitor. Quis lectus nulla at volutpat diam ut venenatis tellus. Eget felis eget nunc lobortis. Ac tincidunt vitae semper quis lectus nulla at volutpat diam. Ullamcorper velit sed ullamcorper morbi tincidunt.
    </p>

    <p>
        Quisque sagittis purus sit amet volutpat. Quis imperdiet massa tincidunt nunc pulvinar sapien et ligula ullamcorper. Consequat nisl vel pretium lectus quam id leo in. Vulputate ut pharetra sit amet aliquam id diam maecenas. Id semper risus in hendrerit gravida rutrum quisque non tellus. Velit egestas dui id ornare arcu odio ut sem nulla. Vel risus commodo viverra maecenas accumsan lacus. Amet risus nullam eget felis eget. Adipiscing enim eu turpis egestas pretium aenean pharetra magna ac. Eleifend mi in nulla posuere sollicitudin. Orci dapibus ultrices in iaculis nunc sed. Eleifend mi in nulla posuere sollicitudin aliquam ultrices sagittis orci. Suspendisse in est ante in nibh mauris cursus mattis molestie. Nibh tortor id aliquet lectus. Aenean sed adipiscing diam donec. Fermentum odio eu feugiat pretium nibh. Nec sagittis aliquam malesuada bibendum arcu vitae. Nulla malesuada pellentesque elit eget. Sit amet tellus cras adipiscing enim eu.
    </p>

    <img src="img01.jpg"/>
    <p>

        Risus nec feugiat in fermentum posuere urna nec. Sed faucibus turpis in eu mi bibendum neque egestas congue. Ornare aenean euismod elementum nisi. Lacinia quis vel eros donec ac odio tempor orci dapibus. Venenatis a condimentum vitae sapien pellentesque habitant. Eu feugiat pretium nibh ipsum consequat nisl vel. Faucibus turpis in eu mi bibendum neque egestas congue quisque. Vestibulum morbi blandit cursus risus at ultrices. Diam vel quam elementum pulvinar etiam non quam lacus. Neque egestas congue quisque egestas diam in. Nulla posuere sollicitudin aliquam ultrices sagittis orci a.
    </p>

    <p>
        <strong>
            Faucibus turpis in eu mi bibendum neque egestas. Ultricies integer quis auctor elit sed vulputate mi. Tortor dignissim convallis aenean et tortor at. Tellus in metus vulputate eu scelerisque felis imperdiet proin fermentum. Nisl pretium fusce id velit ut tortor pretium viverra suspendisse. In hac habitasse platea dictumst quisque sagittis purus sit amet. A lacus vestibulum sed arcu non odio euismod lacinia at. Sollicitudin ac orci phasellus egestas tellus rutrum tellus pellentesque eu. Eu facilisis sed odio morbi quis commodo odio aenean sed. Nunc non blandit massa enim nec dui nunc. Nunc sed blandit libero volutpat. Tortor id aliquet lectus proin nibh nisl. Eget velit aliquet sagittis id consectetur purus ut.
        </strong>
    </p>

    <p>
        Facilisis volutpat est velit egestas. Non quam lacus suspendisse faucibus interdum posuere lorem ipsum. Semper risus in hendrerit gravida rutrum. Etiam tempor orci eu lobortis elementum. Eu nisl nunc mi ipsum faucibus vitae. Enim praesent elementum facilisis leo vel. Duis at consectetur lorem donec massa sapien faucibus et molestie. Pellentesque massa placerat duis ultricies lacus sed turpis tincidunt id. Tortor aliquam nulla facilisi cras. Ipsum dolor sit amet consectetur adipiscing elit duis. Consequat interdum varius sit amet. Gravida cum sociis natoque penatibus et magnis dis. Bibendum enim facilisis gravida neque convallis a. Risus at ultrices mi tempus imperdiet. Quis eleifend quam adipiscing vitae proin sagittis nisl. Condimentum id venenatis a condimentum.
    </p>

    <p>
        Malesuada fames ac turpis egestas sed. Quis varius quam quisque id diam. Porttitor leo a diam sollicitudin tempor. Vestibulum mattis ullamcorper velit sed ullamcorper morbi tincidunt. Tortor condimentum lacinia quis vel eros donec ac. Sit amet mauris commodo quis imperdiet massa. Viverra nibh cras pulvinar mattis nunc sed blandit libero. Eu turpis egestas pretium aenean. Ridiculus mus mauris vitae ultricies. Euismod nisi porta lorem mollis aliquam ut porttitor leo a. Quis eleifend quam adipiscing vitae. At volutpat diam ut venenatis tellus.
    </p>

    <p>
        Lacus vestibulum sed arcu non odio euismod lacinia. Nam aliquam sem et tortor. Aliquam vestibulum morbi blandit cursus risus at. At consectetur lorem donec massa sapien. Tortor consequat id porta nibh venenatis cras sed. Ornare suspendisse sed nisi lacus sed viverra tellus in hac. Lacus luctus accumsan tortor posuere ac ut consequat semper viverra. Quis lectus nulla at volutpat diam ut venenatis tellus. Nunc mi ipsum faucibus vitae aliquet nec ullamcorper sit amet. Leo in vitae turpis massa sed elementum tempus. Venenatis lectus magna fringilla urna porttitor rhoncus dolor purus non. Justo eget magna fermentum iaculis. Viverra tellus in hac habitasse platea dictumst vestibulum. Viverra orci sagittis eu volutpat odio facilisis mauris sit. Amet facilisis magna etiam tempor orci eu lobortis. Amet volutpat consequat mauris nunc congue. Lorem ipsum dolor sit amet. Morbi non arcu risus quis varius. Id eu nisl nunc mi ipsum faucibus vitae aliquet.
    </p>
',
    100
),

--         <p>TEXT</p> <img src="http://localhost:8199/news/images/news/img01.jpg"/> <p>TEXT</p>

(
    2,
    current_date,
    current_date,
    '<img src="http://localhost:8199/news/images/news/img02.jpg"/>',
    current_date,
    1,
    'Заголовок02',
    '<img src="img02.jpg"/>
    <p>
        Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ipsum consequat nisl vel pretium. Praesent elementum facilisis leo vel fringilla est. Mauris sit amet massa vitae tortor. Nulla porttitor massa id neque aliquam vestibulum. Malesuada bibendum arcu vitae elementum curabitur. Arcu dui vivamus arcu felis bibendum. Fermentum et sollicitudin ac orci phasellus egestas tellus. Ornare aenean euismod elementum nisi. Porttitor eget dolor morbi non arcu risus. Lacus sed turpis tincidunt id aliquet. Viverra tellus in hac habitasse platea. Aliquet bibendum enim facilisis gravida neque convallis a. Ligula ullamcorper malesuada proin libero nunc consequat interdum varius sit. Scelerisque mauris pellentesque pulvinar pellentesque habitant. Et leo duis ut diam quam nulla porttitor. Quis lectus nulla at volutpat diam ut venenatis tellus. Eget felis eget nunc lobortis. Ac tincidunt vitae semper quis lectus nulla at volutpat diam. Ullamcorper velit sed ullamcorper morbi tincidunt.
    </p>

    <p>
        Quisque sagittis purus sit amet volutpat. Quis imperdiet massa tincidunt nunc pulvinar sapien et ligula ullamcorper. Consequat nisl vel pretium lectus quam id leo in. Vulputate ut pharetra sit amet aliquam id diam maecenas. Id semper risus in hendrerit gravida rutrum quisque non tellus. Velit egestas dui id ornare arcu odio ut sem nulla. Vel risus commodo viverra maecenas accumsan lacus. Amet risus nullam eget felis eget. Adipiscing enim eu turpis egestas pretium aenean pharetra magna ac. Eleifend mi in nulla posuere sollicitudin. Orci dapibus ultrices in iaculis nunc sed. Eleifend mi in nulla posuere sollicitudin aliquam ultrices sagittis orci. Suspendisse in est ante in nibh mauris cursus mattis molestie. Nibh tortor id aliquet lectus. Aenean sed adipiscing diam donec. Fermentum odio eu feugiat pretium nibh. Nec sagittis aliquam malesuada bibendum arcu vitae. Nulla malesuada pellentesque elit eget. Sit amet tellus cras adipiscing enim eu.
    </p>

    <img src="img02.jpg"/>
    <p>

        Risus nec feugiat in fermentum posuere urna nec. Sed faucibus turpis in eu mi bibendum neque egestas congue. Ornare aenean euismod elementum nisi. Lacinia quis vel eros donec ac odio tempor orci dapibus. Venenatis a condimentum vitae sapien pellentesque habitant. Eu feugiat pretium nibh ipsum consequat nisl vel. Faucibus turpis in eu mi bibendum neque egestas congue quisque. Vestibulum morbi blandit cursus risus at ultrices. Diam vel quam elementum pulvinar etiam non quam lacus. Neque egestas congue quisque egestas diam in. Nulla posuere sollicitudin aliquam ultrices sagittis orci a.
    </p>

    <p>
        <b>
        Faucibus turpis in eu mi bibendum neque egestas. Ultricies integer quis auctor elit sed vulputate mi. Tortor dignissim convallis aenean et tortor at. Tellus in metus vulputate eu scelerisque felis imperdiet proin fermentum. Nisl pretium fusce id velit ut tortor pretium viverra suspendisse. In hac habitasse platea dictumst quisque sagittis purus sit amet. A lacus vestibulum sed arcu non odio euismod lacinia at. Sollicitudin ac orci phasellus egestas tellus rutrum tellus pellentesque eu. Eu facilisis sed odio morbi quis commodo odio aenean sed. Nunc non blandit massa enim nec dui nunc. Nunc sed blandit libero volutpat. Tortor id aliquet lectus proin nibh nisl. Eget velit aliquet sagittis id consectetur purus ut.
        </b>
    </p>

    <p>
        Facilisis volutpat est velit egestas. Non quam lacus suspendisse faucibus interdum posuere lorem ipsum. Semper risus in hendrerit gravida rutrum. Etiam tempor orci eu lobortis elementum. Eu nisl nunc mi ipsum faucibus vitae. Enim praesent elementum facilisis leo vel. Duis at consectetur lorem donec massa sapien faucibus et molestie. Pellentesque massa placerat duis ultricies lacus sed turpis tincidunt id. Tortor aliquam nulla facilisi cras. Ipsum dolor sit amet consectetur adipiscing elit duis. Consequat interdum varius sit amet. Gravida cum sociis natoque penatibus et magnis dis. Bibendum enim facilisis gravida neque convallis a. Risus at ultrices mi tempus imperdiet. Quis eleifend quam adipiscing vitae proin sagittis nisl. Condimentum id venenatis a condimentum.
    </p>

    <p>
        Malesuada fames ac turpis egestas sed. Quis varius quam quisque id diam. Porttitor leo a diam sollicitudin tempor. Vestibulum mattis ullamcorper velit sed ullamcorper morbi tincidunt. Tortor condimentum lacinia quis vel eros donec ac. Sit amet mauris commodo quis imperdiet massa. Viverra nibh cras pulvinar mattis nunc sed blandit libero. Eu turpis egestas pretium aenean. Ridiculus mus mauris vitae ultricies. Euismod nisi porta lorem mollis aliquam ut porttitor leo a. Quis eleifend quam adipiscing vitae. At volutpat diam ut venenatis tellus.
    </p>

    <p>
        Lacus vestibulum sed arcu non odio euismod lacinia. Nam aliquam sem et tortor. Aliquam vestibulum morbi blandit cursus risus at. At consectetur lorem donec massa sapien. Tortor consequat id porta nibh venenatis cras sed. Ornare suspendisse sed nisi lacus sed viverra tellus in hac. Lacus luctus accumsan tortor posuere ac ut consequat semper viverra. Quis lectus nulla at volutpat diam ut venenatis tellus. Nunc mi ipsum faucibus vitae aliquet nec ullamcorper sit amet. Leo in vitae turpis massa sed elementum tempus. Venenatis lectus magna fringilla urna porttitor rhoncus dolor purus non. Justo eget magna fermentum iaculis. Viverra tellus in hac habitasse platea dictumst vestibulum. Viverra orci sagittis eu volutpat odio facilisis mauris sit. Amet facilisis magna etiam tempor orci eu lobortis. Amet volutpat consequat mauris nunc congue. Lorem ipsum dolor sit amet. Morbi non arcu risus quis varius. Id eu nisl nunc mi ipsum faucibus vitae aliquet.
    </p>
',
    200
),

(
    3,
    current_date,
    current_date,
    '<img src="http://localhost:8199/news/images/news/img03.jpg"/>',
    current_date,
    1,
    'Заголовок03',
    '<img src="img03.jpg"/>
    <p>
        Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ipsum consequat nisl vel pretium. Praesent elementum facilisis leo vel fringilla est. Mauris sit amet massa vitae tortor. Nulla porttitor massa id neque aliquam vestibulum. Malesuada bibendum arcu vitae elementum curabitur. Arcu dui vivamus arcu felis bibendum. Fermentum et sollicitudin ac orci phasellus egestas tellus. Ornare aenean euismod elementum nisi. Porttitor eget dolor morbi non arcu risus. Lacus sed turpis tincidunt id aliquet. Viverra tellus in hac habitasse platea. Aliquet bibendum enim facilisis gravida neque convallis a. Ligula ullamcorper malesuada proin libero nunc consequat interdum varius sit. Scelerisque mauris pellentesque pulvinar pellentesque habitant. Et leo duis ut diam quam nulla porttitor. Quis lectus nulla at volutpat diam ut venenatis tellus. Eget felis eget nunc lobortis. Ac tincidunt vitae semper quis lectus nulla at volutpat diam. Ullamcorper velit sed ullamcorper morbi tincidunt.
    </p>

    <p>
        Quisque sagittis purus sit amet volutpat. Quis imperdiet massa tincidunt nunc pulvinar sapien et ligula ullamcorper. Consequat nisl vel pretium lectus quam id leo in. Vulputate ut pharetra sit amet aliquam id diam maecenas. Id semper risus in hendrerit gravida rutrum quisque non tellus. Velit egestas dui id ornare arcu odio ut sem nulla. Vel risus commodo viverra maecenas accumsan lacus. Amet risus nullam eget felis eget. Adipiscing enim eu turpis egestas pretium aenean pharetra magna ac. Eleifend mi in nulla posuere sollicitudin. Orci dapibus ultrices in iaculis nunc sed. Eleifend mi in nulla posuere sollicitudin aliquam ultrices sagittis orci. Suspendisse in est ante in nibh mauris cursus mattis molestie. Nibh tortor id aliquet lectus. Aenean sed adipiscing diam donec. Fermentum odio eu feugiat pretium nibh. Nec sagittis aliquam malesuada bibendum arcu vitae. Nulla malesuada pellentesque elit eget. Sit amet tellus cras adipiscing enim eu.
    </p>

    <img src="img03.jpg"/>
    <p>

        Risus nec feugiat in fermentum posuere urna nec. Sed faucibus turpis in eu mi bibendum neque egestas congue. Ornare aenean euismod elementum nisi. Lacinia quis vel eros donec ac odio tempor orci dapibus. Venenatis a condimentum vitae sapien pellentesque habitant. Eu feugiat pretium nibh ipsum consequat nisl vel. Faucibus turpis in eu mi bibendum neque egestas congue quisque. Vestibulum morbi blandit cursus risus at ultrices. Diam vel quam elementum pulvinar etiam non quam lacus. Neque egestas congue quisque egestas diam in. Nulla posuere sollicitudin aliquam ultrices sagittis orci a.
    </p>

    <p>
        <b>
        Faucibus turpis in eu mi bibendum neque egestas. Ultricies integer quis auctor elit sed vulputate mi. Tortor dignissim convallis aenean et tortor at. Tellus in metus vulputate eu scelerisque felis imperdiet proin fermentum. Nisl pretium fusce id velit ut tortor pretium viverra suspendisse. In hac habitasse platea dictumst quisque sagittis purus sit amet. A lacus vestibulum sed arcu non odio euismod lacinia at. Sollicitudin ac orci phasellus egestas tellus rutrum tellus pellentesque eu. Eu facilisis sed odio morbi quis commodo odio aenean sed. Nunc non blandit massa enim nec dui nunc. Nunc sed blandit libero volutpat. Tortor id aliquet lectus proin nibh nisl. Eget velit aliquet sagittis id consectetur purus ut.
        </b>
    </p>

    <p>
        Facilisis volutpat est velit egestas. Non quam lacus suspendisse faucibus interdum posuere lorem ipsum. Semper risus in hendrerit gravida rutrum. Etiam tempor orci eu lobortis elementum. Eu nisl nunc mi ipsum faucibus vitae. Enim praesent elementum facilisis leo vel. Duis at consectetur lorem donec massa sapien faucibus et molestie. Pellentesque massa placerat duis ultricies lacus sed turpis tincidunt id. Tortor aliquam nulla facilisi cras. Ipsum dolor sit amet consectetur adipiscing elit duis. Consequat interdum varius sit amet. Gravida cum sociis natoque penatibus et magnis dis. Bibendum enim facilisis gravida neque convallis a. Risus at ultrices mi tempus imperdiet. Quis eleifend quam adipiscing vitae proin sagittis nisl. Condimentum id venenatis a condimentum.
    </p>

    <p>
        Malesuada fames ac turpis egestas sed. Quis varius quam quisque id diam. Porttitor leo a diam sollicitudin tempor. Vestibulum mattis ullamcorper velit sed ullamcorper morbi tincidunt. Tortor condimentum lacinia quis vel eros donec ac. Sit amet mauris commodo quis imperdiet massa. Viverra nibh cras pulvinar mattis nunc sed blandit libero. Eu turpis egestas pretium aenean. Ridiculus mus mauris vitae ultricies. Euismod nisi porta lorem mollis aliquam ut porttitor leo a. Quis eleifend quam adipiscing vitae. At volutpat diam ut venenatis tellus.
    </p>

    <p>
        Lacus vestibulum sed arcu non odio euismod lacinia. Nam aliquam sem et tortor. Aliquam vestibulum morbi blandit cursus risus at. At consectetur lorem donec massa sapien. Tortor consequat id porta nibh venenatis cras sed. Ornare suspendisse sed nisi lacus sed viverra tellus in hac. Lacus luctus accumsan tortor posuere ac ut consequat semper viverra. Quis lectus nulla at volutpat diam ut venenatis tellus. Nunc mi ipsum faucibus vitae aliquet nec ullamcorper sit amet. Leo in vitae turpis massa sed elementum tempus. Venenatis lectus magna fringilla urna porttitor rhoncus dolor purus non. Justo eget magna fermentum iaculis. Viverra tellus in hac habitasse platea dictumst vestibulum. Viverra orci sagittis eu volutpat odio facilisis mauris sit. Amet facilisis magna etiam tempor orci eu lobortis. Amet volutpat consequat mauris nunc congue. Lorem ipsum dolor sit amet. Morbi non arcu risus quis varius. Id eu nisl nunc mi ipsum faucibus vitae aliquet.
</p>
',
    300
),

(
    4,
    current_date,
    current_date,
    '<img src="http://localhost:8199/news/images/news/img04.jpg"/>',
    current_date,
    2,
    'Заголовок04',
    '<img src="img04.jpg"/>
<p>
Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ipsum consequat nisl vel pretium. Praesent elementum facilisis leo vel fringilla est. Mauris sit amet massa vitae tortor. Nulla porttitor massa id neque aliquam vestibulum. Malesuada bibendum arcu vitae elementum curabitur. Arcu dui vivamus arcu felis bibendum. Fermentum et sollicitudin ac orci phasellus egestas tellus. Ornare aenean euismod elementum nisi. Porttitor eget dolor morbi non arcu risus. Lacus sed turpis tincidunt id aliquet. Viverra tellus in hac habitasse platea. Aliquet bibendum enim facilisis gravida neque convallis a. Ligula ullamcorper malesuada proin libero nunc consequat interdum varius sit. Scelerisque mauris pellentesque pulvinar pellentesque habitant. Et leo duis ut diam quam nulla porttitor. Quis lectus nulla at volutpat diam ut venenatis tellus. Eget felis eget nunc lobortis. Ac tincidunt vitae semper quis lectus nulla at volutpat diam. Ullamcorper velit sed ullamcorper morbi tincidunt.
</p>

<p>
Quisque sagittis purus sit amet volutpat. Quis imperdiet massa tincidunt nunc pulvinar sapien et ligula ullamcorper. Consequat nisl vel pretium lectus quam id leo in. Vulputate ut pharetra sit amet aliquam id diam maecenas. Id semper risus in hendrerit gravida rutrum quisque non tellus. Velit egestas dui id ornare arcu odio ut sem nulla. Vel risus commodo viverra maecenas accumsan lacus. Amet risus nullam eget felis eget. Adipiscing enim eu turpis egestas pretium aenean pharetra magna ac. Eleifend mi in nulla posuere sollicitudin. Orci dapibus ultrices in iaculis nunc sed. Eleifend mi in nulla posuere sollicitudin aliquam ultrices sagittis orci. Suspendisse in est ante in nibh mauris cursus mattis molestie. Nibh tortor id aliquet lectus. Aenean sed adipiscing diam donec. Fermentum odio eu feugiat pretium nibh. Nec sagittis aliquam malesuada bibendum arcu vitae. Nulla malesuada pellentesque elit eget. Sit amet tellus cras adipiscing enim eu.
</p>

<img src="img04.jpg"/>
<p>

Risus nec feugiat in fermentum posuere urna nec. Sed faucibus turpis in eu mi bibendum neque egestas congue. Ornare aenean euismod elementum nisi. Lacinia quis vel eros donec ac odio tempor orci dapibus. Venenatis a condimentum vitae sapien pellentesque habitant. Eu feugiat pretium nibh ipsum consequat nisl vel. Faucibus turpis in eu mi bibendum neque egestas congue quisque. Vestibulum morbi blandit cursus risus at ultrices. Diam vel quam elementum pulvinar etiam non quam lacus. Neque egestas congue quisque egestas diam in. Nulla posuere sollicitudin aliquam ultrices sagittis orci a.
</p>

<p>
<b>
Faucibus turpis in eu mi bibendum neque egestas. Ultricies integer quis auctor elit sed vulputate mi. Tortor dignissim convallis aenean et tortor at. Tellus in metus vulputate eu scelerisque felis imperdiet proin fermentum. Nisl pretium fusce id velit ut tortor pretium viverra suspendisse. In hac habitasse platea dictumst quisque sagittis purus sit amet. A lacus vestibulum sed arcu non odio euismod lacinia at. Sollicitudin ac orci phasellus egestas tellus rutrum tellus pellentesque eu. Eu facilisis sed odio morbi quis commodo odio aenean sed. Nunc non blandit massa enim nec dui nunc. Nunc sed blandit libero volutpat. Tortor id aliquet lectus proin nibh nisl. Eget velit aliquet sagittis id consectetur purus ut.
</b>
</p>

<p>
Facilisis volutpat est velit egestas. Non quam lacus suspendisse faucibus interdum posuere lorem ipsum. Semper risus in hendrerit gravida rutrum. Etiam tempor orci eu lobortis elementum. Eu nisl nunc mi ipsum faucibus vitae. Enim praesent elementum facilisis leo vel. Duis at consectetur lorem donec massa sapien faucibus et molestie. Pellentesque massa placerat duis ultricies lacus sed turpis tincidunt id. Tortor aliquam nulla facilisi cras. Ipsum dolor sit amet consectetur adipiscing elit duis. Consequat interdum varius sit amet. Gravida cum sociis natoque penatibus et magnis dis. Bibendum enim facilisis gravida neque convallis a. Risus at ultrices mi tempus imperdiet. Quis eleifend quam adipiscing vitae proin sagittis nisl. Condimentum id venenatis a condimentum.
</p>

<p>
Malesuada fames ac turpis egestas sed. Quis varius quam quisque id diam. Porttitor leo a diam sollicitudin tempor. Vestibulum mattis ullamcorper velit sed ullamcorper morbi tincidunt. Tortor condimentum lacinia quis vel eros donec ac. Sit amet mauris commodo quis imperdiet massa. Viverra nibh cras pulvinar mattis nunc sed blandit libero. Eu turpis egestas pretium aenean. Ridiculus mus mauris vitae ultricies. Euismod nisi porta lorem mollis aliquam ut porttitor leo a. Quis eleifend quam adipiscing vitae. At volutpat diam ut venenatis tellus.
</p>

<p>
Lacus vestibulum sed arcu non odio euismod lacinia. Nam aliquam sem et tortor. Aliquam vestibulum morbi blandit cursus risus at. At consectetur lorem donec massa sapien. Tortor consequat id porta nibh venenatis cras sed. Ornare suspendisse sed nisi lacus sed viverra tellus in hac. Lacus luctus accumsan tortor posuere ac ut consequat semper viverra. Quis lectus nulla at volutpat diam ut venenatis tellus. Nunc mi ipsum faucibus vitae aliquet nec ullamcorper sit amet. Leo in vitae turpis massa sed elementum tempus. Venenatis lectus magna fringilla urna porttitor rhoncus dolor purus non. Justo eget magna fermentum iaculis. Viverra tellus in hac habitasse platea dictumst vestibulum. Viverra orci sagittis eu volutpat odio facilisis mauris sit. Amet facilisis magna etiam tempor orci eu lobortis. Amet volutpat consequat mauris nunc congue. Lorem ipsum dolor sit amet. Morbi non arcu risus quis varius. Id eu nisl nunc mi ipsum faucibus vitae aliquet.
</p>
',
    500
),

(
    5,
    current_date,
    current_date,
    '<img src="http://localhost:8199/news/images/news/img05.jpg"/>',
    current_date,
    2,
    'Заголовок05',
    '<img src="img05.jpg"/>
<p>
Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ipsum consequat nisl vel pretium. Praesent elementum facilisis leo vel fringilla est. Mauris sit amet massa vitae tortor. Nulla porttitor massa id neque aliquam vestibulum. Malesuada bibendum arcu vitae elementum curabitur. Arcu dui vivamus arcu felis bibendum. Fermentum et sollicitudin ac orci phasellus egestas tellus. Ornare aenean euismod elementum nisi. Porttitor eget dolor morbi non arcu risus. Lacus sed turpis tincidunt id aliquet. Viverra tellus in hac habitasse platea. Aliquet bibendum enim facilisis gravida neque convallis a. Ligula ullamcorper malesuada proin libero nunc consequat interdum varius sit. Scelerisque mauris pellentesque pulvinar pellentesque habitant. Et leo duis ut diam quam nulla porttitor. Quis lectus nulla at volutpat diam ut venenatis tellus. Eget felis eget nunc lobortis. Ac tincidunt vitae semper quis lectus nulla at volutpat diam. Ullamcorper velit sed ullamcorper morbi tincidunt.
</p>

<p>
Quisque sagittis purus sit amet volutpat. Quis imperdiet massa tincidunt nunc pulvinar sapien et ligula ullamcorper. Consequat nisl vel pretium lectus quam id leo in. Vulputate ut pharetra sit amet aliquam id diam maecenas. Id semper risus in hendrerit gravida rutrum quisque non tellus. Velit egestas dui id ornare arcu odio ut sem nulla. Vel risus commodo viverra maecenas accumsan lacus. Amet risus nullam eget felis eget. Adipiscing enim eu turpis egestas pretium aenean pharetra magna ac. Eleifend mi in nulla posuere sollicitudin. Orci dapibus ultrices in iaculis nunc sed. Eleifend mi in nulla posuere sollicitudin aliquam ultrices sagittis orci. Suspendisse in est ante in nibh mauris cursus mattis molestie. Nibh tortor id aliquet lectus. Aenean sed adipiscing diam donec. Fermentum odio eu feugiat pretium nibh. Nec sagittis aliquam malesuada bibendum arcu vitae. Nulla malesuada pellentesque elit eget. Sit amet tellus cras adipiscing enim eu.
</p>

<img src="img05.jpg"/>
<p>

Risus nec feugiat in fermentum posuere urna nec. Sed faucibus turpis in eu mi bibendum neque egestas congue. Ornare aenean euismod elementum nisi. Lacinia quis vel eros donec ac odio tempor orci dapibus. Venenatis a condimentum vitae sapien pellentesque habitant. Eu feugiat pretium nibh ipsum consequat nisl vel. Faucibus turpis in eu mi bibendum neque egestas congue quisque. Vestibulum morbi blandit cursus risus at ultrices. Diam vel quam elementum pulvinar etiam non quam lacus. Neque egestas congue quisque egestas diam in. Nulla posuere sollicitudin aliquam ultrices sagittis orci a.
</p>

<p>
<b>
Faucibus turpis in eu mi bibendum neque egestas. Ultricies integer quis auctor elit sed vulputate mi. Tortor dignissim convallis aenean et tortor at. Tellus in metus vulputate eu scelerisque felis imperdiet proin fermentum. Nisl pretium fusce id velit ut tortor pretium viverra suspendisse. In hac habitasse platea dictumst quisque sagittis purus sit amet. A lacus vestibulum sed arcu non odio euismod lacinia at. Sollicitudin ac orci phasellus egestas tellus rutrum tellus pellentesque eu. Eu facilisis sed odio morbi quis commodo odio aenean sed. Nunc non blandit massa enim nec dui nunc. Nunc sed blandit libero volutpat. Tortor id aliquet lectus proin nibh nisl. Eget velit aliquet sagittis id consectetur purus ut.
</b>
</p>

<p>
Facilisis volutpat est velit egestas. Non quam lacus suspendisse faucibus interdum posuere lorem ipsum. Semper risus in hendrerit gravida rutrum. Etiam tempor orci eu lobortis elementum. Eu nisl nunc mi ipsum faucibus vitae. Enim praesent elementum facilisis leo vel. Duis at consectetur lorem donec massa sapien faucibus et molestie. Pellentesque massa placerat duis ultricies lacus sed turpis tincidunt id. Tortor aliquam nulla facilisi cras. Ipsum dolor sit amet consectetur adipiscing elit duis. Consequat interdum varius sit amet. Gravida cum sociis natoque penatibus et magnis dis. Bibendum enim facilisis gravida neque convallis a. Risus at ultrices mi tempus imperdiet. Quis eleifend quam adipiscing vitae proin sagittis nisl. Condimentum id venenatis a condimentum.
</p>

<p>
Malesuada fames ac turpis egestas sed. Quis varius quam quisque id diam. Porttitor leo a diam sollicitudin tempor. Vestibulum mattis ullamcorper velit sed ullamcorper morbi tincidunt. Tortor condimentum lacinia quis vel eros donec ac. Sit amet mauris commodo quis imperdiet massa. Viverra nibh cras pulvinar mattis nunc sed blandit libero. Eu turpis egestas pretium aenean. Ridiculus mus mauris vitae ultricies. Euismod nisi porta lorem mollis aliquam ut porttitor leo a. Quis eleifend quam adipiscing vitae. At volutpat diam ut venenatis tellus.
</p>

<p>
Lacus vestibulum sed arcu non odio euismod lacinia. Nam aliquam sem et tortor. Aliquam vestibulum morbi blandit cursus risus at. At consectetur lorem donec massa sapien. Tortor consequat id porta nibh venenatis cras sed. Ornare suspendisse sed nisi lacus sed viverra tellus in hac. Lacus luctus accumsan tortor posuere ac ut consequat semper viverra. Quis lectus nulla at volutpat diam ut venenatis tellus. Nunc mi ipsum faucibus vitae aliquet nec ullamcorper sit amet. Leo in vitae turpis massa sed elementum tempus. Venenatis lectus magna fringilla urna porttitor rhoncus dolor purus non. Justo eget magna fermentum iaculis. Viverra tellus in hac habitasse platea dictumst vestibulum. Viverra orci sagittis eu volutpat odio facilisis mauris sit. Amet facilisis magna etiam tempor orci eu lobortis. Amet volutpat consequat mauris nunc congue. Lorem ipsum dolor sit amet. Morbi non arcu risus quis varius. Id eu nisl nunc mi ipsum faucibus vitae aliquet.
</p>
',
    100
),

(
    1,
    current_date,
    current_date,
    '<img src="http://localhost:8199/news/images/news/img06.jpg"/>',
    current_date,
    2,
    'Заголовок06',
    '<img src="img06.jpg"/>
<p>
Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ipsum consequat nisl vel pretium. Praesent elementum facilisis leo vel fringilla est. Mauris sit amet massa vitae tortor. Nulla porttitor massa id neque aliquam vestibulum. Malesuada bibendum arcu vitae elementum curabitur. Arcu dui vivamus arcu felis bibendum. Fermentum et sollicitudin ac orci phasellus egestas tellus. Ornare aenean euismod elementum nisi. Porttitor eget dolor morbi non arcu risus. Lacus sed turpis tincidunt id aliquet. Viverra tellus in hac habitasse platea. Aliquet bibendum enim facilisis gravida neque convallis a. Ligula ullamcorper malesuada proin libero nunc consequat interdum varius sit. Scelerisque mauris pellentesque pulvinar pellentesque habitant. Et leo duis ut diam quam nulla porttitor. Quis lectus nulla at volutpat diam ut venenatis tellus. Eget felis eget nunc lobortis. Ac tincidunt vitae semper quis lectus nulla at volutpat diam. Ullamcorper velit sed ullamcorper morbi tincidunt.
</p>

<p>
Quisque sagittis purus sit amet volutpat. Quis imperdiet massa tincidunt nunc pulvinar sapien et ligula ullamcorper. Consequat nisl vel pretium lectus quam id leo in. Vulputate ut pharetra sit amet aliquam id diam maecenas. Id semper risus in hendrerit gravida rutrum quisque non tellus. Velit egestas dui id ornare arcu odio ut sem nulla. Vel risus commodo viverra maecenas accumsan lacus. Amet risus nullam eget felis eget. Adipiscing enim eu turpis egestas pretium aenean pharetra magna ac. Eleifend mi in nulla posuere sollicitudin. Orci dapibus ultrices in iaculis nunc sed. Eleifend mi in nulla posuere sollicitudin aliquam ultrices sagittis orci. Suspendisse in est ante in nibh mauris cursus mattis molestie. Nibh tortor id aliquet lectus. Aenean sed adipiscing diam donec. Fermentum odio eu feugiat pretium nibh. Nec sagittis aliquam malesuada bibendum arcu vitae. Nulla malesuada pellentesque elit eget. Sit amet tellus cras adipiscing enim eu.
</p>

<img src="img06.jpg"/>
<p>

Risus nec feugiat in fermentum posuere urna nec. Sed faucibus turpis in eu mi bibendum neque egestas congue. Ornare aenean euismod elementum nisi. Lacinia quis vel eros donec ac odio tempor orci dapibus. Venenatis a condimentum vitae sapien pellentesque habitant. Eu feugiat pretium nibh ipsum consequat nisl vel. Faucibus turpis in eu mi bibendum neque egestas congue quisque. Vestibulum morbi blandit cursus risus at ultrices. Diam vel quam elementum pulvinar etiam non quam lacus. Neque egestas congue quisque egestas diam in. Nulla posuere sollicitudin aliquam ultrices sagittis orci a.
</p>

<p>
<b>
Faucibus turpis in eu mi bibendum neque egestas. Ultricies integer quis auctor elit sed vulputate mi. Tortor dignissim convallis aenean et tortor at. Tellus in metus vulputate eu scelerisque felis imperdiet proin fermentum. Nisl pretium fusce id velit ut tortor pretium viverra suspendisse. In hac habitasse platea dictumst quisque sagittis purus sit amet. A lacus vestibulum sed arcu non odio euismod lacinia at. Sollicitudin ac orci phasellus egestas tellus rutrum tellus pellentesque eu. Eu facilisis sed odio morbi quis commodo odio aenean sed. Nunc non blandit massa enim nec dui nunc. Nunc sed blandit libero volutpat. Tortor id aliquet lectus proin nibh nisl. Eget velit aliquet sagittis id consectetur purus ut.
</b>
</p>

<p>
Facilisis volutpat est velit egestas. Non quam lacus suspendisse faucibus interdum posuere lorem ipsum. Semper risus in hendrerit gravida rutrum. Etiam tempor orci eu lobortis elementum. Eu nisl nunc mi ipsum faucibus vitae. Enim praesent elementum facilisis leo vel. Duis at consectetur lorem donec massa sapien faucibus et molestie. Pellentesque massa placerat duis ultricies lacus sed turpis tincidunt id. Tortor aliquam nulla facilisi cras. Ipsum dolor sit amet consectetur adipiscing elit duis. Consequat interdum varius sit amet. Gravida cum sociis natoque penatibus et magnis dis. Bibendum enim facilisis gravida neque convallis a. Risus at ultrices mi tempus imperdiet. Quis eleifend quam adipiscing vitae proin sagittis nisl. Condimentum id venenatis a condimentum.
</p>

<p>
Malesuada fames ac turpis egestas sed. Quis varius quam quisque id diam. Porttitor leo a diam sollicitudin tempor. Vestibulum mattis ullamcorper velit sed ullamcorper morbi tincidunt. Tortor condimentum lacinia quis vel eros donec ac. Sit amet mauris commodo quis imperdiet massa. Viverra nibh cras pulvinar mattis nunc sed blandit libero. Eu turpis egestas pretium aenean. Ridiculus mus mauris vitae ultricies. Euismod nisi porta lorem mollis aliquam ut porttitor leo a. Quis eleifend quam adipiscing vitae. At volutpat diam ut venenatis tellus.
</p>

<p>
Lacus vestibulum sed arcu non odio euismod lacinia. Nam aliquam sem et tortor. Aliquam vestibulum morbi blandit cursus risus at. At consectetur lorem donec massa sapien. Tortor consequat id porta nibh venenatis cras sed. Ornare suspendisse sed nisi lacus sed viverra tellus in hac. Lacus luctus accumsan tortor posuere ac ut consequat semper viverra. Quis lectus nulla at volutpat diam ut venenatis tellus. Nunc mi ipsum faucibus vitae aliquet nec ullamcorper sit amet. Leo in vitae turpis massa sed elementum tempus. Venenatis lectus magna fringilla urna porttitor rhoncus dolor purus non. Justo eget magna fermentum iaculis. Viverra tellus in hac habitasse platea dictumst vestibulum. Viverra orci sagittis eu volutpat odio facilisis mauris sit. Amet facilisis magna etiam tempor orci eu lobortis. Amet volutpat consequat mauris nunc congue. Lorem ipsum dolor sit amet. Morbi non arcu risus quis varius. Id eu nisl nunc mi ipsum faucibus vitae aliquet.
</p>
',
    200
),

(
    2,
    current_date,
    current_date,
    '<img src="http://localhost:8199/news/images/news/img07.jpg"/>',
    current_date,
    3,
    'Заголовок07',
    '<img src="img07.jpg"/>
<p>
Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ipsum consequat nisl vel pretium. Praesent elementum facilisis leo vel fringilla est. Mauris sit amet massa vitae tortor. Nulla porttitor massa id neque aliquam vestibulum. Malesuada bibendum arcu vitae elementum curabitur. Arcu dui vivamus arcu felis bibendum. Fermentum et sollicitudin ac orci phasellus egestas tellus. Ornare aenean euismod elementum nisi. Porttitor eget dolor morbi non arcu risus. Lacus sed turpis tincidunt id aliquet. Viverra tellus in hac habitasse platea. Aliquet bibendum enim facilisis gravida neque convallis a. Ligula ullamcorper malesuada proin libero nunc consequat interdum varius sit. Scelerisque mauris pellentesque pulvinar pellentesque habitant. Et leo duis ut diam quam nulla porttitor. Quis lectus nulla at volutpat diam ut venenatis tellus. Eget felis eget nunc lobortis. Ac tincidunt vitae semper quis lectus nulla at volutpat diam. Ullamcorper velit sed ullamcorper morbi tincidunt.
</p>

<p>
Quisque sagittis purus sit amet volutpat. Quis imperdiet massa tincidunt nunc pulvinar sapien et ligula ullamcorper. Consequat nisl vel pretium lectus quam id leo in. Vulputate ut pharetra sit amet aliquam id diam maecenas. Id semper risus in hendrerit gravida rutrum quisque non tellus. Velit egestas dui id ornare arcu odio ut sem nulla. Vel risus commodo viverra maecenas accumsan lacus. Amet risus nullam eget felis eget. Adipiscing enim eu turpis egestas pretium aenean pharetra magna ac. Eleifend mi in nulla posuere sollicitudin. Orci dapibus ultrices in iaculis nunc sed. Eleifend mi in nulla posuere sollicitudin aliquam ultrices sagittis orci. Suspendisse in est ante in nibh mauris cursus mattis molestie. Nibh tortor id aliquet lectus. Aenean sed adipiscing diam donec. Fermentum odio eu feugiat pretium nibh. Nec sagittis aliquam malesuada bibendum arcu vitae. Nulla malesuada pellentesque elit eget. Sit amet tellus cras adipiscing enim eu.
</p>

<img src="img07.jpg"/>
<p>

Risus nec feugiat in fermentum posuere urna nec. Sed faucibus turpis in eu mi bibendum neque egestas congue. Ornare aenean euismod elementum nisi. Lacinia quis vel eros donec ac odio tempor orci dapibus. Venenatis a condimentum vitae sapien pellentesque habitant. Eu feugiat pretium nibh ipsum consequat nisl vel. Faucibus turpis in eu mi bibendum neque egestas congue quisque. Vestibulum morbi blandit cursus risus at ultrices. Diam vel quam elementum pulvinar etiam non quam lacus. Neque egestas congue quisque egestas diam in. Nulla posuere sollicitudin aliquam ultrices sagittis orci a.
</p>

<p>
<b>
Faucibus turpis in eu mi bibendum neque egestas. Ultricies integer quis auctor elit sed vulputate mi. Tortor dignissim convallis aenean et tortor at. Tellus in metus vulputate eu scelerisque felis imperdiet proin fermentum. Nisl pretium fusce id velit ut tortor pretium viverra suspendisse. In hac habitasse platea dictumst quisque sagittis purus sit amet. A lacus vestibulum sed arcu non odio euismod lacinia at. Sollicitudin ac orci phasellus egestas tellus rutrum tellus pellentesque eu. Eu facilisis sed odio morbi quis commodo odio aenean sed. Nunc non blandit massa enim nec dui nunc. Nunc sed blandit libero volutpat. Tortor id aliquet lectus proin nibh nisl. Eget velit aliquet sagittis id consectetur purus ut.
</b>
</p>

<p>
Facilisis volutpat est velit egestas. Non quam lacus suspendisse faucibus interdum posuere lorem ipsum. Semper risus in hendrerit gravida rutrum. Etiam tempor orci eu lobortis elementum. Eu nisl nunc mi ipsum faucibus vitae. Enim praesent elementum facilisis leo vel. Duis at consectetur lorem donec massa sapien faucibus et molestie. Pellentesque massa placerat duis ultricies lacus sed turpis tincidunt id. Tortor aliquam nulla facilisi cras. Ipsum dolor sit amet consectetur adipiscing elit duis. Consequat interdum varius sit amet. Gravida cum sociis natoque penatibus et magnis dis. Bibendum enim facilisis gravida neque convallis a. Risus at ultrices mi tempus imperdiet. Quis eleifend quam adipiscing vitae proin sagittis nisl. Condimentum id venenatis a condimentum.
</p>

<p>
Malesuada fames ac turpis egestas sed. Quis varius quam quisque id diam. Porttitor leo a diam sollicitudin tempor. Vestibulum mattis ullamcorper velit sed ullamcorper morbi tincidunt. Tortor condimentum lacinia quis vel eros donec ac. Sit amet mauris commodo quis imperdiet massa. Viverra nibh cras pulvinar mattis nunc sed blandit libero. Eu turpis egestas pretium aenean. Ridiculus mus mauris vitae ultricies. Euismod nisi porta lorem mollis aliquam ut porttitor leo a. Quis eleifend quam adipiscing vitae. At volutpat diam ut venenatis tellus.
</p>

<p>
Lacus vestibulum sed arcu non odio euismod lacinia. Nam aliquam sem et tortor. Aliquam vestibulum morbi blandit cursus risus at. At consectetur lorem donec massa sapien. Tortor consequat id porta nibh venenatis cras sed. Ornare suspendisse sed nisi lacus sed viverra tellus in hac. Lacus luctus accumsan tortor posuere ac ut consequat semper viverra. Quis lectus nulla at volutpat diam ut venenatis tellus. Nunc mi ipsum faucibus vitae aliquet nec ullamcorper sit amet. Leo in vitae turpis massa sed elementum tempus. Venenatis lectus magna fringilla urna porttitor rhoncus dolor purus non. Justo eget magna fermentum iaculis. Viverra tellus in hac habitasse platea dictumst vestibulum. Viverra orci sagittis eu volutpat odio facilisis mauris sit. Amet facilisis magna etiam tempor orci eu lobortis. Amet volutpat consequat mauris nunc congue. Lorem ipsum dolor sit amet. Morbi non arcu risus quis varius. Id eu nisl nunc mi ipsum faucibus vitae aliquet.
</p>
',
    500
),

(
    3,
    current_date,
    current_date,
    '<img src="http://localhost:8199/news/images/news/img08.jpg"/>',
    current_date,
    3,
    'Заголовок08',
    '<img src="img08.jpg"/>
<p>
Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ipsum consequat nisl vel pretium. Praesent elementum facilisis leo vel fringilla est. Mauris sit amet massa vitae tortor. Nulla porttitor massa id neque aliquam vestibulum. Malesuada bibendum arcu vitae elementum curabitur. Arcu dui vivamus arcu felis bibendum. Fermentum et sollicitudin ac orci phasellus egestas tellus. Ornare aenean euismod elementum nisi. Porttitor eget dolor morbi non arcu risus. Lacus sed turpis tincidunt id aliquet. Viverra tellus in hac habitasse platea. Aliquet bibendum enim facilisis gravida neque convallis a. Ligula ullamcorper malesuada proin libero nunc consequat interdum varius sit. Scelerisque mauris pellentesque pulvinar pellentesque habitant. Et leo duis ut diam quam nulla porttitor. Quis lectus nulla at volutpat diam ut venenatis tellus. Eget felis eget nunc lobortis. Ac tincidunt vitae semper quis lectus nulla at volutpat diam. Ullamcorper velit sed ullamcorper morbi tincidunt.
</p>

<p>
Quisque sagittis purus sit amet volutpat. Quis imperdiet massa tincidunt nunc pulvinar sapien et ligula ullamcorper. Consequat nisl vel pretium lectus quam id leo in. Vulputate ut pharetra sit amet aliquam id diam maecenas. Id semper risus in hendrerit gravida rutrum quisque non tellus. Velit egestas dui id ornare arcu odio ut sem nulla. Vel risus commodo viverra maecenas accumsan lacus. Amet risus nullam eget felis eget. Adipiscing enim eu turpis egestas pretium aenean pharetra magna ac. Eleifend mi in nulla posuere sollicitudin. Orci dapibus ultrices in iaculis nunc sed. Eleifend mi in nulla posuere sollicitudin aliquam ultrices sagittis orci. Suspendisse in est ante in nibh mauris cursus mattis molestie. Nibh tortor id aliquet lectus. Aenean sed adipiscing diam donec. Fermentum odio eu feugiat pretium nibh. Nec sagittis aliquam malesuada bibendum arcu vitae. Nulla malesuada pellentesque elit eget. Sit amet tellus cras adipiscing enim eu.
</p>

<img src="img08.jpg"/>
<p>

Risus nec feugiat in fermentum posuere urna nec. Sed faucibus turpis in eu mi bibendum neque egestas congue. Ornare aenean euismod elementum nisi. Lacinia quis vel eros donec ac odio tempor orci dapibus. Venenatis a condimentum vitae sapien pellentesque habitant. Eu feugiat pretium nibh ipsum consequat nisl vel. Faucibus turpis in eu mi bibendum neque egestas congue quisque. Vestibulum morbi blandit cursus risus at ultrices. Diam vel quam elementum pulvinar etiam non quam lacus. Neque egestas congue quisque egestas diam in. Nulla posuere sollicitudin aliquam ultrices sagittis orci a.
</p>

<p>
<b>
Faucibus turpis in eu mi bibendum neque egestas. Ultricies integer quis auctor elit sed vulputate mi. Tortor dignissim convallis aenean et tortor at. Tellus in metus vulputate eu scelerisque felis imperdiet proin fermentum. Nisl pretium fusce id velit ut tortor pretium viverra suspendisse. In hac habitasse platea dictumst quisque sagittis purus sit amet. A lacus vestibulum sed arcu non odio euismod lacinia at. Sollicitudin ac orci phasellus egestas tellus rutrum tellus pellentesque eu. Eu facilisis sed odio morbi quis commodo odio aenean sed. Nunc non blandit massa enim nec dui nunc. Nunc sed blandit libero volutpat. Tortor id aliquet lectus proin nibh nisl. Eget velit aliquet sagittis id consectetur purus ut.
</b>
</p>

<p>
Facilisis volutpat est velit egestas. Non quam lacus suspendisse faucibus interdum posuere lorem ipsum. Semper risus in hendrerit gravida rutrum. Etiam tempor orci eu lobortis elementum. Eu nisl nunc mi ipsum faucibus vitae. Enim praesent elementum facilisis leo vel. Duis at consectetur lorem donec massa sapien faucibus et molestie. Pellentesque massa placerat duis ultricies lacus sed turpis tincidunt id. Tortor aliquam nulla facilisi cras. Ipsum dolor sit amet consectetur adipiscing elit duis. Consequat interdum varius sit amet. Gravida cum sociis natoque penatibus et magnis dis. Bibendum enim facilisis gravida neque convallis a. Risus at ultrices mi tempus imperdiet. Quis eleifend quam adipiscing vitae proin sagittis nisl. Condimentum id venenatis a condimentum.
</p>

<p>
Malesuada fames ac turpis egestas sed. Quis varius quam quisque id diam. Porttitor leo a diam sollicitudin tempor. Vestibulum mattis ullamcorper velit sed ullamcorper morbi tincidunt. Tortor condimentum lacinia quis vel eros donec ac. Sit amet mauris commodo quis imperdiet massa. Viverra nibh cras pulvinar mattis nunc sed blandit libero. Eu turpis egestas pretium aenean. Ridiculus mus mauris vitae ultricies. Euismod nisi porta lorem mollis aliquam ut porttitor leo a. Quis eleifend quam adipiscing vitae. At volutpat diam ut venenatis tellus.
</p>

<p>
Lacus vestibulum sed arcu non odio euismod lacinia. Nam aliquam sem et tortor. Aliquam vestibulum morbi blandit cursus risus at. At consectetur lorem donec massa sapien. Tortor consequat id porta nibh venenatis cras sed. Ornare suspendisse sed nisi lacus sed viverra tellus in hac. Lacus luctus accumsan tortor posuere ac ut consequat semper viverra. Quis lectus nulla at volutpat diam ut venenatis tellus. Nunc mi ipsum faucibus vitae aliquet nec ullamcorper sit amet. Leo in vitae turpis massa sed elementum tempus. Venenatis lectus magna fringilla urna porttitor rhoncus dolor purus non. Justo eget magna fermentum iaculis. Viverra tellus in hac habitasse platea dictumst vestibulum. Viverra orci sagittis eu volutpat odio facilisis mauris sit. Amet facilisis magna etiam tempor orci eu lobortis. Amet volutpat consequat mauris nunc congue. Lorem ipsum dolor sit amet. Morbi non arcu risus quis varius. Id eu nisl nunc mi ipsum faucibus vitae aliquet.
</p>
',
    400
),

(
    4,
    current_date,
    current_date,
    '<img src="http://localhost:8199/news/images/news/img09.jpg"/>',
    current_date,3,'Заголовок09',
    '<img src="img09.jpg"/>
<p>
Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ipsum consequat nisl vel pretium. Praesent elementum facilisis leo vel fringilla est. Mauris sit amet massa vitae tortor. Nulla porttitor massa id neque aliquam vestibulum. Malesuada bibendum arcu vitae elementum curabitur. Arcu dui vivamus arcu felis bibendum. Fermentum et sollicitudin ac orci phasellus egestas tellus. Ornare aenean euismod elementum nisi. Porttitor eget dolor morbi non arcu risus. Lacus sed turpis tincidunt id aliquet. Viverra tellus in hac habitasse platea. Aliquet bibendum enim facilisis gravida neque convallis a. Ligula ullamcorper malesuada proin libero nunc consequat interdum varius sit. Scelerisque mauris pellentesque pulvinar pellentesque habitant. Et leo duis ut diam quam nulla porttitor. Quis lectus nulla at volutpat diam ut venenatis tellus. Eget felis eget nunc lobortis. Ac tincidunt vitae semper quis lectus nulla at volutpat diam. Ullamcorper velit sed ullamcorper morbi tincidunt.
</p>

<p>
Quisque sagittis purus sit amet volutpat. Quis imperdiet massa tincidunt nunc pulvinar sapien et ligula ullamcorper. Consequat nisl vel pretium lectus quam id leo in. Vulputate ut pharetra sit amet aliquam id diam maecenas. Id semper risus in hendrerit gravida rutrum quisque non tellus. Velit egestas dui id ornare arcu odio ut sem nulla. Vel risus commodo viverra maecenas accumsan lacus. Amet risus nullam eget felis eget. Adipiscing enim eu turpis egestas pretium aenean pharetra magna ac. Eleifend mi in nulla posuere sollicitudin. Orci dapibus ultrices in iaculis nunc sed. Eleifend mi in nulla posuere sollicitudin aliquam ultrices sagittis orci. Suspendisse in est ante in nibh mauris cursus mattis molestie. Nibh tortor id aliquet lectus. Aenean sed adipiscing diam donec. Fermentum odio eu feugiat pretium nibh. Nec sagittis aliquam malesuada bibendum arcu vitae. Nulla malesuada pellentesque elit eget. Sit amet tellus cras adipiscing enim eu.
</p>

<img src="img09.jpg"/>
<p>

Risus nec feugiat in fermentum posuere urna nec. Sed faucibus turpis in eu mi bibendum neque egestas congue. Ornare aenean euismod elementum nisi. Lacinia quis vel eros donec ac odio tempor orci dapibus. Venenatis a condimentum vitae sapien pellentesque habitant. Eu feugiat pretium nibh ipsum consequat nisl vel. Faucibus turpis in eu mi bibendum neque egestas congue quisque. Vestibulum morbi blandit cursus risus at ultrices. Diam vel quam elementum pulvinar etiam non quam lacus. Neque egestas congue quisque egestas diam in. Nulla posuere sollicitudin aliquam ultrices sagittis orci a.
</p>

<p>
<b>
Faucibus turpis in eu mi bibendum neque egestas. Ultricies integer quis auctor elit sed vulputate mi. Tortor dignissim convallis aenean et tortor at. Tellus in metus vulputate eu scelerisque felis imperdiet proin fermentum. Nisl pretium fusce id velit ut tortor pretium viverra suspendisse. In hac habitasse platea dictumst quisque sagittis purus sit amet. A lacus vestibulum sed arcu non odio euismod lacinia at. Sollicitudin ac orci phasellus egestas tellus rutrum tellus pellentesque eu. Eu facilisis sed odio morbi quis commodo odio aenean sed. Nunc non blandit massa enim nec dui nunc. Nunc sed blandit libero volutpat. Tortor id aliquet lectus proin nibh nisl. Eget velit aliquet sagittis id consectetur purus ut.
</b>
</p>

<p>
Facilisis volutpat est velit egestas. Non quam lacus suspendisse faucibus interdum posuere lorem ipsum. Semper risus in hendrerit gravida rutrum. Etiam tempor orci eu lobortis elementum. Eu nisl nunc mi ipsum faucibus vitae. Enim praesent elementum facilisis leo vel. Duis at consectetur lorem donec massa sapien faucibus et molestie. Pellentesque massa placerat duis ultricies lacus sed turpis tincidunt id. Tortor aliquam nulla facilisi cras. Ipsum dolor sit amet consectetur adipiscing elit duis. Consequat interdum varius sit amet. Gravida cum sociis natoque penatibus et magnis dis. Bibendum enim facilisis gravida neque convallis a. Risus at ultrices mi tempus imperdiet. Quis eleifend quam adipiscing vitae proin sagittis nisl. Condimentum id venenatis a condimentum.
</p>

<p>
Malesuada fames ac turpis egestas sed. Quis varius quam quisque id diam. Porttitor leo a diam sollicitudin tempor. Vestibulum mattis ullamcorper velit sed ullamcorper morbi tincidunt. Tortor condimentum lacinia quis vel eros donec ac. Sit amet mauris commodo quis imperdiet massa. Viverra nibh cras pulvinar mattis nunc sed blandit libero. Eu turpis egestas pretium aenean. Ridiculus mus mauris vitae ultricies. Euismod nisi porta lorem mollis aliquam ut porttitor leo a. Quis eleifend quam adipiscing vitae. At volutpat diam ut venenatis tellus.
</p>

<p>
Lacus vestibulum sed arcu non odio euismod lacinia. Nam aliquam sem et tortor. Aliquam vestibulum morbi blandit cursus risus at. At consectetur lorem donec massa sapien. Tortor consequat id porta nibh venenatis cras sed. Ornare suspendisse sed nisi lacus sed viverra tellus in hac. Lacus luctus accumsan tortor posuere ac ut consequat semper viverra. Quis lectus nulla at volutpat diam ut venenatis tellus. Nunc mi ipsum faucibus vitae aliquet nec ullamcorper sit amet. Leo in vitae turpis massa sed elementum tempus. Venenatis lectus magna fringilla urna porttitor rhoncus dolor purus non. Justo eget magna fermentum iaculis. Viverra tellus in hac habitasse platea dictumst vestibulum. Viverra orci sagittis eu volutpat odio facilisis mauris sit. Amet facilisis magna etiam tempor orci eu lobortis. Amet volutpat consequat mauris nunc congue. Lorem ipsum dolor sit amet. Morbi non arcu risus quis varius. Id eu nisl nunc mi ipsum faucibus vitae aliquet.
</p>
',
    1000
),

(
    5,
    current_date,
    current_date,
    '<img src="http://localhost:8199/news/images/news/img10.jpg"/>',
    current_date,
    1,
    'Заголовок10',
    '<img src="img10.jpg"/>
<p>
Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ipsum consequat nisl vel pretium. Praesent elementum facilisis leo vel fringilla est. Mauris sit amet massa vitae tortor. Nulla porttitor massa id neque aliquam vestibulum. Malesuada bibendum arcu vitae elementum curabitur. Arcu dui vivamus arcu felis bibendum. Fermentum et sollicitudin ac orci phasellus egestas tellus. Ornare aenean euismod elementum nisi. Porttitor eget dolor morbi non arcu risus. Lacus sed turpis tincidunt id aliquet. Viverra tellus in hac habitasse platea. Aliquet bibendum enim facilisis gravida neque convallis a. Ligula ullamcorper malesuada proin libero nunc consequat interdum varius sit. Scelerisque mauris pellentesque pulvinar pellentesque habitant. Et leo duis ut diam quam nulla porttitor. Quis lectus nulla at volutpat diam ut venenatis tellus. Eget felis eget nunc lobortis. Ac tincidunt vitae semper quis lectus nulla at volutpat diam. Ullamcorper velit sed ullamcorper morbi tincidunt.
</p>

<p>
Quisque sagittis purus sit amet volutpat. Quis imperdiet massa tincidunt nunc pulvinar sapien et ligula ullamcorper. Consequat nisl vel pretium lectus quam id leo in. Vulputate ut pharetra sit amet aliquam id diam maecenas. Id semper risus in hendrerit gravida rutrum quisque non tellus. Velit egestas dui id ornare arcu odio ut sem nulla. Vel risus commodo viverra maecenas accumsan lacus. Amet risus nullam eget felis eget. Adipiscing enim eu turpis egestas pretium aenean pharetra magna ac. Eleifend mi in nulla posuere sollicitudin. Orci dapibus ultrices in iaculis nunc sed. Eleifend mi in nulla posuere sollicitudin aliquam ultrices sagittis orci. Suspendisse in est ante in nibh mauris cursus mattis molestie. Nibh tortor id aliquet lectus. Aenean sed adipiscing diam donec. Fermentum odio eu feugiat pretium nibh. Nec sagittis aliquam malesuada bibendum arcu vitae. Nulla malesuada pellentesque elit eget. Sit amet tellus cras adipiscing enim eu.
</p>

<img src="img10.jpg"/>
<p>

Risus nec feugiat in fermentum posuere urna nec. Sed faucibus turpis in eu mi bibendum neque egestas congue. Ornare aenean euismod elementum nisi. Lacinia quis vel eros donec ac odio tempor orci dapibus. Venenatis a condimentum vitae sapien pellentesque habitant. Eu feugiat pretium nibh ipsum consequat nisl vel. Faucibus turpis in eu mi bibendum neque egestas congue quisque. Vestibulum morbi blandit cursus risus at ultrices. Diam vel quam elementum pulvinar etiam non quam lacus. Neque egestas congue quisque egestas diam in. Nulla posuere sollicitudin aliquam ultrices sagittis orci a.
</p>

<p>
<b>
Faucibus turpis in eu mi bibendum neque egestas. Ultricies integer quis auctor elit sed vulputate mi. Tortor dignissim convallis aenean et tortor at. Tellus in metus vulputate eu scelerisque felis imperdiet proin fermentum. Nisl pretium fusce id velit ut tortor pretium viverra suspendisse. In hac habitasse platea dictumst quisque sagittis purus sit amet. A lacus vestibulum sed arcu non odio euismod lacinia at. Sollicitudin ac orci phasellus egestas tellus rutrum tellus pellentesque eu. Eu facilisis sed odio morbi quis commodo odio aenean sed. Nunc non blandit massa enim nec dui nunc. Nunc sed blandit libero volutpat. Tortor id aliquet lectus proin nibh nisl. Eget velit aliquet sagittis id consectetur purus ut.
</b>
</p>

<p>
Facilisis volutpat est velit egestas. Non quam lacus suspendisse faucibus interdum posuere lorem ipsum. Semper risus in hendrerit gravida rutrum. Etiam tempor orci eu lobortis elementum. Eu nisl nunc mi ipsum faucibus vitae. Enim praesent elementum facilisis leo vel. Duis at consectetur lorem donec massa sapien faucibus et molestie. Pellentesque massa placerat duis ultricies lacus sed turpis tincidunt id. Tortor aliquam nulla facilisi cras. Ipsum dolor sit amet consectetur adipiscing elit duis. Consequat interdum varius sit amet. Gravida cum sociis natoque penatibus et magnis dis. Bibendum enim facilisis gravida neque convallis a. Risus at ultrices mi tempus imperdiet. Quis eleifend quam adipiscing vitae proin sagittis nisl. Condimentum id venenatis a condimentum.
</p>

<p>
Malesuada fames ac turpis egestas sed. Quis varius quam quisque id diam. Porttitor leo a diam sollicitudin tempor. Vestibulum mattis ullamcorper velit sed ullamcorper morbi tincidunt. Tortor condimentum lacinia quis vel eros donec ac. Sit amet mauris commodo quis imperdiet massa. Viverra nibh cras pulvinar mattis nunc sed blandit libero. Eu turpis egestas pretium aenean. Ridiculus mus mauris vitae ultricies. Euismod nisi porta lorem mollis aliquam ut porttitor leo a. Quis eleifend quam adipiscing vitae. At volutpat diam ut venenatis tellus.
</p>

<p>
Lacus vestibulum sed arcu non odio euismod lacinia. Nam aliquam sem et tortor. Aliquam vestibulum morbi blandit cursus risus at. At consectetur lorem donec massa sapien. Tortor consequat id porta nibh venenatis cras sed. Ornare suspendisse sed nisi lacus sed viverra tellus in hac. Lacus luctus accumsan tortor posuere ac ut consequat semper viverra. Quis lectus nulla at volutpat diam ut venenatis tellus. Nunc mi ipsum faucibus vitae aliquet nec ullamcorper sit amet. Leo in vitae turpis massa sed elementum tempus. Venenatis lectus magna fringilla urna porttitor rhoncus dolor purus non. Justo eget magna fermentum iaculis. Viverra tellus in hac habitasse platea dictumst vestibulum. Viverra orci sagittis eu volutpat odio facilisis mauris sit. Amet facilisis magna etiam tempor orci eu lobortis. Amet volutpat consequat mauris nunc congue. Lorem ipsum dolor sit amet. Morbi non arcu risus quis varius. Id eu nisl nunc mi ipsum faucibus vitae aliquet.
</p>
',
    300
),

(
    1,
    current_date,
    current_date,
    '<img src="http://localhost:8199/news/images/news/img11.jpg"/>',
    current_date,
    2,
    'Заголовок11',
    '<img src="img11.jpg"/>
<p>
Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ipsum consequat nisl vel pretium. Praesent elementum facilisis leo vel fringilla est. Mauris sit amet massa vitae tortor. Nulla porttitor massa id neque aliquam vestibulum. Malesuada bibendum arcu vitae elementum curabitur. Arcu dui vivamus arcu felis bibendum. Fermentum et sollicitudin ac orci phasellus egestas tellus. Ornare aenean euismod elementum nisi. Porttitor eget dolor morbi non arcu risus. Lacus sed turpis tincidunt id aliquet. Viverra tellus in hac habitasse platea. Aliquet bibendum enim facilisis gravida neque convallis a. Ligula ullamcorper malesuada proin libero nunc consequat interdum varius sit. Scelerisque mauris pellentesque pulvinar pellentesque habitant. Et leo duis ut diam quam nulla porttitor. Quis lectus nulla at volutpat diam ut venenatis tellus. Eget felis eget nunc lobortis. Ac tincidunt vitae semper quis lectus nulla at volutpat diam. Ullamcorper velit sed ullamcorper morbi tincidunt.
</p>

<p>
Quisque sagittis purus sit amet volutpat. Quis imperdiet massa tincidunt nunc pulvinar sapien et ligula ullamcorper. Consequat nisl vel pretium lectus quam id leo in. Vulputate ut pharetra sit amet aliquam id diam maecenas. Id semper risus in hendrerit gravida rutrum quisque non tellus. Velit egestas dui id ornare arcu odio ut sem nulla. Vel risus commodo viverra maecenas accumsan lacus. Amet risus nullam eget felis eget. Adipiscing enim eu turpis egestas pretium aenean pharetra magna ac. Eleifend mi in nulla posuere sollicitudin. Orci dapibus ultrices in iaculis nunc sed. Eleifend mi in nulla posuere sollicitudin aliquam ultrices sagittis orci. Suspendisse in est ante in nibh mauris cursus mattis molestie. Nibh tortor id aliquet lectus. Aenean sed adipiscing diam donec. Fermentum odio eu feugiat pretium nibh. Nec sagittis aliquam malesuada bibendum arcu vitae. Nulla malesuada pellentesque elit eget. Sit amet tellus cras adipiscing enim eu.
</p>

<img src="img11.jpg"/>
<p>

Risus nec feugiat in fermentum posuere urna nec. Sed faucibus turpis in eu mi bibendum neque egestas congue. Ornare aenean euismod elementum nisi. Lacinia quis vel eros donec ac odio tempor orci dapibus. Venenatis a condimentum vitae sapien pellentesque habitant. Eu feugiat pretium nibh ipsum consequat nisl vel. Faucibus turpis in eu mi bibendum neque egestas congue quisque. Vestibulum morbi blandit cursus risus at ultrices. Diam vel quam elementum pulvinar etiam non quam lacus. Neque egestas congue quisque egestas diam in. Nulla posuere sollicitudin aliquam ultrices sagittis orci a.
</p>

<p>
<b>
Faucibus turpis in eu mi bibendum neque egestas. Ultricies integer quis auctor elit sed vulputate mi. Tortor dignissim convallis aenean et tortor at. Tellus in metus vulputate eu scelerisque felis imperdiet proin fermentum. Nisl pretium fusce id velit ut tortor pretium viverra suspendisse. In hac habitasse platea dictumst quisque sagittis purus sit amet. A lacus vestibulum sed arcu non odio euismod lacinia at. Sollicitudin ac orci phasellus egestas tellus rutrum tellus pellentesque eu. Eu facilisis sed odio morbi quis commodo odio aenean sed. Nunc non blandit massa enim nec dui nunc. Nunc sed blandit libero volutpat. Tortor id aliquet lectus proin nibh nisl. Eget velit aliquet sagittis id consectetur purus ut.
</b>
</p>

<p>
Facilisis volutpat est velit egestas. Non quam lacus suspendisse faucibus interdum posuere lorem ipsum. Semper risus in hendrerit gravida rutrum. Etiam tempor orci eu lobortis elementum. Eu nisl nunc mi ipsum faucibus vitae. Enim praesent elementum facilisis leo vel. Duis at consectetur lorem donec massa sapien faucibus et molestie. Pellentesque massa placerat duis ultricies lacus sed turpis tincidunt id. Tortor aliquam nulla facilisi cras. Ipsum dolor sit amet consectetur adipiscing elit duis. Consequat interdum varius sit amet. Gravida cum sociis natoque penatibus et magnis dis. Bibendum enim facilisis gravida neque convallis a. Risus at ultrices mi tempus imperdiet. Quis eleifend quam adipiscing vitae proin sagittis nisl. Condimentum id venenatis a condimentum.
</p>

<p>
Malesuada fames ac turpis egestas sed. Quis varius quam quisque id diam. Porttitor leo a diam sollicitudin tempor. Vestibulum mattis ullamcorper velit sed ullamcorper morbi tincidunt. Tortor condimentum lacinia quis vel eros donec ac. Sit amet mauris commodo quis imperdiet massa. Viverra nibh cras pulvinar mattis nunc sed blandit libero. Eu turpis egestas pretium aenean. Ridiculus mus mauris vitae ultricies. Euismod nisi porta lorem mollis aliquam ut porttitor leo a. Quis eleifend quam adipiscing vitae. At volutpat diam ut venenatis tellus.
</p>

<p>
Lacus vestibulum sed arcu non odio euismod lacinia. Nam aliquam sem et tortor. Aliquam vestibulum morbi blandit cursus risus at. At consectetur lorem donec massa sapien. Tortor consequat id porta nibh venenatis cras sed. Ornare suspendisse sed nisi lacus sed viverra tellus in hac. Lacus luctus accumsan tortor posuere ac ut consequat semper viverra. Quis lectus nulla at volutpat diam ut venenatis tellus. Nunc mi ipsum faucibus vitae aliquet nec ullamcorper sit amet. Leo in vitae turpis massa sed elementum tempus. Venenatis lectus magna fringilla urna porttitor rhoncus dolor purus non. Justo eget magna fermentum iaculis. Viverra tellus in hac habitasse platea dictumst vestibulum. Viverra orci sagittis eu volutpat odio facilisis mauris sit. Amet facilisis magna etiam tempor orci eu lobortis. Amet volutpat consequat mauris nunc congue. Lorem ipsum dolor sit amet. Morbi non arcu risus quis varius. Id eu nisl nunc mi ipsum faucibus vitae aliquet.
</p>
',
    250
);

INSERT INTO comments (created, article_id, user_id, text)
VALUES
(current_date-100,1,1,'Комментарий 1'),
(current_date-99,1,2,'Комментарий 2'),
(current_date-98,1,1,'Комментарий 3'),
(current_date-97,1,2,'Комментарий 4'),
(current_date-96,1,1,'Комментарий 5'),
(current_date-95,1,2,'Комментарий 6'),
(current_date-94,1,1,'Комментарий 7'),
(current_date-100,2,1,'Комментарий 1'),
(current_date-99,2,2,'Комментарий 2'),
(current_date-98,2,1,'Комментарий 3'),
(current_date-97,3,2,'Комментарий 4'),
(current_date-96,3,1,'Комментарий 5'),
(current_date-95,3,2,'Комментарий 6'),
(current_date-94,3,1,'Комментарий 7'),
(current_date-100,4,1,'Комментарий 1'),
(current_date-99,5,2,'Комментарий 2'),
(current_date-98,5,1,'Комментарий 3'),
(current_date-97,6,2,'Комментарий 4'),
(current_date-96,6,1,'Комментарий 5'),
(current_date-95,6,2,'Комментарий 6'),
(current_date-94,7,1,'Комментарий 7'),
(current_date-100,7,1,'Комментарий 1'),
(current_date-99,7,2,'Комментарий 2'),
(current_date-98,7,1,'Комментарий 3'),
(current_date-97,8,2,'Комментарий 4'),
(current_date-96,9,1,'Комментарий 5'),
(current_date-95,9,2,'Комментарий 6'),
(current_date-94,10,1,'Комментарий 7')
;


INSERT INTO  article_likes(article_id, user_id,value)
VALUES
(1,1,1),
(1,1,1),
(1,1,1),
(1,1,1),
(1,1,1),
(1,1,1),
(1,1,1),
(1,1,1),
(1,1,1),
(1,1,1),
(1,1,1),
(1,1,1),
(1,1,1),
(1,1,1),
(1,1,1),
(1,1,1),
(1,1,1),
(1,1,1),
(1,1,1),
(1,1,1),
(1,1,1),
(1,1,1),
(1,1,1),
(1,1,1),
(1,1,1),
(1,1,1),
(1,1,1),
(1,1,1),
(1,1,1),
(1,1,1),
(1,1,1),
(1,1,1),
(1,1,1),
(1,1,1),


(1,1,-1),
(1,1,-1),
(1,1,-1),
(1,1,-1),
(1,1,-1),
(1,1,-1),
(1,1,-1),
(1,1,-1),
(1,1,-1),
(1,1,-1),
(1,1,-1),
(1,1,-1),

(2,1,1),
(2,1,1),
(2,1,1),
(2,1,1),
(2,1,1),
(2,1,1),
(2,1,1),

(3,1,-1),
(3,1,-1),
(3,1,-1),
(3,1,-1),
(3,1,-1),
(3,1,-1),
(3,1,-1)
;
