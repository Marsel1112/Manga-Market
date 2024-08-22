function displayBooks(books) {
    const container = document.getElementById('form-container');
    container.innerHTML = ''; // Очистка контейнера

    container.style.display = 'flex';
    container.style.flexWrap = 'wrap';
    container.style.justifyContent = 'flex-start';

    books.forEach(book => {
        const card = document.createElement('div');
        card.className = 'product-card';
        card.style.border = '1px solid #ccc';
        card.style.padding = '10px';
        card.style.margin = '10px';
        card.style.width = '300px';
        card.style.height = '150px';

        // Создание элемента для содержимого продукта
        const productContent = document.createElement('div');
        productContent.style.display = 'flex'; // Используем flexbox
        productContent.style.alignItems = 'center'; // Выровнять по центру вертикально

        // Создание изображения
        const img = document.createElement('img');
        img.src = book.url;
        img.alt = book.bookTitle || 'Без названия';
        img.style.width = '100px'; // Фиксированная ширина изображения
        img.style.height = 'auto'; // Автоматическая высота
        img.style.marginRight = '10px'; // Отступ справа от изображения

        // Создание контейнера для информации о книге
        const productInfo = document.createElement('div');
        productInfo.style.flex = '1'; // Занимает оставшееся пространство

        // Заголовок книги
        const h3 = document.createElement('h3');
        h3.textContent = book.bookTitle || 'Без названия';
        h3.style.color = '#f3f1f1'; // Цвет текста
        productInfo.appendChild(h3);

        // Жанр книги
        const p = document.createElement('p');
        p.textContent = book.bookGenre || 'Неизвестный жанр';
        p.style.color = '#ea0d0d'; // Цвет текста
        productInfo.appendChild(p);

        // Цена книги
        const span = document.createElement('span');
        span.textContent = 'Цена: $' + (book.bookPrice ? book.bookPrice.toFixed(2) : 'Не указана');
        span.style.color = '#09ee09'; // Цвет текста
        productInfo.appendChild(span);

        // Собираем все элементы вместе
        productContent.appendChild(img);
        productContent.appendChild(productInfo);
        card.appendChild(productContent);
        container.appendChild(card); // Добавление карточки в контейнер
    });
}