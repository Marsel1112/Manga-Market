function showForm(formType) {
    const formContainer = document.getElementById('form-container');
    let formHTML = '';
    if (formType === 'form1') {
        fetch('/Market/main/library',{
            method: 'GET'
        }).then(response => {
            if (!response.ok) {
                throw new Error('Сетевая ошибка');
            }
            return response.json();
        }).then(books => displayBooks(books)).catch(error => console.error('Ошибка:', error));
    }
    else if (formType === 'form2') {
        fetch('/Market/main/book',{
            method: 'GET'
        }).then(response => {
            if (!response.ok) {
                throw new Error('Сетевая ошибка');
            }
            return response.json();
        }).then(books => displayBooks(books)).catch(error => console.error('Ошибка:', error));
    }
    else if (formType === 'form3') {
        formHTML = `
                    <form class="form-container" id="form3" action="/Market/main/book" method="post">
                        <input type="text1" name="bookTitle" required placeholder="Введите название книги">
                        <input type="text2" name="bookGenre" required placeholder="Введите жанр книги">
                        <input type="text3" name="bookPrice" required placeholder="Цена книги">
                        <input type="text4" name="count" required placeholder="Колличество книг">
                        <input type="textUrl" name="url" required placeholder="Вставьте url обложки">
                        <button type="submit">Выставить на продажу</button>
                    </form>
                `;
    }
    formContainer.innerHTML = formHTML;
    if (formType === 'form1') {
        const  labelStyle = formContainer.querySelector("label[for='email']").style;
        labelStyle.color = '#f3f1f1';
        labelStyle.fontSize = '64px';
    }
    else if (formType === 'form3') {
        applyForm3Styles(formContainer);
    }


}