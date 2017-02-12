app.controller('UserData', function($scope, $http) {

	$scope.user = {
		age: '18',
		activity: 'Relaxation'
	};

    $scope.isRelax = function(){
        $scope.user.activity = "Relaxation";
        $scope.sendJSON();
    }
    $scope.isExercise = function(){
        $scope.user.activity = "Exercise";
        $scope.sendJSON();
    }

    $scope.sendJSON = function(){
    		$scope.user.push({ 'User age':$scope.user.age, 'activity': $scope.user.activity });
    		// Writing it to the server
    		//
    		var dataObj = {
    				age : $scope.user.age,
    				activity : $scope.user.activity,
    		};
            var res = $http.post('/user_data_json', dataObj);
            		res.success(function(data, status, headers, config) {
            			$scope.message = data;
            		});
            res.error(function(data, status, headers, config) {
            			alert( "failure message: " + JSON.stringify({data: data}));
            		});
            		// Making the fields empty
            		//
            		$scope.age='';
            		$scope.activity='';
    };
});