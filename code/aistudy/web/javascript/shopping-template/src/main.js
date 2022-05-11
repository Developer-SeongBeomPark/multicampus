//Fetch the items from the json file, return response
function loadItems(){
    return fetch('data/data.json')
    .then(response => response.json())//json객체로 변환
    .then(json => json.items);
 
}
 
//update the list with the given items
function displayItems(items){
    const container = document.querySelector('.items'); //ul 태그 찾는다.
    //const html = items.map(item => createHTMLString(item)).join('');
    //console.log(html);
    container.innerHTML = items.map(item => createHTMLString(item)).join(''); //생성된 li태그를 문자열로 변경(join)
}
 
//create HTML List iem from the given data item
function createHTMLString(item) {
    return `
    <li class="item">
        <img src="${item.image}" alt="${item.type}" class="item__thumbnail">
        <span class="item__description">${item.gender}, ${item.size}</span>  
    </li>
    `;
}
 
function onButtonClick(event, items){//이벤트가 발생하는 버튼에 필터링되는 값을 가지도록 한다.
    const dataset = event.target.dataset;
    const key = dataset.key;
    const value = dataset.value;
    
    if(key == null || value == null){
        return;
    }
 
    const filtered = items.filter(item => item[key] === value);
    console.log(filtered);
    displayItems(filtered);
 
}
 
function setEventListeners(items){
    const log = document.querySelector('.logo');
    const buttons = document.querySelector('.buttons');
    log.addEventListener('click', () => displayItems(items));
    buttons.addEventListener('click', event => onButtonClick(event, items));
}
//main (시작)
loadItems()
    .then(items => {
        console.log(items);
        displayItems(items);
        setEventListeners(items);
    })
    .catch(console.log);