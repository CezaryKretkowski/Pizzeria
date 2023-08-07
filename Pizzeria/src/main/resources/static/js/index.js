window.addEventListener('scroll',function(){
    var header = this.document.getElementById("navbarHeder");
    var scrollTop = window.pageYOffset || document.documentElement.scrollTop;

    if (scrollTop > 500) {
         header.classList.add('menu');

       } else {

        header.classList.remove('menu');
    }
});


function scrollToHaader(id){
    var header= document.getElementById(id);
    header.scrollIntoView({ behavior: "smooth" });
}
function addTobucket(pizza){

    if(localStorage.getItem("busketItem"+pizza.id)===null){
        var item = {"name":pizza.name,"price":pizza.price,"quntyty":1,"totalPrice":pizza.price};
        localStorage.setItem('busketItem'+pizza.id,JSON.stringify(item));
    }else{
        var itemString =localStorage.getItem("busketItem"+pizza.id);
        var item=JSON.parse(itemString);
        item.quntyty+=1;
        localStorage.setItem('busketItem'+pizza.id,JSON.stringify(item));
    }
    
    dispalyProducts();

}
function dispalyProducts(){
    var busketContainer = document.getElementById("busketContainer");
    
    busketContainer.innerHTML='';
    var val =parseInt(localStorage.length);
    if(val==0)
        busketContainer.innerHTML+=`<div>Brak produktów</div>`
    else
        for(let i in localStorage){
            var itemString = localStorage[i];
            if(i.includes("busketItem")){
                var item=JSON.parse(itemString);
                busketContainer.innerHTML+=`            
                <div class="m-3 border-bottom border-dark " >
                    <button type="button" class="btn-close float-end" value="`+i+`" onclick="deleteFromBusket(event.target.value)"></button>
                    <h6>Nazwa: `+item.name+`</h6>
                    <h6>Cena: `+item.price+`</h6>
                    <div class="mb-2 row">
                        <h6 class="form-label col">Ilość :</h6>
                        <input type="number" id="`+i+`" onchange="updateTotalPrice()" value="`+item.quntyty+`"  class="form-control col w-50" >
                    </div>
                </div>`;
            }
        }
        updateTotalPrice();
}
function updateTotalPriceItem(id){
    var numberInput = document.getElementById(id).value;
    var itemString = localStorage.getItem(id);
    var item=JSON.parse(itemString);
    item.quntyty=numberInput;
    item.totalPrice = 0;
    for(let i =0;i<item.quntyty;i++)
        item.totalPrice+=item.price;
    return item.totalPrice.toFixed(2);
}
function updateTotalPrice(){
    var price =0;
    for(let i in localStorage){
        if(i.includes("busketItem")){
            price+=updateTotalPriceItem(i);
        }
    }
    document.getElementById('total_Price').innerHTML=price+" zł";
}
function deleteFromBusket(id){
    localStorage.removeItem(id);
    dispalyProducts();
}
function getBusket(){
    dispalyProducts();
}