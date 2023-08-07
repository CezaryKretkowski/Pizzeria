function navigate(nr)
{
    orders = document.getElementById("#orders");
    menu = document.getElementById("#menu");
    about = document.getElementById("#about");


    switch(nr){
        case 0 :orders.style.display='block';
                menu.style.display='none';
                about.style.display='none';
            break;
        case 1 :orders.style.display='none';
                menu.style.display='block';
                about.style.display='none';
            break;
        case 2 :orders.style.display='none';
                menu.style.display='none';
                about.style.display='block';
        break;
        default:orders.style.display='block';
                menu.style.display='none';
                about.style.display='none';
    }
}

var isopen=false;

function navabarTriger(){
    isopen=!isopen;
    if(isopen==true){
        this.document.getElementById("navigationBar").style.display="block";
    }else{
        this.document.getElementById("navigationBar").style.display="none";
    }
}
window.addEventListener('resize', function(event){
        var nav = this.document.getElementById("navigationBar");
        var button = this.document.getElementById("menu-button");
        if((this.window.innerWidth/100)*10<140){
            nav.classList.remove("NavBar");
            nav.classList.add("NavBarAbsolut");
            button.style.display="block";
            button.disable=false;
            
        }else
        {
            nav.classList.add("NavBar");
            nav.classList.remove("NavBarAbsolut");    
            button.style.display="none";
            button.disable=true;        
        }
  });


function editButton(id){
  
    this.document.getElementById("edit"+id).style.display='';
    this.document.getElementById("view"+id).style.display='none';

}
function cancelButton(id){
   
    this.document.getElementById("edit"+id).style.display='none';
    this.document.getElementById("view"+id).style.display='';

}