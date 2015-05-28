var itemsJson = {
    "fireworks": [
        {
            "name": "Sony FireWorks",
            "id": "aa",
			"tot" :0,
            "products": [
                {
                            "name": "Adidas Men Red Printed T-shirt",
                            "quan" :0,
							"tot":0,
                            "amt": "200",
                            "banner": "img/diwalicrakers-adbanner2.jpg"
                        },
                        {
                            "name": "Adidas Men Red Printed T-shirt",
                             "quan" :0,
							"tot":0,
                            "amt": "200",
                            "banner": "img/diwalicrakers-adbanner2.jpg"
                        },
                   
                        {
                            "name": "Adidas Men Red Printed T-shirt",
                             "quan" :0,
							"tot":0,
                            "amt": "200",
                            "banner": "img/diwalicrakers-adbanner2.jpg"
                        },
                        {
                            "name": "Adidas Men Red Printed T-shirt",
                             "quan" :0,
							"tot":0,
                            "amt": "200",
                            "banner": "img/diwalicrakers-adbanner2.jpg"
                        }
                   
            ]
        },
        {
            "name": "abc FireWorks",
            "id": "bb",
			"tot" :0,
			"products": [
                {
                  
                            "name": "Adidas Men Red Printed T-shirt",
                            "amt": "200",
							 "quan" :0,
							"tot":0,
                            "banner": "img/diwalicrakers-adbanner2.jpg"
                        },
                        {
                            "name": "Adidas Men Red Printed T-shirt",
                            "amt": "200",
							 "quan" :0,
							"tot":0,
                            "banner": "img/diwalicrakers-adbanner2.jpg"
                        }
                    
            ]
        },
        {
            "name": "ggg FireWorks",
            "id": "cc",
			"tot" :0,
			"products": [
                {
                   
                            "name": "Adidas Men Red Printed T-shirt",
                             "quan" :0,
							"tot":0,
                            "amt": "200",
                            "banner": "img/diwalicrakers-adbanner2.jpg"
                        },
                        {
                            "name": "Adidas Men Red Printed T-shirt",
                             "quan" :0,
							"tot":0,
                            "amt": "200",
                            "banner": "img/diwalicrakers-adbanner2.jpg"
                        }
                   
            ]
        },
        {
            "name": "yyy FireWorks",
            "id": "dd",
			"tot" :0,
			"products": [
                {
                            "name": "Adidas Men Red Printed T-shirt",
                             "quan" :0,
							"tot":0,
                            "amt": "200",
                            "banner": "img/diwalicrakers-adbanner2.jpg"
                        },
                        {
                            "name": "Adidas Men Red Printed T-shirt",
                             "quan" :0,
							"tot":0,
                            "amt": "200",
                            "banner": "img/diwalicrakers-adbanner2.jpg"
                        }
                   
            ]
        }
    ],

    "tableHeader": "<td>Product Name</td><td class='td-qty'>Quantity</td><td>Unit Price</td><td>Sub Total</td>",
	"active" : "aa",
	"maxLimit" : "5000"
	}


