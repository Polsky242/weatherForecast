function getOptions(word, citiesArr) {
    return citiesArr.filter(city => {
        const regex = new RegExp(word, 'gi');
        return city.match(regex);
    });
}

const api = '../js/cities.json';
const cities = [];

fetch(api)
    .then(res => res.json())
    .then(data => {
        cities.push(...data.cities.map(city => city.name));

        const searchInput = document.querySelector('.search');
        const searchOptions = document.querySelector('.options');

        function displayOptions() {
            const options = getOptions(this.value, cities);
            const html = options.map(city => {
                return `<li><span>${city}</span></li>`;
            })
                .slice(0, 3)
                .join('');
            searchOptions.innerHTML = this.value ? html : null;

            const optionItems = searchOptions.querySelectorAll('li');

            optionItems.forEach(item => {
                item.addEventListener('click', () => {
                    searchInput.value = item.textContent;
                    searchOptions.innerHTML = '';
                    // Выполнение формы при выборе города
                    document.querySelector('form').submit();
                });
            });
        }

        searchInput.addEventListener('input', displayOptions);
        searchInput.addEventListener('keyup', displayOptions);
    });






