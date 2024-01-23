'use strict';

app.controller('FriendController', function($scope, $http) {

	$scope.init = function(userId)
	{
		$scope.userId = userId;

	    $http.get('/api/profile/friends/' + $scope.userId).
	    success(function(data, status, headers, config) {
	      $scope.friends = data;
	    }).
	    error(function(data, status, headers, config) {
	      console.log(status);
	    });		
	}    

});