function generator(){

var tabContent ='<div  role="tabpanel" class="table-responsive tab-pane fade"></div>';
var tableContent = '<table class="table table-bordered tbl-cart"></table>';
var theadContent = '<thead><tr></tr><tr></tr></thead><tbody></tbody>';
var trListHead = '<tr class="listHead"><td colspan="5"></td></tr>'
var trItemContent ='<tr><td><a data-content="" data-html="true" data-popover="true" class="" data-original-title="" title=""></a></td><td><select data-rate="100" class="qtySelect"><option value="0">Please select</option></select></td><td class="price"></td><td><span class="fa fa-inr"></span> <span class="subtotal">0</span></td></tr>'
var tabContainer = $('<div class="row"><div class="col-md-3"><div class="lead text-uppercase">Category</div><div role="tablist" id="myTab" class="list-group text-uppercase "></div></div><div class="col-lg-9 col-md-9 col-sm-12"><div class="lead text-uppercase">Shopping Cart <div class="pull-right">Grand Total: <span class="fa fa-inr 2x"> <span class="grantTotal">0.00</span></span></div></div><div class="tab-content"></div></div></div>'); 
var buttonContent = '<div class="btn-group btns-cart"><a data-keyboard="false" data-backdrop="static" data-target="#alert" data-toggle="modal" class="btn btn-warning btn-lg" href="#">Confirm order</a><button type="button" class="btn btn-warning" onclick="window.location=\'shopping-cart.html\'">Checkout <i class="fa fa-arrow-circle-right"></i></button></div>'; 

var itemList = itemsJson.fireworks 
var htmlContent = "";
var tempContent;
var headerList = itemsJson.tableHeader;

for(var init in itemList){
	tempContent = $(tabContent);
	tempContent.attr("id",itemList[init].id);
	if(itemsJson.active == itemList[init].id)
		tempContent.addClass("active").addClass("in")
	tempContent.append(tableContent); 
	tempContent.find(".tbl-cart").append(theadContent);
	tabContainer.find(".grantTotal").attr("data-limit",itemsJson.maxLimit);
	
	tabContainer.find("#myTab").append('<a data-toggle="tab" role="tab" class="list-group-item" href="#'+itemList[init].id+'">'+itemList[init].name+'</a>')
	tempContent.find(".tbl-cart thead tr").each(function(i,cur){
		if(i==0){
			$(cur).append('<td colspan="5" class="fireworks">'+itemList[init].name+'</td>')
		}else 
		if(i==1){
			$(cur).append(headerList);
		}
	});
	var tempBody = tempContent.find(".tbl-cart tbody");
	var products = itemList[init].products;
	for(var len in products){
	
		tempBody.append('<tr class="listHead"><td colspan="5">'+products[len].itemCat+'</td></tr>')
		var productItem = products[len].items
		for(var ilen in productItem){
			var temptrItemContent = $(trItemContent);
			var tempItems =productItem[ilen];
			temptrItemContent.find("td").each(function(i,cur){
				if(i==0){
					var tempAnchor = $(cur).find("a");
					tempAnchor.attr("data-content","<img src='"+tempItems.banner+"'>")
					tempAnchor.text(tempItems.name)
				}else if(i==1){
					var tempSelect = $(cur).find("select");
					tempSelect.attr("data-rate",tempItems.amt)
					var maxItem = tempItems.max;
					if(maxItem==undefined)
						maxItem=0;
					else
						maxItem = parseInt(maxItem);
						
					for(var j=1; j<= maxItem; j++ ){
						tempSelect.append("<option value='"+j+"'>"+j+"</option>")
					}
				}else if(i==2){
						$(cur).append('<span class="fa fa-inr"></span>'+tempItems.amt)
				}else if(i==3){
				
				}
			});
			
			tempBody.append(temptrItemContent);
		}
		
		
	}
	tempBody.append('<tr class="tr-total"><td align="right" colspan="3">Total</td><td class="" colspan="2"><b><span class="fa fa-inr"></span> <span class="total">0</span></b></td></tr>');
	
	
	
	tabContainer.find(".tab-content").append(tempContent);
}

tabContainer.find(".tab-content").append(buttonContent);
$(".containerWrapper").html(tabContainer);
initializeCall();
}


function selectedItem(){


var grantTotalDiv = $(".grantTotal")
var maxLimit = parseFloat($(".grantTotal").attr("data-limit")).toFixed(2);
var grantAmt = parseFloat($(".grantTotal").text());
if(grantAmt> maxLimit){
	alert("excceds Max-Limit"); 
	return false;
}
	

var category ="";
var selectItem ={"fireworks" :[],"grandTotal":""}
	$(".containerWrapper .tab-content .tab-pane").each(function(){
		var curElem = $(this);
		
		$("thead .fireworks",curElem).each(function(){
			var fireWork = {"name" :"","products":[],"total":""};
			fireWork.name = $(this).text();
			
			
			
			var catItem = {"itemCat":"","items":[]};
			var catPush = false;
			$("tbody tr",curElem).each(function(i,subTRitem){
				 subTRitem = $(subTRitem);
				
				if(subTRitem.hasClass("listHead")){
						
						
						
						if(catItem.items.length!=0){
							fireWork.products.push(catItem);
							catItem = {"itemCat":"","items":[]};
						}
						catItem.itemCat = $("td",subTRitem).text();
							
				}else if(subTRitem.hasClass("tr-total")){
					fireWork.total = $("td .total",subTRitem).text();
					if(catItem.items.length!=0)
						fireWork.products.push(catItem);
				}else{
					var selectedItem = catItem; 
					var itemDetails = {"name" :"","quantity":"","unitprice":"","totalprice":"" }
					$("td",subTRitem).each(function(i,inputDetails){
						if(i==0)
							itemDetails.name = $("a",inputDetails).text();
						else if(i==1){
							itemDetails.quantity = $("select",inputDetails).val();
							itemDetails.unitprice = $("select",inputDetails).attr("data-rate");
							
						}else if(i==3)
							itemDetails.totalprice = $(".subtotal",inputDetails).text();
					});
					if(itemDetails.quantity != 0)
						selectedItem.items.push(itemDetails)
					
				}
				
				
				
			});
			if(fireWork.products.length!=0)
				selectItem.fireworks.push(fireWork);
			
			selectItem.grandTotal =$(".grantTotal").text();			
				
		});
		
	});	

		
console.log(selectItem);
}