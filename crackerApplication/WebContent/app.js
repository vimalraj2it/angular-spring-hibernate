
var sampleApp = angular.module('sampleApp', ['ngRoute']);
   sampleApp.config(function($routeProvider) {
        $routeProvider

            // route for the home page
            .when('/', {
                templateUrl : 'pages/home.html',
                controller  : 'mainController'
            })
            
            .when('/orderItemCtrl', {
                templateUrl : 'pages/home.html',
                controller  : 'mainController'
            })

            // route for the contact page
            .when('/confirmOrderCtrl', {
                templateUrl : 'pages/confirm.html',
                controller  : 'confirmController'
            }).
            otherwise({
                redirectTo: '/'
            });;
    });

	sampleApp.factory('MyService', function(){
		
		  var header = {"header" :[{
          label :"Order Items",
          ctrl :"orderItemCtrl"

        },{
          label :"Confirm Order",
          ctrl :"confirmOrderCtrl"

        },{
          label :"Service",
          ctrl :"serviceCtrl"

        },{
          label :"About",
          ctrl :"aboutCtrl"

        },{
          label :"Contact",
          ctrl :"ContactCtrl"

		  }],
		  "fireworks":itemsJson.fireworks
		  
		  
		  };
		return header;
    
  
});
	
	sampleApp.factory('HeaderService', function($http){
	    return {
	        header : function(){
	            return $http.post('header.do');
	        }
	    }
	});
	sampleApp.factory('productService', function($http){
	    return {
	        supplier : function(){
	            return $http.post('supplier.do');
	        }
	    }
	});
	sampleApp.factory('orderService', function($http){
	    return {
	        order : function(data){
	            return $http.post('order.do',data);
	        }
	    }
	});
	
	
	sampleApp.factory('sharedService', function($http) {
	    var sharedService = {};
	    var headerData={};
	    sharedService.header = function(){$http.post('header.do').then(function(response){
	    	this.headerData = response.data
	    	return response.data;
	    });
	    }
	    sharedService.getHeader = function(){
	    	return headerData;
	    };
	    return sharedService;
	});
    // create the controller and inject Angular's $scope
    sampleApp.controller('mainController', function($scope,HeaderService,productService) {
        // create a message to display in our view
    	
    	HeaderService.header().then(function(response){
    		 $scope.headers = response.data;
    	    })
    
        productService.supplier().then(function(response){
        	$scope.fireworks = JSON.parse(response.data);
        	 $scope.$root.fireworks = $scope.fireworks;
        });
      
       
       
		$scope.grantTotal  = 0;
		$scope.changeView = function(index, event) {
                   $scope.tab=index;
                }
			
		
		
		$scope.calculAmt = function(index, firework){
			var products = firework.products;
			products[index].tot =  products[index].amt * products[index].quan;
			firework.tot = 0;
			for(var len in products){
					firework.tot = firework.tot + products[len].tot;
			}
			$scope.grantTotal = firework.tot;
			
		}		
    });

    sampleApp.controller('confirmController', function($scope,orderService,HeaderService) {
    	
    	
    	HeaderService.header().then(function(response){
    		 $scope.headers = response.data;
    	    })
		$scope.fireworks =  $scope.$root.fireworks;
    	var user = {};
		$scope.user = user;
		
		
		$scope.confirmOrder = function(){
			console.log($scope.fireworks);
			console.log($scope.user);
			var data ={
					user : $scope.user,
					suppliers :  $scope.fireworks
			};
			
			orderService.order(data).then(function(response){
				$scope.msg = response.data;
				
				alert($scope.msg.msg);
			});
			
			
			/*$http.post('order.do',data).then(function(response){
				$scope.msg = response.data
		    	console.log( $scope.msg);
		    	
		    });*/
		}
    });

 

        
  
