(function(){
	var app = angular.module('universidadApp',[]);
	app.controller('listadoCtrl', ['$scope', function ($scope) {
		$scope.listadoProductos = {
			productos:[{
				nombre:"Tablet",
				precio: 250.00,
				stock:50
			},
			{
				nombre:"Laptop",
				precio: 2500.00,
				stock:10
			},
			{
				nombre:"Disco Externo 1TB",
				precio: 400.00,
				stock:20
			}]
		}
	}]);

})();